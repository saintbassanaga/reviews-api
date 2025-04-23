package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.saintbassanaga.reviewsapi.models.embeded.Credentials;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "Users",
        uniqueConstraints = {
                @UniqueConstraint(name = "username_unique", columnNames = "username")
        }
)
public class Users extends AbstractEntity {
    @Embedded
    private Credentials credentials;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "trustLevelId", nullable = false)
    private TrustLevel trustLevel;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserRoles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Role> roles ;

/*    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return credentials.getUsername();
    }*/
}