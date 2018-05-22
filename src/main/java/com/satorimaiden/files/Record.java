package com.satorimaiden.files;

import com.satorimaiden.pojo.File;
import com.satorimaiden.pojo.Rule;
import com.satorimaiden.xml.logics.BaseLogicComparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Record {

    private String id;
    private Path path;
    private String separator;
    private Header header;
    private List<BaseLogicComparator> logicList = new ArrayList<>();

    public Record(File file) {
        this.path = Paths.get(file.getName());
        this.separator = file.getSeparator();
        this.id = file.getId();
        file.getRules().stream()
                .map(Rule::getLogicList)
                .forEach(logicList::addAll);

        try (Stream<String> stringStream = Files.lines(path)) {
            this.header = new Header(file.getSeparator(), stringStream.limit(1).findFirst().get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<BaseLogicComparator> getLogicList() {
        return logicList;
    }

    public Stream<Row> stream() {
        Stream<String> lines;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines.map(row -> new Row(separator, row, header)).skip(1);
    }

    public String getId() {
        return id;
    }

    public Path getPath() {
        return path;
    }

    public String getSeparator() {
        return separator;
    }

    public Header getHeader() {
        return header;
    }
}
