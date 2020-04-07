package org.changgou.goods.service;

import org.changgou.goods.pojo.Brand;

import java.util.List;

/**
 * 品牌表(Brand)表服务接口
 *
 * @author makejava
 * @since 2020-04-07 11:22:22
 */
public interface TbBrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Brand queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Brand> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param Brand 实例对象
     * @return 实例对象
     */
    Brand insert(Brand Brand);

    /**
     * 修改数据
     *
     * @param Brand 实例对象
     * @return 实例对象
     */
    Brand update(Brand Brand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}