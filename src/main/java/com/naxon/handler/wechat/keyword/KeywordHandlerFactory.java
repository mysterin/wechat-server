package com.naxon.handler.wechat.keyword;

import com.naxon.util.SpringHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/26 16:02
 */
@Component
public class KeywordHandlerFactory implements InitializingBean {

    private Map<String,KeywordHandler> handlerMap = new HashMap<>();

    @Autowired
    private DefaultKeywordHandler defaultKeywordHandler;

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

    @Override
    public void afterPropertiesSet() throws Exception {
        // 注册默认处理器
        registerHandler("你好", defaultKeywordHandler);
    }
}
