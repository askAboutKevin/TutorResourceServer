package com.tutor.resource.dal.dao;

import java.util.List;
import com.tutor.resource.dal.mapper.PartnerUniversityMapper;
import com.tutor.resource.model.PartnerUniversity;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;


public interface PartnerUniversityDAO {

    @SqlQuery("SELECT id, name, street_address, city, state, zip_code FROM Partner_University")
    @RegisterRowMapper(PartnerUniversityMapper.class)
    List<PartnerUniversity> selectAllPartnerUniversities();

    @SqlQuery("SELECT id, name, street_address, city, state, zip_code FROM Partner_University WHERE id = ?")
    @RegisterRowMapper(PartnerUniversityMapper.class)
    PartnerUniversity selectPartnerUniversityById(int id);

    @SqlUpdate("INSERT INTO Partner_University (name, street_address, city, state, zip_code) VALUES (?, ?, ?, ?, ?)")
    int insertPartnerUniversity(String name, String streetAddress, String city, String state, String zipCode);

    @SqlUpdate("UPDATE Partner_University SET name = ?, street_address = ?, city = ?, state = ?, zip_code = ? WHERE id = ?")
    int updatePartnerUniversity(String name, String streetAddress, String city, String state, String zipCode, int id);

    @SqlUpdate("DELETE FROM Partner_University WHERE id = ?")
    int deletePartnerUniversity(int id);
}
