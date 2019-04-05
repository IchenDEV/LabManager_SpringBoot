package com.idevlab.LabMgr.Controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.MsgService;
import com.idevlab.LabMgr.Service.PushMsgService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jose4j.lang.JoseException;
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
    @Autowired
    private PushMsgService pushService;

    @RequiresPermissions("book:list")
    @PostMapping("/list")
    public JSONObject listMsg(@RequestBody JSONObject requestJson) {
        return msgService.listMsg(requestJson);
    }

    @RequiresPermissions("book:add")
    @PostMapping("/add")
    public JSONObject addMsg(@RequestBody JSONObject requestJson)
            throws GeneralSecurityException, IOException, JoseException, ExecutionException, InterruptedException {
        CommonUtil.hasAllRequired(requestJson, "author,receiver,msg");
        var result = msgService.addMsg(requestJson);
        pushService.pushToUser(requestJson.getIntValue("receiver"), requestJson.getString("msg"));
        logService.addLog("AddMsg",
                "id:" + requestJson.getString("id") + " receiver:" + requestJson.getString("receiver"));
        return result;
    }

    @RequiresPermissions("book:delete")
    @PostMapping("/delete")
    public JSONObject deleteMsg(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteMsg", requestJson.getString("id"));
        return msgService.deleteMsg(requestJson);
    }

    @RequiresPermissions("book:update")
    @PostMapping("/read")
    public JSONObject readMsg(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("readMsg", requestJson.getString("id"));
        return msgService.readMsg(requestJson);
    }
}