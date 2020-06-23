package com.example.chart_leave.service;

import com.example.chart_leave.utils.Response;

public interface MessageService {
    Response getMessage(Integer userId);
    Response MessageChart(Integer userId,String title,String content);
    Response deleteChart(Integer messageId);
}
