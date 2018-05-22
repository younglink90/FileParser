package com.satorimaiden.xml.logics;

import com.satorimaiden.pojo.Logic;

public class Equals extends BaseLogicComparator {

    public Equals(Logic logic) {
        super(logic);
    }

    @Override
    public boolean test(String s) {
        return getValue().equals(s);
    }
}
