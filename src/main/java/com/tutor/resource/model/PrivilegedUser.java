package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class PrivilegedUser {


    private String id;
    private String firstName;
    private String last_name;
    private String salt;
    private String password_hash;
    private String email;
    private String contact_number;
    private String title;
    private String role;
    private String lastLoggedIn;
    private String picture;

    public PrivilegedUser(String id, String firstName, String last_name, String salt, String password_hash, String email, String contact_number, String title, String role, String lastLoggedIn, String picture) {
        this.id = id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.salt = salt;
        this.password_hash = password_hash;
        this.email = email;
        this.contact_number = contact_number;
        this.title = title;
        this.role = role;
        this.lastLoggedIn = lastLoggedIn;
        this.picture = picture;
    }

    // Constructor for incoming requests
    @JsonCreator
    public PrivilegedUser(@JsonProperty("first") String firstName,
                          @JsonProperty("last") String last_name,
                          @JsonProperty("password") String password_hash,
                          @JsonProperty("email") String email,
                          @JsonProperty("number") String contact_number,
                          @JsonProperty("title") String title,
                          @JsonProperty("role") String role,
                          @JsonProperty("picture") String picture
    ) {
        this.firstName = firstName;
        this.last_name = last_name;
        this.password_hash = password_hash;
        this.email = email;
        this.contact_number = contact_number;
        this.title = title;
        this.role = role;
        this.picture = picture;
    }

    @ColumnName("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ColumnName("first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @ColumnName("last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    @ColumnName("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ColumnName("role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ColumnName("last_logged_in")
    public String getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(String lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    @ColumnName("picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
