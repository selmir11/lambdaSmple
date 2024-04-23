package com.c4hco.test.automation.Dto.Edi;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;
import org.json.JSONArray;

import java.util.Map;

@Data @JsonIgnoreType
public class Edi834TransactionDetails {
    Map<String, JSONArray> newMemberSegmentsMap;
    Map<String, JSONArray> newCommonSegInTransMap;

    Map<String, MemberSegments> memberSegmentsMap;
    Map<String, CommonSegments> commonSegmentsInTransMap;
}
