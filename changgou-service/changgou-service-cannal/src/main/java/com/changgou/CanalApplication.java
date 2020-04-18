package com.changgou;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/18
 *
 * @author Lenovo
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCanalClient
@EnableEurekaClient
public class CanalApplication {
    /**
     * 启动类
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }
}
