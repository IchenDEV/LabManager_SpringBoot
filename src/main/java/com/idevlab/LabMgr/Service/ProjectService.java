package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: ้กน็ฎ ๆ้
 * @date: 2019/1/27 17:48
 */
public interface ProjectService {
	JSONObject listProject(JSONObject jsonObject);
	JSONObject listProjectGroup(JSONObject jsonObject);
	JSONObject addProject(JSONObject jsonObject);
    JSONObject updateProject(JSONObject jsonObject);
	JSONObject deleteProject(JSONObject jsonObject);
}