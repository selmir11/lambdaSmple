package com.c4hco.test.automation.Dto.Edi;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor @JsonIgnoreType
public class CommonEDISegments {
    @JsonProperty("ISA")
    private List<List<String>> ISA;
    @JsonProperty("IEA")
    private List<List<String>> IEA;
    @JsonProperty("GS")
    private List<List<String>> GS;
    @JsonProperty("GE")
    private List<List<String>> GE;
    @JsonProperty("QTY")
    private List<List<String>> QTY;
    @JsonProperty("BGN")
    private List<List<String>> BGN;
}
