package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.DailyLog;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DailyLogMapper implements RowMapper<DailyLog> {
    @Override
    public DailyLog map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new DailyLog(
                resultSet.getInt("id"),
                resultSet.getString("tutor_id"),
                resultSet.getString("tutor_name"),
                resultSet.getString("date_of_tutoring"),
                resultSet.getFloat("time_in_school"),
                resultSet.getInt("num_of_individual_students_tutored"),
                resultSet.getInt("num_of_student_groups_tutored"),
                resultSet.getString("tutee_first_name"),
                resultSet.getString("tutee_last_name"),
                resultSet.getString("tutee_id"),
                resultSet.getFloat("time_spent_one_on_one"),
                resultSet.getFloat("time_spent_small_group"),
                resultSet.getString("session_material")
        );
    }
}