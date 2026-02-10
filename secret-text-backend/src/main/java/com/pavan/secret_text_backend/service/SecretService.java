package com.pavan.secret_text_backend.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pavan.secret_text_backend.model.Secret;
import com.pavan.secret_text_backend.repository.SecretRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecretService {

    private final SecretRepository secretRepository;

    // Save secret text with pin
    public void saveSecret(String pin, String content) {
        Secret secret = new Secret();
        secret.setPin(pin);
        secret.setContent(content);
        secret.setCreatedAt(Instant.now());

        secretRepository.save(secret);
    }

    // Get secret text using pin ----
    public Optional<Secret> getSecretByPin(String pin) {
        return secretRepository.findByPin(pin);
    }
    public boolean pinExists(String pin) {
        return secretRepository.existsByPin(pin);
    }

}
