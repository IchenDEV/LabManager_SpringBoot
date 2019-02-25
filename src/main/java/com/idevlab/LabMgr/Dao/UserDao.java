package com.idevlab.LabMgr.Dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author: idevlab
 * @description: 用户相关dao
 * @date: 2019/1/22 11:02
 */
public interface UserDao {
    int countUser(JSONObject jsonObject);
    int countSuper(JSONObject jsonObject);
    int countUserGroup(JSONObject jsonObject);
    int countUserDepartment(JSONObject jsonObject);
    int countUserProject(JSONObject jsonObject);
    List<JSONObject> listUser(JSONObject jsonObject);
    List<JSONObject> listUserGroup(JSONObject jsonObject);
    List<JSONObject> listUserDepartment(JSONObject jsonObject);
    List<JSONObject> listUserProject(JSONObject jsonObject);
    int queryExistUsername(JSONObject jsonObject);
    int addUser(JSONObject jsonObject);
    int updateUser(JSONObject jsonObject);
    int delUser(JSONObject jsonObject);

     /**
     * 查询所有的角色 在添加/修改用户的时候要使用此方法
     */
    List<JSONObject> getAllRoles();
    /**
     * 角色列表
     */
    List<JSONObject> listRole();
    /**
     * 查询所有权限, 给角色分配权限时调用
     */
    List<JSONObject> listAllPermission();
    /**
     * 新增角色
     */
    int insertRole(JSONObject jsonObject);
    /**
     * 批量插入角色的权限
     * 
     * @param roleId      角色ID
     * @param permissions 权限
     */
    int insertRolePermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);
    /**
     * 将角色曾经拥有而修改为不再拥有的权限 delete_status改为'2'
     */
    int removeOldPermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);
    /**
     * 修改角色名称
     */
    int updateRoleName(JSONObject jsonObject);
    /**
     * 查询某角色的全部数据 在删除和修改角色时调用
     */
    JSONObject getRoleAllInfo(JSONObject jsonObject);
    /**
     * 删除角色
     */
    int removeRole(JSONObject jsonObject);
    /**
     * 删除本角色全部权限
     */
    int removeRoleAllPermission(JSONObject jsonObject);
}