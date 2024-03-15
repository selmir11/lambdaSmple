package com.c4hco.test.automation.utils;

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

    public PolicyMember() {
    }

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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PolicyMember)) return false;
        final PolicyMember other = (PolicyMember) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$emailId = this.getEmailId();
        final Object other$emailId = other.getEmailId();
        if (this$emailId == null ? other$emailId != null : !this$emailId.equals(other$emailId)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$ssn = this.getSsn();
        final Object other$ssn = other.getSsn();
        if (this$ssn == null ? other$ssn != null : !this$ssn.equals(other$ssn)) return false;
        final Object this$relationshipToSubscriber = this.getRelationshipToSubscriber();
        final Object other$relationshipToSubscriber = other.getRelationshipToSubscriber();
        if (this$relationshipToSubscriber == null ? other$relationshipToSubscriber != null : !this$relationshipToSubscriber.equals(other$relationshipToSubscriber))
            return false;
        final Object this$signature = this.getSignature();
        final Object other$signature = other.getSignature();
        if (this$signature == null ? other$signature != null : !this$signature.equals(other$signature)) return false;
        final Object this$accountId = this.getAccountId();
        final Object other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !this$accountId.equals(other$accountId)) return false;
        final Object this$policyId = this.getPolicyId();
        final Object other$policyId = other.getPolicyId();
        if (this$policyId == null ? other$policyId != null : !this$policyId.equals(other$policyId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PolicyMember;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $emailId = this.getEmailId();
        result = result * PRIME + ($emailId == null ? 43 : $emailId.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $ssn = this.getSsn();
        result = result * PRIME + ($ssn == null ? 43 : $ssn.hashCode());
        final Object $relationshipToSubscriber = this.getRelationshipToSubscriber();
        result = result * PRIME + ($relationshipToSubscriber == null ? 43 : $relationshipToSubscriber.hashCode());
        final Object $signature = this.getSignature();
        result = result * PRIME + ($signature == null ? 43 : $signature.hashCode());
        final Object $accountId = this.getAccountId();
        result = result * PRIME + ($accountId == null ? 43 : $accountId.hashCode());
        final Object $policyId = this.getPolicyId();
        result = result * PRIME + ($policyId == null ? 43 : $policyId.hashCode());
        return result;
    }

//    public String toString() {
//        return "PolicyMember(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", emailId=" + this.getEmailId() + ", password=" + this.getPassword() + ", phoneNumber=" + this.getPhoneNumber() + ", ssn=" + this.getSsn() + ", relationshipToSubscriber=" + this.getRelationshipToSubscriber() + ", signature=" + this.getSignature() + ", accountId=" + this.getAccountId() + ", policyId=" + this.getPolicyId() + ")";
//    }
}
