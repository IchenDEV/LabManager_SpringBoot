package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: log 权限
 * @date: 2019/1/26 23:18
 */
public interface LogService {
	JSONObject listLog(JSONObject jsonObject);
	JSONObject addLog(JSONObject jsonObject);
	JSONObject addLog(String operation, String targer);
	JSONObject addLog(String operator,String operation, String targer);
    JSONObject updateLog(JSONObject jsonObject);
	JSONObject deleteLog(JSONObject jsonObject);
}