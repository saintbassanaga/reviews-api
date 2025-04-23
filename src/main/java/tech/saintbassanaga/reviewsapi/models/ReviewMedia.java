package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ReviewMedia")
public class ReviewMedia extends AbstractEntity {
    private String mediaType;
    private String mediaUrl;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "reviewId", nullable = false)
    private Reviews reviews;

}