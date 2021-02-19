package com.nexon.config;

import com.naxon.tool.http.OkHttpClientFactory;
import com.naxon.tool.http.OkHttpExecutor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/19 14:16
 */
@Configuration
public class HttpConfig {

    @Bean
    public OkHttpClientFactory okHttpClientFactory() {
        return new OkHttpClientFactory();
    }

    @Bean
    public OkHttpExecutor okHttpExecutor() {
        OkHttpExecutor okHttpExecutor = new OkHttpExecutor(okHttpClientFactory());
        return okHttpExecutor;
    }
}
