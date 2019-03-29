package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.PushDao;
import com.idevlab.LabMgr.Service.PushMsgService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Push;

import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author: idevlab
 * @Description: 实验室/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class PushMsgServiceImpl implements PushMsgService {

	@Autowired
	private PushDao pushDao;

	@Override
	public List<JSONObject> listPush(int user) {
		JSONObject json = new JSONObject();
		json.put("user", user);
		List<JSONObject> list = pushDao.listPush(json);
		return list;
	}

	public void pushToUser(int user, String payload) {
		System.out.print(user);
		var list = listPush(user);
		Push p = new Push();
		for (var item : list) {
			try {
				p.pushMsg(item.getString("endpoint"), item.getString("userPublicKey"), item.getString("auth"), payload);
			} catch (GeneralSecurityException | IOException | JoseException | ExecutionException
					| InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public JSONObject addPush(JSONObject jsonObject) {
		pushDao.addPush(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject addPush(int user, String endpoint, String userPublicKey, String auth) {
		JSONObject json = new JSONObject();
		json.put("endpoint", endpoint);
		json.put("userPublicKey", userPublicKey);
		json.put("auth", auth);
		json.put("user", user);
		json.put("status", 1);
		pushDao.addPush(json);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deletePush(JSONObject jsonObject) {
		pushDao.deletePush(jsonObject);
		return CommonUtil.successJson();
	}
}