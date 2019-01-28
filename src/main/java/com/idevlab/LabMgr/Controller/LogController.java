package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
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
 * @author: idevlog
 * @description: log controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    /**
     * 查询实验室列表
     * offSet 
     * pageRow
     */
    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listLog(@RequestBody JSONObject requestJson) {
        return logService.listLog(requestJson);
    }

    @RequiresPermissions("device:update")
    @PostMapping("/updateLog")
    public JSONObject updateLog(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateLog",requestJson.getString("id"));
        return logService.updateLog(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteLog")
    public JSONObject deleteLog(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteLog",requestJson.getString("id"));
        return logService.deleteLog(requestJson);
    }
}