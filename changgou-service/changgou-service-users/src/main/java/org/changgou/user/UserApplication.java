package org.changgou.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/29
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
@MapperScan(basePackages = {"org.changgou.user.dao"})
public class UserApplication {
    /**
     * 启动方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
