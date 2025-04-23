package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

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