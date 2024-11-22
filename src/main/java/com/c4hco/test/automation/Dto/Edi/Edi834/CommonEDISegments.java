package com.c4hco.test.automation.Dto.Edi.Edi834;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
@Data @NoArgsConstructor @AllArgsConstructor @JsonIgnoreType
public class CommonEDISegments {
    @JsonProperty("ISA")
    private JSONArray ISA;
    @JsonProperty("IEA")
    private JSONArray IEA;
    @JsonProperty("GS")
    private JSONArray GS;
    @JsonProperty("GE")
    private JSONArray GE;
}
