package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.MsgService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: idevmsg
 * @description: msg controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;
    @Autowired
    private LogService logService;
 
    @RequiresPermissions("book:list")
    @PostMapping("/list")
    public JSONObject listMsg(@RequestBody JSONObject requestJson) {
        return msgService.listMsg(requestJson);
    }
    @RequiresPermissions("book:add")
    @PostMapping("/addMsg")
    public JSONObject addMsg(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "author,receiver,msg");
        var result=msgService.addMsg(requestJson);
        logService.addLog("AddMsg","id:"+requestJson.getString("id")+" receiver:"+requestJson.getString("receiver"));
        return result;
    }
    @RequiresPermissions("book:delete")
    @PostMapping("/deleteMsg")
    public JSONObject deleteMsg(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteMsg",requestJson.getString("id"));
        return msgService.deleteMsg(requestJson);
    }

    @RequiresPermissions("book:update")
    @PostMapping("/readMsg")
    public JSONObject readMsg(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("readMsg",requestJson.getString("id"));
        return msgService.readMsg(requestJson);
    }
}