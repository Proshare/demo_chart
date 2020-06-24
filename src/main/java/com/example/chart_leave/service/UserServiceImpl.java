package com.example.chart_leave.service;

import com.example.chart_leave.dao.user;
import com.example.chart_leave.repository.UserRespository;
import com.example.chart_leave.utils.CommonTools;
import com.example.chart_leave.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRespository userRespository;
    // 注册
    @Override
    public Response UserRegister(String userName,String passwd){

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


            ObjectMapper mapper = new ObjectMapper();//定义一个转化对象

            return new Response("0", mapper.writeValueAsString(User));

        }catch (Exception e){
            return new Response("-1", "注册用户失败");
        }
    }
    // 登录
    @Override
    public Response UserLogin(String userName, String passwd) {
        user User = userRespository.findByUserName(userName);

        if(User != null){
            String encodemd5 = CommonTools.getMD5(passwd);
            if(User.getToken().equals(CommonTools.convertMD5(CommonTools.convertMD5(encodemd5)))) {
                User.setUserPasswd("");
                ObjectMapper mapper = new ObjectMapper();//定义一个转化对象
                try {
                    return new Response("0", mapper.writeValueAsString(User));
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Response("-1", "用户保存出错");
                }
            }
            else
                return new Response("-1","密码错误");
        }
        else
            return new Response("-1","用户不存在");
    }

    @Override
    public Response getUser(Integer userId) {



        Optional<user> Users = userRespository.findById(userId);

        if(Users.get()!=null) {
            ObjectMapper mapper = new ObjectMapper();//定义一个转化对象
            try {

                return new Response("0", mapper.writeValueAsString(Users.get()));
            } catch (Exception e) {
                e.printStackTrace();
                return new Response("-1", "用户查询出错");
            }
        } else {
            return new Response("-1","用户不存在");
        }
    }

}
