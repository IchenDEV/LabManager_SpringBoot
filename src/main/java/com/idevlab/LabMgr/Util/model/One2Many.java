package com.idevlab.LabMgr.Util.Model;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Set;

/**
 * @author: idevlab
 * @description: MyBatis的一对多JSON返回对象
 * <p>
 * 处理嵌套查询结果时，MyBatis会根据bean定义的属性类型来初始化嵌套的成员变量，
 * 主要看其是不是Collection
 * 如果这里不定义，那么嵌套返回结果里就只能返回一对一的结果，而不是一对多的
 * <p>
 * 参见MyBatis  DefaultResultSetHandler.instantiateCollectionPropertyIfAppropriate()
 * @date: 2017/10/24 10:17
 */
public class One2Many extends JSONObject{
	private Set<String> roleList;
	private Set<String> menuList;
	private Set<String> permissionList;
	private Set<Integer> permissionIds;
	private List<JSONObject> picList;
	private List<JSONObject> menus;
	private List<JSONObject> users;
	private List<JSONObject> permissions;

	/**
	 * @return the menuList
	 */
	public Set<String> getMenuList() {
		return menuList;
	}

	/**
	 * @return the permissions
	 */
	public List<JSONObject> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<JSONObject> permissions) {
		this.permissions = permissions;
	}

	/**
	 * @return the users
	 */
	public List<JSONObject> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<JSONObject> users) {
		this.users = users;
	}

	/**
	 * @return the picList
	 */
	public List<JSONObject> getPicList() {
		return picList;
	}

	/**
	 * @param picList the picList to set
	 */
	public void setPicList(List<JSONObject> picList) {
		this.picList = picList;
	}

	/**
	 * @return the permissionIds
	 */
	public Set<Integer> getPermissionIds() {
		return permissionIds;
	}

	/**
	 * @param permissionIds the permissionIds to set
	 */
	public void setPermissionIds(Set<Integer> permissionIds) {
		this.permissionIds = permissionIds;
	}

	/**
	 * @return the permissionList
	 */
	public Set<String> getPermissionList() {
		return permissionList;
	}

	/**
	 * @param permissionList the permissionList to set
	 */
	public void setPermissionList(Set<String> permissionList) {
		this.permissionList = permissionList;
	}

	/**
	 * @return the menus
	 */
	public List<JSONObject> getMenus() {
		return menus;
	}

	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<JSONObject> menus) {
		this.menus = menus;
	}

	/**
	 * @return the roleList
	 */
	public Set<String> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(Set<String> roleList) {
		this.roleList = roleList;
	}

	/**
	 * @param menuList the menuList to set
	 */
	public void setMenuList(Set<String> menuList) {
		this.menuList = menuList;
	}
}
