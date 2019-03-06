package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: msg 权限
 * @date: 2019/1/26 23:18
 */
public interface AnnouncementService {
	JSONObject listAnnouncement(JSONObject jsonObject);
	JSONObject getAnnouncement(JSONObject jsonObject);
	JSONObject addAnnouncement(JSONObject jsonObject);
	JSONObject updateAnnouncement(JSONObject jsonObject);
	JSONObject deleteAnnouncement(JSONObject jsonObject);
}