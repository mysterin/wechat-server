package com.naxon.handler;

import com.naxon.tool.wechat.constant.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/24 18:03
 */
@Component
public class WechatMsgHandlerFactory {

    private Map<MsgType, WechatMsgHandler> handlerMap = new HashMap<>();

    @Autowired
    private WechatTextMsgHandler wechatTextMsgHandler;

    public WechatMsgHandler getHandler(String type) {
        MsgType msgType = MsgType.valueOf(type.toUpperCase());
        return handlerMap.get(msgType);
    }

    public WechatMsgHandler getHandler(MsgType msgType) {
        return handlerMap.get(msgType);
    }

    /**
     * 注册处理器
     * @param msgType
     * @param handler
     */
    public void registerHandler(MsgType msgType, WechatMsgHandler handler) {
        Assert.notNull(msgType, "msgType 不可为空");
        handlerMap.put(msgType, handler);
    }
}
