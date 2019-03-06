package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @date: 2019/1/26 23:14
 */
public interface AnnouncementDao {
    int countAnnouncement(JSONObject jsonObject);
    List<JSONObject> listAnnouncement(JSONObject jsonObject);
    JSONObject getAnnouncement(JSONObject jsonObject);
    int addAnnouncement(JSONObject jsonObject);
    int updateAnnouncement(JSONObject jsonObject);
    int deleteAnnouncement(JSONObject jsonObject);
}
