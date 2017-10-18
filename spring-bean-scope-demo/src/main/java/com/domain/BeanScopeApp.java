package com.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {
    public static void main(String[] args) {
        // Create application context (Container)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
        //Create the bean
        Organization organization = (Organization)applicationContext.getBean("myorg");
        Organization anotherOrganization = (Organization)applicationContext.getBean("myorg");
        anotherOrganization.setPostalCode("9999");
        // Invoke bean method
        System.out.println("---------------");
        System.out.println(organization);
        System.out.println(anotherOrganization);
        if(organization == anotherOrganization){
            System.out.println("Same instance");
        }
//        System.out.println(organization.corporateSlogan());
//        System.out.println(organization.corporateService());
        System.out.println("---------------");
        //Close application context(container)
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
