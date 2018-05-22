package com.satorimaiden.pojo;

import com.satorimaiden.xml.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class File {

    private String id;
    private String name;
    private String separator;
    private List<Rule> rules = new ArrayList<>();

    public File(com.satorimaiden.xml.File file) {
        this.id = file.getId();
        this.name = file.getName();
        this.separator = file.getSeparator();
        this.rules = file.getRules().stream()
            .map(rule -> new Rule(rule, this))
            .collect(Collectors.toList());
    }

    public static File getById(String id) {
        return Config.get().getFiles().stream()
                .filter(file -> file.getId().equals(id))
                .findFirst()
                .map(File::new)
                .get();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
