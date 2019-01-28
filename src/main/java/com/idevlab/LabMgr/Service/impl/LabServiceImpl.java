package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.LabDao;
import com.idevlab.LabMgr.Service.LabService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: idevlab
 * @Description: 实验室/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class LabServiceImpl implements LabService {

	@Autowired
	private LabDao labDao;

	/**
	 * 实验室列表
	 */
	@Override
	public JSONObject listLab(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = labDao.countLab(jsonObject);
		List<JSONObject> list = labDao.listLab(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加实验室
	 */
	@Override
	public JSONObject addLab(JSONObject jsonObject) {
		labDao.addLab(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 修改实验室
	 */
	@Override
	public JSONObject updateLab(JSONObject jsonObject) {
		labDao.updateLab(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 删除实验室
	 */
	@Override
	public JSONObject deleteLab(JSONObject jsonObject) {
		labDao.deleteLab(jsonObject);
		return CommonUtil.successJson();
	}
}