package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/6
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableEurekaServer
public class EreakaApplication {
    /**
     * 入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(EreakaApplication.class, args);
    }
}
