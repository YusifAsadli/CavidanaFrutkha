package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.basket.BasketAddDto;
import edu.az.itbrains123.ecommerse.dtos.basket.BasketDto;
import edu.az.itbrains123.ecommerse.dtos.user.UserBasketDto;
import edu.az.itbrains123.ecommerse.models.Basket;

import java.util.List;

public interface  BasketService {
    void addToCart(BasketAddDto basketAddDto,String userEmail);
    UserBasketDto getBasket(String email, String coupon);
    void removeBasketItem(String userEmail, Long id);
}
