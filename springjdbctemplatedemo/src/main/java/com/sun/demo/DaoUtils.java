package com.sun.demo;

import com.sun.dao.OrganizatonDao;
import com.sun.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {
    public static final String createOperation = "CREATE";
    public static final String readOperation = "READ";
    public static final String updateOperation = "UPDATE";
    public static final String deleteOperation = "DELETE";
    public static final String cleanupOperation = "TRUNCATE";

    public static void printOrganizations(List<Organization> organizations, String operation) {
        System.out.println("\n*********** printing organizations after " + operation + " operation");
        for (Organization organization : organizations) {
            System.out.println(organization);
        }
    }

    public static void printSuccessFailure(String operation, boolean param) {
        if (param) {
            System.out.println("\nOperation " + operation + " successful");
        } else {
            System.out.println("\nOperation " + operation + " failed");
        }

    }

    public static void createSeedData(OrganizatonDao organizatonDao){
        Organization organization = new Organization("Chaudhary",1994,"977",1000,"We sell dry noodle snacks");
        Organization organization1 = new Organization("Google",1990,"777",5000,"We are the search engine giant");
        Organization organization2 = new Organization("Tesla",2000,"8888",3000,"We will go to mars");
        List<Organization> organizations = new ArrayList<Organization>();
        organizations.add(organization);
        organizations.add(organization1);
        organizations.add(organization2);

        int createCount = 0;
        for(Organization org : organizations){
            boolean created = organizatonDao.create(org);
            if(created) createCount++;
        }

        System.out.println("Created "+createCount+" organizations");
    }

    public static void printOrganizationsCount(List<Organization> organizations, String operation){
        System.out.println("\n*********Currently we have "+organizations.size()+" organizations after "+operation+" operation");
    }

    public static void printOrganization(Organization organization, String operation){
        System.out.println("\n*********Printing organization after invoking "+operation+" operation");
        System.out.println(organization);
    }
}
