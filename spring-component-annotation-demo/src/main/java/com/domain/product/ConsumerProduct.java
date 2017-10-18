package com.domain.product;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class ConsumerProduct extends GenericProduct {
    public int calculatePrice() {
        Random random = new Random();
        int price = random.nextInt(priceRandomizer);
        return price;
    }
}
