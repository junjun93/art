package com.junjun.art.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author junjun
 * @date 2019-02-27 11:08:27
 **/
@EnableTransactionManagement
@Configuration
public class MPConfig {

    /**
     * 分页插件 分页拦截器
     * */
    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();
    }

    /**
     * 打印 sql
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {

        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //格式化sql语句
        Properties properties = new Properties();
        properties.setProperty("format", "false");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }
}
