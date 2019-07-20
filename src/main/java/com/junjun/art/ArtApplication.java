package com.junjun.art;

/**
 * @author junjun
 * @since 2019/7/18 10:24:30
 **/
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.junjun.art.common",
        "com.junjun.art.controller",
        "com.junjun.art.service",
})
@MapperScan("com.junjun.art.mapper")
public class ArtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtApplication.class, args);
    }

}
