package cn.brill.modules.base.dao;

import java.util.List;

import cn.brill.base.BaseDao;
import cn.brill.base.entity.User;

/**
 * @author zhang
 * @date 2019/12/26
 */
public interface UserDao extends BaseDao<User, String> {

    /**
     * 通过用户名获取用户
     * 
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过手机获取用户
     * 
     * @param mobile
     * @return
     */
    User findByMobile(String mobile);

    /**
     * 通过邮件获取用户
     * 
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 通过部门id获取
     * 
     * @param departmentId
     * @return
     */
    List<User> findByDepartmentId(String departmentId);

}
