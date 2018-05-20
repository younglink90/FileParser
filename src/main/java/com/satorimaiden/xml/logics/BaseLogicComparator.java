package com.satorimaiden.xml.logics;

import com.satorimaiden.xml.Logic;

import java.util.function.Predicate;

public abstract class BaseLogicComparator implements Predicate<String> {

    public String toFile;
    public String toField;
    public String value;

    protected BaseLogicComparator(Logic logic) {
        this.toField = logic.getToField();
        this.toFile = logic.getToFile();
    }

    public static BaseLogicComparator of(Logic logic) {
        switch(logic.getType().toUpperCase()) {
            case "EQUALS":
                return new Equals(logic);
            case "CONTAINS":
                return new Contains(logic);
            default:
                throw new RuntimeException("Error parsing logic type");
        }
    }

    public String getToFile() {
        return toFile;
    }

    public void setToFile(String toFile) {
        this.toFile = toFile;
    }

    public String getToField() {
        return toField;
    }

    public void setToField(String toField) {
        this.toField = toField;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
