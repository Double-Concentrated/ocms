package com.ocms.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BatchApply {
    public static void main(String[] args) {
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

        StaffMapperImpl staffMapper = new StaffMapperImpl();
        for (int i = 0; i < 20; i++) {
            staffMapper.staffSubmitApply(map);
            System.out.println("Staff Submit Apply Successfully!");
        }
        staffMapper.staffSubmitApply(map);
    }
}
