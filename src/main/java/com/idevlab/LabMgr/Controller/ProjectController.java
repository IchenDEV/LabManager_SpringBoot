package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.ProjectService;
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
 * @description: 项目相关controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private LogService logService;

    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listProject(@RequestBody JSONObject requestJson) {
        return projectService.listProject(requestJson);
    }

    @RequiresPermissions("device:list")
    @PostMapping("/group")
    public JSONObject listProjectGroup(@RequestBody JSONObject requestJson) {
        return projectService.listProjectGroup(requestJson);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/add")
    public JSONObject addProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,description,status");
        var result = projectService.addProject(requestJson);
        logService.addLog("AddProject", "id:" + requestJson.getString("id") + " name:" + requestJson.getString("name"));
        return result;
    }

    @RequiresPermissions("device:update")
    @PostMapping("/update")
    public JSONObject updateProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateProject", requestJson.getString("id"));
        return projectService.updateProject(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/delete")
    public JSONObject deleteProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteProject", requestJson.getString("id"));
        return projectService.deleteProject(requestJson);
    }
}