package com.ocms.dao;

import com.ocms.pojo.Apply;
import com.ocms.pojo.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author Flat-White
 */
public interface StaffMapper {
    /**
     * 查询所有员工信息
     * @return Staff list
     */
    List<Staff> staffListStaff();

    /**
     * 查询某个员工信息
     * @param map staName
     * @return Staff Object
     */
    Staff staffGetStaffByStaName(Map<String, Object> map);

    /**
     * 提交申请
     * @param map staId conTime applyName applyNum
     * @return apply success->1 / fail -> 0
     */
    int staffSubmitApply(Map<String, Object> map);

    /**
     * 查询审核情况
     * @param map staId
     * @return Apply list
     */
    List<Apply> staffQueryApply(Map<String, Object> map);
}
