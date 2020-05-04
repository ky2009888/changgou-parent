package org.changgou.pay.controller;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.changgou.utils.ConvertUtils;
import com.changgou.utils.Result;
import com.changgou.utils.StatusCode;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.changgou.pay.mq.RabbitMqConfig;
import org.changgou.pay.service.WeiXinPayService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
@Slf4j
public class WeiXinPayContoller {
    /**
     * 自动注入weiXinPayService实例
     */
    @Resource
    private WeiXinPayService weiXinPayService;
    /**
     * 定义消息队列句柄.
     */
    @Resource
    private RabbitTemplate rabbitTemplate;

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

    /**
     * 微信支付生成二维码
     *
     * @return
     */
    @PostMapping("query")
    public Result<Map<String, String>> queryWXPayOrder(String orderNum) throws Exception {
        Map map = weiXinPayService.queryOrder(orderNum);
        return new Result<Map<String, String>>(true, StatusCode.OK, "获取的二维码", map);
    }

    /**
     * 支付回调
     *
     * @param request  请求对象
     * @param response 响应对象
     */
    @RequestMapping("notify")
    public void notifyLogic(HttpServletRequest request, HttpServletResponse response) {
        log.info("支付成功回调");
        try {
            //输入流转换为字符串
            String xml = ConvertUtils.convertToString(request.getInputStream());
            log.info(xml);
            //基于微信发送的通知内容,完成后续的业务逻辑处理
            Map<String, String> map = WXPayUtil.xmlToMap(xml);
            if ("SUCCESS".equals(map.get("result_code"))) {
                //查询订单
                Map result = weiXinPayService.queryOrder(map.get("out_trade_no"));
                log.info("查询订单结果:" + result);
                if ("SUCCESS".equals(result.get("result_code"))) {
                    //将订单的消息发送到mq'
                    Map message = new HashMap();
                    message.put("orderId", result.get("out_trade_no"));
                    message.put("transactionId", result.get("transaction_id"));
                    //消息的发送 TODO
                    rabbitTemplate.convertAndSend("exchange.order", "mq.pay.routing.key", JSON.toJSONString(message));
                    //完成双向通信 TODO
                    //rabbitTemplate.convertAndSend("paynotify", "", result.get("out_trade_no"));
                } else {
                    //输出错误原因
                    log.info(map.get("err_code_des"));
                }

            } else {
                //输出错误原因
                log.info(map.get("err_code_des"));
            }


            //给微信一个结果通知
            response.setContentType("text/xml");
            String data = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
            response.getWriter().write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
