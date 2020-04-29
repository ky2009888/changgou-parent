package org.changgou.user.service.impl;
import org.changgou.user.dao.OauthCodeMapper;
import org.changgou.user.pojo.OauthCode;
import org.changgou.user.service.OauthCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthCode业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class OauthCodeServiceImpl implements OauthCodeService {

    @Autowired
    private OauthCodeMapper oauthCodeMapper;


    /**
     * OauthCode条件+分页查询
     * @param oauthCode 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthCode> findPage(OauthCode oauthCode, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthCode);
        //执行搜索
        return new PageInfo<OauthCode>(oauthCodeMapper.selectByExample(example));
    }

    /**
     * OauthCode分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthCode> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthCode>(oauthCodeMapper.selectAll());
    }

    /**
     * OauthCode条件查询
     * @param oauthCode
     * @return
     */
    @Override
    public List<OauthCode> findList(OauthCode oauthCode){
        //构建查询条件
        Example example = createExample(oauthCode);
        //根据构建的条件查询数据
        return oauthCodeMapper.selectByExample(example);
    }


    /**
     * OauthCode构建查询对象
     * @param oauthCode
     * @return
     */
    public Example createExample(OauthCode oauthCode){
        Example example=new Example(OauthCode.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthCode!=null){
            // 
            if(!StringUtils.isEmpty(oauthCode.getCode())){
                    criteria.andEqualTo("code",oauthCode.getCode());
            }
            // 
            if(!StringUtils.isEmpty(oauthCode.getAuthentication())){
                    criteria.andEqualTo("authentication",oauthCode.getAuthentication());
            }
        }
        return example;
    }
    /**
     * 修改OauthCode
     * @param oauthCode
     */
    @Override
    public void update(OauthCode oauthCode){
        oauthCodeMapper.updateByPrimaryKey(oauthCode);
    }

    /**
     * 增加OauthCode
     * @param oauthCode
     */
    @Override
    public void add(OauthCode oauthCode){
        oauthCodeMapper.insert(oauthCode);
    }
    /**
     * 查询OauthCode全部数据
     * @return
     */
    @Override
    public List<OauthCode> findAll() {
        return oauthCodeMapper.selectAll();
    }
}
