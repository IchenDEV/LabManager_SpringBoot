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
    /**
     * 查询用户数量
     */
    int countUser(JSONObject jsonObject);

    int countSuper(JSONObject jsonObject);
    
    /**
     * 查询用户的组的数量
     */
    int countUserGroup(JSONObject jsonObject);

    /**
     * 查询用户的部门的数量
     */
    int countUserDepartment(JSONObject jsonObject);

    /**
     * 查询用户列表
     */
    List<JSONObject> listUser(JSONObject jsonObject);

    /**
     * 查询用户项目组列表
     */
    List<JSONObject> listUserGroup(JSONObject jsonObject);

    /**
     * 查询用户部门列表
     */
    List<JSONObject> listUserDepartment(JSONObject jsonObject);

    /**
     * 查询所有的角色 在添加/修改用户的时候要使用此方法
     */
    List<JSONObject> getAllRoles();

    /**
     * 校验用户名是否已存在
     */
    int queryExistUsername(JSONObject jsonObject);

    /**
     * 新增用户
     */
    int addUser(JSONObject jsonObject);

    /**
     * 修改用户
     */
    int updateUser(JSONObject jsonObject);

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