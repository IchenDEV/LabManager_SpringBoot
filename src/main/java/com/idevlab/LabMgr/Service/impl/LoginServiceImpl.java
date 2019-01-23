package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.LoginDao;
import com.idevlab.LabMgr.Service.LoginService;
import com.idevlab.LabMgr.Service.PermissionService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: idevlab
 * @description: 登录service实现类
 * @date: 2019/1/22 11:53
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 登录提交
	 */
	@Override
	public JSONObject authLogin(JSONObject jsonObject) {
		JSONObject info = new JSONObject();//用于返回JSON包

		String username = jsonObject.getString("username");//截取用户名
		String password = com.idevlab.LabMgr.Util.CommonUtil.md5(jsonObject.getString("password"));//截取密码并加密
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);//获得token
		try {
			currentUser.login(token);//登录
			info.put("loginCode", 0);//登录成功返回loginCode 0
			info.put("result", "success");
		} catch (AuthenticationException e) {
			info.put("loginCode", -1);//登录失败返回loginCode -1
			info.put("result", "fail");
		}
		return CommonUtil.successJson(info);//打包返回
	}

	/**
	 * 根据用户名和密码查询对应的用户
	 */
	@Override
	public JSONObject getUser(String username, String password) {
		return loginDao.getUser(username, password);
	}

	/**
	 * 查询当前登录用户的权限等信息
	 */
	@Override
	public JSONObject getInfo() {
		//从session获取用户信息
		Session session = SecurityUtils.getSubject().getSession();//获得session
		JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
		String username = userInfo.getString("username");
		JSONObject info = new JSONObject();
		JSONObject userPermission = permissionService.getUserPermission(username);
		session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
		info.put("userPermission", userPermission);
		return CommonUtil.successJson(info);
	}

	/**
	 * 退出登录
	 */
	@Override
	public JSONObject logout() {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();//登出
		} catch (Exception e) {
		}
		return CommonUtil.successJson();
	}

}
