package com.zhao.springboot.service;

import com.zhao.springboot.dao.UserDao;
import com.zhao.springboot.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {

    public int insertUser() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("zhaohuan");
        user.setNote("笔记");
        Connection conn = null;
        int result = 0 ;
        try {
            // 获取数据事物链接
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            // 非自动提交事物
            conn.setAutoCommit(false);
            result = userDao.insertUser(conn,user);
            conn.commit();
        } catch (Exception e) {
            try{
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
