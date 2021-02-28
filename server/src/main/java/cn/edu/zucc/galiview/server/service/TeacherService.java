package cn.edu.zucc.galiview.server.service;

import cn.edu.zucc.galiview.server.domain.Teacher;
import cn.edu.zucc.galiview.server.domain.TeacherExample;
import cn.edu.zucc.galiview.server.dto.TeacherDto;
import cn.edu.zucc.galiview.server.dto.PageDto;
import cn.edu.zucc.galiview.server.mapper.TeacherMapper;
import cn.edu.zucc.galiview.server.util.CopyUtil;
import cn.edu.zucc.galiview.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 列表查询
     */
    public List<TeacherDto> all() {
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        return CopyUtil.copyList(teacherList, TeacherDto.class);
    }

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teacherList);
        pageDto.setTotal(pageInfo.getTotal());
        List<TeacherDto> teacherDtoList = CopyUtil.copyList(teacherList, TeacherDto.class);
        pageDto.setList(teacherDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(TeacherDto teacherDto) {
        Teacher teacher = CopyUtil.copy(teacherDto, Teacher.class);
        if (StringUtils.isEmpty(teacherDto.getId())) {
            this.insert(teacher);
        } else {
            this.update(teacher);
        }
    }

    /**
     * 新增
     */
    private void insert(Teacher teacher) {
        teacher.setId(UuidUtil.getShortUuid());
        teacherMapper.insert(teacher);
    }

    /**
     * 更新
     */
    private void update(Teacher teacher) {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        teacherMapper.deleteByPrimaryKey(id);
    }
}
