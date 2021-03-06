package org.changgou.goods.controller;

import org.changgou.goods.pojo.Goods;
import org.changgou.goods.pojo.Spu;
import org.changgou.goods.service.SpuService;
import com.github.pagehelper.PageInfo;
import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/****
 * @Author:ky2009888
 * @Description:
 * @Date 2020/4/11 14:56
 *****/
@Api(value = "SpuController")
@RestController
@RequestMapping("/spuc")
@CrossOrigin
public class SpuController {

    @Resource
    private SpuService spuService;

    /**
     * 商品审核
     *
     * @param spuId
     * @return Result
     */
    @GetMapping("/auditGoods")
    public Result<Goods> auditGoods(String spuId) {
        boolean goods = spuService.auditGoods(spuId);
        return new Result<Goods>(goods, StatusCode.OK, "审核成功");
    }

    /**
     * 下架商品
     *
     * @param spuId
     * @return Result
     */
    @GetMapping("/pullGoods")
    public Result<Goods> pullGoods(String spuId) {
        boolean goods = spuService.pullGoods(spuId);
        return new Result<Goods>(goods, StatusCode.OK, "下架成功");
    }

    /**
     * 批量上架商品
     *
     * @param spuIds
     * @return Result
     */
    @GetMapping("/batchPushGoods")
    public Result<Map<String, Boolean>> batchPushGoods(String[] spuIds) {
        List<Map<String, Boolean>> mapList = spuService.batchPushGoods(spuIds);
        return new Result<Map<String, Boolean>>(true, StatusCode.OK, "批量上架成功", mapList);
    }

    /**
     * 上架商品
     *
     * @param spuId
     * @return Result
     */
    @GetMapping("/pushGoods")
    public Result<Goods> pushGoods(String spuId) {
        boolean goods = spuService.pullGoods(spuId);
        return new Result<Goods>(goods, StatusCode.OK, "上架成功");
    }

    /**
     * 根据SPU的主键进行查询
     *
     * @param id spuId
     * @return Result<Goods>
     */
    @GetMapping("/findGoodsById")
    public Result<Goods> findGoodsById(String id) {
        Goods goods = spuService.findGoodsById(id);
        return new Result<Goods>(true, StatusCode.OK, "查询商品信息成功", goods);
    }

    /***
     * Spu分页条件搜索实现
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Spu条件分页查询", notes = "分页条件查询Spu方法详情", tags = {"SpuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Spu>> findPage(@RequestBody(required = false) @ApiParam(name = "Spu对象", value = "传入JSON数据", required = false) Spu spu, @PathVariable int page, @PathVariable int size) {
        //调用SpuService实现分页条件查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(spu, page, size);
        return new Result<PageInfo<Spu>>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * Spu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Spu分页查询", notes = "分页查询Spu方法详情", tags = {"SpuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Spu>> findPage(@PathVariable int page, @PathVariable int size) {
        //调用SpuService实现分页查询Spu
        PageInfo<Spu> pageInfo = spuService.findPage(page, size);
        return new Result<PageInfo<Spu>>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param spu
     * @return
     */
    @ApiOperation(value = "Spu条件查询", notes = "条件查询Spu方法详情", tags = {"SpuController"})
    @PostMapping(value = "/search")
    public Result<List<Spu>> findList(@RequestBody(required = false) @ApiParam(name = "Spu对象", value = "传入JSON数据", required = false) Spu spu) {
        //调用SpuService实现条件查询Spu
        List<Spu> list = spuService.findList(spu);
        return new Result<List<Spu>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Spu根据ID删除", notes = "根据ID删除Spu方法详情", tags = {"SpuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        //调用SpuService实现根据主键删除
        spuService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改Spu数据
     * @param spu
     * @param id
     * @return
     */
    @ApiOperation(value = "Spu根据ID修改", notes = "根据ID修改Spu方法详情", tags = {"SpuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody @ApiParam(name = "Spu对象", value = "传入JSON数据", required = false) Spu spu, @PathVariable String id) {
        //设置主键值
        spu.setId(id);
        //调用SpuService实现修改Spu
        spuService.update(spu);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增Spu数据
     * @param spu
     * @return
     */
    @ApiOperation(value = "Spu添加", notes = "添加Spu方法详情", tags = {"SpuController"})
    @PostMapping
    public Result add(@RequestBody @ApiParam(name = "Spu对象", value = "传入JSON数据", required = true) Spu spu) {
        //调用SpuService实现添加Spu
        spuService.add(spu);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 根据ID查询Spu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Spu根据ID查询", notes = "根据ID查询Spu方法详情", tags = {"SpuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Spu> findById(@PathVariable String id) {
        //调用SpuService实现根据主键查询Spu
        Spu spu = spuService.findById(id);
        return new Result<Spu>(true, StatusCode.OK, "查询成功", spu);
    }

    /***
     * 查询Spu全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Spu", notes = "查询所Spu有方法详情", tags = {"SpuController"})
    @GetMapping("/findAll")
    public Result<List<Spu>> findAll() {
        //调用SpuService实现查询所有Spu
        List<Spu> list = spuService.findAll();
        return new Result<List<Spu>>(true, StatusCode.OK, "查询成功", list);
    }
}
