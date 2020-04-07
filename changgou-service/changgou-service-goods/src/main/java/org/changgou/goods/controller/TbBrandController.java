package org.changgou.goods.controller;

import org.changgou.goods.pojo.Brand;
import org.changgou.goods.service.TbBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 品牌表(TbBrand)表控制层
 *
 * @author makejava
 * @since 2020-04-07 11:22:23
 */
@RestController
@RequestMapping("tbBrand")
@CrossOrigin
public class TbBrandController {
    /**
     * 服务对象
     */
    @Resource
    private TbBrandService tbBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Brand selectOne(Integer id) {
        return this.tbBrandService.queryById(id);
    }

}