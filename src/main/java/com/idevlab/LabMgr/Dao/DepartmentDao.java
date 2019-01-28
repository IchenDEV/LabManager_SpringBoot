package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * @author: idevlab
 * @description: Department相关dao
 * @date: 2019/1/27 18:34
 */
public interface DepartmentDao {
    /**
     * 查询设备数量
     */
    int countDepartment(JSONObject jsonObject);

    /**
     * 查询设备列表
     */
    List<JSONObject> listDepartment(JSONObject jsonObject);


    List<JSONObject> listDepartmentUser(JSONObject jsonObject);

    /**
     * 新增设备
     */
    int addDepartment(JSONObject jsonObject);

    

    /**
     * 修改设备
     */
    int updateDepartment(JSONObject jsonObject);

    /**
     * 删除设备
     */
    int deleteDepartment(JSONObject jsonObject);

}
