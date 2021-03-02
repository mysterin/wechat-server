package com.naxon.handler.wechat;

import com.naxon.tool.wechat.model.WechatMsgModel;

/**
 * @author linxiaobin
 * @Description 消息类型处理器接口
 * @date 2021/2/24 18:01
 */
public interface MsgTypeHandler {

    String handle(WechatMsgModel wechatMsgModel);
}
