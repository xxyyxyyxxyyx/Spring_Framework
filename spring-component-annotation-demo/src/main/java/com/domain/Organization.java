package com.domain;

import com.service.BusinessService;
import com.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Organization {
    private String companyName;
    private int yearOfIncorporation;
    @Value("${org.postalCode}")
    private String postalCode;
    private int employeeCount;
    @Value("${org.employeeCount}")
    private String slogan;

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

//    public void initialize(){
//        System.out.println("initialization method called");
//
//    }
//
//    public void destroy(){
//        System.out.println("destroy method called");
//    }

    public void postConstruct(){

    }

    public void preDestroy(){
    }


    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    //Static factory method
    public static Organization createInstance(String companyName, int yearOfIncorporation){
        System.out.println("Invoking static factory method");
        return new Organization(companyName,yearOfIncorporation);
    }


    public String corporateSlogan(){
        return slogan;
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
