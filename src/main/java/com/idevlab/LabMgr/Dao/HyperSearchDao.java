package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @date: 2019/1/26 23:14
 */
public interface HyperSearchDao {
    int countHyperSearch(JSONObject jsonObject);
    List<JSONObject> hyperSearch(JSONObject jsonObject);
}