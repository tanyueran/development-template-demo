/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : red-packet

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 31/01/2020 16:01:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for button_table
-- ----------------------------
DROP TABLE IF EXISTS `button_table`;
CREATE TABLE `button_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `buttonCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '按钮的code值',
  `buttonName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '按钮的名称',
  `menu_id` int(11) NOT NULL COMMENT '外键，所属菜单的id',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '按钮说明备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `按钮code值`(`buttonCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu_table
-- ----------------------------
DROP TABLE IF EXISTS `menu_table`;
CREATE TABLE `menu_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `menuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '菜单的名称',
  `menuCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '菜单的code',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `菜单code值`(`menuCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for privilege_table
-- ----------------------------
DROP TABLE IF EXISTS `privilege_table`;
CREATE TABLE `privilege_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `master` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '仅仅为:user、role',
  `masterId` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '外键、为userId或者roleId',
  `access` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '仅仅为：menu、button',
  `accessId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '外键、为menuId、或则buttonId',
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用于开闭单个用户的功能，默认为true，',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '中间表，将user、role 和 menu相关联起来。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for red_packet_detail_table
-- ----------------------------
DROP TABLE IF EXISTS `red_packet_detail_table`;
CREATE TABLE `red_packet_detail_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `packet_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '红包的主键id',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '领取人id',
  `amout` double(255, 2) NOT NULL COMMENT '领取的金额值',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '领取时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for red_packet_table
-- ----------------------------
DROP TABLE IF EXISTS `red_packet_table`;
CREATE TABLE `red_packet_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '外键，红包发送人id',
  `totalNum` int(100) NOT NULL COMMENT '红包总数',
  `restNum` int(100) NOT NULL COMMENT '红包剩余个数',
  `totalAmount` double(255, 2) NOT NULL COMMENT '红包金额',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '红包备注',
  `version` int(11) NOT NULL COMMENT '版本，乐观锁',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_table
-- ----------------------------
DROP TABLE IF EXISTS `role_table`;
CREATE TABLE `role_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `roleCode` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色code值',
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名称',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '说明、备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `roleCode`(`roleCode`) USING BTREE COMMENT '角色的code唯一'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role_table
-- ----------------------------
DROP TABLE IF EXISTS `user_role_table`;
CREATE TABLE `user_role_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '外键，用户的id',
  `role_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '外键，角色的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `userCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `用户的账号`(`userCode`) USING BTREE COMMENT '用户账号唯一'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1217731265990627328', 'user01', 'password', '大象', '2020-01-16 16:52:20');
INSERT INTO `user_table` VALUES ('1218766540724375552', 'user02', 'password', '张三', '2020-01-19 13:32:36');
INSERT INTO `user_table` VALUES ('1218768250045861888', 'user03', 'password', '李四', '2020-01-19 13:33:03');
INSERT INTO `user_table` VALUES ('1218769019004391424', 'user04', 'password', '李四2', '2020-01-19 13:45:32');

SET FOREIGN_KEY_CHECKS = 1;
