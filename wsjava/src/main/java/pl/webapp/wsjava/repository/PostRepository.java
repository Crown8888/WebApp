package pl.webapp.wsjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByUserId(Long userId);
    // find newposts by created date only last 5 posts
    @Query("SELECT p FROM Post p ORDER BY p.created_at DESC")
    List<Post> findNewPosts();
}
