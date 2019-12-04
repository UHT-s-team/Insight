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

/*Table structure for table `recentplay` */

DROP TABLE IF EXISTS `recentplay`;

CREATE TABLE `recentplay` (
  `G_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '游戏ID',
  `U_ID` int(20) DEFAULT NULL COMMENT '用户ID',
  `G_NAME` varchar(40) DEFAULT NULL COMMENT '游戏名称',
  `G_TIME` varchar(20) DEFAULT NULL COMMENT '游戏时长',
  `T_TAGLIB` varchar(10) DEFAULT NULL COMMENT '类型标签',
  `G_NUMBER` float DEFAULT NULL COMMENT '游戏评分',
  PRIMARY KEY (`G_ID`),
  KEY `U_ID` (`U_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1133 DEFAULT CHARSET=utf8;

/*Data for the table `recentplay` */

insert  into `recentplay`(`G_ID`,`U_ID`,`G_NAME`,`G_TIME`,`T_TAGLIB`,`G_NUMBER`) values 
(1132,23233,'校内','23122时','飙车',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
