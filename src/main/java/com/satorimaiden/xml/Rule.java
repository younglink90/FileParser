package com.satorimaiden.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Rule {

    private String field;
    @XmlElement(name = "logic")
    private List<Logic> logicList;
    private String containsValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<Logic> getLogicList() {
        return logicList;
    }

    public void setLogicList(List<Logic> logicList) {
        this.logicList = logicList;
    }

    public String getContainsValue() {
        return containsValue;
    }

    public void setContainsValue(String containsValue) {
        this.containsValue = containsValue;
    }
}
