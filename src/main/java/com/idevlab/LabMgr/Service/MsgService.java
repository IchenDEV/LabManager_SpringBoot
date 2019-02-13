package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: msg 权限
 * @date: 2019/1/26 23:18
 */
public interface MsgService {
	/**
	 * msg列表
	 */
	JSONObject listMsg(JSONObject jsonObject);

	/**
	 * 添加msg
	 */
	JSONObject addMsg(JSONObject jsonObject);

	JSONObject readMsg(JSONObject jsonObject);
    	/**
	 * 删除msg
	 */
	JSONObject deleteMsg(JSONObject jsonObject);
}