package com.naxon.handler.wechat;

import com.naxon.handler.wechat.keyword.KeywordHandler;
import com.naxon.handler.wechat.keyword.KeywordHandlerFactory;
import com.naxon.tool.wechat.constant.MsgType;
import com.naxon.tool.wechat.model.WechatMsgModel;
import com.naxon.tool.wechat.model.WechatReplyMsgModel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linxiaobin
 * @Description 文本消息类型处理器
 * @date 2021/2/24 18:02
 */
@Component
public class TextMsgTypeHandler implements MsgTypeHandler, InitializingBean {

    @Autowired
    private MsgTypeHandlerFactory msgTypeHandlerFactory;
    @Autowired
    private KeywordHandlerFactory keywordHandlerFactory;

    /**
     * 注册到工厂
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        msgTypeHandlerFactory.registerHandler(MsgType.TEXT, this);
    }

    /**
     * 处理消息
     * @param wechatMsgModel
     * @return
     */
    @Override
    public String handle(WechatMsgModel wechatMsgModel) {
        String content = wechatMsgModel.getContent();
        KeywordHandler handler = keywordHandlerFactory.getHandler(content);
        if (handler != null) {
            WechatReplyMsgModel wechatReplyMsgModel = handler.handleKeyword(wechatMsgModel);
            String response = wechatReplyMsgModel.replyXmlMsg();
            return response;
        }
        return null;
    }

}
