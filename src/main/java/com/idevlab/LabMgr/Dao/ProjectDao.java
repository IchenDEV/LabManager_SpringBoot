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
     * 查询项目数量
     */
    int countProject(JSONObject jsonObject);

    /**
     * 查询项目的组的数量
     */
    int countProjectGroup(JSONObject jsonObject);

    /**
     * 查询项目列表
     */
    List<JSONObject> listProject(JSONObject jsonObject);

    /**
     * 查询项目的组
     */
    List<JSONObject> listProjectGroup(JSONObject jsonObject);

    /**
     * 新增项目
     */
    int addProject(JSONObject jsonObject);

    /**
     * 修改项目
     */
    int updateProject(JSONObject jsonObject);

    /**
     * 删除项目
     */
    int deleteProject(JSONObject jsonObject);

}
