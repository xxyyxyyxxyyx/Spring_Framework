package com.domain.promotion;

import com.domain.product.ConsumerProduct;
import com.domain.product.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeFair {
    @Autowired
    private IndustrialProduct industrialProduct;
    @Autowired
    private ConsumerProduct consumerProduct;

//    @Autowired
//    public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
//        this.industrialProduct = industrialProduct;
//        this.consumerProduct = consumerProduct;
//    }

    //    @Autowired
//    public void setIndustrialProduct(IndustrialProduct industrialProduct) {
//        this.industrialProduct = industrialProduct;
//    }
//    @Autowired
//    public void setConsumerProduct(ConsumerProduct consumerProduct) {
//        this.consumerProduct = consumerProduct;
//    }
//
    public int declareIndustrialProductPrice(IndustrialProduct industrialProduct){
        return industrialProduct.calculatePrice();
    }
    public int declareConsumerProductPrice(ConsumerProduct consumerProduct){
        return consumerProduct.calculatePrice();
    }
    public String specialPromotionPricing(){
        String priceInfo = "Industrial product price is "+declareIndustrialProductPrice(industrialProduct)+" and the Consumer product price is "+declareConsumerProductPrice(consumerProduct);
        return priceInfo;
    }
}
