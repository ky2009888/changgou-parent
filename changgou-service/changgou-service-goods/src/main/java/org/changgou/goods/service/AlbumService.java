package org.changgou.goods.service;

import org.changgou.goods.pojo.Album;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * Album表服务接口
 *
 * @author lenovo
 * @since 2020-04-11 11:22:22
 */
public interface AlbumService {

    /***
     * 查询所有
     * @return
     */
    List<Album> findAll();

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Album findById(Long id);

    /***
     * 新增
     * @param album
     */
    void add(Album album);

    /***
     * 修改
     * @param album
     */
    void update(Album album);

    /***
     * 删除
     * @param id
     */
    void delete(Long id);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<Album> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Album> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Album> findPage(Map<String, Object> searchMap, int page, int size);


}
