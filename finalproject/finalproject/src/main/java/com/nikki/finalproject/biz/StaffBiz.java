package com.nikki.finalproject.biz;

import com.nikki.finalproject.entity.Staff;
import com.nikki.finalproject.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffBiz {

    @Autowired
    private StaffMapper staffMapper;

    public List<Staff> findAll(){
        return staffMapper.selectStaff();
    }

    public void addStaff(Staff staff){
        this.staffMapper.insertStaff(staff);
    }

    public boolean deleteStaff(int id){
        return this.staffMapper.deleteStaffById(id)>0;
    }

    public void updateStaff(Staff staff){
        this.staffMapper.updateStaff(staff);
    }

    public Staff selectStaffByName(String staffName) {
        Staff staff = staffMapper.selectStaffByName(staffName);
        return staff;
    }
}
