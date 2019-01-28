package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.LogDao;
import com.idevlab.LabMgr.Service.LogService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.Constants;
import org.apache.shiro.session.Session;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: idevlab
 * @Description: log/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class LogServiceImpl implements  LogService {

	@Autowired
	private  LogDao  logDao;

	/**
	 * log列表
	 */
	@Override
	public JSONObject listLog(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =  logDao.countLog(jsonObject);
		List<JSONObject> list =  logDao.listLog(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加log
	 */
	@Override
	public JSONObject addLog(JSONObject jsonObject) {	

        logDao.addLog(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject addLog(String operation, String targer) {	
		Session session = SecurityUtils.getSubject().getSession();//获得session
		JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
		String username = userInfo.getString("username");
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("user", username);
		jsonObject.put("operation", operation);
		jsonObject.put("targer", targer);
        logDao.addLog(jsonObject);
		return CommonUtil.successJson();
	}

	
	/**
	 * 修改log
	 */
	@Override
	public JSONObject updateLog(JSONObject jsonObject) {
		logDao.updateLog(jsonObject);
		return CommonUtil.successJson();
    }
    /**
	 * 删除log
	 */
    @Override
    public JSONObject deleteLog(JSONObject jsonObject){
        logDao.deleteLog(jsonObject);
		return CommonUtil.successJson();
    }
}