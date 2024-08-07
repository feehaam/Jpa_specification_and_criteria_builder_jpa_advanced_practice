package playground.specification.productDataContext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playground.specification.productDataContext.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

