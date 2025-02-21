package com.c4hco.test.automation.utils;
import lombok.Getter;

@Getter
public enum Race {
    Asian("A"),
    Black("B"),
    BlackorAfricanAmerican("B"),
    Caucasian("C"),
    NativeAmerican("G"),
    WhiteorEuropean("C"),
    PreferNotToAnswer("7"),
    MiddleEasternorNorthAfrican("E"),
    NativeHawaiianorPacificIslander("J"),
    AsianorAsianAmerican("A"),
    NotListed("E"),
    HispanicorLatino("H");

    private final String RaceCode;
    Race(String RaceCode) {
        this.RaceCode = RaceCode;
    }

    public static String getCodeForRace(String RaceName){
        for (Race race : Race.values()){
            if (race.name().equalsIgnoreCase((RaceName.replace(" ", "")))) {
                return race.getRaceCode();
            }
        }
        throw new IllegalArgumentException("Unknown Race: " + RaceName);
    }
}
