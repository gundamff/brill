package cn.brill.modules.base.dao;

import java.util.List;

import cn.brill.base.BaseDao;
import cn.brill.base.entity.DepartmentHeader;

/**
 * @author zhang
 * @date 2020/01/06
 */
public interface DepartmentHeaderDao extends BaseDao<DepartmentHeader, String> {

    /**
     * 通过部门和负责人类型获取
     * 
     * @param departmentId
     * @param type
     * @return
     */
    List<DepartmentHeader> findByDepartmentIdAndType(String departmentId, Integer type);

    /**
     * 通过部门id删除
     * 
     * @param departmentId
     */
    void deleteByDepartmentId(String departmentId);

    /**
     * 通过userId删除
     * 
     * @param userId
     */
    void deleteByUserId(String userId);
}
