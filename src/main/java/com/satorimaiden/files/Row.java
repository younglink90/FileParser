package com.satorimaiden.files;

public class Row extends Parser {

    private Header header;

    public Row(String separator, String row, Header header) {
        super(separator, row);
        this.header = header;
    }

    public String getValue(String headerValue) {
        int position = header.getValues().indexOf(headerValue);
        return getValues().get(position);
    }
}
