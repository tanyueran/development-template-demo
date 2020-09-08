package com.github.tanyueran.mapper;

import com.github.tanyueran.modal.CloudUser;
import com.github.tanyueran.modal.CloudUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CloudUserMapper extends Mapper<CloudUser> {
    long countByExample(CloudUserExample example);

    int deleteByExample(CloudUserExample example);

    List<CloudUser> selectByExample(CloudUserExample example);

    int updateByExampleSelective(@Param("record") CloudUser record, @Param("example") CloudUserExample example);

    int updateByExample(@Param("record") CloudUser record, @Param("example") CloudUserExample example);
}