package com.pavan.secret_text_backend.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pavan.secret_text_backend.model.Secret;
import com.pavan.secret_text_backend.service.SecretService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/secret")
@RequiredArgsConstructor

 // allow frontend calls
public class SecretController {

    private final SecretService secretService;

    // 1️⃣ Upload secret text with PIN
    @PostMapping
    public ResponseEntity<?> saveSecret(@RequestBody Secret request) {
        if (request.getPin() == null || request.getPin().isBlank() ||
                request.getContent() == null || request.getContent().isBlank()) {

            return ResponseEntity
                    .badRequest()
                    .body("PIN and content must have proper values (cannot be empty or blank)");
        }

        String pin = request.getPin().trim();
        String content = request.getContent().trim();

        // 🔥 Check if PIN already exists
        if (secretService.pinExists(pin)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("PIN already exists. Please choose another PIN.");
        }

        secretService.saveSecret(pin, content);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Secret saved successfully");
    }

    // 2️⃣ Get secret text using PIN
    @GetMapping("/{pin}")
    public ResponseEntity<?> getSecret(@PathVariable String pin) {
        Optional<Secret> secretOpt = secretService.getSecretByPin(pin);

        return secretOpt.<ResponseEntity<?>>map(secret -> ResponseEntity.ok(secret.getContent())).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Invalid PIN or secret expired"));

    }
}
