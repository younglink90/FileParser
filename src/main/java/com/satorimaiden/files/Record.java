package com.satorimaiden.files;

import com.satorimaiden.xml.File;
import com.satorimaiden.xml.Rule;
import com.satorimaiden.xml.logics.BaseLogicComparator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Record {

    private String id;
    private Path path;
    private File file;
    private Header header;
    private List<BaseLogicComparator> logicList = new ArrayList<>();

    public Record(File file) {
        this.path = Paths.get(file.getName());
        this.file = file;
        this.id = file.getId();
        file.getRules().stream().map(Rule::getLogicList).forEach(logicList::addAll);

        try (Stream<String> stringStream = Files.lines(path)) {
            this.header = new Header(file.getSeparator(), stringStream.limit(1).findFirst().get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Row> stream() throws Exception {
        return Files.lines(path).map(row -> new Row(file.getSeparator(), row, header)).skip(1);
    }
}
