package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Lab相关dao
 * @date: 2019/1/26 23:14
 */
public interface LabDao {
    /**
     * 查询实验室数量
     */
    int countLab(JSONObject jsonObject);

    /**
     * 查询实验室列表
     */
    List<JSONObject> listLab(JSONObject jsonObject);

    /**
     * 新增实验室
     */
    int addLab(JSONObject jsonObject);

    /**
     * 修改实验室
     */
    int updateLab(JSONObject jsonObject);

    /**
     * 删除实验室
     */
    int deleteLab(JSONObject jsonObject);

}
