package org.changgou.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/4/20
 *
 * @author Lenovo
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"org.changgou.goods.feign"})
@EnableElasticsearchRepositories(basePackages = {"org.changgou.search.dao"})
@Slf4j
public class ElasticSearchApplication {
    /**
     * 命令行入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        /**
         * 解决netty报错
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    /**
     * 实例化
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
