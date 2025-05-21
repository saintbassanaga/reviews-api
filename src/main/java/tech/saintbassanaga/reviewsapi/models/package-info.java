/**
 * This package contains the domain model entities for the Reviews API application.
 * 
 * <p>The model classes in this package represent the core business entities of the application
 * and are mapped to database tables using JPA annotations. Most entity classes extend the
 * {@link tech.saintbassanaga.reviewsapi.models.AbstractEntity} base class, which provides
 * common fields such as ID, timestamps, and audit information.</p>
 * 
 * <p>Key entities in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.Users}: Represents users of the system</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.Products}: Represents products that can be reviewed</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.Reviews}: Represents user reviews of products</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.Comments}: Represents comments on reviews</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.Categories}: Represents product categories</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.Role}: Represents user roles for authorization</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.TrustLevel}: Represents user trust levels</li>
 * </ul>
 * 
 * <p>The package also includes supporting entities for tracking votes, reports, moderation actions,
 * notifications, and review history.</p>
 * 
 * @see tech.saintbassanaga.reviewsapi.models.embeded
 */
package tech.saintbassanaga.reviewsapi.models;