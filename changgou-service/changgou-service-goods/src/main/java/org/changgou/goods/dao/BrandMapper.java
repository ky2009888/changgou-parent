package org.changgou.goods.dao;

import org.apache.ibatis.annotations.Select;
import org.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:ky2009888
 * @Description:Brand的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 根据分类ID查询品牌
     *
     * @param categoryId 分类ID
     * @return List<Brand>
     */
    @Select(" select t.* from tb_brand t,tb_category_brand t2 where t.id = t2.brand_id and t2.category_id = #{categoryId} ")
    List<Brand> findByCategoryId(Integer categoryId);
}
