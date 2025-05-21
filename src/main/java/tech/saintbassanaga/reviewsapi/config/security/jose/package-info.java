/**
 * This package contains classes related to JSON Object Signing and Encryption (JOSE) for JWT security.
 * 
 * <p>JOSE is a framework intended to provide a method to securely transfer claims between parties.
 * The classes in this package specifically deal with JSON Web Key Sets (JWKS), which are used for
 * signing and verifying JSON Web Tokens (JWTs) in the application's authentication system.</p>
 * 
 * <p>Key components in this package include:</p>
 * <ul>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.jose.Jwks}: A utility class for
 *       generating and managing JSON Web Key Sets, providing methods to create RSA key pairs
 *       for JWT signing and verification.</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.jose.PersistentJwks}: Handles the
 *       persistence of JSON Web Key Sets, allowing the application to reuse the same keys
 *       across restarts for consistent JWT validation.</li>
 *   <li>{@link tech.saintbassanaga.reviewsapi.config.security.jose.KeyGeneratorUtils}: Provides
 *       utility methods for generating cryptographic keys used in the JWT signing process.</li>
 * </ul>
 * 
 * <p>These components are essential for the secure implementation of JWT-based authentication,
 * ensuring that tokens are properly signed, verified, and managed throughout their lifecycle.</p>
 * 
 * @see tech.saintbassanaga.reviewsapi.config.security.JwtProvider
 */
package tech.saintbassanaga.reviewsapi.config.security.jose;