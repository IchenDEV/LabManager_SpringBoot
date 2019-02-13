package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Msg相关dao
 * @date: 2019/1/26 23:14
 */
public interface MsgDao {
    /**
     * 查询msg数量
     */
    int countMsg(JSONObject jsonObject);

    /**
     * 查询msg列表
     */
    List<JSONObject> listMsg(JSONObject jsonObject);

    /**
     * 新增msg
     */
    int addMsg(JSONObject jsonObject);
    int readMsg(JSONObject jsonObject);

    /**
     * 删除msg
     */
    int deleteMsg(JSONObject jsonObject);

}
