package com.c4hco.test.automation.Dto.Edi.Edi834;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data @JsonIgnoreType
public class Member {
    @JsonProperty("DTP")
    private List<List<String>> DTP;
    @JsonProperty("LUI")
    private List<List<String>> LUI;
    @JsonProperty("N1")
    private List<List<String>> N1;
    @JsonProperty("N3")
    private List<List<String>> N3;
    @JsonProperty("HLH")
    private List<List<String>> HLH;
    @JsonProperty("N4")
    private List<List<String>> N4;
    @JsonProperty("LS")
    private List<List<String>> LS;
    @JsonProperty("LX")
    private List<List<String>> LX;
    @JsonProperty("INS")
    private List<List<String>> INS;
    @JsonProperty("REF")
    private List<List<String>> REF;
    @JsonProperty("NM1")
    private List<List<String>> NM1;
    @JsonProperty("LE")
    private List<List<String>> LE;
    @JsonProperty("PER")
    private List<List<String>> PER;
    @JsonProperty("HD")
    private List<List<String>> HD;
    @JsonProperty("DMG")
    private List<List<String>> DMG;
}
