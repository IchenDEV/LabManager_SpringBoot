package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.DeviceService;
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
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private LogService logService;
    /**
     * 查询记录列表
     * offSet 
     * pageRow
     */
    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listDevice(@RequestBody JSONObject requestJson) {
        return deviceService.listDevice(requestJson);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/addDevice")
    public JSONObject addDevice(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "No,name,description,model,status,band,location");
        logService.addLog("AddDevice", "New");
        return deviceService.addDevice(requestJson);
    }

    @RequiresPermissions("device:update")
    @PostMapping("/updateDevice")
    public JSONObject updateDevice(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateDevice",requestJson.getString("id"));
        return deviceService.updateDevice(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteDevice")
    public JSONObject deleteDevice(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteDevice",requestJson.getString("id"));
        return deviceService.deleteDevice(requestJson);
    }
}