package playground.specification;

import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playground.specification.productDataContext.entities.Product;
import playground.specification.productDataContext.entities.Tag;
import playground.specification.productDataContext.entities.Variant;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceSpecificationImpl implements ProductService {

    @Autowired
    private ProductRepositorySpec productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByTitle(String title) {
        return productRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("title"), title));
    }

    @Override
    public List<Product> findByDescriptionContaining(String keyword) {
        return productRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("description"), "%" + keyword + "%"));
    }

    @Override
    public List<Product> findByTagsName(String tagName) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Tag> tags = root.join("tags");
            return criteriaBuilder.equal(tags.get("name"), tagName);
        });
    }

    @Override
    public List<Product> findByVariantsPriceLessThan(Double price) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Variant> variants = root.join("variants");
            return criteriaBuilder.lessThan(variants.get("price"), price);
        });
    }

    @Override
    public List<Product> findByVariantsAvailableQuantityGreaterThan(Integer quantity) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Variant> variants = root.join("variants");
            return criteriaBuilder.greaterThan(variants.get("availableQuantity"), quantity);
        });
    }

    @Override
    public List<Product> findByCreatedAtAfter(java.time.LocalDateTime dateTime) {
        return productRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("createdAt"), dateTime));
    }

    @Override
    public List<Product> findByVariantsName(String variantName) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Variant> variants = root.join("variants");
            return criteriaBuilder.equal(variants.get("name"), variantName);
        });
    }

    @Override
    public List<Product> findByTitleOrDescription(String title, String description) {
        return productRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("title"), title),
                        criteriaBuilder.like(root.get("description"), "%" + description + "%")
                ));
    }

    @Override
    public List<Product> findProductsWithVariantsPriceBetween(Double minPrice, Double maxPrice) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Variant> variants = root.join("variants");
            return criteriaBuilder.between(variants.get("price"), minPrice, maxPrice);
        });
    }

    @Override
    public List<Product> findProductsWithTagAndVariantPriceBetween(String tagName, Double minPrice, Double maxPrice) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Tag> tags = root.join("tags");
            Join<Product, Variant> variants = root.join("variants");
            Predicate tagPredicate = criteriaBuilder.equal(tags.get("name"), tagName);
            Predicate pricePredicate = criteriaBuilder.between(variants.get("price"), minPrice, maxPrice);
            return criteriaBuilder.and(tagPredicate, pricePredicate);
        });
    }

    @Override
    public List<Product> findProductsWithTotalAvailabilityBelow(Integer minLimit) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Subquery<Integer> subquery = query.subquery(Integer.class);
            Root<Variant> variantRoot = subquery.from(Variant.class);
            subquery.select(criteriaBuilder.sum(variantRoot.get("availableQuantity")));
            subquery.where(criteriaBuilder.equal(variantRoot.get("product"), root));
            return criteriaBuilder.lessThan(subquery, minLimit);
        });
    }

    @Override
    public List<Product> findProductsByMultipleTags(List<String> tagNames) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            Join<Product, Tag> tags = root.join("tags");
            CriteriaBuilder.In<String> inClause = criteriaBuilder.in(tags.get("name"));
            tagNames.forEach(inClause::value);
            return inClause;
        });
    }

    @Override
    public Object findProductBasicInfoList() {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            query.multiselect(root.get("id"), root.get("title"), root.get("description"),
                    criteriaBuilder.selectCase()
                            .when(criteriaBuilder.isTrue(root.join("photos").get("isThumbnail")), root.join("photos").get("url"))
                            .otherwise(null)
            );
            return query.getRestriction();
        });
    }

    @Override
    public Object findProductAndTotalQuantityList() {
        return productRepository.findAll((root, query, criteriaBuilder) -> {
            query.multiselect(root.get("id"), root.get("title"),
                    criteriaBuilder.sum(root.join("variants").get("availableQuantity"))
            );
            query.groupBy(root.get("id"));
            return query.getRestriction();
        });
    }
}
