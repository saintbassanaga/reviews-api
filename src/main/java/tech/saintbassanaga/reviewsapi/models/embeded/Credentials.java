package tech.saintbassanaga.reviewsapi.models.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@Embeddable
@UniqueElements
public class Credentials {

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    @Column(nullable = false,unique = true)
    private String email;
}