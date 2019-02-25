package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Msg相关dao
 * @date: 2019/1/26 23:14
 */
public interface MsgDao {
    int countMsg(JSONObject jsonObject);
    List<JSONObject> listMsg(JSONObject jsonObject);
    int addMsg(JSONObject jsonObject);
    int readMsg(JSONObject jsonObject);
    int deleteMsg(JSONObject jsonObject);
}
