package org.changgou.user.service;
import org.changgou.user.pojo.OauthRefreshToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthRefreshToken业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OauthRefreshTokenService {

    /***
     * OauthRefreshToken多条件分页查询
     * @param oauthRefreshToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthRefreshToken> findPage(OauthRefreshToken oauthRefreshToken, int page, int size);

    /***
     * OauthRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthRefreshToken> findPage(int page, int size);

    /***
     * OauthRefreshToken多条件搜索方法
     * @param oauthRefreshToken
     * @return
     */
    List<OauthRefreshToken> findList(OauthRefreshToken oauthRefreshToken);
    /***
     * 修改OauthRefreshToken数据
     * @param oauthRefreshToken
     */
    void update(OauthRefreshToken oauthRefreshToken);

    /***
     * 新增OauthRefreshToken
     * @param oauthRefreshToken
     */
    void add(OauthRefreshToken oauthRefreshToken);
    /***
     * 查询所有OauthRefreshToken
     * @return
     */
    List<OauthRefreshToken> findAll();
}
