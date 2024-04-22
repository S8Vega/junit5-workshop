package co.com.the_chaos_company.model.product;

import co.com.the_chaos_company.exception.ProductNotValidException;
import lombok.Getter;

@Getter
public class Product {
    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        if (!isValid()) {
            throw new ProductNotValidException(this);
        }
    }

    public boolean isValid() {
        return isValidName() && isValidPrice();
    }

    private boolean isValidName() {
        return name != null && !name.isEmpty() && name.length() > 3;
    }

    private boolean isValidPrice() {
        return price != null && price > 0;
    }

    public String toString() {
        return String.format("Product{name='%s', price=%s}", name, price);
    }
}
