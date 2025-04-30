package tech.saintbassanaga.reviewsapi.services.impls;

import tech.saintbassanaga.reviewsapi.models.Reviews;
import tech.saintbassanaga.reviewsapi.services.ReviewsService;

import java.util.List;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Thu - 4/24/25
 */
public class ReviewsServiceImpls implements ReviewsService {
    @Override
    public String addReview(Reviews review) {
        return "";
    }

    @Override
    public void deleteReviewByUuid(String reviewId) {

    }

    @Override
    public String updateReview(Reviews review) {
        return "";
    }

    @Override
    public Reviews findReviewByUuid(String reviewId) {
        return null;
    }

    @Override
    public List<Reviews> findAllReviews() {
        return List.of();
    }

    @Override
    public List<Reviews> findReviewsByProduct(String productId) {
        return List.of();
    }
}
