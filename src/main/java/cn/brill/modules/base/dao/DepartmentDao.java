package cn.brill.modules.base.dao;

import java.util.List;

import cn.brill.base.BaseDao;
import cn.brill.base.entity.Department;

/**
 * @author zhang
 * @date 2019/12/27
 */
public interface DepartmentDao extends BaseDao<Department, String> {

    /**
     * 通过父id获取 升序
     * 
     * @param parentId
     * @return
     */
    List<Department> findByParentIdOrderBySortOrder(String parentId);

    /**
     * 通过父id获取 升序 数据权限
     * 
     * @param parentId
     * @param departmentIds
     * @return
     */
    List<Department> findByParentIdAndIdInOrderBySortOrder(String parentId, List<String> departmentIds);

    /**
     * 通过父id和状态获取 升序
     * 
     * @param parentId
     * @param status
     * @return
     */
    List<Department> findByParentIdAndStatusOrderBySortOrder(String parentId, Integer status);

    /**
     * 部门名模糊搜索 升序
     * 
     * @param title
     * @return
     */
    List<Department> findByTitleLikeOrderBySortOrder(String title);

    /**
     * 部门名模糊搜索 升序 数据权限
     * 
     * @param title
     * @param departmentIds
     * @return
     */
    List<Department> findByTitleLikeAndIdInOrderBySortOrder(String title, List<String> departmentIds);

}
