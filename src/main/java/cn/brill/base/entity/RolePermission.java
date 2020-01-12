package cn.brill.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.brill.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhang
 * @date 2019/12/25
 */
@Data
@Entity
@Table(name = "t_role_permission")
@TableName("t_role_permission")
@ApiModel(value = "角色权限")
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 7061491478305861893L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    private String permissionId;
}
