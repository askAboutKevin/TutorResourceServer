package com.tutor.resource.dal.mapper;

import com.tutor.resource.model.Message;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<Message> {
    @Override
    public Message map(ResultSet resultSet, StatementContext ctx) throws SQLException {
        return new Message(
                resultSet.getString("id"),
                resultSet.getString("text"),
                resultSet.getString("timestamp"),
                resultSet.getString("sender_id"),
                resultSet.getString("receiver_id")
        );    }
}
