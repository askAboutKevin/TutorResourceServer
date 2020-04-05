package com.tutor.resource.dal.dao;

import java.util.List;
import com.tutor.resource.dal.mapper.SchoolMapper;
import com.tutor.resource.model.School;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;


public interface SchoolDAO {

    @SqlQuery("SELECT id, registered, name, street_address, city, state, zip_code, nces_number, longitude, latitude, site_supervisor FROM School")
    @RegisterRowMapper(SchoolMapper.class)
    List<School> selectAllSchools();

    @SqlQuery("SELECT id, registered, name, street_address, city, state, zip_code, nces_number, longitude, latitude, site_supervisor FROM School WHERE id = ?")
    @RegisterRowMapper(SchoolMapper.class)
    School selectSchoolById(int id);

    @SqlUpdate("INSERT INTO School (name, street_address, city, state, zip_code, nces_number, longitude, latitude, site_supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")
    int insertSchool(String name, String streetAddress, String city, String state, String zipCode, String ncesNumber, String longitude, String latitude, String siteSupervisor);

//    @SqlUpdate("UPDATE School SET name = ?, street_address = ?, city = ?, state = ?, zip_code = ?, nces_number = ?, longitude = ?, latitude = ?, site_supervisor = ? WHERE id = ?")
//    int updateSchool(String name, String streetAddress, String city, String state, String zipCode, String ncesNumber, String longitude, String latitude, String siteSupervisor, int id);

    @SqlUpdate("DELETE FROM School WHERE id = ?")
    int deleteSchool(int id);

}
