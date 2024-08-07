package playground.specification.userDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.userDataContext.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
