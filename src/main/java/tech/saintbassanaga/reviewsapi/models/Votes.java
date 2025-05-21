package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a vote within the system, associated with a user and a review.
 * This entity allows tracking the type of vote provided by a user for a specific review.
 *
 * A vote is required to be linked to an existing user and an existing review.
 * Cascade operations are applied to the user and review entities, ensuring their persistence
 * and removal are appropriately synchronized with the vote entity.
 */
@Getter
@Setter
@Entity
@Table(name = "Votes")
public class Votes extends AbstractEntity {
    private String type;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reviewsId", nullable = false)
    private Reviews reviews;


}