package com.sun.daoimpl;

import com.sun.dao.OrganizatonDao;
import com.sun.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizatonDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(Organization organization) {
        String sqlQuery = "INSERT INTO organization(company_name,year_of_incorporation,postal_code,employee_count,slogan) VALUES(?,?,?,?,?)";
        Object[] args = new Object[]{
                organization.getCompanyName(),
                organization.getYearOfIncorporation(),
                organization.getPostalCode(),
                organization.getEmployeeCount(),
                organization.getSlogan()

        };

        return jdbcTemplate.update(sqlQuery, args) == 1;

    }

    public Organization getOrganization(int id) {
        String sql = "SELECT * FROM organization WHERE id = ?";
        Object[] args = new Object[]{
                id
        };
        Organization organization = jdbcTemplate.queryForObject(sql,args, new OrganizationRowMapper());
        return organization;

    }

    public List<Organization> getAllOrganizations() {
        String sqlQuery = "SELEC * FROM organization";
        List<Organization> organizations = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
        return organizations;
    }

    public boolean delete(Organization organization) {
        String sql = "DELETE FROM organization WHERE id = ?";
        Object[] args = new Object[]{
                organization.getId()
        };
        return jdbcTemplate.update(sql,args) == 1;
    }

    public boolean update(Organization organization) {
        String sql = "UPDATE organization SET slogan = ? WHERE id = ?";
        Object[] args = new Object[]{
                organization.getSlogan(),
                organization.getId()
        };
        return jdbcTemplate.update(sql,args) == 1;
    }

    public void cleanup() {
        String sql = "TRUNCATE TABLE organization";
        jdbcTemplate.execute(sql);
    }
}
