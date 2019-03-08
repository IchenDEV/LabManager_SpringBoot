package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.BookDao;
import com.idevlab.LabMgr.Service.BookService;
import com.idevlab.LabMgr.Service.DeviceService;
import com.idevlab.LabMgr.Service.LoginService;
import com.idevlab.LabMgr.Util.CommonUtil;
import com.idevlab.LabMgr.Util.Constants.ErrorEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: idevlab
 * @Description: 预定权限
 * @date: 2019/1/22 10:18
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private LoginService login;
	@Autowired
	private DeviceService device;

	@Override
	public JSONObject listBook(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = bookDao.countBook(jsonObject);
		int totalBookedTime = bookDao.countBookedTime(jsonObject);
		List<JSONObject> list = bookDao.listBook(jsonObject);
		return CommonUtil.MsgSuccessPage(jsonObject, list, count, "totalBookedTime", totalBookedTime);
	}
	@Override
	public List<JSONObject> exportBook(JSONObject jsonObject) {
		List<JSONObject> list = bookDao.listBook(jsonObject);
		return list;
	}
	@Override
	public JSONObject getHotBook(JSONObject jsonObject) {
		int count = bookDao.countHotDevice(jsonObject);
		List<JSONObject> list = bookDao.getHotDevice(jsonObject);
		return CommonUtil.successPage( list, count);
	}

	@Override
	public JSONObject addBook(JSONObject jsonObject) {
		if (bookDao.checkTimeFree(jsonObject) == 0) {
			var reputation = login.getInfo().getJSONObject("userPermission").getInteger("reputation");
			JSONObject search = new JSONObject();
			search.put("id", jsonObject.getString("device"));
			var requireReputation = device.listDevice(search).getInteger("RequireReputation");
			if (requireReputation <= reputation) {
				bookDao.addBook(jsonObject);
				return CommonUtil.successJson();
			}
		}
		return CommonUtil.errorJson(ErrorEnum.E_90004);
	}

	@Override
	public JSONObject updateBook(JSONObject jsonObject) {
		bookDao.updateBook(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public JSONObject deleteBook(JSONObject jsonObject) {
		bookDao.deleteBook(jsonObject);
		return CommonUtil.successJson();
	}
}