package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.Set;

/**
 * @author: idevlab
 * @description: 权限相关dao
 * @date: 2019/1/22 11:02
 */
public interface PermissionDao {
	/**
	 * 查询用户的角色 菜单 权限
	 */
	JSONObject getUserPermission(String username);

	/**
	 * 查询所有的菜单
	 */
	Set<String> getAllMenu();

	/**
	 * 查询所有的权限
	 */
	Set<String> getAllPermission();
}
