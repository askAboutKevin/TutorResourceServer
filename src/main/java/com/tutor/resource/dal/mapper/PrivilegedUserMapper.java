package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.PrivilegedUser;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PrivilegedUserMapper implements RowMapper<PrivilegedUser> {

    @Override
    public PrivilegedUser map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new PrivilegedUser(
                resultSet.getString("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("salt"),
                resultSet.getString("password_hash"),
                resultSet.getString("email"),
                resultSet.getString("contact_number"),
                resultSet.getString("title"),
                resultSet.getString("role"),
                resultSet.getString("last_logged_in"),
                resultSet.getString("portfolio_image")
        );    }
}