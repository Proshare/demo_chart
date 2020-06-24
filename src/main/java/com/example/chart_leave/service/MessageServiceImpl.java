package com.example.chart_leave.service;

import com.example.chart_leave.dao.message;
import com.example.chart_leave.repository.MessageRepository;
import com.example.chart_leave.repository.UserRespository;
import com.example.chart_leave.utils.CommonTools;
import com.example.chart_leave.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//负责实现抽象类
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    UserRespository userRespository;
    @Autowired
    MessageRepository messageRepository;

    //查找
    @Override
    public Response getMessage(Integer userId) {
        ObjectMapper mapper = new ObjectMapper();//定义一个转化对象
        List<message> mes = messageRepository.findAll();

        if (mes.size() > 0) {
            try {

                return new Response("0", mapper.writeValueAsString(mes));
            } catch (Exception e) {
                e.printStackTrace();
                return new Response("-1", "查询出错");
            }
        } else
            return new Response("0", "您没收到留言");

    }

    //添加
    @Override
    public Response MessageChart(Integer userId, String Title, String content) {
        if (userRespository.findById(userId) == null)
            return new Response("-1", "请登录后再留言");

        message mes = new message();
        mes.setUserId(userId);
        mes.setTitle(Title);
        mes.setContent(content);
        mes.setLeaveTime(CommonTools.getCurrentTime());

        messageRepository.save(mes);
        ObjectMapper mapper = new ObjectMapper();//定义一个转化对象
        try {
            return new Response("0", mapper.writeValueAsString(mes));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("-1", "留言内容保存出错");
        }

    }

    //删除
    @Override
    public Response deleteChart(Integer messageId) {
        messageRepository.deleteById(messageId);
        return new Response("0", "删除成功");
    }
}
