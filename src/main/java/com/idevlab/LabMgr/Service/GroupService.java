package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 组 权限
 * @date: 2019/1/27 17:48
 */
public interface GroupService {
	/**
	 * 组列表
	 */
	JSONObject listGroup(JSONObject jsonObject);
	JSONObject listGroupUser(JSONObject jsonObject);
	JSONObject listGroupProject(JSONObject jsonObject);
	/**
	 * 添加组
	 */
	JSONObject addGroup(JSONObject jsonObject);

	/**
	 * 添加组人员
	 */
	JSONObject addUserToGroup(JSONObject jsonObject) ;

	/**
	 * 添加组项目
	 */
	JSONObject addProjectToGroup(JSONObject jsonObject);
	/**
	 * 修改组
	 */
    JSONObject updateGroup(JSONObject jsonObject);
    
    /**
	 * 删除组
	 */
	JSONObject deleteGroup(JSONObject jsonObject);

	JSONObject deleteGroupUser(JSONObject jsonObject);

	JSONObject deleteGroupProject(JSONObject jsonObject);
}