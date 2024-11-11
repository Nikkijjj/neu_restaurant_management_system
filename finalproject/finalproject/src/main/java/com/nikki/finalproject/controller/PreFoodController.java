package com.nikki.finalproject.controller;

import com.nikki.finalproject.biz.FoodBiz;
import com.nikki.finalproject.entity.Food;
import com.nikki.finalproject.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class  PreFoodController {
    @Autowired
    private FoodBiz biz;
    @Autowired
    private FoodMapper foodMapper;

    @RequestMapping("/p_food/list")
    public Map findFood(HttpServletRequest request){
        List<Food> list = biz.findAll();
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg", "查询食谱成功！");
        result.put("food",list);
        return result;
    }

    @RequestMapping("/p_food/add")
    public Map addFood(Food food){
        this.biz.addFood(food);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","添加菜品成功！");
        return result;
    }

    @RequestMapping("/p_food/delete")
    public Map deleteFood(int id){

        Map result = new HashMap<>();
        if(biz.deleteFood(id)){
            result.put("isOk",true);
            result.put("msg","删除菜品成功！");
        }else {
            result.put("isOk",false);
            result.put("msg","删除菜品失败");
        }

        return result;
    }

    @RequestMapping("/p_food/update")
    public Map updateFood(Food food){
        this.biz.updateFood(food);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","更新菜品成功！");
        return result;
    }


}
