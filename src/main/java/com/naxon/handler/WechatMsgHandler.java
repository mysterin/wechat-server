package com.naxon.handler;

import com.naxon.tool.wechat.model.WechatMsgModel;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/24 18:01
 */
public interface WechatMsgHandler {

    String handle(WechatMsgModel wechatMsgModel);
}
