package com.sun;

import com.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PNamespaceApp {
    public static void main(String[] args) {
        // Create application context (Container)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
        //Create the bean
        Organization organization = (Organization)applicationContext.getBean("myorg");
        // Invoke bean method
        System.out.println("---------------");
        System.out.println(organization);
        System.out.println("---------------");
        //Close application context(container)
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
