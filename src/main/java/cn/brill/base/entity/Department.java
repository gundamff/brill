package cn.brill.base.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.brill.base.BaseEntity;
import cn.brill.common.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhang
 * @date 2019/12/27
 */
@Data
@Entity
@Table(name = "t_department")
@TableName("t_department")
@ApiModel(value = "部门")
public class Department extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    private String title;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "是否为父节点(含子节点) 默认false")
    private Boolean isParent = false;

    @ApiModelProperty(value = "排序值")
    @Column(precision = 10, scale = 2)
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "父节点名称")
    private String parentTitle;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "主负责人")
    private List<String> mainHeader;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "副负责人")
    private List<String> viceHeader;
}
