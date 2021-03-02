package com.naxon.handler.wechat.keyword;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/26 16:02
 */
public class KeywordHandlerFactory {

    private Map<String,KeywordHandler> handlerMap = new HashMap<>();

    /**
     * 获取关键字处理器
     * @param keyword
     * @return
     */
    public KeywordHandler getHandler(String keyword) {
        KeywordHandler keywordHandler = handlerMap.get(keyword);
        return keywordHandler;
    }

    /**
     * 注册关键字处理器
     * @param keyword
     * @param keywordHandler
     */
    public void registerHandler(String keyword, KeywordHandler keywordHandler) {
        Assert.notNull(keyword, "keyword 不允许为空");
        handlerMap.put(keyword, keywordHandler);
    }
}
