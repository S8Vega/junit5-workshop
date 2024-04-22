package co.com.the_chaos_company.exception;

import co.com.the_chaos_company.model.product.Product;

public class ProductNotValidException extends RuntimeException {
    public ProductNotValidException(Product product) {
        super("Product not valid: " + product);
    }
}
