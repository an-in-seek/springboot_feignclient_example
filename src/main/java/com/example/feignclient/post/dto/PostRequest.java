package com.example.feignclient.post.dto;

public record PostRequest(
    String title,
    String content,
    long userId
) {

}
