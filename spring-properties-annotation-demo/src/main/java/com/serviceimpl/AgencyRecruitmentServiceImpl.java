package com.serviceimpl;

import com.service.RecruitmentService;

import java.util.Random;

public class AgencyRecruitmentServiceImpl implements RecruitmentService {
    public String recuritEmployees(String companyName, String department, int numberOfRecruitments) {
        Random random = new Random();
        String hiringFacts = companyName+" hired "+random.nextInt(numberOfRecruitments)+" employees from agencies";
        return hiringFacts;
    }
}
