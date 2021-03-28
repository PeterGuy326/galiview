package cn.edu.zucc.galiview.server.mapper.my;

import cn.edu.zucc.galiview.server.dto.ResourceDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyUserMapper {

    List<ResourceDto> findResources(@Param("userId") String userId);

}
