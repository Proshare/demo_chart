package com.example.chart_leave.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data  注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
 * @AllArgsConstructor  注解在类上；为类提供一个全参的构造方法
 * @NoArgsConstructor  注解在类上；为类提供一个无参的构造方法
 * **/
@Data
@AllArgsConstructor
@NoArgsConstructor
//工具类一个是返回状态，一个返回内容
public class Response{
    private String status;
    private Object content;


}
