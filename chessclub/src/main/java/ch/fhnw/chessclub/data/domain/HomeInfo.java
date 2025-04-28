package ch.fhnw.chessclub.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HomeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    private String title;
    private String description;
    private String version;

    @ManyToOne
    @JoinColumn(name = "related_entity_id") // Foreign Key
    private RelatedEntity relatedEntity; // Replace 'RelatedEntity' with the actual related entity

    public HomeInfo() {}

    public HomeInfo(String title, String description, String version, RelatedEntity relatedEntity) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.relatedEntity = relatedEntity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public RelatedEntity getRelatedEntity() {
        return relatedEntity;
    }

    public void setRelatedEntity(RelatedEntity relatedEntity) {
        this.relatedEntity = relatedEntity;
    }
}
