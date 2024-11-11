package com.nikki.finalproject.controller;

import com.nikki.finalproject.entity.Manager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @RequestMapping("/login")
    public Map login(Manager manager){
        Map result = new HashMap<>();

        String managerName = manager.getManagerName();
        String loginPwd = manager.getLoginPwd();

        if("nikki".equals(managerName) && "1212".equals(loginPwd)){
            result.put("isOk",true);
            result.put("msg","管理员登录成功！");
        }else {
            result.put("isOk",false);
            result.put("msg","管理员登录失败！");
        }
        return result;
    }
}
