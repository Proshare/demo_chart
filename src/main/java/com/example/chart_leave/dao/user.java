package com.example.chart_leave.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
//持久化，并同时省略get 和set

@Entity

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String userPasswd;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp registerTime;
    
    private String token;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public String getToken() {
        return token;
    }
}
