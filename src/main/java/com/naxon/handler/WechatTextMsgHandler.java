package com.naxon.handler;

import com.naxon.tool.wechat.WechatUtil;
import com.naxon.tool.wechat.model.WechatMsgModel;
import org.springframework.stereotype.Component;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/24 18:02
 */
@Component
public class WechatTextMsgHandler implements WechatMsgHandler {

    @Override
    public String handle(WechatMsgModel wechatMsgModel) {
        String fromUserName = wechatMsgModel.getFromUserName();
        String toUserName = wechatMsgModel.getToUserName();
        String content = wechatMsgModel.getCreateTime();
        String response = WechatUtil.replyText(fromUserName, toUserName, content);
        return response;
    }
}
