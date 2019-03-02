package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Device相关dao
 * @date: 2019/1/26 23:14
 */
public interface DeviceDao {
    int countDevice(JSONObject jsonObject);
    int countDeviceTime(JSONObject jsonObject);
    List<JSONObject> listDevice(JSONObject jsonObject);
    int addDevice(JSONObject jsonObject);
    int updateDevice(JSONObject jsonObject);
    int deleteDevice(JSONObject jsonObject);

}
