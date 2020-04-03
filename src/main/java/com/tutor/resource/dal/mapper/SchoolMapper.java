package com.tutor.resource.dal.mapper;


import com.tutor.resource.model.School;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolMapper implements RowMapper<School> {
    @Override
    public School map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new School(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("registered"),
                resultSet.getString("street_address"),
                resultSet.getString("city"),
                resultSet.getString("state"),
                resultSet.getString("zip_code"),
                resultSet.getString("nces_number"),
                resultSet.getString("longitude"),
                resultSet.getString("latitude"),
                resultSet.getString("site_supervisor")
        );
    }
}