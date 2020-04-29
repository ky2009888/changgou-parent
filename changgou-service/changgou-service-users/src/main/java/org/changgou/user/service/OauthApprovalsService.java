package org.changgou.user.service;
import org.changgou.user.pojo.OauthApprovals;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:ky2009888
 * @Description:OauthApprovals业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OauthApprovalsService {

    /***
     * OauthApprovals多条件分页查询
     * @param oauthApprovals
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthApprovals> findPage(OauthApprovals oauthApprovals, int page, int size);

    /***
     * OauthApprovals分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthApprovals> findPage(int page, int size);

    /***
     * OauthApprovals多条件搜索方法
     * @param oauthApprovals
     * @return
     */
    List<OauthApprovals> findList(OauthApprovals oauthApprovals);
    /***
     * 修改OauthApprovals数据
     * @param oauthApprovals
     */
    void update(OauthApprovals oauthApprovals);

    /***
     * 新增OauthApprovals
     * @param oauthApprovals
     */
    void add(OauthApprovals oauthApprovals);
    /***
     * 查询所有OauthApprovals
     * @return
     */
    List<OauthApprovals> findAll();
}
