package co.com.the_chaos_company.model.cartitem;

import co.com.the_chaos_company.model.product.Product;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CartItem {
    private final Product product;
    private final Integer quantity;

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
//        if (!isValid()) {
//            throw new CartItemNotValidException(this);
//        }
    }

    public Double getTotal() {
        return product.getPrice() * quantity;
    }

    public boolean isValid() {
        return product != null && product.isValid() && quantity != null && quantity > 0;
    }
}
