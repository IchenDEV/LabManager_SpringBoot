package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * @author: idevlab
 * @description: 登录相关dao
 * @date: 2019/1/22 11:02
 */
public interface LoginDao {
	/**
	 * 根据用户名和密码查询对应的用户
	 */
	JSONObject getUser(@Param("username") String username, @Param("password") String password);

	JSONObject getCurrentUser(@Param("username") String username);

	JSONObject updateCurrentUser(JSONObject jsonObject);

	JSONObject updateCurrentPassword(@Param("username") String username, @Param("password") String password);
}
