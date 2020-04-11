package org.changgou.goods.controller;

import com.changgou.utils.PageResult;
import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import com.github.pagehelper.Page;
import org.changgou.goods.pojo.Para;
import org.changgou.goods.service.ParaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 */
@RestController
@CrossOrigin
@RequestMapping("/para")
public class ParaController {

    /**
     * 定义参数服务类的句柄
     */
    @Resource
    private ParaService paraService;

    /**
     * 查询全部数据
     *
     * @return Result
     */
    @GetMapping
    public Result findAll() {
        List<Para> paraList = paraService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", paraList);
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Para para = paraService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", para);
    }


    /***
     * 新增数据
     * @param para
     * @return Result
     */
    @PostMapping
    public Result add(@RequestBody Para para) {
        paraService.add(para);
        return new Result(true, StatusCode.OK, "添加成功");
    }


    /***
     * 修改数据
     * @param para
     * @param id
     * @return Result
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Para para, @PathVariable Integer id) {
        para.setId(id);
        paraService.update(para);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return Result
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        paraService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return Result
     */
    @GetMapping(value = "/search")
    public Result findList(@RequestParam Map searchMap) {
        List<Para> list = paraService.findList(searchMap);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return Result
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result findPage(@RequestParam Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Para> pageList = paraService.findPage(searchMap, page, size);
        PageResult pageResult = new PageResult(pageList.getTotal(), pageList.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

}
