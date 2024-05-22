package com.c4hco.test.automation.Dto.Edi;

import lombok.Data;

import java.util.List;
@Data
public class Transaction {
    private CommonSegments commonSegments;
    private List<Member> membersList;
//    public List<Member> getMembersList() {
//        return membersList;
//    }
//
//    public void setMembersList(List<Member> membersList) {
//        this.membersList = membersList;
//    }
//
//    public CommonSegments getCommonSegments() {
//        return commonSegments;
//    }
//
//    public void setCommonSegments(CommonSegments commonSegments) {
//        this.commonSegments = commonSegments;
//    }


}
