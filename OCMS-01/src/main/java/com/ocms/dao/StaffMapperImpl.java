package com.ocms.dao;

import com.ocms.pojo.Apply;
import com.ocms.pojo.Staff;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author Flat-White
 */
public class StaffMapperImpl implements StaffMapper {

    public StaffMapperImpl() {
    }

    @Override
    public List<Staff> staffListStaff() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        List<Staff> staffList = staffMapper.staffListStaff();
        sqlSession.close();

        return staffList;
    }

    @Override
    public Staff staffGetStaffByStaName(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        Staff staff = mapper.staffGetStaffByStaName(map);
        sqlSession.close();

        return staff;
    }

    @Override
    public int staffSubmitApply(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        int i = mapper.staffSubmitApply(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<Apply> staffQueryApply(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        List<Apply> applyList = staffMapper.staffQueryApply(map);
        sqlSession.close();

        return applyList;
    }
}
