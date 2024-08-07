package playground.specification;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/specification")
public class ProductControllerSpecification extends ProductControllerBase{
    public ProductControllerSpecification(ProductServiceSpecificationImpl productService) {
        super(productService);
    }
}
