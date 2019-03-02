package com.idevlab.LabMgr.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Dao.BookDao;
import com.idevlab.LabMgr.Dao.DepartmentDao;
import com.idevlab.LabMgr.Dao.DeviceDao;
import com.idevlab.LabMgr.Dao.GroupDao;
import com.idevlab.LabMgr.Dao.LabDao;
import com.idevlab.LabMgr.Dao.MsgDao;
import com.idevlab.LabMgr.Dao.ProjectDao;
import com.idevlab.LabMgr.Dao.UserDao;
import com.idevlab.LabMgr.Service.AnalyseService;
import com.idevlab.LabMgr.Util.CommonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: idevlab
 * @Description: 预定权限
 * @date: 2019/1/22 10:18
 */
@Service
public class AnalyseServiceImpl implements AnalyseService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private DeviceDao deviceDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private MsgDao msgDao;
	@Autowired
	private LabDao labDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private UserDao userDao;

	public JSONObject getCount() {
		JSONObject result = new JSONObject();
		JSONObject request = new JSONObject();
		CommonUtil.fillPageParam(request);
		int bookCount = bookDao.countBook(request);
		int departmentCount = departmentDao.countDepartment(request);
		int deviceCount = deviceDao.countDevice(request);
		int groupCount = groupDao.countGroup(request);
		int msgCount = msgDao.countMsg(request);
		int labCount = labDao.countLab(request);
		int projectCount = projectDao.countProject(request);
		int userCount = userDao.countUser(request);

		result.put("books", bookCount);
		result.put("departments", departmentCount);
		result.put("devices", deviceCount);
		result.put("groups", groupCount);
		result.put("messages", msgCount);
		result.put("labs", labCount);
		result.put("projects", projectCount);
		result.put("users", userCount);
		return result;
	}

	public JSONObject getTotalUseRate() {
		JSONObject result = new JSONObject();
		JSONObject request = new JSONObject();
		CommonUtil.fillPageParam(request);
		int deviceCount = deviceDao.countDeviceTime(request);
		int totalBookedTime = bookDao.countBookedTime(request);
		if (deviceCount != 0) {
			result.put("TotalUseRate", totalBookedTime * 1.0 / deviceCount);
		}else{
			result.put("TotalUseRate", 0);
		}
		return result;
	}
}