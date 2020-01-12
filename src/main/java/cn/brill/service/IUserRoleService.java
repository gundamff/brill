package cn.brill.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.brill.base.entity.Role;
import cn.brill.base.entity.UserRole;

/**
 * @author zhang
 * @date 2019/12/27
 */
@CacheConfig(cacheNames = "userRole")
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 通过用户id获取
     * 
     * @param userId
     * @return
     */
    @Cacheable(key = "#userId")
    List<Role> findByUserId(@Param("userId") String userId);

    /**
     * 通过用户id获取用户角色关联的部门数据
     * 
     * @param userId
     * @return
     */
    List<String> findDepIdsByUserId(String userId);
}