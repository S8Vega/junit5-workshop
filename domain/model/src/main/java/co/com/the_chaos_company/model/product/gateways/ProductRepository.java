package co.com.the_chaos_company.model.product.gateways;

import co.com.the_chaos_company.model.product.Product;

public interface ProductRepository {
    Product findByName(String name);
}
