package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.AnalyseService;
import com.idevlab.LabMgr.Service.BookService;
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
@RequestMapping("/analyse")
public class AnalyseController {

   @Autowired
   LogService logService;
   @Autowired
   AnalyseService analyseService;
   @Autowired
   private BookService bookService;

   @PostMapping("/count")
   @RequiresPermissions("device:delete")
   public JSONObject count() {
      var x=  analyseService.getCount();
      return CommonUtil.successJson(x);
   }
   @RequiresPermissions("book:list")
    @PostMapping("/listMonthCount")
    public JSONObject listMonthCountBook(@RequestBody JSONObject requestJson) {
         CommonUtil.hasAllRequired(requestJson, "year");
        return bookService.listMonthBookCount(requestJson);
    }

   @PostMapping("/totalUseRate")
   @RequiresPermissions("device:delete")
   public JSONObject useRate(@RequestBody JSONObject requestJson) {
      var x=  analyseService.getTotalUseRate(requestJson);
      return CommonUtil.successJson(x);
   }
}
