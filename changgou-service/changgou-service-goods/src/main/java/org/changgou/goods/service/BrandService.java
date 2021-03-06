package org.changgou.goods.service;

import org.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:ky2009888
 * @Description:Brand业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BrandService {

    /***
     * Brand多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    /***
     * Brand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(int page, int size);

    /***
     * Brand多条件搜索方法
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /***
     * 删除Brand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Brand数据
     * @param brand
     */
    void update(Brand brand);

    /***
     * 新增Brand
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据ID查询Brand
     *
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 根据分类ID，CategoryId查询Brand
     *
     * @param categoryId 分类ID
     * @return List<Brand>
     */
    public List<Brand> findByCategoryId(Integer categoryId);

    /***
     * 查询所有Brand
     * @return
     */
    List<Brand> findAll();
}
