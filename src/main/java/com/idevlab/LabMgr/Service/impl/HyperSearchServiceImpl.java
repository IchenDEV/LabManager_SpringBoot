package com.idevlab.LabMgr.Service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.HyperSearchDao;
import com.idevlab.LabMgr.Service.HyperSearchService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: idevlab
 * @Description: 预定权限
 * @date: 2019/1/22 10:18
 */
@Service
public class HyperSearchServiceImpl implements HyperSearchService {
	@Autowired
	private HyperSearchDao hyperSearchDao;

	public JSONObject search(JSONObject json) {
		CommonUtil.fillPageParam(json);
		int Count = hyperSearchDao.countHyperSearch(json);
		List<JSONObject> list = hyperSearchDao.hyperSearch(json);
		return CommonUtil.successPage(json, list, Count);
	}
}