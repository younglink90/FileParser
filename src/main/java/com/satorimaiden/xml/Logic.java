package com.satorimaiden.xml;

import com.satorimaiden.enums.Limit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Logic {

    @XmlAttribute
    private String type;
    @XmlAttribute
    private String limit;
    @XmlAttribute
    private int count;
    @XmlElement
    private String toFile;
    @XmlElement
    private String toField;
    @XmlElement
    private String value;

    public Limit getLimit() {
        return Limit.of(limit);
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
