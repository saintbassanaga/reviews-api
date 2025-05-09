package tech.saintbassanaga.reviewsapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Fri - 5/9/25
 */

@Component
public class RsaApplayer {

    @Value("${rsa.private-key}")
    private String privateKeyBase64;

    @Value("${rsa.public-key}")
    private String publicKeyBase64;


    @Bean
    public RSAPrivateKey privateKey() throws Exception {
        // Decode the Base64 string and convert it into a PrivateKey object
        byte[] decodedKey = Base64.getDecoder().decode(privateKeyBase64);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) keyFactory.generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(decodedKey));
    }

    @Bean
    public RSAPublicKey publicKey() throws Exception {
        // Decode the Base64 string and convert it into a PublicKey object
        byte[] decodedKey = Base64.getDecoder().decode(publicKeyBase64);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(new java.security.spec.X509EncodedKeySpec(decodedKey));
    }
}
