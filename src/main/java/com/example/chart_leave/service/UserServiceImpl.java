package com.example.chart_leave.service;

import com.alibaba.fastjson.JSON;
import com.example.chart_leave.dao.user;
import com.example.chart_leave.repository.UserRespository;
import com.example.chart_leave.utils.CommonTools;
import com.example.chart_leave.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRespository userRespository;
    // 注册
    @Override
    public Response UserRegister(String userName,String passwd){
        // 判断是否为空
        if(CommonTools.isEmpty(userName))
            return new Response("-1", "用户名不能为空");
        if(CommonTools.isEmpty(passwd))
            return new Response("-1", "用户名不能为空");
        try {
            if (userRespository.findByUserName(userName) !=null)
                return new Response("-1", "此用户名已经存在");
            user User = new user();
            User.setUserName(userName);
            User.setUserPasswd(passwd);
            User.setRegisterTime(CommonTools.getCurrentTime());
            String encodemd5 = CommonTools.getMD5(passwd);

            User.setToken(encodemd5);
            User = userRespository.save(User);
            User.setUserPasswd("");
            return new Response("0", JSON.toJSONString(User));
        }catch (Exception e){
            return new Response("-1", "注册用户失败");
        }
    }
    // 登录
    @Override
    public Response UserLogin(String userName, String passwd) {
        if(CommonTools.isEmpty(userName))
            return new Response("-1","用户名不能为空");
        if(CommonTools.isEmpty(passwd))
            return new Response("-1","用户密码不能为空");
        user User = userRespository.findByUserName(userName);

        if(User != null){
            String encodemd5 = CommonTools.getMD5(passwd);
            if(User.getToken().equals(CommonTools.convertMD5(CommonTools.convertMD5(encodemd5)))) {
                User.setUserPasswd("");
                return new Response("0", JSON.toJSONString(User));
            }
            else
                return new Response("-1","密码错误");
        }
        else
            return new Response("-1","用户不存在");
    }

    @Override
    public Response getUser(Integer userId) {
        Optional<user> Users = null;

        if((Users = userRespository.findById(userId))!=null) {
            return new Response("0", JSON.toJSONString(Users));
        } else {
            return new Response("-1","用户不存在");
        }
    }

}
