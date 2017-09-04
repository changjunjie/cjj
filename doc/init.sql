-- ----------------------------
--  Table structure for `USER`
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `USER`
-- ----------------------------
BEGIN;
INSERT INTO `USER` VALUES ('1', '7player', '18', '123456');
COMMIT;

-- ----------------------------
--  Table structure for `FAIL_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `FAIL_INFO`;
CREATE TABLE `FAIL_INFO` (
  `CREATED` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'created time',
  `MODIFIED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'modified time',
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `CLASS_NAME` varchar(255) NOT NULL COMMENT 'class name',
  `METHOD` varchar(255) NOT NULL COMMENT 'method',
  `PARAMS` text NOT NULL COMMENT 'method params json',
  `exception` text NOT NULL COMMENT 'exception',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COMMENT='fail method info';
