package web.group.two.comment.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments_user")

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username_comment")
    private String username_comment;

    @Column(name = "comments_comment")
    private String comments_comment;

    @Column(name = "movies_comment")
    private String movies_comment;

    public Comment(String username_comment, String comments_comment, String movies_comment) {
        this.username_comment = username_comment;
        this.comments_comment = comments_comment;
        this.movies_comment = movies_comment;
    }
    public static Comment addCommentWithUsername(final String username_comment, final String comments_comment, final String movies_comment){
        return new Comment(username_comment, comments_comment, movies_comment);
    }
}
