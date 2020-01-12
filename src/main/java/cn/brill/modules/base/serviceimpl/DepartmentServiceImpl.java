package cn.brill.modules.base.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.brill.base.BaseDao;
import cn.brill.base.entity.Department;
import cn.brill.common.utils.SecurityUtil;
import cn.brill.modules.base.dao.DepartmentDao;
import cn.brill.service.DepartmentService;

/**
 * @author zhang
 * @date 2019/12/27
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private SecurityUtil securityUtil;

    @Override
    public BaseDao<Department, String> getRepository() {
        return departmentDao;
    }

    @Override
    public List<Department> findByParentIdOrderBySortOrder(String parentId, Boolean openDataFilter) {
        // 数据权限
        List<String> depIds = securityUtil.getDeparmentIds();
        if (depIds != null && depIds.size() > 0 && openDataFilter) {
            return departmentDao.findByParentIdAndIdInOrderBySortOrder(parentId, depIds);
        }
        return departmentDao.findByParentIdOrderBySortOrder(parentId);
    }

    @Override
    public List<Department> findByParentIdAndStatusOrderBySortOrder(String parentId, Integer status) {
        return departmentDao.findByParentIdAndStatusOrderBySortOrder(parentId, status);
    }

    @Override
    public List<Department> findByTitleLikeOrderBySortOrder(String title, Boolean openDataFilter) {
        // 数据权限
        List<String> depIds = securityUtil.getDeparmentIds();
        if (depIds != null && depIds.size() > 0 && openDataFilter) {
            return departmentDao.findByTitleLikeAndIdInOrderBySortOrder(title, depIds);
        }
        return departmentDao.findByTitleLikeOrderBySortOrder(title);
    }

}
