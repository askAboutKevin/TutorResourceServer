package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Student;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getInt("tutor_id"),
                resultSet.getInt("school"),
                resultSet.getString("name")
        );    }
}
