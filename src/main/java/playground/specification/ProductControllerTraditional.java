package playground.specification;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products/traditional")
public class ProductControllerTraditional extends ProductControllerBase{
    public ProductControllerTraditional(ProductServiceTraditionalImpl productService) {
        super(productService);
    }
}
