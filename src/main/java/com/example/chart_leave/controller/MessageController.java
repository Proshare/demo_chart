package com.example.chart_leave.controller;

import com.example.chart_leave.service.MessageService;
import com.example.chart_leave.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MessageController {

    @Autowired
    MessageService messageService;
    /**
     * 获取所有留言
     *
     * @param userId
     * @param title
     * @param content
     * @return
     */
    @PostMapping(value = "/leaveWord")
    public Response leaveWord(@RequestParam("userId")Integer userId,
                              @RequestParam("title")String title,
                              @RequestParam("content")String content){
        return messageService.MessageChart(userId,title,content);
    }

    /**
     * 获取所有留言
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/getWords")
    public Response getWords(@RequestParam("userId")Integer userId){
        return messageService.getMessage(userId);
    }


}

