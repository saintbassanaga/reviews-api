package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.saintbassanaga.reviewsapi.models.embeded.RoleGroup;

import java.util.HashSet;
import java.util.Set;

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
    private Set<User> users = new HashSet<>();
}