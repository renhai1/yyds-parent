/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : yygh_order

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 09/02/2022 14:32:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NULL DEFAULT NULL,
  `out_trade_no` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单交易号',
  `hoscode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院编号',
  `hosname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院名称',
  `depcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室编号',
  `depname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生职称',
  `hos_schedule_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排班编号（医院自己的排班主键）',
  `reserve_date` date NULL DEFAULT NULL COMMENT '安排日期',
  `reserve_time` tinyint(3) NULL DEFAULT 0 COMMENT '安排时间（0：上午 1：下午）',
  `patient_id` bigint(20) NULL DEFAULT NULL COMMENT '就诊人id',
  `patient_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊人名称',
  `patient_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊人手机',
  `hos_record_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约记录唯一标识（医院预约记录主键）',
  `number` int(11) NULL DEFAULT NULL COMMENT '预约号序',
  `fetch_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议取号时间',
  `fetch_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取号地点',
  `amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '医事服务费',
  `quit_time` datetime NULL DEFAULT NULL COMMENT '退号时间',
  `order_status` tinyint(3) NULL DEFAULT NULL COMMENT '订单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_hoscode`(`hoscode`) USING BTREE,
  INDEX `idx_hos_schedule_id`(`hos_schedule_id`) USING BTREE,
  INDEX `idx_hos_record_id`(`hos_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, 13, '164421691749355', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '61f261c986d34a7e49b56a34', '2022-02-08', 0, 1, '张三', '13845046517', '1', 12, '2022-02-0809:00前', '一层114窗口', 100, '2022-02-07 15:30:00', 0, '2022-02-07 14:55:17', '2022-02-07 15:02:41', 0);
INSERT INTO `order_info` VALUES (2, 13, '164421722572912', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '副主任医师', '61f261c986d34a7e49b56a35', '2022-02-08', 0, 1, '张三', '13845046517', '2', 13, '2022-02-0809:00前', '一层114窗口', 100, '2022-02-07 15:30:00', 0, '2022-02-07 15:00:25', '2022-02-07 15:02:43', 0);
INSERT INTO `order_info` VALUES (3, 13, '164429904140946', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '61f261c986d34a7e49b56a37', '2022-02-09', 0, 1, '张三', '13845046517', '4', 15, '2022-02-0909:00前', '一层114窗口', 100, '2022-02-08 15:30:00', 1, '2022-02-08 13:44:01', '2022-02-08 13:44:01', 0);
INSERT INTO `order_info` VALUES (4, 13, '164437094409435', '1000_0', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '61f261c986d34a7e49b56a3a', '2022-02-10', 0, 2, '孙丽丽', '13845046517', '5', 16, '2022-02-1009:00前', '一层114窗口', 100, '2022-02-09 15:30:00', -1, '2022-02-09 09:42:24', '2022-02-09 09:42:24', 0);

-- ----------------------------
-- Table structure for payment_info
-- ----------------------------
DROP TABLE IF EXISTS `payment_info`;
CREATE TABLE `payment_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `payment_type` tinyint(1) NULL DEFAULT NULL COMMENT '支付类型（微信 支付宝）',
  `trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `payment_status` tinyint(3) NULL DEFAULT NULL COMMENT '支付状态',
  `callback_time` datetime NULL DEFAULT NULL COMMENT '回调时间',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_info
-- ----------------------------
INSERT INTO `payment_info` VALUES (1, '164429904140946', 3, 2, '4200001323202202083379857060', 100.00, '2022-02-09|北京协和医院|多发性硬化专科门诊|医师', 2, '2022-02-08 13:50:07', '{transaction_id=4200001323202202083379857060, nonce_str=8UzTkRGKQzKcm7Yp, trade_state=SUCCESS, bank_type=OTHERS, openid=oHwsHuFJML39xfpy4armetXTJKnI, sign=30A625B40D8D09F51F9B330FC7B5DFCF, return_msg=OK, fee_type=CNY, mch_id=1558950191, cash_fee=1, out_trade_no=164429904140946, cash_fee_type=CNY, appid=wx74862e0dfcf69954, total_fee=1, trade_state_desc=支付成功, trade_type=NATIVE, result_code=SUCCESS, attach=, time_end=20220208135007, is_subscribe=N, return_code=SUCCESS}', '2022-02-08 13:44:10', '2022-02-08 13:44:10', 0);
INSERT INTO `payment_info` VALUES (2, '164437094409435', 4, 2, '4200001318202202099943987809', 100.00, '2022-02-10|北京协和医院|多发性硬化专科门诊|医师', 2, '2022-02-09 09:42:43', '{transaction_id=4200001318202202099943987809, nonce_str=jUKpRyD0FIcA6U8Q, trade_state=SUCCESS, bank_type=OTHERS, openid=oHwsHuFJML39xfpy4armetXTJKnI, sign=B0D2C72E17F9E99D88F10D9A887E5F9D, return_msg=OK, fee_type=CNY, mch_id=1558950191, cash_fee=1, out_trade_no=164437094409435, cash_fee_type=CNY, appid=wx74862e0dfcf69954, total_fee=1, trade_state_desc=支付成功, trade_type=NATIVE, result_code=SUCCESS, attach=, time_end=20220209094245, is_subscribe=N, return_code=SUCCESS}', '2022-02-09 09:42:31', '2022-02-09 09:42:30', 0);

-- ----------------------------
-- Table structure for refund_info
-- ----------------------------
DROP TABLE IF EXISTS `refund_info`;
CREATE TABLE `refund_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `payment_type` tinyint(3) NULL DEFAULT NULL COMMENT '支付类型（微信 支付宝）',
  `trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `refund_status` tinyint(3) NULL DEFAULT NULL COMMENT '退款状态',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `callback_time` datetime NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退款信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of refund_info
-- ----------------------------
INSERT INTO `refund_info` VALUES (1, '164437094409435', 4, 2, '50302100922022020917184947108', 100.00, '2022-02-10|北京协和医院|多发性硬化专科门诊|医师', 2, '{\"transaction_id\":\"4200001318202202099943987809\",\"nonce_str\":\"2E32fBLVLEd02RvH\",\"out_refund_no\":\"tk164437094409435\",\"sign\":\"06F0C9A4228BFB105B6817BEA3DEEEAB\",\"return_msg\":\"OK\",\"mch_id\":\"1558950191\",\"refund_id\":\"50302100922022020917184947108\",\"cash_fee\":\"1\",\"out_trade_no\":\"164437094409435\",\"coupon_refund_fee\":\"0\",\"refund_channel\":\"\",\"appid\":\"wx74862e0dfcf69954\",\"refund_fee\":\"1\",\"total_fee\":\"1\",\"result_code\":\"SUCCESS\",\"coupon_refund_count\":\"0\",\"cash_refund_fee\":\"1\",\"return_code\":\"SUCCESS\"}', '2022-02-09 09:43:59', '2022-02-09 09:43:58', '2022-02-09 09:43:58', 0);

SET FOREIGN_KEY_CHECKS = 1;
