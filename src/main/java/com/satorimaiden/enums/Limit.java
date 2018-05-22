package com.satorimaiden.enums;

public enum Limit {
    ONE_TO_MANY, ONE_TO_ONE;

    public static Limit of(String value) {
        if(value == null)
            return null;

        value = value.toUpperCase();
        switch (value) {
            case "1TOMANY":
                return ONE_TO_MANY;
            case "1TO1":
                return ONE_TO_ONE;
            default:
                return null;
        }
    }

}
