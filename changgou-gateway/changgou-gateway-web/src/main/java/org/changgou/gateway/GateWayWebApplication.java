package org.changgou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/25
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayWebApplication.class,args);
    }
}
