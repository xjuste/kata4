package com.toutjuste.kata4.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Kata4Response {
    private final static String descriptionPattern = "^[a-zA-Z0-9 ]+$";

    // format for version like x.y.z ex:  1.0.1
    private final static String apiVersionPattern = "(?!\\.)(\\d+(\\.\\d+)+)(?![\\d\\.])$";


    @NotNull
    @Pattern(regexp=descriptionPattern)
    private String description;

    @NotNull
    @Pattern(regexp=apiVersionPattern)
    @JsonProperty("api_version")
    private String apiVersion;

    public Kata4Response(@NotNull @Pattern(regexp = descriptionPattern) String description, @NotNull @Pattern(regexp = apiVersionPattern) String apiVersion) {
        this.description = description;
        this.apiVersion = apiVersion;
    }

    public Kata4Response() {
    }

    public String getDescription() {
        return description;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
