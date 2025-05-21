/**
 * This package contains embedded classes used within the domain model entities.
 * 
 * <p>Embedded classes in this package are designed to be included as components within
 * other entity classes, rather than being mapped to their own database tables. They
 * represent reusable groups of attributes that can be embedded in multiple entity types.</p>
 * 
 * <p>Key embedded classes in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.embeded.Credentials}: Encapsulates
 *       user authentication information including username, password, and email</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.models.embeded.RoleGroup}: An enumeration
 *       that categorizes roles into predefined groups such as ADMIN, OPERATION, etc.</li>
 * </ul>
 * 
 * <p>These embedded classes help maintain a clean separation of concerns and promote
 * code reuse across the domain model.</p>
 * 
 * @see tech.saintbassanaga.reviewsapi.models
 */
package tech.saintbassanaga.reviewsapi.models.embeded;