/*
Navicat MySQL Data Transfer

Source Server         : tt
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-08-24 08:05:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `bprice` int(11) NOT NULL,
  `publisher` varchar(255) COLLATE utf8_hungarian_ci DEFAULT NULL,
  `auther` varchar(255) COLLATE utf8_hungarian_ci DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '红楼梦', '59', '新华出版社', '曹雪芹');
INSERT INTO `book` VALUES ('2', '西游记', '34', '新华出版社', '吴晨恩');
INSERT INTO `book` VALUES ('3', '水浒传', '56', '新华出版社', '施耐庵');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `price` double NOT NULL,
  `num` int(11) NOT NULL,
  `pic` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '方便面', '23', '12', 'gdfdf.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `age` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '123', '23');
INSERT INTO `user` VALUES ('2', '李四', '23', '34');
INSERT INTO `user` VALUES ('6', 'f', '1', '23');
INSERT INTO `user` VALUES ('7', 'y', '1', '45');
INSERT INTO `user` VALUES ('8', 'g', '1', '12');
INSERT INTO `user` VALUES ('9', 'm', '1', '34');
INSERT INTO `user` VALUES ('10', 'l', '1', '45');
INSERT INTO `user` VALUES ('11', 'n', '1', '17');

-- ----------------------------
-- Table structure for visitcount
-- ----------------------------
DROP TABLE IF EXISTS `visitcount`;
CREATE TABLE `visitcount` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- ----------------------------
-- Records of visitcount
-- ----------------------------
INSERT INTO `visitcount` VALUES ('1', '0');
