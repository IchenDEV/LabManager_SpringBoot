package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.MsgDao;
import com.idevlab.LabMgr.Service.MsgService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: idevlab
 * @Description: msg/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class MsgServiceImpl implements  MsgService {

	@Autowired
	private  MsgDao  msgDao;

	/**
	 * msg列表
	 */
	@Override
	public JSONObject listMsg(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =  msgDao.countMsg(jsonObject);
		List<JSONObject> list =  msgDao.listMsg(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}
	/**
	 * 添加msg
	 */
	@Override
	public JSONObject addMsg(JSONObject jsonObject) {	
        msgDao.addMsg(jsonObject);
		return CommonUtil.successJson();
	}
	@Override
	public JSONObject readMsg(JSONObject jsonObject) {	
        msgDao.readMsg(jsonObject);
		return CommonUtil.successJson();
	}
    /**
	 * 删除msg
	 */
    @Override
    public JSONObject deleteMsg(JSONObject jsonObject){
        msgDao.deleteMsg(jsonObject);
		return CommonUtil.successJson();
    }
}