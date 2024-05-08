package com.c4hco.test.automation.pages.API;
import com.c4hco.test.automation.utils.ApplicationProperties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import static io.restassured.RestAssured.*;

public class APTCCalculator {
    String base_url;
    JSONObject requestBody= new JSONObject();
    Response response ;
    SoftAssert softAssert= new SoftAssert();

    public void getAPIEnvConnection(){
        if(ApplicationProperties.getInstance().getProperty("env").equals("staging")){
            base_url="http://localhost:8090/calculateaptc";
        }else{
            base_url="https://qa-aws.connectforhealthco.com/aptc-calculator-service/calculateaptc";
        }
    }
    public void sendTheHouseholdInformation(String income, String zipCode, String fipsCode, String fpl, String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String effectiveDate = LocalDate.now().format(formatter);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", income);
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
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void sendAPTCCalculatorRequest(){
        response= given().log().body()
                .header("Content-Type", "application/json")
                .header("cf-access-token", ApplicationProperties.getInstance().getProperty("apiToken"))
           .and()
                .body(requestBody.toString())
           .when()
                .post(base_url).prettyPeek();

    }

    public void validateStatusCodeAndContentType(int expectedStatus) {
        softAssert.assertEquals(response.getStatusCode(),expectedStatus);
        softAssert.assertEquals(response.getContentType(), "application/json");
        softAssert.assertAll();
    }

    public void expectedAPTCContributionAmount(String expectedAPTC, String contribution) {
        JsonPath jsonPath = response.jsonPath();
        softAssert.assertEquals(jsonPath.getString("taxHousehold.monthlyAPTCAmount"),"["+expectedAPTC+"]");
        softAssert.assertEquals(jsonPath.getString("taxHousehold.aptcApplicablePercentage"),"["+contribution+"]");
        softAssert.assertAll();
    }


}
