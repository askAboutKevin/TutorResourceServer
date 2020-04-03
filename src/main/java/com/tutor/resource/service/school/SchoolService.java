package com.tutor.resource.service.school;

import com.tutor.resource.model.School;

import java.util.List;

public interface SchoolService {

    List<School> getAll();

    School getById(int id);

    int updateSchool(String name, String streetAddress, String city, String state, String zipCode, String ncesNumber, String longitude, String latitude, String siteSupervisor, int id);

    int addSchool(String name, String streetAddress, String city, String state, String zipCode, String ncesNumber, String siteSupervisor);

    int deleteSchool(int id);
}
