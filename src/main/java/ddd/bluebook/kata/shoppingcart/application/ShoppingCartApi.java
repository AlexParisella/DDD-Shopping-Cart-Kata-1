package ddd.bluebook.kata.shoppingcart.application;

import ddd.bluebook.kata.shoppingcart.domain.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartApi {

@Autowired
ShoppingCartRepository repository;


 /*   public ShoppingCart getCartForUser(String userId) {
        ShoppingCart shoppingCart = repository.findByUserId(userId);
        if(shoppingCart == null) {
            shoppingCart = ShoppingCart.createEmpty(userId);
            repository.save(shoppingCart);
        }
        return  shoppingCart;
    }*/




}
