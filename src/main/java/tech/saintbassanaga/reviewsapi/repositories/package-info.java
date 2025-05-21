/**
 * This package contains repository interfaces for data access and persistence operations.
 * 
 * <p>The repository interfaces in this package extend Spring Data JPA's {@code JpaRepository}
 * interface, providing standard CRUD operations and additional query methods for the domain
 * entities. Each repository is typed with its corresponding entity class and UUID as the
 * identifier type.</p>
 * 
 * <p>These repositories serve as the data access layer of the application, abstracting the
 * underlying database operations and providing a clean API for the service layer to interact
 * with the persistence store.</p>
 * 
 * <p>Key repositories in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.repositories.UsersRepository}: Data access for user entities</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.repositories.ProductsRepository}: Data access for product entities</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.repositories.ReviewsRepository}: Data access for review entities</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.repositories.CategoriesRepository}: Data access for category entities</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.repositories.CommentsRepository}: Data access for comment entities</li>
 * </ul>
 * 
 * <p>Additional repositories are provided for all other domain entities in the system.</p>
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see tech.saintbassanaga.reviewsapi.models
 */
package tech.saintbassanaga.reviewsapi.repositories;