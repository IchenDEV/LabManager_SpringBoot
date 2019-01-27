package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: 项目组相关dao
 * @date: 2019/1/27 17:54
 */
public interface GroupDao {
    /**
     * 查询预定数量
     */
    int countGroup(JSONObject jsonObject);

    /**
     * 查询预定列表
     */
    List<JSONObject> listGroup(JSONObject jsonObject);

    /**
     * 新增预定
     */
    int addGroup(JSONObject jsonObject);

    /**
     * 修改预定
     */
    int updateGroup(JSONObject jsonObject);

    /**
     * 删除预定
     */
    int deleteGroup(JSONObject jsonObject);

}
