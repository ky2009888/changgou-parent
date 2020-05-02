package org.changgou.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/5/2
 *
 * @author Lenovo
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
@EnableEurekaClient
public class WeiXinPayApplication {
    /**
     * 微信支付微服务的启动类
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(WeiXinPayApplication.class, args);
    }
}
