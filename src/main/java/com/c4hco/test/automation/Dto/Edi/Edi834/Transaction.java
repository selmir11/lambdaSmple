package com.c4hco.test.automation.Dto.Edi.Edi834;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    private CommonSegments commonSegments;
    private List<Member> membersList;
}
