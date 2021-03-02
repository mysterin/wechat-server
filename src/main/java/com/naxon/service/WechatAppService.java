package com.naxon.service;

import com.naxon.handler.wechat.MsgTypeHandler;
import com.naxon.handler.wechat.MsgTypeHandlerFactory;
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
    private MsgTypeHandlerFactory msgTypeHandlerFactory;

    /**
     * 处理微信信息
     * @param wechatMsgModel
     */
    public String handle(WechatMsgModel wechatMsgModel) {
        String msgType = wechatMsgModel.getMsgType();
        // 获取对应消息处理器
        MsgTypeHandler msgTypeHandler = msgTypeHandlerFactory.getHandler(msgType);
        if (msgTypeHandler == null) {
            log.info("没有该类型消息的处理器，msgType={}", msgType);
            return null;
        }
        String response = msgTypeHandler.handle(wechatMsgModel);
        return response;
    }

}
