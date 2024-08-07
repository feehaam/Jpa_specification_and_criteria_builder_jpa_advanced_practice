package playground.specification.userDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.userDataContext.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
