package com.naxon.handler;

import com.naxon.tool.wechat.constant.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/24 18:03
 */
@Component
public class WechatMsgHandlerFactory {
    @Autowired
    private WechatTextMsgHandler wechatTextMsgHandler;

    public WechatMsgHandler getHandler(String type) {
        MsgType msgType = MsgType.valueOf(type.toUpperCase());
        switch (msgType) {
            case TEXT:
                return wechatTextMsgHandler;
            default:
                return null;
        }
    }
}
