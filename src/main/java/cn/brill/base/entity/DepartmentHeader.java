package cn.brill.base.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.brill.base.BaseEntity;
import cn.brill.common.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhang
 * @date 2020/01/06
 */
@Data
@Entity
@Table(name = "t_department_header")
@TableName("t_department_header")
@ApiModel(value = "部门负责人")
public class DepartmentHeader extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联部门id")
    private String departmentId;

    @ApiModelProperty(value = "关联部门负责人")
    private String userId;

    @ApiModelProperty(value = "负责人类型 默认0主要 1副职")
    private Integer type = CommonConstant.HEADER_TYPE_MAIN;
}
