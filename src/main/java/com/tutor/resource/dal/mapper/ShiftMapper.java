package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Shift;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShiftMapper implements RowMapper<Shift> {

    @Override
    public Shift map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Shift(
                resultSet.getInt("id"),
                resultSet.getString("user"),
                resultSet.getString("date"),
                resultSet.getString("time_in"),
                resultSet.getString("time_out"),
                resultSet.getString("lunch_out"),
                resultSet.getString("lunch_in"),
                resultSet.getBoolean("logged"),
                resultSet.getFloat("total_time")
        );    }
}