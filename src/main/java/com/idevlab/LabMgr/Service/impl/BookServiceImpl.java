package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.BookDao;
import com.idevlab.LabMgr.Service.BookService;
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

	@Override
	public JSONObject listBook(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = bookDao.countBook(jsonObject);
		List<JSONObject> list = bookDao.listBook(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	public JSONObject addBook(JSONObject jsonObject) {
		if (bookDao.checkTimeFree(jsonObject) == 0) {
			bookDao.addBook(jsonObject);
			return CommonUtil.successJson();
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