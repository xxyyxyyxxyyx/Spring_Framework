package com.serviceimpl;

import com.service.BusinessService;

import java.util.Random;

public class ColudServiceImpl implements BusinessService {
    public String offerService(String companyName) {
        Random random = new Random();
        String service = companyName + " revenue "+random.nextInt(revenue);
        return service;
    }

    public void postConstruct(){
        System.out.println(" cloud post construct method called");

    }

    public void preDestroy(){
        System.out.println("cloud pre destroy method called");
    }
}
