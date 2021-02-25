package com.naxon.service;

import com.naxon.handler.WechatMsgHandler;
import com.naxon.handler.WechatMsgHandlerFactory;
import com.naxon.tool.wechat.model.WechatMsgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/22 18:10
 */
@Service
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
        String response = handler.handle(wechatMsgModel);
        return response;
    }

}
