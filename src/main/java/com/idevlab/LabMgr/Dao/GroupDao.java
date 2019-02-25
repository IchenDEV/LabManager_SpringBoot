package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: 项目组相关dao
 * @date: 2019/1/27 17:54
 */
public interface GroupDao {
    int countGroup(JSONObject jsonObject);
    int countGroupUser(JSONObject jsonObject);
    int countGroupProject(JSONObject jsonObject);
    List<JSONObject> listGroup(JSONObject jsonObject);
    List<JSONObject> listGroupUser(JSONObject jsonObject);
    List<JSONObject> listGroupProject(JSONObject jsonObject);
    int addGroup(JSONObject jsonObject);
    int addUserToGroup(JSONObject jsonObject);
    int addProjectToGroup(JSONObject jsonObject);
    int updateGroup(JSONObject jsonObject);
    int deleteGroup(JSONObject jsonObject);
    int deleteGroupUser(JSONObject jsonObject);
    int deleteGroupProject(JSONObject jsonObject);

}
