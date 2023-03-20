package com.ocms.dao;

import com.ocms.dao.ApplyMapper;
import com.ocms.pojo.Apply;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ApplyDaoTest {
    @Test
    public void getApplyList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
        List<Apply> applyList = applyMapper.getApplyList();

        for (Apply apply : applyList) {
            System.out.println(apply);
        }

        sqlSession.close();
    }
}
