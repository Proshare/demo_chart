package com.example.chart_leave.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    private int userId;
    private String title;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp leaveTime;

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getLeaveTime() {
        return leaveTime;
    }
}

