package com.arep.parcial;

public class SearchResponse {
    private String operation;
    private String inputlist;
    private String value;
    private String output;

    public SearchResponse(String operation, String inputlist, String value, String output) {
        this.operation = operation;
        this.inputlist = inputlist;
        this.value = value;
        this.output = output;
    }

    public String getOperation() {
        return operation;
    }

    public String getInputlist() {
        return inputlist;
    }

    public String getValue() {
        return value;
    }

    public String getOutput() {
        return output;
    }
}