package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.StudentMapper;
import com.tutor.resource.model.Student;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.List;

public interface StudentDAO {

    @SqlQuery("SELECT id, tutor_id, school, name FROM Student")
    @RegisterRowMapper(StudentMapper.class)
    List<Student> selectAllStudents();

    @SqlQuery("SELECT id, tutor_id, school, name FROM Student WHERE id = ?")
    @RegisterRowMapper(StudentMapper.class)
    Student selectStudentById(int id);

    @SqlQuery("SELECT id, tutor_id, school, name FROM Student WHERE name = ?")
    @RegisterRowMapper(StudentMapper.class)
    Student selectStudentByName(String name);

    @SqlUpdate("INSERT INTO Student (tutor_id, school, name) VALUES (?, ?, ?)")
    int insertStudent(String tutor_id, int school, String name);

    @SqlUpdate("UPDATE Student SET tutor_id = ?, name = ? WHERE id = ?")
    int updateStudent(String tutor_id, String name, int id);

    @SqlUpdate("DELETE FROM Student WHERE id = ?")
    int deleteStudent(int id);
}