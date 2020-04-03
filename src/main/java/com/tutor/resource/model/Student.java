package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Student {

    private int id;
    private int tutor_id;
    private int school;
    private String name;

    public Student(int id, int tutor_id, int school, String name) {
        this.id = id;
        this.tutor_id = tutor_id;
        this.school = school;
        this.name = name;
    }

    // Constructor for incoming requests
    @JsonCreator
    public Student(@JsonProperty("tutor_id") int tutor_id, @JsonProperty("school") int school, @JsonProperty("name") String name) {
        this.tutor_id = tutor_id;
        this.school = school;
        this.name = name;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("tutor_id")
    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    @ColumnName("school")
    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @ColumnName("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
