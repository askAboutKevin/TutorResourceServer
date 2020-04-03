package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.MessageMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import com.tutor.resource.model.Message;
import java.util.List;

public interface MessageDAO {

    @SqlQuery("SELECT id, text, timestamp, sender_id, receiver_id FROM Message WHERE sender_id = ? AND receiver_id = ? ORDER BY timestamp")
    @RegisterRowMapper(MessageMapper.class)
    List<Message> selectAllMessagesToSenderFromReceiver(String senderId, String receiverId);

    @SqlUpdate("INSERT INTO Message (id, text, sender_id, receiver_id) VALUES (?, ?, ?, ?)")
    int insertMessage(String id, String text, String sender_id, String receiver_id);

    @SqlUpdate("DELETE FROM Message WHERE id = ?")
    int deleteMessage(String id);
}