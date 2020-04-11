package org.changgou.goods.controller;

import com.changgou.utils.PageResult;
import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import com.github.pagehelper.Page;
import org.changgou.goods.pojo.Pref;
import org.changgou.goods.service.PrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 */
@RestController
@CrossOrigin
@RequestMapping("/pref")
public class PrefController {

    /**
     * 定义Pref服务类的句柄
     */
    @Resource
    private PrefService prefService;

    /**
     * 查询全部数据
     *
     * @return Result
     */
    @GetMapping
    public Result findAll() {
        List<Pref> prefList = prefService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", prefList);
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Pref pref = prefService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", pref);
    }


    /***
     * 新增数据
     * @param pref
     * @return Result
     */
    @PostMapping
    public Result add(@RequestBody Pref pref) {
        prefService.add(pref);
        return new Result(true, StatusCode.OK, "添加成功");
    }


    /***
     * 修改数据
     * @param pref
     * @param id
     * @return Result
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Pref pref, @PathVariable Integer id) {
        pref.setId(id);
        prefService.update(pref);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return Result
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        prefService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return Result
     */
    @GetMapping(value = "/search")
    public Result findList(@RequestParam Map searchMap) {
        List<Pref> list = prefService.findList(searchMap);
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
        Page<Pref> pageList = prefService.findPage(searchMap, page, size);
        PageResult pageResult = new PageResult(pageList.getTotal(), pageList.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


}
