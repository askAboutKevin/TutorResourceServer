package com.tutor.resource.service.school;

import com.tutor.resource.dal.dao.SchoolDAO;
import com.tutor.resource.model.School;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class SchoolServiceImpl implements SchoolService {

    private SchoolDAO schoolDAO;


    public SchoolServiceImpl(SchoolDAO schoolDAO) {
        super();
        this.schoolDAO = schoolDAO;
    }

    @Override
    public List<School> getAll() {
        return this.schoolDAO.selectAllSchools();
    }

    @Override
    public School getById(int id) {

        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.schoolDAO.selectSchoolById(id);
    }

    @Override
    public int updateSchool(String name, String streetAddress, String city, String state, String zipCode, String ncesNumber, String longitude, String latitude, String siteSupervisor, int id) {

        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        boolean updateSchoolSuccess = (
                1 == this.schoolDAO.updateSchool(name,
                        streetAddress,
                        city,
                        state,
                        zipCode,
                        ncesNumber,
                        longitude,
                        latitude,
                        siteSupervisor,
                        id
                ));

        if(updateSchoolSuccess) {
            return 1;
        }

        return 0;
    }

    @Override
    public int addSchool(String name, String streetAddress, String city, String state, String zipCode, String ncesNumber, String siteSupervisor) {

        // Call Google Maps API
        String longitude = "", latitude = "";

        boolean addSchoolSuccess = (
                1 == this.schoolDAO.insertSchool(name,
                        streetAddress,
                        city,
                        state,
                        zipCode,
                        ncesNumber,
                        longitude,
                        latitude,
                        siteSupervisor
                ));

        if(addSchoolSuccess) {
            return 1;
        }

        return 0;
    }

    @Override
    public int deleteSchool(int id) {

        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        boolean deletedSchoolSuccess = (
                1 == this.schoolDAO.deleteSchool(id));

        if(deletedSchoolSuccess) {
            return 1;
        }

        return 0;
    }
}
