package com.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("myorg")
public class Organization {
    @Value("${org.companyName}")
    private String companyName;
    @Value("${org.yearOfIncorporation}")
    private int yearOfIncorporation;
    @Value("${org.postalCode}")
    private String postalCode;
    @Value("${org.employeeCount:300}")
    private int employeeCount;
    @Value("${org.slogan: This is an overridden mission statement}")
    private String slogan;
    private String missionStatement;
    @Autowired
    private Environment env;

    public String corporateSlogan(){
        missionStatement = env.getProperty("statement");
        return missionStatement+" and also "+slogan;
    }



    @Override
    public String toString() {
        return "Organization{" +
                "companyName='" + companyName + '\'' +
                ", yearOfIncorporation=" + yearOfIncorporation +
                ", postalCode='" + postalCode + '\'' +
                ", employeeCount=" + employeeCount +
                ", slogan='" + slogan + '\'' +
                '}';
    }

    public Organization() {
    }

    public Organization(String companyName, int yearOfIncorporation) {
        this.companyName = companyName;
        this.yearOfIncorporation = yearOfIncorporation;
    }


    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    //Static factory method

    public static Organization createInstance(String companyName, int yearOfIncorporation){
        System.out.println("Invoking static factory method");
        return new Organization(companyName,yearOfIncorporation);
    }




    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;

    }
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;

    }

    public String getCompanyName() {
        return companyName;
    }

}
