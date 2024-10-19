package web.group.two.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.group.two.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
