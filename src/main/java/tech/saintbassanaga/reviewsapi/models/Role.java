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
    private String designations;
    private String description;

    @Enumerated(EnumType.STRING)
    private RoleGroup roleGroup;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}