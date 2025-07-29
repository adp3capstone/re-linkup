package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.User;
import za.ac.cput.linkup.domain.message.Message;

public interface UserRepository extends JpaRepository<User, Long> {
}
