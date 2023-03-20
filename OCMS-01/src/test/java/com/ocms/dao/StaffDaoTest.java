package com.ocms.dao;

import com.ocms.pojo.Apply;
import com.ocms.pojo.Staff;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffDaoTest {
    @Test
    public void staffListStaff(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        List<Staff> staffList = staffMapper.staffListStaff();
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
        sqlSession.close();
    }

    @Test
    public void staffGetStaffByStaName(){
        String staName = "CEO";

        Map<String, Object> map = new HashMap<String ,Object>();
        map.put("staName", staName);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        Staff staffByMap = mapper.staffGetStaffByStaName(map);
        System.out.println(staffByMap);
        sqlSession.close();
    }

    @Test
    public void staffSubmitApply(){
        int staId = 1;
        Date date = new Date();
        String applyName = "传真热敏纸";
        int applyNum = 20;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staId", staId);
        map.put("conTime", date);
        map.put("applyName", applyName);
        map.put("applyNum", applyNum);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        int res = mapper.staffSubmitApply(map);
        if (res > 0){
            System.out.println("Insert Success!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void staffQueryApply(){
        int staId = 2;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staId", staId);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        List<Apply> applyList = staffMapper.staffQueryApply(map);
        for (Apply apply : applyList) {
            System.out.println(apply);
        }
        sqlSession.close();
    }
}
