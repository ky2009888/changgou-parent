package org.changgou.pay.service;

import java.util.Map;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/5/2
 *
 * @author Lenovo
 */
public interface WeiXinPayService {
    /**
     * 创建二维码
     *
     * @param paramMap 生成二维码的参数
     * @return Map
     */
    Map createNative(Map<String, String> paramMap) throws Exception;

    /**
     * 进行订单查询
     *
     * @param orderId 订单号
     * @return 订单号
     */
    Map queryOrder(String orderId);

    /**
     * 订单关闭
     *
     * @param orderId 订单号
     * @return 订单号
     */
    Map closeOrder(String orderId);
}
