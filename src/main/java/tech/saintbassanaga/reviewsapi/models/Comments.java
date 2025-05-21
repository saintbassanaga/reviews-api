package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a comment entity in the system. A comment is associated with a specific
 * user and review and serves as a textual contribution to a discussion or feedback
 * mechanism.
 *
 * This entity is mapped to the "Comments" table in the database and extends
 * {@link AbstractEntity}, inheriting common fields such as `id`, `timestamps`,
 * and audit information.
 *
 * Key attributes:
 * - `content`: The textual content of the comment.
 * - A mandatory many-to-one relationship with {@link Users} to associate the comment
 *   with the user who authored it.
 * - A mandatory many-to-one relationship with {@link Reviews} to associate the comment
 *   with the review it is related to.
 */
@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comments extends AbstractEntity {
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reviewsId", nullable = false)
    private Reviews reviews;

}