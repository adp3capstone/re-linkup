package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Match;

public interface IMatchRepository extends JpaRepository<Match, Long> {
}
