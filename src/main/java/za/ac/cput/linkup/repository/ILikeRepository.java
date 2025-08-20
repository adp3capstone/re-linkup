package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;

public interface ILikeRepository extends JpaRepository<Like, Long> {
    // Check if a "toUser" already liked a "fromUser" (mutual like check)
    boolean existsByFromUserIdAndToUserId(User fromUser, User toUser);
}
