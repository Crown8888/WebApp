package pl.webapp.wsjava.repository;

import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByUserId(Long userId);
}
