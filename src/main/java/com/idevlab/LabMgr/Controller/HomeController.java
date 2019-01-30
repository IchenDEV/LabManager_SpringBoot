package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.DepartmentDao;
import com.idevlab.LabMgr.Dao.UserDao;
import com.idevlab.LabMgr.Service.UserService;
import com.idevlab.LabMgr.Util.CommonUtil;

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

    @RequestMapping("/")
    public String index() {
       return "Welcome to LabMgr System";
    }

    @PostMapping("/singUp")
    public JSONObject SingUp(@RequestBody JSONObject requestJson) {
       CommonUtil.hasAllRequired(requestJson, "username, password, nickname");
       requestJson.put("roleId",3);
       return userService.addUser(requestJson);
    }

}

