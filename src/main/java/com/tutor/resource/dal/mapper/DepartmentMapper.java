package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Department;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {
    @Override
    public Department map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Department(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );    }
}
