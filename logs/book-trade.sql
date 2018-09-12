/*
Navicat MySQL Data Transfer

Source Server         : 47.98.126.115_3306
Source Server Version : 50637
Source Host           : 47.98.126.115:3306
Source Database       : book-trade

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-09-12 23:46:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `trade`
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'IID',
  `order_id` int(10) NOT NULL COMMENT '订单ID',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `price` int(10) NOT NULL COMMENT '支付价',
  `pay_status` tinyint(4) NOT NULL COMMENT '1 未付款 2 付款中 3 付款失败 4 付款完成',
  `pay_type` tinyint(4) NOT NULL COMMENT '支付类型:1-支付宝支付，2-网银在线，3-银联，4-微信支付',
  `gateway_pay_num` varchar(30) DEFAULT NULL COMMENT '网关支付流水号',
  `gateway_pay_time` datetime DEFAULT NULL COMMENT '网关支付时间',
  `gateway_pay_price` int(10) NOT NULL DEFAULT '0' COMMENT '网关实际支付金额',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` datetime NOT NULL  COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='交易';

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES ('1', '1', '1', '100', '4', '1', '1530863628415', '2018-07-06 15:53:48', '100', '0', '2018-07-06 15:53:53', '2018-07-06 15:53:53');
INSERT INTO `trade` VALUES ('2', '1', '1', '100', '4', '1', '1530863778248', '2018-07-06 15:56:18', '100', '0', '2018-07-06 15:56:19', '2018-07-06 15:56:19');
INSERT INTO `trade` VALUES ('3', '1', '1', '100', '4', '1', '1530863981388', '2018-07-06 15:59:41', '100', '0', '2018-07-06 15:59:42', '2018-07-06 15:59:42');
INSERT INTO `trade` VALUES ('4', '1', '1', '100', '4', '1', '1530864172577', '2018-07-06 16:02:53', '100', '0', '2018-07-06 16:02:58', '2018-07-06 16:02:58');
INSERT INTO `trade` VALUES ('5', '1', '1', '100', '4', '1', '1530864315973', '2018-07-06 16:05:16', '100', '0', '2018-07-06 16:05:16', '2018-07-06 16:05:16');
INSERT INTO `trade` VALUES ('6', '1', '1', '100', '4', '1', '1530864320861', '2018-07-06 16:05:21', '100', '0', '2018-07-06 16:05:21', '2018-07-06 16:05:21');
INSERT INTO `trade` VALUES ('7', '1', '1', '100', '4', '1', '1530864326196', '2018-07-06 16:05:26', '100', '0', '2018-07-06 16:05:27', '2018-07-06 16:05:27');
INSERT INTO `trade` VALUES ('8', '1', '1', '100', '4', '1', '1530864328340', '2018-07-06 16:05:28', '100', '0', '2018-07-06 16:05:29', '2018-07-06 16:05:29');
INSERT INTO `trade` VALUES ('9', '1', '1', '100', '4', '1', '1530864330659', '2018-07-06 16:05:31', '100', '0', '2018-07-06 16:05:31', '2018-07-06 16:05:31');
INSERT INTO `trade` VALUES ('10', '1', '1', '100', '4', '1', '1530864333283', '2018-07-06 16:05:33', '100', '0', '2018-07-06 16:05:34', '2018-07-06 16:05:34');
