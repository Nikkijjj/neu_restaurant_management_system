package com.nikki.finalproject.biz;

import com.nikki.finalproject.entity.User;
import com.nikki.finalproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//负责处理业务逻辑
//该层通常不会直接与数据库进行交互，而是通过调用mapper数据访问层的方法进行数据的读取、写入等操作
@Service
public class UserBiz {
    @Autowired

    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.selectUser();
    }

    public void addUser(User user) {
        this.userMapper.insertUser(user);
    }

    public boolean deleteUser(int id) {
        return this.userMapper.deleteUserById(id) > 0;
    }

    public void updateUser(User user) {
        this.userMapper.updateUser(user);
    }

    public User login(String userName,String loginPwd) {
        User user = userMapper.selectUserByUserNameAndPw(userName,loginPwd);
        return user;
    }

    public User searchUser(String userName) {
        return this.userMapper.selectUserByUserName(userName);
    }
}
