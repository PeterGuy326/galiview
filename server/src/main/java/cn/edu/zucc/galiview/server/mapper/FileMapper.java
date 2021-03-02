package cn.edu.zucc.galiview.server.mapper;

import cn.edu.zucc.galiview.server.domain.File;
import cn.edu.zucc.galiview.server.domain.FileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {
    long countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(String id);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}