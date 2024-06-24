package com.example.feignclient.user.dto;

import java.time.LocalDateTime;

public record UserResponse(
    long id,
    String name,
    String username,
    String email,
    String phone,
    String website,
    String province,
    String city,
    String district,
    String street,
    String zipcode,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
