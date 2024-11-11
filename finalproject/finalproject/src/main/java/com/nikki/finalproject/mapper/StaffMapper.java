package com.nikki.finalproject.mapper;

import com.nikki.finalproject.entity.Staff;
import com.nikki.finalproject.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffMapper {
    @Select("select * from t_staff")
    List<Staff> selectStaff();

    @Select("select * from t_staff where staffName=#{staffName}")
    Staff selectStaffByName(@Param("staffName") String staffName);

    @Insert("insert into t_staff values (null,#{staffName},#{staffSalary},#{entryDate})")
    int insertStaff(Staff staff);

    @Delete("delete from t_staff where staffId=#{id}")
    int deleteStaffById(int id);

    @Update("update t_staff set staffName=#{staffName}, staffSalary=#{staffSalary},entryDate=#{entryDate} where staffId=#{staffId}")
    int updateStaff(Staff staff);

}
