package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Like;

public interface ILikeRepository extends JpaRepository<Like, Long> {
}
