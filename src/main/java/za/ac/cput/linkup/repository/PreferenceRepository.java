package za.ac.cput.linkup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.domain.message.Message;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
