package com.sun.daoimpl;

import com.sun.dao.OrganizatonDao;
import com.sun.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizatonDao {
    private NamedParameterJdbcTemplate namedParamJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public boolean create(Organization organization) {
        SqlParameterSource beanParams = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "INSERT INTO organization(company_name,year_of_incorporation,postal_code,employee_count,slogan) VALUES (:companyName,:yearOfIncorporation,:postalCode,:employeeCount,:slogan)";
//        Object[] args = new Object[]{
//                organization.getCompanyName(),
//                organization.getYearOfIncorporation(),
//                organization.getPostalCode(),
//                organization.getEmployeeCount(),
//                organization.getSlogan()
//
//        };
//
//        return namedParamJdbcTemplate.update(sqlQuery, args) == 1;
        return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
    }

    public Organization getOrganization(int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("ID",id);
        String sql = "SELECT * FROM organization WHERE id = :ID";
        Organization organization = namedParamJdbcTemplate.queryForObject(sql, sqlParameterSource, new OrganizationRowMapper());
        return organization;
//        Object[] args = new Object[]{
//                id
//        };

    }

    public List<Organization> getAllOrganizations() {
        String sqlQuery = "SELECT * FROM organization";
        List<Organization> organizations = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return organizations;
    }

    public boolean delete(Organization organization) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(organization);
        String sql = "DELETE FROM organization WHERE id = :id";
        return namedParamJdbcTemplate.update(sql, sqlParameterSource) == 1;
//        Object[] args = new Object[]{
//                organization.getId()
//        };
    }

    public boolean update(Organization organization) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(organization);
        String sql = "UPDATE organization SET slogan = :slogan WHERE id = :id";
        return namedParamJdbcTemplate.update(sql, sqlParameterSource) == 1;
//        Object[] args = new Object[]{
//                organization.getSlogan(),
//                organization.getId()
//        };
    }

    public void cleanup() {
        String sql = "TRUNCATE TABLE organization";
        namedParamJdbcTemplate.getJdbcOperations().execute(sql);
    }
}
