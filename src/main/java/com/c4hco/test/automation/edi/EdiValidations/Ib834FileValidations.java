package com.c4hco.test.automation.edi.EdiValidations;

import com.c4hco.test.automation.Dto.Edi.Edi834.Edi834TransactionDetails;
import com.c4hco.test.automation.Dto.Edi.Edi834.Transaction;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ib834FileValidations {
    Edi834TransactionDetails ib834TransactionDetails = null;
    Transaction transaction = null;

    List<String> n1ListWithAddtlMaintReas = new ArrayList<>();

    List<String> n1ListWithAddtlMaintReasMem = new ArrayList<>();
    int segCount = 0;
    int insSegCount = 0;
    SoftAssert softAssert = new SoftAssert();
    public Ib834FileValidations(){
        setN1SegList();
    }
    public void validateIb834MedFile(String medFileName) {

    }
    public void validateIb834DenFile(String denFileName){

    }

    private void setN1SegList() {
        Collections.addAll(n1ListWithAddtlMaintReas, "ADDL MAINT REASON");
        Collections.addAll(n1ListWithAddtlMaintReasMem, "ADDL MAINT REASON");
    }
}
