package com.naxon.service;

import com.naxon.handler.wechat.WechatMsgHandler;
import com.naxon.handler.wechat.WechatMsgHandlerFactory;
import com.naxon.tool.wechat.model.WechatMsgModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/22 18:10
 */
@Service
@Slf4j
public class WechatAppService {

    @Autowired
    private WechatMsgHandlerFactory wechatMsgHandlerFactory;

    /**
     * 处理微信信息
     * @param wechatMsgModel
     */
    public String handle(WechatMsgModel wechatMsgModel) {
        String msgType = wechatMsgModel.getMsgType();
        // 获取对应消息处理器
        WechatMsgHandler handler = wechatMsgHandlerFactory.getHandler(msgType);
        if (handler == null) {
            log.info("没有该类型消息的处理器，msgType={}", msgType);
            return null;
        }
        String response = handler.handle(wechatMsgModel);
        return response;
    }

}
