package com.idevlab.LabMgr.Service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 实验室 权限
 * @date: 2019/1/26 23:18
 */
public interface PushMsgService {

	JSONObject addPush(JSONObject jsonObject);

	List<JSONObject> listPush(int user);

	List<JSONObject> listPush();

	void pushToUser(int user, String payload);

	JSONObject addPush(int user, String endpoint, String userPublicKey, String auth);

	void pushToAll(String payload);

	JSONObject deletePush(JSONObject jsonObject);
}