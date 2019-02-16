package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: 预定相关dao
 * @date: 2019/1/26 23:14
 */
public interface BookDao {
    /**
     * 查询预定数量
     */
    int countBook(JSONObject jsonObject);
    int checkTimeFree(JSONObject jsonObject);

    /**
     * 查询预定列表
     */
    List<JSONObject> listBook(JSONObject jsonObject);

    /**
     * 新增预定
     */
    int addBook(JSONObject jsonObject);

    /**
     * 修改预定
     */
    int updateBook(JSONObject jsonObject);

    /**
     * 删除预定
     */
    int deleteBook(JSONObject jsonObject);

}
