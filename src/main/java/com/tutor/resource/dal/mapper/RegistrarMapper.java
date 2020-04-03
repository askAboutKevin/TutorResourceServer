package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Registrar;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrarMapper implements RowMapper<Registrar> {
    @Override
    public Registrar map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Registrar(
                resultSet.getString("user"),
                resultSet.getBoolean("is_priviliged"),
                resultSet.getString("device_id"),
                resultSet.getString("session_expires")
        );    }
}