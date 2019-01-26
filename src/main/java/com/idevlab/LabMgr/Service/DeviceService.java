package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: hxy
 * @description: 设备 权限
 * @date: 2019/1/26 23:18
 */
public interface DeviceService {
	/**
	 * 设备列表
	 */
	JSONObject listDevice(JSONObject jsonObject);

	/**
	 * 添加设备
	 */
	JSONObject addDevice(JSONObject jsonObject);

	/**
	 * 修改设备
	 */
    JSONObject updateDevice(JSONObject jsonObject);
    
    	/**
	 * 删除设备
	 */
	JSONObject deleteDevice(JSONObject jsonObject);
}