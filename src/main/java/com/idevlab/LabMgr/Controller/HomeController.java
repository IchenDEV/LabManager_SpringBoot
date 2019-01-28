package com.idevlab.LabMgr.Controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.DepartmentDao;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

@Autowired
DepartmentDao departmentDao ;

    @PostMapping("/index")
    public JSONObject index(@RequestBody JSONObject requestJson) {
        CommonUtil.fillPageParam(requestJson);
		int count =  departmentDao.countDepartment(requestJson);
        List<JSONObject> list =  departmentDao.listDepartmentUser(requestJson);
		return CommonUtil.successPage(requestJson, list, count);
    }
}

