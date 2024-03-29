package com.c4hco.test.automation.Dto;

import com.c4hco.test.automation.database.EntityObj.MultipleTablesEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberDetails {
    String firstName;
    String lastName;
    String middleName;
    String emailId;
    String password = "ALaska12!";
    String phoneNumber;
    String ssn;
    String relation_to_subscriber;
    String signature;
    String fullName;
    String dob;
    String zipcode;
    String mailingAddress;
    String mailingZipCode;
    ResidentialAddress resAddress;
    String gender;
    String medicalPlan;
    String medicalPlanStartDate;
    String medicalPlanEndDate;
    String dentalPlan;
    String dentalPlanStartDate;
    String dentalPlanEndDate;
    String financialStartDate;
    String medicalPremiumAmt;
    String dentalPremiumAmt;
    String aptcAmt;
    String tobacco_user;
    String application_id;
    BigDecimal account_id;
    String policyId;

    public Boolean compareWithCombinedQueryData(MultipleTablesEntity multipleTablesEntity) {
        // TO DO:: Add more fields to this
        return String.valueOf(this.account_id).equals(multipleTablesEntity.getAccount_id()) &&
                this.firstName.equals(multipleTablesEntity.getFirst_name()) &&
                this.lastName.equals(multipleTablesEntity.getLast_name()) &&
                this.emailId.equals(multipleTablesEntity.getPolicy_submitted_by()) &&
                this.relation_to_subscriber.equals(multipleTablesEntity.getRelation_to_subscriber());
    }

}
