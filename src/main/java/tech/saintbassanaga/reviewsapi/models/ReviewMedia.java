package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ReviewMedia")
public class ReviewMedia extends AbstractEntity {
    private String mediaType;
    private String mediaUrl;

}