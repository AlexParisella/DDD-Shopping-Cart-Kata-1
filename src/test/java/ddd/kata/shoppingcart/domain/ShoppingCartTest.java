package ddd.kata.shoppingcart.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingCartTest {

    @Test
    public void canCreateAnEmptyCart() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertNotNull(shoppingCart);
    }

    @Test
    public void anEmptyCartSubTotalIsZero() {
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = ShoppingCart.createEmpty(userId);

        assertEquals(0.0, shoppingCart.getTotalAmount());
    }

    @Test
    public void canAddItemsToCart() {
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = ShoppingCart.createEmpty(userId);
        String itemId = UUID.randomUUID().toString();
        String description = "Fabulous Item";
        double unitPrice = 23.99;

        shoppingCart.addItem(itemId, description, unitPrice);

        assertEquals(1, shoppingCart.getItemsCount());
    }

}
