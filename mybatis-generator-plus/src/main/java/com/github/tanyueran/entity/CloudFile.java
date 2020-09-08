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
 * 文件表
 * </p>
 *
 * @author tanxin
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tab_file")
@ApiModel(value="CloudFile对象", description="文件表")
public class CloudFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "保存的路劲")
    private String url;

    @ApiModelProperty(value = "备注")
    private String remark;


}
