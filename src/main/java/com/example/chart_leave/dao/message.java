package com.example.chart_leave.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class message {
    @Id
    @GeneratedValue
    @Column(nullable = false,columnDefinition = "integer(11) COMMENT '留言主键' AUTO_INCREMENT")
    private int messageId;
    @Column(nullable = false,columnDefinition = "integer (11) COMMENT '用户外键'")
    private int userId;
    @Column(nullable = false,columnDefinition = "varchar(100) COMMENT '留言标题' default ''")
    private String title;
    @Column(nullable = false,columnDefinition = "varchar(20000) COMMENT '留言内容' default ''")
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false,columnDefinition = "datetime COMMENT '留言时间'")
    private Timestamp leaveTime;
}

