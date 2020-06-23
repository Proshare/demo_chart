package com.example.chart_leave.repository;


import com.example.chart_leave.dao.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<user,Integer> {
    //user属性的标注
    user findByUserName(String userName);
}
