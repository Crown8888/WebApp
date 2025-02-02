package pl.webapp.wsjava.service;

import org.springframework.stereotype.Service;
import pl.webapp.wsjava.dto.PostDTO;
import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post createPost(Post post, Long userId) {
        post.setUser(userService.findById(userId));
        return postRepository.save(post);
    }
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
