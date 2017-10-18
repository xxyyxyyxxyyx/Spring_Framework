package com.sun;

import com.domain.Organization;
import com.domain.promotion.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesWithAnnotationApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyConfig.class);
        Organization organization = (Organization) applicationContext.getBean("myorg");
        System.out.println(organization);
        System.out.println(organization.corporateSlogan());
        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
