package org.changgou.user.service.impl;
import org.changgou.user.dao.PointLogMapper;
import org.changgou.user.pojo.PointLog;
import org.changgou.user.service.PointLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:PointLog业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PointLogServiceImpl implements PointLogService {

    @Autowired
    private PointLogMapper pointLogMapper;


    /**
     * PointLog条件+分页查询
     * @param pointLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PointLog> findPage(PointLog pointLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pointLog);
        //执行搜索
        return new PageInfo<PointLog>(pointLogMapper.selectByExample(example));
    }

    /**
     * PointLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PointLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PointLog>(pointLogMapper.selectAll());
    }

    /**
     * PointLog条件查询
     * @param pointLog
     * @return
     */
    @Override
    public List<PointLog> findList(PointLog pointLog){
        //构建查询条件
        Example example = createExample(pointLog);
        //根据构建的条件查询数据
        return pointLogMapper.selectByExample(example);
    }


    /**
     * PointLog构建查询对象
     * @param pointLog
     * @return
     */
    public Example createExample(PointLog pointLog){
        Example example=new Example(PointLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(pointLog!=null){
            // 
            if(!StringUtils.isEmpty(pointLog.getOrderId())){
                    criteria.andEqualTo("orderId",pointLog.getOrderId());
            }
            // 
            if(!StringUtils.isEmpty(pointLog.getUserId())){
                    criteria.andEqualTo("userId",pointLog.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(pointLog.getPoint())){
                    criteria.andEqualTo("point",pointLog.getPoint());
            }
        }
        return example;
    }
        /**
         * 删除
         * @param id
         */
        @Override
        public void delete(String id){
            pointLogMapper.deleteByPrimaryKey(id);
        }
    /**
     * 修改PointLog
     * @param pointLog
     */
    @Override
    public void update(PointLog pointLog){
        pointLogMapper.updateByPrimaryKey(pointLog);
    }

    /**
     * 增加PointLog
     * @param pointLog
     */
    @Override
    public void add(PointLog pointLog){
        pointLogMapper.insert(pointLog);
    }
        /**
         * 根据ID查询PointLog
         * @param id
         * @return
         */
        @Override
        public PointLog findById(String id){
            return  pointLogMapper.selectByPrimaryKey(id);
        }
    /**
     * 查询PointLog全部数据
     * @return
     */
    @Override
    public List<PointLog> findAll() {
        return pointLogMapper.selectAll();
    }
}
