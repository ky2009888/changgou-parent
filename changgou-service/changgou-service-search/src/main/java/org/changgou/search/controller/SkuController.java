package org.changgou.search.controller;

import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import org.apache.logging.log4j.status.StatusData;
import org.changgou.search.service.SkuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/23
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("sku")
public class SkuController {
    /**
     * 定义Sku的service句柄.
     */
    @Resource
    private SkuService skuService;

    /**
     * 根据关键字搜索
     *
     * @param searchParam 搜索参数
     * @return Result搜索结果
     */
    @GetMapping("search")
    public Result search(@RequestParam(required = false) Map<String, String> searchParam) {
        Map<String, Object> search = skuService.search(searchParam);
        return new Result(true, StatusCode.OK, "查询成功", search);
    }

    /**
     * 将数据导入到ES索引库
     *
     * @return SUCCESS
     */
    @GetMapping("importData")
    public Result importDataToEs() {
        skuService.importSkuDataToDB();
        return new Result(true, StatusCode.OK, "SUCCESS");
    }
}
