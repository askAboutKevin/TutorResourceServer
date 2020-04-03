package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Event;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {
    @Override
    public Event map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Event(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getDate("start"),
                resultSet.getDate("end"),
                resultSet.getString("location"),
                resultSet.getString("contact"),
                resultSet.getString("details"),
                resultSet.getString("reoccurring")
        );    }
}