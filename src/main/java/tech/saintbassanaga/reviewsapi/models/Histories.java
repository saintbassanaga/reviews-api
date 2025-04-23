package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Histories")
public class Histories extends AbstractEntity {
    private String feeling;
    private String rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewsId")
    private Reviews reviews;

}