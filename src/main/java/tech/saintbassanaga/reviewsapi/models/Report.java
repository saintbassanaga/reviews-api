package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a report entity within the system. A report is used to highlight
 * issues, concerns, or feedback associated with a specific review by a user.
 *
 * This entity is mapped to the "Report" table in the database and extends
 * {@link AbstractEntity}, inheriting common attributes such as `id`,
 * timestamps, and audit information.
 *
 * Key attributes:
 * - `reason`: A textual description of the reason for the report. This field
 *   explains why the report was submitted.
 * - A mandatory many-to-one relationship with {@link Users} to indicate the
 *   user who submitted the report.
 * - A mandatory many-to-one relationship with {@link Reviews} to associate
 *   the report with a specific review.
 *
 * Cascade operations are applied to maintain the integrity and dependencies
 * of the associated {@link Users} and {@link Reviews} entities.
 */
@Getter
@Setter
@Entity
@Table(name = "Report")
public class Report extends AbstractEntity {
    /**
     * The reason or justification for submitting the report.
     * This field contains a textual description explaining why the user is reporting the review,
     * such as inappropriate content, spam, or factual inaccuracies.
     */
    private String reason;

    /**
     * The user who submitted the report.
     * This establishes a mandatory many-to-one relationship with the Users entity.
     * Changes to the associated user will cascade to this report.
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    /**
     * The review that is being reported.
     * This establishes a mandatory many-to-one relationship with the Reviews entity.
     * Changes to the associated review will cascade to this report.
     */
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reviewsId", nullable = false)
    private Reviews reviews;

}
