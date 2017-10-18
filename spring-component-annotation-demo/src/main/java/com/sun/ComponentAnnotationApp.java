package com.sun;

import com.domain.Organization;
import com.domain.promotion.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentAnnotationApp {
    public static void main(String[] args) {
        // Create application context (Container)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
        Organization organization = (Organization) applicationContext.getBean("myorg") ;
        System.out.println(organization);
//        TradeFair tradeFair = (TradeFair) applicationContext.getBean("tradeFair");
//        System.out.println(tradeFair.specialPromotionPricing());
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
