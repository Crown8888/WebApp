package pl.webapp.wsjava.repository;

import org.springframework.data.repository.CrudRepository;
import pl.webapp.wsjava.model.Like;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Long> {
    boolean existsByPostIdAndUserId(Long postId, Long userId);
    Optional<Like> findByPostIdAndUserId(Long postId, Long userId);
    int countByPostId(Long postId);
}