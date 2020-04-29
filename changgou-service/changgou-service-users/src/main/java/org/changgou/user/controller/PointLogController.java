package org.changgou.user.controller;
import org.changgou.user.pojo.PointLog;
import org.changgou.user.service.PointLogService;
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
@Api(value = "PointLogController")
@RestController
@RequestMapping("/pointLog")
@CrossOrigin
public class PointLogController {

    @Resource
    private PointLogService pointLogService;

    /***
     * PointLog分页条件搜索实现
     * @param pointLog
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "PointLog条件分页查询",notes = "分页条件查询PointLog方法详情",tags = {"PointLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "PointLog对象",value = "传入JSON数据",required = false) PointLog pointLog, @PathVariable  int page, @PathVariable  int size){
        //调用PointLogService实现分页条件查询PointLog
        PageInfo<PointLog> pageInfo = pointLogService.findPage(pointLog, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * PointLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "PointLog分页查询",notes = "分页查询PointLog方法详情",tags = {"PointLogController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PointLogService实现分页查询PointLog
        PageInfo<PointLog> pageInfo = pointLogService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pointLog
     * @return
     */
    @ApiOperation(value = "PointLog条件查询",notes = "条件查询PointLog方法详情",tags = {"PointLogController"})
    @PostMapping(value = "/search" )
    public Result<List<PointLog>> findList(@RequestBody(required = false) @ApiParam(name = "PointLog对象",value = "传入JSON数据",required = false) PointLog pointLog){
        //调用PointLogService实现条件查询PointLog
        List<PointLog> list = pointLogService.findList(pointLog);
        return new Result<List<PointLog>>(true,StatusCode.OK,"查询成功",list);
    }
    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "PointLog根据ID删除",notes = "根据ID删除PointLog方法详情",tags = {"PointLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用PointLogService实现根据主键删除
        pointLogService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    /***
     * 修改PointLog数据
     * @param pointLog
     * @param id
     * @return
     */
    @ApiOperation(value = "PointLog根据ID修改",notes = "根据ID修改PointLog方法详情",tags = {"PointLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "PointLog对象",value = "传入JSON数据",required = false) PointLog pointLog,@PathVariable String id){
        //设置主键值
        pointLog.setOrderId(id);
        //调用PointLogService实现修改PointLog
        pointLogService.update(pointLog);
        return new Result(true,StatusCode.OK,"修改成功");
    }
    /***
     * 新增PointLog数据
     * @param pointLog
     * @return
     */
    @ApiOperation(value = "PointLog添加",notes = "添加PointLog方法详情",tags = {"PointLogController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "PointLog对象",value = "传入JSON数据",required = true) PointLog pointLog){
        //调用PointLogService实现添加PointLog
        pointLogService.add(pointLog);
        return new Result(true,StatusCode.OK,"添加成功");
    }
    /***
     * 根据ID查询PointLog数据
     * @param id
     * @return
     */
    @ApiOperation(value = "PointLog根据ID查询",notes = "根据ID查询PointLog方法详情",tags = {"PointLogController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<PointLog> findById(@PathVariable String id){
        //调用PointLogService实现根据主键查询PointLog
        PointLog pointLog = pointLogService.findById(id);
        return new Result<PointLog>(true,StatusCode.OK,"查询成功",pointLog);
    }
    /***
     * 查询PointLog全部数据
     * @return
     */
    @ApiOperation(value = "查询所有PointLog",notes = "查询所PointLog有方法详情",tags = {"PointLogController"})
    @GetMapping
    public Result<List<PointLog>> findAll(){
        //调用PointLogService实现查询所有PointLog
        List<PointLog> list = pointLogService.findAll();
        return new Result<List<PointLog>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
