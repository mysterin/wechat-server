/*
 Navicat Premium Data Transfer

 Source Server         : qlchat-test
 Source Server Type    : MySQL
 Source Server Version : 50081
 Source Host           : 211.159.219.193:3306
 Source Schema         : test_nexon

 Target Server Type    : MySQL
 Target Server Version : 50081
 File Encoding         : 65001

 Date: 07/02/2021 16:14:04
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wechat_app_config
-- ----------------------------
DROP TABLE IF EXISTS `wechat_app_config`;
CREATE TABLE `wechat_app_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `app_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'APPID',
  `app_secret` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'APPSECRET',
  `app_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公众号名称',
  `app_type` enum('subscribe','service') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公众号类型，subscribe-订阅号，service-服务号',
  `token` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用接口凭证',
  `expires_in` datetime NULL DEFAULT NULL COMMENT 'token 过期时间',
  `gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE INDEX `uk_app_id` USING BTREE(`app_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wechat_user_info
-- ----------------------------
DROP TABLE IF EXISTS `wechat_user_info`;
CREATE TABLE `wechat_user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `app_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'APPID',
  `openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的标识',
  `unionid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'unionid',
  `subscribe` int(11) NULL DEFAULT NULL COMMENT '是否订阅该公众号，0-未关注，1-关注',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的昵称',
  `sex` int(11) NULL DEFAULT NULL COMMENT '用户的性别，1-男，2-女，0-未知',
  `language` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的语言',
  `city` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户所在城市',
  `province` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户所在省份',
  `country` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户所在国家',
  `headimgurl` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `subscribe_time` datetime NULL DEFAULT NULL COMMENT '用户关注时间',
  `remark` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公众号运营者对粉丝的备注',
  `groupid` int(11) NULL DEFAULT NULL COMMENT '用户所在的分组 ID',
  `tagid_list` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户被打上的标签 ID 列表',
  `subscribe_scene` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回用户关注的渠道来源，ADD_SCENE_SEARCH-公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION-公众号迁移，ADD_SCENE_PROFILE_CARD-名片分享，ADD_SCENE_QR_CODE-扫描二维码，ADD_SCENE_PROFILE_LINK-图文页内名称点击，ADD_SCENE_PROFILE_ITEM-图文页右上角菜单，ADD_SCENE_PAID-支付后关注，ADD_SCENE_WECHAT_ADVERTISEMENT-微信广告，ADD_SCENE_OTHERS-其他',
  `qr_scene` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '二维码扫码场景',
  `qr_scene_str` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '二维码扫码场景描述',
  PRIMARY KEY USING BTREE (`id`),
  UNIQUE INDEX `uk_app_user` USING BTREE(`app_id`, `openid`),
  INDEX `idx_openid` USING BTREE(`openid`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
