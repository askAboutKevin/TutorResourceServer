package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Student {

    private int id;
    private int tutorDailyTrackerId;
    private int school;
    private String firstName;
    private String lastName;

    public Student(int id, int tutorDailyTrackerId, int school, String firstName, String lastName) {
        this.id = id;
        this.tutorDailyTrackerId = tutorDailyTrackerId;
        this.school = school;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Constructor for incoming requests
    @JsonCreator
    public Student(@JsonProperty("tutor_id") int tutorDailyTrackerId, @JsonProperty("school") int school, @JsonProperty("firstname") String firstName, @JsonProperty("lastname") String lastName) {
        this.tutorDailyTrackerId = tutorDailyTrackerId;
        this.school = school;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("tutor_id")
    public int getTutorDailyTrackerId() {
        return tutorDailyTrackerId;
    }

    public void setTutorDailyTrackerId(int tutorDailyTrackerId) {
        this.tutorDailyTrackerId = tutorDailyTrackerId;
    }

    @ColumnName("school")
    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @ColumnName("first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @ColumnName("last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {  this.lastName = lastName; }
}
