package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Resource;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceMapper implements RowMapper<Resource> {
    @Override
    public Resource map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Resource(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("locator"),
                resultSet.getInt("owner")
        );    }
}
