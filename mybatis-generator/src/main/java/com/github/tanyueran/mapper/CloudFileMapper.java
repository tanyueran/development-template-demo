package com.github.tanyueran.mapper;

import com.github.tanyueran.modal.CloudFile;
import com.github.tanyueran.modal.CloudFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface CloudFileMapper extends Mapper<CloudFile> {
    long countByExample(CloudFileExample example);

    int deleteByExample(CloudFileExample example);

    List<CloudFile> selectByExample(CloudFileExample example);

    int updateByExampleSelective(@Param("record") CloudFile record, @Param("example") CloudFileExample example);

    int updateByExample(@Param("record") CloudFile record, @Param("example") CloudFileExample example);
}