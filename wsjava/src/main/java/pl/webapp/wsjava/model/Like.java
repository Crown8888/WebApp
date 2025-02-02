package pl.webapp.wsjava.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Timestamp created_at;

    public Like() {}

    public Like(Post post, User user) {
        this.post = post;
        this.user = user;
        this.created_at = new Timestamp(System.currentTimeMillis());
    }

    // Getters and setters
    public Long getId() { return id; }
    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Timestamp getCreated_at() { return created_at; }
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }
}