package com.satorimaiden;

import com.satorimaiden.files.Record;
import com.satorimaiden.files.Rule;
import com.satorimaiden.pojo.File;
import com.satorimaiden.xml.Config;

import java.util.List;
import java.util.stream.Collectors;

public class RuleExecutor {

    private List<Record> recordList;
    private List<Rule> ruleList;
    private List<File> fileList;

    public RuleExecutor() {
        this.fileList = Config.get().getFiles().stream().map(File::new).collect(Collectors.toList());
        this.recordList = fileList.stream().map(Record::new).collect(Collectors.toList());
        this.ruleList = fileList.stream().flatMap(file -> file.getRules().stream())
                .flatMap(rule -> rule.getLogicList().stream())
                .map(logic -> new Rule(getRecordByFile(logic.getFromFile()), getRecordByFile(logic.getToFile()), logic))
                .collect(Collectors.toList());
    }

    public void start() {
        ruleList.stream()
                .forEach(this::executeRule);
    }

    private void executeRule(Rule rule) {
        
    }

    private Record getRecordByFile(File file) {
        return recordList.stream()
                .filter(record -> record.getId().equals(file.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
