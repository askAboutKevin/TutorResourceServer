package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.PayPeriod;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PayPeriodMapper implements RowMapper<PayPeriod> {
    @Override
    public PayPeriod map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new PayPeriod(
                resultSet.getInt("id"),
                resultSet.getInt("school"),
                resultSet.getString("start"),
                resultSet.getString("end"),
                resultSet.getString("pay_serve_no"),
                resultSet.getString("comments")
        );    }
}