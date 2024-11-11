package com.nikki.finalproject.controller;


import com.nikki.finalproject.biz.StaffBiz;
import com.nikki.finalproject.entity.Staff;
import com.nikki.finalproject.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffBiz biz;

    @Autowired
    private StaffMapper staffMapper;

    //查询全体员工表
    @RequestMapping("/list")
    public Map findStaff(){
        List<Staff> list = biz.findAll();

        Map result = new HashMap<>();
        result.put("isOk", true);
        result.put("msg","查询员工成功！");
        result.put("staffs",list);
        return result;
    }

    //添加员工
    @RequestMapping("/add")
    public Map addStaff(Staff staff){
        this.biz.addStaff(staff);
        Map result = new HashMap<>();
        result.put("isOk", true);
        result.put("msg","添加员工成功！");
        return result;
    }

    //删除员工
    @RequestMapping("/delete")
    public Map deleteStaff(int id){
        Map result = new HashMap<>();
        if(biz.deleteStaff(id)){
            result.put("isOk", true);
            result.put("msg","删除员工成功！");
        }else {
            result.put("isOk", false);
            result.put("msg","删除员工失败！");
        }

        return result;
    }

    //更新员工信息
    @RequestMapping("/update")
    public Map updateStaff(Staff staff){
        this.biz.updateStaff(staff);
        Map result = new HashMap<>();
        result.put("isOk", true);
        result.put("msg","更新员工成功！");

        return result;
    }

    //查询员工信息
    @RequestMapping("/search")
    public Map searchStaff(String staffName){
        Map result = new HashMap<>();
        Staff staff = biz.selectStaffByName(staffName);

        if(staff != null){
            result.put("isOk", true);
            result.put("msg","查询员工成功！");
            result.put("staffs",staff);
        }else {
            result.put("isOk", false);
            result.put("msg","查询员工失败！");
        }
        return result;
    }

}
