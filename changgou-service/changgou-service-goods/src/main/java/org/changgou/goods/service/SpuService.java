package org.changgou.goods.service;

import org.changgou.goods.pojo.Goods;
import org.changgou.goods.pojo.Spu;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/****
 * @Author:ky2009888
 * @Description:Spu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SpuService {

    /***
     * Spu多条件分页查询
     * @param spu
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(Spu spu, int page, int size);

    /***
     * Spu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Spu> findPage(int page, int size);

    /***
     * Spu多条件搜索方法
     * @param spu
     * @return
     */
    List<Spu> findList(Spu spu);

    /***
     * 删除Spu
     * @param id
     */
    void delete(String id);

    /***
     * 修改Spu数据
     * @param spu
     */
    void update(Spu spu);

    /***
     * 新增Spu
     * @param spu
     */
    void add(Spu spu);

    /**
     * 根据ID查询Spu
     *
     * @param id
     * @return
     */
    Spu findById(String id);

    /***
     * 查询所有Spu
     * @return
     */
    List<Spu> findAll();

    /**
     * 新增商品信息
     *
     * @param goods 商品信息
     */
    void addGoods(Goods goods);

    /**
     * 根据商品ID查询商品信息
     *
     * @param id 商品ID
     * @return Goods
     */
    Goods findGoodsById(String id);

    /**
     * 审核商品
     *
     * @param spuId
     * @return boolen true:成功 false:失败
     */
    boolean auditGoods(String spuId);

    /**
     * 下架商品
     *
     * @param spuId
     * @return boolean true:成功 false:失败
     */
    boolean pullGoods(String spuId);

    /**
     * 上架商品
     *
     * @param spuId
     * @return boolean true:成功 false:失败
     */
    boolean pushGoods(String spuId);

    /**
     * 批量上架商品
     *
     * @param spuIds 一组商品ID
     * @return List<Map < String, Boolean>> true:成功 false:失败
     */
    List<Map<String, Boolean>> batchPushGoods(String[] spuIds);
}
