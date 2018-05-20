package com.satorimaiden.xml.logics;


import com.satorimaiden.xml.Logic;

public class Contains extends BaseLogicComparator {

    public Contains(Logic logic) {
        super(logic);
    }

    @Override
    public boolean test(String s) {
        return value.contains(s);
    }
}
