package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: msg 权限
 * @date: 2019/1/26 23:18
 */
public interface MsgService {
	JSONObject listMsg(JSONObject jsonObject);

	JSONObject sendMsg(int author, int receiver, String msg);

	JSONObject addMsg(JSONObject jsonObject);

	JSONObject readMsg(JSONObject jsonObject);

	JSONObject deleteMsg(JSONObject jsonObject);
}