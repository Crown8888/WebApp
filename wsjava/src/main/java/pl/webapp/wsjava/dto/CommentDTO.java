package pl.webapp.wsjava.dto;

import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.model.User;

import java.sql.Timestamp;

public class CommentDTO {

    private Long id;
    private String content;
    private User user;
    private Post post;
    private Timestamp created_at;

    public CommentDTO() {
    }

    public CommentDTO(Long id, String content, User user, Post post, Timestamp created_at) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.post = post;
        this.created_at = created_at;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
