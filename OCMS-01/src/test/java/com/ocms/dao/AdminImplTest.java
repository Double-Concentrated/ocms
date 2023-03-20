package com.ocms.dao;

import com.ocms.pojo.Admin;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AdminImplTest {
    @Test
    public void adminLogin(){
        String adminAccount = "root";
        String adminPasswd = "root";

        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", adminAccount);
        map.put("adminPasswd", adminPasswd);

        Admin admin;
        AdminMapperImpl adminMapperImpl = new AdminMapperImpl();
        admin = adminMapperImpl.adminLogin(map);
        System.out.println(admin);
    }
}
