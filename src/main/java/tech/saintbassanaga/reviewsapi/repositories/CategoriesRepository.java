package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Categories;

import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
}