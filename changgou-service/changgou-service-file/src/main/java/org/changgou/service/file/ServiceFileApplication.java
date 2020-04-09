package org.changgou.service.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/9
 * 排查数据库自动加载exclude = DataSourceAutoConfiguration.class
 *
 * @author Lenovo
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class ServiceFileApplication {
    /**
     * 入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(ServiceFileApplication.class, args);
    }
}
