package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.DepartmentDao;
import com.idevlab.LabMgr.Dao.GroupDao;
import com.idevlab.LabMgr.Dao.UserDao;
import com.idevlab.LabMgr.Service.UserService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author: idevlab
 * @Description: 用户/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private DepartmentDao departmentDao;
	private GroupDao groupDao;

	/**
	 * 用户列表
	 */
	@Override
	public JSONObject listUser(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = userDao.countUser(jsonObject);
		List<JSONObject> list = userDao.listUser(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject listUserGroup(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = userDao.countUserGroup(jsonObject);
		List<JSONObject> list = userDao.listUserGroup(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject listUserDepartment(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = userDao.countUserDepartment(jsonObject);
		List<JSONObject> list = userDao.listUserDepartment(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject listUserProject(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = userDao.countUserProject(jsonObject);
		List<JSONObject> list = userDao.listUserProject(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public Boolean SuperAdminAuth(int id, String superPassword) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("superPassword", superPassword);
		int count = userDao.countUserGroup(jsonObject);
		if (count == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 添加用户
	 */
	@Override
	public JSONObject addUser(JSONObject jsonObject) {
		int exist = userDao.queryExistUsername(jsonObject);
		if (exist > 0) {
			return CommonUtil.errorJson(ErrorEnum.E_10009);
		}
		String password = com.idevlab.LabMgr.Util.CommonUtil.md5(jsonObject.getString("password"));
		jsonObject.replace("password", password);
		userDao.addUser(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 查询所有的角色 在添加/修改用户的时候要使用此方法
	 */
	@Override
	public JSONObject getAllRoles() {
		List<JSONObject> roles = userDao.getAllRoles();
		return CommonUtil.successPage(roles);
	}

	/**
	 * 修改用户
	 */
	@Override
	public JSONObject updateUser(JSONObject jsonObject) {
		if (jsonObject.getString("password") != null) {
			String password = com.idevlab.LabMgr.Util.CommonUtil.md5(jsonObject.getString("password"));
			jsonObject.replace("password", password);
		}
		if (jsonObject.getString("superPassword") != null) {
			String superPassword = com.idevlab.LabMgr.Util.CommonUtil.md5(jsonObject.getString("superPassword"));
			jsonObject.replace("superPassword", superPassword);
		}
		userDao.updateUser(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 修改用户
	 */
	@Override
	public JSONObject delUser(JSONObject jsonObject) {
		JSONObject json = new JSONObject();
		json.put("group", jsonObject.getString("id"));
		json.put("department", jsonObject.getString("id"));
		try {
			departmentDao.deleteDepartmentUser(json);
			groupDao.deleteGroup(json);
		} catch (NullPointerException nu) {

		}
		userDao.delUser(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 角色列表
	 */
	@Override
	public JSONObject listRole() {
		List<JSONObject> roles = userDao.listRole();
		return CommonUtil.successPage(roles);
	}

	/**
	 * 查询所有权限, 给角色分配权限时调用
	 */
	@Override
	public JSONObject listAllPermission() {
		List<JSONObject> permissions = userDao.listAllPermission();
		return CommonUtil.successPage(permissions);
	}

	/**
	 * 添加角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject addRole(JSONObject jsonObject) {
		userDao.insertRole(jsonObject);
		userDao.insertRolePermission(jsonObject.getString("roleId"), (List<Integer>) jsonObject.get("permissions"));
		return CommonUtil.successJson();
	}

	/**
	 * 修改角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject updateRole(JSONObject jsonObject) {
		String roleId = jsonObject.getString("roleId");
		List<Integer> newPerms = (List<Integer>) jsonObject.get("permissions");
		JSONObject roleInfo = userDao.getRoleAllInfo(jsonObject);
		Set<Integer> oldPerms = (Set<Integer>) roleInfo.get("permissionIds");
		// 修改角色名称
		dealRoleName(jsonObject, roleInfo);
		// 添加新权限
		saveNewPermission(roleId, newPerms, oldPerms);
		// 移除旧的不再拥有的权限
		removeOldPermission(roleId, newPerms, oldPerms);
		return CommonUtil.successJson();
	}

	/**
	 * 修改角色名称
	 */
	private void dealRoleName(JSONObject paramJson, JSONObject roleInfo) {
		String roleName = paramJson.getString("roleName");
		if (!roleName.equals(roleInfo.getString("roleName"))) {
			userDao.updateRoleName(paramJson);
		}
	}

	/**
	 * 为角色添加新权限
	 */
	private void saveNewPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
		List<Integer> waitInsert = new ArrayList<>();
		for (Integer newPerm : newPerms) {
			if (!oldPerms.contains(newPerm)) {
				waitInsert.add(newPerm);
			}
		}
		if (waitInsert.size() > 0) {
			userDao.insertRolePermission(roleId, waitInsert);
		}
	}

	/**
	 * 删除角色 旧的 不再拥有的权限
	 */
	private void removeOldPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
		List<Integer> waitRemove = new ArrayList<>();
		for (Integer oldPerm : oldPerms) {
			if (!newPerms.contains(oldPerm)) {
				waitRemove.add(oldPerm);
			}
		}
		if (waitRemove.size() > 0) {
			userDao.removeOldPermission(roleId, waitRemove);
		}
	}

	/**
	 * 删除角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject deleteRole(JSONObject jsonObject) {
		JSONObject roleInfo = userDao.getRoleAllInfo(jsonObject);
		List<JSONObject> users = (List<JSONObject>) roleInfo.get("users");
		if (users != null && users.size() > 0) {
			return CommonUtil.errorJson(ErrorEnum.E_10008);
		}
		userDao.removeRole(jsonObject);
		userDao.removeRoleAllPermission(jsonObject);
		return CommonUtil.successJson();
	}
}
