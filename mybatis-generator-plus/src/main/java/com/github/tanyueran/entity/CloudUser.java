package com.github.tanyueran.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author tanxin
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tab_user")
@ApiModel(value="CloudUser对象", description="账户表")
public class CloudUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "账号")
    @TableField("user_code")
    private String userCode;

    @ApiModelProperty(value = "用户姓名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("user_pwd")
    private String userPwd;

    @ApiModelProperty(value = "头像id")
    @TableField("file_id")
    private String fileId;

    @ApiModelProperty(value = "用户类型(0：普通用户，1|：管理员用户)")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
