package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 部门 权限
 * @date: 2019/1/26 23:18
 */
public interface DepartmentService {
	JSONObject listDepartment(JSONObject jsonObject);
	JSONObject listDepartmentUser(JSONObject jsonObject);
	JSONObject addDepartment(JSONObject jsonObject);
	JSONObject addUserToDepartment(JSONObject jsonObject);
    JSONObject updateDepartment(JSONObject jsonObject);
	JSONObject deleteDepartment(JSONObject jsonObject);
	JSONObject deleteDepartmentUser(JSONObject jsonObject);
}