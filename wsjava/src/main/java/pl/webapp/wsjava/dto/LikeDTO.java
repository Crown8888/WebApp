package pl.webapp.wsjava.dto;

import pl.webapp.wsjava.model.Post;
import pl.webapp.wsjava.model.User;

public class LikeDTO {
    private Long id;
    private Post post;
    private User user;

    public LikeDTO() {}

    public LikeDTO(Long id, Post post, User user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}