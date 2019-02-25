package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 用户/角色/权限
 * @date: 2017/11/2 10:18
 */
public interface UserService {
	JSONObject listUser(JSONObject jsonObject);
	JSONObject listUserGroup(JSONObject jsonObject);
	JSONObject listUserDepartment(JSONObject jsonObject);
	JSONObject listUserProject(JSONObject jsonObject);
	
	Boolean SuperAdminAuth(int id, String superPassword) ;
	
	JSONObject addUser(JSONObject jsonObject);
	JSONObject updateUser(JSONObject jsonObject);
	JSONObject delUser(JSONObject jsonObject);
	
	JSONObject listRole();
	JSONObject getAllRoles();
	JSONObject listAllPermission();
	JSONObject addRole(JSONObject jsonObject);
	JSONObject updateRole(JSONObject jsonObject);
	JSONObject deleteRole(JSONObject jsonObject);
}
