package com.example.chart_leave.repository;

import com.example.chart_leave.dao.message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<message,Integer> {
}
