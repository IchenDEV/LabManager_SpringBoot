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
    /**
     * 查询组列表
     * offSet 
     * pageRow
     */
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
    @PostMapping("/addGroup")
    public JSONObject addGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,description,status");
        logService.addLog("AddGroup", "New");
        return groupService.addGroup(requestJson);
    }
    @RequiresPermissions("device:add")
    @PostMapping("/addGroupUser")
    public JSONObject addGroupUser(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "user,group,status");
        logService.addLog("AddGroupUser", "New");
        return groupService.addUserToGroup(requestJson);
    }
    @RequiresPermissions("device:add")
    @PostMapping("/addGroupProject")
    public JSONObject addGroupProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "user,group,status");
        logService.addLog("AddGroupProject", "New");
        return groupService.addProjectToGroup(requestJson);
    }

    @RequiresPermissions("device:update")
    @PostMapping("/updateGroup")
    public JSONObject updateGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateGroup",requestJson.getString("id"));
        return groupService.updateGroup(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteGroup")
    public JSONObject deleteGroup(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteGroup",requestJson.getString("id"));
        return groupService.deleteGroup(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteGroupUser")
    public JSONObject deleteGroupUser(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteGroupUser",requestJson.getString("id"));
        return groupService.deleteGroupUser(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteGroupProject")
    public JSONObject deleteGroupProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteGroupProject",requestJson.getString("id"));
        return groupService.deleteGroupProject(requestJson);
    }
}