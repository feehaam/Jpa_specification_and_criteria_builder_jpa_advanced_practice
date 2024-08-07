package playground.specification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import playground.specification.productDataContext.entities.Product;

@Repository
public interface ProductRepositorySpec extends JpaRepository<Product, Long> {
}
