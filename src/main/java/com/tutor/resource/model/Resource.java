package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Resource {

    private int id;
    private String title;
    private String locator;
    private int owner;

    public Resource(int id, String title, String locator, int owner) {
        this.id = id;
        this.title = title;
        this.locator = locator;
        this.owner = owner;
    }

    // Constructor for incoming requests
    @JsonCreator
    public Resource(@JsonProperty("title") String title,
                    @JsonProperty("locator") String locator,
                    @JsonProperty("owner") int owner) {
        this.title = title;
        this.locator = locator;
        this.owner = owner;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ColumnName("locator")
    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    @ColumnName("owner")
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
