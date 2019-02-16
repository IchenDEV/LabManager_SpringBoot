package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: log 权限
 * @date: 2019/1/26 23:18
 */
public interface LogService {
	/**
	 * log列表
	 */
	JSONObject listLog(JSONObject jsonObject);

	/**
	 * 添加log
	 */
	JSONObject addLog(JSONObject jsonObject);

	/**
	 * 添加log
	 */
	JSONObject addLog(String operation, String targer);
	/**
	 * 添加log
	 */
	JSONObject addLog(String operator,String operation, String targer);

	/**
	 * 修改log
	 */
    JSONObject updateLog(JSONObject jsonObject);
    
    	/**
	 * 删除log
	 */
	JSONObject deleteLog(JSONObject jsonObject);
}