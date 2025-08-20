package za.ac.cput.linkup.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Gender;
import za.ac.cput.linkup.domain.enums.Institution;
import za.ac.cput.linkup.domain.enums.Major;
import za.ac.cput.linkup.factory.MatchFactory;
import za.ac.cput.linkup.factory.UserFactory;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchControllerTest {

    private static Match match;
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080/match";

    @BeforeEach
    void setUp() {
        // Create sample users
        User userA = UserFactory.createUser(
                101L,
                "anita123",
                "anita@example.com",
                "Anita",
                "Lottering",
                25,
                Gender.FEMALE,
                "Bio",
                Institution.UNIVERSITY_OF_CAPE_TOWN,
                Major.COMPUTER_SCIENCE,
                null,
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );

        User userB = UserFactory.createUser(
                102L,
                "password456",
                "ethan@gmail.com",
                "Ethan",
                "Le Roux",
                24,
                Gender.MALE,
                "Enjoys sports",
                Institution.CAPE_PENINSULA_UNIVERSITY_OF_TECHNOLOGY,
                Major.INFORMATION_TECHNOLOGY,
                null,
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );

        // Assign to class-level match
        match = MatchFactory.createMatch(
                0L,
                LocalDateTime.now(),
                true,
                userA,
                userB
        );

    }

    @Test
    void a_create() {
        ResponseEntity<Match> response = restTemplate.postForEntity(
                BASE_URL + "/create", match, Match.class);
        assertNotNull(response.getBody());
        assertEquals(match.getUser1().getUserId(), response.getBody().getUser1().getUserId());
        match = response.getBody();
    }

    @Test
    void b_read() {
        ResponseEntity<Match> response = restTemplate.getForEntity(
                BASE_URL + "/read/" + match.getMatchId(), Match.class);
        assertNotNull(response.getBody());
        assertEquals(match.getMatchId(), response.getBody().getMatchId());

    }

    @Test
    void c_update() {

        Match updatedMatch = new Match.Builder()
                .copy(match)
                .setActive(false) //deactivate the match
                .build();

        String url = BASE_URL + "/update";
        ResponseEntity<Match> response = restTemplate.postForEntity(url, updatedMatch, Match.class);
        assertNotNull(response);
        Match updatedResponse = response.getBody();
        assertNotNull(updatedResponse);
        assertFalse(updatedResponse.isActive());
        System.out.println("Updated Match: " + updatedResponse);
        match = updatedResponse; // Update the class-level match with the updated response

    }

    @Test
    void d_delete() {
        restTemplate.delete(BASE_URL + "/delete/" + match.getMatchId());
        ResponseEntity<Match> response = restTemplate.getForEntity(
                BASE_URL + "/read/" + match.getMatchId(), Match.class);
        assertNull(response.getBody());
    }

    @Test
    void e_getAll() {
        ResponseEntity<Match[]> response = restTemplate.getForEntity(
                BASE_URL + "/getAll", Match[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0, "Match list should not be empty");
        for (Match m : response.getBody()) {
            System.out.println("Match: " + m);
        }

    }
}