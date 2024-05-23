package com.c4hco.test.automation.Dto.Edi;

import lombok.Data;

import java.util.List;
@Data
public class Transaction {
    private CommonSegments commonSegments;
    private List<Member> membersList;
}
