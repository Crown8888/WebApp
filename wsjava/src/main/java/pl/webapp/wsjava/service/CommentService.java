package pl.webapp.wsjava.service;

import org.springframework.stereotype.Service;
import pl.webapp.wsjava.model.Comment;
import pl.webapp.wsjava.repository.CommentRepository;
import pl.webapp.wsjava.repository.PostRepository;
import pl.webapp.wsjava.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CurrentUserService currentUserService;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository,
                          UserRepository userRepository, CurrentUserService currentUserService) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.currentUserService = currentUserService;
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Comment createComment(Comment comment) {
        // Set creation timestamp
        comment.setCreated_at(new Timestamp(System.currentTimeMillis()));
        comment.setUser(currentUserService.getCurrentUser());

        // Verify post and user exist
        postRepository.findById(comment.getPost().getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        userRepository.findById(comment.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}