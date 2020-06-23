package com.example.chart_leave.utils;

import java.security.MessageDigest;
import java.sql.Timestamp;
/**
 * 工具类
 * 主要判断是否为空以及进行时间转码
 * 对其密码进行加密处理
 *
 * **/
public class CommonTools {
    public static boolean isEmpty(String str){
        if(str == null)
            return true;
        if(str.isEmpty())
            return true;
        if(str == "" || str.equals(""))
            return true;
        return false;
    }

    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
    //md5加密
    public static String getMD5(String passwd){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = passwd.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String encodemd5){

        char[] a = encodemd5.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }


}
