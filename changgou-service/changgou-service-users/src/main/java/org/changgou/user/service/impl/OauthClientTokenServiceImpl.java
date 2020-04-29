package org.changgou.user.service.impl;
import org.changgou.user.dao.OauthClientTokenMapper;
import org.changgou.user.pojo.OauthClientToken;
import org.changgou.user.service.OauthClientTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthClientToken业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OauthClientTokenServiceImpl implements OauthClientTokenService {

    @Autowired
    private OauthClientTokenMapper oauthClientTokenMapper;


    /**
     * OauthClientToken条件+分页查询
     * @param oauthClientToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthClientToken> findPage(OauthClientToken oauthClientToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthClientToken);
        //执行搜索
        return new PageInfo<OauthClientToken>(oauthClientTokenMapper.selectByExample(example));
    }

    /**
     * OauthClientToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthClientToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthClientToken>(oauthClientTokenMapper.selectAll());
    }

    /**
     * OauthClientToken条件查询
     * @param oauthClientToken
     * @return
     */
    @Override
    public List<OauthClientToken> findList(OauthClientToken oauthClientToken){
        //构建查询条件
        Example example = createExample(oauthClientToken);
        //根据构建的条件查询数据
        return oauthClientTokenMapper.selectByExample(example);
    }


    /**
     * OauthClientToken构建查询对象
     * @param oauthClientToken
     * @return
     */
    public Example createExample(OauthClientToken oauthClientToken){
        Example example=new Example(OauthClientToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthClientToken!=null){
            // 
            if(!StringUtils.isEmpty(oauthClientToken.getTokenId())){
                    criteria.andEqualTo("tokenId",oauthClientToken.getTokenId());
            }
            // 
            if(!StringUtils.isEmpty(oauthClientToken.getToken())){
                    criteria.andEqualTo("token",oauthClientToken.getToken());
            }
            // 
            if(!StringUtils.isEmpty(oauthClientToken.getAuthenticationId())){
                    criteria.andEqualTo("authenticationId",oauthClientToken.getAuthenticationId());
            }
            // 
            if(!StringUtils.isEmpty(oauthClientToken.getUserName())){
                    criteria.andEqualTo("userName",oauthClientToken.getUserName());
            }
            // 
            if(!StringUtils.isEmpty(oauthClientToken.getClientId())){
                    criteria.andEqualTo("clientId",oauthClientToken.getClientId());
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
            oauthClientTokenMapper.deleteByPrimaryKey(id);
        }
    /**
     * 修改OauthClientToken
     * @param oauthClientToken
     */
    @Override
    public void update(OauthClientToken oauthClientToken){
        oauthClientTokenMapper.updateByPrimaryKey(oauthClientToken);
    }

    /**
     * 增加OauthClientToken
     * @param oauthClientToken
     */
    @Override
    public void add(OauthClientToken oauthClientToken){
        oauthClientTokenMapper.insert(oauthClientToken);
    }
        /**
         * 根据ID查询OauthClientToken
         * @param id
         * @return
         */
        @Override
        public OauthClientToken findById(String id){
            return  oauthClientTokenMapper.selectByPrimaryKey(id);
        }
    /**
     * 查询OauthClientToken全部数据
     * @return
     */
    @Override
    public List<OauthClientToken> findAll() {
        return oauthClientTokenMapper.selectAll();
    }
}
