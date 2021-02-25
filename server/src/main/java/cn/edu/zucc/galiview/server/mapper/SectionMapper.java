package cn.edu.zucc.galiview.server.mapper;

import cn.edu.zucc.galiview.server.domain.Section;
import cn.edu.zucc.galiview.server.domain.SectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SectionMapper {
    long countByExample(SectionExample example);

    int deleteByExample(SectionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Section record);

    int insertSelective(Section record);

    List<Section> selectByExample(SectionExample example);

    Section selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Section record, @Param("example") SectionExample example);

    int updateByExample(@Param("record") Section record, @Param("example") SectionExample example);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);
}