package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Date;

public class PartnerUniversity {

    private int id;
    private String name;
    private String street_address;
    private String city;
    private String state;
    private String zip_code;
    private String country;
    private String supervisor;

    public PartnerUniversity(int id, String name, String street_address, String city, String state, String zip_code, String country, String supervisor) {
        this.id = id;
        this.name = name;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.country = country;
        this.supervisor = supervisor;
    }

    // Constructor for incoming requests
    @JsonCreator
    public PartnerUniversity(@JsonProperty("name") String name,
                             @JsonProperty("streetAddress") String street_address,
                             @JsonProperty("city") String city,
                             @JsonProperty("state") String state,
                             @JsonProperty("zipCode") String zip_code,
                             @JsonProperty("country") String country,
                             @JsonProperty("supervisor") String supervisor) {
        this.name = name;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.country = country;
        this.supervisor = supervisor;
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

    @ColumnName("street_address")
    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    @ColumnName("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ColumnName("state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @ColumnName("zip_code")
    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @ColumnName("country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ColumnName("supervisor")
    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
}