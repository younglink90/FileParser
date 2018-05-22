package com.satorimaiden.pojo;

import com.satorimaiden.xml.logics.BaseLogicComparator;

import java.util.List;
import java.util.stream.Collectors;

public class Rule {

    private String field;
    private List<BaseLogicComparator> logicList;
    private String containsValue;

    public Rule(com.satorimaiden.xml.Rule rule, File file) {
        this.field = rule.getField();
        this.containsValue = rule.getContainsValue();
        this.logicList = rule.getLogicList().stream()
            .map(logic -> new Logic(logic, file, this))
            .map(BaseLogicComparator::of)
            .collect(Collectors.toList());
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<BaseLogicComparator> getLogicList() {
        return logicList;
    }

    public void setLogicList(List<BaseLogicComparator> logicList) {
        this.logicList = logicList;
    }

    public String getContainsValue() {
        return containsValue;
    }

    public void setContainsValue(String containsValue) {
        this.containsValue = containsValue;
    }
}
