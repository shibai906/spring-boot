package com.zhao.springboot.dao;

import com.zhao.springboot.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int insertUser(Connection conn , User user) throws SQLException {
        PreparedStatement ps = null ;
        try {
            ps = conn.prepareStatement("insert into user(name,node) values(?,?)");
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getNote());
            return ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

}
