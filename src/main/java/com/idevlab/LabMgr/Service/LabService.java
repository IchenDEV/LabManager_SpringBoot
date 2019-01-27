package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 实验室 权限
 * @date: 2019/1/26 23:18
 */
public interface LabService {
	/**
	 * 实验室列表
	 */
	JSONObject listLab(JSONObject jsonObject);

	/**
	 * 添加实验室
	 */
	JSONObject addLab(JSONObject jsonObject);

	/**
	 * 修改实验室
	 */
    JSONObject updateLab(JSONObject jsonObject);
    
    	/**
	 * 删除实验室
	 */
	JSONObject deleteLab(JSONObject jsonObject);
}