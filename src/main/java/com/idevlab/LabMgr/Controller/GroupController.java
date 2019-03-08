package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.GroupService;
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
 * @description: 组controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private LogService logService;
 
    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listGroup(@RequestBody JSONObject requestJson) {
        return groupService.listGroup(requestJson);
    }
    @RequiresPermissions("device:list")
    @PostMapping("/listUser")
    public JSONObject listGroupUser(@RequestBody JSONObject requestJson) {
        return groupService.listGroupUser(requestJson);
    }
    @RequiresPermissions("device:list")
    @PostMapping("/listProject")
    public JSONObject listGroupProject(@RequestBody JSONObject requestJson) {
        return groupService.listGroupProject(requestJson);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/add")
    public JSONObject addGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,description,status");
        var x= groupService.addGroup(requestJson);
        logService.addLog("AddGroup", "id:"+requestJson.getString("id")+";name:"+requestJson.getString("name"));
        return x;
    }
    @RequiresPermissions("device:add")
    @PostMapping("/addUser")
    public JSONObject addGroupUser(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "user,group,status");
        var x= groupService.addUserToGroup(requestJson);
        logService.addLog("AddGroupUser", "id:"+requestJson.getString("id")+";user:"+requestJson.getString("user")+";group:"+requestJson.getString("group"));
        return x;
    }
    @RequiresPermissions("device:add")
    @PostMapping("/addProject")
    public JSONObject addGroupProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "project,group,status");
        var x=groupService.addProjectToGroup(requestJson);
        logService.addLog("AddGroupProject", "id:"+requestJson.getString("id")+";project:"+requestJson.getString("project")+";group:"+requestJson.getString("group"));
        return x;
    }

    @RequiresPermissions("device:update")
    @PostMapping("/update")
    public JSONObject updateGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateGroup",requestJson.getString("id"));
        return groupService.updateGroup(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/delete")
    public JSONObject deleteGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteGroup",requestJson.getString("id"));
        return groupService.deleteGroup(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteUser")
    public JSONObject deleteGroupUser(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteGroupUser",requestJson.getString("id"));
        return groupService.deleteGroupUser(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteProject")
    public JSONObject deleteGroupProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteGroupProject",requestJson.getString("id"));
        return groupService.deleteGroupProject(requestJson);
    }
}