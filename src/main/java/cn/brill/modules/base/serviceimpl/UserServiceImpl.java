package cn.brill.modules.base.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.brill.base.entity.Department;
import cn.brill.base.entity.Permission;
import cn.brill.base.entity.Role;
import cn.brill.base.entity.User;
import cn.brill.common.utils.SecurityUtil;
import cn.brill.common.vo.SearchVo;
import cn.brill.modules.base.dao.DepartmentDao;
import cn.brill.modules.base.dao.PermissionMapper;
import cn.brill.modules.base.dao.UserDao;
import cn.brill.modules.base.dao.UserRoleMapper;
import cn.brill.service.UserService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author zhang
 * @date 2019/12/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private SecurityUtil securityUtil;

    @Override
    public UserDao getRepository() {
        return userDao;
    }

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return null;
        }
        // 关联部门
        if (StrUtil.isNotBlank(user.getDepartmentId())) {
            Department department = departmentDao.findById(user.getDepartmentId()).orElse(null);
            if (department != null) {
                user.setDepartmentTitle(department.getTitle());
            }
        }
        // 关联角色
        List<Role> roleList = userRoleMapper.findByUserId(user.getId());
        user.setRoles(roleList);
        // 关联权限菜单
        List<Permission> permissionList = permissionMapper.findByUserId(user.getId());
        user.setPermissions(permissionList);
        return user;
    }

    @Override
    public User findByMobile(String mobile) {
        return userDao.findByMobile(mobile);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Page<User> findByCondition(User user, SearchVo searchVo, Pageable pageable) {
        userDao.findAll(new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<String> usernameField = root.get("username");
                Path<String> mobileField = root.get("mobile");
                Path<String> emailField = root.get("email");
                Path<String> departmentIdField = root.get("departmentId");
                Path<String> sexField = root.get("sex");
                Path<Integer> typeField = root.get("type");
                Path<Integer> statusField = root.get("status");
                Path<Date> createTimeField = root.get("createTime");

                List<Predicate> list = new ArrayList<Predicate>();

                // 模糊搜素
                if (StrUtil.isNotBlank(user.getUsername())) {
                    list.add(criteriaBuilder.like(usernameField, '%' + user.getUsername() + '%'));
                }
                if (StrUtil.isNotBlank(user.getMobile())) {
                    list.add(criteriaBuilder.like(mobileField, '%' + user.getMobile() + '%'));
                }
                if (StrUtil.isNotBlank(user.getEmail())) {
                    list.add(criteriaBuilder.like(emailField, '%' + user.getEmail() + '%'));
                }

                // 部门
                if (StrUtil.isNotBlank(user.getDepartmentId())) {
                    list.add(criteriaBuilder.equal(departmentIdField, user.getDepartmentId()));
                }

                // 性别
                if (StrUtil.isNotBlank(user.getSex())) {
                    list.add(criteriaBuilder.equal(sexField, user.getSex()));
                }
                // 类型
                if (user.getType() != null) {
                    list.add(criteriaBuilder.equal(typeField, user.getType()));
                }
                // 状态
                if (user.getStatus() != null) {
                    list.add(criteriaBuilder.equal(statusField, user.getStatus()));
                }
                // 创建时间
                if (StrUtil.isNotBlank(searchVo.getStartDate()) && StrUtil.isNotBlank(searchVo.getEndDate())) {
                    Date start = DateUtil.parse(searchVo.getStartDate());
                    Date end = DateUtil.parse(searchVo.getEndDate());
                    list.add(criteriaBuilder.between(createTimeField, start, DateUtil.endOfDay(end)));
                }

                // 数据权限
                List<String> depIds = securityUtil.getDeparmentIds();
                if (depIds != null && depIds.size() > 0) {
                    list.add(departmentIdField.in(depIds));
                }

                Predicate[] arr = new Predicate[list.size()];
                query.where(list.toArray(arr));
                return query.getRestriction();
            }
        }, pageable);
        return null;
    }

    @Override
    public List<User> findByDepartmentId(String departmentId) {
        return userDao.findByDepartmentId(departmentId);
    }

}
