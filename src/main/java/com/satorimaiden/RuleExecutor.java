package com.satorimaiden;

import com.satorimaiden.files.Record;
import com.satorimaiden.pojo.File;
import com.satorimaiden.pojo.Rule;
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
        this.ruleList = fileList.stream().flatMap(file -> file.getRules().stream()).collect(Collectors.toList());
    }

    public void start() {
        recordList.stream()
                .map(Record::getLogicList)
                .forEach(System.out::println);
    }
}
