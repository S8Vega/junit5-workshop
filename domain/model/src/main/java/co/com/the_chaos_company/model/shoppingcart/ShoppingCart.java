package co.com.the_chaos_company.model.shoppingcart;

import co.com.the_chaos_company.exception.CartItemNotValidException;
import co.com.the_chaos_company.model.cartitem.CartItem;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ShoppingCart {
    private final List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public boolean isValid() {
        return items != null && items.stream().allMatch(CartItem::isValid);
    }

    public Double getTotal() {
        return items.stream().mapToDouble(CartItem::getTotal).sum();
    }

    public Integer getTotalProducts() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public void addItem(CartItem item) {
        if (!item.isValid()) throw new CartItemNotValidException(item);
        items.add(item);
    }
}
