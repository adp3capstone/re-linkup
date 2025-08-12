package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.linkup.domain.message.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Custom query methods can be defined here if needed
    // For example, find by message or messageId
    //Optional<Message> findByMessage(String message)
}
