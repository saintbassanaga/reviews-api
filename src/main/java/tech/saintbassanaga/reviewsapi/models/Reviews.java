package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Represents a review provided by a user for a specific product.
 *
 * This entity is mapped to the "Reviews" table in the database and extends
 * {@link AbstractEntity}, inheriting common fields such as `id`, `timestamps`,
 * and audit information. Each review contains a rating, a feeling or comment
 * regarding the product, and references to the specific product and user
 * associated with the review.
 *
 * Key attributes:
 * - `feeling`: A textual representation of the user's feeling or comment
 *   regarding the product.
 * - `rating`: A numerical representation of the user's evaluation of the
 *   product.
 * - A mandatory many-to-one relationship with {@link Products} to associate
 *   the review with a specific product.
 * - A mandatory many-to-one relationship with {@link Users} to associate
 *   the review with a specific user.
 */
@Getter
@Setter
@Entity
@Table(name = "Reviews")
public class Reviews  extends  AbstractEntity{
    /**
     * The textual representation of the user's feeling or comment about the product.
     * This field contains the user's qualitative feedback, opinions, or experiences
     * with the product being reviewed.
     */
    private String feeling;

    /**
     * The numerical rating given by the user for the product.
     * This typically represents a score (e.g., on a scale of 1-5 or 1-10)
     * indicating the user's overall satisfaction with the product.
     */
    private Integer rating;

    /**
     * The product being reviewed.
     * This establishes a mandatory many-to-one relationship with the Products entity,
     * linking this review to a specific product in the system.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "productsId", nullable = false)
    private Products products;

    /**
     * The user who created the review.
     * This establishes a mandatory many-to-one relationship with the Users entity,
     * linking this review to the user who authored it.
     * Changes to the associated user will cascade to this review.
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

}
