package com.nikki.finalproject.mapper;


import com.nikki.finalproject.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    List<User> selectUser();

    @Select("select * from t_user where userName=#{userName} and loginPwd=#{loginPwd}")
    User selectUserByUserNameAndPw(@Param("userName") String userName,@Param("loginPwd") String loginPwd);

    @Select("select * from t_user where userName=#{userName}")
    User selectUserByUserName(@Param("userName") String userName);

    @Insert("insert into t_user values (null,#{userName},#{loginPwd})")
    int insertUser(User user);

    @Delete("delete from t_user where userId=#{id}")
    int deleteUserById(int id);

    @Update("update t_user set userName=#{userName},loginPwd=#{loginPwd} where userId=#{userId}")
    int updateUser(User user);
}
