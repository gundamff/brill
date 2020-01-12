package cn.brill.modules.base.dao;

import java.util.List;

import cn.brill.base.BaseDao;
import cn.brill.base.entity.RoleDepartment;

/**
 * @author zhang
 * @date 2020/01/06
 */
public interface RoleDepartmentDao extends BaseDao<RoleDepartment, String> {

    /**
     * 通过roleId获取
     * 
     * @param roleId
     * @return
     */
    List<RoleDepartment> findByRoleId(String roleId);

    /**
     * 通过角色id删除
     * 
     * @param roleId
     */
    void deleteByRoleId(String roleId);

    /**
     * 通过角色id删除
     * 
     * @param departmentId
     */
    void deleteByDepartmentId(String departmentId);
}