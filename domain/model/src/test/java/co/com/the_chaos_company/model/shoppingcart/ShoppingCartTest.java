package co.com.the_chaos_company.model.shoppingcart;

import co.com.the_chaos_company.exception.CartItemNotValidException;
import co.com.the_chaos_company.model.cartitem.CartItem;
import co.com.the_chaos_company.model.product.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class ShoppingCartTest {

    static Object[] getTotal_parametrizedMethod() {
        return new Object[]{
                new Object[]{100.0, 200.0, 300.0, 600.0},
                new Object[]{200.0, 300.0, 400.0, 900.0},
                new Object[]{300.0, 400.0, 500.0, 1200.0}
        };
    }

    @Test
    void getTotal_withItems() {
        Product product1 = new Product("Product 1", 100.0);
        Product product2 = new Product("Product 2", 200.0);
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, 3);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        assertEquals(800.0, shoppingCart.getTotal());
    }

    @Test
    void getTotal_withInvalidItems() {
        Product product1 = new Product("Product 1", 100.0);
        Product product2 = new Product("Product 2", 200.0);
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, -3);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);

        Exception e = assertThrows(CartItemNotValidException.class, () -> shoppingCart.addItem(item2));

        assertEquals("CartItem not valid: CartItem(product=Product(name=Product 2, price=200.0), quantity=-3)",
                e.getMessage());
    }

    @Test
    void getTotal_timeValid() {
        Product product1 = new Product("Product 1", 100.0);
        Product product2 = new Product("Product 2", 200.0);
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product2, 3);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        assertTimeout(Duration.ofMillis(500), () -> {
            assertEquals(800.0, shoppingCart.getTotal());
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void getTotal_parametrizedCsv(Double price1, Double price2, Double price3, Double expected) {
        Product product1 = new Product("Product 1", price1);
        Product product2 = new Product("Product 2", price2);
        Product product3 = new Product("Product 3", price3);
        CartItem item1 = new CartItem(product1, 1);
        CartItem item2 = new CartItem(product2, 1);
        CartItem item3 = new CartItem(product3, 1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.addItem(item3);

        assertEquals(expected, shoppingCart.getTotal());
    }

    @ParameterizedTest
    @MethodSource
    void getTotal_parametrizedMethod(Double price1, Double price2, Double price3, Double expected) {
        Product product1 = new Product("Product 1", price1);
        Product product2 = new Product("Product 2", price2);
        Product product3 = new Product("Product 3", price3);
        CartItem item1 = new CartItem(product1, 1);
        CartItem item2 = new CartItem(product2, 1);
        CartItem item3 = new CartItem(product3, 1);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.addItem(item3);

        assertEquals(expected, shoppingCart.getTotal());
    }

}