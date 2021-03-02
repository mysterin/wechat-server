package com.naxon.handler.wechat.keyword;

import com.naxon.tool.wechat.model.WechatMsgModel;
import com.naxon.tool.wechat.model.WechatReplyMsgModel;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/26 16:02
 */
public interface KeywordHandler {
    /**
     * 关键字处理
     * @param wechatMsgModel
     * @return
     */
    WechatReplyMsgModel handleKeyword(WechatMsgModel wechatMsgModel);
}
