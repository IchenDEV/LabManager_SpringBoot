package com.idevlab.LabMgr.Controller;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Enity.Device;
import com.idevlab.LabMgr.Service.DeviceService;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Excel;

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
  
    @RequiresPermissions("device:list")
    @PostMapping("/list")
    public JSONObject listDevice(@RequestBody JSONObject requestJson) {
        return deviceService.listDevice(requestJson);
    }
    @RequiresPermissions("device:list")
    @PostMapping("/listRecommend")
    public JSONObject listRecomend(@RequestBody JSONObject requestJson) {
        return deviceService.recommendDevice(requestJson);
    }

    @RequiresPermissions("device:update")
    @PostMapping("/listUseRate")
    public JSONObject listUseRate(@RequestBody JSONObject requestJson) {
        return deviceService.listDeviceUseRate(requestJson);
    }
    
    @RequiresPermissions("book:list")
    @PostMapping("/export")
    public void exportBook(HttpServletResponse response) throws NoSuchFileException {
        JSONObject ex=new JSONObject();
        List<JSONObject> lst= deviceService.export(ex);
        List<Device> list =new ArrayList<Device>();
        for (JSONObject var : lst) {
            list.add(new Device(var));
        }
        Excel.exportExcel(list,"export","export", Device.class, "export.xlsx", response);
    }

    @RequiresPermissions("device:add")
    @PostMapping("/add")
    public JSONObject addDevice(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "No,name,description,model,status,band,location,func");
        var result= deviceService.addDevice(requestJson);
        logService.addLog("AddDevice", "id:"+requestJson.getString("id")+";name:"+requestJson.getString("name"));
        return result;
    }

    @RequiresPermissions("device:update")
    @PostMapping("/update")
    public JSONObject updateDevice(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateDevice",requestJson.getString("id"));
        return deviceService.updateDevice(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/delete")
    public JSONObject deleteDevice(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteDevice",requestJson.getString("id"));
        return deviceService.deleteDevice(requestJson);
    }
}