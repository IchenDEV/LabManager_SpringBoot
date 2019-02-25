package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.GroupDao;
import com.idevlab.LabMgr.Service.GroupService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.ErrorEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: idevlab
 * @Description: 组/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Override
	public JSONObject listGroup(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = groupDao.countGroup(jsonObject);
		List<JSONObject> list = groupDao.listGroup(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject listGroupUser(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = groupDao.countGroupUser(jsonObject);
		List<JSONObject> list = groupDao.listGroupUser(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject listGroupProject(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = groupDao.countGroupProject(jsonObject);
		List<JSONObject> list = groupDao.listGroupProject(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject addGroup(JSONObject jsonObject) {
		groupDao.addGroup(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject addUserToGroup(JSONObject jsonObject) {
		if (groupDao.countGroupUser(jsonObject) == 0) {
			groupDao.addUserToGroup(jsonObject);
			return CommonUtil.successJson();
		}
		return CommonUtil.errorJson(ErrorEnum.E_90004);
	}

	@Override
	public JSONObject addProjectToGroup(JSONObject jsonObject) {
		if (groupDao.countGroupProject(jsonObject) == 0) {
			groupDao.addProjectToGroup(jsonObject);
			return CommonUtil.successJson();
		}
		return CommonUtil.errorJson(ErrorEnum.E_90004);
	}

	@Override
	public JSONObject updateGroup(JSONObject jsonObject) {
		groupDao.updateGroup(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteGroup(JSONObject jsonObject) {
		JSONObject json = new JSONObject();
		json.put("group", jsonObject.getString("id"));
		groupDao.deleteGroupUser(json);
		groupDao.deleteGroupProject(json);
		groupDao.deleteGroup(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteGroupUser(JSONObject jsonObject) {
		groupDao.deleteGroupUser(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteGroupProject(JSONObject jsonObject) {
		groupDao.deleteGroupProject(jsonObject);
		return CommonUtil.successJson();
	}
}