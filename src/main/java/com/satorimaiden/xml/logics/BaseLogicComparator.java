package com.satorimaiden.xml.logics;

import com.satorimaiden.pojo.File;
import com.satorimaiden.pojo.Logic;

import java.util.function.Predicate;

public abstract class BaseLogicComparator implements Predicate<String> {

    private File fromFile;
    private String fromField;
    private File toFile;
    private String toField;
    private String value;

    protected BaseLogicComparator(Logic logic) {
        this.toField = logic.getToField();
        this.toFile = logic.getToFile();
        this.fromField = logic.getFromField();
        this.fromFile = logic.getFromFile();
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

    public File getToFile() {
        return toFile;
    }

    public void setToFile(File toFile) {
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

    public File getFromFile() {
        return fromFile;
    }

    public void setFromFile(File fromFile) {
        this.fromFile = fromFile;
    }

    public String getFromField() {
        return fromField;
    }

    public void setFromField(String fromField) {
        this.fromField = fromField;
    }
}
