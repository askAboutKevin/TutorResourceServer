package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Shift {

    private int id;
    private String user;
    private String date;
    private String time_in;
    private String time_out;
    private String lunch_out;
    private String lunch_in;
    private boolean logged;
    private float totalTime;

    public Shift(int id, String user, String date, String time_in, String time_out, String lunch_out, String lunch_in, boolean logged, float totalTime) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
        this.lunch_out = lunch_out;
        this.lunch_in = lunch_in;
        this.logged = logged;
        this.totalTime = totalTime;
    }

    // Constructor for incoming requests
    @JsonCreator
    public Shift(@JsonProperty("user") String user,
                 @JsonProperty("date") String date,
                 @JsonProperty("timeIn") String time_in,
                 @JsonProperty("timeOut") String time_out,
                 @JsonProperty("lunchOut") String lunch_out,
                 @JsonProperty("lunchIn") String lunch_in) {
        this.user = user;
        this.date = date;
        this.time_in = time_in;
        this.time_out = time_out;
        this.lunch_out = lunch_out;
        this.lunch_in = lunch_in;
    }

    @ColumnName("total_time")
    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @ColumnName("date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ColumnName("time_in")
    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    @ColumnName("time_out")
    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    @ColumnName("lunch_out")
    public String getLunch_out() {
        return lunch_out;
    }

    public void setLunch_out(String lunch_out) {
        this.lunch_out = lunch_out;
    }

    @ColumnName("lunch_in")
    public String getLunch_in() {
        return lunch_in;
    }

    public void setLunch_in(String lunch_in) {
        this.lunch_in = lunch_in;
    }

    @ColumnName("logged")
    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}