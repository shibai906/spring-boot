package com.zhao.springboot.aop;

import com.zhao.springboot.model.User;

public class UserServiceImp implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null) {
            throw new RuntimeException("检查用户参数是否为空......");
        }
        System.out.println("id=" + user.getId());
        System.out.println("userName=" + user.getUserName());
        System.out.println("note=" + user.getNote());
    }
}
