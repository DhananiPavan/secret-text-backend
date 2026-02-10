package com.pavan.secret_text_backend.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "secret_text")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secret {

    @Id
    private String id;

    private String pin;

    private String content;

    @CreatedDate
    @Indexed(expireAfter = "PT24H") // 24 hours
    private Instant createdAt;

}

