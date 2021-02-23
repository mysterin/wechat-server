package com.naxon.controller;

import com.naxon.config.ApplicationWechatConfig;
import com.naxon.tool.wechat.aes.AesException;
import com.naxon.tool.wechat.aes.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/22 18:29
 */
@RestController
@RequestMapping("/wechat-server")
@Slf4j
public class WechatServerController {

    @Autowired
    private ApplicationWechatConfig applicationWechatConfig;

    /**
     * 接入服务器
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return
     */
    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String doGet(String signature, String timestamp, String nonce, String echostr) {
        String token = applicationWechatConfig.getToken();
        Boolean result = null;
        try {
            result = WXBizMsgCrypt.checkSignature(token, signature, timestamp, nonce);
            if (result) {
                return echostr;
            }
        } catch (AesException e) {
            log.error("接入服务器异常", e);
        }
        return "fail";
    }

    /**
     * 处理微信服务器推送过来的消息
     * @return
     */
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public String doPost(String timestamp, String nonce, String encrypt_type, String msg_signature, @RequestBody String msg) {
        return "success";
    }
}
