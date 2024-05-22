package com.c4hco.test.automation.Dto.Edi;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Edi834TransactionDetails {
    private List<Transaction> transactionList;
   // private CommonEDISegments commonEDISegments;
//    public List<Transaction> getTransactionList() {
//        return transactionList;
//    }
//
//    public void setTransactionList(List<Transaction> transactionList) {
//        this.transactionList = transactionList;
//    }
//
//    public CommonEDISegments getCommonEDISegments() {
//        return commonEDISegments;
//    }
//
//    public void setCommonEDISegments(CommonEDISegments commonEDISegments) {
//        this.commonEDISegments = commonEDISegments;
//    }


}
