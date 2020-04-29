package org.changgou.user.service.impl;
import org.changgou.user.dao.OauthApprovalsMapper;
import org.changgou.user.pojo.OauthApprovals;
import org.changgou.user.service.OauthApprovalsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthApprovals业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OauthApprovalsServiceImpl implements OauthApprovalsService {

    @Autowired
    private OauthApprovalsMapper oauthApprovalsMapper;


    /**
     * OauthApprovals条件+分页查询
     * @param oauthApprovals 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthApprovals> findPage(OauthApprovals oauthApprovals, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthApprovals);
        //执行搜索
        return new PageInfo<OauthApprovals>(oauthApprovalsMapper.selectByExample(example));
    }

    /**
     * OauthApprovals分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthApprovals> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthApprovals>(oauthApprovalsMapper.selectAll());
    }

    /**
     * OauthApprovals条件查询
     * @param oauthApprovals
     * @return
     */
    @Override
    public List<OauthApprovals> findList(OauthApprovals oauthApprovals){
        //构建查询条件
        Example example = createExample(oauthApprovals);
        //根据构建的条件查询数据
        return oauthApprovalsMapper.selectByExample(example);
    }


    /**
     * OauthApprovals构建查询对象
     * @param oauthApprovals
     * @return
     */
    public Example createExample(OauthApprovals oauthApprovals){
        Example example=new Example(OauthApprovals.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthApprovals!=null){
            // 
            if(!StringUtils.isEmpty(oauthApprovals.getUserId())){
                    criteria.andEqualTo("userId",oauthApprovals.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(oauthApprovals.getClientId())){
                    criteria.andEqualTo("clientId",oauthApprovals.getClientId());
            }
            // 
            if(!StringUtils.isEmpty(oauthApprovals.getScope())){
                    criteria.andEqualTo("scope",oauthApprovals.getScope());
            }
            // 
            if(!StringUtils.isEmpty(oauthApprovals.getStatus())){
                    criteria.andEqualTo("status",oauthApprovals.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(oauthApprovals.getExpiresAt())){
                    criteria.andEqualTo("expiresAt",oauthApprovals.getExpiresAt());
            }
            // 
            if(!StringUtils.isEmpty(oauthApprovals.getLastModifiedAt())){
                    criteria.andEqualTo("lastModifiedAt",oauthApprovals.getLastModifiedAt());
            }
        }
        return example;
    }
    /**
     * 修改OauthApprovals
     * @param oauthApprovals
     */
    @Override
    public void update(OauthApprovals oauthApprovals){
        oauthApprovalsMapper.updateByPrimaryKey(oauthApprovals);
    }

    /**
     * 增加OauthApprovals
     * @param oauthApprovals
     */
    @Override
    public void add(OauthApprovals oauthApprovals){
        oauthApprovalsMapper.insert(oauthApprovals);
    }
    /**
     * 查询OauthApprovals全部数据
     * @return
     */
    @Override
    public List<OauthApprovals> findAll() {
        return oauthApprovalsMapper.selectAll();
    }
}
