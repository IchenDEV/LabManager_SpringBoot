package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.DepartmentService;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: idevlab
 * @description: 用户/角色/权限相关controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LogService logService;
    /**
     * 查询部门列表
     * offSet 
     * pageRow
     */
    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listDepartment(@RequestBody JSONObject requestJson) {
        return departmentService.listDepartment(requestJson);
    }

    @RequiresPermissions("device:list")
    @PostMapping("/listUser")
    public JSONObject listDepartmentUser(@RequestBody JSONObject requestJson) {
        return departmentService.listDepartmentUser(requestJson);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/addDepartment")
    public JSONObject addDepartment(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,description,status");
        logService.addLog("AddDepartment","id:"+requestJson.getString("id")+";name:"+requestJson.getString("name"));
        return departmentService.addDepartment(requestJson);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/addDepartmentUser")
    public JSONObject addDepartmentUser(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "user,department,status");
        var x =departmentService.addUserToDepartment(requestJson);
        logService.addLog("AddDepartmentUser", "id:"+requestJson.getString("id")+";user:"+requestJson.getString("user")+";department'"+requestJson.getString("department"));
        return x;
    }
 

    @RequiresPermissions("device:update")
    @PostMapping("/updateDepartment")
    public JSONObject updateDepartment(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateDepartment",requestJson.getString("id"));
        return departmentService.updateDepartment(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteDepartment")
    public JSONObject deleteDepartment(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteDepartment",requestJson.getString("id"));
        return departmentService.deleteDepartment(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteDepartmentUser")
    public JSONObject deleteDepartmentUser(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteDepartmentUser",requestJson.getString("id"));
        return departmentService.deleteDepartmentUser(requestJson);
    }
}