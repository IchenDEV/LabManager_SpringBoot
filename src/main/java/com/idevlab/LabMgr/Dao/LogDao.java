package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Log相关dao
 * @date: 2019/1/26 23:14
 */
public interface LogDao {
    /**
     * 查询log数量
     */
    int countLog(JSONObject jsonObject);

    /**
     * 查询log列表
     */
    List<JSONObject> listLog(JSONObject jsonObject);

    /**
     * 新增log
     */
    int addLog(JSONObject jsonObject);

    /**
     * 修改log
     */
    int updateLog(JSONObject jsonObject);

    /**
     * 删除log
     */
    int deleteLog(JSONObject jsonObject);

}
