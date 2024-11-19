package com.c4hco.test.automation.Dto.Edi.Edi834;

import com.c4hco.test.automation.Dto.Edi.Edi834.CommonSegments;
import com.c4hco.test.automation.Dto.Edi.Edi834.Member;
import lombok.Data;

import java.util.List;
@Data
public class Transaction {
    private CommonSegments commonSegments;
    private List<Member> membersList;
}
