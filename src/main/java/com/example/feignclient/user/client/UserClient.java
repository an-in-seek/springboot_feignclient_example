package com.example.feignclient.user.client;

import com.example.feignclient.user.dto.UserRequest;
import com.example.feignclient.user.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "userClient", url = "https://koreanjson.com/users")
public interface UserClient {

    @PostMapping
    UserResponse postUser(UserRequest userRequest);

    @PutMapping("/{userId}")
    UserResponse putUser(@PathVariable long userId, @RequestBody UserRequest userRequest);

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable long userId);

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable long userId);

}
