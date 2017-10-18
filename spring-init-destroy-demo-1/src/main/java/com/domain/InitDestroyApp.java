package com.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyApp {
    public static void main(String[] args) {
        // Create application context (Container)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
        Organization org1 = (Organization)  applicationContext.getBean("myorg");
        Organization org2 = (Organization) applicationContext.getBean("myorg2") ;

        System.out.println(org1);
        System.out.println(org2);
        //Close application context(container)
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
