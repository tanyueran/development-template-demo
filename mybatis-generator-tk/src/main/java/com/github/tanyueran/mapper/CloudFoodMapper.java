package com.github.tanyueran.mapper;

import com.github.tanyueran.modal.CloudFood;
import com.github.tanyueran.modal.CloudFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CloudFoodMapper extends Mapper<CloudFood> {
    long countByExample(CloudFoodExample example);

    int deleteByExample(CloudFoodExample example);

    List<CloudFood> selectByExample(CloudFoodExample example);

    int updateByExampleSelective(@Param("record") CloudFood record, @Param("example") CloudFoodExample example);

    int updateByExample(@Param("record") CloudFood record, @Param("example") CloudFoodExample example);
}