package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 组 权限
 * @date: 2019/1/27 17:48
 */
public interface GroupService {
	JSONObject listGroup(JSONObject jsonObject);
	JSONObject listGroupUser(JSONObject jsonObject);
	JSONObject listGroupProject(JSONObject jsonObject);
	JSONObject addGroup(JSONObject jsonObject);
	JSONObject addUserToGroup(JSONObject jsonObject) ;
	JSONObject addProjectToGroup(JSONObject jsonObject);
    JSONObject updateGroup(JSONObject jsonObject);
	JSONObject deleteGroup(JSONObject jsonObject);
	JSONObject deleteGroupUser(JSONObject jsonObject);
	JSONObject deleteGroupProject(JSONObject jsonObject);
}