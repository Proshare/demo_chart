package com.example.chart_leave.service;

import com.example.chart_leave.utils.Response;

public interface UserService {
    Response getUser(Integer UserId);
    Response UserRegister(String userName,String passwd);
    Response UserLogin(String userName, String passwd);
}
