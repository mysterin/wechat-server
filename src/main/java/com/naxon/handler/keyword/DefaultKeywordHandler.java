package com.naxon.handler.keyword;

import com.naxon.tool.wechat.model.WechatMsgModel;
import com.naxon.tool.wechat.model.WechatReplyMsgModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author linxiaobin
 * @Description 默认的关键字处理器
 * @date 2021/3/1 10:09
 */
@Slf4j
public class DefaultKeywordHandler implements KeywordHandler {

    @Override
    public WechatReplyMsgModel handleKeyword(WechatMsgModel wechatMsgModel) {
        String content = wechatMsgModel.getContent();
        return null;
    }
}
