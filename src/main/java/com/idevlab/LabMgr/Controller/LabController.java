package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LabService;
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
 * @description: 实验室controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/lab")
public class LabController {
    @Autowired
    private LabService labService;
    @Autowired
    private LogService logService;
   
    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listLab(@RequestBody JSONObject requestJson) {
        return labService.listLab(requestJson);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/addLab")
    public JSONObject addLab(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "name,description,status,location");
        var result =labService.addLab(requestJson);
        logService.addLog("AddLab", "id:"+requestJson.getString("id")+";name:"+requestJson.getString("name"));
        return result;
    }

    @RequiresPermissions("device:update")
    @PostMapping("/updateLab")
    public JSONObject updateLab(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateLab",requestJson.getString("id"));
        return labService.updateLab(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteLab")
    public JSONObject deleteLab(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteLab",requestJson.getString("id"));
        return labService.deleteLab(requestJson);
    }
}