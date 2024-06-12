package co.com.the_chaos_company.productrest;

import co.com.the_chaos_company.model.product.Product;
import co.com.the_chaos_company.usecase.product.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductUseCase productUseCase;

    @GetMapping("/{name}")
    public Product findByName(@PathVariable(name = "name") String name) {
        return productUseCase.findByName(name);
    }
}
