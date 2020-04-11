package org.changgou.goods.dao;

import org.apache.ibatis.annotations.Select;
import org.changgou.goods.pojo.Category;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:ky2009888
 * @Description:Category的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface CategoryMapper extends Mapper<Category> {
    /**
     * 根据parentId查询所有的子分类
     *
     * @param parentId 父分类ID
     * @return List<Category>
     */
    @Select(" select * from tb_category t where t.parent_id = #{parentId} ")
    List<Category> findByParentId(Integer parentId);
}
