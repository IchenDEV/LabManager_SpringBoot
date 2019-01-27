package com.idevlab.LabMgr.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 预定 权限
 * @date: 2019/1/27 17:48
 */
public interface BookService {
	/**
	 * 预定列表
	 */
	JSONObject listBook(JSONObject jsonObject);

	/**
	 * 添加预定
	 */
	JSONObject addBook(JSONObject jsonObject);

	/**
	 * 修改预定
	 */
    JSONObject updateBook(JSONObject jsonObject);
    
    	/**
	 * 删除预定
	 */
	JSONObject deleteBook(JSONObject jsonObject);
}