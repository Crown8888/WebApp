package pl.webapp.wsjava.repository;

import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findByPostId(Long postId);
}
