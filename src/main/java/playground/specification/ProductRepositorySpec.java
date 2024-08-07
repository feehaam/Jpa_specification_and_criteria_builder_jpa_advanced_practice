package playground.specification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import playground.specification.productDataContext.entities.Product;

@Repository
public interface ProductRepositorySpec extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
