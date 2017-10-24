package com.sun.demo;

import com.sun.dao.OrganizatonDao;
import com.sun.domain.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import java.util.List;

public class JdbcTemplateClassicApp1 {

    public static void main(String[] args) {
        // Creating the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // Crating organization bean
        OrganizatonDao organizatonDao = (OrganizatonDao) applicationContext.getBean("orgDao");

        // Exception in dao layer
        List<Organization> organizations = null;

        try {
            organizations = organizatonDao.getAllOrganizations();
            for(Organization organization:organizations){
                System.out.println(organization);
            }
        }
        catch (BadSqlGrammarException e){
            System.out.println("EXCEPTION SQL "+e.getSql());
        }
        catch (DataAccessException e){
            System.out.println("EXCEPTION MESSAGE "+e.getMessage());
            System.out.println("EXCEPTION CLASS "+e.getClass());
        }
        //Create seed data
        DaoUtils.createSeedData(organizatonDao);
        // List organizations
//        List<Organization> organizations = organizatonDao.getAllOrganizations();
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

        // Delete an organization from the database
        Organization twitter = organizatonDao.getOrganization(4);
        organizatonDao.delete(twitter);
        organizations = organizatonDao.getAllOrganizations();
        DaoUtils.printOrganizations(organizations,DaoUtils.deleteOperation);
        // Clean up
        organizatonDao.cleanup();
        DaoUtils.printOrganizationsCount(organizatonDao.getAllOrganizations(), DaoUtils.cleanupOperation);
        // Close application context
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
