package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 部门 权限
 * @date: 2019/1/26 23:18
 */
public interface DepartmentService {
	/**
	 * 部门列表
	 */
	JSONObject listDepartment(JSONObject jsonObject);

	JSONObject listDepartmentUser(JSONObject jsonObject);

	/**
	 * 添加部门
	 */
	JSONObject addDepartment(JSONObject jsonObject);

	JSONObject addUserToDepartment(JSONObject jsonObject);
	
	/**
	 * 修改部门
	 */
    JSONObject updateDepartment(JSONObject jsonObject);
    
    	/**
	 * 删除部门
	 */
	JSONObject deleteDepartment(JSONObject jsonObject);

	JSONObject deleteDepartmentUser(JSONObject jsonObject);
}