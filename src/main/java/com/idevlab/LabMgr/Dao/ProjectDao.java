package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: 项目相关dao
 * @date: 2019/1/27 17:54
 */
public interface ProjectDao {
    int countProject(JSONObject jsonObject);
    int countProjectGroup(JSONObject jsonObject);
    List<JSONObject> listProject(JSONObject jsonObject);
    List<JSONObject> listProjectGroup(JSONObject jsonObject);
    int addProject(JSONObject jsonObject);
    int updateProject(JSONObject jsonObject);
    int deleteProject(JSONObject jsonObject);
}
