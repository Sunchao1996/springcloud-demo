/*
Navicat MySQL Data Transfer

Source Server         : 47.98.126.115_3306
Source Server Version : 50637
Source Host           : 47.98.126.115:3306
Source Database       : book-order

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-09-12 23:46:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL DEFAULT '0' COMMENT '产品ID',
  `price` int(10) DEFAULT '0' COMMENT '价格',
  `user_id` int(10) DEFAULT '0' COMMENT '用户账号ID',
  `trade_id` int(10) DEFAULT '0' COMMENT '交易号ID',
  `trade_status` tinyint(1) DEFAULT '0' COMMENT '支付状态 0=未支付 1=已支付',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '100', '1', '1', '1', '1', '2018-07-06 15:48:40', '2018-07-06 15:48:41');
INSERT INTO `order` VALUES ('2', '1', '100', '1', null, '0', '1', '2018-07-06 15:51:14', '2018-07-06 15:51:14');
INSERT INTO `order` VALUES ('3', '1', '100', '1', null, '0', '1', '2018-07-06 15:52:04', '2018-07-06 15:52:04');
INSERT INTO `order` VALUES ('4', '1', '100', '1', null, '0', '1', '2018-07-06 15:53:48', '2018-07-06 15:53:49');
INSERT INTO `order` VALUES ('5', '1', '100', '1', null, '0', '1', '2018-07-06 15:55:50', '2018-07-06 15:55:55');
INSERT INTO `order` VALUES ('6', '1', '100', '1', null, '0', '1', '2018-07-06 15:56:18', '2018-07-06 15:56:18');
INSERT INTO `order` VALUES ('7', '1', '100', '1', null, '0', '1', '2018-07-06 15:59:41', '2018-07-06 15:59:42');
INSERT INTO `order` VALUES ('8', '1', '100', '1', null, '0', '1', '2018-07-06 16:02:45', '2018-07-06 16:02:51');
INSERT INTO `order` VALUES ('9', '1', '100', '1', null, '0', '1', '2018-07-06 16:02:52', '2018-07-06 16:02:53');
INSERT INTO `order` VALUES ('10', '1', '100', '1', null, '0', '1', '2018-07-06 16:05:16', '2018-07-06 16:05:16');
INSERT INTO `order` VALUES ('11', '1', '100', '1', null, '0', '1', '2018-07-06 16:05:21', '2018-07-06 16:05:21');
INSERT INTO `order` VALUES ('12', '1', '100', '1', null, '0', '1', '2018-07-06 16:05:26', '2018-07-06 16:05:26');
INSERT INTO `order` VALUES ('13', '1', '100', '1', null, '0', '1', '2018-07-06 16:05:28', '2018-07-06 16:05:28');
INSERT INTO `order` VALUES ('14', '1', '100', '1', null, '0', '1', '2018-07-06 16:05:30', '2018-07-06 16:05:31');
INSERT INTO `order` VALUES ('15', '1', '100', '1', null, '0', '1', '2018-07-06 16:05:33', '2018-07-06 16:05:33');
