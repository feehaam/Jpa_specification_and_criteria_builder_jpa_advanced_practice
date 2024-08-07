package playground.specification;

import org.springframework.stereotype.Service;
import playground.specification.productDataContext.entities.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceSpecificationImpl implements ProductService {

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Product> findByDescriptionContaining(String keyword) {
        return List.of();
    }

    @Override
    public List<Product> findByTagsName(String tagName) {
        return List.of();
    }

    @Override
    public List<Product> findByVariantsPriceLessThan(Double price) {
        return List.of();
    }

    @Override
    public List<Product> findByVariantsAvailableQuantityGreaterThan(Integer quantity) {
        return List.of();
    }

    @Override
    public List<Product> findByCreatedAtAfter(LocalDateTime dateTime) {
        return List.of();
    }

    @Override
    public List<Product> findByVariantsName(String variantName) {
        return List.of();
    }

    @Override
    public List<Product> findByTitleOrDescription(String title, String description) {
        return List.of();
    }

    @Override
    public List<Product> findProductsWithVariantsPriceBetween(Double minPrice, Double maxPrice) {
        return List.of();
    }

    @Override
    public List<Product> findProductsWithTagAndVariantPriceBetween(String tagName, Double minPrice, Double maxPrice) {
        return List.of();
    }

    @Override
    public List<Product> findProductsWithTotalAvailabilityBelow(Integer minLimit) {
        return List.of();
    }

    @Override
    public List<Product> findProductsByMultipleTags(List<String> tagNames) {
        return List.of();
    }

    @Override
    public Object findProductBasicInfoList() {
        return null;
    }

    @Override
    public Object findProductAndTotalQuantityList() {
        return null;
    }
}
