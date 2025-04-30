package tech.saintbassanaga.reviewsapi.services.impls;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tech.saintbassanaga.reviewsapi.models.Products;
import tech.saintbassanaga.reviewsapi.repositories.ProductsRepository;
import tech.saintbassanaga.reviewsapi.services.ProductService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Thu - 4/24/25
 */

@Service
@AllArgsConstructor
public class ProductServiceImpls implements ProductService {

    private final ProductsRepository productsRepository;

    @Override
    public String addProduct(Products product) {
        return "product added Successfully";
    }

    @Override
    @Async
     public CompletableFuture<List<UUID>> findProductByName(String productName) {
        return (CompletableFuture.completedFuture(List.of()));
    }

    @Override
    @RolesAllowed(value = "admin")
    public void deleteProductByUuid(UUID productId) {
        productsRepository.deleteById(productId);
    }

}
