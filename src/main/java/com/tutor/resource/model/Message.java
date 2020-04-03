package com.tutor.resource.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Message {

    private String id;
    private String text;
    private String timestamp;
    private String senderId;
    private String receiverId;

    public Message(String id, String text, String timestamp, String senderId, String receiverId) {
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    @JsonCreator
    public Message(@JsonProperty("text") String text, @JsonProperty("senderId") String senderId, @JsonProperty("receiverId") String receiverId) {
        this.text = text;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    @ColumnName("id")
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @ColumnName("text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ColumnName("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @ColumnName("sender_id")
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @ColumnName("receiver_id")
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

}