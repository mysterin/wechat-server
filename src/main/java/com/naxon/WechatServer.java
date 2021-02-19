package com.naxon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/19 18:56
 */
@SpringBootApplication
@MapperScan("com.naxon.dao.mapper")
public class WechatServer {
    public static void main(String[] args) {
        SpringApplication.run(WechatServer.class, args);
    }
}
