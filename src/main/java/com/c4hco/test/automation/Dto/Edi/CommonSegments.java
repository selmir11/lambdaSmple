package com.c4hco.test.automation.Dto.Edi;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data @JsonIgnoreType
public class CommonSegments {
    @JsonProperty("ST")
    private List<List<String>> ST;
    @JsonProperty("DTP")
    private List<List<String>> DTP;
    @JsonProperty("REF")
    private List<List<String>> REF;
    @JsonProperty("N1")
    private List<List<String>> N1;
    @JsonProperty("ISA")
    private List<List<String>> ISA; // should remove?
    @JsonProperty("QTY")
    private List<List<String>> QTY;
    @JsonProperty("BGN")
    private List<List<String>> BGN;
    @JsonProperty("GS")
    private List<List<String>> GS; // should remove ?
    // Include SE
}
