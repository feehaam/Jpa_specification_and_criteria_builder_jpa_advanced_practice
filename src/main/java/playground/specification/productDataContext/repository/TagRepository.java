package playground.specification.productDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.productDataContext.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {}
