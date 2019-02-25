package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Log相关dao
 * @date: 2019/1/26 23:14
 */
public interface LogDao {
    int countLog(JSONObject jsonObject);
    List<JSONObject> listLog(JSONObject jsonObject);
    int addLog(JSONObject jsonObject);
    int updateLog(JSONObject jsonObject);
    int deleteLog(JSONObject jsonObject);

}
