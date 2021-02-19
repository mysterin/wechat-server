package com.naxon.service;

import com.alibaba.fastjson.JSONObject;
import com.naxon.dao.entity.BiliUserFollower;
import com.naxon.tool.common.JsonUtils;
import com.naxon.tool.http.OkHttpExecutor;
import com.naxon.dao.mapper.BiliUserFollowerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/11 1:04
 */
@Service
@Slf4j
public class BiliUserFollowerService {

    private static final String BILI_USER_FOLLOWER_URL = "https://api.bilibili.com/x/relation/stat?vmid={0}&spm_id_from=333.788.b_636f6d6d656e74.111";

    @Autowired
    private OkHttpExecutor okHttpExecutor;
    @Autowired
    private BiliUserFollowerMapper biliUserFollowerMapper;

    /**
     * 抓取哔哩用户关注数
     * @param userId
     * @return
     */
    public BiliUserFollower crawlBiliUserFollower(Long userId) {
        try {
            String url = MessageFormat.format(BILI_USER_FOLLOWER_URL, userId.toString());
            String response = okHttpExecutor.syncGet(url);
            JSONObject json = JsonUtils.parseJson(response);
            String data = json.getString("data");
            BiliUserFollower biliUserFollower = JsonUtils.parseJson(data, BiliUserFollower.class);
            return biliUserFollower;
        } catch (Exception e) {
            log.error("获取哔哩用户关注数异常", e);
        }
        return null;
    }

    /**
     * 保存哔哩用户关注信息
     * @param biliUserFollower
     */
    public void saveBiliUserFollower(BiliUserFollower biliUserFollower) {
        biliUserFollowerMapper.insert(biliUserFollower);
    }

    /**
     * 获取哔哩用户列表，根据时间查询
     * @param starttime
     * @param endtime
     * @return
     */
    public List<BiliUserFollower> listByTime(Date starttime, Date endtime) {
        return null;
    }
}
