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
     * 查询组数量
     */
    int countGroup(JSONObject jsonObject);

    /**
     * 查询组用户数量
     */
    int countGroupUser(JSONObject jsonObject);

    /**
     * 查询组项目数量
     */
    int countGroupProject(JSONObject jsonObject);

    /**
     * 查询组列表
     */
    List<JSONObject> listGroup(JSONObject jsonObject);

    /**
     * 查询组用户
     */
    List<JSONObject> listGroupUser(JSONObject jsonObject);

    /**
     * 查询组项目
     */
    List<JSONObject> listGroupProject(JSONObject jsonObject);

    /**
     * 新增组
     */
    int addGroup(JSONObject jsonObject);

    /**
     * 新增组成员
     */
    int addUserToGroup(JSONObject jsonObject);

    /**
     * 新增组项目
     */
    int addProjectToGroup(JSONObject jsonObject);

    /**
     * 修改组
     */
    int updateGroup(JSONObject jsonObject);

    /**
     * 删除组
     */
    int deleteGroup(JSONObject jsonObject);

    /**
     * 删除组用户
     */
    int deleteGroupUser(JSONObject jsonObject);

    /**
     * 删除组项目
     */
    int deleteGroupProject(JSONObject jsonObject);

}
