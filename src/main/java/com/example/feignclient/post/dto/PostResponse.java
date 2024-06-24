package com.example.feignclient.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public record PostResponse(
    long id,
    String title,
    String content,
    @JsonProperty("UserId") long userId,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
