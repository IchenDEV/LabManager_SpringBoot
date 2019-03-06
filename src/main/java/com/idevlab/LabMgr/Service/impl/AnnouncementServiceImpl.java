package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.AnnouncementDao;
import com.idevlab.LabMgr.Service.AnnouncementService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: idevlab
 * @Description: msg/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementDao msgDao;

	@Override
	public JSONObject listAnnouncement(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = msgDao.countAnnouncement(jsonObject);
		List<JSONObject> list = msgDao.listAnnouncement(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}
	@Override
	public JSONObject getAnnouncement(JSONObject jsonObject) {
		JSONObject result = msgDao.getAnnouncement(jsonObject);
		return CommonUtil.successJson(result);
	}

	@Override
	public JSONObject addAnnouncement(JSONObject jsonObject) {
		msgDao.addAnnouncement(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject updateAnnouncement(JSONObject jsonObject) {
		msgDao.updateAnnouncement(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteAnnouncement(JSONObject jsonObject) {
		msgDao.deleteAnnouncement(jsonObject);
		return CommonUtil.successJson();
	}
}