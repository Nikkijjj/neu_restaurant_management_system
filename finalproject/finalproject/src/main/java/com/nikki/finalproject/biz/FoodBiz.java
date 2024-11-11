package com.nikki.finalproject.biz;

import com.nikki.finalproject.entity.Food;
import com.nikki.finalproject.entity.User;
import com.nikki.finalproject.mapper.FoodMapper;
import com.nikki.finalproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FoodBiz {
    @Autowired
    /*让spring反过来提供一个foodMapper（spring会通过setter给这个属性注入一个对象，如果属性是接口或抽象类型的，
    spring会自己去匹配其实现类或子类）*/
    private FoodMapper foodMapper;//Mapper是一个接口，下面创建其对象

    public List<Food> findAll() {
        return foodMapper.selectFood();
    }
//将要添加的食品信息传递给 addFood 方法，以便在数据库中插入相应的记录
    public void addFood(Food food) {
        this.foodMapper.insertFood(food);
    }

    public boolean deleteFood(int id) {
        return this.foodMapper.deleteFoodById(id)>0;
    }
//通过将 FoodMapper 作为参数传递给 updateFood 方法，可以在运行时更新数据访问逻辑
    public  void updateFood(Food food) {
        this.foodMapper.updateFood(food);
    }

    public Food selectFoodByName(String foodName) {
        Food food = foodMapper.selectFoodByFoodName(foodName);
        return food;
    }
}
