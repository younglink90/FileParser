package com.satorimaiden;

import com.satorimaiden.files.Record;
import com.satorimaiden.xml.Config;

import java.util.List;
import java.util.stream.Collectors;

public class RuleExecutor {

    private Config config;
    private List<Record> recordList;

    private RuleExecutor(Config config) {
        this.config = config;
        this.recordList = config.getFiles().stream()
                .map(Record::new)
                .collect(Collectors.toList());
    }

    public static RuleExecutor of(Config config) {
        return new RuleExecutor(config);
    }

    public void start() {

    }
}
