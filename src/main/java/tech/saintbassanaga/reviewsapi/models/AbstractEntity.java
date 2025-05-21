package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Abstract base class for all entity models in the system.
 * 
 * This class provides common fields and functionality that are shared across all entities,
 * including unique identifier, audit information (creation and modification timestamps and users),
 * and version control for optimistic locking.
 * 
 * All entity classes in the application should extend this class to inherit these common attributes
 * and behaviors, ensuring consistency across the domain model.
 */
@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    /**
     * Unique identifier for the entity.
     * Automatically generated as a UUID when a new entity is persisted.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Timestamp when the entity was created.
     * Automatically set by Spring Data's auditing capabilities.
     */
    @CreatedDate
    private Timestamp createdDate;

    /**
     * Timestamp when the entity was last modified.
     * Automatically updated by Spring Data's auditing capabilities whenever the entity is changed.
     */
    @LastModifiedDate
    private Timestamp lastModifiedDate;

    /**
     * Identifier of the user who created the entity.
     * Automatically set by Spring Data's auditing capabilities.
     */
    @CreatedBy
    private String createdBy;

    /**
     * Identifier of the user who last modified the entity.
     * Automatically updated by Spring Data's auditing capabilities whenever the entity is changed.
     */
    @LastModifiedBy
    private String lastModifiedBy;

    /**
     * Version number used for optimistic locking.
     * Automatically incremented by JPA whenever the entity is updated,
     * helping to prevent concurrent modification conflicts.
     */
    @Version
    private Long version;

}
