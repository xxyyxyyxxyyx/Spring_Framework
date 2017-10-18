package com.domain;

import com.service.BusinessService;
import com.service.RecruitmentService;

public class Organization {
    private String companyName;
    private int yearOfIncorporation;
    private String postalCode;
    private int employeeCount;
    private String slogan;
    private BusinessService businessService;

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
    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;

    }

    public String corporateSlogan(){
        return slogan;
    }

    public String corporateService(){
        return businessService.offerService(companyName);
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

    @Override
    public String toString() {
        return "Organization{" +
                "companyName='" + companyName + '\'' +
                ", yearOfIncorporation=" + yearOfIncorporation +
                ", postalCode='" + postalCode + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
