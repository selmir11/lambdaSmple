package com.c4hco.test.automation.database.DbValidations;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.DbData;
import com.c4hco.test.automation.database.EntityObj.PlanDbData;
import com.c4hco.test.automation.database.EntityObj.PolicyTablesEntity;
import com.c4hco.test.automation.database.dbDataProvider.DbDataProvider_Exch;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PolicyDbValidations_new {
    DbDataProvider_Exch exchDbDataProvider = new DbDataProvider_Exch();
    SoftAssert softAssert = new SoftAssert();

    public void policyRecordValidations() {
        setData();

        List<PolicyTablesEntity> policyEntities = SharedData.getPolicyTablesEntities();
        DbData dbData = SharedData.getDbData();
        PlanDbData medicalPlanDbData = SharedData.getMedicalPlanDbData().get("group1");

        for (PolicyTablesEntity policyTablesEntity : policyEntities) {
            if (policyTablesEntity.getSubscriber_ind().equals("1")) {
                setPlanPremiumAmt(policyTablesEntity, medicalPlanDbData); // works for one group
                validateSubscriberMedDetails(policyTablesEntity);
            } else {
                validateDependentMedDetails(policyTablesEntity);
            }
            medValidationsCommonForAllMembers(policyTablesEntity, dbData, medicalPlanDbData);
        }

    }

    private void validateDependentMedDetails(PolicyTablesEntity policyTablesEntity){
        List<MemberDetails> members = SharedData.getMembers();
        for(MemberDetails member: members){
            if(member.getFirstName().equals(policyTablesEntity.getFirst_name())){
                System.out.println("NAME OF DEPENDENT::::"+member.getFirstName());
                softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), member.getRelation_to_subscriber(), "Relationship to subscriber does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), member.getMedicalPremiumAmt(), "Medical Policy total plan premium amount does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), SharedData.getPrimaryMember().getFinancialHelp() ? policyTablesEntity.getTotal_premium_reduction_amt() : member.getMedicalAptcAmt() + ".00", "Subscriber Medical APTC amount does not match");
                softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()),SharedData.getPrimaryMember().getFinancialHelp() ? "APTC" : "null", "Subscriber Medical Policy premium reduction type does not match");
                softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()),  SharedData.getPrimaryMember().getFinancialHelp() ? "APTC" : "null", "premium reduction type in en policy financial ah table does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), member.getTotalMedAmtAfterReduction(), "--Medical Policy total responsible amount does not match");
                softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Medical Policy total CSR amount does not match");
                softAssert.assertAll();
            }
        }
    }

    private void validateSubscriberMedDetails(PolicyTablesEntity policyTablesEntity) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        softAssert.assertEquals(policyTablesEntity.getRelation_to_subscriber(), "SELF", "Relationship to subscriber does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_plan_premium_amt(), subscriber.getMedicalPremiumAmt(), "Medical Policy total plan premium amount does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_premium_reduction_amt(), subscriber.getFinancialHelp() ? policyTablesEntity.getTotal_premium_reduction_amt() : subscriber.getMedicalAptcAmt() + ".00", "Subscriber Medical APTC amount does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_emcfh()), subscriber.getFinancialHelp() ? "APTC" : "null", "Subscriber Medical Policy premium reduction type does not match");
        softAssert.assertEquals(String.valueOf(policyTablesEntity.getPremium_reduction_type_epfh()),  subscriber.getFinancialHelp() ? "APTC" : "null", "premium reduction type in en policy financial ah table does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_responsible_amt(), subscriber.getTotalMedAmtAfterReduction(), "--Medical Policy total responsible amount does not match");
        softAssert.assertEquals(policyTablesEntity.getTotal_csr_amt(), "0.00", "Medical Policy total CSR amount does not match");
        softAssert.assertAll();
        System.out.println("***********************SUBSCRIBER MED DETAILS PASSED****************************");
    }

    private void medValidationsCommonForAllMembers(PolicyTablesEntity policyTablesEntity, DbData dbData, PlanDbData medicalPlanDbData) {
        softAssert.assertEquals(policyTablesEntity.getHios_plan_id(), medicalPlanDbData.getBaseId() + "-" + dbData.getCsrLevel(), "Hios id does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_start_date(), SharedData.getExpectedCalculatedDates().getPolicyStartDate(), "Coverage type 1, Policy start date does not match");
        softAssert.assertEquals(policyTablesEntity.getPolicy_end_date(), SharedData.getExpectedCalculatedDates().getPolicyEndDate(), "Coverage type 1, Policy end date does not match");

        softAssert.assertEquals(policyTablesEntity.getCoverage_start_date(), SharedData.getExpectedCalculatedDates().getCoverageStartDate(), "policy member coverage start date does not match");
        softAssert.assertEquals(policyTablesEntity.getCoverage_end_date(), SharedData.getExpectedCalculatedDates().getCoverageEndDate(), "policy member coverage end date does not match");

        softAssert.assertEquals(policyTablesEntity.getFinancial_period_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Medical financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getFinancial_period_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Medical financial end date does not match");

        softAssert.assertEquals(policyTablesEntity.getMember_financial_start_date(), SharedData.getExpectedCalculatedDates().getFinancialStartDate(), "Medical member financial start date does not match");
        softAssert.assertEquals(policyTablesEntity.getMember_financial_end_date(), SharedData.getExpectedCalculatedDates().getFinancialEndDate(), "Medical member financial end date does not match");
        softAssert.assertAll();
    }

    private void setData(){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<PolicyTablesEntity> policyEntities = exchDbDataProvider.getMedicalRecordsDataFromPolicyTables();
        SharedData.setPolicyTablesEntities(policyEntities);
        exchDbDataProvider.setDataFromDb();
        exchDbDataProvider.setMedicalPlanDataFromDb(SharedData.getPrimaryMember().getMedicalPlan()); // Works for one group
        if(SharedData.getScenarioDetails().getTotalMembers()>1){
            List<MemberDetails> memberDetailsList =  SharedData.getMembers();
            for(MemberDetails member: memberDetailsList){
                exchDbDataProvider.setExchPersonId(member, member.getMemberId());
            }
        }
        exchDbDataProvider.setExchPersonId(subscriber, subscriber.getMemberId());
    }

    private void setPlanPremiumAmt(PolicyTablesEntity policyTablesEntity, PlanDbData medicalPlanDbData) {
        // To compare with ob834 entities
        // WIP - set from UI if possible
            medicalPlanDbData.setPremiumAmt(policyTablesEntity.getPlan_premium_amt());
            SharedData.getMedicalPlanDbData().put("group1", medicalPlanDbData);
    }


}
