package playground.specification.productDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.productDataContext.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {}
