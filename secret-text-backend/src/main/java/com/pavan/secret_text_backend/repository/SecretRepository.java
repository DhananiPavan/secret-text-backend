package com.pavan.secret_text_backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pavan.secret_text_backend.model.Secret;

@Repository
public interface SecretRepository extends MongoRepository<Secret, String> {

    Optional<Secret> findByPin(String pin);
    boolean existsByPin(String pin);

}
