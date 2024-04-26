package com.c4hco.test.automation.pages.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class APTCCalculator {

    public void SendAPTCRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String expectedAPTC, String contribution){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String effectiveDate = LocalDate.now().format(formatter);

        RestAssured.baseURI = "https://qa-aws.connectforhealthco.com/aptc-calculator-service/calculateaptc";

        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("cf-access-token", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQ1MDU4M2Y5MDM5MTgyODhkZjVlMmYzMzNiOGRkMmMxZDcwM2VjMGRjYzA0NmZiOTVjOWZlYjIxZjdlMDhiOGMifQ.eyJhdWQiOlsiMGZiYTdkOTgxNDZjYzEyZTJhNDlhOGVjYThjMzY3MmM0OGQwZjkyYjIzMzI4YWFhYmViODQ0MTk1NTRiNmU4YyJdLCJlbWFpbCI6ImpqZW5raW5zQGM0aGNvLmNvbSIsImV4cCI6MTY0MTkzODE4NCwiaWF0IjoxNjQxODUxNzg0LCJuYmYiOjE2NDE4NTE3ODQsImlzcyI6Imh0dHBzOi8vYzRoY28uY2xvdWRmbGFyZWFjY2Vzcy5jb20iLCJ0eXBlIjoiYXBwIiwiaWRlbnRpdHlfbm9uY2UiOiJpU1ZuNUNlN2Y0NGhzWlE3Iiwic3ViIjoiODRmZmNkYWUtYzM5My00MTZlLWJiNzktZjc3NWNiOTE2MzRjIiwiY291bnRyeSI6IlVTIn0.gEuYIypNI0efkiyVl0BZc9fgvTfObfMhloPbMmFGkcLwJIwMqlI2w-B_iZJyBAwosBiTMOyFC66Myfh1NH2Eh3tpszW6HnwHlMjU14JQMJp1pY0Puc8HxniD8PWm6BR9qR7ZROe1IYBw9MAKffq68KDKCzgpG_GyJAUUhiBzSZItHPrMEi3E3N0Wvv6k61Km_0Jp6hA4F5qWkHRY0X_EQlNrFXfoummO4xuUzc_krzGJ9j_z-wd7AcTIbCFDGfXjYb6kAPahjXUxyy9qNkLgTQ280DU7NLbwEyJ5dAlEq9lw-fETL439gnV9ssSJfg6AUE2p6ZAgiN1oweBb96ltYQ");

        JSONObject map = new JSONObject();
        map.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", "1");
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", Arrays.asList(new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "1");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}));
        map.put("eligibilityPurpose", "INITIAL_DETERMINATION");

        request.body(map.toString());
        System.out.println("Request: "+ map.toString()); //For Debugging

        Response response = request.post();

        int statusCode = response.getStatusCode();
        String responseText = response.asString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200);
        softAssert.assertTrue(responseText.contains("\"monthlyAPTCAmount\":"+expectedAPTC));
        softAssert.assertTrue(responseText.contains("\"aptcApplicablePercentage\":"+contribution));
        softAssert.assertAll();

        System.out.println("Response: "+ response.asString()); //For Debugging
    }
}
