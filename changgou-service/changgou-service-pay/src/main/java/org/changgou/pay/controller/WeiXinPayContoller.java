package org.changgou.pay.controller;

import cn.hutool.core.map.MapUtil;
import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import org.changgou.pay.service.WeiXinPayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/5/2
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("wx")
public class WeiXinPayContoller {
    /**
     * 自动注入weiXinPayService实例
     */
    @Resource
    private WeiXinPayService weiXinPayService;

    /**
     * 微信支付生成二维码
     *
     * @return
     */
    @PostMapping("pay")
    public Result<Map<String, String>> generateCode(String orderNum, String money) throws Exception {
        Map<String, String> param = MapUtil.newHashMap();
        param.put("orderNum", orderNum);
        param.put("totalFee", money);
        Map map = weiXinPayService.createNative(param);
        return new Result<Map<String, String>>(true, StatusCode.OK, "获取的二维码", map);
    }
}
