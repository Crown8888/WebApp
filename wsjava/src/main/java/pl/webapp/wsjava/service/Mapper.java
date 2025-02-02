package pl.webapp.wsjava.service;

import org.springframework.stereotype.Component;
import pl.webapp.wsjava.dto.*;
import pl.webapp.wsjava.model.Category;
import pl.webapp.wsjava.model.Comment;
import pl.webapp.wsjava.model.Like;
import pl.webapp.wsjava.model.Post;

@Component
public class Mapper {
    public UserDTO toDTO(pl.webapp.wsjava.model.User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    public CommentDTO toDTO(Comment comment) {
        return new CommentDTO(comment.getId(), comment.getContent(), comment.getUser(), comment.getPost(), comment.getCreated_at());
    }

    public PostDTO toDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUser(),
                post.getCreated_at()
        );
    }

    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName(), category.getDescription(), category.getCreated_at());
    }

    public LikeDTO toDTO(Like like) {
        return new LikeDTO(like.getId(), like.getPost(), like.getUser());
    }

    public pl.webapp.wsjava.model.User toEntity(UserDTO userDTO) {
        return new pl.webapp.wsjava.model.User(userDTO.getId(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
    }

    public Comment toEntity(CommentDTO commentDTO) {
        return new Comment(commentDTO.getId(), commentDTO.getContent(), commentDTO.getUser(), commentDTO.getPost(), commentDTO.getCreated_at());
    }

    public Post toEntity(PostDTO postDTO) {
        return new Post(postDTO.getId(), postDTO.getTitle(), postDTO.getContent(), postDTO.getUser(), postDTO.getCreated_at());
    }

    public Category toEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getId(), categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getCreated_at());
    }
}