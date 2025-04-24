package tech.saintbassanaga.reviewsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.saintbassanaga.reviewsapi.models.Products;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
}