package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.LoginService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.Constants;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: idevlab
 * @description: 登录相关Controller
 * @date: 2019/1/22 10:33
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
    @Autowired
    private LogService logService;
	/**
	 * 登录
	 */
	@CrossOrigin
	@PostMapping("/auth")
	public JSONObject authLogin(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "username,password");
		JSONObject x= loginService.authLogin(requestJson);
		JSONObject y= loginService.getInfo();
		Session session = SecurityUtils.getSubject().getSession();//获得session
		JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
		String username = userInfo.getString("username");
		logService.addLog("login",username);
		return x;
	}

	/**
	 * 查询当前登录用户的信息
	 */
	@CrossOrigin
	@PostMapping("/getInfo")
	public JSONObject getInfo() {
		return loginService.getInfo();
	}

	/**
	 * 查询当前登录用户的信息
	 */
	@CrossOrigin
	@PostMapping("/updateInfo")
	public JSONObject updateInfo(@RequestBody JSONObject requestJson) {
		Session session = SecurityUtils.getSubject().getSession();//获得session
		JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
		String username = userInfo.getString("username");
		logService.addLog("updateInfo", username);
		return loginService.updateCurrentUser(requestJson);
	}


	/**
	 * 登出
	 */
	@CrossOrigin
	@PostMapping("/logout")
	public JSONObject logout() {
		return loginService.logout();
	}
}