package com.sun.dao;

import com.sun.domain.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizatonDao {
    // Set the data source for connecting with the database
    public void setDataSource(DataSource ds);

    // Create a record in the organization table
    public boolean create(Organization organization);

    // Get a single organization from the database
    public Organization getOrganization(int id);

    // Get all the organizations from the database
    public List<Organization> getAllOrganizations();

    // Delete an organization from the database
    public boolean delete(Organization organization);

    // Update an organization
    public boolean update(Organization organization);

    // Clean up connection
    public void cleanup();


}
