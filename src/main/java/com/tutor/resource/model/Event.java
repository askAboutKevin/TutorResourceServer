package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    private int id;
    private String title;
    private String start;
    private String end;
    private String location;
    private String contact;
    private String details;
    private String reoccurring;

    public Event(int id, String title, String start, String end, String location, String contact, String details, String reoccurring) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.location = location;
        this.contact = contact;
        this.details = details;
        this.reoccurring = reoccurring;
    }

    @JsonCreator
    public Event(
            @JsonProperty("title") String title,
            @JsonProperty("start") String start,
            @JsonProperty("end") String end,
            @JsonProperty("location") String location,
            @JsonProperty("contact") String contact,
            @JsonProperty("details") String details,
            @JsonProperty("reoccurring") String reoccurring
    ) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.location = location;
        this.contact = contact;
        this.details = details;
        this.reoccurring = reoccurring;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getReoccurring() {
        return reoccurring;
    }

    public void setReoccurring(String reoccurring) {
        this.reoccurring = reoccurring;
    }
}

