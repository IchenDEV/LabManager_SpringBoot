package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao. DeviceDao;
import com.idevlab.LabMgr.Service. DeviceService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: idevlab
 * @Description: 用户/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class DeviceServiceImpl implements  DeviceService {

	@Autowired
	private  DeviceDao  deviceDao;

	/**
	 * 用户列表
	 */
	@Override
	public JSONObject listDevice(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =  deviceDao.countDevice(jsonObject);
		List<JSONObject> list =  deviceDao.listDevice(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加用户
	 */
	@Override
	public JSONObject addDevice(JSONObject jsonObject) {	
        deviceDao.addDevice(jsonObject);
		return CommonUtil.successJson();
	}

	
	/**
	 * 修改用户
	 */
	@Override
	public JSONObject updateDevice(JSONObject jsonObject) {
		deviceDao.updateDevice(jsonObject);
		return CommonUtil.successJson();
    }
    
    @Override
    public JSONObject deleteDevice(JSONObject jsonObject){
        deviceDao.deleteDevice(jsonObject);
		return CommonUtil.successJson();
    }
}