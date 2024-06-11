package co.com.the_chaos_company.model.shoppingcart;

import co.com.the_chaos_company.model.cartitem.CartItem;
import co.com.the_chaos_company.model.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTest2 {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        this.shoppingCart = new ShoppingCart();
    }

    @Test
    void isValid_empty() {
        assertTrue(shoppingCart.isValid());
    }

    @Test
    void isValid_withItems() {
        Product product1 = new Product("Product 1", 100.0);
        Product product2 = new Product("Product 2", 200.0);
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, 3);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        assertTrue(shoppingCart.isValid());
    }

    @Test
    @Disabled
    void isValid_withInvalidItems() {
        // cannot be tested because no invalid CartItems can be created
        // TIP2: let TDD really drive your design
    }

    @Test
    void getTotal_empty() {
        assertEquals(0, shoppingCart.getTotal());
    }

    @Test
    void getTotalProducts_empty() {
        assertEquals(0, shoppingCart.getTotalProducts());
    }

    @Test
    void getTotalProducts_withItems() {
        Product product1 = new Product("Product 1", 100.0);
        Product product2 = new Product("Product 2", 200.0);
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, 3);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        assertEquals(5, shoppingCart.getTotalProducts());
    }
}