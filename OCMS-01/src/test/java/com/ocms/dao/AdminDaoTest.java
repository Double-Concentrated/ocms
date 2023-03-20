package com.ocms.dao;

import com.ocms.pojo.Admin;
import com.ocms.pojo.Apply;
import com.ocms.pojo.Consume;
import com.ocms.pojo.Staff;
import com.ocms.utils.Md5Utils;
import com.ocms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDaoTest {
    @Test
    public void adminLogin(){
        String adminAccount = "root";
        String adminPasswd = "root";
//        System.out.println(Md5Utils.toMd5(adminPasswd));

        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", adminAccount);
        map.put("adminPasswd", adminPasswd);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        try {
            Admin admin  = mapper.adminLogin(map);
                    System.out.println(map.get("adminPasswd"));
            if (admin.getAdminPasswd().equals(Md5Utils.toMd5(map.get("adminPasswd").toString()))){
                System.out.println("adminLogin Successfully!");
            }
            else System.out.println("密码错误！");
        }catch (Exception e){
            System.out.println("该账户不存在！");
        }
        sqlSession.close();
    }

    @Test
    public void adminGetStaIdByApplyId(){
        int applyId = 1;
        Map<String, Object> map = new HashMap<>();
        map.put("applyId", applyId);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int staId = mapper.adminGetStaIdByApplyId(map);
        System.out.println(staId);
        sqlSession.close();
    }

    @Test
    public void adminAgreeApply(){
        int applyId = 1;
        int adminId = 1;
        String applyNote = "申请通过。";
        Map<String, Object> map = new HashMap<>();
        map.put("applyId", applyId);
        map.put("adminId", adminId);
        map.put("applyNote", applyNote);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int staId = mapper.adminGetStaIdByApplyId(map);
//        System.out.println(staId);
        map.put("staId", staId);
        int i = mapper.adminAgreeApply(map);
        if (i > 0){
            System.out.println("adminAgreeApply Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminRejectApply(){
        int applyId = 2;
        int adminId = 1;
        String applyNote = "耗材不足。";
        Map<String, Object> map = new HashMap<>();
        map.put("applyId", applyId);
        map.put("adminId", adminId);
        map.put("applyNote", applyNote);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminRejectApply(map);
        if (i > 0){
            System.out.println("adminRejectApply Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminEncryptPasswd(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminEncryptPasswd();
        if (i > 0){
            System.out.println("adminEncryptPasswd Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminListApply(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminListApply();

        for (Apply apply : applyList) {
            System.out.println(apply);
        }

        sqlSession.close();
    }

    @Test
    public void adminGetTreatApply(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminGetTreatApply();
        for (Apply apply : applyList) {
            System.out.println(apply);
        }
        sqlSession.close();
    }

    @Test
    public void adminGetUnTreatApply(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminGetUnTreatApply();
        for (Apply apply : applyList) {
            System.out.println(apply);
        }
        sqlSession.close();
    }

    @Test
    public void adminGetApplyByStaName(){
        String staName = "仓库管理员";
        Map<String, Object> map = new HashMap<>();
        map.put("staName", staName);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Apply> applyList = mapper.adminGetApplyByStaName(map);
        for (Apply apply : applyList) {
            System.out.println(apply);
        }
        sqlSession.close();
    }

    @Test
    public void adminListStaff(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Staff> staffList = mapper.adminListStaff();

        for (Staff staff : staffList) {
            System.out.println(staff);
        }

        sqlSession.close();
    }

    @Test
    public void adminUpdateStaff(){
        int staId = 20;
        String staName = "TestStaff";
        String staDept = "TestDept";
        String staTele = "6666666";

        Map<String, Object> map = new HashMap<>();
        map.put("staId", staId);
        map.put("staName", staName);
        map.put("staDept", staDept);
        map.put("staTele", staTele);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminUpdateStaff(map);
        if (i > 0){
            System.out.println("adminUpdateStaff Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminInsertStaff(){
        String staName = "TestStaff";
        String staDept = "TestDept";
        String staTele = "666666";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("staName", staName);
        map.put("staDept", staDept);
        map.put("staTele", staTele);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminInsertStaff(map);
        if(i > 0){
            System.out.println("adminInsertStaff Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminDeleteStaff(){
        int staId = 20;

        Map<String, Object> map = new HashMap<>();
        map.put("staId", staId);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminDeleteStaff(map);
        if (i > 0){
            System.out.println("adminDeleteStaff Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminListConsume(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Consume> consumeList = mapper.adminListConsume();

        for (Consume consume : consumeList) {
            System.out.println(consume);
        }

        sqlSession.close();
    }

    @Test
    public void adminUpdateConsume(){
        int conId = 10;
        String conName = "硫酸纸";
        int conNum = 100;
        String conFactory = "知名硫酸纸生产厂";
        Date date = new Date();

        Map<String, Object> map = new HashMap<>();
        map.put("conId", conId);
        map.put("conName", conName);
        map.put("conNum", conNum);
        map.put("conFactory", conFactory);
        map.put("conIndate", date);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminUpdateConsume(map);
        if (i > 0){
            System.out.println("adminUpdateConsume Successfully!");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminInsertConsume(){
        String conName = "TestConsume";
        int conNum = 100;
        String conFactory = "TestFactory";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("conName", conName);
        map.put("conNum", conNum);
        map.put("conFactory", conFactory);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminInsertConsume(map);
        if(i > 0){
            System.out.println("adminInsertConsume successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void adminDeleteConsume(){
        int conId = 5;

        Map<String, Object> map = new HashMap<>();
        map.put("conId", conId);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.adminDeleteConsume(map);
        if (i > 0){
            System.out.println("adminDeleteConsume Successfully!");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
