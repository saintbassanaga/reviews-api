package tech.saintbassanaga.reviewsapi.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author hmekeng
 * @created 10/03/2025 - 13:56
 * @project mercurial-rest
 * @package com.siic.dgls.mercurial.config.security
 */
@ConfigurationProperties(prefix = "rsa")
public record RsaKeyConfig(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}

