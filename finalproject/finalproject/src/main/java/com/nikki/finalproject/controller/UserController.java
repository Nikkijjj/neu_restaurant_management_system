package com.nikki.finalproject.controller;

import com.nikki.finalproject.biz.UserBiz;
import com.nikki.finalproject.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//负责接收用户请求，并将请求传发给biz业务逻辑层进行处理
//也负责将处理结果返回给用户
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBiz biz;

    //查询全体用户表
    @RequestMapping("/list")
    public Map findUser(){
        List<User> list = biz.findAll();

        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","查询用户成功！");
        result.put("users",list);

        return result;
    }

    //添加新用户
    @RequestMapping("/add")
    public Map addUser(User user){
        this.biz.addUser(user);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","新用户添加成功！");
        return result;
    }

    //删除用户
    @RequestMapping("/delete")
    public Map deleteUser(int id){
        Map result = new HashMap<>();
        if(biz.deleteUser(id)){
            result.put("isOk",true);
            result.put("msg","删除用户成功！");
        }else {
            result.put("isOk",false);
            result.put("msg","删除用户失败！");
        }
        return result;
    }

    //更新用户信息
    @RequestMapping("/update")
    public Map updateUser(User user){
        this.biz.updateUser(user);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","更新用户成功！");
        return result;
    }

    //用户登录，给拦截器传参
   @RequestMapping("/login")
    public Map login(String userName,String loginPwd,HttpServletRequest request) {
        Map result = new HashMap<>();
        User user = biz.login(userName, loginPwd);
        HttpSession session = request.getSession();

        if(user != null){
            session.setAttribute("login_user", user);
            result.put("isOk",true);
            result.put("msg","用户登录成功！");
            System.out.println(session.getAttribute("login_user"));
        }else {
            result.put("isOk",false);
            result.put("msg","用户名或密码错误！");
        }
        return result;
    }

    @RequestMapping("/search")
    public Map searchUser(String userName) {
        Map result = new HashMap<>();
        User user = biz.searchUser(userName);

        if(user != null){
            result.put("isOk",true);
            result.put("msg","用户查询成功！");
            result.put("users",user);
        }else {
            result.put("isOk",false);
            result.put("msg","用户查询失败！");
        }
        return result;
    }

}
