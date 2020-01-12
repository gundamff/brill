package cn.brill.common.base.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.brill.service.DepartmentHeaderService;
import cn.brill.service.DepartmentService;
import cn.brill.service.RoleDepartmentService;
import cn.brill.service.UserService;
import io.swagger.annotations.Api;

/**
 * @author zhang
 * @date 2020/01/02
 */
@RestController
@Api(description = "部门管理接口")
@RequestMapping("/brill/department")
@CacheConfig(cacheNames = "department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDepartmentService roleDepartmentService;

    @Autowired
    private DepartmentHeaderService departmentHeaderService;

}
