package com.stackroute.pie.userlogin.Model;

public class Request {
    public Request(int requestId, String requestStatus, String newInsurancePolicy, String newInsuranceCompany) {
        this.requestId = requestId;
        this.requestStatus = requestStatus;
        this.newInsurancePolicy = newInsurancePolicy;
        this.newInsuranceCompany = newInsuranceCompany;
    }

    private int requestId;
    private String requestStatus;
    private String newInsurancePolicy;
    private String newInsuranceCompany;

    public String getNewInsurancePolicy() {
        return newInsurancePolicy;
    }

    public void setNewInsurancePolicy(String newInsurancePolicy) {
        this.newInsurancePolicy = newInsurancePolicy;
    }

    public String getNewInsuranceCompany() {
        return newInsuranceCompany;
    }

    public void setNewInsuranceCompany(String newInsuranceCompany) {
        this.newInsuranceCompany = newInsuranceCompany;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}

