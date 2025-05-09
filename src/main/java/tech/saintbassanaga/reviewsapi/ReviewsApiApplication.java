package tech.saintbassanaga.reviewsapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.saintbassanaga.reviewsapi.services.AuditorAwareImpls;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ReviewsApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReviewsApiApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpls();
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Generate key pair
        KeyPair keyPair = generateKeyPair();

        // 2. Create output directory
        Path keyDir = Paths.get("keys");
        Files.createDirectories(keyDir);

        // 3. Save keys to PEM files
        writeToPemFile(keyDir.resolve("public.pem"), "PUBLIC KEY", keyPair.getPublic().getEncoded());
        writeToPemFile(keyDir.resolve("private.pem"), "PRIVATE KEY", keyPair.getPrivate().getEncoded());
        writeToPemFile(keyDir.resolve("keypair.pem"), "PRIVATE KEY", keyPair.getPrivate().getEncoded());

        System.out.println("Key files generated in: " + keyDir.toAbsolutePath());
    }

    private KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    private void writeToPemFile(Path path, String type, byte[] encoded) throws IOException {
        String base64 = Base64.getEncoder().encodeToString(encoded);
        String content = "-----BEGIN " + type + "-----\n" +
                base64.replaceAll("(.{64})", "$1\n") +
                "\n-----END " + type + "-----";

        Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }


}
