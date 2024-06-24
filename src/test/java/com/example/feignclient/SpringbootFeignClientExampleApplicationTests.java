package com.example.feignclient;

import com.example.feignclient.post.client.PostClient;
import com.example.feignclient.post.dto.PostResponse;
import com.example.feignclient.user.client.UserClient;
import com.example.feignclient.user.dto.UserResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootFeignClientExampleApplicationTests {

    @Autowired
    private UserClient userClient;

    @Autowired
    private PostClient postClient;

    @Test
    void contextLoads() {
        // 테스트할 User ID
        final long userId = 7;

        // User ID가 7인 사용자 정보 조회
        UserResponse user = userClient.getUser(userId);
        System.out.println(user);

        // User ID가 7인 사용자가 작성한 Post 정보 조회
        List<PostResponse> posts = postClient.getPostByUserId(userId);
        posts.forEach(System.out::println);
    }

}
