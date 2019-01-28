package com.idevlab.LabMgr.Controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.DeviceService;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
     * 查询用户列表
     * offSet 
     * pageRow
     */
    @RequiresPermissions("device:list")
    @GetMapping("/list")
    public JSONObject listDevice(HttpServletRequest request) {
        return deviceService.listDevice(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("device:list")
    @GetMapping("/listById")
    public JSONObject listDeviceById(HttpServletRequest request) {
        return deviceService.listDevice(CommonUtil.request2Json(request));
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
}