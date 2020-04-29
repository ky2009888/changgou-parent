package org.changgou.user.controller;
import org.changgou.user.pojo.OauthClientToken;
import org.changgou.user.service.OauthClientTokenService;
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
@Api(value = "OauthClientTokenController")
@RestController
@RequestMapping("/oauthClientToken")
@CrossOrigin
public class OauthClientTokenController {

    @Resource
    private OauthClientTokenService oauthClientTokenService;

    /***
     * OauthClientToken分页条件搜索实现
     * @param oauthClientToken
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OauthClientToken条件分页查询",notes = "分页条件查询OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OauthClientToken对象",value = "传入JSON数据",required = false) OauthClientToken oauthClientToken, @PathVariable  int page, @PathVariable  int size){
        //调用OauthClientTokenService实现分页条件查询OauthClientToken
        PageInfo<OauthClientToken> pageInfo = oauthClientTokenService.findPage(oauthClientToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthClientToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OauthClientToken分页查询",notes = "分页查询OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthClientTokenService实现分页查询OauthClientToken
        PageInfo<OauthClientToken> pageInfo = oauthClientTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthClientToken
     * @return
     */
    @ApiOperation(value = "OauthClientToken条件查询",notes = "条件查询OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @PostMapping(value = "/search" )
    public Result<List<OauthClientToken>> findList(@RequestBody(required = false) @ApiParam(name = "OauthClientToken对象",value = "传入JSON数据",required = false) OauthClientToken oauthClientToken){
        //调用OauthClientTokenService实现条件查询OauthClientToken
        List<OauthClientToken> list = oauthClientTokenService.findList(oauthClientToken);
        return new Result<List<OauthClientToken>>(true,StatusCode.OK,"查询成功",list);
    }
    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthClientToken根据ID删除",notes = "根据ID删除OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OauthClientTokenService实现根据主键删除
        oauthClientTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    /***
     * 修改OauthClientToken数据
     * @param oauthClientToken
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthClientToken根据ID修改",notes = "根据ID修改OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "OauthClientToken对象",value = "传入JSON数据",required = false) OauthClientToken oauthClientToken,@PathVariable String id){
        //设置主键值
        oauthClientToken.setAuthenticationId(id);
        //调用OauthClientTokenService实现修改OauthClientToken
        oauthClientTokenService.update(oauthClientToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /***
     * 新增OauthClientToken数据
     * @param oauthClientToken
     * @return
     */
    @ApiOperation(value = "OauthClientToken添加",notes = "添加OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "OauthClientToken对象",value = "传入JSON数据",required = true) OauthClientToken oauthClientToken){
        //调用OauthClientTokenService实现添加OauthClientToken
        oauthClientTokenService.add(oauthClientToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /***
     * 根据ID查询OauthClientToken数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthClientToken根据ID查询",notes = "根据ID查询OauthClientToken方法详情",tags = {"OauthClientTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<OauthClientToken> findById(@PathVariable String id){
        //调用OauthClientTokenService实现根据主键查询OauthClientToken
        OauthClientToken oauthClientToken = oauthClientTokenService.findById(id);
        return new Result<OauthClientToken>(true,StatusCode.OK,"查询成功",oauthClientToken);
    }
    /***
     * 查询OauthClientToken全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OauthClientToken",notes = "查询所OauthClientToken有方法详情",tags = {"OauthClientTokenController"})
    @GetMapping
    public Result<List<OauthClientToken>> findAll(){
        //调用OauthClientTokenService实现查询所有OauthClientToken
        List<OauthClientToken> list = oauthClientTokenService.findAll();
        return new Result<List<OauthClientToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
