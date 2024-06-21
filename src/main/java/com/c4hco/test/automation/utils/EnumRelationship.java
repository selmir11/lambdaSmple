package com.c4hco.test.automation.utils;

import lombok.Getter;

@Getter
public enum EnumRelationship {
    Mother("03"),
    Father("03"),
    Child("19"),
    Self("18"),
    Spouse("01"),
    GrandChild("05"),
    Brother("14"),
    Sister("14");

    private final String RelCode;
    EnumRelationship(String RelCode) {
        this.RelCode = RelCode;
    }


    public static String getCodeForRelationship(String relationshipName){
        for (EnumRelationship enumRelationship : EnumRelationship.values()){
            if (enumRelationship.name().equalsIgnoreCase((relationshipName))) {
                return enumRelationship.getRelCode();
            }
        }
        throw new IllegalArgumentException("Unknown Relationship: " + relationshipName);
    }
}
