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
@Table(name = "t_role_department")
@TableName("t_role_department")
@ApiModel(value = "角色部门")
public class RoleDepartment extends BaseEntity {

    private static final long serialVersionUID = 8225468217415146939L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "部门id")
    private String departmentId;

}
