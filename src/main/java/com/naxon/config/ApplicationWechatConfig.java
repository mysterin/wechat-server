package com.naxon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/22 18:15
 */
@Component
@ConfigurationProperties(prefix = "application.wechat")
@Data
public class ApplicationWechatConfig {
    private String token;
    private String aesKey;
    private String ghId;
    private String appId;
    private String appSecret;
}
