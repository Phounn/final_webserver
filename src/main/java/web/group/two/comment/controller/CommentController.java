package web.group.two.comment.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.group.two.comment.dto.AddCommentDTO;
import web.group.two.comment.dto.CommentDTO;
import web.group.two.comment.entity.Comment;
import web.group.two.comment.service.CommentService;
import web.group.two.common.response.dto.ApiResponseDTO;
import web.group.two.user.entity.LoginUser;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentService commentService;

    @Operation(
            summary = "See All Comment",
            description = "Query saved Comment in the form of a list.",
            security = @SecurityRequirement(name = "basicScheme")
    )

    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )
    @Secured("ROLE_ADMIN")
    @GetMapping
    public Flux<ApiResponseDTO<Object>> getAllComment() {
        log.info("call GetAllComment");
        List<CommentDTO> commentList= commentService.findAllComment();
        return Flux.fromIterable(commentList)
                .map(user ->
                        ApiResponseDTO.builder()
                                .code(200)
                                .message("Comment List found")
                                .body(user)
                                .build());
    }

    @Operation(
            summary = "Add Comment",
            description = "Add Comment."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Success",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Comment.class))
            }
    )
    @PostMapping
    public Mono<ApiResponseDTO<Object>> addComment(@RequestBody final AddCommentDTO addComment, @AuthenticationPrincipal LoginUser loginUser) {
        log.info("Username >>> {} / Comment >>> {}, ", loginUser.getUser().getName(), addComment.getComments_comment());
        String userName = loginUser.getUser().getName();
        AddCommentDTO addCommentDTO = new AddCommentDTO(userName, addComment.getComments_comment());
        CommentDTO commentDTO = commentService.addComment(addCommentDTO);
        return Mono.justOrEmpty(
                ApiResponseDTO.builder()
                        .code(200)
                        .message("Add Comment")
                        .body(commentDTO)
                        .build()

        );
    }
}
