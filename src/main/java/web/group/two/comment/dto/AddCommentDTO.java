package web.group.two.comment.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "Comment Add DTO")
@Data

public class AddCommentDTO {
    @Schema(name = "username_comment", description = "username_comment", example = "Iron Man")
    private String username_comment;

    @Schema(name = "comments_comment", description = "comments_comment", example = "This is Good")
    private String comments_comment;

    public AddCommentDTO(String username_comment, String comments_comment){
        this.username_comment = username_comment;
        this.comments_comment = comments_comment;
    }
}
