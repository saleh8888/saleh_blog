/*
 Navicat Premium Data Transfer

 Source Server         : saleh
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 03/03/2022 22:02:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for m_blog
-- ----------------------------
DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `created` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `status` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog` VALUES (7, 1, 'aaaaaaaa', 'aaaaaaaaaaaaa', 'asdasdsadsadasdsad', '2022-03-03 20:37:04', 0);
INSERT INTO `m_blog` VALUES (8, 1, 'asdasdasdasdasdsad', 'asdaaaaaaaaaaaaaaaaaaaaa', 'asssssssssssssssssssss', '2022-03-03 20:38:14', 0);
INSERT INTO `m_blog` VALUES (9, 1, '这是一条博客的标题', '这是一条博客的描述', '这是一条博客的内容', '2022-03-03 20:38:44', 0);

-- ----------------------------
-- Table structure for m_log
-- ----------------------------
DROP TABLE IF EXISTS `m_log`;
CREATE TABLE `m_log`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `log_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `operation_status` int(4) NULL DEFAULT NULL,
  `blog_title` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `operation_type` int(4) NULL DEFAULT NULL COMMENT '操作类型,1,新增,2,编辑,3,删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_log
-- ----------------------------
INSERT INTO `m_log` VALUES (5, 'admin', '2022-03-03 20:37:04', 1, 'aaaaaaaa', 1);
INSERT INTO `m_log` VALUES (6, 'admin', '2022-03-03 20:38:14', 1, 'asdasdasdasdasdsad', 1);

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(5) NOT NULL,
  `created` datetime(0) NULL DEFAULT NULL,
  `last_login` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `UK_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES (1, 'myblog', 'http://image-1300566513.jpg', NULL, 'e10adc3949ba59abbe56e057f20f883e', 0, '2020-04-20 10:44:01', NULL);

SET FOREIGN_KEY_CHECKS = 1;
