package org.changgou.goods.dao;

import org.apache.ibatis.annotations.Param;
import org.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 品牌表(TbBrand)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-07 11:22:21
 */
public interface TbBrandMapper extends Mapper<Brand> {

}