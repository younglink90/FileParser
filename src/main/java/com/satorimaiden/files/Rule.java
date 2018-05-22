package com.satorimaiden.files;

import com.satorimaiden.xml.logics.BaseLogicComparator;

import java.util.stream.Stream;

public class Rule {

    private Record mainFile;
    private Record comparedFile;
    private BaseLogicComparator logic;

    public Rule(Record mainFile, Record comparedFile, BaseLogicComparator logic) {
        this.mainFile = mainFile;
        this.comparedFile = comparedFile;
        this.logic = logic;
    }

    public BaseLogicComparator getLogic() {
        return logic;
    }

    public Stream<Row> parsedRows() {
        return null;
    }
}
