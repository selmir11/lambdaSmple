package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.CommonEDISegments;
import com.c4hco.test.automation.Dto.Edi.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Member;
import com.c4hco.test.automation.Dto.Edi.Transaction;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.database.EntityObj.Ob834DetailsEntity;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ob834FileValidations_new {
    SoftAssert softAssert = new SoftAssert();
    Edi834TransactionDetails edi834TransactionDetails = null;
    Transaction transaction = null;
    Ob834DetailsEntity subscriberMedEntity = new Ob834DetailsEntity();
    Ob834DetailsEntity subscriberDenEntity = new Ob834DetailsEntity();
    List<String> n1ListWithSepReason = new ArrayList<>();
    List<String> n1ListWithAddtlMaintReas = new ArrayList<>();
    List<String> n1ListWithSepReasonMem = new ArrayList<>();
    List<String> n1ListWithAddtlMaintReasMem = new ArrayList<>();

    public Ob834FileValidations_new(){
        getOb834MedEntityForSubscriber();
        getOb834DenEntityForSubscriber();
        setN1SegList();
    }

    public void validateOb834MedFile(){
        List<Ob834DetailsEntity> medicalEntityList = SharedData.getOb834DetailsMedEntities();
        getDataByEmailAndAccNum();
        validateSubscriberSegments(subscriberMedEntity);
        validateMemSeg(medicalEntityList);
    }

    public void validateOb834DenFile(){
        List<Ob834DetailsEntity> dentalEntityList = SharedData.getOb834DetailsDenEntities();
        getDataByEmailAndAccNum();
        validateSubscriberSegments(subscriberDenEntity);
        validateMemSeg(dentalEntityList);
    }

    private void validateSubscriberSegments(Ob834DetailsEntity entry){
        validateCtrlFnGrpSegment(entry);
        validateSponsorPayerDetails(entry);
        validatePerSeg(entry);
        validateBgnSeg(entry);
        validateQtySeg(entry);
        validateLUISeg(entry);
        validateN3N4Segments(entry);
        validateTrnSeg(entry);
    }

    private void validateLxRefN1Seg(Member member, Ob834DetailsEntity entry){
        List<List<String>> lxSegment = member.getLX();
        List<List<String>> n1SegListOfList = member.getN1();
        List<List<String>> refSegListOfList = member.getREF();
        List<String> n1SegList = new ArrayList<>();
        int lxSegCount = 1;

        for(List<String> lxSeg: lxSegment){
            Assert.assertEquals(String.valueOf(lxSeg.get(0)).replaceAll(String.valueOf(lxSegCount), ""), "LX");
            Assert.assertEquals(Integer.parseInt(lxSeg.get(1)), lxSegCount, "lxSeg.get(1)::"+lxSeg.get(1)+"  lxSegCount::"+lxSegCount);

            for(List<String> n1SegLst: n1SegListOfList ){
                if(String.valueOf(n1SegLst.get(0)).equals("LX"+lxSegCount)){
                    Assert.assertEquals(String.valueOf(n1SegLst.get(1)), "75");
                    n1SegList.add(n1SegLst.get(3));
                    break;
                }
            }

            for(List<String> refSegList: refSegListOfList){
                if(String.valueOf(refSegList.get(0)).equals("LX"+lxSegCount)){
                    switch("LX"+lxSegCount){
                        // WIP
                        case "LX1":
                            refSegList.get(3); // compare with specific entity value
                            refSegList.get(1); // 9x or 9v or 17 ?? hardcode
                            break;
                        case "LX2":
                            break;
                        case "LX3":
                            break;
                        case "LX4":
                            break;
                        case "LX5":
                            break;
                        case "LX6":
                            break;
                        case "LX7":
                            break;
                        case "LX8":
                            break;
                        default: Assert.fail("Incorrect LX Case");

                    }
                    break;
                }

            }

            lxSegCount++;
        }
        validateMemN1Seg(entry, n1SegList);
    }

    private void validateMemN1Seg(Ob834DetailsEntity entry, List<String> n1SegList){
        List<String> expectedN1List;

        if (entry.getSubscriber_indicator().equals("Y")) {
            expectedN1List = (entry.getAddl_maint_reason() == null && entry.getSep_reason() != null) ? n1ListWithSepReason : n1ListWithAddtlMaintReas;
        } else {
            expectedN1List = (entry.getAddl_maint_reason() == null && entry.getSep_reason() != null) ? n1ListWithSepReasonMem : n1ListWithAddtlMaintReasMem;
        }
        Assert.assertEquals(n1SegList, expectedN1List);
    }

    private void validateSegments(Member member, Ob834DetailsEntity entry) {
        validateDMGSegment(member,entry);
        validateHLHSeg(member, entry);
        validateInsSegment(member, entry);
        validateNM1Seg(member, entry);
        validateAddlMaintReason(member, entry);
        validateDtpSegment(member, entry);
        validateHierarchyLevelSeg(member, entry);
        validateLSLESegment(member);
        validateLxRefN1Seg(member, entry);
        softAssert.assertAll();
    }

    private void validateHLHSeg(Member member, Ob834DetailsEntity entry){
        List<String> HLHSeg = member.getHLH().get(0);
        softAssert.assertEquals(HLHSeg.get(0), entry.getTobacco_use());
        softAssert.assertAll();
    }

    private void validateLSLESegment(Member member){
        List<String> lsSegment = member.getLS().get(0);
        List<String> leSegment = member.getLE().get(0);
        softAssert.assertEquals(lsSegment.get(1), "2700", "Loop Header, the loop ID number given on the transaction set does not match");
        softAssert.assertEquals(leSegment.get(0), "2700", "Loop trailer, The loop ID number given on the transaction set does not match");
        softAssert.assertAll();
    }

    private void validateCtrlFnGrpSegment(Ob834DetailsEntity entry){
        CommonEDISegments commonEDISegments = SharedData.getCommonEDISegments();
        //ISA Segment
        JSONArray isaSeg = commonEDISegments.getISA();
        String senderId = isaSeg.get(5).toString().trim();
        String receiverId = isaSeg.get(7).toString().trim();
        softAssert.assertEquals(isaSeg.get(4), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(senderId, entry.getInterchange_sender_id() , "Interchange Sender ID does not match");
        softAssert.assertEquals(isaSeg.get(6), "ZZ", "Interchange ID qualifier, 'ZZ' Mutually Defined");
        softAssert.assertEquals(receiverId, entry.getInterchange_receiver_id(),"Interchange receiver id does not match");
        softAssert.assertEquals("20"+isaSeg.get(8), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(isaSeg.get(9), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(isaSeg.get(11), "00501", "Code specifying the version number of the interchange control segments");
        softAssert.assertEquals(isaSeg.get(12), entry.getInterchange_ctrl_number(), "Interchange control number does not match");
        softAssert.assertEquals(isaSeg.get(13), "0", "No Interchange Acknowledgment Requested");
        softAssert.assertEquals(isaSeg.get(14), "T","End of ISA segment, 'T' for Test Data, does not match");
        //IEA Segment
        JSONArray ieaSeg = commonEDISegments.getIEA();
        softAssert.assertEquals(ieaSeg.get(0), entry.getMember_group(), "Number of functional groups included does not match");
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
        softAssert.assertEquals(geSeg.get(0), entry.getMember_group(), "Count of the number of functional groups included in an interchange does not match");
        softAssert.assertEquals(geSeg.get(1), entry.getGroup_ctrl_number(), "Control number assigned by the interchange sender does not match");
        softAssert.assertAll();
    }

    private void validateSponsorPayerDetails(Ob834DetailsEntity entry){
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        transaction =  edi834TransactionDetails.getTransactionList().get(0);
        List<List<String>> n1Segment = transaction.getCommonSegments().getN1();
        //Sponsor Details
        softAssert.assertEquals(n1Segment.get(0).get(0), "P5", "P5 does not match");
        softAssert.assertEquals(n1Segment.get(0).get(1), entry.getMember_first_name()+" "+entry.getMember_last_name(), "Sponsor full name does not match.");
        softAssert.assertEquals(n1Segment.get(0).get(2), "FI", "FI, Federal Taxpayer's Identification Number");
        softAssert.assertEquals(n1Segment.get(0).get(3), entry.getSponsor_id(), "Sponsor Id does not match");
        //Payer Details
        softAssert.assertEquals(n1Segment.get(1).get(0), "IN", "Insurer");
        softAssert.assertEquals(n1Segment.get(1).get(1), entry.getInsurer_name(), "Insurer Name does not match");
        softAssert.assertEquals(n1Segment.get(1).get(2), "94", "Code assigned by the organization that is the ultimate destination of the transaction set");
        softAssert.assertEquals(n1Segment.get(1).get(3), entry.getInsurer_id(), "Insurer Identification Code");
        softAssert.assertAll();
    }

    private void validateAddlMaintReason(Member member,Ob834DetailsEntity entry){
        List<List<String>> refSegList = member.getREF();
        for (List<String> refSeg : refSegList) {
            if (refSeg.get(0).equals("LX1") && refSeg.get(1).equals("17")){
                softAssert.assertEquals(refSeg.get(3), entry.getAddl_maint_reason(),"Additional Maintenance reason does not match");
            }
        }
        softAssert.assertAll();
    }

    private void validateInsSegment(Member member,Ob834DetailsEntity entry){
        List<String> insSegment  = member.getINS().get(0);

        softAssert.assertEquals(insSegment.get(0), entry.getSubscriber_indicator(), "In INS segment, Subscriber indicator does not match");
        softAssert.assertEquals(insSegment.get(1), entry.getIndividual_rel_code(), "In INS segment,Individual rel code does not match");
        softAssert.assertEquals(insSegment.get(2), entry.getMaintenance_type_code(), "In INS segment, Maintenance type code does not match");
        softAssert.assertEquals(insSegment.get(3), entry.getMaintenance_reas_code(), "In INS segment, Maintenance reason code does not match");
        softAssert.assertEquals(insSegment.get(4), "A", "Active does not match");
        if(insSegment.get(0).equals("Y")){
            softAssert.assertEquals(insSegment.get(7), "AC", "Active does not match");
        }
        softAssert.assertAll();
    }

    private void validateDtpSegment(Member member,Ob834DetailsEntity entry){
       // System.out.println("DTP::"+member.getDTP());
        List<List<String>> dtpSegList = member.getDTP();
        for(List<String> dtpSeg: dtpSegList){
            if(dtpSeg.get(0).contains("348")){
                softAssert.assertEquals(dtpSeg.get(2),entry.getBenefit_begin_date(),"DTP 348 does not match with benefit start date.");
            }else if(dtpSeg.get(0).contains("349")){
                softAssert.assertEquals(dtpSeg.get(2),entry.getBenefit_end_date(),"DTP 349 does not match with benefit end date.");
            }else if(dtpSeg.get(0).contains("303")){
                softAssert.assertEquals(dtpSeg.get(2),entry.getFinancial_effective_date(),"DTP 303 doe not match with financial effective date.");
            }
        }
        softAssert.assertAll();
    }

    private void validateHierarchyLevelSeg(Member member,Ob834DetailsEntity entry){
        List<String> hdSeg = member.getHD().get(0);
        softAssert.assertEquals(hdSeg.get(0), entry.getHd_maint_type_code(), "HD maintenance type code does not match");
        softAssert.assertEquals(hdSeg.get(1), "", "Empty");
        softAssert.assertEquals(hdSeg.get(2), entry.getInsurance_line_code(),"Insurance line code does not match");
        softAssert.assertAll();
    }

    private void validateNM1Seg(Member member,Ob834DetailsEntity entry){
        List<List<String>> nm1Seg1  = member.getNM1();
        if(SharedData.getPrimaryMember().getHasIncorrectEntities()){
            softAssert.assertEquals(nm1Seg1.get(0).get(0),"74","Entity Identifier Code does not match");
            softAssert.assertEquals(nm1Seg1.get(2).get(0),"31","NM1 segment with value 31");
            softAssert.assertEquals(nm1Seg1.get(2).get(1),"1","NM1 segment with value 1");
            softAssert.assertEquals(nm1Seg1.get(0).get(1), entry.getIncorrect_entity_type_qualifier(),"Incorrect entity type qualifier does not match");
            softAssert.assertEquals(nm1Seg1.get(0).get(7), entry.getIncorrect_id_code_qualifier(),"Incorrect id code qualifier does not match");
            softAssert.assertEquals(nm1Seg1.get(1).get(0), entry.getIncorrect_entity_id_code(),"Incorrect entity id code.");
            softAssert.assertEquals(nm1Seg1.get(1).get(8), entry.getIncorrect_id_code(),"Incorrect id code");
            softAssert.assertEquals(String.valueOf(nm1Seg1.size()),"3" , "NM1 segment size is not equal to 3");
        }else{
            softAssert.assertEquals(nm1Seg1.get(0).get(0),"IL","Entity Identifier Code does not match");
        }

        if(nm1Seg1.get(0).get(3).toLowerCase().contains("primary")){
            softAssert.assertEquals(nm1Seg1.get(1).get(0),"31","NM1 segment with value 31");
            softAssert.assertEquals(nm1Seg1.get(1).get(1),"1","NM1 segment with value 1");
            softAssert.assertEquals(String.valueOf(nm1Seg1.size()),"2" , "NM1 segment size for subscriber is not equal to 2");
        } else{
            softAssert.assertEquals(String.valueOf(nm1Seg1.size()),"1" , "NM1 segment size for member is not equal to 1");
        }
        softAssert.assertEquals(nm1Seg1.get(0).get(2), entry.getMember_last_name(),"Member Last name does not match");
        softAssert.assertEquals(nm1Seg1.get(0).get(3), entry.getMember_first_name(), "Member first name does not match");
        softAssert.assertEquals(nm1Seg1.get(0).get(8),entry.getMember_ssn(), "Member SSN does not match");
        softAssert.assertAll();
    }

    private void validatePerSeg(Ob834DetailsEntity entry){
        List<String> perSeg = transaction.getMembersList().get(0).getPER().get(0);
        softAssert.assertEquals(perSeg.get(0), "IP", "code identifying the Insured Party, IP does not match");
        softAssert.assertEquals(perSeg.get(2), "TE", "Telephone code TE does not match");
        softAssert.assertEquals(perSeg.get(3), entry.getPrimary_phone(), "Primary Phone number does not match");
        softAssert.assertEquals(perSeg.get(4), "EM", "Electronic mail code EM does not match");
        softAssert.assertEquals(perSeg.get(5), entry.getPrimary_email(), "Primary email does not match");
        softAssert.assertEquals(perSeg.get(6), "AP", "Alternate phone code does not match");
        softAssert.assertEquals(perSeg.get(7), entry.getAlternate_phone(), "Alternate phone number does not match");
        softAssert.assertAll();
    }

    private void validateBgnSeg(Ob834DetailsEntity entry){
        List<String> bgnSeg = transaction.getCommonSegments().getBGN().get(0);
        softAssert.assertEquals(bgnSeg.get(0), entry.getTs_purpose_code(), "ts purpose code does not match");
        softAssert.assertEquals(bgnSeg.get(1), entry.getBgn_reference_ident(),"BGN reference identification does not match");
        softAssert.assertEquals(bgnSeg.get(2), entry.getInterchange_date(), "Interchange date does not match");
        softAssert.assertEquals(bgnSeg.get(3), entry.getInterchange_time(), "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(4), "MT", "Interchange time does not match");
        softAssert.assertEquals(bgnSeg.get(7), entry.getBgn_action_code(),"BGN action code does not match");
        softAssert.assertAll();
    }

    private void validateTrnSeg(Ob834DetailsEntity entry){
        // ST Segment
        List<String> stSeg  = transaction.getCommonSegments().getST().get(0);
        softAssert.assertEquals(stSeg.get(0), "834", "Transaction Set Identifier Code does not match");
        softAssert.assertEquals(stSeg.get(1), "1000", "Transaction Set Control Number does not match");
        softAssert.assertEquals(stSeg.get(2), "005010X220A1", "Implementation Convention Reference does not match");
        // SE Segment
        int segCount = segmentCount();
        List<String> seSeg = transaction.getCommonSegments().getSE().get(0);
      //  softAssert.assertEquals(seSeg.get(0), String.valueOf(segCount), "Total number of segments included in a transaction set including ST and SE segments does not match");
        softAssert.assertEquals(seSeg.get(1), entry.getTs_control_number(), "Ts control number does not match");
        softAssert.assertAll();
    }

    private void validateQtySeg(Ob834DetailsEntity entry) {
        // WIP
        List<List<String>> qtySeg = transaction.getCommonSegments().getQTY();
        List<List<String>> insSegment = transaction.getMembersList().get(0).getINS();
        softAssert.assertEquals(qtySeg.get(0).get(0), "TO", "Total enrolls ");
        softAssert.assertEquals(qtySeg.get(0).get(1), entry.getTotal_enrollees(), "Total enrolls does not match");
      //  softAssert.assertEquals(qtySeg.get(0).get(1), String.valueOf(insSegment.size()), "Total enrolls does not match with the size of INS segment");
        softAssert.assertEquals(qtySeg.get(1).get(0), "DT", "Total dependents");
        softAssert.assertEquals(qtySeg.get(1).get(1), entry.getTotal_dependents(), "Total dependents doe not match");
        softAssert.assertEquals(qtySeg.get(2).get(0), "ET", "Total subscribers");
        softAssert.assertEquals(qtySeg.get(2).get(1), entry.getTotal_subscribers(), "Total subscribers does not match");
        softAssert.assertAll();
    }

    private void validateLUISeg(Ob834DetailsEntity entry){
        List<List<String>> luiSeg = transaction.getMembersList().get(0).getLUI();
        softAssert.assertEquals(luiSeg.get(0).get(2), entry.getWritten_language(), "Written Language does not match.");
        softAssert.assertEquals(luiSeg.get(0).get(3), String.valueOf(6), "Written Language Use Indicator does not match");
        softAssert.assertEquals(luiSeg.get(1).get(2), entry.getSpoken_language(), "Spoken Language does not match.");
        softAssert.assertEquals(luiSeg.get(1).get(3), String.valueOf(7), "Spoken Language Use Indicator does not match");
        softAssert.assertAll();
    }

    private void validateN3N4Segments(Ob834DetailsEntity entry){
        //N3 Segment
        List<List<String>> n3Seg = transaction.getMembersList().get(0).getN3();
        softAssert.assertEquals(n3Seg.get(0).get(0), entry.getResidence_street_line1(), "Residence street address line1 does not match");
        softAssert.assertEquals(n3Seg.get(1).get(0), entry.getMail_street_line1(), "Mailing address street line 1 does not match");
        //N4 Segment
        List<List<String>> n4Seg = transaction.getMembersList().get(0).getN4();
        softAssert.assertEquals(n4Seg.get(0).get(0), entry.getResidence_city(), "Residence city does not match");
        softAssert.assertEquals(n4Seg.get(0).get(1), entry.getResidence_st(), "Residence state does not match");
        softAssert.assertEquals(n4Seg.get(0).get(2), entry.getResidence_zip_code(), "Residence zipcode does not match");
        softAssert.assertEquals(n4Seg.get(0).get(4), "CY", "Country Code");
        softAssert.assertEquals(n4Seg.get(0).get(5), entry.getResidence_fip_code(),"Residence fipcode does not match");

        softAssert.assertEquals(n4Seg.get(1).get(0), entry.getMail_city(), "Mailing city does not match");
        softAssert.assertEquals(n4Seg.get(1).get(1), entry.getMail_st(), "Mailing State does not match");
        softAssert.assertEquals(n4Seg.get(1).get(2), entry.getMail_zip_code(), "Mailing zipcode does not match");
        softAssert.assertAll();
    }

    private void validateDMGSegment(Member member, Ob834DetailsEntity entry){
        List<String> dmgSeg = member.getDMG().get(0);
        softAssert.assertEquals(dmgSeg.get(0), "D8", "D8, Date Expressed in Format CCYYMMDD");
        softAssert.assertEquals(dmgSeg.get(1), entry.getMember_dob(), "Member date of birth does not match");
        softAssert.assertEquals(dmgSeg.get(2), entry.getMember_gender(), "Member gender does not match");
        // validate raceCode as well
        softAssert.assertAll();
    }

    private int segmentCount() {
        // WIP
        return transaction.getMembersList().get(0).getN1().size() +
                transaction.getMembersList().get(0).getN4().size() +
                transaction.getMembersList().get(0).getLS().size() +
                transaction.getMembersList().get(0).getHD().size() +
                transaction.getMembersList().get(0).getDTP().size() +
                transaction.getMembersList().get(0).getLUI().size() +
                transaction.getMembersList().get(0).getN3().size() +
                transaction.getMembersList().get(0).getHLH().size() +
                transaction.getMembersList().get(0).getLX().size() +
                transaction.getMembersList().get(0).getINS().size() +
                transaction.getMembersList().get(0).getREF().size() +
                transaction.getMembersList().get(0).getNM1().size() +
                transaction.getMembersList().get(0).getLE().size() +
                transaction.getMembersList().get(0).getPER().size() +
                transaction.getMembersList().get(0).getDMG().size() +
                transaction.getCommonSegments().getDTP().size() +
                transaction.getCommonSegments().getST().size() +
                transaction.getCommonSegments().getSE().size() +
                transaction.getCommonSegments().getREF().size() +
                transaction.getCommonSegments().getN1().size() +
                transaction.getCommonSegments().getQTY().size() +
                transaction.getCommonSegments().getBGN().size();
    }

    private void validateMemSeg(List<Ob834DetailsEntity> entityList){
        for( Ob834DetailsEntity entity: entityList){
           List<Member> memberSegmentsList = transaction.getMembersList();
            for(Member member: memberSegmentsList){
                if(entity.getMember_first_name().contains(member.getNM1().get(0).get(3))){
                    System.out.println("validating the member segments for :::::::::::::"+member.getNM1().get(0).get(3));
                    validateSegments(member, entity);
                    break;
                }
            }
        }
    }

    private void getOb834MedEntityForSubscriber(){
        List<Ob834DetailsEntity> medicalEntityList = SharedData.getOb834DetailsMedEntities();
        for(Ob834DetailsEntity medEntity:medicalEntityList){
            if(medEntity.getMember_first_name().toLowerCase().contains("primary")){
                subscriberMedEntity = medEntity;
                break;
            }
        }
    }

    private void getOb834DenEntityForSubscriber(){
        List<Ob834DetailsEntity> dentalEntityList = SharedData.getOb834DetailsDenEntities();
        for(Ob834DetailsEntity denEntity:dentalEntityList){
            if(denEntity.getMember_first_name().toLowerCase().contains("primary")){
                subscriberDenEntity = denEntity;
                break;
            }
        }
    }

    private void getDataByEmailAndAccNum(){
        // With 1 group updatedTransactionList will have only one Transaction.
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();
        String email = SharedData.getPrimaryMember().getEmailId();
        List<Transaction> updatedTransactionList = new ArrayList<>();
        List<Transaction> transactionList = edi834TransactionDetails.getTransactionList();
        for(Transaction trans: transactionList) {
            String primaryEmailFromEdiFile = trans.getMembersList().get(0).getPER().get(0).get(5);
            if( primaryEmailFromEdiFile.equals(email)) {
                updatedTransactionList.add(trans);
            }
        }
        edi834TransactionDetails.setTransactionList(updatedTransactionList);
        SharedData.setEdi834TransactionDetails(edi834TransactionDetails);
        edi834TransactionDetails = SharedData.getEdi834TransactionDetails();

        transactionList = edi834TransactionDetails.getTransactionList();
        transaction = transactionList.get(0); // 1 group will have only 1 transaction after updating with accNum and emailId
    }

    private void setN1SegList(){
        Collections.addAll(n1ListWithSepReason, "PRE AMT 1", "APTC AMT", "CSR AMT", "RATING AREA", "SOURCE EXCHANGE ID", "TOT RES AMT", "PRE AMT TOT", "SEP REASON");
        Collections.addAll(n1ListWithAddtlMaintReas, "ADDL MAINT REASON", "PRE AMT 1", "APTC AMT", "CSR AMT", "RATING AREA", "SOURCE EXCHANGE ID", "TOT RES AMT", "PRE AMT TOT");
        Collections.addAll(n1ListWithSepReasonMem, "PRE AMT 1", "SEP REASON");
        Collections.addAll(n1ListWithAddtlMaintReasMem, "ADDL MAINT REASON", "PRE AMT 1");
    }
}
