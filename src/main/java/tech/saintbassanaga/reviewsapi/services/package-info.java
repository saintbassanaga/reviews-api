/**
 * This package contains service interfaces that define the business operations of the application.
 * 
 * <p>The service interfaces in this package act as the business layer of the application,
 * defining the operations that can be performed on the domain entities. They encapsulate
 * the business logic and rules, providing a clean API for the controllers to interact with.</p>
 * 
 * <p>These interfaces follow the Interface Segregation Principle, with each interface
 * focusing on a specific area of functionality. The actual implementations of these
 * interfaces are located in the {@link tech.saintbassanaga.reviewsapi.services.impls} package.</p>
 * 
 * <p>Key service interfaces in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.services.ProductService}: Defines operations for managing products</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.services.ReviewsService}: Defines operations for managing reviews</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.services.AdminService}: Defines administrative operations</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.services.AuthService}: Defines authentication and user management operations</li>
 * </ul>
 * 
 * @see tech.saintbassanaga.reviewsapi.services.impls
 * @see tech.saintbassanaga.reviewsapi.repositories
 */
package tech.saintbassanaga.reviewsapi.services;