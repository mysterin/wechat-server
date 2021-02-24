package com.naxon.controller;

import com.naxon.config.ApplicationWechatConfig;
import com.naxon.handler.WechatMsgHandler;
import com.naxon.handler.WechatMsgHandlerFactory;
import com.naxon.service.WechatAppService;
import com.naxon.tool.common.NaxonUtil;
import com.naxon.tool.wechat.WechatUtil;
import com.naxon.tool.wechat.aes.AesException;
import com.naxon.tool.wechat.aes.WXBizMsgCrypt;
import com.naxon.tool.wechat.model.WechatMsgModel;
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
    @Autowired
    private WechatAppService wechatAppService;

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
        try {
            log.debug("token={}, signature={}, timestamp={}, nonce={}, echostr={}", token, signature, timestamp, nonce, echostr);
            boolean result = WechatUtil.checkSignature(token, signature, timestamp, nonce);
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
        try {
            String token = applicationWechatConfig.getToken();
            String aesKey = applicationWechatConfig.getAesKey();
            String appId = applicationWechatConfig.getAppId();
            WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, aesKey, appId);
            String decryptMsg = wxBizMsgCrypt.decryptMsg(msg_signature, timestamp, nonce, msg);
            log.debug("timestamp={}, nonce={}, encrypt_type={}, msg_signature={}, decryptMsg={}", timestamp, nonce, encrypt_type, msg_signature, decryptMsg);

            WechatMsgModel wechatMsgModel = WechatUtil.parseXmlMsg(decryptMsg);
            String response = wechatAppService.handle(wechatMsgModel);
            log.debug("response={}", response);
            if (NaxonUtil.isNotEmpty(response)) {
                return response;
            }

        } catch (Exception e) {
            log.error("处理微信消息异常", e);
        }
        return "success";
    }
}
