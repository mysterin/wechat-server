package com.naxon.handler.keyword;

import com.naxon.tool.wechat.model.WechatMsgModel;
import com.naxon.tool.wechat.model.WechatReplyMsgModel;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/26 16:02
 */
public interface KeywordHandler {
    WechatReplyMsgModel handleKeyword(WechatMsgModel wechatMsgModel);
}
