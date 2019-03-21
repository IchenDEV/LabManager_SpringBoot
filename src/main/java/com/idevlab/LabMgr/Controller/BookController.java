package com.idevlab.LabMgr.Controller;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Enity.Book;
import com.idevlab.LabMgr.Service.BookService;
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

    

    @RequiresPermissions("book:list")
    @PostMapping("/export")
    public void exportBook(HttpServletResponse response) throws NoSuchFileException {
        JSONObject ex=new JSONObject();
        List<JSONObject> lst= bookService.exportBook(ex);
        List<Book> list =new ArrayList<Book>();
        for (JSONObject var : lst) {
            list.add(new Book(var));
        }
        Excel.exportExcel(list,"export","export", Book.class, Long.toString((new Date()).getTime())+".xlsx", response);
    }

    @RequiresPermissions("book:add")
    @PostMapping("/add")
    public JSONObject addBook(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "project,device,beginTime,endTime,applicant,status");
        var result=bookService.addBook(requestJson);
        logService.addLog("AddBook","id:"+ requestJson.getString("id")+";project:"+requestJson.getString("project")+";device:"+requestJson.getString("device"));
        return result;
    }

    @RequiresPermissions("book:update")
    @PostMapping("/update")
    public JSONObject updateBook(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("UpdateBook", requestJson.getString("id"));
        return bookService.updateBook(requestJson);
    }

    @RequiresPermissions("device:delete")
    @PostMapping("/delete")
    public JSONObject deleteBook(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        logService.addLog("DeleteBook",requestJson.getString("id"));
        return bookService.deleteBook(requestJson);
    }

    @RequiresPermissions("device:list")
    @PostMapping("/getHot")
    public JSONObject getHot(@RequestBody JSONObject requestJson) {
        logService.addLog("getHotDevice","Hot");
        return bookService.getHotBook(requestJson);
    }
}