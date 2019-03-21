package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Service.AnnouncementService;
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
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService msgService;
    @Autowired
    private LogService logService;
 
    
    @PostMapping("/list")
    public JSONObject listAnnouncement(@RequestBody JSONObject requestJson) {
        return msgService.listAnnouncement(requestJson);
    }
    
    @PostMapping("/get")
    public JSONObject getAnnouncement(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return msgService.getAnnouncement(requestJson);
    }
    @RequiresPermissions("book:add")
    @PostMapping("/add")
    public JSONObject addLab(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "author,title,summary,msg");
        var result=msgService.addAnnouncement(requestJson);
        logService.addLog("AddAnnouncement","id:"+requestJson.getString("id"));
        return result;
    }
    @RequiresPermissions("book:delete")
    @PostMapping("/delete")
    public JSONObject deleteAnnouncement(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteAnnouncement",requestJson.getString("id"));
        return msgService.deleteAnnouncement(requestJson);
    }

    @RequiresPermissions("book:update")
    @PostMapping("/update")
    public JSONObject updateAnnouncement(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("updateAnnouncement",requestJson.getString("id"));
        return msgService.updateAnnouncement(requestJson);
    }
}