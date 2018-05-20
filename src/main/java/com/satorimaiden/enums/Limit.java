package com.satorimaiden.enums;

public enum Limit {
    ONE_TO_MANY, ONE_TO_ONE;

    public static Limit of(String value) {
        value = value.toUpperCase();
        switch (value) {
            case "1TOMANY":
                return ONE_TO_MANY;
            case "1TO1":
                return ONE_TO_ONE;
            default:
                throw new RuntimeException("Cannot parse limit");
        }
    }

}
