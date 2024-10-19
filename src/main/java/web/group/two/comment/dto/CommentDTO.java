package web.group.two.comment.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import web.group.two.comment.entity.Comment;

@Schema(description = "Comment DTO")
@Getter
@AllArgsConstructor
public class CommentDTO {
    @Schema(name = "id", description = "comment id", example = "1")
    private Long id;

    @Schema(name = "username_comment", description = "username_comment", example = "Iron Man")
    private String username_comment;

    @Schema(name = "comments_comment", description = "comments_comment", example = "This is Good")
    private String comments_comment;

    @Schema(name = "movies_comment", description = "movies_comment", example = "Harry Potter")
    private String movies_comment;

    public CommentDTO(final Comment comment) {
        this.id = comment.getId();
        this.username_comment = comment.getUsername_comment();
        this.comments_comment = comment.getComments_comment();
        this.movies_comment = comment.getMovies_comment();
    }
}
