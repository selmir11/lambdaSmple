package com.c4hco.test.automation.pages.API;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.*;
import org.testng.asserts.SoftAssert;

public class EasyEnrollment {

    String base_url;
    JSONObject requestBody = new JSONObject();
    Response response;
    SoftAssert softAssert = new SoftAssert();
    BasicActions basicActions = new BasicActions();
    private Map<String, Object> payloadMap;
    String memberLastName;


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

        if (emailAddress.equals("random_email")) {
            emailAddress = "AutomationUser" + System.currentTimeMillis() + "@test.com";
        }

        if (ssn.equals("random")) {
            ssn = String.valueOf(100000000 + (long) (Math.random() * 900000000));
        }

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
    public void dorForSingleTaxHousehold(String adjustedGrossIncome, String filedByDeadline, String filingType, String householdSize, String mailingAddressLine1, String city,String zipCode, String middleInitial, String phoneNumber,  String dateOfBirth, String ssn, String year){
        requestBody.put("adjustedGrossIncome", adjustedGrossIncome);

        requestBody.put("filedByDeadline", filedByDeadline);
        requestBody.put("filingType", filingType);
        requestBody.put("firstName", SharedData.getPrimaryMember().getFirstName());
        requestBody.put("householdSize", householdSize);
        requestBody.put("lastName", SharedData.getPrimaryMember().getLastName());
        requestBody.put("mailingAddressCity", city);
        requestBody.put("mailingAddressLine1", mailingAddressLine1);

        requestBody.put("mailingAddressState", "CO");
        requestBody.put("mailingAddressZip", zipCode);
        requestBody.put("middleInitial", middleInitial);
        requestBody.put("phoneNumber", phoneNumber);

        Map<String, Object> taxHouseholdMember = new LinkedHashMap<>();
        taxHouseholdMember.put("dateOfBirth", dateOfBirth);
        taxHouseholdMember.put("firstName", SharedData.getPrimaryMember().getFirstName());
        taxHouseholdMember.put("lastName", SharedData.getPrimaryMember().getLastName());
        taxHouseholdMember.put("middleInitial", middleInitial);
        taxHouseholdMember.put("ssn", ssn);

        requestBody.put("taxHouseholdMembers", Arrays.asList(taxHouseholdMember));
        String taxpayerkey = String.valueOf(System.currentTimeMillis());
        requestBody.put("taxpayerKey", taxpayerkey);
        requestBody.put("year", year);
        SharedData.setPrimaryTaxPayerKey(taxpayerkey);
        System.out.println("Request Body: " + requestBody.toString());
    }

    public void isendAPIPayload(DataTable dataTable) {
        payloadMap = new HashMap<>();
        dataTable.asMaps().forEach(row -> {

            String key = row.get("key");
            String value = row.get("value");
            String taxpayerkey = String.valueOf(System.currentTimeMillis());
            if("<PrimFName>".equals(value)){
               value = SharedData.getPrimaryMember().getFirstName();
            }else if("<PrimLName>".equals(value)){
                value = SharedData.getPrimaryMember().getLastName();
            }else if("<PrimEmail>".equals(value)){
                value = SharedData.getPrimaryMember().getEmailId();
            }else if("<Random>".equals(value)) {
                value = "LastN"+generateRandomString(5);
                memberLastName = value;
            }else if ("<taxpayerKey>".equals(value)){
                value = taxpayerkey;
                SharedData.setPrimaryTaxPayerKey(taxpayerkey);
            }
            else if ("<RandomPhone>".equals(value)) {
                value = "732" + (int)(Math.random() * 9000000 + 1000000);;
            } else if ("<RandomSSN>".equals(value)) {
                value = generateRandomSSN();
            } else if ("null".equals(value)) {
                value = null;
            }
            requestBody.put(key, value);
        });
    }
    public void payloadForAdditionalTaxHouseholdMem(DataTable dataTable){
        List<Map<String, Object>> taxHouseholdMembers = new ArrayList<>();


        dataTable.asMaps().forEach(row -> {
            LocalDate date = LocalDate.now().minusDays(5);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
            String todayDate = date.format(formatter);

            Map<String, Object> member = new HashMap<>();
            row.forEach((key, value) -> {
                if("<PrimFName>".equals(value)){
                    value = SharedData.getPrimaryMember().getFirstName();
                }else if("<PrimLName>".equals(value)){
                    value = SharedData.getPrimaryMember().getLastName();
                }else if("<RandomLastName>".equals(value)) {
                    value = memberLastName;
                }else if("<Random>".equals(value)){
                    value = generateRandomString(5);
                }
                else if ("<PrimSSN>".equals(value)) {
                    value = SharedData.getPrimaryMember().getSsn();
                } else if ("null".equals(value)) {
                    value = null;
                }else if("<CurrentDate>".equals(value)){
                    value = todayDate;
                    System.out.println("DOB: "+ value);
                }else if("<RandomSSN>".equals(value)){
                    value = generateRandomSSN().replace("-","");
                }
                member.put(key, value);
            });
            taxHouseholdMembers.add(member);
        });

        requestBody.put("taxHouseholdMembers", taxHouseholdMembers);

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
        System.out.println(response);
    }

    public void validateValidationMessage(String expectedMessage) {
        JsonPath jsonPath = response.jsonPath();
        softAssert.assertEquals(jsonPath.getString("validationMessages"), expectedMessage, "Validation message for SSN does not match the expected message.");
        softAssert.assertAll();
    }
    private String generateRandomString(int length) {
       return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }
    private String generateRandomSSN() {
        return (int)(Math.random() * 900 + 100) + "-"+
                (int)(Math.random() * 90 + 10) + "-"+
                (int)(Math.random() * 9000 + 1000);
    }

}
