// 4. LikeService
package pl.webapp.wsjava.service;

import org.springframework.stereotype.Service;
import pl.webapp.wsjava.model.Like;
import pl.webapp.wsjava.repository.LikeRepository;
import pl.webapp.wsjava.repository.PostRepository;
import pl.webapp.wsjava.repository.UserRepository;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public LikeService(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Like toggleLike(Long postId, Long userId) {
        if (likeRepository.existsByPostIdAndUserId(postId, userId)) {
            likeRepository.findByPostIdAndUserId(postId, userId)
                    .ifPresent(likeRepository::delete);
            return null;
        }

        var post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return likeRepository.save(new Like(post, user));
    }

    public int getLikeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}
