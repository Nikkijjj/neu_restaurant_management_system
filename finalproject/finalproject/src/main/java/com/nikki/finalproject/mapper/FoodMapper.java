package com.nikki.finalproject.mapper;


import com.nikki.finalproject.entity.Food;
import org.apache.ibatis.annotations.*;

import java.util.List;

//负责与数据库进行交互，执行具体的数据操作
//Mapper接口定义了数据库操作方法，被业务逻辑层调用，用于实现业务逻辑的数据需求
@Mapper
public interface FoodMapper {
    @Select("select * from t_food")
    List<Food> selectFood();

    @Select("select * from t_food where foodName=#{foodName}")
    Food selectFoodByFoodName(@Param("foodName") String foodName);
    //SQL语句查询语句，#{id}是查询时，将id的值填充到该位置上
    @Insert("insert into t_food values (null,#{foodName},#{description},#{price},#{foodPic})")
    int insertFood(Food food);

    @Delete("delete from t_food where foodId=#{id}")
    int deleteFoodById(int id);

    @Update("update t_food set foodName=#{foodName}, description=#{description}, price=#{price}, foodPic=#{foodPic} where foodId=#{foodId}")
    int updateFood(Food food);
}
