package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Department相关dao
 * @date: 2019/1/27 18:34
 */
public interface DepartmentDao {
    int countDepartment(JSONObject jsonObject);
    List<JSONObject> listDepartment(JSONObject jsonObject);
    int countDepartmentUser(JSONObject jsonObject);
    List<JSONObject> listDepartmentUser(JSONObject jsonObject);
    int addDepartment(JSONObject jsonObject);
    int addUserToDepartment(JSONObject jsonObject);
    int updateDepartment(JSONObject jsonObject);
    int deleteDepartment(JSONObject jsonObject);
    int deleteDepartmentUser(JSONObject jsonObject);
}
