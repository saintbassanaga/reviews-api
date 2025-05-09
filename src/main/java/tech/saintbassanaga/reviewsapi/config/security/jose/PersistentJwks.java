package tech.saintbassanaga.reviewsapi.config.security.jose;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Getter
@Component
public class PersistentJwks {
    private static final Logger logger = LoggerFactory.getLogger(PersistentJwks.class);
    private static final String KEY_FILE_PATH = "jwt-rsa-key.ser";
    private final RSAKey rsaKey;

    public PersistentJwks() {
        this.rsaKey = loadOrGenerateRsaKey();
    }

    public RSAPublicKey getPublicKey() throws JOSEException {
        return this.rsaKey.toRSAPublicKey();
    }

    private RSAKey loadOrGenerateRsaKey() {
        File keyFile = new File(KEY_FILE_PATH);
        
        if (keyFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(keyFile))) {
                logger.info("Loading RSA key from file: {}", KEY_FILE_PATH);
                return (RSAKey) ois.readObject();
            } catch (Exception e) {
                logger.warn("Failed to load RSA key from file: {}", e.getMessage());
                // If loading fails, generate a new key
                return generateAndSaveRsaKey();
            }
        } else {
            return generateAndSaveRsaKey();
        }
    }

    private RSAKey generateAndSaveRsaKey() {
        logger.info("Generating new RSA key and saving to file: {}", KEY_FILE_PATH);
        RSAKey newKey = generateRsa();
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(KEY_FILE_PATH))) {
            oos.writeObject(newKey);
        } catch (Exception e) {
            logger.error("Failed to save RSA key to file: {}", e.getMessage());
        }
        
        return newKey;
    }

    private RSAKey generateRsa() {
        return Jwks.generateRsa();
    }

}