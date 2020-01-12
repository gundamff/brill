package cn.brill.modules.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.brill.base.entity.Role;
import cn.brill.base.entity.UserRole;

/**
 * @author zhang
 * @date 2019/12/27
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 通过用户id获取
     * 
     * @param userId
     * @return
     */
    @Select("SELECT r.id id, name, r.data_type FROM t_user_role ur LEFT JOIN t_role"
        + " ON ur.role_id = r.id WHERE user_Id = #{userId}")
    List<Role> findByUserId(@Param("userId") String userId);

    /**
     * 通过用户id获取用户角色关联的部门数据
     * 
     * @param userId
     * @return
     */
    @Select("SELECT DISTINCT rd.department_id FROM t_role_department rd WHERE role_id IN"
        + " ( SELECT ur.role_id FROM t_user_role ur WHERE ur.user_id = #{userId} )")
    List<String> findDepIdsByUserId(@Param("userId") String userId);

}
