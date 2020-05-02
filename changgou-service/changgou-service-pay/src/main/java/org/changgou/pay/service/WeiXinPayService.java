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
}
