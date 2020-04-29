package org.changgou.user.service;
import org.changgou.user.pojo.PointLog;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:PointLog业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PointLogService {

    /***
     * PointLog多条件分页查询
     * @param pointLog
     * @param page
     * @param size
     * @return
     */
    PageInfo<PointLog> findPage(PointLog pointLog, int page, int size);

    /***
     * PointLog分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PointLog> findPage(int page, int size);

    /***
     * PointLog多条件搜索方法
     * @param pointLog
     * @return
     */
    List<PointLog> findList(PointLog pointLog);
    /***
     * 删除PointLog
     * @param id
     */
    void delete(String id);
    /***
     * 修改PointLog数据
     * @param pointLog
     */
    void update(PointLog pointLog);

    /***
     * 新增PointLog
     * @param pointLog
     */
    void add(PointLog pointLog);
    /**
     * 根据ID查询PointLog
     * @param id
     * @return
     */
   PointLog findById(String id);
    /***
     * 查询所有PointLog
     * @return
     */
    List<PointLog> findAll();
}
