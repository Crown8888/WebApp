package pl.webapp.wsjava.dto;

import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.model.User;

import java.sql.Timestamp;

public class CommentDTO {

    private Long id;
    private String content;
    private User user;
    private Post post;
    private Timestamp createdAt;

    public CommentDTO() {
    }

    public CommentDTO(Long id, String content, User user, Post post, Timestamp createdAt) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.post = post;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
