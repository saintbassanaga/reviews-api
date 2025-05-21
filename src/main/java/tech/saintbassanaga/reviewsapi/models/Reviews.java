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
    private String feeling;
    private Integer rating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productsId", nullable = false)
    private Products products;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

}