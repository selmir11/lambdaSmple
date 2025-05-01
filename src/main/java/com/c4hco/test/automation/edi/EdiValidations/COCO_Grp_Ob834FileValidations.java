package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Edi834.Member;
import com.c4hco.test.automation.Dto.Edi.Edi834.Transaction;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import com.c4hco.test.automation.utils.BasicActions;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class COCO_Grp_Ob834FileValidations {


    List<String> n1ListWithSepReason;
    List<String> n1ListWithAddtlMaintReas;
    List<String> n1ListWithSepReasonMem;
    List<String> n1ListWithAddtlMaintReasMem;
    List<Ob834DetailsEntity> subscriberMedEntities = new ArrayList<>();
    Edi834TransactionDetails edi834TransactionDetails = new Edi834TransactionDetails();
    List<Transaction> transactionsList = new ArrayList<>();
    BasicActions basicActions = new BasicActions();
    List<Ob834DetailsEntity> entityWithFileName = new ArrayList<>();;
    int segCount = 0;

    SoftAssert softAssert = new SoftAssert();

    public void validateOb834MedFile(String medFileName) {
        resetAllEntities();
        setN1SegList();
        List<Ob834DetailsEntity> medicalEntityList = SharedData.getOb834DetailsMedEntities();
        for(Ob834DetailsEntity entiti : medicalEntityList){
           if(entiti.getFilename().equals(medFileName)){
               entityWithFileName.add(entiti);
           }
        }
        getSubscriberEntities(medFileName);
        getDataByEmailAndAccNum();
        segCount = 0;
        validateCtrlFnGrpSegment(subscriberMedEntities.get(0));
        validateSubscriberSegments(subscriberMedEntities);
        validateMemSeg(entityWithFileName);
        validateSegCount();
    }

    private void validateSegCount() {
        int transSegCount=0;
        String seSeg;
        for(Transaction transaction: transactionsList){
            seSeg = transaction.getCommonSegments().getSE().get(0).get(0);
            transSegCount = transSegCount + Integer.parseInt(seSeg);
        }
        softAssert.assertEquals(transSegCount, segCount, "Total number of segments included in a transaction set including ST and SE segments does not match");
        softAssert.assertAll();
    }

    private void resetAllEntities(){
        subscriberMedEntities = new ArrayList<>();
        edi834TransactionDetails = new Edi834TransactionDetails();
        transactionsList = new ArrayList<>();
        n1ListWithSepReason = new ArrayList<>();
        n1ListWithAddtlMaintReas = new ArrayList<>();
        n1ListWithSepReasonMem = new ArrayList<>();
        n1ListWithAddtlMaintReasMem = new ArrayList<>();
        entityWithFileName = new ArrayList<>();
    }

    private void validateMemSeg(List<Ob834DetailsEntity> entityList) {
        for (Ob834DetailsEntity entity : entityList) {
            for (Transaction transaction : transactionsList) {
                List<Member> memberSegmentsList = transaction.getMembersList();
                for (Member member : memberSegmentsList) {
                    if (entity.getMember_first_name().contains(member.getNM1().get(0).get(3))) {
                        System.out.println("validating the member segments for :::::::::::::" + member.getNM1().get(0).get(3));
                        validateSegments(member, entity);
                        if(!(entity.getResponsible_person_rel_code() == null)){
                            validatePerSeg(entity, member);
                            nm1MinorSubs(member, entity);
                        }
                        break;
                    }
                }
            }
        }
    }

    private void validateSegments(Member member, Ob834DetailsEntity entry) {
        validateDMGSegment(member, entry);
        validateHLHSeg(member, entry);
        validateInsSegment(member, entry);
        validateNM1Seg(member, entry);
        validateHierarchyLevelSeg(member, entry);
        validateAddlMaintReason(member, entry);
        validateDtpSegment(member, entry);
        validateMemberRefSeg(member, entry);
        validateLSLESegment(member);
        validateLxRefN1Segment(member, entry);
        softAssert.assertAll();
    }

    private void validateMemberRefSeg(Member member, Ob834DetailsEntity entry) {
        List<List<String>> refSegListOfList = member.getREF();
        for (List<String> refSegList : refSegListOfList) {
            if (refSegList.size() == 2) {
                switch (refSegList.get(0)) {
                    case "0F":
                        softAssert.assertEquals(refSegList.get(1), entry.getSubscriber_id(), "REF 0F segment mismatch");
                        break;
                    case "17":
                        softAssert.assertEquals(refSegList.get(1), entry.getMember_id(), "REF 17 segment mismatch");
                        break;
                    case "6O":
                        softAssert.assertEquals(refSegList.get(1), entry.getAccount_id(), "REF 6O segment mismatch");
                        break;
                    case "1L":
                        softAssert.assertEquals(refSegList.get(1), entry.getEap_id(), "REF 1L segment mismatch");
                        break;
                    case "CE":
                        softAssert.assertEquals(refSegList.get(1), entry.getHios_plan_id() + entry.getCsr_level(), "REF CE segment mismatch");
                        break;
                    case "E8":
                        softAssert.assertEquals(refSegList.get(1), "COCO", "REF E8 segment mismatch");
                        break;
                    default:
                        Assert.fail("Incorrect Case for Member REF Seg - Non LS loop::" + refSegList.get(0));
                }

            }
        }
        softAssert.assertAll();
    }

    private void validateLxRefN1Segment(Member member, Ob834DetailsEntity entry) {
        List<List<String>> lxSegment = member.getLX();
        List<List<String>> n1SegListOfList = member.getN1();
        List<List<String>> refSegListOfList = member.getREF();
        List<String> n1SegList = new ArrayList<>();

        int lxSegCount = 1;

        if (member.getINS().get(0).get(0).equals("Y")) {
            if (entry.getAddl_maint_reason() != null && entry.getAddl_maint_reason().contains("|")) {
                softAssert.assertEquals(lxSegment.size(), 9, "LX Seg size is not equals to 8 for subscriber"); // size of addtl Maint Reasons - WIP
            } else {
                softAssert.assertEquals(lxSegment.size(), 8, "LX Seg size is not equals to 8 for subscriber");
            }
        } else if(SharedData.getPrimaryMember().getIsProfileChange()&& entry.getAddl_maint_reason().contains("|")){
            // For SLER-1235 - rating area update. Works for one group
            softAssert.assertEquals(lxSegment.size(), 3, "LX Seg size is not equals to 3 for member");
        }else {
            softAssert.assertEquals(lxSegment.size(), 2, "LX Seg size is not equals to 2 for member");
        }
        softAssert.assertEquals(lxSegment.size(), n1SegListOfList.size(), "LX seg size is not equal to n1seg size within LS loop for this member");

        for (List<String> lxSeg : lxSegment) {
            Assert.assertEquals(String.valueOf(lxSeg.get(0)).replaceAll(String.valueOf(lxSegCount), ""), "LX");
            Assert.assertEquals(Integer.parseInt(lxSeg.get(1)), lxSegCount, "lxSeg.get(1)::" + lxSeg.get(1) + "  lxSegCount::" + lxSegCount);

            for (List<String> n1SegLst : n1SegListOfList) {
                if (String.valueOf(n1SegLst.get(0)).equals("LX" + lxSegCount)) {
                    Assert.assertEquals(String.valueOf(n1SegLst.get(1)), "75");
                    n1SegList.add(n1SegLst.get(3));
                    break;
                }
            }

            for (List<String> refSegList : refSegListOfList) {
                if (String.valueOf(refSegList.get(0)).equals("LX" + lxSegCount)) {
                    if (entry.getAddl_maint_reason() == null && entry.getSep_reason() != null) {
                        validateLxWithSepReason(lxSegCount, refSegList, entry, member);
                    } else {
                        validateWithoutSepReasn(lxSegCount, refSegList, entry, member);
                    }
                    break;
                }
            }
            lxSegCount++;
        }
        segCount = segCount + (lxSegCount - 1) + n1SegListOfList.size();
        validateMemN1Seg(entry, n1SegList);
    }

    private void validateMemN1Seg(Ob834DetailsEntity entry, List<String> n1SegList) {
        List<String> expectedN1List;

        if (entry.getSubscriber_indicator().equals("Y")) {
            expectedN1List = (entry.getAddl_maint_reason() == null && entry.getSep_reason() != null) ? n1ListWithSepReason : getN1ListWithAddlMaintReas(entry);
        } else {
            expectedN1List = (entry.getAddl_maint_reason() == null && entry.getSep_reason() != null) ? n1ListWithSepReasonMem : getN1ListWithAddlMaintReasMem(entry);
        }
        Assert.assertEquals(n1SegList, expectedN1List);
    }

    private List<String> getN1ListWithAddlMaintReas(Ob834DetailsEntity entry) {
        if (entry.getAddl_maint_reason().contains("|")) {
            n1ListWithAddtlMaintReas.add(0, "ADDL MAINT REASON");
        }
        return n1ListWithAddtlMaintReas;
    }

    private List<String> getN1ListWithAddlMaintReasMem(Ob834DetailsEntity entry) {
        if (entry.getAddl_maint_reason().contains("|")&&SharedData.getPrimaryMember().getIsProfileChange()) {
            n1ListWithAddtlMaintReasMem.add(0, "ADDL MAINT REASON");
        }
        return n1ListWithAddtlMaintReasMem;
    }

    private void validateLxWithSepReason(int lxSegCount, List<String> refSegList, Ob834DetailsEntity entry, Member member) {
        if (member.getINS().get(0).get(0).equals("Y")) {
            switch ("LX" + lxSegCount) {
                case "LX1":
                    // segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                    break;
                case "LX2":
                    //  segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_reduction_amt()), "LX" + lxSegCount + " did not match");
                    break;
                case "LX3":
                    //  segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getCsr_amount()), "LX" + lxSegCount + " did not match");
                    break;
                case "LX4":
                    //  segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getRate_area()), "LX" + lxSegCount + " did not match");
                    break;
                case "LX5":
                    // segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals("COCO"), "LX" + lxSegCount + " did not match");
                    break;
                case "LX6":
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getTotal_responsible_amount()));
                    break;
                case "LX7":
                    // segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getTotal_premium_amount()), "LX" + lxSegCount + " did not match");
                    break;
                case "LX8":
                    // segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getSep_reason()), "LX" + lxSegCount + " did not match");
                    break;
                default:
                    Assert.fail("Incorrect LX Case");
            }
        } else {
            // member
            switch ("LX" + lxSegCount) {
                case "LX1":
                    // segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                    break;
                case "LX2":
                    // segCount = segCount+1;
                    softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getSep_reason()), "LX" + lxSegCount + " did not match");
                    break;
                default:
                    Assert.fail("Incorrect LX Case");
            }

        }

        softAssert.assertAll("LX switch case for sep reason not null");
    }

    private void validateWithoutSepReasn(int lxSegCount, List<String> refSegList, Ob834DetailsEntity entry, Member member) {
        if (entry.getAddl_maint_reason().contains("|")) {
            String[] parts = entry.getAddl_maint_reason().split("\\|");
            String addtlMainReas1 = parts[0];
            String addtlMainReas2 = parts[1];
            if (member.getINS().get(0).get(0).equals("Y")) {
                switch ("LX" + lxSegCount) {
                    case "LX1":
                        softAssert.assertEquals(String.valueOf(refSegList.get(3)), addtlMainReas1, "LX" + lxSegCount + " did not match");
                        break;
                    case "LX2":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(addtlMainReas2), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX3":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX4":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_reduction_amt()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX5":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getCsr_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX6":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getRate_area()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX7":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals("COCO"), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX8":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getTotal_responsible_amount()));
                        break;
                    case "LX9":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getTotal_premium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    default:
                        Assert.fail("Incorrect LX Case");
                }
            } else
            if(SharedData.getPrimaryMember().getIsProfileChange()&&entry.getAddl_maint_reason().contains("|")){
                switch ("LX" + lxSegCount) {
                    case "LX1":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(addtlMainReas1), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX2":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(addtlMainReas2), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX3":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    default:
                        Assert.fail("Incorrect LX Case");
                }
            } else
            {
                // member
                switch ("LX" + lxSegCount) {
                    case "LX1":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getAddl_maint_reason()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX2":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    default:
                        Assert.fail("Incorrect LX Case");
                }
            }
        } else {

            if (member.getINS().get(0).get(0).equals("Y")) {
                switch ("LX" + lxSegCount) {
                    case "LX1":
                        softAssert.assertEquals(String.valueOf(refSegList.get(3)), entry.getAddl_maint_reason(), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX2":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX3":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_reduction_amt()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX4":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getCsr_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX5":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getRate_area()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX6":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals("COCO"), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX7":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getTotal_responsible_amount()));
                        break;
                    case "LX8":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getTotal_premium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    default:
                        Assert.fail("Incorrect LX Case");
                }
            }
            else {
                // member
                switch ("LX" + lxSegCount) {
                    case "LX1":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getAddl_maint_reason()), "LX" + lxSegCount + " did not match");
                        break;
                    case "LX2":
                        softAssert.assertTrue(String.valueOf(refSegList.get(3)).equals(entry.getPremium_amount()), "LX" + lxSegCount + " did not match");
                        break;
                    default:
                        Assert.fail("Incorrect LX Case");
                }
            }
        }
        softAssert.assertAll("LX switch case for sep reason null");
    }


    private void validateDtpSegment(Member member, Ob834DetailsEntity entry) {
        List<List<String>> dtpSegList = member.getDTP();
        segCount = segCount + dtpSegList.size();
        for (List<String> dtpSeg : dtpSegList) {
            if (dtpSeg.get(0).contains("348")) {
                softAssert.assertEquals(dtpSeg.get(2), entry.getBenefit_begin_date(), "DTP 348 does not match with benefit start date.");
            } else if (dtpSeg.get(0).contains("349")) {
                softAssert.assertEquals(dtpSeg.get(2), entry.getBenefit_end_date(), "DTP 349 does not match with benefit end date.");
            } else if (dtpSeg.get(0).contains("303")) {
                softAssert.assertEquals(dtpSeg.get(2), entry.getFinancial_effective_date(), "DTP 303 doe not match with financial effective date.");
            }
        }
        softAssert.assertAll();
    }

    private void validateAddlMaintReason(Member member, Ob834DetailsEntity entry) {
        List<List<String>> refSegList = member.getREF();
        segCount = segCount + refSegList.size();
        for (List<String> refSeg : refSegList) {
            if (refSeg.get(0).equals("LX1") && refSeg.get(1).equals("17")) {
                if (entry.getAddl_maint_reason().contains(("|"))) {
                    String[] parts = entry.getAddl_maint_reason().split("\\|");
                    String addtlMainReas1 = parts[0];
                    softAssert.assertEquals(refSeg.get(3), addtlMainReas1, "Additional Maintenance reason does not match");
                } else {
                    softAssert.assertEquals(refSeg.get(3), entry.getAddl_maint_reason(), "Additional Maintenance reason does not match");
                }
                if (refSeg.get(0).equals("LX2") && refSeg.get(1).equals("17") && entry.getAddl_maint_reason().contains("|")) {
                    String[] parts = entry.getAddl_maint_reason().split("\\|");
                    String addtlMainReas2 = parts[1];
                    softAssert.assertEquals(refSeg.get(3), addtlMainReas2, "Additional Maintenance reason does not match");
                }

            }
        }
        softAssert.assertAll();
    }

    private void validateLSLESegment(Member member) {
        List<String> lsSegment = member.getLS().get(0);
        List<String> leSegment = member.getLE().get(0);
        softAssert.assertEquals(lsSegment.get(1), "2700", "Loop Header, the loop ID number given on the transaction set does not match");
        softAssert.assertEquals(leSegment.get(0), "2700", "Loop trailer, The loop ID number given on the transaction set does not match");
        segCount = segCount + 2;
        softAssert.assertAll();
    }

    private void validateHierarchyLevelSeg(Member member, Ob834DetailsEntity entry) {
        List<String> hdSeg = member.getHD().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(hdSeg.get(0), entry.getHd_maint_type_code(), "HD maintenance type code does not match");
        softAssert.assertEquals(hdSeg.get(1), "", "Empty");
        softAssert.assertEquals(hdSeg.get(2), entry.getInsurance_line_code(), "Insurance line code does not match");
        softAssert.assertAll();
    }

    private void validateNM1Seg(Member member, Ob834DetailsEntity entry) {
        List<List<String>> nm1Seg = member.getNM1();
        segCount = segCount + nm1Seg.size();
        MemberDetails memberFromSd =  basicActions.getMember(entry.getMember_first_name());
        if(entry.getSubscriber_indicator().equals("Y") && !memberFromSd.getIsMinor()) {
            if (memberFromSd.getHasIncorrectEntities()) {
                validateMemberNM1IncorrectEntities(nm1Seg, entry);
            } else {
                validateNm1ILSeg(nm1Seg, entry);
                if (!memberFromSd.getResAddress().equals(memberFromSd.getMailingAddress()) && !(memberFromSd.getMailingAddress() == null)) {
                    softAssert.assertEquals(nm1Seg.get(1).get(0), "31", "NM1 segment with value 31");
                    softAssert.assertEquals(nm1Seg.get(1).get(1), "1", "NM1 segment with value 1");
                }
            }
        }else if (entry.getSubscriber_indicator().equals("N") && !(memberFromSd.getHasIncorrectEntities())){
            // member
            validateNm1ILSeg(nm1Seg, entry);
            softAssert.assertEquals(String.valueOf(nm1Seg.size()), "1", "NM1 segment size for member is not equal to 1");
        }else if(memberFromSd.getHasIncorrectEntities()){
            validateMemberNM1IncorrectEntities(nm1Seg, entry);
        }
        softAssert.assertAll();
    }

    private void nm1MinorSubs(Member member, Ob834DetailsEntity entry){
        List<List<String>> nm1Seg = member.getNM1();
        MemberDetails memberFromSd =  basicActions.getMember(entry.getMember_first_name());
        validateNm1ILSeg(nm1Seg, entry);
        if(!memberFromSd.getResAddress().equals(memberFromSd.getMailingAddress()) && !(memberFromSd.getMailingAddress() == null)){
            softAssert.assertEquals(nm1Seg.get(1).get(0), "31", "NM1 segment with value 31");
            softAssert.assertEquals(nm1Seg.get(1).get(1), "1", "NM1 segment with value 1");

            softAssert.assertEquals(nm1Seg.get(2).get(0), entry.getResponsible_person_rel_code(), "NM1 segment S1 responsible_person_rel_code mismatch");
            softAssert.assertEquals(nm1Seg.get(2).get(2), entry.getResponsible_person_last_name(), "NM1 segment responsible person last name");
            softAssert.assertEquals(nm1Seg.get(2).get(3), entry.getResponsible_person_first_name(), "NM1 segment responsible person first name");
            softAssert.assertEquals(String.valueOf(nm1Seg.size()), "3", "NM1 segment size is not equal to 3");

        } else {
            softAssert.assertEquals(nm1Seg.get(1).get(0), entry.getResponsible_person_rel_code(), "NM1 segment S1 responsible_person_rel_code mismatch");
            softAssert.assertEquals(nm1Seg.get(1).get(2), entry.getResponsible_person_last_name(), "NM1 segment responsible person last name");
            softAssert.assertEquals(nm1Seg.get(1).get(3), entry.getResponsible_person_first_name(), "NM1 segment responsible person first name");
            softAssert.assertEquals(String.valueOf(nm1Seg.size()), "2", "NM1 segment size is not equal to 3");
        }
    }

    private void validateNm1ILSeg(List<List<String>> nm1Seg1, Ob834DetailsEntity entry) {
        softAssert.assertEquals(nm1Seg1.get(0).get(0), "IL", "Entity Identifier Code does not match");
        softAssert.assertEquals(nm1Seg1.get(0).get(2), entry.getMember_last_name(), "Member Last name does not match");
        softAssert.assertEquals(nm1Seg1.get(0).get(3), entry.getMember_first_name(), "Member first name does not match");
        softAssert.assertEquals(nm1Seg1.get(0).get(8), entry.getMember_ssn(), "Member SSN does not match");
    }

    private void validateNM1IncorrectEntities(List<List<String>> nm1Seg, Ob834DetailsEntity entry){
        System.out.println("Incorrect entities for:: "+ entry.getMember_first_name());
        softAssert.assertEquals(nm1Seg.get(0).get(0), "74", "Entity Identifier Code does not match");
        softAssert.assertEquals(nm1Seg.get(2).get(0), "31", "NM1 segment with value 31");
        softAssert.assertEquals(nm1Seg.get(2).get(1), "1", "NM1 segment with value 1");
        softAssert.assertEquals(nm1Seg.get(0).get(1), entry.getIncorrect_entity_type_qualifier(), "Incorrect entity type qualifier does not match");
        if("34".equals(entry.getIncorrect_id_code_qualifier())){
            softAssert.assertEquals(nm1Seg.get(0).get(7), entry.getIncorrect_id_code_qualifier(), "Incorrect id code qualifier does not match");
        }
        softAssert.assertEquals(nm1Seg.get(1).get(0), entry.getIncorrect_entity_id_code(), "Incorrect entity id code.");
        if (SharedData.getPrimaryMember().getIncorrectIdCode() != null) {
            softAssert.assertEquals(nm1Seg.get(1).get(8), entry.getIncorrect_id_code(), "Incorrect id code");
        }
        softAssert.assertEquals(String.valueOf(nm1Seg.size()), "3", "NM1 segment size is not equal to 3");
    }
    private void validateMemberNM1IncorrectEntities(List<List<String>> nm1Seg, Ob834DetailsEntity entry){
        System.out.println("File Incorrect entities for:: "+ entry.getMember_first_name());
        softAssert.assertEquals(nm1Seg.get(0).get(0), "74", "Member Entity Identifier Code does not match");
        softAssert.assertEquals(nm1Seg.get(0).get(1),"1", "Member NM1 segment 1");
        softAssert.assertEquals(nm1Seg.get(0).get(2),entry.getMember_last_name(), "NM1 segment, member last name mismatch");
        softAssert.assertEquals(nm1Seg.get(0).get(3),entry.getMember_first_name(), "NM1 segment, member first name mismatch");
        if("34".equals(entry.getIncorrect_id_code_qualifier())){
            softAssert.assertEquals(nm1Seg.get(0).get(7), entry.getIncorrect_id_code_qualifier(), "Incorrect id code qualifier does not match");
            softAssert.assertEquals(nm1Seg.get(0).get(8), entry.getMember_ssn(), "Incorrect id code, member SSN does not match");
            softAssert.assertEquals(nm1Seg.get(1).get(7), entry.getIncorrect_id_code_qualifier(),"NM1 segment, Incorrect id code qualifier mismatch");
            softAssert.assertEquals(nm1Seg.get(1).get(8),entry.getIncorrect_id_code(), "NM1 segment, Incorrect id code mismatch");
        }
        softAssert.assertEquals(nm1Seg.get(1).get(0),entry.getIncorrect_entity_id_code(), "Incorrect entity id code mismatch");
        softAssert.assertEquals(nm1Seg.get(1).get(1), entry.getIncorrect_entity_type_qualifier(), "Incorrect entity type qualifier does not match");
        softAssert.assertEquals(nm1Seg.get(1).get(2),entry.getIncorrect_last_name(), "NM1 segment, Incorrect member last name mismatch");
        softAssert.assertEquals(nm1Seg.get(1).get(3),entry.getIncorrect_first_name(), "NM1 segment, Incorrect member first name mismatch");
        softAssert.assertEquals(String.valueOf(nm1Seg.size()), "2", "NM1 segment size is not equal to 2");
    }


    private void validateInsSegment(Member member, Ob834DetailsEntity entry) {
        segCount = segCount + 1;
        List<String> insSegment = member.getINS().get(0);
        softAssert.assertEquals(insSegment.get(0), entry.getSubscriber_indicator(), "In INS segment, Subscriber indicator does not match");
        softAssert.assertEquals(insSegment.get(1), entry.getIndividual_rel_code(), "In INS segment,Individual rel code does not match");
        softAssert.assertEquals(insSegment.get(2), entry.getMaintenance_type_code(), "In INS segment, Maintenance type code does not match");
        softAssert.assertEquals(insSegment.get(3), entry.getMaintenance_reas_code(), "In INS segment, Maintenance reason code does not match");
        softAssert.assertEquals(insSegment.get(4), "A", "Active does not match");
        if (insSegment.get(0).equals("Y")) {
            softAssert.assertEquals(insSegment.get(7), "AC", "Active does not match");
        }
    }

    private void validateHLHSeg(Member member, Ob834DetailsEntity entry) {
        List<String> HLHSeg = member.getHLH().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(HLHSeg.get(0), entry.getTobacco_use());
    }

    private void validateDMGSegment(Member member, Ob834DetailsEntity entry) {
        MemberDetails memberFromSd =  basicActions.getMember(entry.getMember_first_name());
        List<List<String>> dmgSeg = member.getDMG();
        segCount = segCount + 1;
        softAssert.assertEquals(dmgSeg.get(0).get(0), "D8", "D8, Date Expressed in Format CCYYMMDD");
        softAssert.assertEquals(dmgSeg.get(0).get(1), entry.getMember_dob(), "Member date of birth does not match");
        softAssert.assertEquals(dmgSeg.get(0).get(2), entry.getMember_gender(), "Member gender does not match");
        if (!(entry.getMember_race().equals("7") || entry.getMember_race().equals("8"))) {
            softAssert.assertEquals(dmgSeg.get(0).get(4), entry.getMember_race(), "Member gender does not match");
        }
        if(memberFromSd.getHasIncorrectEntities()){
            softAssert.assertEquals(dmgSeg.get(1).get(2),entry.getIncorrect_gender(), "Member Incorrect gender does not match");
            softAssert.assertEquals(dmgSeg.get(1).get(4),entry.getIncorrect_race(),"Member Incorrect race does not match");
            segCount = segCount + 1;
        }
    }


    private void validateSubscriberSegments(List<Ob834DetailsEntity> dbSubscriberEntities) {
        for (Ob834DetailsEntity dbSubscriberEntity : dbSubscriberEntities) {
            for (Transaction transaction : transactionsList) {
                List<Member> membersList = transaction.getMembersList();
                for (Member mem : membersList) {
                    if (mem.getNM1().get(0).get(3).equals(dbSubscriberEntity.getMember_first_name())) {
                        validateSponsorPayerDetails(dbSubscriberEntity, transaction);
                        validateDtpSegment(dbSubscriberEntity, transaction);
                        validateBgnSeg(dbSubscriberEntity, transaction);
                        validateQtySeg(dbSubscriberEntity, transaction);
                        validateTrnSeg(dbSubscriberEntity, transaction);
                        validateSubscriberRefSeg(transaction);
                        validatePerSeg(dbSubscriberEntity, mem);
                        validateLUISeg(dbSubscriberEntity, mem);
                        validateN3N4Segments(dbSubscriberEntity, mem);
                        break;

                    }
                }
                softAssert.assertAll();
            }
        }
    }

    private void validateSubscriberRefSeg(Transaction transaction) {
        List<String> refSeg = transaction.getCommonSegments().getREF().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(String.valueOf(refSeg.get(0)), "38", "Subscriber ref is not 38");
        softAssert.assertEquals(String.valueOf(refSeg.get(1)), "COCO", "subscriber ref is not COCO");
    }

    private void validateTrnSeg(Ob834DetailsEntity entry, Transaction transaction) {
        // ST Segment
        List<String> stSeg = transaction.getCommonSegments().getST().get(0);
        softAssert.assertEquals(stSeg.get(0), "834", "Transaction Set Identifier Code does not match");
        softAssert.assertEquals(stSeg.get(2), "005010X220A1", "Implementation Convention Reference does not match");
        // SE Segment
        List<String> seSeg = transaction.getCommonSegments().getSE().get(0);
        softAssert.assertEquals(seSeg.get(1), entry.getTs_control_number(), "Ts control number does not match");
        segCount = segCount + 2;
    }

    private void validateN3N4Segments(Ob834DetailsEntity entry, Member member) {
        //N3 Segment
        List<List<String>> n3Seg = member.getN3();
        //N4 Segment
        List<List<String>> n4Seg = member.getN4();

        if (entry.getMail_street_line1() != null) {
            softAssert.assertEquals(n3Seg.get(1).get(0), entry.getMail_street_line1(), "Mailing address street line 1 does not match");
            softAssert.assertEquals(n4Seg.get(1).get(0), entry.getMail_city(), "Mailing city does not match");
            softAssert.assertEquals(n4Seg.get(1).get(1), entry.getMail_st(), "Mailing State does not match");
            softAssert.assertEquals(n4Seg.get(1).get(2), entry.getMail_zip_code(), "Mailing zipcode does not match");
        }

        segCount = segCount + n3Seg.size() + n4Seg.size();
        softAssert.assertEquals(n3Seg.get(0).get(0), entry.getResidence_street_line1(), "Residence street address line1 does not match");
        softAssert.assertEquals(n4Seg.get(0).get(0), entry.getResidence_city(), "Residence city does not match");
        softAssert.assertEquals(n4Seg.get(0).get(1), entry.getResidence_st(), "Residence state does not match");
        softAssert.assertEquals(n4Seg.get(0).get(2), entry.getResidence_zip_code(), "Residence zipcode does not match");
        softAssert.assertEquals(n4Seg.get(0).get(4), "CY", "Country Code");
        softAssert.assertEquals(n4Seg.get(0).get(5), entry.getResidence_fip_code(), "Residence fipcode does not match");
    }

    private void validateLUISeg(Ob834DetailsEntity entry, Member member) {
        List<List<String>> luiSeg = member.getLUI();
        segCount = segCount + luiSeg.size();
        softAssert.assertEquals(luiSeg.get(0).get(2), entry.getWritten_language(), "Written Language does not match.");
        softAssert.assertEquals(luiSeg.get(0).get(3), String.valueOf(6), "Written Language Use Indicator does not match");
        softAssert.assertEquals(luiSeg.get(1).get(2), entry.getSpoken_language(), "Spoken Language does not match.");
        softAssert.assertEquals(luiSeg.get(1).get(3), String.valueOf(7), "Spoken Language Use Indicator does not match");
    }

    private void validateQtySeg(Ob834DetailsEntity entry, Transaction transaction) {
        List<List<String>> qtySeg = transaction.getCommonSegments().getQTY();
        segCount = segCount + qtySeg.size();
        softAssert.assertEquals(qtySeg.get(0).get(0), "TO", "Total enrolls ");
        softAssert.assertEquals(qtySeg.get(0).get(1), entry.getTotal_enrollees(), "Total enrolls does not match");
        softAssert.assertEquals(qtySeg.get(1).get(0), "DT", "Total dependents");
        softAssert.assertEquals(qtySeg.get(1).get(1), entry.getTotal_dependents(), "Total dependents doe not match");
        softAssert.assertEquals(qtySeg.get(2).get(0), "ET", "Total subscribers");
        softAssert.assertEquals(qtySeg.get(2).get(1), entry.getTotal_subscribers(), "Total subscribers does not match");
    }

    private void validateBgnSeg(Ob834DetailsEntity entry, Transaction transaction) {
        List<String> bgnSeg = transaction.getCommonSegments().getBGN().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(bgnSeg.get(0), entry.getTs_purpose_code(), "ts purpose code does not match");
        softAssert.assertEquals(bgnSeg.get(1), entry.getBgn_reference_ident(), "BGN reference identification does not match");
        softAssert.assertEquals(bgnSeg.get(2), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(bgnSeg.get(3), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(4), "MT", "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(7), entry.getBgn_action_code(), "BGN action code does not match");
    }

    private void validatePerSeg(Ob834DetailsEntity entry, Member member) {
        List<String> perSeg = member.getPER().get(0);
        segCount = segCount + 1;
        softAssert.assertEquals(perSeg.get(0), "IP", "code identifying the Insured Party, IP does not match");
        softAssert.assertEquals(perSeg.get(2), "TE", "Telephone code TE does not match");
        softAssert.assertEquals(perSeg.get(3), entry.getPrimary_phone(), "Primary Phone number does not match");
        softAssert.assertEquals(perSeg.get(4), "EM", "Electronic mail code EM does not match");
        softAssert.assertEquals(perSeg.get(5), entry.getPrimary_email(), "Primary email does not match");
        softAssert.assertEquals(perSeg.get(6), "AP", "Alternate phone code does not match");
        softAssert.assertEquals(perSeg.get(7), entry.getAlternate_phone(), "Alternate phone number does not match");
    }
    private void validateDtpSegment(Ob834DetailsEntity entry, Transaction transaction){
        List<List<String>> dtpSegment = transaction.getCommonSegments().getDTP();
        segCount = segCount +dtpSegment.size();
        softAssert.assertEquals(dtpSegment.get(0).get(0), "303", "DTP01 segment, Date Time Qualifier, mismatch");
        softAssert.assertEquals(dtpSegment.get(0).get(1),"D8","DTP02 segment, Date Time Period Format Qualifier D8 mismatch");
        softAssert.assertEquals(dtpSegment.get(0).get(2),entry.getApplication_date(), "Application date mismatch" );
        softAssert.assertAll();
    }

    private void validateSponsorPayerDetails(Ob834DetailsEntity entry, Transaction transaction) {
        List<List<String>> n1Segment = transaction.getCommonSegments().getN1();
        segCount = segCount + n1Segment.size();
        //Sponsor Details
        softAssert.assertEquals(n1Segment.get(0).get(0), "P5", "P5 does not match");
        softAssert.assertEquals(n1Segment.get(0).get(1), entry.getPlan_sponsor_name(), "Sponsor full name does not match.");
        softAssert.assertEquals(n1Segment.get(0).get(2), "94", "94, Federal Taxpayer's Identification Number");
        softAssert.assertEquals(n1Segment.get(0).get(3), entry.getSponsor_id(), "Sponsor Id does not match");
        //Payer Details
        softAssert.assertEquals(n1Segment.get(1).get(0), "IN", "Insurer");
        softAssert.assertEquals(n1Segment.get(1).get(1), entry.getInsurer_name(), "Insurer Name does not match");
        softAssert.assertEquals(n1Segment.get(1).get(2), "94", "Code assigned by the organization that is the ultimate destination of the transaction set");
        softAssert.assertEquals(n1Segment.get(1).get(3), entry.getInsurer_id(), "Insurer Identification Code");

        if (SharedData.getHasBroker()) {
            softAssert.assertEquals(n1Segment.get(2).get(0), "BO", "Broker");
            softAssert.assertEquals(n1Segment.get(2).get(1), entry.getTpa_or_broker_name(), "Broker name mismatch");
            softAssert.assertEquals(n1Segment.get(2).get(2), "FI", "Broker Code assigned by the organization that is the ultimate destination of the transaction set");
            softAssert.assertEquals(n1Segment.get(2).get(3), entry.getTpa_or_broker_id(), "Broker Id mismatch");
            List<String> actSegment = transaction.getCommonSegments().getACT().get(0);
            softAssert.assertEquals(actSegment.get(0), entry.getTpa_or_broker_lic_num(), "Broker License Number did not match");
            segCount = segCount + 1;
        }

    }

    private void validateCtrlFnGrpSegment(Ob834DetailsEntity entry) {
        CommonEDISegments commonEDISegments = SharedData.getCommonEDISegments();
        //ISA Segment
        JSONArray isaSeg = commonEDISegments.getISA();
        String senderId = isaSeg.get(5).toString().trim();
        String receiverId = isaSeg.get(7).toString().trim();
        softAssert.assertEquals(isaSeg.get(4), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(senderId, entry.getInterchange_sender_id(), "Interchange Sender ID does not match");
        softAssert.assertEquals(isaSeg.get(6), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(receiverId, entry.getInterchange_receiver_id(), "Interchange receiver id does not match");
        softAssert.assertEquals("20" + isaSeg.get(8), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(isaSeg.get(9), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), "0", "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), "T", "End of ISA segment, 'T' for Test Data, does not match");
        //IEA Segment
        JSONArray ieaSeg = commonEDISegments.getIEA();
//        softAssert.assertEquals(ieaSeg.get(0), entry.getMember_group(), "Number of functional groups included does not match");
        softAssert.assertEquals(ieaSeg.get(1), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        //GS Segment
        JSONArray gsSeg = commonEDISegments.getGS().getJSONArray(0);
        softAssert.assertEquals(gsSeg.get(0), "BE", "Benefit Enrollment and Maintenance, Code identifying a group of application related transaction sets");
        softAssert.assertEquals(gsSeg.get(1), entry.getInterchange_sender_id(), "Sender's code does not match");
        softAssert.assertEquals(gsSeg.get(2), entry.getInterchange_receiver_id(), "Receiver's code does not match");
        softAssert.assertEquals(gsSeg.get(3), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(gsSeg.get(4), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(gsSeg.get(5), entry.getGroup_ctrl_number(), "Group control number does not match");
        softAssert.assertEquals(gsSeg.get(6), "X", "Code identifying the issuer of the standard; this code is used in conjunction with Data, X\n" +
                "Accredited Standards Committee ");
        softAssert.assertEquals(gsSeg.get(7), "005010X220A1", "Code indicating the version, release, subrelease, and industry identifier of the EDI standard being used does not match");
        //GE Segment
        JSONArray geSeg = commonEDISegments.getGE().getJSONArray(0);
        softAssert.assertEquals(geSeg.get(1), entry.getGroup_ctrl_number(), "Control number assigned by the interchange sender does not match");
        setTransGrpCtrlNum(geSeg);
    }

    private void setTransGrpCtrlNum(JSONArray geSeg){
        Map<String, String> transForGrpCtrlNum = SharedData.getTransForGrpCtrlNum();
        if(transForGrpCtrlNum == null){
            transForGrpCtrlNum = new HashMap<>();
        }
        transForGrpCtrlNum.put(geSeg.get(1).toString(), geSeg.get(0).toString());
        SharedData.setTransForGrpCtrlNum(transForGrpCtrlNum);
    }

    private void getDataByEmailAndAccNum() {
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        String email = SharedData.getPrimaryMember().getEmailId();
        List<Transaction> updatedTransactionList = new ArrayList<>();
        transactionsList = edi834TransactionDetails.getTransactionList();
        for (Transaction trans : transactionsList) {
            List<Member> members = trans.getMembersList();

            for (Member mem : members) {
                if (mem.getINS().get(0).get(0).equals("Y") && mem.getPER().get(0).get(5).equals(email)) {
                    updatedTransactionList.add(trans);
                    break;
                }
            }
        }

        edi834TransactionDetails.setTransactionList(updatedTransactionList);
        SharedData.setEdi834TransactionDetails(edi834TransactionDetails);
        transactionsList = edi834TransactionDetails.getTransactionList();
    }

    private void getSubscriberEntities(String fileName) {
        List<Ob834DetailsEntity> medicalEntityList = SharedData.getOb834DetailsMedEntities();
        for (Ob834DetailsEntity medEntity : medicalEntityList) {
            if (medEntity.getSubscriber_indicator().equals("Y") && medEntity.getFilename().equals(fileName)) {
                subscriberMedEntities.add(medEntity);
            }
        }
    }
    private void setN1SegList() {
        Collections.addAll(n1ListWithSepReason, "PRE AMT 1", "SES AMT", "CSR AMT", "RATING AREA", "SOURCE EXCHANGE ID", "TOT RES AMT", "PRE AMT TOT", "SEP REASON");
        Collections.addAll(n1ListWithAddtlMaintReas, "ADDL MAINT REASON", "PRE AMT 1", "SES AMT", "CSR AMT", "RATING AREA", "SOURCE EXCHANGE ID", "TOT RES AMT", "PRE AMT TOT");
        Collections.addAll(n1ListWithSepReasonMem, "PRE AMT 1", "SEP REASON");
        Collections.addAll(n1ListWithAddtlMaintReasMem, "ADDL MAINT REASON", "PRE AMT 1");
    }

}
