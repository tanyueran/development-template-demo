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
 * 菜品表
 * </p>
 *
 * @author tanxin
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tab_food")
@ApiModel(value="CloudFood对象", description="菜品表")
public class CloudFood implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜品名称")
    private String foodName;

    @ApiModelProperty(value = "菜品类型")
    private Integer foodType;

    @ApiModelProperty(value = "菜品介绍")
    private String foodDetail;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "菜品头像id")
    private String imgId;

    @ApiModelProperty(value = "备注")
    private String remark;


}
