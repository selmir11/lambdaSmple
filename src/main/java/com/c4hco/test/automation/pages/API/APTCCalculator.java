package com.c4hco.test.automation.pages.API;
import com.c4hco.test.automation.utils.ApplicationProperties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import java.util.*;
import static io.restassured.RestAssured.*;

public class APTCCalculator {
    String base_url;
    JSONObject requestBody= new JSONObject();
    Response response ;
    SoftAssert softAssert= new SoftAssert();
    String effectiveDate = "2025-01-01";

    public void getAPIEnvConnection(){
        if(ApplicationProperties.getInstance().getProperty("env").equals("staging")){
            base_url="http://localhost:8090/calculateaptc";
        }else{
            base_url="https://qa-aws.connectforhealthco.com/aptc-calculator-service/calculateaptc";
        }
    }

    private List<Map<String, Object>> createHouseholdMembers(List<String> datesOfBirth, String zipCode, String fipsCode) {
        List<Map<String, Object>> householdMembers = new ArrayList<>();
        for (int i = 0; i < datesOfBirth.size(); i++) {
            int finalI = i;
            householdMembers.add(new LinkedHashMap<String, Object>() {
                {
                    put("personID", String.valueOf(finalI + 1));
                    put("applyingForCoverageIndicator", "true");
                    put("aptcEligibleIndicator", "true");
                    put("dateOfBirth", datesOfBirth.get(finalI));
                    put("memberZipCode", zipCode);
                    put("memberCountyFIPSCode", fipsCode);
                }
            });
        }
        return householdMembers;
    }

    public void buildSingleMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth) {
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
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
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }
    public void buildTwoMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildThreeMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildFourMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildFiveMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildSixMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildSevenMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildEightMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7, String dateOfBirth8) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7, dateOfBirth8);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildNineMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7, String dateOfBirth8, String dateOfBirth9) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7, dateOfBirth8, dateOfBirth9);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildTenMemberTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5, String dateOfBirth6, String dateOfBirth7, String dateOfBirth8, String dateOfBirth9, String dateOfBirth10) {
        List<String> datesOfBirth = Arrays.asList(dateOfBirth, dateOfBirth2, dateOfBirth3, dateOfBirth4, dateOfBirth5, dateOfBirth6, dateOfBirth7, dateOfBirth8, dateOfBirth9, dateOfBirth10);
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "004");
                put("magiAmount", magi);
                put("householdSize", String.valueOf(datesOfBirth.size()));
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl);
                put("householdMember", createHouseholdMembers(datesOfBirth, zipCode, fipsCode));
            }
        }));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildTwoMemberDifferentZipTaxHouseholdRequest(String magi, String zipCode, String fipsCode, String zipCode2, String fipsCode2, String fpl, String dateOfBirth, String dateOfBirth2) {
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
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
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "2");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth2);
                        put("memberZipCode", zipCode2);
                        put("memberCountyFIPSCode", fipsCode2);
                    }
                }));
            }}));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildTwoTaxHouseHoldOneTwoMember(String magi, String magi2, String zipCode, String fipsCode, String fpl, String fpl2, String dateOfBirth, String dateOfBirth2, String dateOfBirth3) {
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "001");
                put("magiAmount", magi);
                put("householdSize", "2");
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
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "2");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth2);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }},new LinkedHashMap<String, Object>(){
            {
                put("taxHouseholdID", "002");
                put("magiAmount", magi2);
                put("householdSize", "1");
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl2);
                put("householdMember", Arrays.asList(new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "3");
                        put("applyingForCoverageIndicator", "true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth3);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildTwoTHHTHH1ThreeMemberOneNotAPTCTHH2OneMemberNotAPTC(String magi, String magi2, String zipCode, String fipsCode, String fpl, String fpl2, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4) {
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "001");
                put("magiAmount", magi);
                put("householdSize", "2");
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
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "2");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth2);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "3");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth3);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}, new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "002");
                put("magiAmount", magi2);
                put("householdSize", "1");
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl2);
                put("householdMember", Arrays.asList(new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "4");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "false");
                        put("dateOfBirth", dateOfBirth4);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildTwoTHHTHH1ThreeMemberOneNotAPTCTHH2OneMember(String magi, String magi2, String zipCode, String fipsCode, String fpl, String fpl2, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4) {
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "001");
                put("magiAmount", magi);
                put("householdSize", "2");
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
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "2");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth2);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "3");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth3);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}, new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "002");
                put("magiAmount", magi2);
                put("householdSize", "1");
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl2);
                put("householdMember", Arrays.asList(new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "4");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth4);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}));
        requestBody.put("eligibilityPurpose", "INITIAL_DETERMINATION");
    }

    public void buildThreeTHHTHH1ThreeMemberTHH2OneMemberTHH3OneMember(String magi, String magi2, String magi3, String zipCode, String fipsCode, String fpl, String fpl2, String fpl3, String dateOfBirth, String dateOfBirth2, String dateOfBirth3, String dateOfBirth4, String dateOfBirth5) {
        requestBody.put("taxHousehold", Arrays.asList(new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "001");
                put("magiAmount", magi);
                put("householdSize", "2");
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
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "2");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth2);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }, new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "3");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth3);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}, new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "002");
                put("magiAmount", magi2);
                put("householdSize", "1");
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl2);
                put("householdMember", Arrays.asList(new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "4");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth4);
                        put("memberZipCode", zipCode);
                        put("memberCountyFIPSCode", fipsCode);
                    }
                }));
            }}, new LinkedHashMap<String, Object>() {
            {
                put("taxHouseholdID", "003");
                put("magiAmount", magi3);
                put("householdSize", "1");
                put("householdZipCode", zipCode);
                put("householdCountyFIPSCode", fipsCode);
                put("coverageEffectiveDate", effectiveDate);
                put("fplPercentage", fpl3);
                put("householdMember", Arrays.asList(new LinkedHashMap<String, Object>() {
                    {
                        put("personID", "5");
                        put("applyingForCoverageIndicator","true");
                        put("aptcEligibleIndicator", "true");
                        put("dateOfBirth", dateOfBirth5);
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
