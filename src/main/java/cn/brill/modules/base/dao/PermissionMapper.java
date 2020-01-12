package cn.brill.modules.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.brill.base.entity.Permission;

/**
 * @author zhang
 * @date 2019/12/27
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 通过用户id获取
     * 
     * @param userId
     * @return
     */
    @Select("SELECT DISTINCT p.id, p.name, p.show_always, p.title, p.path, p.icon, p.type, p.component, p.level,"
        + "p.button_type, p.parent_id, p.sort_order, p.description, p.status, p.url"
        + " FROM t_user u  LEFT JOIN t_user_role ur ON u.id = ur.user_id"
        + " LEFT JOIN t_role_permission rp ON ur.role_id = rp.role_id"
        + " LEFT JOIN t_permission p ON p.id = rp.permission_id   WHERE u.id = #{userId} AND p.status = 0"
        + " ORDER BY p.sort_order ASC")
    List<Permission> findByUserId(@Param("userId") String userId);

}
