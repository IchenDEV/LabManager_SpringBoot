package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.PushMsgService;
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
@RequestMapping("/push")
public class PushController {
    @Autowired
    private LogService logService;
    @Autowired
    private PushMsgService pushService;

    @RequiresPermissions("book:add")
    @PostMapping("/add")
    public JSONObject addLab(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "user,subscription");
        var endpoint = requestJson.getJSONObject("subscription").getString("endpoint");
        var user = requestJson.getIntValue("user");
        var auth = requestJson.getJSONObject("subscription").getJSONObject("keys").getString("auth");
        var upk = requestJson.getJSONObject("subscription").getJSONObject("keys").getString("p256dh");
        var result = pushService.addPush(user, endpoint, upk, auth);
        logService.addLog("Add Push", "id:" + requestJson.getString("id"));
        return result;
    }

}