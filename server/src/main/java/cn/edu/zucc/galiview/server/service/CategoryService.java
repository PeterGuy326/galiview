package cn.edu.zucc.galiview.server.service;

import cn.edu.zucc.galiview.server.domain.Category;
import cn.edu.zucc.galiview.server.domain.CategoryExample;
import cn.edu.zucc.galiview.server.dto.CategoryDto;
import cn.edu.zucc.galiview.server.mapper.CategoryMapper;
import cn.edu.zucc.galiview.server.util.CopyUtil;
import cn.edu.zucc.galiview.server.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 列表查询
     */
    public List<CategoryDto> all() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        List<CategoryDto> categoryDtoList = CopyUtil.copyList(categoryList, CategoryDto.class);
        return categoryDtoList;
    }

    /**
    * 保存，id有值时更新，无值时新增
    */
    public void save(CategoryDto categoryDto) {
        Category category = CopyUtil.copy(categoryDto, Category.class);
        if (StringUtils.isEmpty(categoryDto.getId())) {
        this.insert(category);
    } else {
        this.update(category);
        }
    }

    /**
    * 新增
    */
    private void insert(Category category) {
        category.setId(UuidUtil.getShortUuid());
        categoryMapper.insert(category);
    }

    /**
    * 更新
    */
    private void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    /**
    * 删除
    */
    @Transactional
    public void delete(String id) {

        categoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除子分类
     * @Param id
     */
    public void deleteChildren(String id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if ("00000000".equals(category.getParent())) {
            // 如果是一级分类，需要删除其下的二级分类
            CategoryExample example = new CategoryExample();
            example.createCriteria().andParentEqualTo(category.getId());
            categoryMapper.deleteByExample(example);
        }
    }
}