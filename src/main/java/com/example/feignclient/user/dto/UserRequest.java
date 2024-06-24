package com.example.feignclient.user.dto;

public record UserRequest(
    String name,
    String username,
    String email,
    String phone,
    String website,
    String province,
    String city,
    String district,
    String street,
    String zipcode
) {

}
