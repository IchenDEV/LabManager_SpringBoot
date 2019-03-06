package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.HyperSearchService;
import com.idevlab.LabMgr.Service.LogService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/hyperSearch")
public class HyperSearchContriller {

   @Autowired
   LogService logService;
   @Autowired
   HyperSearchService hyperSearchService;

   @PostMapping("/search")
   @RequiresPermissions("device:delete")
   public JSONObject search(@RequestBody JSONObject requestJson) {
     return  hyperSearchService.search(requestJson);
   }
}