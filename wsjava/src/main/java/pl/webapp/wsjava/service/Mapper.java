package pl.webapp.wsjava.service;

import org.springframework.stereotype.Component;
import pl.webapp.wsjava.dto.CommentDTO;
import pl.webapp.wsjava.dto.PostDTO;
import pl.webapp.wsjava.dto.UserDTO;
import pl.webapp.wsjava.model.Comment;
import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.model.User;

@Component
public class Mapper {
    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    public CommentDTO toDTO(Comment comment) {
        return new CommentDTO(comment.getId(), comment.getContent(), comment.getUser(), comment.getPost(), comment.getCreatedAt());
    }

    public PostDTO toDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getUser().getId()
        );
    }

    public User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
    }

    public Comment toEntity(CommentDTO commentDTO) {
        return new Comment(commentDTO.getId(), commentDTO.getContent(), commentDTO.getUser(), commentDTO.getPost(), commentDTO.getCreatedAt());
    }

    public Post toEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        return post;
    }
}