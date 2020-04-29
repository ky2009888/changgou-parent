package org.changgou.user.service;
import org.changgou.user.pojo.OauthClientToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthClientToken业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OauthClientTokenService {

    /***
     * OauthClientToken多条件分页查询
     * @param oauthClientToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthClientToken> findPage(OauthClientToken oauthClientToken, int page, int size);

    /***
     * OauthClientToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthClientToken> findPage(int page, int size);

    /***
     * OauthClientToken多条件搜索方法
     * @param oauthClientToken
     * @return
     */
    List<OauthClientToken> findList(OauthClientToken oauthClientToken);
    /***
     * 删除OauthClientToken
     * @param id
     */
    void delete(String id);
    /***
     * 修改OauthClientToken数据
     * @param oauthClientToken
     */
    void update(OauthClientToken oauthClientToken);

    /***
     * 新增OauthClientToken
     * @param oauthClientToken
     */
    void add(OauthClientToken oauthClientToken);
    /**
     * 根据ID查询OauthClientToken
     * @param id
     * @return
     */
   OauthClientToken findById(String id);
    /***
     * 查询所有OauthClientToken
     * @return
     */
    List<OauthClientToken> findAll();
}
