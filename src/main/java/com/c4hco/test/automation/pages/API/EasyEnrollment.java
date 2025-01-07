package com.c4hco.test.automation.pages.API;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import org.testng.asserts.SoftAssert;

public class EasyEnrollment {

    String base_url;
    JSONObject requestBody= new JSONObject();
    Response response ;
    SoftAssert softAssert= new SoftAssert();

    public void getDORToC4APIEnvConnection() {
        if (ApplicationProperties.getInstance().getProperty("env").equals("staging")) {
            base_url = "https://staging-aws.connectforhealthco.com/easy-enrollment-portal-services/dor-tax-household";
        } else {
            base_url = "https://qa-aws.connectforhealthco.com/easy-enrollment-portal-services/dor-tax-household";
        }
    }

    public void dorToC4APIDataRequest(String adjustedGrossIncome, String emailAddress, String filedByDeadline, String filingType, String firstName, String householdSize, String lastName, String mailingAddressLine1, String zipCode, String middleInitial, String phoneNumber, String dateOfBirth, String ssn) {

        if (emailAddress.equals("random_email")) {
            emailAddress = "AutomationUser" + System.currentTimeMillis() + "@test.com";
        }

        if (ssn.equals("random")) {
            ssn = "8" + String.valueOf(100000000 + (long) (Math.random() * 900000000));
        }

        requestBody.put("adjustedGrossIncome", adjustedGrossIncome);
        requestBody.put("emailAddress", emailAddress);
        requestBody.put("filedByDeadline", filedByDeadline);
        requestBody.put("filingType", filingType);
        requestBody.put("firstName", firstName);
        requestBody.put("householdSize", householdSize);
        requestBody.put("lastName", lastName);
        requestBody.put("mailingAddressCity", "Denver");
        requestBody.put("mailingAddressLine1", mailingAddressLine1);
        requestBody.put("mailingAddressLine2", "");
        requestBody.put("mailingAddressState", "CO");
        requestBody.put("mailingAddressZip", zipCode);
        requestBody.put("middleInitial", middleInitial);
        requestBody.put("phoneNumber", phoneNumber);

        Map<String, Object> taxHouseholdMember = new LinkedHashMap<>();
        taxHouseholdMember.put("dateOfBirth", dateOfBirth);
        taxHouseholdMember.put("firstName", firstName);
        taxHouseholdMember.put("lastName", lastName);
        taxHouseholdMember.put("middleInitial", middleInitial);
        taxHouseholdMember.put("ssn", ssn);

        requestBody.put("taxHouseholdMembers", Arrays.asList(taxHouseholdMember));

        requestBody.put("taxpayerKey", String.valueOf(System.currentTimeMillis()));
        requestBody.put("year", "2023");

        System.out.println("Request Body: " + requestBody.toString());
    }
    public void dorForTaxHousehold(String adjustedGrossIncome, String emailAddress, String filedByDeadline, String filingType, String firstName, String householdSize, String lastName,String mailingAddressLine1, String mailingAddressLine2, String city,String zipCode, String middleInitial, String phoneNumber,  String dateOfBirth, String ssn, String year){
        requestBody.put("adjustedGrossIncome", adjustedGrossIncome);
        requestBody.put("emailAddress", emailAddress);
        requestBody.put("filedByDeadline", filedByDeadline);
        requestBody.put("filingType", filingType);
        requestBody.put("firstName", firstName);
        requestBody.put("householdSize", householdSize);
        requestBody.put("lastName", lastName);
        requestBody.put("mailingAddressCity", city);
        requestBody.put("mailingAddressLine1", mailingAddressLine1);
        requestBody.put("mailingAddressLine2", mailingAddressLine2);
        requestBody.put("mailingAddressState", "CO");
        requestBody.put("mailingAddressZip", zipCode);
        requestBody.put("middleInitial", middleInitial);
        requestBody.put("phoneNumber", phoneNumber);

        Map<String, Object> taxHouseholdMember = new LinkedHashMap<>();
        taxHouseholdMember.put("dateOfBirth", dateOfBirth);
        taxHouseholdMember.put("firstName", firstName);
        taxHouseholdMember.put("lastName", lastName);
        taxHouseholdMember.put("middleInitial", middleInitial);
        taxHouseholdMember.put("ssn", ssn);

        requestBody.put("taxHouseholdMembers", Arrays.asList(taxHouseholdMember));
        String taxpayerkey = String.valueOf(System.currentTimeMillis());
        requestBody.put("taxpayerKey", taxpayerkey);
        requestBody.put("year", year);
        SharedData.setPrimaryTaxPayerKey(taxpayerkey);
        System.out.println("Request Body: " + requestBody.toString());
    }

    public void sendDorToC4DataRequest() {
        response = given().log().body()
                .header("Content-Type", "application/json")
                .header("cf-access-token", ApplicationProperties.getInstance().getProperty("apiToken"))
                .and()
                .body(requestBody.toString())
                .when()
                .post(base_url).prettyPeek();
        String apiToken = ApplicationProperties.getInstance().getProperty("apiToken");
        System.out.println("API Token: " + apiToken);
    }

    public void validateStatusCodeAndContentType(int expectedStatus) {
        if (response != null) {
            softAssert.assertEquals(response.getStatusCode(), expectedStatus);
            softAssert.assertEquals(response.getContentType(), "application/json");
        } else {
            softAssert.fail("Response is null");
        }
        softAssert.assertAll();
    }

    public void validateValidationMessage(String expectedMessage) {
        JsonPath jsonPath = response.jsonPath();
        softAssert.assertEquals(jsonPath.getString("validationMessages"), expectedMessage, "Validation message for SSN does not match the expected message.");
        softAssert.assertAll();
    }
}
