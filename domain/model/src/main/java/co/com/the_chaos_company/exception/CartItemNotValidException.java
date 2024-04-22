package co.com.the_chaos_company.exception;

import co.com.the_chaos_company.model.cartitem.CartItem;

public class CartItemNotValidException extends RuntimeException {
    public CartItemNotValidException(CartItem cartItem) {
        super("CartItem not valid: " + cartItem);
    }
}
