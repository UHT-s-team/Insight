/*
SQLyog Ultimate v13.1.1 (32 bit)
MySQL - 5.5.40 : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis`;

/*Table structure for table `gamedayinfo` */

DROP TABLE IF EXISTS `gamedayinfo`;

CREATE TABLE `gamedayinfo` (
  `ITime` date NOT NULL COMMENT '发布时间',
  `num` int(10) DEFAULT NULL COMMENT '发布条数',
  `average` float DEFAULT NULL COMMENT '评价评分',
  `OneStarNum` int(10) DEFAULT NULL COMMENT '一星各数',
  `TowStarNum` int(10) DEFAULT NULL COMMENT '二星各数',
  `ThreeStarNum` int(10) DEFAULT NULL COMMENT '三星各数',
  `FourStarNum` int(10) DEFAULT NULL COMMENT '四星各数',
  `FiveStarNum` int(10) DEFAULT NULL COMMENT '五星各数',
  PRIMARY KEY (`ITime`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `gamedayinfo` */

insert  into `gamedayinfo`(`ITime`,`num`,`average`,`OneStarNum`,`TowStarNum`,`ThreeStarNum`,`FourStarNum`,`FiveStarNum`) values 
('2019-11-13',23,2.2,123,123,123,213,123);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
