package pl.webapp.wsjava.dto;

import java.sql.Timestamp;

public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
    private Timestamp created_at;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, String description, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
