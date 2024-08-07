package playground.specification.userDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.userDataContext.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
