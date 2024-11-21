package com.c4hco.test.automation.Dto.Edi.Edi834;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data @JsonIgnoreType @JsonIgnoreProperties(ignoreUnknown = true)
public class CommonSegments {
    @JsonProperty("ST")
    private List<List<String>> ST;
    @JsonProperty("SE")
    private List<List<String>> SE;
    @JsonProperty("DTP")
    private List<List<String>> DTP;
    @JsonProperty("REF")
    private List<List<String>> REF;
    @JsonProperty("N1")
    private List<List<String>> N1;
    @JsonProperty("QTY")
    private List<List<String>> QTY;
    @JsonProperty("BGN")
    private List<List<String>> BGN;
}
