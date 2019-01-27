package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao. DepartmentDao;
import com.idevlab.LabMgr.Service. DepartmentService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: idevlab
 * @Description: 部门
 * @date: 2019/1/22 10:18
 */
@Service
public class DepartmentServiceImpl implements  DepartmentService {

	@Autowired
	private  DepartmentDao  departmentDao;

	/**
	 * 部门列表
	 */
	@Override
	public JSONObject listDepartment(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =  departmentDao.countDepartment(jsonObject);
		List<JSONObject> list =  departmentDao.listDepartment(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加部门
	 */
	@Override
	public JSONObject addDepartment(JSONObject jsonObject) {	
        departmentDao.addDepartment(jsonObject);
		return CommonUtil.successJson();
	}

	
	/**
	 * 修改部门
	 */
	@Override
	public JSONObject updateDepartment(JSONObject jsonObject) {
		departmentDao.updateDepartment(jsonObject);
		return CommonUtil.successJson();
    }
    
    @Override
    public JSONObject deleteDepartment(JSONObject jsonObject){
        departmentDao.deleteDepartment(jsonObject);
		return CommonUtil.successJson();
    }
}