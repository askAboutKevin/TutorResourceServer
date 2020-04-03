package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Tutor;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorMapper implements RowMapper<Tutor> {
    @Override
    public Tutor map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Tutor (
                resultSet.getString("id"),
                resultSet.getBoolean("attended_orientation"),
                resultSet.getInt("daily_tracker_id"),
                resultSet.getString("topic"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getInt("school"),
                resultSet.getInt("university"),
                resultSet.getString("supervisor"),
                resultSet.getInt("department"),
                resultSet.getString("salt"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("number"),
                resultSet.getString("last_logged_in"),
                resultSet.getString("ssn"),
                resultSet.getString("image")
        );
    }
}