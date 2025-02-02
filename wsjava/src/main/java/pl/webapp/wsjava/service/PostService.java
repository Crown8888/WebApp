package pl.webapp.wsjava.service;

import org.springframework.stereotype.Service;
import pl.webapp.wsjava.dto.PostDTO;
import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CurrentUserService currentUserService;


    public PostService(PostRepository postRepository, CurrentUserService currentUserService) {
        this.postRepository = postRepository;
        this.currentUserService = currentUserService;
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post createPost(Post post) {
        post.setUser(currentUserService.getCurrentUser());
        post.setCreated_at(new java.sql.Timestamp(System.currentTimeMillis()));
        return postRepository.save(post);
    }
    // findNewPosts
    public List<Post> findNewPosts() {
        return postRepository.findNewPosts();
    }
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
