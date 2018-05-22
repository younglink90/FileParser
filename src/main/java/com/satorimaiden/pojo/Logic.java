package com.satorimaiden.pojo;

import com.satorimaiden.enums.Limit;

public class Logic {

    private String type;
    private Limit limit;
    private int count;
    private String value;
    private File toFile;
    private String toField;
    private File fromFile;
    private String fromField;

    public Logic(com.satorimaiden.xml.Logic logic, File file, Rule rule) {
        this.type = logic.getType();
        this.limit = logic.getLimit();
        this.count = logic.getCount();
        this.toField = logic.getToField();
        this.toFile = File.getById(logic.getToFile());
        this.fromField = rule.getField();
        this.fromFile = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
