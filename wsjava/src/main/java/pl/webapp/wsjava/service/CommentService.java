package pl.webapp.wsjava.service;

import org.springframework.stereotype.Service;
import pl.webapp.wsjava.model.Comment;
import pl.webapp.wsjava.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
