package com.idevlab.LabMgr.Controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LoginService;
import com.idevlab.LabMgr.Service.UserService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	private UserService userService;
	/**
	 * 登录
	 */
	@CrossOrigin
	@PostMapping("/auth")
	public JSONObject authLogin(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "username,password");
		JSONObject x= loginService.authLogin(requestJson);
		loginService.getInfo();
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
	 * 登出
	 */
	@CrossOrigin
	@PostMapping("/logout")
	public JSONObject logout() {
		return loginService.logout();
	}
}