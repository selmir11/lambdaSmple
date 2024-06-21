package com.c4hco.test.automation.utils;
import lombok.Getter;

@Getter
public enum Race {
    Asian("A"),
    Black("B"),
    Caucasian("C"),
    NativeAmerican("G"),
    White("O"),
    NotProvided("7")
    ;

    private final String RaceCode;
    Race(String RaceCode) {
        this.RaceCode = RaceCode;
    }

    public static String getCodeForRace(String RaceName){
        for (Race race : Race.values()){
            if (race.name().equalsIgnoreCase((RaceName))) {
                return race.getRaceCode();
            }
        }
        throw new IllegalArgumentException("Unknown Race: " + RaceName);
    }
}
