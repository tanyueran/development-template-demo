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
 * 文件表
 * </p>
 *
 * @author tanxin
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tab_file")
@ApiModel(value="CloudFile对象", description="文件表")
public class CloudFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "文件名称")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "保存的路劲")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;


}
