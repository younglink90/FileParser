package com.satorimaiden.xml.logics;


import com.satorimaiden.pojo.Logic;

public class Contains extends BaseLogicComparator {

    public Contains(Logic logic) {
        super(logic);
    }

    @Override
    public boolean test(String s) {
        return getValue().contains(s);
    }
}
