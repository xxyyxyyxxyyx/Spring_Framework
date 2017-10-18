package com.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp2 {
    public static void main(String[] args) {
        // Create application context (Container)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
        //Create the bean
        Organization organization = (Organization)applicationContext.getBean("myorg");
        Department humanResourceDept = (Department)applicationContext.getBean("humanResourceDept");
        // Invoke bean method
        System.out.println("---------------");
        System.out.println(organization.corporateSlogan());
        System.out.println(organization.corporateService());
        System.out.println(humanResourceDept.hiringStauts(1000));
        System.out.println("---------------");
        //Close application context(container)
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
