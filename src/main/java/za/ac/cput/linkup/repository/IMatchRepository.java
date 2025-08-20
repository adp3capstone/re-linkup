package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;

import java.util.List;
import java.util.Optional;

public interface IMatchRepository extends JpaRepository<Match, Long> {

    // Find all matches a user is involved in by their user IDs
    List<Match> findByUser1OrUser2(User user1, User user2);

    // Check if a match exists between two users(user1 to user2)
    Optional<Match> findByUser1AndUser2(User user1, User user2);

    // Check if a match exists between two users (user2 to user1)
    Optional<Match> findByUser2AndUser1(User user2, User user1);

}
