package com.c4hco.test.automation.utils.Dto;

public class PolicyMember {
    String firstName;
    String lastName;
    String emailId;
    String password = "ALaska12!";
    String phoneNumber;
    String ssn;
    String relationshipToSubscriber;
    String signature;

    String accountId;
    String policyId;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getSsn() {
        return this.ssn;
    }

    public String getRelationshipToSubscriber() {
        return this.relationshipToSubscriber;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getPolicyId() {
        return this.policyId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setRelationshipToSubscriber(String relationshipToSubscriber) {
        this.relationshipToSubscriber = relationshipToSubscriber;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }
}
