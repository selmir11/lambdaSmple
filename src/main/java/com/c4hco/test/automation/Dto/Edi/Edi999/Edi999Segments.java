package com.c4hco.test.automation.Dto.Edi.Edi999;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Edi999Segments {
    @JsonProperty("ISA")
    private JSONArray ISA;
    @JsonProperty("IEA")
    private JSONArray IEA;
    @JsonProperty("GS")
    private JSONArray GS;
    @JsonProperty("GE")
    private JSONArray GE;
    @JsonProperty("ST")
    private JSONArray ST;
    @JsonProperty("SE")
    private JSONArray SE;
    @JsonProperty("AK1")
    private JSONArray AK1;
    @JsonProperty("AK2")
    private JSONArray AK2;
    @JsonProperty("AK9")
    private JSONArray AK9;
    @JsonProperty("IK5")
    private JSONArray IK5;
}
