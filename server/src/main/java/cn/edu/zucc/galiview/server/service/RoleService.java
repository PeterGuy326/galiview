package cn.edu.zucc.galiview.server.service;

import cn.edu.zucc.galiview.server.domain.Role;
import cn.edu.zucc.galiview.server.domain.RoleExample;
import cn.edu.zucc.galiview.server.domain.RoleResource;
import cn.edu.zucc.galiview.server.domain.RoleResourceExample;
import cn.edu.zucc.galiview.server.dto.PageDto;
import cn.edu.zucc.galiview.server.dto.RoleDto;
import cn.edu.zucc.galiview.server.mapper.RoleMapper;
import cn.edu.zucc.galiview.server.mapper.RoleResourceMapper;
import cn.edu.zucc.galiview.server.util.CopyUtil;
import cn.edu.zucc.galiview.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleResourceMapper roleResourceMapper;

    /**
    * 列表查询
    */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        RoleExample roleExample = new RoleExample();
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        pageDto.setTotal(pageInfo.getTotal());
        List<RoleDto> roleDtoList = CopyUtil.copyList(roleList, RoleDto.class);
        pageDto.setList(roleDtoList);
    }

    /**
    * 保存，id有值时更新，无值时新增
    */
    public void save(RoleDto roleDto) {
        Role role = CopyUtil.copy(roleDto, Role.class);
        if (StringUtils.isEmpty(roleDto.getId())) {
        this.insert(role);
    } else {
        this.update(role);
        }
    }

    /**
    * 新增
    */
    private void insert(Role role) {
        role.setId(UuidUtil.getShortUuid());
        roleMapper.insert(role);
    }

    /**
    * 更新
    */
    private void update(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    /**
    * 删除
    */
    public void delete(String id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 按角色保存资源
     */
    public void saveResource(RoleDto roleDto) {
        String roleId = roleDto.getId();
        List<String> resourceIds = roleDto.getResourceIds();
        // 清空库中所有的当前角色下的记录
        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceMapper.deleteByExample(example);

        // 保存角色资源
        for (int i = 0; i < resourceIds.size(); i++) {
            RoleResource roleResource = new RoleResource();
            roleResource.setId(UuidUtil.getShortUuid());
            roleResource.setRoleId(roleId);
            roleResource.setResourceId(resourceIds.get(i));
            roleResourceMapper.insert(roleResource);
        }
    }
}