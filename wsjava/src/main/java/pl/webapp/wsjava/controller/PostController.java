package pl.webapp.wsjava.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.webapp.wsjava.dto.PostDTO;
import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.service.PostService;
import pl.webapp.wsjava.service.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final Mapper modelMapper;

    public PostController(PostService postService, Mapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.findAll().stream()
                .map(modelMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        Post post = postService.findById(id);
        return post != null
                ? ResponseEntity.ok(modelMapper.toDTO(post))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        Post post = postService.createPost(modelMapper.toEntity(postDTO), postDTO.getUserId());
        return new ResponseEntity<>(modelMapper.toDTO(post), HttpStatus.CREATED);
    }

    // GetNewPosts
    @GetMapping("/new")
    public ResponseEntity<List<PostDTO>> getNewPosts() {
        return ResponseEntity.ok(postService.findNewPosts().stream()
                .map(modelMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}