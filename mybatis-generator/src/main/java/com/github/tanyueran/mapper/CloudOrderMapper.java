package com.github.tanyueran.mapper;

import com.github.tanyueran.modal.CloudOrder;
import com.github.tanyueran.modal.CloudOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CloudOrderMapper extends Mapper<CloudOrder> {
    long countByExample(CloudOrderExample example);

    int deleteByExample(CloudOrderExample example);

    List<CloudOrder> selectByExample(CloudOrderExample example);

    int updateByExampleSelective(@Param("record") CloudOrder record, @Param("example") CloudOrderExample example);

    int updateByExample(@Param("record") CloudOrder record, @Param("example") CloudOrderExample example);
}