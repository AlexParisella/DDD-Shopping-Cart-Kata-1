package ddd.kata.shoppingcart.domain;

import ddd.kata.shoppingcart.domain.articles.ArticleId;
import ddd.kata.shoppingcart.domain.articles.Money;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.assertNotEquals;
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
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertEquals(0.0, shoppingCart.getTotalAmount());
    }

    @Test
    public void thereAreNoItems() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        assertEquals(0, shoppingCart.getItemsCount());
    }

    @Test
    public void canAddItems() {
        String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);
        
        ArticleId articleId = ArticleId.generate();
        String itemDescription = "bellissimo oggetto";
        int qty = 4;
        Money mon = new Money(new BigDecimal(10.0), new BigDecimal(10.0*qty));
        
        shoppingCart.addItem(articleId, itemDescription, qty, mon);

        assertEquals(qty, shoppingCart.getItemsCount());
    }

    @Test
    public void canRemoveItem() {
    	String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        ArticleId articleId = ArticleId.generate();
        String itemDescription = "bellissimo oggetto";
        int qty = 4;
        Money mon = new Money(new BigDecimal(10.0), new BigDecimal(10.0*qty));

        shoppingCart.addItem(articleId, itemDescription, qty, mon);
        
        double size = shoppingCart.getTotalAmount();
        
        shoppingCart.removeItem(articleId);
        
        assertNotEquals(shoppingCart.getTotalAmount(), size);
    }

    @Test
    public void canEditItem() {
    	String cartId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = new ShoppingCart(cartId, userId);

        ArticleId articleId = ArticleId.generate();
        String itemDescription = "bellissimo oggetto";
        int qty = 4;
        
        Money mon = new Money(new BigDecimal(10.0), new BigDecimal(10.0*qty));
        
        shoppingCart.addItem(articleId, itemDescription, qty, mon);
        int primitiveQuantity = shoppingCart.getItemAmount(articleId);
        
        shoppingCart.editItem(articleId, 8);
        
        assertNotEquals(-1, shoppingCart.getItemAmount(articleId));
        assertNotEquals(primitiveQuantity, shoppingCart.getItemAmount(articleId));
        
    }

    /*
    @Test
    public void canAddItemsToCart() {
        String userId = UUID.randomUUID().toString();

        ShoppingCart shoppingCart = ShoppingCart.createEmpty(userId);
        String itemId = UUID.randomUUID().toString();
        String description = "Fabulous Item";
        double unitPrice = 23.99;

        shoppingCart.addItem(itemId, description, unitPrice);

        assertEquals(1, shoppingCart.getItemsCount());
    }*/



}
