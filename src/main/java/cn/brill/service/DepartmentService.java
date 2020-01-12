package cn.brill.service;

import java.util.List;

import cn.brill.base.BaseService;
import cn.brill.base.entity.Department;

/**
 * @author zhang
 * @date 2019/12/27
 */
public interface DepartmentService extends BaseService<Department, String> {

    /**
     * 通过父id获取 升序
     * 
     * @param parentId
     * @param openDataFilter
     *            是否开启数据权限
     * @return
     */
    List<Department> findByParentIdOrderBySortOrder(String parentId, Boolean openDataFilter);

    /**
     * 通过父id和状态获取
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
     * @param openDataFilter
     *            是否开启数据权限
     * @return
     */
    List<Department> findByTitleLikeOrderBySortOrder(String title, Boolean openDataFilter);

}
