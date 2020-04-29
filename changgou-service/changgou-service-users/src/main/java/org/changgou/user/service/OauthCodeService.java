package org.changgou.user.service;
import org.changgou.user.pojo.OauthCode;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthCode业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OauthCodeService {

    /***
     * OauthCode多条件分页查询
     * @param oauthCode
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthCode> findPage(OauthCode oauthCode, int page, int size);

    /***
     * OauthCode分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthCode> findPage(int page, int size);

    /***
     * OauthCode多条件搜索方法
     * @param oauthCode
     * @return
     */
    List<OauthCode> findList(OauthCode oauthCode);
    /***
     * 修改OauthCode数据
     * @param oauthCode
     */
    void update(OauthCode oauthCode);

    /***
     * 新增OauthCode
     * @param oauthCode
     */
    void add(OauthCode oauthCode);
    /***
     * 查询所有OauthCode
     * @return
     */
    List<OauthCode> findAll();
}
