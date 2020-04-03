package com.tutor.resource.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class PayPeriod {

    private int id;
    private int school;
    private String start;
    private String end;
    private String payServeNo;
    private String comments;

    public PayPeriod(int id, int school, String start, String end, String payServeNo, String comments) {
        this.id = id;
        this.school = school;
        this.start = start;
        this.end = end;
        this.payServeNo = payServeNo;
        this.comments = comments;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("school")
    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @ColumnName("start")
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @ColumnName("end")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @ColumnName("pay_serve_no")
    public String getPayServeNo() {
        return payServeNo;
    }

    public void setPayServeNo(String payServeNo) {
        this.payServeNo = payServeNo;
    }

    @ColumnName("comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}