package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Match;
import za.ac.cput.linkup.domain.User;

public interface MatchRepository extends JpaRepository<Match, Long> {

    //method to check if a match exists between two users regardless of the order of users
    boolean existsByUser1AndUser2OrUser2AndUser1(User user1, User user2, User user3, User user4);
}
