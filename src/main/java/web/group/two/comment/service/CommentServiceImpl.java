package web.group.two.comment.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import web.group.two.comment.dto.AddCommentDTO;
import web.group.two.comment.dto.CommentDTO;
import web.group.two.comment.entity.Comment;
import web.group.two.comment.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    @Override
    public List<CommentDTO> findAllComment() {
        return commentRepository.findAll()
                .stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO addComment(AddCommentDTO addCommentDTO) {
        Comment comment = Comment.addCommentWithUsername(
                addCommentDTO.getUsername_comment(),
                addCommentDTO.getComments_comment(),
                ("Harry Potter")
        );
        Comment savedUser = commentRepository.save(comment);
        return new CommentDTO(savedUser);
    }
}
