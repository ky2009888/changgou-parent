package org.changgou.goods.service.impl;

import org.changgou.goods.dao.TbBrandMapper;
import org.changgou.goods.pojo.Brand;
import org.changgou.goods.service.TbBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌表(Brand)表服务实现类
 *
 * @author makejava
 * @since 2020-04-07 11:22:23
 */
@Service("brandService")
public class TbBrandServiceImpl implements TbBrandService {
    @Resource
    private TbBrandMapper tbBrandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Brand queryById(Integer id) {
        return this.tbBrandDao.selectByPrimaryKey(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Brand> queryAllByLimit(int offset, int limit) {
        //return this.tbBrandDao.selectByExampleAndRowBounds(offset, limit);
        return null;
    }

    /**
     * 新增数据
     *
     * @param Brand 实例对象
     * @return 实例对象
     */
    @Override
    public Brand insert(Brand Brand) {
        this.tbBrandDao.insert(Brand);
        return Brand;
    }

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @Override
    public Brand update(Brand brand) {
        this.tbBrandDao.updateByPrimaryKey(brand);
        return this.queryById(brand.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbBrandDao.deleteByPrimaryKey(id) > 0;
    }
}