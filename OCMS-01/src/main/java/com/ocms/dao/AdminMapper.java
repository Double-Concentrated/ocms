package com.ocms.dao;

import com.ocms.pojo.Admin;
import com.ocms.pojo.Apply;
import com.ocms.pojo.Consume;
import com.ocms.pojo.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author Flat-White
 */
public interface AdminMapper {

    /**
     * 管理员登陆
     * @param map adminAccount adminPasswd
     * @return Admin Object
     */
    Admin adminLogin(Map<String, Object> map);

    /**
     * 管理员获取apply中相应的staId
     * @param map staId
     * @return staId
     */
    int adminGetStaIdByApplyId(Map<String, Object> map);

    /**
     * 管理员同意申请
     * @param map applyId adminId applyNote
     * @return update success->1 / fail -> 0
     */
    int adminAgreeApply(Map<String, Object> map);

    /**
     * 管理员拒绝申请
     * @param map applyId adminId applyNote
     * @return update success->1 / fail -> 0
     */
    int adminRejectApply(Map<String, Object> map);

    /**
     * 管理员加密密码
     * @return encrypt success->1 / fail -> 0
     */
    int adminEncryptPasswd();

    /**
     * 查询所有申请情况
     * @return Apply list
     */
    List<Apply> adminListApply();

    /**
     * 管理员查询已处理申请
     * @return Apply List
     */
    List<Apply> adminGetTreatApply();

    /**
     * 管理员查询未处理申请
     * @return Apply List
     */
    List<Apply> adminGetUnTreatApply();

    /**
     * 查询某员工申请情况
     * @param map staName
     * @return Apply Object
     */
    List<Apply> adminGetApplyByStaName(Map<String, Object> map);

    /**
     * 查询所有员工信息
     * @return Staff list
     */
    List<Staff> adminListStaff();

    /**
     * 修改员工信息
     * @param map staId staName staDept staTele
     * @return update success->1 / fail -> 0
     */
    int adminUpdateStaff(Map<String, Object> map);

    /**
     * 增加员工
     * @param map staName staDept staTele
     * @return add success->1 / fail -> 0
     */
    int adminInsertStaff(Map<String, Object> map);

    /**
     * 删除员工
     * @param map staId
     * @return del success->1 / fail -> 0
     */
    int adminDeleteStaff(Map<String, Object> map);

    /**
     * 查询所有耗材信息
     * @return Consume list
     */
    List<Consume> adminListConsume();

    /**
     * 修改耗材数量
     * @param map conId conName conNum conFactory
     * @return update success->1 / fail -> 0
     */
    int adminUpdateConsume(Map<String, Object> map);

    /**
     * 新增耗材
     * @param map conName conNum conFactory
     * @return add success->1 / fail -> 0
     */
    int adminInsertConsume(Map<String, Object> map);

    /**
     * 删除耗材
     * @param map conId
     * @return del success->1 / fail -> 0
     */
    int adminDeleteConsume(Map<String, Object> map);
}
