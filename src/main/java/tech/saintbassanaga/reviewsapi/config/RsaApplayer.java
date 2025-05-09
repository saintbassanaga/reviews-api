package tech.saintbassanaga.reviewsapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Fri - 5/9/25
 */

@Configuration
public class RsaApplayer {

    @Value("${rsa.private-key}")
    private String privateKeyBase64;

    @Value("${rsa.public-key}")
    private String publicKeyBase64;

    @Bean
    public RSAPrivateKey privateKey() throws Exception {
        byte[] decoded = Base64.getDecoder().decode(privateKeyBase64);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
        return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(keySpec);
    }

    @Bean
    public RSAPublicKey publicKey() throws Exception {
        byte[] decoded = Base64.getDecoder().decode(publicKeyBase64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }
}
