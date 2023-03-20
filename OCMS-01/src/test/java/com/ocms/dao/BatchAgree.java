package com.ocms.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BatchAgree {
    public static void main(String[] args) {
        Connection con;
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名javasysqltest
        String url = "jdbc:mysql://localhost:3306/OCMS?useSSL=false&userUnicode=true&characterEncoding=UTF-8";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            // 如果连接不是关闭的
            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            //创建一个对象将SQL语句发送到SQL
            Statement statement = con.createStatement();
            //sql语句
            String sql = "update ocms.apply set apply_is_check = 1, apply_result = 1 where sta_id = 1";
            // ResultSet类，用来存放获取的结果集
            int i = statement.executeUpdate(sql);
            if (i > 0){
                System.out.println("Batch Agree Apply Successfully!");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("结束!");
        }
    }
}
