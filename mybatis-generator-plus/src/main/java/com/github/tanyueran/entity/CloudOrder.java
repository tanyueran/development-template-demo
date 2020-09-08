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
 * 订单表
 * </p>
 *
 * @author tanxin
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tab_order")
@ApiModel(value="CloudOrder对象", description="订单表")
public class CloudOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "菜品id")
    private String foodId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "下单时间")
    private LocalDateTime createTime;


}
