package playground.specification.productDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.productDataContext.entities.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {}
