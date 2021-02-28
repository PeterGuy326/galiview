package cn.edu.zucc.galiview.server.mapper.my;

import cn.edu.zucc.galiview.server.dto.SortDto;
import org.apache.ibatis.annotations.Param;

public interface MyCourseMapper {

    int updateTime(@Param("courseId") String courseId);

    int updateSort(SortDto sortDto);

    int moveSortsBackward(SortDto sortDto);

    int moveSortsForward(SortDto sortDto);
}
