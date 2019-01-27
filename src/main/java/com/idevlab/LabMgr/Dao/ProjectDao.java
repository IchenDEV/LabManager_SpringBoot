package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: 项目相关dao
 * @date: 2019/1/27 17:54
 */
public interface ProjectDao {
    /**
     * 查询预定数量
     */
    int countProject(JSONObject jsonObject);

    /**
     * 查询预定列表
     */
    List<JSONObject> listProject(JSONObject jsonObject);

    /**
     * 新增预定
     */
    int addProject(JSONObject jsonObject);

    /**
     * 修改预定
     */
    int updateProject(JSONObject jsonObject);

    /**
     * 删除预定
     */
    int deleteProject(JSONObject jsonObject);

}
