package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Lab相关dao
 * @date: 2019/1/26 23:14
 */
public interface LabDao {
    int countLab(JSONObject jsonObject);
    List<JSONObject> listLab(JSONObject jsonObject);
    int addLab(JSONObject jsonObject);
    int updateLab(JSONObject jsonObject);
    int deleteLab(JSONObject jsonObject);

}
