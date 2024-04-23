package com.c4hco.test.automation.Dto.Edi;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import java.util.List;

@Data @JsonIgnoreType
public class CommonSegments {
    private List<List<String>> ST;
    private List<List<String>> DTP;
    private List<List<String>> REF;
    private List<List<String>> N1;
    private List<List<String>> QTY;
    private List<List<String>> BGN;
}
