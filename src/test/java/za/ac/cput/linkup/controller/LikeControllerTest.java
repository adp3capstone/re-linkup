package za.ac.cput.linkup.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LikeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    String baseUrl = "http://localhost:8080/api/likes";

    private static Like like;

    @BeforeEach
    void setUp() {
        User userA = new User.Builder()
                .setUserId(1L)
                .setFirstName("Luyanda")
                .setLastName("Makhanya")
                .setEmail("luyanda@gmail.com")
                .build();

        User userB = new User.Builder()
                .setUserId(2L)
                .setFirstName("Bob")
                .setLastName("Jones")
                .setEmail("bob@example.com")
                .build();

        like = new Like.Builder()
                .setLikeId(100L)
                .setFromUserId(userA)
                .setToUserId(userB)
                .setTimestamp(LocalDateTime.now())
                .build();
    }

    @Test
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<Like> postResponse = restTemplate.postForEntity(url, like, Like.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(like.getLikeId(), postResponse.getBody().getLikeId());
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test
    void read() {
        String url = baseUrl + "/read/" + like.getLikeId();
        ResponseEntity<Like> response = restTemplate.getForEntity(url, Like.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(like.getLikeId(), response.getBody().getLikeId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void update() {
        Like updated = new Like.Builder()
                .setLikeId(like.getLikeId())
                .setFromUserId(like.getFromUserId())
                .setToUserId(like.getToUserId())
                .setTimestamp(LocalDateTime.now().plusDays(1))
                .build();
        String url = baseUrl + "/update";
        ResponseEntity<Like> response = restTemplate.postForEntity(url, updated, Like.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(updated.getTimestamp(), response.getBody().getTimestamp());
        System.out.println("Updated: " + response.getBody());

    }

    @Test
    void delete() {
        String url = baseUrl + "/delete/" + like.getLikeId();
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody() );
    }
}