package com.example.chart_leave.service;

import com.alibaba.fastjson.JSONArray;
import com.example.chart_leave.dao.message;
import com.example.chart_leave.repository.MessageRepository;
import com.example.chart_leave.repository.UserRespository;
import com.example.chart_leave.utils.CommonTools;
import com.example.chart_leave.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//负责实现抽象类
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    UserRespository userRespository;
    @Autowired
    MessageRepository messageRepository;
    //查找
    @Override
    public Response getMessage(Integer userId){
        List<message> mes = messageRepository.findAll();
        if (mes.size()>0)
            return new Response("0",JSONArray.toJSONString(mes));
        else
            return new Response("0","您没收到留言");

    }
    //添加
    @Override
    public Response MessageChart(Integer userId,String Title,String content){
        if (userRespository.findById(userId)==null)
            return new Response("-1","请登录后再留言");
        if (CommonTools.isEmpty(Title))
            return new Response("-1","标题不能为空");
        if (CommonTools.isEmpty(content))
            return new Response("-1","内容不能为空");
        message mes = new message();
        mes.setUserId(userId);
        mes.setTitle(Title);
        mes.setContent(content);
        mes.setLeaveTime(CommonTools.getCurrentTime());
        System.out.println(Title);
        System.out.println(content);

        messageRepository.save(mes);
        return new Response("0",JSONArray.toJSONString(mes));
    }
    //删除
    @Override
    public Response deleteChart(Integer messageId){
        messageRepository.deleteById(messageId);
        return new Response("0","删除成功");
    }
}
