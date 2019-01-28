package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 项目 权限
 * @date: 2019/1/27 17:48
 */
public interface ProjectService {
	/**
	 * 项目列表
	 */
	JSONObject listProject(JSONObject jsonObject);
	JSONObject listProjectGroup(JSONObject jsonObject);
	
	/**
	 * 添加项目
	 */
	JSONObject addProject(JSONObject jsonObject);

	/**
	 * 修改项目
	 */
    JSONObject updateProject(JSONObject jsonObject);
    
    	/**
	 * 删除项目
	 */
	JSONObject deleteProject(JSONObject jsonObject);
}