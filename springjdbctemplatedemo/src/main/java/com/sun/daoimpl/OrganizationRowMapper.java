package com.sun.daoimpl;

import com.sun.domain.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization> {
    public Organization mapRow(ResultSet resultSet, int rownum) throws SQLException {
        Organization organization = new Organization();
        organization.setId(resultSet.getInt("id"));
        organization.setCompanyName(resultSet.getString("company_name"));
        organization.setYearOfIncorporation(resultSet.getInt("year_of_incorporation"));
        organization.setPostalCode(resultSet.getString("postal_code"));
        organization.setEmployeeCount(resultSet.getInt("employee_count"));
        organization.setSlogan(resultSet.getString("slogan"));
        return organization;
    }
}
