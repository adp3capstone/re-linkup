package za.ac.cput.linkup.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.repository.LikeRepository;
import za.ac.cput.linkup.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LikeServiceTest {
    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    private User user1;
    private User user2;

    private Like like1;
    private Like like2;


    @BeforeEach
    void setUp() {
        // Create and save users
        user1 = new User();
        user2 = new User();
        userRepository.save(user1);
        userRepository.save(user2);

        // Build likes
        like1 = new Like.Builder()
                .setLikeId(1L)
                .setFromUserId(user1)
                .setToUserId(user2)
                .setTimestamp(LocalDateTime.now())
                .build();

        like2 = new Like.Builder()
                .setLikeId(2L)
                .setFromUserId(user2)
                .setToUserId(user1)
                .setTimestamp(LocalDateTime.now().plusMinutes(5))
                .build();

    }

    @Test
    void create() {
        Like created = likeService.create(like1);
        assertNotNull(created);
        assertEquals(user1, created.getFromUserId());
        System.out.println("Created Like: " + created);

    }

    @Test
    void read() {
        Like created = likeService.create(like1);
        Like read = likeService.read(created.getLikeId());
        assertNotNull(read);
        assertEquals(created.getLikeId(), read.getLikeId());
        System.out.println("Read Like: " + read);
    }

    @Test
    void update() {
        Like created = likeService.create(like1);

        Like updated = new Like.Builder()
                .setLikeId(created.getLikeId())
                .setFromUserId(created.getFromUserId())
                .setToUserId(created.getToUserId())
                .setTimestamp(LocalDateTime.now().plusHours(1))
                .build();

        Like result = likeService.update(updated);
        assertNotNull(result);
        assertEquals(updated.getTimestamp(), result.getTimestamp());
        System.out.println("Updated Like: " + result);
    }

    @Test
    void delete() {
        Like created = likeService.create(like1);
        assertNotNull(likeService.read(created.getLikeId()));

        likeService.delete(created.getLikeId());

        assertNull(likeService.read(created.getLikeId()));
        System.out.println("Deleted Like with ID: " + created.getLikeId());

    }

    @Test
    void getAllLike() {
        likeService.create(like1);
        likeService.create(like2);

        List<Like> allLikes = likeService.getAllLike();
        assertEquals(2, allLikes.size());
        System.out.println("All Likes: " + allLikes);
    }

/*    @Test
    void shouldDetectMatchWhenMutualLikesExist() {
        likeService.create(like1); // user1 likes user2
        likeService.create(like2); // user2 likes user1

        Optional<Like> reverseLike = likeRepository.findByFromUserIdAndToUserId(
                user2, user1
        );

        assertTrue(reverseLike.isPresent());
        System.out.println("Match logic confirmed!");
    }*/
}