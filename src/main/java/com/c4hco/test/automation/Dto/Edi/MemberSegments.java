package com.c4hco.test.automation.Dto.Edi;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import java.util.List;

@Data @JsonIgnoreType
public class MemberSegments {
    private List<List<String>> DTP;
    private List<List<String>> LUI;
    private List<List<String>> N1;
    private List<List<String>> N3;
    private List<List<String>> HLH;
    private List<List<String>> N4;
    private List<List<String>> LS;
    private List<List<String>> LX;
    private List<List<String>> INS;
    private List<List<String>> REF;
    private List<List<String>> NM1;
    private List<List<String>> LE;
    private List<List<String>> PER;
    private List<List<String>> HD;
    private List<List<String>> DMG;
}
