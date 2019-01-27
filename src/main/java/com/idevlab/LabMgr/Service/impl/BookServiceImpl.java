package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao. BookDao;
import com.idevlab.LabMgr.Service. BookService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: idevlab
 * @Description: 预定/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class BookServiceImpl implements  BookService {

	@Autowired
	private  BookDao  bookDao;

	/**
	 * 预定列表
	 */
	@Override
	public JSONObject listBook(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =   bookDao.countBook(jsonObject);
		List<JSONObject> list =   bookDao.listBook(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加预定
	 */
	@Override
	public JSONObject addBook(JSONObject jsonObject) {	
		bookDao.addBook(jsonObject);
		return CommonUtil.successJson();
	}

	
	/**
	 * 修改预定
	 */
	@Override
	public JSONObject updateBook(JSONObject jsonObject) {
		bookDao.updateBook(jsonObject);
		return CommonUtil.successJson();
    }
    
    @Override
    public JSONObject deleteBook(JSONObject jsonObject){
		bookDao.deleteBook(jsonObject);
		return CommonUtil.successJson();
    }
}