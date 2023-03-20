package com.ocms.dao;

import com.ocms.pojo.Admin;
import com.ocms.pojo.Apply;
import com.ocms.pojo.Consume;
import com.ocms.pojo.Staff;
import com.ocms.utils.Md5Utils;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author Flat-White
 */
public class AdminMapperImpl implements AdminMapper{

    public AdminMapperImpl() {
    }

    @Override
    public Admin adminLogin(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        try{
            Admin admin  = mapper.adminLogin(map);
            sqlSession.close();
            if (admin.getAdminPasswd().equals(Md5Utils.toMd5(map.get("adminPasswd").toString()))){
                return admin;
            }
            else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int adminGetStaIdByApplyId(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int staId = mapper.adminGetStaIdByApplyId(map);
        sqlSession.close();

        return staId;
    }

    @Override
    public int adminAgreeApply(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int staId = mapper.adminGetStaIdByApplyId(map);
        map.put("staId", staId);
        int i = mapper.adminAgreeApply(map);
        if (i > 0){
            System.out.println("adminAgreeApply Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int adminRejectApply(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminRejectApply(map);
        if (i > 0){
            System.out.println("adminRejectApply Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int adminEncryptPasswd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminEncryptPasswd();
        if (i > 0){
            System.out.println("adminEncryptPasswd Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<Apply> adminListApply() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminListApply();
        sqlSession.close();

        return applyList;
    }

    @Override
    public List<Apply> adminGetTreatApply() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminGetUnTreatApply();
        sqlSession.close();

        return applyList;
    }

    @Override
    public List<Apply> adminGetUnTreatApply() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminGetUnTreatApply();
        sqlSession.close();

        return applyList;
    }

    @Override
    public List<Apply> adminGetApplyByStaName(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminGetApplyByStaName(map);
        sqlSession.close();

        return applyList;
    }

    @Override
    public List<Staff> adminListStaff() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Staff> staffList = mapper.adminListStaff();
        sqlSession.close();

        return staffList;
    }

    @Override
    public int adminUpdateStaff(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminUpdateStaff(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int adminInsertStaff(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminInsertStaff(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int adminDeleteStaff(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminDeleteStaff(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<Consume> adminListConsume() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Consume> consumeList = mapper.adminListConsume();
        sqlSession.close();

        return consumeList;
    }

    @Override
    public int adminUpdateConsume(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminUpdateConsume(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int adminInsertConsume(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminInsertConsume(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int adminDeleteConsume(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminDeleteConsume(map);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }
}
