package pl.webapp.wsjava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.Like;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Long> {
    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.id = :postId AND l.user.id = :userId")
    boolean existsByPostIdAndUserId(Long postId, Long userId);
    Optional<Like> findByPostIdAndUserId(Long postId, Long userId);
    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.id = :postId")
    int countByPostId(Long postId);
}