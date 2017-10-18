package com.sun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {
    public static void main(String[] args) {
        // Create application context (Container)
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml");
        //Create the bean
        Organization organization = (Organization)applicationContext.getBean("myorg");
        // Invoke bean method
        organization.corporateSlogan();
        //Close application context(container)
        ((FileSystemXmlApplicationContext)applicationContext).close();
    }
}
