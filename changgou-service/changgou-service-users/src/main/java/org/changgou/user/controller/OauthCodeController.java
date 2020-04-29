package org.changgou.user.controller;
import org.changgou.user.pojo.OauthCode;
import org.changgou.user.service.OauthCodeService;
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
@Api(value = "OauthCodeController")
@RestController
@RequestMapping("/oauthCode")
@CrossOrigin
public class OauthCodeController {

    @Resource
    private OauthCodeService oauthCodeService;

    /***
     * OauthCode分页条件搜索实现
     * @param oauthCode
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OauthCode条件分页查询",notes = "分页条件查询OauthCode方法详情",tags = {"OauthCodeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OauthCode对象",value = "传入JSON数据",required = false) OauthCode oauthCode, @PathVariable  int page, @PathVariable  int size){
        //调用OauthCodeService实现分页条件查询OauthCode
        PageInfo<OauthCode> pageInfo = oauthCodeService.findPage(oauthCode, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthCode分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OauthCode分页查询",notes = "分页查询OauthCode方法详情",tags = {"OauthCodeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthCodeService实现分页查询OauthCode
        PageInfo<OauthCode> pageInfo = oauthCodeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthCode
     * @return
     */
    @ApiOperation(value = "OauthCode条件查询",notes = "条件查询OauthCode方法详情",tags = {"OauthCodeController"})
    @PostMapping(value = "/search" )
    public Result<List<OauthCode>> findList(@RequestBody(required = false) @ApiParam(name = "OauthCode对象",value = "传入JSON数据",required = false) OauthCode oauthCode){
        //调用OauthCodeService实现条件查询OauthCode
        List<OauthCode> list = oauthCodeService.findList(oauthCode);
        return new Result<List<OauthCode>>(true,StatusCode.OK,"查询成功",list);
    }
    /***
     * 新增OauthCode数据
     * @param oauthCode
     * @return
     */
    @ApiOperation(value = "OauthCode添加",notes = "添加OauthCode方法详情",tags = {"OauthCodeController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "OauthCode对象",value = "传入JSON数据",required = true) OauthCode oauthCode){
        //调用OauthCodeService实现添加OauthCode
        oauthCodeService.add(oauthCode);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /***
     * 查询OauthCode全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OauthCode",notes = "查询所OauthCode有方法详情",tags = {"OauthCodeController"})
    @GetMapping
    public Result<List<OauthCode>> findAll(){
        //调用OauthCodeService实现查询所有OauthCode
        List<OauthCode> list = oauthCodeService.findAll();
        return new Result<List<OauthCode>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
