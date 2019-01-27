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

	/**
	 * 添加组
	 */
	JSONObject addGroup(JSONObject jsonObject);

	/**
	 * 修改组
	 */
    JSONObject updateGroup(JSONObject jsonObject);
    
    	/**
	 * 删除组
	 */
	JSONObject deleteGroup(JSONObject jsonObject);
}