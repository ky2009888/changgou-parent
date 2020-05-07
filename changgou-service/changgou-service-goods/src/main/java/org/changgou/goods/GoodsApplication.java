package org.changgou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/6
 * 备注：
 * tk.mybatis.spring.annotation.MapperScan  @MapperScan
 * @author Lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"org.changgou.goods.dao"})
@EnableFeignClients
public class GoodsApplication {
    /**
     * 入口方法
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
