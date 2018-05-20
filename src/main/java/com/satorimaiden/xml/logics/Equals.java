package com.satorimaiden.xml.logics;

import com.satorimaiden.xml.Logic;

public class Equals extends BaseLogicComparator {

    public Equals(Logic logic) {
        super(logic);
    }

    @Override
    public boolean test(String s) {
        return value.equals(s);
    }
}
