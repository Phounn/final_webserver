package web.group.two.comment.service;

import web.group.two.comment.dto.AddCommentDTO;
import web.group.two.comment.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAllComment();

    CommentDTO addComment(AddCommentDTO addCommentDTO);

}
