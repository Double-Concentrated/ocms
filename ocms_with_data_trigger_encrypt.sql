/*
 Navicat Premium Data Transfer

 Source Server         : dbms
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : ocms

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 19/05/2021 00:43:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_account` varchar(30) NOT NULL,
  `admin_passwd` char(50) NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, 'root', '63a9f0ea7bb98050796b649e85481845');
INSERT INTO `admin` VALUES (2, 'admin', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `admin` VALUES (3, 'kali', 'd6ca3fd0c3a3b462ff2b83436dda495e');
INSERT INTO `admin` VALUES (4, 'ubuntu', '1d41c853af58d3a7ae54990ce29417d8');
COMMIT;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `sta_id` int(11) NOT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `con_id` int(11) NOT NULL,
  `apply_time` datetime NOT NULL,
  `con_time` datetime NOT NULL,
  `apply_num` int(11) NOT NULL,
  `apply_name` varchar(20) NOT NULL,
  `apply_is_check` int(11) NOT NULL,
  `apply_result` int(11) DEFAULT NULL,
  `apply_note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`apply_id`) USING BTREE,
  KEY `FK_Apply` (`con_id`) USING BTREE,
  KEY `FK_Apply2` (`sta_id`) USING BTREE,
  KEY `FK_Apply3` (`admin_id`) USING BTREE,
  CONSTRAINT `FK_Apply` FOREIGN KEY (`con_id`) REFERENCES `consume` (`con_id`),
  CONSTRAINT `FK_Apply2` FOREIGN KEY (`sta_id`) REFERENCES `staff` (`sta_id`),
  CONSTRAINT `FK_Apply3` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of apply
-- ----------------------------
BEGIN;
INSERT INTO `apply` VALUES (1, 1, NULL, 3, '2021-04-28 10:10:35', '2021-04-28 10:10:41', 10, '墨盒', 0, NULL, NULL);
INSERT INTO `apply` VALUES (2, 2, NULL, 5, '2021-04-28 10:12:15', '2021-04-28 10:12:21', 10, '复印纸', 0, NULL, NULL);
INSERT INTO `apply` VALUES (3, 1, NULL, 7, '2021-05-19 00:42:06', '2021-05-19 00:42:05', 20, '传真热敏纸', 0, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for consume
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT,
  `con_name` varchar(20) NOT NULL,
  `con_num` int(11) NOT NULL,
  `con_factory` varchar(50) NOT NULL,
  `con_indate` datetime NOT NULL,
  `con_is_replenish` int(11) NOT NULL,
  PRIMARY KEY (`con_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of consume
-- ----------------------------
BEGIN;
INSERT INTO `consume` VALUES (1, '硒鼓', 50, '知名硒鼓生产厂', '2021-04-27 22:40:12', 0);
INSERT INTO `consume` VALUES (2, '粉仓', 50, '知名粉仓生产厂', '2021-04-27 22:40:59', 0);
INSERT INTO `consume` VALUES (3, '墨盒', 50, '知名墨盒生产厂', '2021-04-27 22:41:30', 0);
INSERT INTO `consume` VALUES (4, '碳带', 50, '知名碳带生产厂', '2021-04-27 22:42:21', 0);
INSERT INTO `consume` VALUES (5, '复印纸', 50, '知名复印纸生产厂', '2021-04-27 22:43:00', 0);
INSERT INTO `consume` VALUES (6, '彩喷纸', 50, '知名彩喷纸生产厂', '2021-04-27 22:43:28', 0);
INSERT INTO `consume` VALUES (7, '传真热敏纸', 50, '知名传真热敏纸生产厂', '2021-04-27 22:43:52', 0);
INSERT INTO `consume` VALUES (8, '高光相纸', 50, '知名高光相纸生产厂', '2021-04-27 22:44:28', 0);
INSERT INTO `consume` VALUES (9, '绘图纸', 50, '知名绘图纸生产厂', '2021-04-27 22:44:56', 0);
INSERT INTO `consume` VALUES (10, '硫酸纸', 50, '知名硫酸纸生产厂', '2021-04-27 22:45:21', 0);
COMMIT;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `sta_id` int(11) NOT NULL AUTO_INCREMENT,
  `sta_name` varchar(20) NOT NULL,
  `sta_dept` varchar(20) NOT NULL,
  `sta_tele` char(20) NOT NULL,
  PRIMARY KEY (`sta_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of staff
-- ----------------------------
BEGIN;
INSERT INTO `staff` VALUES (1, '仓库管理员', '仓库', '000000');
INSERT INTO `staff` VALUES (2, '总裁', '行政部', '666666');
INSERT INTO `staff` VALUES (3, '董事长', '行政部', '666666');
INSERT INTO `staff` VALUES (4, 'CEO', '行政部', '666666');
INSERT INTO `staff` VALUES (5, '摸鱼产品一号职工', '产品部', '111');
INSERT INTO `staff` VALUES (6, '划水产品二号职工', '产品部', '111');
INSERT INTO `staff` VALUES (7, '摸鱼设计一号职工', '设计部', '222');
INSERT INTO `staff` VALUES (8, '划水设计二号职工', '设计部', '666');
INSERT INTO `staff` VALUES (9, '摸鱼技术一号职工', '技术部', '222');
INSERT INTO `staff` VALUES (10, '划水技术二号职工', '技术部', '333');
INSERT INTO `staff` VALUES (11, '不摸鱼技术三号', '技术部', '444');
INSERT INTO `staff` VALUES (12, '不划水技术四号职工', '技术部', '444');
INSERT INTO `staff` VALUES (13, '摸鱼市场一号职工', '市场部', '444');
INSERT INTO `staff` VALUES (14, '划水市场二号职工', '市场部', '444');
INSERT INTO `staff` VALUES (15, '绝不摸鱼财务一号职工', '财务部', '555');
INSERT INTO `staff` VALUES (16, '必不划水财务二号职工', '财务部', '555');
INSERT INTO `staff` VALUES (17, '整天摸鱼人力一号职工', '人力部', '777');
INSERT INTO `staff` VALUES (18, '想要放假人力二号职工', '人力部', '777');
INSERT INTO `staff` VALUES (19, '快被解雇人力三号职工', '人力部', '888');
COMMIT;

-- ----------------------------
-- Triggers structure for table consume
-- ----------------------------
DROP TRIGGER IF EXISTS `before_insert_auto_check_replenish`;
delimiter ;;
CREATE TRIGGER `before_insert_auto_check_replenish` BEFORE INSERT ON `consume` FOR EACH ROW BEGIN
	IF
		( new.con_num < 10 ) THEN
			SET new.con_is_replenish = 1;
		
	END IF;
	
	END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table consume
-- ----------------------------
DROP TRIGGER IF EXISTS `after_insert_auto_apply_replenish`;
delimiter ;;
CREATE TRIGGER `after_insert_auto_apply_replenish` AFTER INSERT ON `consume` FOR EACH ROW BEGIN
	IF(new.con_is_replenish = 1) THEN
	INSERT INTO apply
	(sta_id, con_id, apply_time, con_time, apply_num, apply_name, apply_is_check)
	SELECT 1, new.con_id, NOW(), NOW(), 50, new.con_name, 0 
	FROM staff, apply
	WHERE staff.sta_id = apply.sta_id
	LIMIT 1;
	END IF;
	
	END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table consume
-- ----------------------------
DROP TRIGGER IF EXISTS `before_update_auto_check_replenish`;
delimiter ;;
CREATE TRIGGER `before_update_auto_check_replenish` BEFORE UPDATE ON `consume` FOR EACH ROW BEGIN
	IF
		( new.con_num < 10 ) THEN
			SET new.con_is_replenish = 1;
		
	END IF;
	
	END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table consume
-- ----------------------------
DROP TRIGGER IF EXISTS `after_update_auto_apply_replenish`;
delimiter ;;
CREATE TRIGGER `after_update_auto_apply_replenish` AFTER UPDATE ON `consume` FOR EACH ROW BEGIN
	IF(new.con_is_replenish = 1) THEN
	INSERT INTO apply
	(sta_id, con_id, apply_time, con_time, apply_num, apply_name, apply_is_check)
	SELECT 1, new.con_id, NOW(), NOW(), 50, new.con_name, 0 
	FROM staff, apply
	WHERE staff.sta_id = apply.sta_id
	LIMIT 1;
	END IF;
	
	END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
