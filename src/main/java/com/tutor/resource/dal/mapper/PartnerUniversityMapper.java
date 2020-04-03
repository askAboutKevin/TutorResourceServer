package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Department;
import com.tutor.resource.model.PartnerUniversity;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerUniversityMapper implements RowMapper<PartnerUniversity> {
    @Override
    public PartnerUniversity map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new PartnerUniversity (
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("street_address"),
                resultSet.getString("city"),
                resultSet.getString("state"),
                resultSet.getString("zip_code"),
                resultSet.getString("country"),
                resultSet.getString("supervisor")
        );
    }
}