package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.ProjectDao;
import com.idevlab.LabMgr.Service.ProjectService;
import com.idevlab.LabMgr.Util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: idevlab
 * @Description: 项目/角色/权限
 * @date: 2019/1/22 10:18
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private  ProjectDao  projectDao;

	/**
	 * 项目列表
	 */
	@Override
	public JSONObject listProject(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =   projectDao.countProject(jsonObject);
		List<JSONObject> list =   projectDao.listProject(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}
/**
	 * 项目的组列表
	 */
	@Override
	public JSONObject listProjectGroup(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count =   projectDao.countProjectGroup(jsonObject);
		List<JSONObject> list =   projectDao.listProjectGroup(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}
	
	/**
	 * 添加项目
	 */
	@Override
	public JSONObject addProject(JSONObject jsonObject) {	
		projectDao.addProject(jsonObject);
		return CommonUtil.successJson();
	}

	
	/**
	 * 修改项目
	 */
	@Override
	public JSONObject updateProject(JSONObject jsonObject) {
		projectDao.updateProject(jsonObject);
		return CommonUtil.successJson();
    }
    /**
	 * 删除项目
	 */
    @Override
    public JSONObject deleteProject(JSONObject jsonObject){
		projectDao.deleteProject(jsonObject);
		return CommonUtil.successJson();
    }
}