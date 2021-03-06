package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Service.LoginService;
import com.idevlab.LabMgr.Service.UserService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
   @Autowired
   UserService userService;
   @Autowired
   LoginService loginService;

   @RequestMapping("/")
   public String index() {
      return "Welcome  to  LabMgr backend System  0.95";
   }

   @PostMapping("/singUp")
   public JSONObject SingUp(@RequestBody JSONObject requestJson) {
      CommonUtil.hasAllRequired(requestJson, "username, password, nickname");
      requestJson.put("roleId", 3);
      return userService.addUser(requestJson);
   }

   @PostMapping("/queryExistUsername")
   public JSONObject queryExistUsername(@RequestBody JSONObject requestJson) {
      CommonUtil.hasAllRequired(requestJson, "username");
      return loginService.queryExistUsername(requestJson);
   }

}
