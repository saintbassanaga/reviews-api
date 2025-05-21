package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents moderation records for reviews in the system.
 *
 * This entity is used to track the moderation process associated with user reviews. Each moderation
 * entry links a review to the user performing the moderation action and also includes a status to
 * specify the current state of moderation.
 *
 * This class is mapped to the "Moderations" table in the database and extends {@link AbstractEntity},
 * inheriting common attributes like `id`, timestamps, and audit data.
 *
 * Key Attributes:
 * - `reviews`: Represents the review being moderated. Establishes a mandatory many-to-one relationship
 *   with the {@link Reviews} entity.
 * - `user`: Denotes the user performing the moderation action. Establishes a mandatory many-to-one
 *   relationship with the {@link Users} entity.
 * - `status`: Stores the current moderation status, represented by a string.
 */
@Getter
@Setter
@Entity
@Table(name = "Moderations")
public class Moderations extends AbstractEntity {
    /**
     * The review being moderated.
     * This establishes a mandatory many-to-one relationship with the Reviews entity.
     * Changes to the associated review will cascade to this moderation record.
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reviewsId", nullable = false)
    private Reviews reviews;

    /**
     * The user performing the moderation action.
     * This establishes a mandatory many-to-one relationship with the Users entity.
     * Changes to the associated user will cascade to this moderation record.
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    /**
     * The current status of the moderation process.
     * This field indicates the state of the review in the moderation workflow,
     * such as "pending", "approved", "rejected", etc.
     */
    private String status;

}
