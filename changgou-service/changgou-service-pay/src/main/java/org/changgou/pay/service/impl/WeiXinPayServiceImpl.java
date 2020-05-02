package org.changgou.pay.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.EntityUtils;
import org.changgou.pay.service.WeiXinPayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/**
 * 功能描述:微信支付的公共服务类
 * 项目名称:changgou-parent
 * 创建日期:2020/5/2
 *
 * @author Lenovo
 */
@Service("weiXinPayService")
public class WeiXinPayServiceImpl implements WeiXinPayService {
    /**
     * 应用的ID
     */
    @Value("${weixin.appid}")
    private String appid;
    /**
     * 商户的ID
     */
    @Value("${weixin.partner}")
    private String partner;
    /**
     * 秘钥
     */
    @Value("${weixin.partnerkey}")
    private String partnerkey;
    /**
     * 支付回调地址
     */
    @Value("${weixin.notifyurl}")
    private String notifyurl;

    /**
     * 创建二维码
     *
     * @param paramMap 生成二维码的参数
     * @return Map
     */
    @Override
    public Map createNative(Map<String, String> paramMap) throws Exception {
        Map<String, String> param = MapUtil.newHashMap(32);
        param.put("appid", appid);
        param.put("mch_id", partner);
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        param.put("body", "金灿灿商品");
        param.put("out_trade_no", paramMap.get("orderNum"));
        param.put("total_fee", paramMap.get("totalFee"));
        param.put("spbill_create_ip", "8.8.8.8");
        param.put("notify_url", notifyurl);
        param.put("trade_type", "NATIVE");
        String signedXml = WXPayUtil.generateSignedXml(param, partnerkey);
        //付款二维码的生成地址 WXPayConstants.UNIFIEDORDER_URL
        HttpPost httpPost = new HttpPost(WXPayConstants.UNIFIEDORDER_URL);
        HttpEntity httpEntity = new StringEntity(signedXml);
        httpPost.setEntity(httpEntity);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity responseEntity = httpResponse.getEntity();
        String responseContent = EntityUtils.toString(responseEntity,"UTF-8");
        return WXPayUtil.xmlToMap(responseContent);
    }
}
