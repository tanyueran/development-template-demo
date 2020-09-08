package com.github.tanyueran.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tab_user")
@ApiModel(value="CloudUser对象", description="账户表")
public class CloudUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号")
    private String userCodde;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String userPwd;

    @ApiModelProperty(value = "头像id")
    private String fileId;

    @ApiModelProperty(value = "用户类型(0：普通用户，1|：管理员用户)")
    private Integer type;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
