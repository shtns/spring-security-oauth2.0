/*
 Navicat Premium Data Transfer

 Source Server         : 115.159.0.240
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 115.159.0.240:3306
 Source Schema         : db_security

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 19/01/2021 23:49:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父菜单id',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `access_path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问路径',
  `sort` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排序值（默认为1）',
  `del_flag` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志位 0 未删 1 已删',
  `creation_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（由数据库控制）',
  `last_modify_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间（由数据库控制）',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '前台菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES (1, -1, '首页', '/menu/home_page', '1', '0', '2020-04-10 17:52:21', '2021-01-18 14:46:26');
INSERT INTO `menu_info` VALUES (2, -1, '行程预定', '/menu/travel_booking', '2', '0', '2020-04-10 17:53:21', '2021-01-17 23:37:26');
INSERT INTO `menu_info` VALUES (3, 2, '国内机票', '/menu/domestic_air_tickets', '1', '0', '2020-04-10 17:53:42', '2021-01-17 23:37:28');
INSERT INTO `menu_info` VALUES (4, 2, '国际机票', '/menu/international_air_ticket', '2', '0', '2020-04-10 17:54:03', '2021-01-17 23:37:29');
INSERT INTO `menu_info` VALUES (5, 2, '酒店预订', '/menu/hotel_reservation', '3', '0', '2020-04-10 17:54:16', '2021-01-17 23:37:31');
INSERT INTO `menu_info` VALUES (6, 2, '火车票', '/menu/train_ticket', '4', '0', '2020-04-10 17:54:51', '2021-01-17 23:37:33');
INSERT INTO `menu_info` VALUES (7, -1, '我的申请', '/menu/my_application', '3', '0', '2020-04-10 17:55:02', '2021-01-17 23:37:35');
INSERT INTO `menu_info` VALUES (8, -1, '我的审批', '/menu/my_approval', '4', '0', '2020-04-10 17:55:37', '2021-01-17 23:37:37');
INSERT INTO `menu_info` VALUES (9, -1, '我的订单', '/menu/my_order', '5', '0', '2020-04-10 17:55:43', '2021-01-17 23:37:38');
INSERT INTO `menu_info` VALUES (10, -1, '我的行程', '/menu/my_itinerary', '6', '0', '2020-07-30 17:20:55', '2021-01-17 23:37:44');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_name_en` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色英文名称',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色备注',
  `del_flag` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志位 0 未删 1 已删',
  `creation_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（由数据库控制）',
  `last_modify_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间（由数据库控制）',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '前台角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, '管理员', 'admin', NULL, '0', '2021-01-17 12:03:33', '2021-01-17 12:03:33');
INSERT INTO `role_info` VALUES (2, '测试', 'test', NULL, '0', '2021-01-17 12:04:15', '2021-01-17 12:04:15');

-- ----------------------------
-- Table structure for role_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_info`;
CREATE TABLE `role_menu_info`  (
  `role_id` bigint NOT NULL COMMENT '角色id',
  `menu_id` bigint NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '前台角色菜单关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_menu_info
-- ----------------------------
INSERT INTO `role_menu_info` VALUES (1, 1);
INSERT INTO `role_menu_info` VALUES (1, 2);
INSERT INTO `role_menu_info` VALUES (1, 3);
INSERT INTO `role_menu_info` VALUES (1, 4);
INSERT INTO `role_menu_info` VALUES (1, 5);
INSERT INTO `role_menu_info` VALUES (1, 6);
INSERT INTO `role_menu_info` VALUES (1, 7);
INSERT INTO `role_menu_info` VALUES (1, 8);
INSERT INTO `role_menu_info` VALUES (1, 9);
INSERT INTO `role_menu_info` VALUES (1, 10);
INSERT INTO `role_menu_info` VALUES (2, 2);
INSERT INTO `role_menu_info` VALUES (2, 3);
INSERT INTO `role_menu_info` VALUES (2, 4);
INSERT INTO `role_menu_info` VALUES (2, 5);
INSERT INTO `role_menu_info` VALUES (2, 6);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `login_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登入账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '状态（0 正常 1 锁定）',
  `name_cn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称中文',
  `name_en` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称英文',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '住址',
  `del_flag` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志位 （0 未删 1 已删)',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（由数据库控制）',
  `last_modify_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间（由数据库控制）',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 1, 'zhangsan', '$2a$10$eDV4qt/FZopPNTvkTxSvyuizXcSXgRAlBrfaChpN1tQnZ9lEEwjYS', '0', '张三', 'zs', '131517252', '广东广州', '0', '2021-01-08 08:38:49', '2021-01-08 08:38:49');
INSERT INTO `user_info` VALUES (2, 2, 'list', '$2a$10$5EYhjbB/4cyTRodyN7n0neAtci0VTIXlJ1dwoqivevpSu.337WF6a', '0', '李四', 'ls', '131517252', '广东广州', '0', '2021-01-08 09:44:11', '2021-01-08 09:44:11');

SET FOREIGN_KEY_CHECKS = 1;
