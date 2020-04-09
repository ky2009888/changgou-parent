package org.changgou.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.changgou.goods.dao.TbBrandMapper;
import org.changgou.goods.pojo.Brand;
import org.changgou.goods.service.TbBrandService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public List<Brand> queryAllByLimit(Brand brand, int offset, int limit) {
        return this.tbBrandDao.selectByRowBounds(brand, new RowBounds(offset, limit));
    }

    /**
     * 查询多条数据
     *
     * @param example 查询条数
     * @return 对象列表
     */
    @Override
    public List<Brand> queryAllByExample(Example example) {
        return this.tbBrandDao.selectByExample(example);
    }

    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @Override
    public Brand insert(Brand brand) {
        this.tbBrandDao.insertSelective(brand);
        return brand;
    }

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @Override
    public Brand update(Brand brand) {
        this.tbBrandDao.updateByPrimaryKeySelective(brand);
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

    /**
     * 条件+分页查询
     *
     * @param brand 查询条件
     * @param page  页码
     * @param size  页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(brand);
        //执行搜索
        return new PageInfo<Brand>(this.tbBrandDao.selectByExample(example));
    }

    /**
     * 构建查询对象
     *
     * @param brand
     * @return
     */
    public Example createExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            // 品牌名称
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            // 品牌图片地址
            if (!StringUtils.isEmpty(brand.getImage())) {
                criteria.andLike("image", "%" + brand.getImage() + "%");
            }
            // 品牌的首字母
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andLike("letter", "%" + brand.getLetter() + "%");
            }
            // 品牌id
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("id", brand.getId());
            }
            // 排序
            if (!StringUtils.isEmpty(brand.getSeq() + "")) {
                criteria.andEqualTo("seq", brand.getSeq());
            }
        }
        return example;
    }
}