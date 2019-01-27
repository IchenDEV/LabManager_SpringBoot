package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.GroupDao;
import com.idevlab.LabMgr.Service.GroupService;
import com.idevlab.LabMgr.Util.CommonUtil;
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
	private  GroupDao  groupDao;

	/**
	 * 组列表
	 */
	@Override
	public JSONObject listGroup(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =   groupDao.countGroup(jsonObject);
		List<JSONObject> list =   groupDao.listGroup(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加组
	 */
	@Override
	public JSONObject addGroup(JSONObject jsonObject) {	
		groupDao.addGroup(jsonObject);
		return CommonUtil.successJson();
	}

	
	/**
	 * 修改组
	 */
	@Override
	public JSONObject updateGroup(JSONObject jsonObject) {
		groupDao.updateGroup(jsonObject);
		return CommonUtil.successJson();
    }
    
    @Override
    public JSONObject deleteGroup(JSONObject jsonObject){
		groupDao.deleteGroup(jsonObject);
		return CommonUtil.successJson();
    }
}