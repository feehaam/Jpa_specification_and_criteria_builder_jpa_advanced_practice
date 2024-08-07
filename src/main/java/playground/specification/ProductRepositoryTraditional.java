package playground.specification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import playground.specification.productDataContext.entities.Product;

import java.util.List;

@Repository
public interface ProductRepositoryTraditional extends JpaRepository<Product, Long> {

    // Directly implemented by JPA Repository methods
    List<Product> findByTitle(String title);

    List<Product> findByDescriptionContaining(String keyword);

    List<Product> findByTagsName(String tagName);

    List<Product> findByVariantsPriceLessThan(Double price);

    List<Product> findByVariantsAvailableQuantityGreaterThan(Integer quantity);

    List<Product> findByCreatedAtAfter(java.time.LocalDateTime dateTime);

    List<Product> findByVariantsName(String variantName);

    List<Product> findByTitleOrDescription(String title, String description);
}
