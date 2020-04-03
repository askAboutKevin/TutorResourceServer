package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.TutorMapper;
import com.tutor.resource.model.Tutor;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.List;


public interface TutorDAO {

    @SqlQuery("SELECT id, topic, first_name, last_name, school, university, supervisor, department, salt, password, email, number, daily_tracker_id FROM Tutor")
    @RegisterRowMapper(TutorMapper.class)
    List<Tutor> selectAllTutors();

    @SqlQuery("SELECT id, topic, first_name, last_name, school, university, supervisor, department, salt, password_hash, email, number, daily_tracker_id FROM Tutor WHERE id = ?")
    @RegisterRowMapper(TutorMapper.class)
    Tutor selectTutorById(String id);

    @SqlQuery("SELECT id, topic, first_name, last_name, school, university, supervisor, department, salt, password_hash, email, number, daily_tracker_id FROM Tutor WHERE id = ?")
    @RegisterRowMapper(TutorMapper.class)
    Tutor selectTutorByEmail(String email);

    @SqlUpdate("INSERT INTO Tutor (id, topic, first_name, last_name, school, university, supervisor, department, salt, password, email, number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
    int insertTutor(String id, String topic, String firstName, String lastName, int school, int university, String supervisor, int department, String salt, String password, String email, String number);

    @SqlUpdate("UPDATE Tutor SET salt = ?, password = ?, email = ?, number = ? WHERE id = ?")
    int updateTutorUsernamePassword(String salt, String password, String email, String number, String id);

    @SqlUpdate("DELETE FROM Tutor WHERE id = ?")
    int deleteTutor(String id);

}
