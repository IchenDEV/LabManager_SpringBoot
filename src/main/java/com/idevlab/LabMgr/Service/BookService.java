package com.idevlab.LabMgr.Service;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: idevlab
 * @description: 预定 权限
 * @date: 2019/1/27 17:48
 */
public interface BookService {
	JSONObject listBook(JSONObject jsonObject);
	JSONObject getHotBook(JSONObject jsonObject);
	JSONObject addBook(JSONObject jsonObject);
    JSONObject updateBook(JSONObject jsonObject);
	JSONObject deleteBook(JSONObject jsonObject);
}