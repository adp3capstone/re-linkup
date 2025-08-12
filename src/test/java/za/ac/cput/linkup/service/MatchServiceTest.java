package za.ac.cput.linkup.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.enums.Major;
import za.ac.cput.linkup.repository.MatchRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatchServiceTest {
    @Autowired
    private MatchRepository matchRepository;
    private MatchService matchService;
    private  User user1;
    private  User user2;
    private Match match;

    @BeforeEach
    void setUp() {
        user1 = new User.Builder()
                .setUserId(1L)
                .setFirstName("Luyanda")
                .setLastName("Makhanya")
                .setEmail("luyanda@gmail.com")
                .setMajor(Major.COMPUTER_SCIENCE)
                .build();

        user2 = new User.Builder()
                .setUserId(2L)
                .setFirstName("Hope")
                .setLastName("Puse")
                .setEmail("puse@gmail.com")
                .setMajor(Major.COMPUTER_SCIENCE)
                .build();
    }

    @Test
    void create() {
        Match created = matchService.create(match);
        assertNotNull(created);
        assertEquals(match.getUser1(), created.getUser1());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Match created = matchService.create(match);
        Match read = matchService.read(created.getMatchId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Match created = matchService.create(match);
        Match updatedMatch = new Match.Builder()
                .copy(created)
                .setActive(false)
                .build();
        Match updated = matchService.update(updatedMatch);
        assertNotNull(updated);
        assertFalse(updated.isActive());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        Match created = matchService.create(match);
        boolean deleted = matchService.delete(created.getMatchId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void getAllMatches() {
        matchService.create(match);
        List<Match> matches = matchService.getAllMatches();
        assertNotNull(matches);
        assertFalse(matches.isEmpty());
        System.out.println("All matches: " + matches);
    }
}