# Spring Boot Feign Client 예제

이 프로젝트는 Spring Cloud OpenFeign을 사용하여 Spring Boot 애플리케이션에서 REST 클라이언트를 생성하는 방법을 설명합니다. 이 예제는 게시물 서비스와 사용자 서비스와 상호 작용하는 두 개의 Feign 클라이언트(`PostClient`
와 `UserClient`)를 포함합니다.

## 프로젝트 구조

- `com.example.feignclient`
    - `SpringbootFeignClientExampleApplication`: 메인 애플리케이션 클래스.
    - `client`
        - `PostClient`: 게시물 서비스와 상호 작용하는 Feign 클라이언트.
        - `UserClient`: 사용자 서비스와 상호 작용하는 Feign 클라이언트.
    - `dto`
        - `PostRequest`, `PostResponse`: 게시물용 데이터 전송 객체.
        - `UserRequest`, `UserResponse`: 사용자용 데이터 전송 객체.
    - `tests`
        - `SpringbootFeignClientExampleApplicationTests`: 애플리케이션 단위 테스트.

## Feign 클라이언트

### PostClient

`PostClient` 인터페이스는 다음 엔드포인트를 정의합니다:

- `@PostMapping`: 새로운 게시물 생성.
- `@PutMapping("/{postId}")`: 기존 게시물 수정.
- `@GetMapping`: 사용자 ID로 게시물 조회.
- `@GetMapping("/{postId}")`: 게시물 ID로 게시물 조회.
- `@DeleteMapping("/{postId}")`: 게시물 ID로 게시물 삭제.

```java

@FeignClient(name = "post-client", url = "https://koreanjson.com/posts")
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
```

### UserClient

`UserClient` 인터페이스는 다음 엔드포인트를 정의합니다:

- `@PostMapping`: 새로운 사용자 생성.
- `@PutMapping("/{userId}")`: 기존 사용자 수정.
- `@GetMapping("/{userId}")`: 사용자 ID로 사용자 조회.
- `@DeleteMapping("/{userId}")`: 사용자 ID로 사용자 삭제.

```java

@FeignClient(name = "user-client", url = "https://koreanjson.com/users")
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
```

## 애플리케이션 실행

1. **리포지토리 클론:**
   ```sh
   git clone https://github.com/an-in-seek/springboot_feignclient_example.git
   cd springboot_feignclient_example
   ```

2. **프로젝트 빌드:**
   ```sh
   ./gradlew build
   ```

3. **애플리케이션 실행:**
   ```sh
   ./gradlew bootRun
   ```

## 애플리케이션 테스트

단위 테스트는 `src/test/java/com/example/feignclient` 디렉토리에 위치해 있습니다. 테스트를 실행하려면 다음 명령어를 사용하세요:

```sh
./gradlew test
```

## 종속성

이 프로젝트는 다음 종속성을 필요로 합니다:

- Spring Boot
- Spring Cloud OpenFeign
- Spring Web
- Spring Boot Test
- JUnit

`build.gradle` 파일에 다음 종속성이 포함되어 있는지 확인하세요:

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation platform('org.springframework.cloud:spring-cloud-dependencies:2023.0.2')
    implementation "org.springframework.cloud:spring-cloud-starter-openfeign"
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

## 설정

메인 애플리케이션 클래스에서 Feign 클라이언트를 활성화해야 합니다:

```java

@EnableFeignClients
@SpringBootApplication
public class SpringbootFeignClientExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFeignClientExampleApplication.class, args);
    }
}
```