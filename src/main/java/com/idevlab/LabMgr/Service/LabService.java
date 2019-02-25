package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 实验室 权限
 * @date: 2019/1/26 23:18
 */
public interface LabService {
	JSONObject listLab(JSONObject jsonObject);
	JSONObject addLab(JSONObject jsonObject);
    JSONObject updateLab(JSONObject jsonObject);
	JSONObject deleteLab(JSONObject jsonObject);
}