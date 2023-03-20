package com.ocms.dao;

import com.ocms.pojo.Apply;

import java.util.List;

/**
 * @author Flat-White
 */
public interface ApplyMapper {

    /**
     * 查询所有审核情况
     * @return Apply list
     */
    List<Apply> getApplyList();
}
