package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class School {

    private int id;
    private String name;
    private String registered;
    private String streetAddress;
    private String city;
    private String state;
    private String zip_code;
    private String nces_number;
    private String longitude;
    private String latitude;
    private String site_supervisor;


    public School(int id, String name, String registered, String streetAddress, String city, String state, String zip_code, String nces_number, String longitude, String latitude, String site_supervisor) {
        this.id = id;
        this.name = name;
        this.registered = registered;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.nces_number = nces_number;
        this.longitude = longitude;
        this.latitude = latitude;
        this.site_supervisor = site_supervisor;
    }

    // Constructor for incoming requests
    @JsonCreator
    public School(@JsonProperty("name") String name,
                  @JsonProperty("streetAddress") String streetAddress,
                  @JsonProperty("city") String city,
                  @JsonProperty("state") String state,
                  @JsonProperty("zip") String zip_code,
                  @JsonProperty("nces") String nces_number,
                  @JsonProperty("supervisor") String site_supervisor) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.nces_number = nces_number;
        this.site_supervisor = site_supervisor;
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

    @ColumnName("registered")
    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    @ColumnName("street_address")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    @ColumnName("nces_number")
    public String getNces_number() {
        return nces_number;
    }

    public void setNces_number(String nces_number) {
        this.nces_number = nces_number;
    }

    @ColumnName("longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @ColumnName("latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    @ColumnName("site_supervisor")
    public String getSite_supervisor() {
        return site_supervisor;
    }

    public void setSite_supervisor(String site_supervisor) {
        this.site_supervisor = site_supervisor;
    }
}