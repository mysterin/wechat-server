package com.naxon.handler.wechat.keyword;

import com.naxon.tool.wechat.WechatMsgUtil;
import com.naxon.tool.wechat.model.WechatMsgModel;
import com.naxon.tool.wechat.model.WechatReplyMsgModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linxiaobin
 * @Description 默认的关键字处理器
 * @date 2021/3/1 10:09
 */
@Component
@Slf4j
public class DefaultKeywordHandler implements KeywordHandler {

    @Override
    public WechatReplyMsgModel handleKeyword(WechatMsgModel wechatMsgModel) {
        String content = wechatMsgModel.getContent();
        WechatReplyMsgModel wechatReplyMsgModel = WechatMsgUtil.replyText(wechatMsgModel, content);
        return wechatReplyMsgModel;
    }
}
