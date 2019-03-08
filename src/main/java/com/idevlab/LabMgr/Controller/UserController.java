package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.UserService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.ErrorEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: idevlab
 * @description: 用户/角色/权限相关controller
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;

	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("user:list")
	@PostMapping("/list")
	public JSONObject listUser(@RequestBody JSONObject requestJson) {
		return userService.listUser(requestJson);
	}

	@PostMapping("/listGroup")
	public JSONObject listUserGroup(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "id");
		return userService.listUserGroup(requestJson);
	}

	@PostMapping("/listDepartment")
	public JSONObject listUserDepartment(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "id");
		return userService.listUserDepartment(requestJson);
	}
	@PostMapping("/listProject")
	public JSONObject listUserProject(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "id");
		return userService.listUserProject(requestJson);
	}

	@RequiresPermissions("user:add")
	@PostMapping("/add")
	public JSONObject addUser(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "username, password, nickname,roleId");
		var x=userService.addUser(requestJson);
		logService.addLog("addUser","id:"+requestJson.getString("id")+" username:"+requestJson.getString("username")+"name "+requestJson.getString("nickname"));
		return x;
	}

	@RequiresPermissions("user:update")
	@PostMapping("/update")
	public JSONObject updateUser(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "id,adminId,adminSuperPassword");
		if (userService.SuperAdminAuth(requestJson.getInteger("adminId"),
			requestJson.getString("adminSuperPassword"))) {
			logService.addLog("updateUser", requestJson.getString("username"));
			return userService.updateUser(requestJson);
		}
		return CommonUtil.errorJson(ErrorEnum.E_502);
	}

	@RequiresPermissions("user:delete")
	@PostMapping("/delete")
	public JSONObject delUser(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "id");
		logService.addLog("delUser", requestJson.getString("id"));
		return userService.delUser(requestJson);
	}
}
