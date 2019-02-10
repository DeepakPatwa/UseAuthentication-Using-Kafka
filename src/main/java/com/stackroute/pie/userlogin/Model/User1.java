package com.stackroute.pie.userlogin.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class User1 {


    private Long insuredId;
    private String fullName;
    private String username;


    private String email;
    private String password;
    private  String gender;
    private Date createdDate = new Date();
    private Set<Role> roles = new HashSet<>();
    private Set<Policy> policies =new HashSet<>();
    private String securityAnswer;



    public User1() {}

    public User1(Long insuredId, String fullName, String username, String email, String password, String gender, Date createdDate, String securityAnswer, Set<Role> roles, Set<Policy> policies) {
        this.insuredId = insuredId;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.createdDate = createdDate;
        this.securityAnswer = securityAnswer;
        this.roles = roles;
        this.policies = policies;
    }


    public Long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Long insuredId) {
        this.insuredId = insuredId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(Set<Policy> policies) {
        this.policies = policies;
    }

    @Override
    public String toString() {
        return "User1{" +
                "insuredId=" + insuredId +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", createdDate=" + createdDate +
                ", roles=" + roles +
                ", policies=" + policies +
                ", securityAnswer='" + securityAnswer + '\'' +
                '}';
    }
}
