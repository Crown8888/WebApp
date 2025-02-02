package pl.webapp.wsjava.dto;

import pl.webapp.wsjava.model.User;

import java.sql.Timestamp;

public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Timestamp created_at;
    private User user;
    

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String content, User user, Timestamp created_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}