package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
    // Additional query methods can be defined here if needed
}
