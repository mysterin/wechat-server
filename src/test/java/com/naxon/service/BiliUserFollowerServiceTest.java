package com.naxon.service;

import com.naxon.dao.entity.BiliUserFollower;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author linxiaobin
 * @Description
 * @date 2021/2/20 16:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BiliUserFollowerServiceTest {

    @Autowired
    private BiliUserFollowerService biliUserFollowerService;

    @Test
    public void crawlBiliUserFollower() {
        Long userId = 777536L;
        BiliUserFollower biliUserFollower = biliUserFollowerService.crawlBiliUserFollower(userId);
        log.info(biliUserFollower.toString());
    }

    @Test
    public void saveBiliUserFollower() {
        Long userId = 777536L;
        BiliUserFollower biliUserFollower = biliUserFollowerService.crawlBiliUserFollower(userId);
        biliUserFollowerService.saveBiliUserFollower(biliUserFollower);
    }
}