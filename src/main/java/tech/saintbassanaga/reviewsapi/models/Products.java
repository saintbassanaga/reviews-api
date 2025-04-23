package tech.saintbassanaga.reviewsapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Products extends AbstractEntity {
    private String name;
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoriesId", nullable = false)
    private Categories categories;

}