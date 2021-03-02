package com.naxon.handler.wechat;

import com.naxon.tool.wechat.constant.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaobin
 * @Description 消息类型处理器的注册工厂
 * @date 2021/2/24 18:03
 */
@Component
public class MsgTypeHandlerFactory {

    private Map<MsgType, MsgTypeHandler> handlerMap = new HashMap<>();

    @Autowired
    private TextMsgTypeHandler wechatTextMsgHandler;

    public MsgTypeHandler getHandler(String type) {
        MsgType msgType = MsgType.valueOf(type.toUpperCase());
        return handlerMap.get(msgType);
    }

    public MsgTypeHandler getHandler(MsgType msgType) {
        return handlerMap.get(msgType);
    }

    /**
     * 注册处理器
     * @param msgType
     * @param handler
     */
    public void registerHandler(MsgType msgType, MsgTypeHandler handler) {
        Assert.notNull(msgType, "msgType 不可为空");
        handlerMap.put(msgType, handler);
    }
}
