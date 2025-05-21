package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the history of interactions or feedback associated with reviews.
 *
 * This entity is mapped to the "Histories" table in the database and extends
 * {@link AbstractEntity}, inheriting common fields such as `id`, timestamps,
 * and audit information. The `Histories` entity records additional details
 * such as feelings and ratings related to a specific review.
 *
 * Key features:
 * - Includes a `feeling` field to capture textual feedback or emotion related
 *   to the review.
 * - Contains a `rating` field to store numerical feedback associated with the review.
 * - Maintains a many-to-one relationship with the {@link Reviews} entity to
 *   associate the history entry with a specific review.
 * - Applies cascade operations on the `Reviews` relationship, ensuring
 *   changes or deletions in a `Review` propagate to related history records.
 */
@Getter
@Setter
@Entity
@Table(name = "Histories")
public class Histories extends AbstractEntity {
    /**
     * Textual representation of the user's feeling or feedback about the review.
     * This can include emotional responses, comments, or other qualitative feedback.
     */
    private String feeling;

    /**
     * Numerical or categorical rating associated with the review.
     * This represents the quantitative assessment of the review's quality or relevance.
     */
    private String rating;

    /**
     * The review that this history entry is associated with.
     * This establishes a many-to-one relationship with the Reviews entity,
     * allowing multiple history entries to be associated with a single review.
     * Changes to the associated review will cascade to this history entry.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewsId")
    private Reviews reviews;

}
