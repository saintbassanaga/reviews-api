package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.saintbassanaga.reviewsapi.models.embeded.RoleGroup;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a role within the system. Roles define the permissions or designations
 * assigned to users and group them under specific role groups. It is used to manage
 * user access control in the application.
 *
 * This entity is mapped to the "Role" table in the database.
 *
 * Key features:
 * - Contains a string field for designations, representing the name or title of the role.
 * - Includes a description field for providing additional details about the role.
 * - Maps to an enumerated type {@link RoleGroup} which categorizes roles into predefined groups.
 * - Maintains a many-to-many relationship with the {@link Users} entity to associate multiple users
 *   with multiple roles.
 *
 * This class extends {@link AbstractEntity}, inheriting common entity attributes such as
 * ID, timestamps, and audit information.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Role")
public class Role extends AbstractEntity {
    /**
     * The name or title of the role.
     * This field represents the designation assigned to users, such as "Admin", "Moderator", "User", etc.
     */
    private String designations;

    /**
     * Additional details about the role.
     * This field provides a more detailed explanation of the role's purpose, responsibilities, or permissions.
     */
    private String description;

    /**
     * The category or group to which this role belongs.
     * This field maps to an enumerated type that categorizes roles into predefined groups,
     * helping to organize and manage roles within the system.
     */
    @Enumerated(EnumType.STRING)
    private RoleGroup roleGroup;

    /**
     * The set of users assigned to this role.
     * This establishes a many-to-many relationship with the Users entity,
     * allowing multiple users to have multiple roles.
     * The relationship is mapped by the "roles" field in the Users entity.
     */
    @ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}
