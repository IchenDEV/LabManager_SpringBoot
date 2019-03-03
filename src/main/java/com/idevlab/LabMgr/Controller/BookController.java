package com.idevlab.LabMgr.Controller;

import com.alibaba.fastjson.JSONObject;
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
/**
 * @author: idevlab
 * @description: 用户/角色/权限相关controller
 * @date: 2019/1/26 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LogService logService;

    @RequiresPermissions("book:list")
    @PostMapping("/list")
    public JSONObject listBook(@RequestBody JSONObject requestJson) {
        return bookService.listBook(requestJson);
    }

    @RequiresPermissions("book:add")
    @PostMapping("/addBook")
    public JSONObject addBook(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "project,device,beginTime,endTime,applicant,status");
        var result=bookService.addBook(requestJson);
        logService.addLog("AddBook","id:"+ requestJson.getString("id")+";project:"+requestJson.getString("project")+";device:"+requestJson.getString("device"));
        return result;
    }

    @RequiresPermissions("book:update")
    @PostMapping("/updateBook")
    public JSONObject updateBook(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateBook", requestJson.getString("id"));
        return bookService.updateBook(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/deleteBook")
    public JSONObject deleteBook(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteBook",requestJson.getString("id"));
        return bookService.deleteBook(requestJson);
    }
}