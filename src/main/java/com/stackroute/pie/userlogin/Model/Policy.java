package com.stackroute.pie.userlogin.Model;

public class Policy {

    private String existingInsuranceCompany;
    private int existingPolicyId;
    private String existingPolicyName;
    private String[] diseases;


    public String getExistingInsuranceCompany() {
        return existingInsuranceCompany;
    }

    public void setExistingInsuranceCompany(String existingInsuranceCompany) {
        this.existingInsuranceCompany = existingInsuranceCompany;
    }

    public int getExistingPolicyId() {
        return existingPolicyId;
    }

    public void setExistingPolicyId(int existingPolicyId) {
        this.existingPolicyId = existingPolicyId;
    }

    public String getExistingPolicyName() {
        return existingPolicyName;
    }

    public void setExistingPolicyName(String existingPolicyName) {
        this.existingPolicyName = existingPolicyName;
    }

    public String[] getDiseases() {
        return diseases;
    }

    public void setDiseases(String[] diseases) {
        this.diseases = diseases;
    }

}
