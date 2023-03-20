package com.ocms.dao;

import com.ocms.pojo.Apply;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Flat-White
 */
public class ApplyMapperImpl implements ApplyMapper{

    public ApplyMapperImpl() {
    }

    @Override
    public List<Apply> getApplyList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
        List<Apply> applyList = applyMapper.getApplyList();
        sqlSession.close();

        return applyList;
    }
}
