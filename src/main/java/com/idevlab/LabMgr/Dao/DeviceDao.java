package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Device相关dao
 * @date: 2019/1/26 23:14
 */
public interface DeviceDao {
    /**
     * 查询设备数量
     */
    int countDevice(JSONObject jsonObject);

    /**
     * 查询设备列表
     */
    List<JSONObject> listDevice(JSONObject jsonObject);


    /**
     * 新增设备
     */
    int addDevice(JSONObject jsonObject);

    /**
     * 修改设备
     */
    int updateDevice(JSONObject jsonObject);

    /**
     * 删除设备
     */
    int deleteDevice(JSONObject jsonObject);

}
