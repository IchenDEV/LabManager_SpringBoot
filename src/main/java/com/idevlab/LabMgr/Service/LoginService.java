package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 登录Service
 * @date: 2017/10/24 11:02
 */
public interface LoginService {
	JSONObject authLogin(JSONObject jsonObject);
	JSONObject queryExistUsername(JSONObject jsonObject);
	/**
	 * 根据用户名和密码查询对应的用户
	 *
	 * @param username 用户名
	 * @param password 密码
	 */
	JSONObject getUser(String username, String password);

	/**
	 * 查询当前登录用户的权限等信息
	 */
	JSONObject getInfo();
	JSONObject updateCurrentUser(JSONObject jsonObject);
	JSONObject updateCurrentPassword(String username, String password);
	JSONObject logout();
}