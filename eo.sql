/*
Navicat MySQL Data Transfer

Source Server         : adscreen
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : eo

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-05-31 18:37:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve` (
  `approveId` int(255) NOT NULL AUTO_INCREMENT,
  `approvetitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `approvetype` int(5) NOT NULL,
  `approver` int(64) DEFAULT NULL,
  `applytime` datetime DEFAULT NULL,
  `newTime` datetime NOT NULL,
  `state` int(1) NOT NULL DEFAULT '0',
  `ispass` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`approveId`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve
-- ----------------------------
INSERT INTO `approve` VALUES ('1', '柴攀峰1的请假', '1', '3', '2016-10-09 09:40:18', '2016-10-28 08:20:03', '0', '0');
INSERT INTO `approve` VALUES ('2', '柴攀峰2的报销', '3', '3', '2016-10-06 09:48:24', '2016-11-01 02:40:14', '2', '0');
INSERT INTO `approve` VALUES ('3', '柴攀峰3的出差', '2', '3', '2016-10-17 09:51:30', '2016-10-27 13:27:38', '2', '0');
INSERT INTO `approve` VALUES ('4', '柴攀峰4的请假', '1', '3', '2016-10-18 10:04:59', '2016-10-18 10:04:59', '2', '0');
INSERT INTO `approve` VALUES ('5', '柴攀峰5的出差', '2', '3', '2016-10-12 10:06:13', '2016-10-12 10:06:13', '1', '1');
INSERT INTO `approve` VALUES ('6', '柴攀峰6的报销', '3', '3', '2016-10-11 10:08:09', '2016-10-11 10:08:09', '1', '2');
INSERT INTO `approve` VALUES ('73', '柴攀峰的请假', '1', '3', '2016-11-05 13:40:00', '2016-11-05 13:40:00', '0', '0');
INSERT INTO `approve` VALUES ('74', '柴攀峰的请假', '1', '3', '2016-11-05 13:40:25', '2016-11-05 13:40:25', '0', '0');
INSERT INTO `approve` VALUES ('75', '柴攀峰的请假', '1', '3', '2016-11-05 14:00:50', '2016-11-05 14:00:50', '0', '0');
INSERT INTO `approve` VALUES ('76', '柴攀峰的出差', '2', '3', '2016-11-05 14:03:11', '2016-11-05 14:03:11', '0', '0');
INSERT INTO `approve` VALUES ('77', 'zhangsan的请假', '1', '4', '2016-11-08 00:03:57', '2016-11-08 00:42:56', '2', '0');
INSERT INTO `approve` VALUES ('78', 'zhangsan的报销', '3', '4', '2016-11-08 00:43:42', '2016-11-08 00:43:42', '0', '0');
INSERT INTO `approve` VALUES ('79', 'zhangsan的请假', '1', '4', '2016-11-08 00:48:13', '2016-11-08 00:48:13', '0', '0');
INSERT INTO `approve` VALUES ('80', 'zhangsan的请假', '1', '4', '2016-11-08 01:01:40', '2016-11-08 01:01:40', '0', '0');
INSERT INTO `approve` VALUES ('81', 'zhangsan的请假', '1', '4', '2016-11-08 01:02:37', '2016-11-08 01:02:37', '0', '0');
INSERT INTO `approve` VALUES ('82', 'zhangsan的请假', '1', '4', '2016-11-08 01:05:29', '2016-11-08 01:05:29', '0', '0');
INSERT INTO `approve` VALUES ('83', 'zhangsan的请假', '1', '4', '2016-11-08 01:06:30', '2016-11-08 01:06:30', '0', '0');
INSERT INTO `approve` VALUES ('84', 'zhangsan的请假', '1', '4', '2016-11-08 01:08:12', '2016-11-08 01:08:12', '0', '0');
INSERT INTO `approve` VALUES ('85', 'zhangsan的请假', '1', '4', '2016-11-08 01:13:11', '2016-11-08 01:13:11', '0', '0');
INSERT INTO `approve` VALUES ('86', 'zhangsan的请假', '1', '4', '2016-11-08 01:13:53', '2016-11-08 01:13:53', '0', '0');
INSERT INTO `approve` VALUES ('87', 'zhangsan的请假', '1', '4', '2016-11-08 01:19:42', '2016-11-08 01:19:42', '0', '0');
INSERT INTO `approve` VALUES ('88', 'zhangsan的请假', '1', '4', '2016-11-08 01:28:47', '2016-11-08 01:28:47', '0', '0');
INSERT INTO `approve` VALUES ('89', 'zhangsan的请假', '1', '4', '2016-11-08 01:47:38', '2016-11-08 01:47:38', '0', '0');
INSERT INTO `approve` VALUES ('90', 'zhangsan的请假', '1', '4', '2016-11-08 01:59:46', '2016-11-08 01:59:46', '0', '0');
INSERT INTO `approve` VALUES ('91', 'zhangsan的请假', '1', '4', '2016-11-08 02:01:25', '2016-11-08 02:01:25', '1', '2');
INSERT INTO `approve` VALUES ('92', 'zhangsan的请假', '1', '4', '2016-11-08 02:29:56', '2016-11-08 02:30:01', '2', '0');
INSERT INTO `approve` VALUES ('93', 'liu的请假', '1', '4', '2016-11-08 06:57:52', '2016-11-08 06:57:52', '0', '0');
INSERT INTO `approve` VALUES ('94', 'chaipanfen的请假', '1', '3', '2016-11-08 12:49:08', '2016-11-08 12:49:08', '0', '0');
INSERT INTO `approve` VALUES ('95', 'chaipanfen的请假', '1', '3', '2016-11-08 12:52:42', '2016-11-08 12:52:42', '0', '0');
INSERT INTO `approve` VALUES ('96', '345的请假', '1', '44', '2016-11-08 18:32:23', '2016-11-08 18:32:23', '1', '2');
INSERT INTO `approve` VALUES ('97', 'chaipanfen的请假', '1', '3', '2016-11-08 18:51:53', '2016-11-08 18:51:53', '1', '1');
INSERT INTO `approve` VALUES ('98', 'liu的请假', '1', '4', '2016-11-08 19:28:39', '2016-11-08 19:28:39', '1', '1');
INSERT INTO `approve` VALUES ('99', '刘的出差', '2', '1', '2016-11-08 19:37:20', '2016-11-08 19:37:20', '1', '1');
INSERT INTO `approve` VALUES ('100', '刘的请假', '1', '1', '2016-11-08 19:42:00', '2016-11-08 19:42:00', '1', '1');
INSERT INTO `approve` VALUES ('101', 'contestuser的请假', '1', '34', '2016-11-08 19:51:29', '2016-11-08 19:51:44', '2', '0');
INSERT INTO `approve` VALUES ('102', '345的请假', '1', '44', '2016-11-08 19:52:48', '2016-11-08 19:52:48', '0', '0');
INSERT INTO `approve` VALUES ('103', '400的请假', '1', '45', '2016-11-08 19:54:30', '2016-11-08 19:54:30', '0', '0');
INSERT INTO `approve` VALUES ('104', 'dage的请假', '1', '31', '2016-11-08 20:06:36', '2016-11-08 20:06:36', '1', '1');
INSERT INTO `approve` VALUES ('105', '刘的请假', '1', '1', '2016-11-08 20:11:27', '2017-05-21 11:17:28', '2', '0');
INSERT INTO `approve` VALUES ('107', '400的请假', '1', '45', '2016-11-08 20:29:15', '2016-11-08 20:29:15', '1', '1');
INSERT INTO `approve` VALUES ('108', '400的请假', '1', '45', '2016-11-08 20:34:48', '2016-11-08 20:34:48', '1', '1');
INSERT INTO `approve` VALUES ('109', '400的出差', '2', '45', '2016-11-08 20:37:00', '2016-11-08 20:37:00', '1', '1');
INSERT INTO `approve` VALUES ('113', '400的请假', '1', '45', '2016-11-08 20:40:30', '2016-11-08 20:40:30', '1', '1');
INSERT INTO `approve` VALUES ('114', '400的请假', '1', '45', '2016-11-08 20:45:12', '2016-11-08 20:45:12', '1', '1');
INSERT INTO `approve` VALUES ('115', '400的请假', '1', '45', '2016-11-08 20:47:59', '2016-11-08 20:47:59', '1', '1');
INSERT INTO `approve` VALUES ('116', 'liu的请假', '1', '4', '2016-11-09 09:17:35', '2016-11-09 09:17:35', '0', '0');
INSERT INTO `approve` VALUES ('117', 'liu的请假', '1', '4', '2016-11-08 20:43:07', '2016-11-08 20:43:07', '0', '0');
INSERT INTO `approve` VALUES ('118', '刘的请假', '1', '1', '2016-11-08 21:01:36', '2016-11-08 21:01:36', '1', '1');
INSERT INTO `approve` VALUES ('119', '刘的请假', '1', '1', '2017-05-30 12:44:45', '2017-05-30 12:44:45', '0', '0');
INSERT INTO `approve` VALUES ('120', '刘的请假', '1', '1', '2017-05-30 12:44:50', '2017-05-30 12:44:50', '0', '0');
INSERT INTO `approve` VALUES ('121', '张三的请假', '1', '47', '2017-05-30 13:48:58', '2017-05-30 13:48:58', '1', '2');
INSERT INTO `approve` VALUES ('122', '张三的报销', '3', '47', '2017-05-30 13:59:24', '2017-05-30 13:59:24', '1', '2');
INSERT INTO `approve` VALUES ('123', '李四的请假', '1', '49', '2017-05-30 14:21:01', '2017-05-30 14:21:01', '1', '1');
INSERT INTO `approve` VALUES ('124', '张三的请假', '1', '47', '2017-05-30 14:28:14', '2017-05-30 14:28:14', '1', '1');
INSERT INTO `approve` VALUES ('125', '刘菲炫的请假', '1', '48', '2017-05-31 12:10:56', '2017-05-31 12:10:56', '1', '1');
INSERT INTO `approve` VALUES ('126', '张三的请假', '1', '47', '2017-05-31 00:11:52', '2017-05-31 00:11:52', '0', '0');
INSERT INTO `approve` VALUES ('127', '李四的请假', '1', '49', '2017-05-31 12:15:32', '2017-05-31 12:15:32', '0', '0');
INSERT INTO `approve` VALUES ('128', '刘菲炫的请假', '1', '48', '2017-05-31 01:50:31', '2017-05-31 01:50:31', '1', '2');

-- ----------------------------
-- Table structure for approvedata
-- ----------------------------
DROP TABLE IF EXISTS `approvedata`;
CREATE TABLE `approvedata` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `approveid` int(20) NOT NULL,
  `text_1` text,
  `varchar_2` varchar(255) DEFAULT NULL,
  `varchar_3` varchar(255) DEFAULT NULL,
  `varchar_4` varchar(255) DEFAULT NULL,
  `varchar_5` varchar(255) DEFAULT NULL,
  `varchar_6` varchar(255) DEFAULT NULL,
  `varchar_7` varchar(255) DEFAULT NULL,
  `varchar_8` varchar(255) DEFAULT NULL,
  `varchar_9` varchar(255) DEFAULT NULL,
  `varchar_10` varchar(255) DEFAULT NULL,
  `int_1` int(11) DEFAULT NULL,
  `int_2` int(11) DEFAULT NULL,
  `int_3` int(11) DEFAULT NULL,
  `int_4` int(11) DEFAULT NULL,
  `int_5` int(11) DEFAULT NULL,
  `int_6` int(11) DEFAULT NULL,
  `int_7` int(11) DEFAULT NULL,
  `int_8` int(11) DEFAULT NULL,
  `int_9` int(11) DEFAULT NULL,
  `int_10` int(11) DEFAULT NULL,
  `datetime_1` datetime DEFAULT NULL,
  `datetime_2` datetime DEFAULT NULL,
  `datetime_3` datetime DEFAULT NULL,
  `datetime_4` datetime DEFAULT NULL,
  `datetime_5` datetime DEFAULT NULL,
  `datetime_6` datetime DEFAULT NULL,
  `datetime_7` datetime DEFAULT NULL,
  `datetime_8` datetime DEFAULT NULL,
  `datetime_9` datetime DEFAULT NULL,
  `datetime_10` datetime DEFAULT NULL,
  `bit_1` bit(1) DEFAULT NULL,
  `bit_2` bit(1) DEFAULT NULL,
  `bit_3` bit(1) DEFAULT NULL,
  `bit_4` bit(1) DEFAULT NULL,
  `bit_5` bit(1) DEFAULT NULL,
  `bit_6` bit(1) DEFAULT NULL,
  `bit_7` bit(1) DEFAULT NULL,
  `bit_8` bit(1) DEFAULT NULL,
  `bit_9` bit(1) DEFAULT NULL,
  `bit_10` bit(1) DEFAULT NULL,
  `decimal_1` decimal(10,0) DEFAULT NULL,
  `decimal_2` decimal(10,0) DEFAULT NULL,
  `decimal_3` decimal(10,0) DEFAULT NULL,
  `decimal_4` decimal(10,0) DEFAULT NULL,
  `decimal_5` decimal(10,0) DEFAULT NULL,
  `decimal_6` decimal(10,0) DEFAULT NULL,
  `decimal_7` decimal(10,0) DEFAULT NULL,
  `decimal_8` decimal(10,0) DEFAULT NULL,
  `decimal_9` decimal(10,0) DEFAULT NULL,
  `decimal_10` decimal(10,0) DEFAULT NULL,
  `varchar_1` varchar(255) DEFAULT NULL,
  `text_2` text,
  `text_3` text,
  `text_4` text,
  `text_5` text,
  `text_6` text,
  `text_7` text,
  `text_8` text,
  `text_9` text,
  `text_10` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approvedata
-- ----------------------------
INSERT INTO `approvedata` VALUES ('1', '1', '生病了', '事假', null, null, null, null, null, null, null, null, null, '3', null, null, null, null, null, null, null, null, '2016-10-10 09:28:22', '2016-10-13 09:28:48', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('2', '2', '买鸡', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('3', '3', '卖鸡', '上海', null, null, null, null, null, null, null, null, '5', null, null, null, null, null, null, null, null, null, '2016-10-04 09:53:26', '2016-10-09 09:53:30', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('4', '4', '累死了休年假', '年假', null, null, null, null, null, null, null, null, null, '3', null, null, null, null, null, null, null, null, '2016-09-26 09:56:36', '2016-09-29 09:56:42', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('5', '5', 'ppt', '镇江', null, null, null, null, null, null, null, null, '4', null, null, null, null, null, null, null, null, null, '2016-10-18 10:06:32', '2016-10-22 10:06:36', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('6', '6', '买车', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('15', '55', 'fefe', '事假', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-03 00:00:00', '2016-11-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('16', '56', 'efefe', '病假', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-03 00:00:00', '2016-11-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('17', '57', '11', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-03 00:00:00', '2016-11-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('18', '58', '111', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-03 00:00:00', '2016-11-04 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('19', '59', 'dddd', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-03 00:00:00', '2016-11-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('20', '65', 'fege', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-06 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('21', '66', '156465', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('22', '67', '156465', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-05 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('23', '68', '1', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-06 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('24', '69', 'dwdw', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-07 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('25', '70', 'fefef', 'fefefe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '11', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('26', '71', '1', 'fefefefefe', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-07 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('27', '72', 'grgr', 'fff', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-08 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('28', '73', 'rggr', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-05 00:00:00', '2016-11-07 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('29', '74', 'fefe', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-05 00:00:00', '2016-11-06 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('30', '75', 'fefe', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-05 00:00:00', '2016-11-06 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('31', '76', 'efefe', 'fefe', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, '2016-11-05 00:00:00', '2016-11-08 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('32', '77', '222', '年假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('33', '78', '3333333', '3333', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3333333', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('34', '79', 'jiujzijiojid', '病假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('35', '80', '322', '病假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('36', '81', '22', '事假', null, null, null, null, null, null, null, null, null, '222', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('37', '82', '23', '事假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('38', '83', '22', '病假', null, null, null, null, null, null, null, null, null, '22', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-10 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('39', '84', '2222', '病假', null, null, null, null, null, null, null, null, null, '3', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('40', '85', '1111', '病假', null, null, null, null, null, null, null, null, null, '21', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('41', '86', '22222', '病假', null, null, null, null, null, null, null, null, null, '22', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('42', '87', '22', '事假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-08 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('43', '88', '3333', '事假', null, null, null, null, null, null, null, null, null, '33', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-08 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('44', '89', '2222', '事假', null, null, null, null, null, null, null, null, null, '22', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-10 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('45', '90', '2222', '病假', null, null, null, null, null, null, null, null, null, '2222', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-08 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('46', '91', '2222', '病假', null, null, null, null, null, null, null, null, null, '332', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-10 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('47', '92', 'ddd', '年假', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('48', '93', '222', '病假', null, null, null, null, null, null, null, null, null, '11', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-09 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('49', '94', 'efefe', '病假', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-12 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('50', '95', 'fefe', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-10 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('51', '96', 'greger', '其他', null, null, null, null, null, null, null, null, null, '32432', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('52', '97', 'efrgr', '其他', null, null, null, null, null, null, null, null, null, '3', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('53', '98', 'grgr', '其他', null, null, null, null, null, null, null, null, null, '22', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('54', '99', 'fdsf', 'eewqe', null, null, null, null, null, null, null, null, '6', null, null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-13 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('55', '100', 'ewfewfw', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-14 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('56', '101', 'regreg', '其他', null, null, null, null, null, null, null, null, null, '323', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('57', '102', 'ege', '其他', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-11 00:00:00', '2016-11-20 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('58', '103', '4t4t4', '其他', null, null, null, null, null, null, null, null, null, '44', null, null, null, null, null, null, null, null, '2016-11-06 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('59', '104', 'efe', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('60', '105', 'efwfw', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('61', '106', 'wqdqw', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-10 00:00:00', '2016-11-12 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('62', '107', 'efe', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('63', '108', 'rf', '其他', null, null, null, null, null, null, null, null, null, '4', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('64', '109', 'wdw', '22', null, null, null, null, null, null, null, null, '11', null, null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('65', '113', 'efwef', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-10 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('66', '114', 'efew', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-01 00:00:00', '2016-11-30 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('67', '115', 'wdqdwq', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-13 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('68', '116', '啦啦啦', '病假', null, null, null, null, null, null, null, null, null, '4', null, null, null, null, null, null, null, null, '2016-11-09 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('69', '117', '222', '事假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2016-11-08 00:00:00', '2016-11-11 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('70', '118', 'efe', '其他', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2016-11-04 00:00:00', '2016-11-08 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('71', '119', '做毕设', '病假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-30 00:00:00', '2017-05-31 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('72', '120', '做毕设', '病假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-30 00:00:00', '2017-05-31 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('73', '121', '回学校答辩啊', '事假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-30 00:00:00', '2017-05-31 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('74', '122', '木材', '活动', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '20', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('75', '123', '无聊', '产假', null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, '2017-05-30 00:00:00', '2017-05-30 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('76', '124', '调休', '调休', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-30 00:00:00', '2017-05-31 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('77', '125', '有事', '年假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-31 00:00:00', '2017-06-01 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('78', '126', 'miyjkjk', '病假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-31 00:00:00', '2017-06-01 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('79', '127', '头晕', '调休', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-31 00:00:00', '2017-06-01 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `approvedata` VALUES ('80', '128', 'hghgh', '病假', null, null, null, null, null, null, null, null, null, '2', null, null, null, null, null, null, null, null, '2017-05-31 00:00:00', '2017-06-01 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for approveimg
-- ----------------------------
DROP TABLE IF EXISTS `approveimg`;
CREATE TABLE `approveimg` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `approveId` int(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approveimg
-- ----------------------------
INSERT INTO `approveimg` VALUES ('52', '95', '20161108_125242_bf1416f2-c1af-4196-902d-a1b3170e7cb0.png');
INSERT INTO `approveimg` VALUES ('53', '95', '20161108_125242_6e04ed94-8ef2-46a6-9904-d7a96c3ce527.png');
INSERT INTO `approveimg` VALUES ('54', '95', '20161108_125242_6f6a30b2-953c-4a04-85ac-299d8f9360dc.png');
INSERT INTO `approveimg` VALUES ('55', '96', '20161108_183223_95978ab0-0403-4779-a995-17b7b8dc5197.png');
INSERT INTO `approveimg` VALUES ('56', '96', '20161108_183223_a25edc28-7cc2-486b-9d63-aba291acc658.png');
INSERT INTO `approveimg` VALUES ('57', '96', '20161108_183223_4f47b656-fcf3-4947-8955-e854919a6e1e.png');
INSERT INTO `approveimg` VALUES ('58', '97', '20161108_185153_1abff968-0dc0-425d-bdd3-47850e485263.png');
INSERT INTO `approveimg` VALUES ('59', '97', '20161108_185153_3a4ce571-076f-4889-9f22-e663b4698384.png');
INSERT INTO `approveimg` VALUES ('60', '97', '20161108_185153_b1c89557-5bf9-436f-96e4-8c861d0a297c.png');
INSERT INTO `approveimg` VALUES ('61', '97', '20161108_185153_31efaa71-6d3b-4e53-98e0-6c1aad40c449.png');
INSERT INTO `approveimg` VALUES ('62', '116', '20161109_091734_96fcddcb-641a-40e7-bf54-e0e98340b188.png');
INSERT INTO `approveimg` VALUES ('63', '116', '20161109_091735_692f5762-df10-4c8d-9859-ff7617ed82d3.png');
INSERT INTO `approveimg` VALUES ('64', '117', '20161108_204306_e5572e45-6454-42da-9b6d-c6f506d7ce9b.png');
INSERT INTO `approveimg` VALUES ('65', '119', '20170530_124444_087ee3fe-15f2-4c20-9c1a-a2fa9d949823.png');
INSERT INTO `approveimg` VALUES ('66', '120', '20170530_124444_087ee3fe-15f2-4c20-9c1a-a2fa9d949823.png');
INSERT INTO `approveimg` VALUES ('67', '120', '20170530_124450_e18452b9-689b-46f4-bb7c-b7d1929f056c.png');
INSERT INTO `approveimg` VALUES ('68', '121', '20170530_134858_aac5d4f6-012d-4548-a498-aff59b0bc76f.png');
INSERT INTO `approveimg` VALUES ('69', '122', '20170530_135924_03bbdb36-9ea0-42c7-9252-79361ab01911.png');
INSERT INTO `approveimg` VALUES ('70', '123', '20170530_142101_73e9c504-fb4e-4db3-b70b-df6187ac1ad4.png');
INSERT INTO `approveimg` VALUES ('71', '123', '20170530_142101_2dade03b-9c9f-44a7-b977-369229c20dfe.png');
INSERT INTO `approveimg` VALUES ('72', '124', '20170530_142814_6e4074d8-4be5-49cc-9ae2-f3dfd3875efc.png');
INSERT INTO `approveimg` VALUES ('73', '124', '20170530_142814_98e15021-6f2e-4322-be3f-60f2e5a523ea.png');
INSERT INTO `approveimg` VALUES ('74', '124', '20170530_142814_db22ec95-a116-4abf-bef3-0c4727beb03f.png');
INSERT INTO `approveimg` VALUES ('75', '124', '20170530_142814_32617380-a5a6-4589-a993-9e180e110470.png');
INSERT INTO `approveimg` VALUES ('76', '125', '20170531_121056_173db3cb-2343-405e-9c82-63186b21e76c.png');

-- ----------------------------
-- Table structure for approverule
-- ----------------------------
DROP TABLE IF EXISTS `approverule`;
CREATE TABLE `approverule` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `approvetypeId` int(50) NOT NULL,
  `shunxu` varchar(255) NOT NULL,
  `limited` decimal(11,0) DEFAULT NULL,
  `limitcolumnid` int(11) DEFAULT NULL,
  `companyId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approverule
-- ----------------------------

-- ----------------------------
-- Table structure for approvestate
-- ----------------------------
DROP TABLE IF EXISTS `approvestate`;
CREATE TABLE `approvestate` (
  `approvestateId` int(255) NOT NULL AUTO_INCREMENT,
  `approverId` varchar(64) DEFAULT NULL,
  `parentstateId` int(255) DEFAULT NULL,
  `comment` text,
  `decision` int(1) NOT NULL DEFAULT '2',
  `decisiontime` datetime DEFAULT NULL,
  `applicantId` int(64) DEFAULT NULL,
  `isnew` bit(1) DEFAULT b'0',
  `approveId` int(255) DEFAULT NULL,
  `isself` bit(1) DEFAULT b'0',
  PRIMARY KEY (`approvestateId`)
) ENGINE=InnoDB AUTO_INCREMENT=445 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approvestate
-- ----------------------------
INSERT INTO `approvestate` VALUES ('1', '3', '25', 'a', '1', '2016-10-01 10:29:24', '1', '\0', '1', '\0');
INSERT INTO `approvestate` VALUES ('2', '3', '1', 'b', '1', '2016-10-18 10:37:25', '2', '\0', '1', '\0');
INSERT INTO `approvestate` VALUES ('3', '3', '2', null, '1', '2016-10-18 10:52:18', '5', '\0', '1', '\0');
INSERT INTO `approvestate` VALUES ('4', '3', '3', null, '2', '2016-10-30 08:06:52', '10', '', '1', '\0');
INSERT INTO `approvestate` VALUES ('5', '3', '4', null, '2', '1970-10-26 21:45:02', '7', '\0', '1', '\0');
INSERT INTO `approvestate` VALUES ('6', '3', '26', null, '1', '2016-10-18 11:21:35', '1', '\0', '2', '\0');
INSERT INTO `approvestate` VALUES ('7', '3', '6', null, '1', '2016-10-18 11:22:27', '2', '\0', '2', '\0');
INSERT INTO `approvestate` VALUES ('8', '3', '7', null, '1', '2016-10-18 11:34:27', '4', '\0', '2', '\0');
INSERT INTO `approvestate` VALUES ('9', '3', '104', null, '2', '2016-10-30 07:12:59', '10', '\0', '2', '\0');
INSERT INTO `approvestate` VALUES ('10', '3', '27', null, '1', '2016-10-18 11:36:15', '2', '\0', '3', '\0');
INSERT INTO `approvestate` VALUES ('11', '3', '10', null, '1', '2016-10-18 11:40:32', '3', '\0', '3', '\0');
INSERT INTO `approvestate` VALUES ('12', '3', '42', null, '2', null, '10', '\0', '3', '\0');
INSERT INTO `approvestate` VALUES ('13', '3', '12', null, '2', null, '5', '\0', '3', '\0');
INSERT INTO `approvestate` VALUES ('14', '3', '28', null, '1', '2016-10-18 11:45:07', '1', '\0', '4', '\0');
INSERT INTO `approvestate` VALUES ('15', '3', '14', null, '1', '2016-10-18 11:45:04', '2', '\0', '4', '\0');
INSERT INTO `approvestate` VALUES ('16', '3', '15', null, '1', '2016-10-19 14:02:06', '10', '\0', '4', '\0');
INSERT INTO `approvestate` VALUES ('17', '3', '16', null, '0', '2016-10-24 15:22:18', '3', '', '4', '');
INSERT INTO `approvestate` VALUES ('18', '3', '29', null, '1', '2016-10-18 11:47:24', '1', '\0', '5', '\0');
INSERT INTO `approvestate` VALUES ('19', '3', '18', null, '1', '2016-10-18 11:49:06', '3', '\0', '5', '\0');
INSERT INTO `approvestate` VALUES ('20', '3', '19', null, '1', '2016-10-19 13:28:08', '4', '\0', '5', '\0');
INSERT INTO `approvestate` VALUES ('21', '3', '20', null, '1', '2016-10-19 13:28:18', '10', '', '5', '\0');
INSERT INTO `approvestate` VALUES ('22', '3', '30', null, '0', '2016-10-18 14:14:45', '10', '', '6', '\0');
INSERT INTO `approvestate` VALUES ('23', '3', '22', null, '2', '2016-10-18 14:15:21', '2', '\0', '6', '\0');
INSERT INTO `approvestate` VALUES ('24', '3', '23', null, '2', null, '1', '\0', '6', '\0');
INSERT INTO `approvestate` VALUES ('25', '3', '0', null, '1', '2016-10-06 19:08:34', '3', '\0', '1', '');
INSERT INTO `approvestate` VALUES ('26', '3', '0', null, '1', '2016-10-06 19:09:49', '3', '\0', '2', '');
INSERT INTO `approvestate` VALUES ('27', '3', '0', null, '1', '2016-10-06 19:10:51', '3', '\0', '3', '');
INSERT INTO `approvestate` VALUES ('28', '3', '0', null, '1', '2016-10-06 19:11:33', '3', '\0', '4', '');
INSERT INTO `approvestate` VALUES ('29', '3', '0', null, '1', '2016-10-06 20:12:51', '3', '\0', '5', '');
INSERT INTO `approvestate` VALUES ('30', '3', '0', null, '1', '2016-10-05 20:13:48', '3', '\0', '6', '');
INSERT INTO `approvestate` VALUES ('42', '3', '11', null, '0', '2016-10-27 13:27:38', '3', '', '3', '');
INSERT INTO `approvestate` VALUES ('104', '3', '8', null, '0', '2016-11-01 02:40:14', '3', '', '2', '');
INSERT INTO `approvestate` VALUES ('233', '3', '0', null, '1', '2016-11-05 13:40:00', '3', '\0', '73', '');
INSERT INTO `approvestate` VALUES ('234', '3', '233', null, '2', null, '3', '', '73', '\0');
INSERT INTO `approvestate` VALUES ('235', '3', '234', null, '2', null, '2', '\0', '73', '\0');
INSERT INTO `approvestate` VALUES ('236', '3', '235', null, '2', null, '1', '\0', '73', '\0');
INSERT INTO `approvestate` VALUES ('237', '3', '236', null, '2', null, '4', '\0', '73', '\0');
INSERT INTO `approvestate` VALUES ('238', '3', '0', null, '1', '2016-11-05 13:40:25', '3', '\0', '74', '');
INSERT INTO `approvestate` VALUES ('239', '3', '238', null, '2', null, '3', '', '74', '\0');
INSERT INTO `approvestate` VALUES ('240', '3', '239', null, '2', null, '2', '\0', '74', '\0');
INSERT INTO `approvestate` VALUES ('241', '3', '240', null, '2', null, '1', '\0', '74', '\0');
INSERT INTO `approvestate` VALUES ('242', '3', '241', null, '2', null, '4', '\0', '74', '\0');
INSERT INTO `approvestate` VALUES ('243', '3', '0', null, '1', '2016-11-05 14:00:50', '3', '\0', '75', '');
INSERT INTO `approvestate` VALUES ('244', '3', '243', null, '2', null, '3', '', '75', '\0');
INSERT INTO `approvestate` VALUES ('245', '3', '244', null, '2', null, '2', '\0', '75', '\0');
INSERT INTO `approvestate` VALUES ('246', '3', '245', null, '2', null, '1', '\0', '75', '\0');
INSERT INTO `approvestate` VALUES ('247', '3', '246', null, '2', null, '4', '\0', '75', '\0');
INSERT INTO `approvestate` VALUES ('248', '3', '0', null, '1', '2016-11-05 14:03:11', '3', '\0', '76', '');
INSERT INTO `approvestate` VALUES ('249', '3', '248', null, '2', null, '3', '', '76', '\0');
INSERT INTO `approvestate` VALUES ('250', '3', '249', null, '2', null, '3', '\0', '76', '\0');
INSERT INTO `approvestate` VALUES ('251', '3', '250', null, '2', null, '1', '\0', '76', '\0');
INSERT INTO `approvestate` VALUES ('252', '3', '251', null, '2', null, '4', '\0', '76', '\0');
INSERT INTO `approvestate` VALUES ('253', '4', '0', null, '1', '2016-11-08 00:03:57', '4', '\0', '77', '');
INSERT INTO `approvestate` VALUES ('254', '4', '258', null, '2', null, '3', '\0', '77', '\0');
INSERT INTO `approvestate` VALUES ('255', '4', '254', null, '2', null, '2', '\0', '77', '\0');
INSERT INTO `approvestate` VALUES ('256', '4', '255', null, '2', null, '1', '\0', '77', '\0');
INSERT INTO `approvestate` VALUES ('257', '4', '256', null, '2', null, '4', '\0', '77', '\0');
INSERT INTO `approvestate` VALUES ('258', '4', '253', null, '0', '2016-11-08 00:42:56', '4', '', '77', '');
INSERT INTO `approvestate` VALUES ('259', '4', '0', null, '1', '2016-11-08 00:43:42', '4', '\0', '78', '');
INSERT INTO `approvestate` VALUES ('260', '4', '259', '同意', '1', '2017-05-30 13:34:59', '1', '\0', '78', '\0');
INSERT INTO `approvestate` VALUES ('261', '4', '260', null, '2', null, '3', '', '78', '\0');
INSERT INTO `approvestate` VALUES ('262', '4', '261', null, '2', null, '5', '\0', '78', '\0');
INSERT INTO `approvestate` VALUES ('263', '4', '0', null, '1', '2016-11-08 00:48:13', '4', '\0', '79', '');
INSERT INTO `approvestate` VALUES ('264', '4', '263', null, '2', null, '3', '', '79', '\0');
INSERT INTO `approvestate` VALUES ('265', '4', '264', null, '2', null, '2', '\0', '79', '\0');
INSERT INTO `approvestate` VALUES ('266', '4', '265', null, '2', null, '1', '\0', '79', '\0');
INSERT INTO `approvestate` VALUES ('267', '4', '266', null, '2', null, '4', '\0', '79', '\0');
INSERT INTO `approvestate` VALUES ('268', '4', '0', null, '1', '2016-11-08 01:01:40', '4', '\0', '80', '');
INSERT INTO `approvestate` VALUES ('269', '4', '268', null, '2', null, '3', '', '80', '\0');
INSERT INTO `approvestate` VALUES ('270', '4', '269', null, '2', null, '2', '\0', '80', '\0');
INSERT INTO `approvestate` VALUES ('271', '4', '270', null, '2', null, '1', '\0', '80', '\0');
INSERT INTO `approvestate` VALUES ('272', '4', '271', null, '2', null, '4', '\0', '80', '\0');
INSERT INTO `approvestate` VALUES ('273', '4', '0', null, '1', '2016-11-08 01:02:37', '4', '\0', '81', '');
INSERT INTO `approvestate` VALUES ('274', '4', '273', null, '2', null, '3', '', '81', '\0');
INSERT INTO `approvestate` VALUES ('275', '4', '274', null, '2', null, '2', '\0', '81', '\0');
INSERT INTO `approvestate` VALUES ('276', '4', '275', null, '2', null, '1', '\0', '81', '\0');
INSERT INTO `approvestate` VALUES ('277', '4', '276', null, '2', null, '4', '\0', '81', '\0');
INSERT INTO `approvestate` VALUES ('278', '4', '0', null, '1', '2016-11-08 01:05:29', '4', '\0', '82', '');
INSERT INTO `approvestate` VALUES ('279', '4', '278', '1111', '1', '2016-11-08 02:31:59', '3', '\0', '82', '\0');
INSERT INTO `approvestate` VALUES ('280', '4', '279', null, '2', null, '2', '', '82', '\0');
INSERT INTO `approvestate` VALUES ('281', '4', '280', null, '2', null, '1', '\0', '82', '\0');
INSERT INTO `approvestate` VALUES ('282', '4', '281', null, '2', null, '4', '\0', '82', '\0');
INSERT INTO `approvestate` VALUES ('283', '4', '0', null, '1', '2016-11-08 01:06:30', '4', '\0', '83', '');
INSERT INTO `approvestate` VALUES ('284', '4', '283', null, '2', null, '3', '', '83', '\0');
INSERT INTO `approvestate` VALUES ('285', '4', '284', null, '2', null, '2', '\0', '83', '\0');
INSERT INTO `approvestate` VALUES ('286', '4', '285', null, '2', null, '1', '\0', '83', '\0');
INSERT INTO `approvestate` VALUES ('287', '4', '286', null, '2', null, '4', '\0', '83', '\0');
INSERT INTO `approvestate` VALUES ('288', '4', '0', null, '1', '2016-11-08 01:08:12', '4', '\0', '84', '');
INSERT INTO `approvestate` VALUES ('289', '4', '288', null, '2', null, '3', '', '84', '\0');
INSERT INTO `approvestate` VALUES ('290', '4', '289', null, '2', null, '2', '\0', '84', '\0');
INSERT INTO `approvestate` VALUES ('291', '4', '290', null, '2', null, '1', '\0', '84', '\0');
INSERT INTO `approvestate` VALUES ('292', '4', '291', null, '2', null, '4', '\0', '84', '\0');
INSERT INTO `approvestate` VALUES ('293', '4', '0', null, '1', '2016-11-08 01:13:11', '4', '\0', '85', '');
INSERT INTO `approvestate` VALUES ('294', '4', '293', null, '2', null, '3', '', '85', '\0');
INSERT INTO `approvestate` VALUES ('295', '4', '294', null, '2', null, '2', '\0', '85', '\0');
INSERT INTO `approvestate` VALUES ('296', '4', '295', null, '2', null, '1', '\0', '85', '\0');
INSERT INTO `approvestate` VALUES ('297', '4', '296', null, '2', null, '4', '\0', '85', '\0');
INSERT INTO `approvestate` VALUES ('298', '4', '0', null, '1', '2016-11-08 01:13:53', '4', '\0', '86', '');
INSERT INTO `approvestate` VALUES ('299', '4', '298', null, '2', null, '3', '', '86', '\0');
INSERT INTO `approvestate` VALUES ('300', '4', '299', null, '2', null, '2', '\0', '86', '\0');
INSERT INTO `approvestate` VALUES ('301', '4', '300', null, '2', null, '1', '\0', '86', '\0');
INSERT INTO `approvestate` VALUES ('302', '4', '301', null, '2', null, '4', '\0', '86', '\0');
INSERT INTO `approvestate` VALUES ('303', '4', '0', null, '1', '2016-11-08 01:19:42', '4', '\0', '87', '');
INSERT INTO `approvestate` VALUES ('304', '4', '303', null, '2', null, '3', '', '87', '\0');
INSERT INTO `approvestate` VALUES ('305', '4', '304', null, '2', null, '2', '\0', '87', '\0');
INSERT INTO `approvestate` VALUES ('306', '4', '305', null, '2', null, '1', '\0', '87', '\0');
INSERT INTO `approvestate` VALUES ('307', '4', '306', null, '2', null, '4', '\0', '87', '\0');
INSERT INTO `approvestate` VALUES ('308', '4', '0', null, '1', '2016-11-08 01:28:47', '4', '\0', '88', '');
INSERT INTO `approvestate` VALUES ('309', '4', '308', null, '2', null, '3', '', '88', '\0');
INSERT INTO `approvestate` VALUES ('310', '4', '309', null, '2', null, '2', '\0', '88', '\0');
INSERT INTO `approvestate` VALUES ('311', '4', '310', null, '2', null, '1', '\0', '88', '\0');
INSERT INTO `approvestate` VALUES ('312', '4', '311', null, '2', null, '4', '\0', '88', '\0');
INSERT INTO `approvestate` VALUES ('313', '4', '0', null, '1', '2016-11-08 01:47:38', '4', '\0', '89', '');
INSERT INTO `approvestate` VALUES ('314', '4', '313', null, '2', null, '3', '', '89', '\0');
INSERT INTO `approvestate` VALUES ('315', '4', '314', null, '2', null, '2', '\0', '89', '\0');
INSERT INTO `approvestate` VALUES ('316', '4', '315', null, '2', null, '1', '\0', '89', '\0');
INSERT INTO `approvestate` VALUES ('317', '4', '316', null, '2', null, '4', '\0', '89', '\0');
INSERT INTO `approvestate` VALUES ('318', '4', '0', null, '1', '2016-11-08 01:59:46', '4', '\0', '90', '');
INSERT INTO `approvestate` VALUES ('319', '4', '318', null, '2', null, '3', '', '90', '\0');
INSERT INTO `approvestate` VALUES ('320', '4', '319', null, '2', null, '2', '\0', '90', '\0');
INSERT INTO `approvestate` VALUES ('321', '4', '320', null, '2', null, '1', '\0', '90', '\0');
INSERT INTO `approvestate` VALUES ('322', '4', '321', null, '2', null, '4', '\0', '90', '\0');
INSERT INTO `approvestate` VALUES ('323', '4', '0', null, '1', '2016-11-08 02:01:25', '4', '\0', '91', '');
INSERT INTO `approvestate` VALUES ('324', '4', '323', 'eeee', '0', '2016-11-08 02:32:21', '3', '', '91', '\0');
INSERT INTO `approvestate` VALUES ('325', '4', '324', null, '2', null, '2', '\0', '91', '\0');
INSERT INTO `approvestate` VALUES ('326', '4', '325', null, '2', null, '1', '\0', '91', '\0');
INSERT INTO `approvestate` VALUES ('327', '4', '326', null, '2', null, '4', '\0', '91', '\0');
INSERT INTO `approvestate` VALUES ('328', '4', '0', null, '1', '2016-11-08 02:29:56', '4', '\0', '92', '');
INSERT INTO `approvestate` VALUES ('329', '4', '333', null, '2', null, '3', '\0', '92', '\0');
INSERT INTO `approvestate` VALUES ('330', '4', '329', null, '2', null, '2', '\0', '92', '\0');
INSERT INTO `approvestate` VALUES ('331', '4', '330', null, '2', null, '1', '\0', '92', '\0');
INSERT INTO `approvestate` VALUES ('332', '4', '331', null, '2', null, '4', '\0', '92', '\0');
INSERT INTO `approvestate` VALUES ('333', '4', '328', null, '0', '2016-11-08 02:30:01', '4', '', '92', '');
INSERT INTO `approvestate` VALUES ('334', '4', '0', null, '1', '2016-11-08 06:57:52', '4', '\0', '93', '');
INSERT INTO `approvestate` VALUES ('335', '4', '334', null, '2', null, '3', '', '93', '\0');
INSERT INTO `approvestate` VALUES ('336', '4', '335', null, '2', null, '2', '\0', '93', '\0');
INSERT INTO `approvestate` VALUES ('337', '4', '336', null, '2', null, '1', '\0', '93', '\0');
INSERT INTO `approvestate` VALUES ('338', '4', '337', null, '2', null, '4', '\0', '93', '\0');
INSERT INTO `approvestate` VALUES ('339', '3', '0', null, '1', '2016-11-08 12:49:08', '3', '\0', '94', '');
INSERT INTO `approvestate` VALUES ('340', '3', '339', null, '2', null, '3', '', '94', '\0');
INSERT INTO `approvestate` VALUES ('341', '3', '340', null, '2', null, '2', '\0', '94', '\0');
INSERT INTO `approvestate` VALUES ('342', '3', '341', null, '2', null, '1', '\0', '94', '\0');
INSERT INTO `approvestate` VALUES ('343', '3', '342', null, '2', null, '4', '\0', '94', '\0');
INSERT INTO `approvestate` VALUES ('344', '3', '0', null, '1', '2016-11-08 12:52:42', '3', '\0', '95', '');
INSERT INTO `approvestate` VALUES ('345', '3', '344', '11', '1', '2016-11-08 12:52:58', '3', '\0', '95', '\0');
INSERT INTO `approvestate` VALUES ('346', '3', '345', null, '2', null, '2', '', '95', '\0');
INSERT INTO `approvestate` VALUES ('347', '3', '346', null, '2', null, '1', '\0', '95', '\0');
INSERT INTO `approvestate` VALUES ('348', '3', '347', null, '2', null, '4', '\0', '95', '\0');
INSERT INTO `approvestate` VALUES ('349', '44', '0', null, '1', '2016-11-08 18:32:23', '44', '\0', '96', '');
INSERT INTO `approvestate` VALUES ('350', '44', '349', 'grgre', '0', '2016-11-08 18:32:37', '44', '', '96', '\0');
INSERT INTO `approvestate` VALUES ('351', '3', '0', null, '1', '2016-11-08 18:51:53', '3', '\0', '97', '');
INSERT INTO `approvestate` VALUES ('352', '3', '351', 'grg', '1', '2016-11-08 18:52:04', '3', '\0', '97', '\0');
INSERT INTO `approvestate` VALUES ('353', '3', '352', 'fefw', '1', '2016-11-08 18:52:56', '2', '\0', '97', '\0');
INSERT INTO `approvestate` VALUES ('354', '3', '353', 'fwegew', '1', '2016-11-08 18:53:58', '1', '\0', '97', '\0');
INSERT INTO `approvestate` VALUES ('355', '3', '354', 'fewf', '1', '2016-11-08 19:19:09', '4', '\0', '97', '\0');
INSERT INTO `approvestate` VALUES ('356', '4', '0', null, '1', '2016-11-08 19:28:39', '4', '\0', '98', '');
INSERT INTO `approvestate` VALUES ('357', '4', '356', '', '1', '2016-11-08 19:29:26', '5', '\0', '98', '\0');
INSERT INTO `approvestate` VALUES ('358', '4', '357', '', '1', '2016-11-08 19:30:01', '1', '\0', '98', '\0');
INSERT INTO `approvestate` VALUES ('359', '1', '0', null, '1', '2016-11-08 19:37:20', '1', '\0', '99', '');
INSERT INTO `approvestate` VALUES ('360', '1', '359', 'ivdsvds', '1', '2016-11-08 19:37:28', '1', '\0', '99', '\0');
INSERT INTO `approvestate` VALUES ('361', '1', '360', 'dsvsd', '1', '2016-11-08 19:38:23', '5', '\0', '99', '\0');
INSERT INTO `approvestate` VALUES ('362', '1', '361', '', '1', '2016-11-08 19:39:00', '1', '\0', '99', '\0');
INSERT INTO `approvestate` VALUES ('363', '1', '0', null, '1', '2016-11-08 19:42:00', '1', '\0', '100', '');
INSERT INTO `approvestate` VALUES ('364', '1', '363', '', '1', '2016-11-08 19:42:09', '1', '\0', '100', '\0');
INSERT INTO `approvestate` VALUES ('365', '1', '364', 'frr', '1', '2016-11-08 19:42:44', '5', '\0', '100', '\0');
INSERT INTO `approvestate` VALUES ('366', '1', '365', 'effe', '1', '2016-11-08 19:43:14', '1', '\0', '100', '\0');
INSERT INTO `approvestate` VALUES ('367', '34', '0', null, '1', '2016-11-08 19:51:29', '34', '\0', '101', '');
INSERT INTO `approvestate` VALUES ('368', '34', '372', null, '2', null, '1', '\0', '101', '\0');
INSERT INTO `approvestate` VALUES ('369', '34', '368', null, '2', null, '5', '\0', '101', '\0');
INSERT INTO `approvestate` VALUES ('370', '34', '369', null, '2', null, '1', '\0', '101', '\0');
INSERT INTO `approvestate` VALUES ('371', '34', '370', null, '2', null, '34', '\0', '101', '\0');
INSERT INTO `approvestate` VALUES ('372', '34', '367', null, '0', '2016-11-08 19:51:44', '34', '', '101', '');
INSERT INTO `approvestate` VALUES ('373', '44', '0', null, '1', '2016-11-08 19:52:48', '44', '\0', '102', '');
INSERT INTO `approvestate` VALUES ('374', '44', '373', null, '2', null, '1', '', '102', '\0');
INSERT INTO `approvestate` VALUES ('375', '44', '374', null, '2', null, '5', '\0', '102', '\0');
INSERT INTO `approvestate` VALUES ('376', '44', '375', null, '2', null, '1', '\0', '102', '\0');
INSERT INTO `approvestate` VALUES ('377', '44', '376', null, '2', null, '34', '\0', '102', '\0');
INSERT INTO `approvestate` VALUES ('378', '44', '377', null, '2', null, '44', '\0', '102', '\0');
INSERT INTO `approvestate` VALUES ('379', '45', '0', null, '1', '2016-11-08 19:54:30', '45', '\0', '103', '');
INSERT INTO `approvestate` VALUES ('380', '45', '379', null, '2', null, '1', '', '103', '\0');
INSERT INTO `approvestate` VALUES ('381', '45', '380', null, '2', null, '5', '\0', '103', '\0');
INSERT INTO `approvestate` VALUES ('382', '45', '381', null, '2', null, '1', '\0', '103', '\0');
INSERT INTO `approvestate` VALUES ('383', '45', '382', null, '2', null, '34', '\0', '103', '\0');
INSERT INTO `approvestate` VALUES ('384', '45', '383', null, '2', null, '44', '\0', '103', '\0');
INSERT INTO `approvestate` VALUES ('385', '45', '384', null, '2', null, '45', '\0', '103', '\0');
INSERT INTO `approvestate` VALUES ('386', '31', '0', null, '1', '2016-11-08 20:06:36', '31', '\0', '104', '');
INSERT INTO `approvestate` VALUES ('387', '31', '386', 'dwdw', '1', '2016-11-08 20:07:16', '5', '\0', '104', '\0');
INSERT INTO `approvestate` VALUES ('388', '31', '387', 'rew', '1', '2016-11-08 20:08:23', '1', '\0', '104', '\0');
INSERT INTO `approvestate` VALUES ('389', '1', '0', null, '1', '2016-11-08 20:11:27', '1', '\0', '105', '');
INSERT INTO `approvestate` VALUES ('390', '1', '389', '同意', '1', '2017-04-16 17:10:45', '1', '\0', '105', '\0');
INSERT INTO `approvestate` VALUES ('391', '1', '416', null, '2', null, '5', '\0', '105', '\0');
INSERT INTO `approvestate` VALUES ('392', '1', '391', null, '2', null, '1', '\0', '105', '\0');
INSERT INTO `approvestate` VALUES ('393', '45', '0', null, '1', '2016-11-08 20:23:39', '45', '\0', '106', '');
INSERT INTO `approvestate` VALUES ('394', '45', '0', null, '1', '2016-11-08 20:29:15', '45', '\0', '107', '');
INSERT INTO `approvestate` VALUES ('395', '45', '394', '', '1', '2016-11-08 20:32:01', '45', '\0', '107', '\0');
INSERT INTO `approvestate` VALUES ('396', '45', '0', null, '1', '2016-11-08 20:34:48', '45', '\0', '108', '');
INSERT INTO `approvestate` VALUES ('397', '45', '396', '', '1', '2016-11-08 20:34:53', '45', '\0', '108', '\0');
INSERT INTO `approvestate` VALUES ('398', '45', '0', null, '1', '2016-11-08 20:37:00', '45', '\0', '109', '');
INSERT INTO `approvestate` VALUES ('399', '45', '398', 'u', '1', '2016-11-08 20:37:23', '45', '\0', '109', '\0');
INSERT INTO `approvestate` VALUES ('400', '45', '0', null, '1', '2016-11-08 20:40:30', '45', '\0', '113', '');
INSERT INTO `approvestate` VALUES ('401', '45', '400', '', '1', '2016-11-08 20:40:40', '45', '\0', '113', '\0');
INSERT INTO `approvestate` VALUES ('402', '45', '0', null, '1', '2016-11-08 20:45:12', '45', '\0', '114', '');
INSERT INTO `approvestate` VALUES ('403', '45', '402', '', '1', '2016-11-08 20:45:18', '45', '\0', '114', '\0');
INSERT INTO `approvestate` VALUES ('404', '45', '0', null, '1', '2016-11-08 20:47:59', '45', '\0', '115', '');
INSERT INTO `approvestate` VALUES ('405', '45', '404', '', '1', '2016-11-08 20:48:04', '45', '\0', '115', '\0');
INSERT INTO `approvestate` VALUES ('406', '4', '0', null, '1', '2016-11-09 09:17:35', '4', '\0', '116', '');
INSERT INTO `approvestate` VALUES ('407', '4', '406', null, '2', null, '5', '', '116', '\0');
INSERT INTO `approvestate` VALUES ('408', '4', '407', null, '2', null, '1', '\0', '116', '\0');
INSERT INTO `approvestate` VALUES ('409', '4', '0', null, '1', '2016-11-08 20:43:07', '4', '\0', '117', '');
INSERT INTO `approvestate` VALUES ('410', '4', '409', null, '2', null, '5', '', '117', '\0');
INSERT INTO `approvestate` VALUES ('411', '4', '410', null, '2', null, '1', '\0', '117', '\0');
INSERT INTO `approvestate` VALUES ('412', '1', '0', null, '1', '2016-11-08 21:01:36', '1', '\0', '118', '');
INSERT INTO `approvestate` VALUES ('413', '1', '412', 'fefef', '1', '2016-11-08 21:01:47', '1', '\0', '118', '\0');
INSERT INTO `approvestate` VALUES ('414', '1', '413', '', '1', '2016-11-08 21:02:38', '5', '\0', '118', '\0');
INSERT INTO `approvestate` VALUES ('415', '1', '414', '', '1', '2016-11-08 21:03:04', '1', '\0', '118', '\0');
INSERT INTO `approvestate` VALUES ('416', '1', '390', null, '0', '2017-05-21 11:17:28', '1', '', '105', '');
INSERT INTO `approvestate` VALUES ('417', '1', '0', null, '1', '2017-05-30 12:44:45', '1', '\0', '119', '');
INSERT INTO `approvestate` VALUES ('418', '1', '0', null, '1', '2017-05-30 12:44:50', '1', '\0', '120', '');
INSERT INTO `approvestate` VALUES ('419', '47', '0', null, '1', '2017-05-30 13:48:58', '47', '\0', '121', '');
INSERT INTO `approvestate` VALUES ('420', '47', '419', '不同意', '0', '2017-05-30 14:01:42', '47', '', '121', '\0');
INSERT INTO `approvestate` VALUES ('421', '47', '0', null, '1', '2017-05-30 13:59:24', '47', '\0', '122', '');
INSERT INTO `approvestate` VALUES ('422', '47', '421', '不同意', '0', '2017-05-30 13:59:45', '47', '', '122', '\0');
INSERT INTO `approvestate` VALUES ('423', '47', '422', null, '2', null, '47', '\0', '122', '\0');
INSERT INTO `approvestate` VALUES ('424', '49', '0', null, '1', '2017-05-30 14:21:01', '49', '\0', '123', '');
INSERT INTO `approvestate` VALUES ('425', '49', '424', '同意', '1', '2017-05-30 14:22:01', '47', '\0', '123', '\0');
INSERT INTO `approvestate` VALUES ('426', '47', '0', null, '1', '2017-05-30 14:28:14', '47', '\0', '124', '');
INSERT INTO `approvestate` VALUES ('427', '47', '426', '可以小伙子', '1', '2017-05-31 00:51:42', '48', '\0', '124', '\0');
INSERT INTO `approvestate` VALUES ('428', '47', '427', '同意', '1', '2017-05-31 00:51:54', '47', '\0', '124', '\0');
INSERT INTO `approvestate` VALUES ('429', '48', '0', null, '1', '2017-05-31 12:10:56', '48', '\0', '125', '');
INSERT INTO `approvestate` VALUES ('430', '48', '429', '同意', '1', '2017-05-31 12:12:22', '48', '\0', '125', '\0');
INSERT INTO `approvestate` VALUES ('431', '48', '430', '4545', '1', '2017-05-31 00:12:26', '47', '\0', '125', '\0');
INSERT INTO `approvestate` VALUES ('432', '48', '431', 'hao', '1', '2017-05-31 00:12:40', '47', '\0', '125', '\0');
INSERT INTO `approvestate` VALUES ('433', '47', '0', null, '1', '2017-05-31 00:11:52', '47', '\0', '126', '');
INSERT INTO `approvestate` VALUES ('434', '47', '433', null, '2', null, '48', '', '126', '\0');
INSERT INTO `approvestate` VALUES ('435', '47', '434', null, '2', null, '47', '\0', '126', '\0');
INSERT INTO `approvestate` VALUES ('436', '47', '435', null, '2', null, '47', '\0', '126', '\0');
INSERT INTO `approvestate` VALUES ('437', '49', '0', null, '1', '2017-05-31 12:15:32', '49', '\0', '127', '');
INSERT INTO `approvestate` VALUES ('438', '49', '437', 'ok', '1', '2017-05-31 00:16:36', '48', '\0', '127', '\0');
INSERT INTO `approvestate` VALUES ('439', '49', '438', '同意', '1', '2017-05-31 12:17:36', '47', '\0', '127', '\0');
INSERT INTO `approvestate` VALUES ('440', '49', '439', null, '2', null, '47', '', '127', '\0');
INSERT INTO `approvestate` VALUES ('441', '48', '0', null, '1', '2017-05-31 01:50:31', '48', '\0', '128', '');
INSERT INTO `approvestate` VALUES ('442', '48', '441', 'jjh', '1', '2017-05-31 01:50:45', '48', '\0', '128', '\0');
INSERT INTO `approvestate` VALUES ('443', '48', '442', '同意', '1', '2017-05-31 13:51:18', '47', '\0', '128', '\0');
INSERT INTO `approvestate` VALUES ('444', '48', '443', '不同意', '0', '2017-05-31 13:51:35', '47', '', '128', '\0');

-- ----------------------------
-- Table structure for approvestateimg
-- ----------------------------
DROP TABLE IF EXISTS `approvestateimg`;
CREATE TABLE `approvestateimg` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `imgurl` varchar(200) DEFAULT NULL,
  `approvestateid` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approvestateimg
-- ----------------------------
INSERT INTO `approvestateimg` VALUES ('1', '20161108_125258_35e484ce-c0a2-47fc-be90-b2c55109c28a.png', '345');
INSERT INTO `approvestateimg` VALUES ('2', '20161108_125258_2c152d61-7ce6-4f55-8eb4-2d40c5b81167.png', '345');
INSERT INTO `approvestateimg` VALUES ('3', '20161108_125258_6976b9b6-69ed-4e71-bf6c-32b20a0d8730.png', '345');
INSERT INTO `approvestateimg` VALUES ('4', '20161108_125258_e577cc4e-2315-40e9-b1ec-2fdbca0a9dba.png', '345');
INSERT INTO `approvestateimg` VALUES ('5', '20161108_183237_2c0b58d3-0d46-4fc0-8c8e-a3e1f963771a.png', '350');
INSERT INTO `approvestateimg` VALUES ('6', '20161108_183237_594b89ed-9950-4f71-9045-5216c0dcf37e.png', '350');
INSERT INTO `approvestateimg` VALUES ('7', '20161108_185204_c2bc627a-4442-488d-aeb1-95e7be96e0c1.png', '352');
INSERT INTO `approvestateimg` VALUES ('8', '20161108_185204_d6e7df47-eca6-46e8-9e8c-22a8bf3d39fd.png', '352');
INSERT INTO `approvestateimg` VALUES ('9', '20161108_185256_ff49ec26-be0a-4940-bc18-01bd0d1a7f40.png', '353');
INSERT INTO `approvestateimg` VALUES ('10', '20161108_185256_76a3c139-450d-47c7-997c-65416a64aeff.png', '353');
INSERT INTO `approvestateimg` VALUES ('11', '20161108_185358_a2fd5466-b69d-4428-aef2-9f3888d19fea.png', '354');
INSERT INTO `approvestateimg` VALUES ('12', '20161108_185358_f3c7eaea-99e1-4e2c-8a66-ffd69e6fc07a.png', '354');
INSERT INTO `approvestateimg` VALUES ('13', '20161108_185358_586e6c1c-fffe-4c32-97b1-15db5cff6974.png', '354');
INSERT INTO `approvestateimg` VALUES ('14', '20161108_185358_b5953bd1-e270-491b-9a0e-9100305f37e0.png', '354');
INSERT INTO `approvestateimg` VALUES ('15', '20170531_135118_27bffddb-9094-43c6-b53f-9e4dfa2a6a7c.png', '443');

-- ----------------------------
-- Table structure for approve_column
-- ----------------------------
DROP TABLE IF EXISTS `approve_column`;
CREATE TABLE `approve_column` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `approvetypeid` int(20) NOT NULL,
  `approvecolumnname` varchar(20) NOT NULL,
  `approvecolumncnname` varchar(20) NOT NULL,
  `shijicolumn` varchar(20) NOT NULL,
  `viewId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve_column
-- ----------------------------
INSERT INTO `approve_column` VALUES ('1', '1', 'leavetype', '请假类型', 'varchar_2', 'leave_type_tv');
INSERT INTO `approve_column` VALUES ('2', '1', 'leaveBegintime', '开始时间', 'datetime_1', 'start_time_tv');
INSERT INTO `approve_column` VALUES ('3', '1', 'leaveEndtime', '结束时间', 'datetime_2', 'end_time_tv');
INSERT INTO `approve_column` VALUES ('4', '1', 'leavedays', '请假天数', 'int_2', 'days_tv');
INSERT INTO `approve_column` VALUES ('5', '1', 'leavereason', '请假理由', 'text_1', 'reason_tv');
INSERT INTO `approve_column` VALUES ('6', '3', 'money', '报销金额', 'decimal_1', 'expense_num_tv');
INSERT INTO `approve_column` VALUES ('7', '3', 'moneyreason', '报销明细', 'text_1', 'rexpense_reason_tv');
INSERT INTO `approve_column` VALUES ('8', '2', 'tripposition', '出差地点', 'varchar_2', 'area_tv');
INSERT INTO `approve_column` VALUES ('9', '2', 'tripbegintime', '开始时间', 'datetime_1', 'start_time_tv');
INSERT INTO `approve_column` VALUES ('10', '2', 'tripendtime', '结束时间', 'datetime_2', 'end_time_tv');
INSERT INTO `approve_column` VALUES ('11', '2', 'tripdays', '出差天数', 'int_1', 'days_tv');
INSERT INTO `approve_column` VALUES ('12', '2', 'tripreason', '出差理由', 'text_1', 'reason_tv');
INSERT INTO `approve_column` VALUES ('13', '4', 'latetime', '补签时间', 'datetime_1', 'applyment_subscribe_tv');
INSERT INTO `approve_column` VALUES ('14', '4', 'latereson', '补签理由', 'text_1', 'reason_tv');
INSERT INTO `approve_column` VALUES ('15', '3', 'moneytype', '报销类型', 'varchar_2', 'expense_type_tv');

-- ----------------------------
-- Table structure for approve_decision
-- ----------------------------
DROP TABLE IF EXISTS `approve_decision`;
CREATE TABLE `approve_decision` (
  `id` int(1) NOT NULL,
  `decision` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve_decision
-- ----------------------------
INSERT INTO `approve_decision` VALUES ('0', '拒绝');
INSERT INTO `approve_decision` VALUES ('1', '同意');
INSERT INTO `approve_decision` VALUES ('2', '还未有意见');

-- ----------------------------
-- Table structure for approve_ispass
-- ----------------------------
DROP TABLE IF EXISTS `approve_ispass`;
CREATE TABLE `approve_ispass` (
  `id` int(1) NOT NULL,
  `ispass_str` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve_ispass
-- ----------------------------
INSERT INTO `approve_ispass` VALUES ('0', '无结果');
INSERT INTO `approve_ispass` VALUES ('1', '通过');
INSERT INTO `approve_ispass` VALUES ('2', '拒绝');

-- ----------------------------
-- Table structure for approve_state_str
-- ----------------------------
DROP TABLE IF EXISTS `approve_state_str`;
CREATE TABLE `approve_state_str` (
  `id` int(1) NOT NULL,
  `state_str` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve_state_str
-- ----------------------------
INSERT INTO `approve_state_str` VALUES ('0', '审批中');
INSERT INTO `approve_state_str` VALUES ('1', '审批完成');
INSERT INTO `approve_state_str` VALUES ('2', '审批撤销');

-- ----------------------------
-- Table structure for approve_type
-- ----------------------------
DROP TABLE IF EXISTS `approve_type`;
CREATE TABLE `approve_type` (
  `id` int(10) NOT NULL,
  `approvetype_str` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of approve_type
-- ----------------------------
INSERT INTO `approve_type` VALUES ('1', '请假');
INSERT INTO `approve_type` VALUES ('2', '出差');
INSERT INTO `approve_type` VALUES ('3', '报销');
INSERT INTO `approve_type` VALUES ('4', '补签');

-- ----------------------------
-- Table structure for company_setting
-- ----------------------------
DROP TABLE IF EXISTS `company_setting`;
CREATE TABLE `company_setting` (
  `SettingId` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` bigint(20) NOT NULL,
  `onTime` varchar(255) NOT NULL,
  `offTime` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `companyTitle` varchar(255) NOT NULL,
  `companySnippet` varchar(255) NOT NULL,
  `effectiveRange` int(11) NOT NULL,
  `elasticityTime` int(11) NOT NULL,
  `lateTime` int(11) NOT NULL DEFAULT '30',
  `earliestTime` int(11) NOT NULL DEFAULT '30',
  `onRemindTime` int(11) DEFAULT NULL,
  `offRemindTime` int(11) DEFAULT NULL,
  `hardworkingTime` int(11) NOT NULL,
  `workWeeks` varchar(255) DEFAULT NULL,
  `breakWeeks` varchar(255) DEFAULT NULL,
  `isAutoBreakByLaw` bit(2) DEFAULT NULL,
  `isNextWeek` bit(2) DEFAULT NULL,
  PRIMARY KEY (`SettingId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_setting
-- ----------------------------
INSERT INTO `company_setting` VALUES ('1', '1', '09:30', '11:30', '31.274979', '120.743518', '苏州工业园区云彩创新孵化器', '仁爱路与林泉街交叉口西南150米', '300', '10', '30', '40', null, null, '0', null, null, null, null);
INSERT INTO `company_setting` VALUES ('6', '69', '10:30', '18:30', '31.895884', '120.570667', '江苏科技大学张家港校区苏州理工学院综合保障部', '北二环路附近', '350', '30', '30', '9', null, null, '6', ' 周一 周二 周三 周四 周五 ', '周六 周日 ', '\0', '\0');

-- ----------------------------
-- Table structure for holidaydate
-- ----------------------------
DROP TABLE IF EXISTS `holidaydate`;
CREATE TABLE `holidaydate` (
  `holidayId` int(11) NOT NULL AUTO_INCREMENT,
  `holidayDate` date NOT NULL,
  `versionNo` int(11) NOT NULL,
  PRIMARY KEY (`holidayId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of holidaydate
-- ----------------------------

-- ----------------------------
-- Table structure for leavetype
-- ----------------------------
DROP TABLE IF EXISTS `leavetype`;
CREATE TABLE `leavetype` (
  `id` int(20) NOT NULL,
  `leavetypename` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leavetype
-- ----------------------------
INSERT INTO `leavetype` VALUES ('1', '事假');
INSERT INTO `leavetype` VALUES ('2', '病假');
INSERT INTO `leavetype` VALUES ('3', '年假');
INSERT INTO `leavetype` VALUES ('4', '调休假');
INSERT INTO `leavetype` VALUES ('5', '婚假');
INSERT INTO `leavetype` VALUES ('6', '产假');
INSERT INTO `leavetype` VALUES ('7', '路途假');
INSERT INTO `leavetype` VALUES ('8', '其他');

-- ----------------------------
-- Table structure for nationholidaydate
-- ----------------------------
DROP TABLE IF EXISTS `nationholidaydate`;
CREATE TABLE `nationholidaydate` (
  `holidayId` bigint(11) NOT NULL AUTO_INCREMENT,
  `holidayDate` date NOT NULL,
  `versionNo` bigint(11) NOT NULL,
  PRIMARY KEY (`holidayId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nationholidaydate
-- ----------------------------
INSERT INTO `nationholidaydate` VALUES ('1', '2016-10-01', '1');
INSERT INTO `nationholidaydate` VALUES ('2', '2016-10-02', '1');
INSERT INTO `nationholidaydate` VALUES ('3', '2016-10-03', '1');
INSERT INTO `nationholidaydate` VALUES ('4', '2016-10-04', '1');
INSERT INTO `nationholidaydate` VALUES ('5', '2016-10-05', '1');
INSERT INTO `nationholidaydate` VALUES ('6', '2016-10-06', '1');
INSERT INTO `nationholidaydate` VALUES ('7', '2016-10-07', '1');
INSERT INTO `nationholidaydate` VALUES ('8', '2016-11-10', '1');
INSERT INTO `nationholidaydate` VALUES ('9', '2016-11-18', '1');

-- ----------------------------
-- Table structure for ruletemp
-- ----------------------------
DROP TABLE IF EXISTS `ruletemp`;
CREATE TABLE `ruletemp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ruletemp
-- ----------------------------

-- ----------------------------
-- Table structure for signinandoffinfo
-- ----------------------------
DROP TABLE IF EXISTS `signinandoffinfo`;
CREATE TABLE `signinandoffinfo` (
  `signInAndOffId` bigint(20) NOT NULL AUTO_INCREMENT,
  `employeeId` bigint(20) NOT NULL DEFAULT '0',
  `companyId` bigint(20) NOT NULL DEFAULT '0',
  `onTime` varchar(255) NOT NULL DEFAULT '00:00',
  `offTime` varchar(255) NOT NULL DEFAULT '00:00',
  `signDate` date NOT NULL DEFAULT '1970-01-01',
  `signInStatus` int(11) NOT NULL DEFAULT '0',
  `signOffStatus` int(11) NOT NULL DEFAULT '0',
  `workTimes` int(11) NOT NULL DEFAULT '0',
  `lateTimes` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `earlyOffTimes` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`signInAndOffId`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signinandoffinfo
-- ----------------------------
INSERT INTO `signinandoffinfo` VALUES ('151', '47', '69', '09:30', '18:33', '2017-05-29', '1', '1', '2', '2017-05-31 01:13:20', '2017-05-31 01:13:20');
INSERT INTO `signinandoffinfo` VALUES ('152', '48', '69', '09:00', '18:30', '2017-05-29', '1', '1', '0', '2017-05-31 01:12:52', '2017-05-31 01:12:52');
INSERT INTO `signinandoffinfo` VALUES ('153', '49', '69', '09:00', '18:30', '2017-05-29', '1', '1', '974', '2017-05-31 01:15:35', '2017-05-31 01:15:35');
INSERT INTO `signinandoffinfo` VALUES ('154', '50', '69', '09:00', '18:30', '2017-05-29', '1', '1', '974', '2017-05-31 01:16:06', '2017-05-31 01:16:06');
INSERT INTO `signinandoffinfo` VALUES ('155', '47', '69', '09:00', '18:30', '2017-05-30', '1', '1', '974', '2017-05-31 01:15:41', '2017-05-31 01:15:41');
INSERT INTO `signinandoffinfo` VALUES ('156', '48', '69', '09:00', '18:30', '2017-05-30', '1', '1', '11', '2017-05-31 01:15:53', '2017-05-31 01:15:53');
INSERT INTO `signinandoffinfo` VALUES ('157', '49', '69', '00:00', '00:00', '2017-05-30', '1', '1', '0', '2017-05-31 01:15:56', '2017-05-31 01:15:56');
INSERT INTO `signinandoffinfo` VALUES ('158', '50', '69', '00:00', '00:00', '2017-05-30', '1', '1', '0', '2017-05-31 01:16:12', '2017-05-31 01:16:12');
INSERT INTO `signinandoffinfo` VALUES ('159', '47', '69', '00:00', '00:00', '2017-05-28', '1', '1', '0', '2017-05-31 01:13:59', '2017-05-31 01:13:59');
INSERT INTO `signinandoffinfo` VALUES ('160', '48', '69', '00:00', '00:00', '2017-05-28', '1', '1', '0', '2017-05-31 01:16:15', '2017-05-31 01:16:15');
INSERT INTO `signinandoffinfo` VALUES ('161', '49', '69', '00:00', '00:00', '2017-05-28', '1', '1', '0', '2017-05-31 01:16:18', '2017-05-31 01:16:18');
INSERT INTO `signinandoffinfo` VALUES ('162', '50', '69', '00:00', '00:00', '2017-05-28', '1', '1', '0', '2017-05-31 01:16:23', '2017-05-31 01:16:23');
INSERT INTO `signinandoffinfo` VALUES ('163', '47', '69', '00:00', '00:00', '2017-05-27', '1', '1', '0', '2017-05-31 01:14:29', '2017-05-31 01:14:29');
INSERT INTO `signinandoffinfo` VALUES ('164', '48', '69', '00:00', '00:00', '2017-05-27', '1', '1', '0', '2017-05-31 01:16:30', '2017-05-31 01:16:30');
INSERT INTO `signinandoffinfo` VALUES ('165', '49', '69', '00:00', '00:00', '2017-05-27', '1', '1', '0', '2017-05-31 01:16:46', '2017-05-31 01:16:46');
INSERT INTO `signinandoffinfo` VALUES ('166', '50', '69', '00:00', '00:00', '2017-05-27', '1', '1', '0', '2017-05-31 01:16:54', '2017-05-31 01:16:54');
INSERT INTO `signinandoffinfo` VALUES ('167', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('168', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('169', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('170', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('171', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('172', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('173', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('174', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('175', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('176', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('177', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('178', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('179', '49', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('180', '49', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('181', '49', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('182', '49', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('183', '49', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('184', '49', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('185', '49', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('186', '49', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('187', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('188', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('189', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('190', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('191', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('192', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('193', '48', '69', '00:00', '00:00', '2017-05-31', '4', '0', '0', null, null);
INSERT INTO `signinandoffinfo` VALUES ('194', '48', '69', '00:00', '00:00', '2017-06-01', '4', '0', '0', null, null);

-- ----------------------------
-- Table structure for tannouncement
-- ----------------------------
DROP TABLE IF EXISTS `tannouncement`;
CREATE TABLE `tannouncement` (
  `aid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `atitle` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `authorId` varchar(255) DEFAULT NULL,
  `acontent` text,
  `atime` varchar(255) DEFAULT NULL,
  `img_1` varchar(255) DEFAULT NULL,
  `img_2` varchar(255) DEFAULT NULL,
  `img_3` varchar(255) DEFAULT NULL,
  `img_4` varchar(255) DEFAULT NULL,
  `img_5` varchar(255) DEFAULT NULL,
  `img_6` varchar(255) DEFAULT NULL,
  `img_7` varchar(255) DEFAULT NULL,
  `img_8` varchar(255) DEFAULT NULL,
  `img_9` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tannouncement
-- ----------------------------
INSERT INTO `tannouncement` VALUES ('1', '开会', '刘菲炫', '1', '今晚12.30在办公室准时开会', '2016-8-21', 'emotion_003.png', null, null, null, null, null, null, null, null);
INSERT INTO `tannouncement` VALUES ('14', 'heiheihei1', 'h', '1', 'aaaaaaaaaa', '2016-11-04', '20161104_082705_a1d2007c-7222-4630-8926-f6157baf54cb.png', 'http://10.40.5.56:8080/Xutils//upload/20161104_082705_a1d2007c-7222-4630-8926-f6157baf54cb.png', 'http://10.40.5.56:8080/Xutils//upload/20161104_082705_a1d2007c-7222-4630-8926-f6157baf54cb.png', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('15', 'aa', 'h', '1', 'ag', '2016-11-04', '20161104_083750_f4bfc848-51b9-47ac-9488-359441b415fc.png', 'http://10.40.5.56:8080/Xutils//upload/20161104_083750_f4bfc848-51b9-47ac-9488-359441b415fc.png', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('16', 'aha', 'h', '1', 'doctor strange', '2016-11-05', '', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('17', 'hahahah', '刘', '1', 'aaaaaa', '2016-11-08', '20161108_073505_51a01133-266c-4434-a5c1-bed09a694c79.png', 'http://10.40.5.56:8080/Xutils//upload/20161108_073505_51a01133-266c-4434-a5c1-bed09a694c79.png', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('18', 'biaoti', '柴攀峰', '3', 'this is neirong', '2016-11-08', '20161108_044251_979b2048-34c8-4e36-b738-a986e2620877.png', 'http://10.40.5.56:8080/Xutils//upload/20161108_044251_979b2048-34c8-4e36-b738-a986e2620877.png', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('19', 'ooo', '柴攀峰', '3', 'jjja', '2016-11-08', '20161108_055558_6bd3bcea-6cd4-490c-abd7-6e5f88a40f02.png', 'http://10.40.5.56:8080/Xutils//upload/20161108_055558_6bd3bcea-6cd4-490c-abd7-6e5f88a40f02.png', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('20', 'this is gonggao', 'liu', '4', 'kdkdkkdkkdkdkdk', '2016-11-08', '20161108_065539_89756ceb-6e35-4523-96cf-0dcfed5b08ad.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('21', '这是', 'liu', '4', '罢了', '2016-11-09', '20161109_091509_00e46335-a46f-4a9f-8d42-af0aa594f583.png', 'http://10.40.5.51:8080/Xutils//upload/20161109_091509_00e46335-a46f-4a9f-8d42-af0aa594f583.png', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('22', '这是', 'liu', '4', '罢了', '2016-11-09', '20161109_091509_00e46335-a46f-4a9f-8d42-af0aa594f583.png', 'http://10.40.5.51:8080/Xutils//upload/20161109_091509_00e46335-a46f-4a9f-8d42-af0aa594f583.png', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('23', '158', 'liu', '4', '155', '2016-11-09', '20161109_091612_2fc58085-2b95-4136-bc14-86977dd22aff.png', 'http://10.40.5.51:8080/Xutils//upload/20161109_091612_2fc58085-2b95-4136-bc14-86977dd22aff.png', 'http://10.40.5.51:8080/Xutils//upload/20161109_091612_2fc58085-2b95-4136-bc14-86977dd22aff.png', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('24', '3', '刘', '1', '33', '2016-11-08', '20161108_205022_bfbc8777-87c7-4467-89b9-3294736316b5.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('25', '33', '刘', '1', '333', '2016-11-08', '20161108_210030_e0ba94a4-6d78-44aa-b2fe-6875262479d6.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('26', '明天此时', '刘', '1', '开会', '2017-04-16', '20170416_172539_ee4aa079-ae03-4d77-b541-52ef8f83a0c0.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('27', '测试号', '18151587320', '47', '来咯来咯', '2017-05-29', '20170529_231401_f27081e8-406d-470d-bc19-1a76843bd23b.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('28', '测试号', '18151587320', '47', '来咯来咯', '2017-05-29', '20170529_231401_f27081e8-406d-470d-bc19-1a76843bd23b.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('29', '测试号', '18151587320', '47', '来咯来咯', '2017-05-29', '20170529_231401_f27081e8-406d-470d-bc19-1a76843bd23b.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('30', '啦啦啦', '刘', '1', '开会了', '2017-05-30', '20170530_104559_92b94b0b-97d1-4f18-b49d-a9388307d007.png', '', '', '', '', '', '', '', '');
INSERT INTO `tannouncement` VALUES ('31', '同意', '张三', '47', '同', '2017-05-31', '20170531_135521_2b891358-c3b8-4c13-bad4-c066ac1a9119.png', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for tchatgroup
-- ----------------------------
DROP TABLE IF EXISTS `tchatgroup`;
CREATE TABLE `tchatgroup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chatgroup_name` varchar(255) DEFAULT NULL,
  `chatgroup_id` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `chatgroup_id` (`chatgroup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tchatgroup
-- ----------------------------
INSERT INTO `tchatgroup` VALUES ('108', '张三、刘菲炫、李四、小明', '0f787e74-8d10-48f7-b00e-8771c7ef17d7', '2017-05-30 18:06:18');
INSERT INTO `tchatgroup` VALUES ('109', '刘菲炫、李四、小明、张三', 'ed0fc2e8-1e0b-4090-90d7-0454f225c09d', '2017-05-31 00:49:02');

-- ----------------------------
-- Table structure for tchatgrouprelation
-- ----------------------------
DROP TABLE IF EXISTS `tchatgrouprelation`;
CREATE TABLE `tchatgrouprelation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `tcg_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tcg_id` (`tcg_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tchatgrouprelation_ibfk_3` FOREIGN KEY (`tcg_id`) REFERENCES `tchatgroup` (`chatgroup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=528 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tchatgrouprelation
-- ----------------------------
INSERT INTO `tchatgrouprelation` VALUES ('519', '18151587320', '0f787e74-8d10-48f7-b00e-8771c7ef17d7');
INSERT INTO `tchatgrouprelation` VALUES ('520', '18151587321', '0f787e74-8d10-48f7-b00e-8771c7ef17d7');
INSERT INTO `tchatgrouprelation` VALUES ('521', '18151587322', '0f787e74-8d10-48f7-b00e-8771c7ef17d7');
INSERT INTO `tchatgrouprelation` VALUES ('523', '18151587331', 'ed0fc2e8-1e0b-4090-90d7-0454f225c09d');
INSERT INTO `tchatgrouprelation` VALUES ('524', '18151587332', 'ed0fc2e8-1e0b-4090-90d7-0454f225c09d');
INSERT INTO `tchatgrouprelation` VALUES ('525', '18151587334', 'ed0fc2e8-1e0b-4090-90d7-0454f225c09d');
INSERT INTO `tchatgrouprelation` VALUES ('527', '18151587330', 'ed0fc2e8-1e0b-4090-90d7-0454f225c09d');

-- ----------------------------
-- Table structure for tcompany
-- ----------------------------
DROP TABLE IF EXISTS `tcompany`;
CREATE TABLE `tcompany` (
  `tc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tc_name` varchar(255) DEFAULT NULL,
  `tc_createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `tc_type` varchar(255) DEFAULT NULL,
  `tc_area` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tc_id`),
  UNIQUE KEY `tc_name` (`tc_name`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcompany
-- ----------------------------
INSERT INTO `tcompany` VALUES ('1', '刘氏集团', '2016-11-08 09:18:26', '软件', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('2', '张氏集团', '2016-10-12 11:46:17', null, null);
INSERT INTO `tcompany` VALUES ('3', '柴氏集团', '2016-10-27 11:46:18', '帝国', '地球');
INSERT INTO `tcompany` VALUES ('4', 'chai', '2016-10-19 11:46:13', 'll', 'hh');
INSERT INTO `tcompany` VALUES ('5', 'jiji', '2016-10-31 21:33:38', 'aa', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('8', 'jiji1', '2016-10-31 21:41:36', 'aaa', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('11', 'hahaha', '2016-10-31 21:50:04', 'aaa', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('12', 'hahaha1', '2016-10-31 21:51:02', 'aaa', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('13', 'LJ\nLJ', '2016-10-31 21:53:16', 'aaa', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('14', 'LJ\nLJ1', '2016-10-31 21:53:57', 'aaa', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('15', '蝙蝠侠', '2016-11-09 00:25:24', 'aa', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('16', null, '2016-11-08 15:04:19', null, null);
INSERT INTO `tcompany` VALUES ('17', 'buzhidao', '2016-11-08 19:04:37', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('35', 'fefefe', '2016-11-08 23:57:23', 'fefe', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('36', 'hhhhhh', '2016-11-09 00:07:04', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('37', '', '2016-11-09 00:10:54', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('40', 'hhhh', '2016-11-09 00:19:52', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('41', 'com', '2016-11-09 00:27:16', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('43', 'rrrr', '2016-11-09 00:33:49', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('44', 'rrr', '2016-11-09 00:38:12', 'r', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('45', '4444', '2016-11-09 00:41:36', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('46', '33333', '2016-11-09 00:50:19', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('47', '3333', '2016-11-09 01:07:30', 'grgr', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('48', '333', '2016-11-09 02:09:31', 'rtrt', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('49', '334324', '2016-11-09 02:10:46', 'e324532', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('52', 'fdsfsd', '2016-11-09 02:12:33', 'dsfsdf', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('56', '3', '2016-11-09 02:15:31', '', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('57', 'eff', '2016-11-09 02:16:30', 'efef', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('62', 'fff', '2016-11-09 02:21:24', 'ffff,', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('63', 'grgr', '2016-11-09 02:26:28', 'rgrg', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('64', '3123', '2016-11-09 02:29:41', '123123', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('65', 'grre', '2016-11-09 02:31:56', 'greger', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('66', 'e', '2016-11-09 03:51:06', 'rgre', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('67', 'r4r', '2016-11-09 03:54:07', '4t4', '江苏-苏州');
INSERT INTO `tcompany` VALUES ('68', '测试公司', '2017-05-14 15:23:17', '教育', '北京市-县-密云县');
INSERT INTO `tcompany` VALUES ('69', '南京金贝网络公司', '2017-05-30 13:43:15', '互联网', '江苏-苏州');

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text` (
  `id` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of text
-- ----------------------------

-- ----------------------------
-- Table structure for tgroup
-- ----------------------------
DROP TABLE IF EXISTS `tgroup`;
CREATE TABLE `tgroup` (
  `tg_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(64) DEFAULT NULL,
  `parent_tg_id` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `tc_id` bigint(20) NOT NULL,
  `tg_leader` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`tg_id`),
  KEY `tc_id` (`tc_id`),
  KEY `tg_leader` (`tg_leader`),
  CONSTRAINT `tgroup_ibfk_1` FOREIGN KEY (`tc_id`) REFERENCES `tcompany` (`tc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tgroup
-- ----------------------------
INSERT INTO `tgroup` VALUES ('1', '高级软件开发组', '0', '创建一个团队更好的沟通', '1', '5');
INSERT INTO `tgroup` VALUES ('6', '特种软件师', '0', '测试公司', '2', null);
INSERT INTO `tgroup` VALUES ('7', '特A', '6', '测试公司下a部门', '2', null);
INSERT INTO `tgroup` VALUES ('8', '特B', '6', '测试公司下B部门', '2', null);
INSERT INTO `tgroup` VALUES ('9', '特A1', '7', '特a下部门', '2', null);
INSERT INTO `tgroup` VALUES ('66', '222222', '64', '', '1', null);
INSERT INTO `tgroup` VALUES ('67', '3333333', '66', '', '1', null);
INSERT INTO `tgroup` VALUES ('68', '111111', '63', '', '1', null);
INSERT INTO `tgroup` VALUES ('78', 'jiji', '0', '默认', '5', null);
INSERT INTO `tgroup` VALUES ('81', 'jiji1', '0', '默认', '8', null);
INSERT INTO `tgroup` VALUES ('84', 'hahaha', '0', '默认', '11', null);
INSERT INTO `tgroup` VALUES ('85', 'hahaha1', '0', '默认', '12', null);
INSERT INTO `tgroup` VALUES ('86', 'LJ\nLJ', '0', '默认', '13', null);
INSERT INTO `tgroup` VALUES ('87', 'LJ\nLJ1', '0', '默认', '14', null);
INSERT INTO `tgroup` VALUES ('88', '刘氏集团', '0', '默认', '15', null);
INSERT INTO `tgroup` VALUES ('104', '22222', '113', '', '1', '1');
INSERT INTO `tgroup` VALUES ('109', 'Android部', '88', '', '15', '6');
INSERT INTO `tgroup` VALUES ('110', 'Java部', '88', '', '15', null);
INSERT INTO `tgroup` VALUES ('111', 'hhaha', '110', '', '15', null);
INSERT INTO `tgroup` VALUES ('112', 'text', '1', '', '1', null);
INSERT INTO `tgroup` VALUES ('113', '3333', '112', '', '1', null);
INSERT INTO `tgroup` VALUES ('114', '3333', '112', '', '1', null);
INSERT INTO `tgroup` VALUES ('115', 'Android架构部', '109', 'rrrrr', '15', null);
INSERT INTO `tgroup` VALUES ('116', null, '0', '默认', '16', null);
INSERT INTO `tgroup` VALUES ('117', '222', '112', '', '1', null);
INSERT INTO `tgroup` VALUES ('118', 'buzhidao', '0', '默认', '17', null);
INSERT INTO `tgroup` VALUES ('136', 'fefefe', '0', '默认', '35', null);
INSERT INTO `tgroup` VALUES ('137', 'hhhhhh', '0', '默认', '36', null);
INSERT INTO `tgroup` VALUES ('138', '', '0', '默认', '37', null);
INSERT INTO `tgroup` VALUES ('141', 'hhhh', '0', '默认', '40', null);
INSERT INTO `tgroup` VALUES ('142', 'com', '0', '默认', '41', null);
INSERT INTO `tgroup` VALUES ('144', 'rrrr', '0', '默认', '43', null);
INSERT INTO `tgroup` VALUES ('145', 'rrr', '0', '默认', '44', null);
INSERT INTO `tgroup` VALUES ('146', '4444', '0', '默认', '45', null);
INSERT INTO `tgroup` VALUES ('147', '33333', '0', '默认', '46', null);
INSERT INTO `tgroup` VALUES ('148', '2222', '147', '', '46', null);
INSERT INTO `tgroup` VALUES ('149', '3333', '0', '默认', '47', null);
INSERT INTO `tgroup` VALUES ('150', '333', '0', '默认', '48', null);
INSERT INTO `tgroup` VALUES ('151', '334324', '0', '默认', '49', null);
INSERT INTO `tgroup` VALUES ('154', 'fdsfsd', '0', '默认', '52', null);
INSERT INTO `tgroup` VALUES ('158', '3', '0', '默认', '56', null);
INSERT INTO `tgroup` VALUES ('159', 'eff', '0', '默认', '57', null);
INSERT INTO `tgroup` VALUES ('164', 'fff', '0', '默认', '62', null);
INSERT INTO `tgroup` VALUES ('165', 'grgr', '0', '默认', '63', null);
INSERT INTO `tgroup` VALUES ('166', '3123', '0', '默认', '64', null);
INSERT INTO `tgroup` VALUES ('167', 'grre', '0', '默认', '65', null);
INSERT INTO `tgroup` VALUES ('168', 'e', '0', '默认', '66', null);
INSERT INTO `tgroup` VALUES ('169', 'r4r', '0', '默认', '67', null);
INSERT INTO `tgroup` VALUES ('170', '测试公司', '0', '默认', '68', null);
INSERT INTO `tgroup` VALUES ('182', '南京金贝网络公司', '0', '默认', '69', '47');
INSERT INTO `tgroup` VALUES ('183', '开发部', '182', '负责程序的运行', '69', '48');
INSERT INTO `tgroup` VALUES ('184', 'Java开发部', '183', '', '69', '51');
INSERT INTO `tgroup` VALUES ('191', '技术部', '183', '', '69', '0');
INSERT INTO `tgroup` VALUES ('192', 'Android', '183', '', '69', '0');
INSERT INTO `tgroup` VALUES ('193', '部门', '183', '', '69', '0');

-- ----------------------------
-- Table structure for tright
-- ----------------------------
DROP TABLE IF EXISTS `tright`;
CREATE TABLE `tright` (
  `tr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_tr_id` bigint(20) DEFAULT NULL,
  `right_name` varchar(64) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tright
-- ----------------------------
INSERT INTO `tright` VALUES ('1', '0', '添加成员', '对成员进行添加');
INSERT INTO `tright` VALUES ('2', '0', '修改成员', '对成员信息修改');
INSERT INTO `tright` VALUES ('3', '0', '删除成员', '对成员删除');

-- ----------------------------
-- Table structure for trole
-- ----------------------------
DROP TABLE IF EXISTS `trole`;
CREATE TABLE `trole` (
  `tr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_tr_id` int(11) DEFAULT NULL,
  `role_name` varchar(64) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`tr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trole
-- ----------------------------
INSERT INTO `trole` VALUES ('1', '0', '董事长', '公司最高执行人员');
INSERT INTO `trole` VALUES ('2', '1', '经理', '直接向1汇报');
INSERT INTO `trole` VALUES ('3', '2', '部门经理', '向2汇报');
INSERT INTO `trole` VALUES ('4', '3', '普通员工', '向3汇报');

-- ----------------------------
-- Table structure for trolerightrelation
-- ----------------------------
DROP TABLE IF EXISTS `trolerightrelation`;
CREATE TABLE `trolerightrelation` (
  `trr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `right_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`trr_id`),
  KEY `role_id` (`role_id`),
  KEY `right_id` (`right_id`),
  CONSTRAINT `trolerightrelation_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `trole` (`tr_id`),
  CONSTRAINT `trolerightrelation_ibfk_2` FOREIGN KEY (`right_id`) REFERENCES `tright` (`tr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trolerightrelation
-- ----------------------------
INSERT INTO `trolerightrelation` VALUES ('1', '1', '2');
INSERT INTO `trolerightrelation` VALUES ('2', '1', '1');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `tu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT '2016-01-01 00:00:00',
  `address` varchar(255) DEFAULT NULL,
  `sex` int(1) DEFAULT '2',
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tu_id`),
  KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('1', '刘', '11', '4', 'keY/uCA587oie31peUb/Nb5QEts3ESg56W6fon4Q6qNWCShSFm5munzCccZo7M4ewGy97WDy3kaTQLXR3SXUwA==', '20170529_230309_471884f6-0499-43b1-a61b-155283e16a8b.png', '2016-10-18 00:00:00', '北京市-县-密云县', '0', 'boss');
INSERT INTO `tuser` VALUES ('2', '刘广永', '1', '1', 'Tfow9pnvoQp0O3w0DW3T8r0pvN45C/mHhbkqwRE514Xj/0kNkV32N5E1p7Wd5bqgG7RBmltW4bk=', 'emotion_002.png', '2016-10-11 19:03:50', null, '0', null);
INSERT INTO `tuser` VALUES ('3', 'chaipanfen', '1', '2', 'D9mMMn37M7r/6uViQHmn5UFNk1Z/VBs0h4MxQpbm08FD2hLD2M1skK95dLjA6vLODtpu2Tgn1eE=', 'emotion_003.png', '1991-01-24 00:00:00', '江苏-苏州', '0', null);
INSERT INTO `tuser` VALUES ('4', 'liu', '11', '3', 'zVWZnIT9y3cK8V+5jWQepUFNk1Z/VBs0h4MxQpbm08FD2hLD2M1skLp60gn14HKxWUUfSbmAEVM=', 'emotion_004.png', '1991-01-24 00:00:00', '江苏-苏州', '0', null);
INSERT INTO `tuser` VALUES ('5', 'jack', 'aaa', '5', '3zvskJJAfCUKESUJJ6AFBb5QEts3ESg56W6fon4Q6qNWCShSFm5musBZ90ZW/dzdwEMnJAg4Hg2TQLXR3SXUwA==', 'emotion_005.png', '2016-10-04 19:03:47', null, '1', '程序员');
INSERT INTO `tuser` VALUES ('6', '金jia', '333', '120', null, 'emotion_006.png', '2016-10-04 19:03:53', null, '0', null);
INSERT INTO `tuser` VALUES ('7', '曹读明', '222', '190', null, 'emotion_007.png', '2016-10-26 19:03:56', null, null, null);
INSERT INTO `tuser` VALUES ('8', '刘五', '111', '111', null, 'emotion_001.png', '2016-10-27 19:03:59', null, '0', null);
INSERT INTO `tuser` VALUES ('9', '刘四', '111', '222', null, 'emotion_002.png', '2016-10-12 19:04:02', null, null, null);
INSERT INTO `tuser` VALUES ('10', '张三', '2323', '333', 'COQ1V0Z7AYlIUOjOrmfCDipojLRe4fpqbbyzSmBW1SYxJX+1zXbuf9xyYHQxY3akpEetQa7QWF32Zd651W4KRQ==', 'emotion_003.png', '2016-10-12 19:04:06', null, null, null);
INSERT INTO `tuser` VALUES ('11', '柴', '44', '18862601582', null, 'emotion_004.png', '2016-10-19 19:04:17', null, '0', null);
INSERT INTO `tuser` VALUES ('28', '皇帝', 'qweQWE1', '13196889273', 'q0dnG4CTS9d0O3w0DW3T8r0pvN45C/mHhbkqwRE514WzP5CRjtiZ+Y1fYhB3I7Jdkf3aJhnyk7vDuWYAQpQkOOZQFmOj7CvS', 'emotion_005.png', '2016-01-01 00:00:00', '江苏省', '1', 'carry');
INSERT INTO `tuser` VALUES ('30', 'he', 'qwe123Q', '18151587329', 'ES25M8CGzAttz3W4V1P+175QEts3ESg56W6fon4Q6qNWCShSFm5musfoUsHRezO3Km/q1pIRGUwwCAXi02kQd/rgCmYAW20v', 'emotion_006.png', '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('31', 'dage', 'Tage123', '15751009576', 'tTvvimmV7haHaOnAWt36T75QEts3ESg56W6fon4Q6qNWCShSFm5muuBbe+wym+P4WlfcWrfsi5UP3d8ce7RYXylN59xC2QNU', 'emotion_007.png', '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('32', '刘菲炫', '0', '123', 'vy11GEPICD2Gkw5ZGO+pDkFNk1Z/VBs0h4MxQpbm08EUBrHWiQWL8sq6esN+qIyx9zmY4qKbGeM=', 'emotion_001.png', '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('33', 'gay', '9', '9', null, 'emotion_002.png', '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('34', 'contestuser', '334', '334', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('35', 'contestuse11', '335', '335', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('36', 'drewrdew', '336', '336', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('37', 'dedf', '338', '338', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('38', 'rewrwe', '330', '330', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('39', 'efewfwe', '339', '339', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('40', 'efgwe', '340', '340', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('41', '341', '341', '341', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('42', '342', '342', '342', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('43', '344', '344', '344', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('44', '345', '345', '345', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('45', '400', '400', '400', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('46', '401', '401', '401', null, null, '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('47', '张三', '123', '18151587330', 'udQdistC/9b/atQYkRb2Gr5QEts3ESg56W6fon4Q6qNKXmoZWEaBfUXJjb6XrWG+ZtnJG8iZ/hMwCAXi02kQd40mLTjFiPVT', 'emotion_002.png', '2016-01-01 12:00:00', '北京市-县-密云县', '0', null);
INSERT INTO `tuser` VALUES ('48', '刘菲炫', '123', '18151587331', '9nOnwT2QMZJh63Y+GN0oIL5QEts3ESg56W6fon4Q6qNKXmoZWEaBfS+PJZQGaWWCZDd60MbGKGEwCAXi02kQd3BICoOWwEVr', 'emotion_003.png', '2016-01-01 12:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('49', '李四', '123', '18151587332', 'kcKLdYp0GMUHfkgjjiGDyCpojLRe4fpqbbyzSmBW1SbwAXTtA+B8Nh+zKEasLMkEQBibCDUePqdL5Jiu4ANGxvehtu3x2NXY', 'emotion_007.png', '2016-01-01 12:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('50', '王五', '123', '18151587333', 'BVh9syAAie/I3Nd7DvoxDr5QEts3ESg56W6fon4Q6qNKXmoZWEaBfSF4uqa6DNhDVA7/1BMVh/owCAXi02kQd6097XzXHWiB', 'emotion_006.png', '2016-01-01 00:00:00', null, '2', null);
INSERT INTO `tuser` VALUES ('51', '小明', '123', '18151587334', 'prMSVbye+f//qLUbrpXuTipojLRe4fpqbbyzSmBW1SbwAXTtA+B8Nqjm5gAj8YxFRTVOcERXh0VL5Jiu4ANGxv8i2K8f3uRf', 'emotion_003.png', '2016-01-01 12:00:00', null, '2', null);

-- ----------------------------
-- Table structure for tusergrouprelation
-- ----------------------------
DROP TABLE IF EXISTS `tusergrouprelation`;
CREATE TABLE `tusergrouprelation` (
  `tug_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tu_id` bigint(20) DEFAULT NULL,
  `tg_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`tug_id`),
  KEY `tu_id` (`tu_id`),
  KEY `tg_id` (`tg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tusergrouprelation
-- ----------------------------
INSERT INTO `tusergrouprelation` VALUES ('5', '5', '113');
INSERT INTO `tusergrouprelation` VALUES ('53', '7', '84');
INSERT INTO `tusergrouprelation` VALUES ('55', '7', '85');
INSERT INTO `tusergrouprelation` VALUES ('57', '7', '86');
INSERT INTO `tusergrouprelation` VALUES ('59', '7', '87');
INSERT INTO `tusergrouprelation` VALUES ('62', '7', '104');
INSERT INTO `tusergrouprelation` VALUES ('75', '2', '111');
INSERT INTO `tusergrouprelation` VALUES ('81', '28', '1');
INSERT INTO `tusergrouprelation` VALUES ('82', '30', '1');
INSERT INTO `tusergrouprelation` VALUES ('85', '3', '104');
INSERT INTO `tusergrouprelation` VALUES ('86', '1', '110');
INSERT INTO `tusergrouprelation` VALUES ('93', '1', '110');
INSERT INTO `tusergrouprelation` VALUES ('101', '9', '1');
INSERT INTO `tusergrouprelation` VALUES ('104', '31', '1');
INSERT INTO `tusergrouprelation` VALUES ('142', '40', '158');
INSERT INTO `tusergrouprelation` VALUES ('143', '40', '159');
INSERT INTO `tusergrouprelation` VALUES ('148', '41', '164');
INSERT INTO `tusergrouprelation` VALUES ('149', '42', '165');
INSERT INTO `tusergrouprelation` VALUES ('150', '43', '166');
INSERT INTO `tusergrouprelation` VALUES ('151', '44', '167');
INSERT INTO `tusergrouprelation` VALUES ('152', '34', '168');
INSERT INTO `tusergrouprelation` VALUES ('153', '45', '169');
INSERT INTO `tusergrouprelation` VALUES ('154', '2', '111');
INSERT INTO `tusergrouprelation` VALUES ('190', '6', '109');
INSERT INTO `tusergrouprelation` VALUES ('192', '47', '183');
INSERT INTO `tusergrouprelation` VALUES ('193', '48', '183');
INSERT INTO `tusergrouprelation` VALUES ('194', '49', '193');
INSERT INTO `tusergrouprelation` VALUES ('195', '51', '192');
INSERT INTO `tusergrouprelation` VALUES ('196', '50', '193');

-- ----------------------------
-- Table structure for tuserrolerelation
-- ----------------------------
DROP TABLE IF EXISTS `tuserrolerelation`;
CREATE TABLE `tuserrolerelation` (
  `tur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tu_id` bigint(20) DEFAULT NULL,
  `tr_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`tur_id`),
  KEY `tu_id` (`tu_id`),
  KEY `tr_id` (`tr_id`),
  CONSTRAINT `tuserrolerelation_ibfk_1` FOREIGN KEY (`tu_id`) REFERENCES `tuser` (`tu_id`),
  CONSTRAINT `tuserrolerelation_ibfk_2` FOREIGN KEY (`tr_id`) REFERENCES `trole` (`tr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuserrolerelation
-- ----------------------------
INSERT INTO `tuserrolerelation` VALUES ('2', '1', '2');
INSERT INTO `tuserrolerelation` VALUES ('3', '2', '3');
INSERT INTO `tuserrolerelation` VALUES ('4', '3', '3');
INSERT INTO `tuserrolerelation` VALUES ('40', '45', '1');
INSERT INTO `tuserrolerelation` VALUES ('41', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('42', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('43', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('44', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('45', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('46', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('47', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('48', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('49', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('50', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('51', '47', '1');
INSERT INTO `tuserrolerelation` VALUES ('52', '47', '1');

-- ----------------------------
-- Table structure for workday
-- ----------------------------
DROP TABLE IF EXISTS `workday`;
CREATE TABLE `workday` (
  `workdayId` bigint(20) NOT NULL AUTO_INCREMENT,
  `workdayDate` date NOT NULL,
  `companyId` bigint(20) NOT NULL,
  PRIMARY KEY (`workdayId`)
) ENGINE=InnoDB AUTO_INCREMENT=608 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workday
-- ----------------------------
INSERT INTO `workday` VALUES ('1', '2016-11-07', '1');
INSERT INTO `workday` VALUES ('2', '2016-11-08', '1');
INSERT INTO `workday` VALUES ('3', '2016-11-09', '1');
INSERT INTO `workday` VALUES ('4', '2016-11-10', '1');
INSERT INTO `workday` VALUES ('5', '2016-11-11', '1');
INSERT INTO `workday` VALUES ('6', '2016-11-12', '1');
INSERT INTO `workday` VALUES ('7', '2016-11-14', '1');
INSERT INTO `workday` VALUES ('8', '2016-11-15', '1');
INSERT INTO `workday` VALUES ('9', '2016-11-16', '1');
INSERT INTO `workday` VALUES ('10', '2016-11-17', '1');
INSERT INTO `workday` VALUES ('11', '2016-11-18', '1');
INSERT INTO `workday` VALUES ('12', '2016-11-19', '1');
INSERT INTO `workday` VALUES ('13', '2016-11-21', '1');
INSERT INTO `workday` VALUES ('14', '2016-11-22', '1');
INSERT INTO `workday` VALUES ('15', '2016-11-23', '1');
INSERT INTO `workday` VALUES ('16', '2016-11-24', '1');
INSERT INTO `workday` VALUES ('17', '2016-11-25', '1');
INSERT INTO `workday` VALUES ('18', '2016-11-26', '1');
INSERT INTO `workday` VALUES ('19', '2016-11-28', '1');
INSERT INTO `workday` VALUES ('20', '2016-11-29', '1');
INSERT INTO `workday` VALUES ('21', '2016-11-30', '1');
INSERT INTO `workday` VALUES ('22', '2016-12-01', '1');
INSERT INTO `workday` VALUES ('23', '2016-12-02', '1');
INSERT INTO `workday` VALUES ('24', '2016-12-03', '1');
INSERT INTO `workday` VALUES ('25', '2016-12-05', '1');
INSERT INTO `workday` VALUES ('26', '2016-12-06', '1');
INSERT INTO `workday` VALUES ('27', '2016-12-07', '1');
INSERT INTO `workday` VALUES ('28', '2016-12-08', '1');
INSERT INTO `workday` VALUES ('29', '2016-12-09', '1');
INSERT INTO `workday` VALUES ('30', '2016-12-10', '1');
INSERT INTO `workday` VALUES ('31', '2016-12-12', '1');
INSERT INTO `workday` VALUES ('32', '2016-12-13', '1');
INSERT INTO `workday` VALUES ('33', '2016-12-14', '1');
INSERT INTO `workday` VALUES ('34', '2016-12-15', '1');
INSERT INTO `workday` VALUES ('35', '2016-12-16', '1');
INSERT INTO `workday` VALUES ('36', '2016-12-17', '1');
INSERT INTO `workday` VALUES ('37', '2016-12-19', '1');
INSERT INTO `workday` VALUES ('38', '2016-12-20', '1');
INSERT INTO `workday` VALUES ('39', '2016-12-21', '1');
INSERT INTO `workday` VALUES ('40', '2016-12-22', '1');
INSERT INTO `workday` VALUES ('41', '2016-12-23', '1');
INSERT INTO `workday` VALUES ('42', '2016-12-24', '1');
INSERT INTO `workday` VALUES ('43', '2016-12-26', '1');
INSERT INTO `workday` VALUES ('44', '2016-12-27', '1');
INSERT INTO `workday` VALUES ('45', '2016-12-28', '1');
INSERT INTO `workday` VALUES ('46', '2016-12-29', '1');
INSERT INTO `workday` VALUES ('47', '2016-12-30', '1');
INSERT INTO `workday` VALUES ('48', '2016-12-31', '1');
INSERT INTO `workday` VALUES ('49', '2017-01-02', '1');
INSERT INTO `workday` VALUES ('50', '2017-01-03', '1');
INSERT INTO `workday` VALUES ('51', '2017-01-04', '1');
INSERT INTO `workday` VALUES ('52', '2016-11-02', '1');
INSERT INTO `workday` VALUES ('53', '2016-11-03', '1');
INSERT INTO `workday` VALUES ('54', '2016-11-04', '1');
INSERT INTO `workday` VALUES ('55', '2016-11-05', '1');
INSERT INTO `workday` VALUES ('56', '2016-11-06', '1');
INSERT INTO `workday` VALUES ('87', '2017-05-31', '15');
INSERT INTO `workday` VALUES ('88', '2017-06-01', '15');
INSERT INTO `workday` VALUES ('89', '2017-06-02', '15');
INSERT INTO `workday` VALUES ('90', '2017-06-03', '15');
INSERT INTO `workday` VALUES ('91', '2017-06-05', '15');
INSERT INTO `workday` VALUES ('92', '2017-06-06', '15');
INSERT INTO `workday` VALUES ('93', '2017-06-07', '15');
INSERT INTO `workday` VALUES ('94', '2017-06-08', '15');
INSERT INTO `workday` VALUES ('95', '2017-06-09', '15');
INSERT INTO `workday` VALUES ('96', '2017-06-10', '15');
INSERT INTO `workday` VALUES ('97', '2017-06-12', '15');
INSERT INTO `workday` VALUES ('98', '2017-06-13', '15');
INSERT INTO `workday` VALUES ('99', '2017-06-14', '15');
INSERT INTO `workday` VALUES ('100', '2017-06-15', '15');
INSERT INTO `workday` VALUES ('101', '2017-06-16', '15');
INSERT INTO `workday` VALUES ('102', '2017-06-17', '15');
INSERT INTO `workday` VALUES ('103', '2017-06-19', '15');
INSERT INTO `workday` VALUES ('104', '2017-06-20', '15');
INSERT INTO `workday` VALUES ('105', '2017-06-21', '15');
INSERT INTO `workday` VALUES ('106', '2017-06-22', '15');
INSERT INTO `workday` VALUES ('107', '2017-06-23', '15');
INSERT INTO `workday` VALUES ('108', '2017-06-24', '15');
INSERT INTO `workday` VALUES ('109', '2017-06-26', '15');
INSERT INTO `workday` VALUES ('110', '2017-06-27', '15');
INSERT INTO `workday` VALUES ('111', '2017-06-28', '15');
INSERT INTO `workday` VALUES ('112', '2017-06-29', '15');
INSERT INTO `workday` VALUES ('113', '2017-06-30', '15');
INSERT INTO `workday` VALUES ('114', '2017-07-01', '15');
INSERT INTO `workday` VALUES ('115', '2017-07-03', '15');
INSERT INTO `workday` VALUES ('116', '2017-07-04', '15');
INSERT INTO `workday` VALUES ('117', '2017-07-05', '15');
INSERT INTO `workday` VALUES ('118', '2017-07-06', '15');
INSERT INTO `workday` VALUES ('119', '2017-07-07', '15');
INSERT INTO `workday` VALUES ('120', '2017-07-08', '15');
INSERT INTO `workday` VALUES ('121', '2017-07-10', '15');
INSERT INTO `workday` VALUES ('122', '2017-07-11', '15');
INSERT INTO `workday` VALUES ('123', '2017-07-12', '15');
INSERT INTO `workday` VALUES ('124', '2017-07-13', '15');
INSERT INTO `workday` VALUES ('125', '2017-07-14', '15');
INSERT INTO `workday` VALUES ('126', '2017-07-15', '15');
INSERT INTO `workday` VALUES ('127', '2017-07-17', '15');
INSERT INTO `workday` VALUES ('128', '2017-07-18', '15');
INSERT INTO `workday` VALUES ('129', '2017-07-19', '15');
INSERT INTO `workday` VALUES ('130', '2017-07-20', '15');
INSERT INTO `workday` VALUES ('131', '2017-07-21', '15');
INSERT INTO `workday` VALUES ('132', '2017-07-22', '15');
INSERT INTO `workday` VALUES ('133', '2017-07-24', '15');
INSERT INTO `workday` VALUES ('134', '2017-07-25', '15');
INSERT INTO `workday` VALUES ('135', '2017-07-26', '15');
INSERT INTO `workday` VALUES ('136', '2017-07-27', '15');
INSERT INTO `workday` VALUES ('137', '2017-07-28', '15');
INSERT INTO `workday` VALUES ('138', '2017-07-29', '15');
INSERT INTO `workday` VALUES ('139', '2017-07-31', '15');
INSERT INTO `workday` VALUES ('140', '2017-08-01', '15');
INSERT INTO `workday` VALUES ('141', '2017-08-02', '15');
INSERT INTO `workday` VALUES ('142', '2017-08-03', '15');
INSERT INTO `workday` VALUES ('143', '2017-08-04', '15');
INSERT INTO `workday` VALUES ('144', '2017-08-05', '15');
INSERT INTO `workday` VALUES ('145', '2017-08-07', '15');
INSERT INTO `workday` VALUES ('146', '2017-08-08', '15');
INSERT INTO `workday` VALUES ('147', '2017-08-09', '15');
INSERT INTO `workday` VALUES ('148', '2017-08-10', '15');
INSERT INTO `workday` VALUES ('149', '2017-08-11', '15');
INSERT INTO `workday` VALUES ('150', '2017-08-12', '15');
INSERT INTO `workday` VALUES ('151', '2017-08-14', '15');
INSERT INTO `workday` VALUES ('152', '2017-08-15', '15');
INSERT INTO `workday` VALUES ('153', '2017-08-16', '15');
INSERT INTO `workday` VALUES ('154', '2017-08-17', '15');
INSERT INTO `workday` VALUES ('155', '2017-08-18', '15');
INSERT INTO `workday` VALUES ('156', '2017-08-19', '15');
INSERT INTO `workday` VALUES ('157', '2017-08-21', '15');
INSERT INTO `workday` VALUES ('158', '2017-08-22', '15');
INSERT INTO `workday` VALUES ('159', '2017-08-23', '15');
INSERT INTO `workday` VALUES ('160', '2017-08-24', '15');
INSERT INTO `workday` VALUES ('161', '2017-08-25', '15');
INSERT INTO `workday` VALUES ('162', '2017-08-26', '15');
INSERT INTO `workday` VALUES ('163', '2017-08-28', '15');
INSERT INTO `workday` VALUES ('164', '2017-08-29', '15');
INSERT INTO `workday` VALUES ('165', '2017-08-30', '15');
INSERT INTO `workday` VALUES ('166', '2017-08-31', '15');
INSERT INTO `workday` VALUES ('167', '2017-09-01', '15');
INSERT INTO `workday` VALUES ('168', '2017-09-02', '15');
INSERT INTO `workday` VALUES ('169', '2017-09-04', '15');
INSERT INTO `workday` VALUES ('170', '2017-09-05', '15');
INSERT INTO `workday` VALUES ('171', '2017-09-06', '15');
INSERT INTO `workday` VALUES ('172', '2017-09-07', '15');
INSERT INTO `workday` VALUES ('173', '2017-09-08', '15');
INSERT INTO `workday` VALUES ('174', '2017-09-09', '15');
INSERT INTO `workday` VALUES ('175', '2017-09-11', '15');
INSERT INTO `workday` VALUES ('176', '2017-09-12', '15');
INSERT INTO `workday` VALUES ('177', '2017-09-13', '15');
INSERT INTO `workday` VALUES ('178', '2017-09-14', '15');
INSERT INTO `workday` VALUES ('179', '2017-09-15', '15');
INSERT INTO `workday` VALUES ('180', '2017-09-16', '15');
INSERT INTO `workday` VALUES ('181', '2017-09-18', '15');
INSERT INTO `workday` VALUES ('182', '2017-09-19', '15');
INSERT INTO `workday` VALUES ('183', '2017-09-20', '15');
INSERT INTO `workday` VALUES ('184', '2017-09-21', '15');
INSERT INTO `workday` VALUES ('185', '2017-09-22', '15');
INSERT INTO `workday` VALUES ('186', '2017-09-23', '15');
INSERT INTO `workday` VALUES ('187', '2017-09-25', '15');
INSERT INTO `workday` VALUES ('188', '2017-09-26', '15');
INSERT INTO `workday` VALUES ('189', '2017-09-27', '15');
INSERT INTO `workday` VALUES ('190', '2017-09-28', '15');
INSERT INTO `workday` VALUES ('191', '2017-09-29', '15');
INSERT INTO `workday` VALUES ('192', '2017-09-30', '15');
INSERT INTO `workday` VALUES ('193', '2017-10-02', '15');
INSERT INTO `workday` VALUES ('194', '2017-10-03', '15');
INSERT INTO `workday` VALUES ('195', '2017-10-04', '15');
INSERT INTO `workday` VALUES ('196', '2017-10-05', '15');
INSERT INTO `workday` VALUES ('197', '2017-10-06', '15');
INSERT INTO `workday` VALUES ('198', '2017-10-07', '15');
INSERT INTO `workday` VALUES ('199', '2017-10-09', '15');
INSERT INTO `workday` VALUES ('200', '2017-10-10', '15');
INSERT INTO `workday` VALUES ('201', '2017-10-11', '15');
INSERT INTO `workday` VALUES ('202', '2017-10-12', '15');
INSERT INTO `workday` VALUES ('203', '2017-10-13', '15');
INSERT INTO `workday` VALUES ('204', '2017-10-14', '15');
INSERT INTO `workday` VALUES ('205', '2017-10-16', '15');
INSERT INTO `workday` VALUES ('206', '2017-10-17', '15');
INSERT INTO `workday` VALUES ('207', '2017-10-18', '15');
INSERT INTO `workday` VALUES ('208', '2017-10-19', '15');
INSERT INTO `workday` VALUES ('209', '2017-10-20', '15');
INSERT INTO `workday` VALUES ('210', '2017-10-21', '15');
INSERT INTO `workday` VALUES ('211', '2017-10-23', '15');
INSERT INTO `workday` VALUES ('212', '2017-10-24', '15');
INSERT INTO `workday` VALUES ('213', '2017-10-25', '15');
INSERT INTO `workday` VALUES ('214', '2017-10-26', '15');
INSERT INTO `workday` VALUES ('215', '2017-10-27', '15');
INSERT INTO `workday` VALUES ('216', '2017-10-28', '15');
INSERT INTO `workday` VALUES ('217', '2017-10-30', '15');
INSERT INTO `workday` VALUES ('218', '2017-10-31', '15');
INSERT INTO `workday` VALUES ('219', '2017-11-01', '15');
INSERT INTO `workday` VALUES ('220', '2017-11-02', '15');
INSERT INTO `workday` VALUES ('221', '2017-11-03', '15');
INSERT INTO `workday` VALUES ('222', '2017-11-04', '15');
INSERT INTO `workday` VALUES ('223', '2017-11-06', '15');
INSERT INTO `workday` VALUES ('224', '2017-11-07', '15');
INSERT INTO `workday` VALUES ('225', '2017-11-08', '15');
INSERT INTO `workday` VALUES ('226', '2017-11-09', '15');
INSERT INTO `workday` VALUES ('227', '2017-11-10', '15');
INSERT INTO `workday` VALUES ('228', '2017-11-11', '15');
INSERT INTO `workday` VALUES ('229', '2017-11-13', '15');
INSERT INTO `workday` VALUES ('230', '2017-11-14', '15');
INSERT INTO `workday` VALUES ('231', '2017-11-15', '15');
INSERT INTO `workday` VALUES ('232', '2017-11-16', '15');
INSERT INTO `workday` VALUES ('233', '2017-11-17', '15');
INSERT INTO `workday` VALUES ('234', '2017-11-18', '15');
INSERT INTO `workday` VALUES ('235', '2017-11-20', '15');
INSERT INTO `workday` VALUES ('236', '2017-11-21', '15');
INSERT INTO `workday` VALUES ('237', '2017-11-22', '15');
INSERT INTO `workday` VALUES ('238', '2017-11-23', '15');
INSERT INTO `workday` VALUES ('239', '2017-11-24', '15');
INSERT INTO `workday` VALUES ('240', '2017-11-25', '15');
INSERT INTO `workday` VALUES ('241', '2017-11-27', '15');
INSERT INTO `workday` VALUES ('242', '2017-11-28', '15');
INSERT INTO `workday` VALUES ('243', '2017-11-29', '15');
INSERT INTO `workday` VALUES ('244', '2017-11-30', '15');
INSERT INTO `workday` VALUES ('245', '2017-12-01', '15');
INSERT INTO `workday` VALUES ('246', '2017-12-02', '15');
INSERT INTO `workday` VALUES ('247', '2017-12-04', '15');
INSERT INTO `workday` VALUES ('248', '2017-12-05', '15');
INSERT INTO `workday` VALUES ('249', '2017-12-06', '15');
INSERT INTO `workday` VALUES ('250', '2017-12-07', '15');
INSERT INTO `workday` VALUES ('251', '2017-12-08', '15');
INSERT INTO `workday` VALUES ('252', '2017-12-09', '15');
INSERT INTO `workday` VALUES ('253', '2017-12-11', '15');
INSERT INTO `workday` VALUES ('254', '2017-12-12', '15');
INSERT INTO `workday` VALUES ('255', '2017-12-13', '15');
INSERT INTO `workday` VALUES ('256', '2017-12-14', '15');
INSERT INTO `workday` VALUES ('257', '2017-12-15', '15');
INSERT INTO `workday` VALUES ('258', '2017-12-16', '15');
INSERT INTO `workday` VALUES ('259', '2017-12-18', '15');
INSERT INTO `workday` VALUES ('260', '2017-12-19', '15');
INSERT INTO `workday` VALUES ('261', '2017-12-20', '15');
INSERT INTO `workday` VALUES ('262', '2017-12-21', '15');
INSERT INTO `workday` VALUES ('263', '2017-12-22', '15');
INSERT INTO `workday` VALUES ('264', '2017-12-23', '15');
INSERT INTO `workday` VALUES ('265', '2017-12-25', '15');
INSERT INTO `workday` VALUES ('266', '2017-12-26', '15');
INSERT INTO `workday` VALUES ('267', '2017-12-27', '15');
INSERT INTO `workday` VALUES ('268', '2017-12-28', '15');
INSERT INTO `workday` VALUES ('269', '2017-12-29', '15');
INSERT INTO `workday` VALUES ('270', '2017-12-30', '15');
INSERT INTO `workday` VALUES ('455', '2017-05-31', '69');
INSERT INTO `workday` VALUES ('456', '2017-06-01', '69');
INSERT INTO `workday` VALUES ('457', '2017-06-02', '69');
INSERT INTO `workday` VALUES ('458', '2017-06-05', '69');
INSERT INTO `workday` VALUES ('459', '2017-06-06', '69');
INSERT INTO `workday` VALUES ('460', '2017-06-07', '69');
INSERT INTO `workday` VALUES ('461', '2017-06-08', '69');
INSERT INTO `workday` VALUES ('462', '2017-06-09', '69');
INSERT INTO `workday` VALUES ('463', '2017-06-12', '69');
INSERT INTO `workday` VALUES ('464', '2017-06-13', '69');
INSERT INTO `workday` VALUES ('465', '2017-06-14', '69');
INSERT INTO `workday` VALUES ('466', '2017-06-15', '69');
INSERT INTO `workday` VALUES ('467', '2017-06-16', '69');
INSERT INTO `workday` VALUES ('468', '2017-06-19', '69');
INSERT INTO `workday` VALUES ('469', '2017-06-20', '69');
INSERT INTO `workday` VALUES ('470', '2017-06-21', '69');
INSERT INTO `workday` VALUES ('471', '2017-06-22', '69');
INSERT INTO `workday` VALUES ('472', '2017-06-23', '69');
INSERT INTO `workday` VALUES ('473', '2017-06-26', '69');
INSERT INTO `workday` VALUES ('474', '2017-06-27', '69');
INSERT INTO `workday` VALUES ('475', '2017-06-28', '69');
INSERT INTO `workday` VALUES ('476', '2017-06-29', '69');
INSERT INTO `workday` VALUES ('477', '2017-06-30', '69');
INSERT INTO `workday` VALUES ('478', '2017-07-03', '69');
INSERT INTO `workday` VALUES ('479', '2017-07-04', '69');
INSERT INTO `workday` VALUES ('480', '2017-07-05', '69');
INSERT INTO `workday` VALUES ('481', '2017-07-06', '69');
INSERT INTO `workday` VALUES ('482', '2017-07-07', '69');
INSERT INTO `workday` VALUES ('483', '2017-07-10', '69');
INSERT INTO `workday` VALUES ('484', '2017-07-11', '69');
INSERT INTO `workday` VALUES ('485', '2017-07-12', '69');
INSERT INTO `workday` VALUES ('486', '2017-07-13', '69');
INSERT INTO `workday` VALUES ('487', '2017-07-14', '69');
INSERT INTO `workday` VALUES ('488', '2017-07-17', '69');
INSERT INTO `workday` VALUES ('489', '2017-07-18', '69');
INSERT INTO `workday` VALUES ('490', '2017-07-19', '69');
INSERT INTO `workday` VALUES ('491', '2017-07-20', '69');
INSERT INTO `workday` VALUES ('492', '2017-07-21', '69');
INSERT INTO `workday` VALUES ('493', '2017-07-24', '69');
INSERT INTO `workday` VALUES ('494', '2017-07-25', '69');
INSERT INTO `workday` VALUES ('495', '2017-07-26', '69');
INSERT INTO `workday` VALUES ('496', '2017-07-27', '69');
INSERT INTO `workday` VALUES ('497', '2017-07-28', '69');
INSERT INTO `workday` VALUES ('498', '2017-07-31', '69');
INSERT INTO `workday` VALUES ('499', '2017-08-01', '69');
INSERT INTO `workday` VALUES ('500', '2017-08-02', '69');
INSERT INTO `workday` VALUES ('501', '2017-08-03', '69');
INSERT INTO `workday` VALUES ('502', '2017-08-04', '69');
INSERT INTO `workday` VALUES ('503', '2017-08-07', '69');
INSERT INTO `workday` VALUES ('504', '2017-08-08', '69');
INSERT INTO `workday` VALUES ('505', '2017-08-09', '69');
INSERT INTO `workday` VALUES ('506', '2017-08-10', '69');
INSERT INTO `workday` VALUES ('507', '2017-08-11', '69');
INSERT INTO `workday` VALUES ('508', '2017-08-14', '69');
INSERT INTO `workday` VALUES ('509', '2017-08-15', '69');
INSERT INTO `workday` VALUES ('510', '2017-08-16', '69');
INSERT INTO `workday` VALUES ('511', '2017-08-17', '69');
INSERT INTO `workday` VALUES ('512', '2017-08-18', '69');
INSERT INTO `workday` VALUES ('513', '2017-08-21', '69');
INSERT INTO `workday` VALUES ('514', '2017-08-22', '69');
INSERT INTO `workday` VALUES ('515', '2017-08-23', '69');
INSERT INTO `workday` VALUES ('516', '2017-08-24', '69');
INSERT INTO `workday` VALUES ('517', '2017-08-25', '69');
INSERT INTO `workday` VALUES ('518', '2017-08-28', '69');
INSERT INTO `workday` VALUES ('519', '2017-08-29', '69');
INSERT INTO `workday` VALUES ('520', '2017-08-30', '69');
INSERT INTO `workday` VALUES ('521', '2017-08-31', '69');
INSERT INTO `workday` VALUES ('522', '2017-09-01', '69');
INSERT INTO `workday` VALUES ('523', '2017-09-04', '69');
INSERT INTO `workday` VALUES ('524', '2017-09-05', '69');
INSERT INTO `workday` VALUES ('525', '2017-09-06', '69');
INSERT INTO `workday` VALUES ('526', '2017-09-07', '69');
INSERT INTO `workday` VALUES ('527', '2017-09-08', '69');
INSERT INTO `workday` VALUES ('528', '2017-09-11', '69');
INSERT INTO `workday` VALUES ('529', '2017-09-12', '69');
INSERT INTO `workday` VALUES ('530', '2017-09-13', '69');
INSERT INTO `workday` VALUES ('531', '2017-09-14', '69');
INSERT INTO `workday` VALUES ('532', '2017-09-15', '69');
INSERT INTO `workday` VALUES ('533', '2017-09-18', '69');
INSERT INTO `workday` VALUES ('534', '2017-09-19', '69');
INSERT INTO `workday` VALUES ('535', '2017-09-20', '69');
INSERT INTO `workday` VALUES ('536', '2017-09-21', '69');
INSERT INTO `workday` VALUES ('537', '2017-09-22', '69');
INSERT INTO `workday` VALUES ('538', '2017-09-25', '69');
INSERT INTO `workday` VALUES ('539', '2017-09-26', '69');
INSERT INTO `workday` VALUES ('540', '2017-09-27', '69');
INSERT INTO `workday` VALUES ('541', '2017-09-28', '69');
INSERT INTO `workday` VALUES ('542', '2017-09-29', '69');
INSERT INTO `workday` VALUES ('543', '2017-10-02', '69');
INSERT INTO `workday` VALUES ('544', '2017-10-03', '69');
INSERT INTO `workday` VALUES ('545', '2017-10-04', '69');
INSERT INTO `workday` VALUES ('546', '2017-10-05', '69');
INSERT INTO `workday` VALUES ('547', '2017-10-06', '69');
INSERT INTO `workday` VALUES ('548', '2017-10-09', '69');
INSERT INTO `workday` VALUES ('549', '2017-10-10', '69');
INSERT INTO `workday` VALUES ('550', '2017-10-11', '69');
INSERT INTO `workday` VALUES ('551', '2017-10-12', '69');
INSERT INTO `workday` VALUES ('552', '2017-10-13', '69');
INSERT INTO `workday` VALUES ('553', '2017-10-16', '69');
INSERT INTO `workday` VALUES ('554', '2017-10-17', '69');
INSERT INTO `workday` VALUES ('555', '2017-10-18', '69');
INSERT INTO `workday` VALUES ('556', '2017-10-19', '69');
INSERT INTO `workday` VALUES ('557', '2017-10-20', '69');
INSERT INTO `workday` VALUES ('558', '2017-10-23', '69');
INSERT INTO `workday` VALUES ('559', '2017-10-24', '69');
INSERT INTO `workday` VALUES ('560', '2017-10-25', '69');
INSERT INTO `workday` VALUES ('561', '2017-10-26', '69');
INSERT INTO `workday` VALUES ('562', '2017-10-27', '69');
INSERT INTO `workday` VALUES ('563', '2017-10-30', '69');
INSERT INTO `workday` VALUES ('564', '2017-10-31', '69');
INSERT INTO `workday` VALUES ('565', '2017-11-01', '69');
INSERT INTO `workday` VALUES ('566', '2017-11-02', '69');
INSERT INTO `workday` VALUES ('567', '2017-11-03', '69');
INSERT INTO `workday` VALUES ('568', '2017-11-06', '69');
INSERT INTO `workday` VALUES ('569', '2017-11-07', '69');
INSERT INTO `workday` VALUES ('570', '2017-11-08', '69');
INSERT INTO `workday` VALUES ('571', '2017-11-09', '69');
INSERT INTO `workday` VALUES ('572', '2017-11-10', '69');
INSERT INTO `workday` VALUES ('573', '2017-11-13', '69');
INSERT INTO `workday` VALUES ('574', '2017-11-14', '69');
INSERT INTO `workday` VALUES ('575', '2017-11-15', '69');
INSERT INTO `workday` VALUES ('576', '2017-11-16', '69');
INSERT INTO `workday` VALUES ('577', '2017-11-17', '69');
INSERT INTO `workday` VALUES ('578', '2017-11-20', '69');
INSERT INTO `workday` VALUES ('579', '2017-11-21', '69');
INSERT INTO `workday` VALUES ('580', '2017-11-22', '69');
INSERT INTO `workday` VALUES ('581', '2017-11-23', '69');
INSERT INTO `workday` VALUES ('582', '2017-11-24', '69');
INSERT INTO `workday` VALUES ('583', '2017-11-27', '69');
INSERT INTO `workday` VALUES ('584', '2017-11-28', '69');
INSERT INTO `workday` VALUES ('585', '2017-11-29', '69');
INSERT INTO `workday` VALUES ('586', '2017-11-30', '69');
INSERT INTO `workday` VALUES ('587', '2017-12-01', '69');
INSERT INTO `workday` VALUES ('588', '2017-12-04', '69');
INSERT INTO `workday` VALUES ('589', '2017-12-05', '69');
INSERT INTO `workday` VALUES ('590', '2017-12-06', '69');
INSERT INTO `workday` VALUES ('591', '2017-12-07', '69');
INSERT INTO `workday` VALUES ('592', '2017-12-08', '69');
INSERT INTO `workday` VALUES ('593', '2017-12-11', '69');
INSERT INTO `workday` VALUES ('594', '2017-12-12', '69');
INSERT INTO `workday` VALUES ('595', '2017-12-13', '69');
INSERT INTO `workday` VALUES ('596', '2017-12-14', '69');
INSERT INTO `workday` VALUES ('597', '2017-12-15', '69');
INSERT INTO `workday` VALUES ('598', '2017-12-18', '69');
INSERT INTO `workday` VALUES ('599', '2017-12-19', '69');
INSERT INTO `workday` VALUES ('600', '2017-12-20', '69');
INSERT INTO `workday` VALUES ('601', '2017-12-21', '69');
INSERT INTO `workday` VALUES ('602', '2017-12-22', '69');
INSERT INTO `workday` VALUES ('603', '2017-12-25', '69');
INSERT INTO `workday` VALUES ('604', '2017-12-26', '69');
INSERT INTO `workday` VALUES ('605', '2017-12-27', '69');
INSERT INTO `workday` VALUES ('606', '2017-12-28', '69');
INSERT INTO `workday` VALUES ('607', '2017-12-29', '69');

-- ----------------------------
-- Procedure structure for changeUserGroup
-- ----------------------------
DROP PROCEDURE IF EXISTS `changeUserGroup`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `changeUserGroup`(IN `pid` bigint,IN `targetId` bigint)
BEGIN
	call showChild(pid);
	UPDATE tusergrouprelation SET tg_id =targetId WHERE tg_id in (SELECT id FROM text);
	
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for deleteChildGroup
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteChildGroup`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `deleteChildGroup`(IN `pid` bigint,IN `targetId` bigint)
BEGIN
	call changeUserGroup(pid,targetId);
	DELETE FROM tgroup WHERE tg_id in (SELECT id FROM text);
	DELETE FROM tgroup WHERE tg_id=pid;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for findAllBoss
-- ----------------------------
DROP PROCEDURE IF EXISTS `findAllBoss`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `findAllBoss`(IN pid BIGINT)
BEGIN
DECLARE done INT DEFAULT FALSE;
DECLARE id BIGINT;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=TRUE;

SET max_sp_recursion_depth=100;







END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for findChild
-- ----------------------------
DROP PROCEDURE IF EXISTS `findChild`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `findChild`(IN pid BIGINT)
BEGIN
DECLARE done INT DEFAULT FALSE;
DECLARE id BIGINT;
DECLARE cur1 CURSOR FOR SELECT tg_id  FROM tgroup WHERE parent_tg_id=pid;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=TRUE;
SET max_sp_recursion_depth=100;
OPEN cur1;
read_loop:LOOP
FETCH cur1 INTO id;
IF done THEN
LEAVE read_loop;
END IF;
INSERT INTO text VALUE(id,pid);
CALL findChild(id);
END LOOP;
CLOSE cur1;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for showChild
-- ----------------------------
DROP PROCEDURE IF EXISTS `showChild`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `showChild`(IN `pid` bigint)
BEGIN
	TRUNCATE TABLE text;  
	CALL findChild(pid);
	SELECT * FROM text;
END
;;
DELIMITER ;
