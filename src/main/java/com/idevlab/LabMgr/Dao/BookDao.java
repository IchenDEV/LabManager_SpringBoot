package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: 预定相关dao
 * @date: 2019/1/26 23:14
 */
public interface BookDao {
    int countBook(JSONObject jsonObject);
    int countHotDevice(JSONObject jsonObject);
    int countBookedTime(JSONObject jsonObject);
    List<JSONObject> getHotDevice(JSONObject jsonObject);
    int checkTimeFree(JSONObject jsonObject);
    List<JSONObject> listBook(JSONObject jsonObject);
    int addBook(JSONObject jsonObject);
    int updateBook(JSONObject jsonObject);
    int deleteBook(JSONObject jsonObject);

}
