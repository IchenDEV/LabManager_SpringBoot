package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Lab相关dao
 * @date: 2019/1/26 23:14
 */
public interface PushDao {
    int countPush(JSONObject jsonObject);

    List<JSONObject> listPush(JSONObject jsonObject);

    int addPush(JSONObject jsonObject);

    int deletePush(JSONObject jsonObject);

}
