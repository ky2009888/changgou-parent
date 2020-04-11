package org.changgou.goods.controller;

import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.changgou.goods.pojo.Brand;
import org.changgou.goods.service.TbBrandService;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌表(TbBrand)表控制层
 *
 * @author makejava
 * @since 2020-04-07 11:22:23
 */
@RestController
@RequestMapping("tbBrand")
@CrossOrigin
public class TbBrandOldController {
    /**
     * 服务对象
     */
    @Resource
    private TbBrandService tbBrandService;

    /**
     * 新增品牌
     *
     * @param brand 品牌对象
     * @return 新增品牌的信息
     */
    @PostMapping("addBrand")
    public Result<Brand> addBrand(Brand brand) {
        brand = this.tbBrandService.insert(brand);
        return new Result<Brand>(true, StatusCode.OK, "通过主键查询单条数据", brand);
    }

    /**
     * 修改品牌
     *
     * @param brand 品牌对象
     * @return 新增品牌的信息
     */
    @PostMapping("updateBrand")
    public Result<Brand> updateBrand(Brand brand) {
        brand = this.tbBrandService.update(brand);
        return new Result<Brand>(true, StatusCode.OK, "通过主键查询单条数据", brand);
    }

    /**
     * 修改品牌
     *
     * @param id 品牌对象ID
     * @return 新增品牌的信息
     */
    @PostMapping("deleteBrand")
    public Result<Brand> deleteBrand(int id) {
        boolean result = this.tbBrandService.deleteById(id);
        return new Result<Brand>(result, StatusCode.OK, "通过主键查询单条数据", null);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Result<Brand> selectOne(Integer id) {
        Brand brand = this.tbBrandService.queryById(id);
        String hello = null;
        hello.split(",");
        return new Result<Brand>(true, StatusCode.OK, "通过主键查询单条数据", brand);
    }

    /**
     * 查询指定的内容
     *
     * @return Result
     */
    @GetMapping("selectAll")
    public Result selectAll(int offset, int limit) {
        if (offset <= 0) {
            offset = 0;
        }
        if (limit <= 0) {
            limit = 10;
        }
        List<Brand> brandList = tbBrandService.queryAllByLimit(new Brand(), offset, limit);
        Result<List<Brand>> result = new Result(true, StatusCode.OK, "查询列表成功", brandList);
        return result;
    }

    /**
     * 查询指定的内容
     *
     * @return Result
     */
    @GetMapping("selectByCondition")
    public Result selectByCondition(Brand brand, int offset, int limit) {
        if (offset <= 0) {
            offset = 0;
        }
        if (limit <= 0) {
            limit = 10;
        }
        List<Brand> brandList = tbBrandService.queryAllByLimit(brand, offset, limit);
        Result<List<Brand>> result = new Result(true, StatusCode.OK, "查询列表成功", brandList);
        return result;
    }

    /**
     * 条件查询
     *
     * @param brand
     * @return
     */
    @GetMapping("/findList")
    public List<Brand> findList(Brand brand) {
        //构建查询条件
        Example example = createExample(brand);
        //根据构建的条件查询数据
        return tbBrandService.queryAllByExample(example);
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

    /***
     * 分页搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable int page, @PathVariable int size) {
        //执行搜索
        PageInfo<Brand> pageInfo = tbBrandService.findPage(brand, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }
}