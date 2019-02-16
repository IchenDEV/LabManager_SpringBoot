package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Config.DynamicScheduledTask;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/backup")
public class BackupController {

   @Autowired
   DynamicScheduledTask dynamicScheduledTask;
   @Autowired
   LogService logService;

   @PostMapping("/now")
   @RequiresPermissions("device:delete")
   public JSONObject now() {
      try {
         System.out.print("Backup Start");
         logService.addLog("Backup", "Now");
         String shpath = "/home/backup.sh";
         Process ps = Runtime.getRuntime().exec(shpath);
         ps.waitFor();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return CommonUtil.successJson();
   }

   @RequiresPermissions("device:delete")
   @PostMapping("/setSchedule")
   public JSONObject setSchedule(@RequestBody JSONObject requestJson) {
      CommonUtil.hasAllRequired(requestJson, "schedule");
      logService.addLog("SetBackupSchedule", requestJson.getString("schedule"));
      dynamicScheduledTask.setCron(requestJson.getString("schedule"));
      return CommonUtil.successJson();
   }

   @RequiresPermissions("device:delete")
   @PostMapping("/getSchedule")
   public JSONObject setSchedule() {
     JSONObject js=new JSONObject();
     js.put("cron",dynamicScheduledTask.getCron());
      return CommonUtil.successJson(js);
   }
}
