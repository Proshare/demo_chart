package com.example.chart_leave.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
//持久化，并同时省略get 和set
@Data
@Entity
public class user {
    @Id
    @GeneratedValue
    @Column(nullable = false,columnDefinition = "Integer(11) COMMENT '用户主键'")
    private int userId;
    @Column(nullable = false,columnDefinition = "varchar(40) COMMENT '用户名'")
    private String userName;
    @Column(nullable = false,columnDefinition = "varchar(40)  COMMENT '用户密码'")
    private String userPasswd;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false,columnDefinition = "datetime  COMMENT '注册时间'")
    private Timestamp registerTime;
    @Column(nullable = false,columnDefinition = "varchar(400)  COMMENT '加密秘钥'")
    private String token;
}
