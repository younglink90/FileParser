package com.satorimaiden.xml;

import com.satorimaiden.xml.logics.BaseLogicComparator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.stream.Collectors;

@XmlAccessorType(XmlAccessType.NONE)
public class Rule {

    @XmlElement
    private String field;
    @XmlElement(name = "logic")
    private List<Logic> logicList;
    @XmlElement
    private String containsValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<BaseLogicComparator> getLogicList() {
        return logicList.stream()
                .map(BaseLogicComparator::of)
                .collect(Collectors.toList());
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
