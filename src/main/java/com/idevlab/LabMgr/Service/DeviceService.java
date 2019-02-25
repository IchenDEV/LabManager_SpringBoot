package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 设备 权限
 * @date: 2019/1/26 23:18
 */
public interface DeviceService {
	JSONObject listDevice(JSONObject jsonObject);
	JSONObject addDevice(JSONObject jsonObject);
    JSONObject updateDevice(JSONObject jsonObject);
	JSONObject deleteDevice(JSONObject jsonObject);
}