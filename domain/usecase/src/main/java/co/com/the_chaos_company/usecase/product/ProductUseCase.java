package co.com.the_chaos_company.usecase.product;

import co.com.the_chaos_company.model.product.Product;
import co.com.the_chaos_company.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductRepository productRepository;

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
