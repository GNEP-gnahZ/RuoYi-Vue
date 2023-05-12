/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 10/05/2023 17:32:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo`  (
  `saleinfo_id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `saleinfo_customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `saleinfo_quantiy` bigint NULL DEFAULT NULL,
  `saleinfo_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `saleinfo_price` decimal(10, 2) NULL DEFAULT NULL,
  `saleinfo_total_price` decimal(10, 2) NULL DEFAULT NULL,
  `saleinfo_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`saleinfo_id`) USING BTREE,
  CONSTRAINT `sale_goods_id` FOREIGN KEY (`saleinfo_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
