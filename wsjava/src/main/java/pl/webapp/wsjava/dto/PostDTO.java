package pl.webapp.wsjava.dto;
import java.time.LocalDateTime;
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Long categoryId;
    private Long userId;
    private String authorUsername;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int likesCount;
    private int commentsCount;
    private boolean isLikedByCurrentUser;
    public PostDTO() {
    }

    public PostDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Optional constructor with categoryId
    public PostDTO(Long id, String title, String content, Long categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }
    public void setId(Long id) {
    }

    public void setTitle(String title) {
    }

    public void setContent(String content) {
    }

    public void setAuthorUsername(String username) {
    }

    public void setCreatedAt(LocalDateTime createdAt) {
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
    }

    public void setLikesCount(int size) {
    }

    public void setCommentsCount(int size) {
    }

    public void setLikedByCurrentUser(boolean b) {
    }
    public long getUserId() {
        return userId;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

    // getters, setters, constructors
}