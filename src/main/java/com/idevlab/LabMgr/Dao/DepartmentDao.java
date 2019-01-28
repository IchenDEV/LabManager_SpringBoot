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
     * 查询部门数量
     */
    int countDepartment(JSONObject jsonObject);

    /**
     * 查询部门列表
     */
    List<JSONObject> listDepartment(JSONObject jsonObject);



    int countDepartmentUser(JSONObject jsonObject);
    List<JSONObject> listDepartmentUser(JSONObject jsonObject);

    /**
     * 新增部门
     */
    int addDepartment(JSONObject jsonObject);

    /**
     * 添加用户到部门
     */
    int addUserToDepartment(JSONObject jsonObject);

    /**
     * 修改部门
     */
    int updateDepartment(JSONObject jsonObject);

    /**
     * 删除部门
     */
    int deleteDepartment(JSONObject jsonObject);

    int deleteDepartmentUser(JSONObject jsonObject);

}
