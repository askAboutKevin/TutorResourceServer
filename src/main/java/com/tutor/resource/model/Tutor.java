package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Tutor {

    private String id;
    private boolean attendedOrientation;
    private int daily_tracker_id;
    private String topic;
    private String first_name;
    private String last_name;
    private int school;
    private int university;
    private String supervisor;
    private int department;
    private String salt;
    private String password_hash;
    private String email;
    private String contact_number;
    private String last_logged_in;
    private String last_four_ssn;
    private String image;

    public Tutor(String id, boolean attendedOrientation, int daily_tracker_id, String topic, String first_name, String last_name, int school, int university, String supervisor, int department, String salt, String password_hash, String email, String contact_number, String last_logged_in, String last_four_ssn, String image) {
        this.id = id;
        this.attendedOrientation = attendedOrientation;
        this.daily_tracker_id = daily_tracker_id;
        this.topic = topic;
        this.first_name = first_name;
        this.last_name = last_name;
        this.school = school;
        this.university = university;
        this.supervisor = supervisor;
        this.department = department;
        this.salt = salt;
        this.password_hash = password_hash;
        this.email = email;
        this.contact_number = contact_number;
        this.last_logged_in = last_logged_in;
        this.last_four_ssn = last_four_ssn;
        this.image = image;
    }

    // Constructor for incoming requests
    @JsonCreator
    public Tutor(@JsonProperty("topic") String topic,
                 @JsonProperty("first") String first_name,
                 @JsonProperty("last") String last_name,
                 @JsonProperty("university") int university,
                 @JsonProperty("supervisor") String supervisor,
                 @JsonProperty("department") int department,
                 @JsonProperty("password") String password_hash,
                 @JsonProperty("email") String email,
                 @JsonProperty("number") String contact_number ){
        this.topic = topic;
        this.first_name = first_name;
        this.last_name = last_name;
        this.university = university;
        this.supervisor = supervisor;
        this.department = department;
        this.password_hash = password_hash;
        this.email = email;
        this.contact_number = contact_number;
    }

    @ColumnName("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ColumnName("attended_orientation")
    public boolean isAttendedOrientation() {
        return attendedOrientation;
    }

    public void setAttendedOrientation(boolean attendedOrientation) {
        this.attendedOrientation = attendedOrientation;
    }

    @ColumnName("daily_tracker_id")
    public int getDaily_tracker_id() {
        return daily_tracker_id;
    }

    public void setDaily_tracker_id(int daily_tracker_id) {
        this.daily_tracker_id = daily_tracker_id;
    }

    @ColumnName("topic")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @ColumnName("first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @ColumnName("last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @ColumnName("school")
    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    @ColumnName("university")
    public int getUniversity() {
        return university;
    }

    public void setUniversity(int university) {
        this.university = university;
    }

    @ColumnName("supervisor")
    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @ColumnName("department")
    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @ColumnName("salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @ColumnName("password")
    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    @ColumnName("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ColumnName("number")
    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    @ColumnName("last_logged_in")
    public String getLast_logged_in() {
        return last_logged_in;
    }

    public void setLast_logged_in(String last_logged_in) {
        this.last_logged_in = last_logged_in;
    }

    @ColumnName("ssn")
    public String getLast_four_ssn() {
        return last_four_ssn;
    }

    public void setLast_four_ssn(String last_four_ssn) {
        this.last_four_ssn = last_four_ssn;
    }

    @ColumnName("image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}