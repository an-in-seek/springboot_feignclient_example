package com.example.feignclient.post.client;

import com.example.feignclient.post.dto.PostRequest;
import com.example.feignclient.post.dto.PostResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "postClient", url = "https://koreanjson.com/posts")
public interface PostClient {

    @PostMapping
    PostResponse postPost(PostRequest userRequest);

    @PutMapping("/{postId}")
    PostResponse putPost(@PathVariable long postId, @RequestBody PostRequest userRequest);

    @GetMapping
    List<PostResponse> getPostByUserId(@RequestParam long userId);

    @GetMapping("/{postId}")
    PostResponse getPost(@PathVariable long postId);

    @DeleteMapping("/{postId}")
    void deletePost(@PathVariable long postId);

}
