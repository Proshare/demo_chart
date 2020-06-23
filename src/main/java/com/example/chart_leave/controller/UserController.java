package com.example.chart_leave.controller;

import com.example.chart_leave.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.chart_leave.service.UserService;
/**
 * //Spring4之后新加入的注解，原来返回json需要@ResponseBody和@Controller配合
 * @RestController
 * //可以帮助SpringBoot应用将所有符合条件的@Configuration配置都加载到当前SpringBoot创建并使用的IoC容器
 * @EnableAutoConfiguration
 * //消除 set ，get方法
 * @Autowired
 * **/
@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    UserService userSerivce;

    //注册新用户，并将用户名密码进行加密保存
    @PostMapping(value = "/userRegister")
    public Response userRegister(@RequestParam("userName") String userName,
                                 @RequestParam("Passwd") String passwd){
        return userSerivce.UserRegister(userName,passwd);
    }
    //根据userid 获取用户
    @PostMapping(value = "/getUser")
    public Response getUser(
            @RequestParam("userId") Integer userId){
        return userSerivce.getUser(userId);
    }

    //用户登录判断
    @PostMapping(value="/userLogin")
    public Response userLogin(
            @RequestParam("userName") String userName,
            @RequestParam("passwd") String passwd){
        return userSerivce.UserLogin(userName,passwd);
    }

}
