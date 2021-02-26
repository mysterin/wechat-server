package com.naxon.handler;

import com.naxon.tool.wechat.WechatUtil;
import com.naxon.tool.wechat.constant.MsgType;
import com.naxon.tool.wechat.model.WechatMsgModel;
import com.naxon.tool.wechat.model.WechatReplayMsgModel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/24 18:02
 */
@Component
public class WechatTextMsgHandler implements WechatMsgHandler, InitializingBean {

    @Autowired
    private WechatMsgHandlerFactory wechatMsgHandlerFactory;

    /**
     * 注册到工厂
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        wechatMsgHandlerFactory.registerHandler(MsgType.TEXT, this);
    }

    /**
     * 处理消息
     * @param wechatMsgModel
     * @return
     */
    @Override
    public String handle(WechatMsgModel wechatMsgModel) {
        String fromUserName = wechatMsgModel.getFromUserName();
        String toUserName = wechatMsgModel.getToUserName();
        String content = wechatMsgModel.getCreateTime();
        String response = WechatUtil.replyText(fromUserName, toUserName, content);
        return response;
    }

}
