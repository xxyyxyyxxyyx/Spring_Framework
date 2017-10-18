package com.sun.demo;

import com.sun.dao.OrganizatonDao;
import com.sun.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateClassicApp1 {

    public static void main(String[] args) {
        // Creating the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // Crating organization bean
        OrganizatonDao organizatonDao = (OrganizatonDao) applicationContext.getBean("orgDao");
        //Create seed data
        DaoUtils.createSeedData(organizatonDao);
        // List organizations
        List<Organization> organizations = organizatonDao.getAllOrganizations();
        DaoUtils.printOrganizations(organizations, DaoUtils.readOperation);
        // Create an organization
        Organization organization = new Organization("Twitter", 2000, "1111", 4000, "We are tweeting");
        boolean result = organizatonDao.create(organization);
        DaoUtils.printSuccessFailure(DaoUtils.createOperation, result);
        DaoUtils.printOrganizationsCount(organizatonDao.getAllOrganizations(), DaoUtils.createOperation);
        // List all organizations
        organizations = organizatonDao.getAllOrganizations();
        DaoUtils.printOrganizations(organizations, DaoUtils.createOperation);

        // Get one organization by id
        Organization tesla = organizatonDao.getOrganization(1);
        DaoUtils.printOrganization(tesla, DaoUtils.readOperation);
        // Update an organization's slogan identified by company name
        Organization newTesla = organizatonDao.getOrganization(3);
        newTesla.setSlogan("This will be our new slogan");
        organizatonDao.update(newTesla);
        organizations = organizatonDao.getAllOrganizations();
        DaoUtils.printOrganizations(organizations,DaoUtils.updateOperation);
        // Clean up
        organizatonDao.cleanup();
        DaoUtils.printOrganizationsCount(organizatonDao.getAllOrganizations(), DaoUtils.cleanupOperation);
        // Close application context
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
