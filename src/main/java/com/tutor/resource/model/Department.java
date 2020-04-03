package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Department {

    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public Department(@JsonProperty("name") String name) {
        this.name = name;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
