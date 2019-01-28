package com.idevlab.LabMgr.Controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.DepartmentDao;
import com.idevlab.LabMgr.Dao.UserDao;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.UserService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

@Autowired
DepartmentDao departmentDao;
@Autowired
UserService userService;
UserDao userDao;

    @PostMapping("/index")
    public JSONObject index(@RequestBody JSONObject requestJson) {
        CommonUtil.fillPageParam(requestJson);
		int count =  departmentDao.countDepartmentUser(requestJson);
        List<JSONObject> list =  departmentDao.listDepartmentUser(requestJson);
		return CommonUtil.successPage(requestJson, list, count);
    }

    @PostMapping(value="singUp")
    public JSONObject SingUp(@RequestBody JSONObject requestJson) {
       CommonUtil.hasAllRequired(requestJson, "username, password, nickname");
       requestJson.put("roleId",3);
       return userService.addUser(requestJson);
    }

}

