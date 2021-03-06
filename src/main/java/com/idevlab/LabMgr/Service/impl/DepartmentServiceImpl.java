package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.DepartmentDao;
import com.idevlab.LabMgr.Service.DepartmentService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.ErrorEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: idevlab
 * @Description: 部门
 * @date: 2019/1/22 10:18
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public JSONObject listDepartment(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = departmentDao.countDepartment(jsonObject);
		List<JSONObject> list = departmentDao.listDepartment(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject listDepartmentUser(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = departmentDao.countDepartmentUser(jsonObject);
		List<JSONObject> list = departmentDao.listDepartmentUser(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject addDepartment(JSONObject jsonObject) {
		departmentDao.addDepartment(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject addUserToDepartment(JSONObject jsonObject) {
		if (departmentDao.countDepartmentUser(jsonObject) == 0) {
			departmentDao.addUserToDepartment(jsonObject);
			return CommonUtil.successJson();
		}
		return CommonUtil.errorJson(ErrorEnum.E_90004);
	}

	@Override
	public JSONObject updateDepartment(JSONObject jsonObject) {
		departmentDao.updateDepartment(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteDepartment(JSONObject jsonObject) {
		JSONObject json = new JSONObject();
		json.put("department", jsonObject.getString("id"));
		departmentDao.deleteDepartmentUser(json);
		departmentDao.deleteDepartment(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteDepartmentUser(JSONObject jsonObject) {
		departmentDao.deleteDepartmentUser(jsonObject);
		return CommonUtil.successJson();
	}
}