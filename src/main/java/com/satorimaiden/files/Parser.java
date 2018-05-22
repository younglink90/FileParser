package com.satorimaiden.files;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Parser {

    private List<String> values;

    public Parser(String separator, String row) {
        values = Stream.of(row)
                .flatMap(r -> Arrays.stream(r.split(separator)))
                .collect(Collectors.toList());
    }

    public List<String> getValues() {
        return values;
    }
}
