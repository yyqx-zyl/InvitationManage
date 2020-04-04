/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.22-log : Database - invitationdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`invitationdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `invitationdb`;

/*Table structure for table `invitation` */

DROP TABLE IF EXISTS `invitation`;

CREATE TABLE `invitation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '帖子标题',
  `summary` varchar(50) DEFAULT NULL COMMENT '帖子摘要',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `invitation` */

insert  into `invitation`(`id`,`title`,`summary`,`author`,`createdate`) values (1,'最新的BWM谍照','新款宝马跑车','小和','2020-03-31 16:03:45'),(2,'恒大的三杆洋枪','外援给力','神算子','2020-03-12 16:04:39'),(3,'歼31试飞','国产歼31登辽宁舰','军神','2020-03-03 16:06:00'),(4,'4G支持移动么？','5G时代即将来临','小风','2020-03-11 16:06:37');

/*Table structure for table `reply_detail` */

DROP TABLE IF EXISTS `reply_detail`;

CREATE TABLE `reply_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `invid` int(11) NOT NULL COMMENT '帖子编号',
  `content` varchar(255) NOT NULL COMMENT '回复内容',
  `author` varchar(50) DEFAULT '匿名用户' COMMENT '回复人昵称',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `reply_detail` */

insert  into `reply_detail`(`id`,`invid`,`content`,`author`,`createdate`) values (1,1,'什么时候上市、售价多少？','总算摇上号了','2020-03-11 16:07:39'),(2,1,'16W发动机，百米加速2.6秒','我是MINI','2020-03-19 16:08:32'),(3,4,'升级系统后才可以使用','匿名用户','2020-03-12 16:11:39'),(4,4,'5G巴巴变','匿名用户','2020-03-12 16:12:10'),(5,1,'<p>水电费发个梵蒂冈</p>','add的多多','2020-04-03 16:34:00'),(10,3,'<p>ghfghfsghsgh分段函数发过火</p>','规划法规','2020-04-04 14:08:52');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
