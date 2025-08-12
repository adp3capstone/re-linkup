package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.linkup.domain.Like;
import za.ac.cput.linkup.domain.User;


public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByFromUserIdAndToUserId(User fromUser, User toUser);

}
