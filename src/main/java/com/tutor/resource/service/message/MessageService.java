package com.tutor.resource.service.message;

import com.tutor.resource.dal.dao.MessageDAO;
import com.tutor.resource.model.Message;
import com.tutor.resource.util.UniqueIdGenerator;
import java.util.List;

public class MessageService {

    private MessageDAO messageDAO;

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public List<Message> selectAllMessagesToSenderFromReceiver(String senderId, String receiverId) {
        List<Message> messages = this.messageDAO.selectAllMessagesToSenderFromReceiver(senderId, receiverId);
        return messages;
    }

    public int insertMessage(String sender_id, String receiver_id, String text) {

        String id = UniqueIdGenerator.generate("message");

        int createdMessage = this.messageDAO.insertMessage(id, text, sender_id, receiver_id);
        return createdMessage;
    }

    public int deleteMessage(String id) {
        int deletedMessages = this.messageDAO.deleteMessage(id);
        return deletedMessages;
    }

}
