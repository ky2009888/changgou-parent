package org.changgou.user.controller;
import org.changgou.user.pojo.OauthApprovals;
import org.changgou.user.service.OauthApprovalsService;
import com.github.pagehelper.PageInfo;
import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;
/****
 * @Author:lenovo
 * @Description:
 * @Date 2020/4/11 0:18
 *****/
@Api(value = "OauthApprovalsController")
@RestController
@RequestMapping("/oauthApprovals")
@CrossOrigin
public class OauthApprovalsController {

    @Resource
    private OauthApprovalsService oauthApprovalsService;

    /***
     * OauthApprovals分页条件搜索实现
     * @param oauthApprovals
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OauthApprovals条件分页查询",notes = "分页条件查询OauthApprovals方法详情",tags = {"OauthApprovalsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OauthApprovals对象",value = "传入JSON数据",required = false) OauthApprovals oauthApprovals, @PathVariable  int page, @PathVariable  int size){
        //调用OauthApprovalsService实现分页条件查询OauthApprovals
        PageInfo<OauthApprovals> pageInfo = oauthApprovalsService.findPage(oauthApprovals, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthApprovals分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OauthApprovals分页查询",notes = "分页查询OauthApprovals方法详情",tags = {"OauthApprovalsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthApprovalsService实现分页查询OauthApprovals
        PageInfo<OauthApprovals> pageInfo = oauthApprovalsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthApprovals
     * @return
     */
    @ApiOperation(value = "OauthApprovals条件查询",notes = "条件查询OauthApprovals方法详情",tags = {"OauthApprovalsController"})
    @PostMapping(value = "/search" )
    public Result<List<OauthApprovals>> findList(@RequestBody(required = false) @ApiParam(name = "OauthApprovals对象",value = "传入JSON数据",required = false) OauthApprovals oauthApprovals){
        //调用OauthApprovalsService实现条件查询OauthApprovals
        List<OauthApprovals> list = oauthApprovalsService.findList(oauthApprovals);
        return new Result<List<OauthApprovals>>(true,StatusCode.OK,"查询成功",list);
    }
    /***
     * 新增OauthApprovals数据
     * @param oauthApprovals
     * @return
     */
    @ApiOperation(value = "OauthApprovals添加",notes = "添加OauthApprovals方法详情",tags = {"OauthApprovalsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "OauthApprovals对象",value = "传入JSON数据",required = true) OauthApprovals oauthApprovals){
        //调用OauthApprovalsService实现添加OauthApprovals
        oauthApprovalsService.add(oauthApprovals);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /***
     * 查询OauthApprovals全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OauthApprovals",notes = "查询所OauthApprovals有方法详情",tags = {"OauthApprovalsController"})
    @GetMapping
    public Result<List<OauthApprovals>> findAll(){
        //调用OauthApprovalsService实现查询所有OauthApprovals
        List<OauthApprovals> list = oauthApprovalsService.findAll();
        return new Result<List<OauthApprovals>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
