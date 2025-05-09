package tech.saintbassanaga.reviewsapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project reviews-api at Fri - 5/9/25
 */

@Component
public class RsaApplayer {

    @Value("${RSA_PRIVATE_KEY}")
    private String privateKeyBase64;

    @Value("${RSA_PUBLIC_KEY}")
    private String publicKeyBase64;

    @Value("${RSA_PRIVATE_KEY_PATH:/tmp/private.pem}")
    private String privateKeyPath;

    @Value("${RSA_PUBLIC_KEY_PATH:/tmp/public.pem}")
    private String publicKeyPath;

    @PostConstruct
    public void init() throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
        Files.write(Paths.get(privateKeyPath), privateKeyBytes);

        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);
        Files.write(Paths.get(publicKeyPath), publicKeyBytes);
    }
}
