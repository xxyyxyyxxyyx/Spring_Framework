package com.domain;

import com.service.RecruitmentService;

public class HumanResourceDept implements Department {
    private String deptName;
    private RecruitmentService recruitmentService;
    private Organization organization;

    public HumanResourceDept(RecruitmentService recruitmentService, Organization organization) {
        this.recruitmentService = recruitmentService;
        this.organization = organization;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String hiringStauts(int numberOfRecruitments) {
        return recruitmentService.recuritEmployees(organization.getCompanyName(),deptName,numberOfRecruitments);
    }
}
