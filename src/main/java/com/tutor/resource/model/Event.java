package com.tutor.resource.model;

import java.util.Date;

public class Event {

    private int id;
    private String title;
    private Date start;
    private Date end;
    private String location;
    private String contact;
    private String details;
    private String reoccurring;

    public Event(int id, String title, Date start, Date end, String location, String contact, String details, String reoccurring) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.location = location;
        this.contact = contact;
        this.details = details;
        this.reoccurring = reoccurring;
    }

    public Event(String title, Date start, Date end, String location, String contact, String details, String reoccurring) {
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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

