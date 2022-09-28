-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 124.221.159.221    Database: my_shinho
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_category_id` int DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `course_number` varchar(50) DEFAULT NULL,
  `course_type_id` int DEFAULT NULL COMMENT '0单节课  1套餐课',
  `course_price` decimal(10,2) DEFAULT NULL,
  `course_points` int DEFAULT NULL,
  `slide_position` int DEFAULT NULL COMMENT '1.首页轮播',
  `description` varchar(50) DEFAULT NULL,
  `course_url` varchar(50) DEFAULT NULL,
  `picture_url` varchar(200) DEFAULT NULL,
  `course_content` text,
  `course_level` varchar(50) DEFAULT NULL,
  `is_public` int DEFAULT NULL COMMENT '0 否 1是',
  `creator` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `carousel_img` varchar(255) DEFAULT NULL COMMENT '轮播图',
  PRIMARY KEY (`id`),
  KEY `course_category_id` (`course_category_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`course_category_id`) REFERENCES `course_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程的表,包括课程的详情';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,2,'熊猫竹竹','119',0,500.00,300,1,'好利来','1565263710326.mp4','/images/courses/20220919222846269964727641197818573440542982267084305.jpg','欠人情若','',1,'李林江','2019-04-07 21:19:07','李林江','2022-09-19 22:57:06','1-1PG10T321Y2.jpg'),(2,5,'琼海清补凉','102',0,368.00,368,2,'我吃巧克力','5e73ff9701a765c3746983bca21e0c52.mp4','images/courses/chocolateCake.jpg','现在吧吧主  ','2',1,'柳俊凯','2019-04-07 21:23:30','柳俊凯','2019-04-07 21:23:43','1-1PG10T95U15.jpg'),(3,1,'白雪黑珍珠','103',1,756.00,756,3,'我吃甜品','1565263710326.mp4','images/courses/lemonade.jpg','山东高速大概','3',1,'刘相永','2019-04-07 21:49:05','李林江','2019-05-29 14:35:14','sekfha.jpg'),(4,2,'活色生香','104',0,255.00,255,0,'活色生香','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/lemonade.jpg','拉萨金凤凰大立科技发货的垃圾可好了','2',1,'李林江','2019-05-29 14:37:58','李林江','2019-05-29 14:31:12','fahsfklh.jpg'),(5,2,'港式糕点','105',0,188.00,188,0,'港式糕点','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/lemonade.jpg','顶顶顶','2',1,'李林江','2019-05-29 14:38:02','李林江','2019-05-29 14:31:46','slkdfgjl.jpg'),(6,1,'水果小吃','106',1,888.00,888,0,'水果小吃','1565263710326.mp4','images/courses/fruitSnacks.jpg','顶顶顶','2',1,'李林江','2019-05-29 14:38:05','李林江','2019-05-29 14:32:11','sdjfhask.jpg'),(7,1,'美味芝麻糊','107',1,777.00,777,0,'美味芝麻糊','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/SesamePaste.jpg','美味芝麻糊','2',1,'李林江','2019-05-29 14:38:08','李林江','2019-05-29 14:32:35','sdjfhask.jpg'),(8,1,'营养炖品','108',1,666.00,666,0,'营养炖品','1565263710326.mp4','images/courses/NutritiousStew.jpg','营养炖品','2',1,'李林江','2019-05-29 14:38:11','李林江','2019-05-29 14:32:59','sdjfhask.jpg'),(9,1,'正宗凉粉','109',1,580.00,580,0,'正宗凉粉','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/jelly.jpg','正宗凉粉','3',1,'李林江','2019-05-29 14:38:14','李林江','2019-05-29 14:33:19','sdjfhask.jpg'),(10,5,'招牌米露','110',0,480.00,480,0,'招牌迷路','1565263710326.mp4','images/courses/lemonade.jpg','招牌迷路','2',1,'李林江','2019-05-29 14:38:16','李林江','2019-05-29 14:33:41','sdjfhask.jpg'),(11,5,'招牌布丁','111',0,300.00,400,0,'招牌布丁','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/pudding.jpg','招牌布丁','2',1,'李林江','2019-05-29 14:38:19','李林江','2019-05-29 14:34:07','sdjfhask.jpg'),(13,2,'帽子蛋糕','112',0,400.00,400,4,'帽子1','1565263710326.mp4','images/courses/hatCake.jpg','高级课程','2',1,'李林江','2019-05-29 14:55:19',NULL,NULL,'1559112901738.jpg'),(14,4,'梅花曲奇饼干','113',0,388.00,388,0,'暖暖的很贴心','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/cookies.jpg','梅花曲奇','3',1,'李林江','2019-05-29 21:19:13',NULL,NULL,'1559135942067.jpg'),(15,3,'奶油蛋糕','114',0,100.00,1000,0,'这','1565263710326.mp4','images/courses/creamCake.jpg','噶啥都干','1',1,'刘相永','2019-06-22 09:53:43','刘相永','2019-06-28 11:17:10','1561172642895.jpg'),(16,3,'你号面包','115',0,100.00,100,0,'111','3de1d74d7a48bdd8891ee32c2ad6e84a.mp4','images/courses/lemonade.jpg','111','2',1,'刘相永','2019-06-27 15:34:29','刘相永','2019-06-28 11:20:02','1561692001427.jpg'),(17,3,'情侣面包','116',0,299.00,200,0,'好吃','1565263710326.mp4','images/courses/bread.jpg','情侣面包','1',1,'刘相永','2019-06-28 11:14:25',NULL,NULL,'1561691653098.jpg'),(20,2,'熔岩蛋糕','118',0,150.00,100,NULL,NULL,NULL,'/images/courses/20220919160526312033337571130349813183492115616107489.jpg',NULL,'',1,'李林江','2022-09-19 16:05:34','李林江','2022-09-19 22:16:32',NULL),(21,3,'肉松面包','120',0,100.00,80,NULL,NULL,NULL,'/images/courses/20220919221232264388044989357636770715892759435300463.jpg',NULL,'2',1,'李林江','2022-09-19 22:12:45',NULL,NULL,NULL),(22,3,'夹心面包','121',0,100.00,80,NULL,NULL,NULL,'/images/courses/20220919221723197718390008752428690623543233918105917.jpg',NULL,'2',1,'李林江','2022-09-19 22:17:30',NULL,NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_category`
--

DROP TABLE IF EXISTS `course_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) DEFAULT NULL,
  `icon_url` varchar(100) DEFAULT NULL,
  `is_published` int DEFAULT NULL COMMENT '0 否 1是',
  `created_Id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `created_Id` (`created_Id`),
  CONSTRAINT `course_category_ibfk_1` FOREIGN KEY (`created_Id`) REFERENCES `employee_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_category`
--

LOCK TABLES `course_category` WRITE;
/*!40000 ALTER TABLE `course_category` DISABLE KEYS */;
INSERT INTO `course_category` VALUES (1,'套餐',NULL,1,1,'2019-04-07 00:00:00'),(2,'蛋糕',NULL,1,2,'2019-04-07 00:00:00'),(3,'面包',NULL,1,3,'2019-04-07 00:00:00'),(4,'饼干',NULL,1,1,'2019-04-07 00:00:00'),(5,'饮品',NULL,1,3,'2019-04-20 00:00:00'),(6,'半熟芝士',NULL,1,3,'2019-06-25 00:00:00');
/*!40000 ALTER TABLE `course_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_package`
--

DROP TABLE IF EXISTS `course_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_package` (
  `id` int NOT NULL AUTO_INCREMENT,
  `package_id` int DEFAULT NULL,
  `package_name` varchar(50) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_package_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='套餐包,一个套餐包中可以添加多个课程';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_package`
--

LOCK TABLES `course_package` WRITE;
/*!40000 ALTER TABLE `course_package` DISABLE KEYS */;
INSERT INTO `course_package` VALUES (1,3,'1111',1),(2,3,'1111',2),(3,3,'1111',4),(4,6,'2222',2);
/*!40000 ALTER TABLE `course_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_reservation`
--

DROP TABLE IF EXISTS `course_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `arrangement_date` date DEFAULT NULL,
  `order_begin_time` time DEFAULT NULL,
  `order_end_time` time DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `display` int DEFAULT '0' COMMENT '0显示            1不显示',
  `start_time` date DEFAULT NULL,
  `state` int DEFAULT '0' COMMENT '0  未开始  1已完成',
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `store_id` (`store_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `course_reservation_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `course_reservation_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `course_reservation_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `order_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程预约';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_reservation`
--

LOCK TABLES `course_reservation` WRITE;
/*!40000 ALTER TABLE `course_reservation` DISABLE KEYS */;
INSERT INTO `course_reservation` VALUES (1,1,1,'2019-04-08 00:00:00',NULL,NULL,'2019-04-08','09:00:00','11:00:00',1,'2019-04-08 15:43:35',0,NULL,1),(2,2,2,'2019-05-21 13:20:10','2019-05-21 13:20:13','2019-05-21 13:20:16','2019-05-21','09:00:00','11:00:00',2,'2019-05-21 13:20:50',1,NULL,1),(17,5,1,'2019-07-25 00:00:00','2019-07-25 09:00:00','2019-07-25 11:00:00','2019-07-25','09:00:00','11:00:00',55,'2019-05-30 11:11:19',0,'2019-05-30',1),(19,13,1,'2019-05-28 00:00:00','2019-05-28 09:00:00','2019-05-28 11:00:00','2019-05-28','19:30:00','11:00:00',57,'2019-05-29 21:38:50',0,'2019-05-29',1),(20,11,1,'2019-05-15 00:00:00','2019-05-15 19:30:00','2019-05-15 21:30:00','2019-05-15','19:30:00','21:30:00',58,'2019-05-29 18:49:56',0,NULL,1),(21,14,1,'2019-05-30 00:00:00','2019-05-30 09:00:00','2019-05-30 11:00:00','2019-05-30','09:00:00','11:00:00',59,'2019-05-29 22:01:18',0,'2019-05-29',1),(22,10,4,'2019-05-30 00:00:00','2019-05-30 16:00:00','2019-05-30 18:00:00','2019-05-30','19:30:00','18:00:00',60,'2019-05-29 22:13:21',0,'2019-05-29',1),(23,13,1,'2019-06-01 00:00:00','2019-06-01 13:30:00','2019-06-01 15:30:00','2019-06-01','13:30:00','15:30:00',63,'2019-05-30 10:37:01',0,'2019-05-30',1),(24,7,1,'2019-06-01 00:00:00','2019-06-01 16:00:00','2019-06-01 18:00:00',NULL,NULL,NULL,64,NULL,1,NULL,0),(25,13,1,'2019-05-29 00:00:00','2019-05-29 13:30:00','2019-05-29 15:30:00','2019-05-29','13:30:00','15:30:00',65,'2019-05-30 13:31:16',0,'2019-05-30',1),(26,4,1,'2019-05-30 00:00:00','2019-05-30 13:30:00','2019-05-30 15:30:00','2019-05-30','13:30:00','15:30:00',66,'2019-05-30 15:07:28',0,'2019-05-30',1),(27,5,1,'2019-06-11 00:00:00','2019-06-11 16:00:00','2019-06-11 18:00:00','2019-06-11','16:00:00','18:00:00',96,'2019-06-11 17:10:13',0,NULL,1),(29,5,2,'2019-06-29 00:00:00','2019-06-29 09:00:00','2019-06-29 11:00:00',NULL,NULL,NULL,124,NULL,0,NULL,0),(30,2,1,'2019-06-25 00:00:00','2019-06-25 13:30:00','2019-06-25 15:30:00','2022-09-12','13:30:00','15:30:00',125,'2022-09-26 10:11:30',1,'2022-09-12',0),(31,14,1,'2019-06-21 00:00:00','2019-06-21 09:00:00','2019-06-21 11:00:00','2019-06-21','09:00:00','11:00:00',127,'2019-06-21 20:32:05',0,'2019-06-21',1),(32,1,1,'2019-06-26 00:00:00','2019-06-26 16:00:00','2019-06-26 18:00:00','2022-09-25','09:00:00','11:00:00',132,'2022-09-26 10:10:46',1,'2022-09-25',0),(33,2,1,'2019-06-12 00:00:00','2019-06-12 13:30:00','2019-06-12 15:30:00',NULL,NULL,NULL,136,NULL,1,NULL,0),(34,2,1,'2019-06-25 00:00:00','2019-06-25 13:30:00','2019-06-25 15:30:00','2019-06-25','13:30:00','15:30:00',62,'2019-06-22 08:37:00',0,'2019-06-22',1),(35,1,1,'2019-06-22 00:00:00','2019-06-22 16:00:00','2019-06-22 18:00:00','2019-06-22','16:00:00','18:00:00',137,'2019-06-22 09:48:04',0,'2019-06-22',1),(36,1,1,'2019-06-25 00:00:00','2019-06-25 13:30:00','2019-06-25 15:30:00','2019-06-25','13:30:00','15:30:00',138,'2019-06-24 16:08:40',0,'2019-06-24',1),(37,15,1,'2019-06-26 00:00:00','2019-06-26 13:30:00','2019-06-26 15:30:00','2019-06-26','13:30:00','15:30:00',139,'2019-06-25 15:03:09',0,NULL,1),(38,5,1,'2019-05-22 00:00:00','2019-05-22 13:30:00','2019-05-22 15:30:00','2019-05-22','13:30:00','15:30:00',140,'2019-06-25 16:16:41',0,NULL,1),(39,4,1,'2019-06-27 00:00:00','2019-06-27 13:30:00','2019-06-27 15:30:00','2019-06-27','13:30:00','15:30:00',141,'2019-06-27 15:31:23',0,'2019-06-27',1),(40,5,1,'2019-06-01 00:00:00','2019-06-01 13:30:00','2019-06-01 15:30:00','2019-06-06','13:30:00','15:30:00',143,'2019-07-01 16:45:02',0,'2019-07-01',1),(41,4,1,'2019-05-29 00:00:00','2019-05-29 13:30:00','2019-05-29 15:30:00','2019-05-29','16:00:00','15:30:00',144,'2019-07-02 15:00:29',0,'2019-07-02',1),(42,4,1,'2019-05-22 00:00:00','2019-05-22 13:30:00','2019-05-22 15:30:00','2019-05-22','13:30:00','15:30:00',148,'2019-07-04 22:00:34',0,'2019-07-04',1),(43,13,1,'2019-07-05 00:00:00','2019-07-05 13:30:00','2019-07-05 15:30:00','2019-07-05','13:30:00','15:30:00',150,'2019-07-05 08:18:32',0,NULL,1),(44,13,1,'2019-05-29 00:00:00','2019-05-29 13:30:00','2019-05-29 15:30:00','2019-05-29','16:00:00','15:30:00',152,'2019-07-05 11:43:35',0,'2019-07-05',1),(45,13,1,'2019-12-12 00:00:00','2019-12-12 19:30:00','2019-12-12 21:30:00','2019-12-12','19:30:00','21:30:00',154,'2019-12-12 09:23:59',0,'2019-12-12',1),(46,13,1,'2019-12-12 00:00:00','2019-12-12 19:30:00','2019-12-12 21:30:00',NULL,NULL,NULL,154,NULL,0,NULL,0),(47,4,1,'2019-12-12 00:00:00','2019-12-12 13:30:00','2019-12-12 15:30:00','2019-12-12','13:30:00','15:30:00',147,'2019-12-12 09:31:57',0,NULL,1),(48,1,1,'2019-12-12 00:00:00','2019-12-12 13:30:00','2019-12-12 15:30:00','2019-12-12','16:00:00','15:30:00',146,'2019-12-12 09:34:18',0,'2019-12-12',1),(49,13,1,'2019-12-12 00:00:00','2019-12-12 19:30:00','2019-12-12 21:30:00',NULL,NULL,NULL,158,NULL,0,NULL,0),(50,13,1,'2019-12-12 00:00:00','2019-12-12 19:30:00','2019-12-12 21:30:00','2019-12-12','19:30:00','21:30:00',157,'2019-12-12 15:26:19',0,'2019-12-12',1),(51,6,7,'2022-09-20 00:00:00','2022-09-20 13:30:00','2022-09-20 15:30:00',NULL,NULL,NULL,159,NULL,NULL,NULL,0),(52,14,7,NULL,NULL,NULL,NULL,NULL,NULL,166,NULL,NULL,NULL,0),(53,8,8,'2022-09-29 00:00:00','2022-09-29 09:00:00','2022-09-29 11:30:00',NULL,NULL,NULL,167,NULL,NULL,NULL,0),(54,9,1,'2022-09-29 00:00:00','2022-09-23 09:00:00','2022-09-23 11:30:00','2022-09-24','09:00:00','11:00:00',169,'2022-09-23 16:51:13',NULL,'2022-09-24',0),(55,15,1,'2022-09-29 00:00:00',NULL,NULL,'2022-09-30',NULL,'11:00:00',170,'2022-09-23 17:14:31',NULL,'2022-09-30',0),(56,10,1,'2022-09-29 00:00:00','2022-09-29 09:00:00','2022-09-29 11:30:00','2022-09-24','09:00:00','11:00:00',171,'2022-09-23 17:27:15',NULL,'2022-09-24',0),(57,17,1,'2022-09-29 00:00:00','2022-09-29 09:00:00','2022-09-29 11:30:00','2022-09-24','09:00:00','11:00:00',172,'2022-09-23 17:36:48',NULL,'2022-09-24',0),(58,6,1,'2022-09-29 00:00:00',NULL,NULL,NULL,NULL,NULL,173,NULL,NULL,NULL,0),(59,8,1,'2022-09-30 00:00:00','2022-09-30 19:30:00','2022-09-30 21:30:00',NULL,NULL,NULL,174,NULL,NULL,NULL,0),(60,7,1,'2022-09-05 00:00:00','2022-09-05 09:00:00','2022-09-05 11:00:00',NULL,NULL,NULL,176,NULL,NULL,NULL,0),(61,7,1,'2022-09-01 00:00:00','2022-09-01 09:00:00','2022-09-01 11:00:00','2022-09-29','09:00:00','11:00:00',181,'2022-09-28 08:45:06',NULL,'2022-09-29',0),(62,8,1,'2022-09-28 00:00:00','2022-09-28 13:30:00','2022-09-28 15:30:00',NULL,NULL,NULL,168,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `course_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_table`
--

DROP TABLE IF EXISTS `course_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `store_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `reservation_date` date DEFAULT NULL,
  `begin_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  KEY `course_id` (`course_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `course_table_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `course_table_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `course_table_ibfk_3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `course_table_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程排课表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_table`
--

LOCK TABLES `course_table` WRITE;
/*!40000 ALTER TABLE `course_table` DISABLE KEYS */;
INSERT INTO `course_table` VALUES (1,1,1,1,5,'2019-04-07 23:30:43','2019-04-08','09:00:00','11:00:00'),(2,1,1,1,5,'2019-04-08 11:52:50','2019-04-08','00:00:13',NULL),(3,1,2,2,5,'2019-04-26 18:05:31','2019-04-26',NULL,NULL),(4,2,4,2,5,'2019-04-26 18:06:09','2019-04-26',NULL,NULL),(5,2,7,1,5,'2019-04-27 18:06:36','2019-04-27',NULL,NULL),(6,3,6,2,5,'2019-04-27 18:06:59','2019-04-27',NULL,NULL),(7,4,3,1,5,NULL,NULL,NULL,NULL),(8,1,3,1,5,'2019-05-29 11:58:06','2019-06-08','09:00:00','11:00:00'),(9,1,1,1,5,'2019-05-29 12:12:56','2019-06-01','16:00:00','18:00:00'),(10,1,2,1,5,'2019-05-29 12:25:00','2019-05-31','19:30:00','21:30:00'),(11,1,5,1,5,'2019-05-29 16:56:23','2019-07-25','09:00:00','11:00:00'),(12,1,11,6,5,'2019-05-29 18:49:56','2019-05-15','19:30:00','21:30:00'),(13,1,13,1,5,'2019-05-29 21:38:50','2019-05-28','19:30:00','11:00:00'),(14,1,14,8,5,'2019-05-29 22:01:18','2019-05-30','09:00:00','11:00:00'),(15,4,10,9,13,'2019-05-29 22:13:21','2019-05-30','19:30:00','18:00:00'),(16,1,13,1,5,'2019-05-30 10:37:01','2019-06-01','13:30:00','15:30:00'),(17,1,5,1,5,'2019-05-30 11:11:19','2019-07-25','09:00:00','11:00:00'),(18,1,13,1,5,'2019-05-30 13:31:16','2019-05-29','13:30:00','15:30:00'),(19,1,4,5,5,'2019-05-30 15:07:28','2019-05-30','13:30:00','15:30:00'),(20,1,5,1,5,'2019-06-11 17:08:24','2019-06-11','16:00:00','18:00:00'),(21,1,14,8,5,'2019-06-21 20:32:05','2019-06-21','09:00:00','11:00:00'),(22,1,2,6,5,'2019-06-22 08:37:00','2019-06-25','13:30:00','15:30:00'),(23,1,1,6,5,'2019-06-22 09:48:04','2019-06-22','16:00:00','18:00:00'),(24,1,1,6,5,'2019-06-24 16:08:40','2019-06-25','13:30:00','15:30:00'),(25,1,15,2,5,'2019-06-25 15:03:09','2019-06-26','13:30:00','15:30:00'),(26,1,5,5,5,'2019-06-25 16:16:41','2019-05-22','13:30:00','15:30:00'),(27,1,4,1,5,'2019-06-27 15:31:23','2019-06-27','13:30:00','15:30:00'),(28,1,5,1,5,'2019-07-01 16:45:02','2019-06-06','13:30:00','15:30:00'),(29,1,4,1,5,'2019-07-02 15:00:29','2019-05-29','16:00:00','15:30:00'),(30,1,4,1,5,'2019-07-04 22:00:34','2019-05-22','13:30:00','15:30:00'),(31,1,13,5,5,'2019-07-05 08:18:32','2019-07-05','13:30:00','15:30:00'),(32,1,13,1,5,'2019-07-05 11:43:35','2019-05-29','16:00:00','15:30:00'),(33,1,13,1,5,'2019-12-12 09:23:59','2019-12-12','19:30:00','21:30:00'),(34,1,4,5,5,'2019-12-12 09:31:57','2019-12-12','13:30:00','15:30:00'),(35,1,1,6,5,'2019-12-12 09:34:18','2019-12-12','16:00:00','15:30:00'),(41,1,10,11,27,'2022-09-23 17:27:12','2022-09-24','09:00:00','11:00:00'),(42,1,17,10,27,'2022-09-23 17:36:46','2022-09-24','09:00:00','11:00:00'),(43,1,1,6,1,'2022-09-26 10:10:43','2022-09-25','09:00:00','11:00:00'),(44,1,2,5,1,'2022-09-26 10:11:30','2022-09-12','13:30:00','15:30:00'),(45,1,7,11,28,'2022-09-28 08:45:04','2022-09-29','09:00:00','11:00:00');
/*!40000 ALTER TABLE `course_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_time_config`
--

DROP TABLE IF EXISTS `course_time_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_time_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course1_start_time` varchar(50) DEFAULT NULL,
  `course1_end_time` varchar(50) DEFAULT NULL,
  `course2_start_time` varchar(50) DEFAULT NULL,
  `course2_end_time` varchar(50) DEFAULT NULL,
  `course3_start_time` varchar(50) DEFAULT NULL,
  `course3_end_time` varchar(50) DEFAULT NULL,
  `course4_start_time` varchar(50) DEFAULT NULL,
  `course4_end_time` varchar(50) DEFAULT NULL,
  `class_attendance` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='上课时间配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_time_config`
--

LOCK TABLES `course_time_config` WRITE;
/*!40000 ALTER TABLE `course_time_config` DISABLE KEYS */;
INSERT INTO `course_time_config` VALUES (1,'09:00','11:00','13:30','15:30','16:00','18:00','19:30','21:30',10);
/*!40000 ALTER TABLE `course_time_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_user`
--

DROP TABLE IF EXISTS `employee_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `creator` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`),
  KEY `store_id` (`store_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `employee_user_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `employee_user_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这张表是员工表，该表中存储了所有的员工，包括管理员，反正后台的用户都在这里';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_user`
--

LOCK TABLES `employee_user` WRITE;
/*!40000 ALTER TABLE `employee_user` DISABLE KEYS */;
INSERT INTO `employee_user` VALUES (1,'101','李林江',1,'d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e','2019-12-12 09:37:50',1,'系统','2019-04-07 22:58:18','',NULL,NULL),(2,'102','柳俊凯',1,'d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e','2019-06-14 13:42:44',1,'系统','2019-04-07 23:00:26','',NULL,NULL),(3,'103','刘相永',1,'root','2019-07-05 11:44:59',1,'系统','2019-04-07 23:01:00','',NULL,NULL),(4,'104','王哥',2,'root1','2019-04-07 23:01:53',1,'李林江','2019-04-07 23:02:09','李林江','2019-04-07 23:04:36',1),(5,'105','范平',3,'root2','2019-12-12 15:26:09',1,'王哥','2019-04-07 23:04:27','王哥','2019-04-07 23:04:39',8),(6,'106','钢铁侠',2,'root1','2019-05-29 11:40:56',1,'李林江','2019-05-29 11:40:09',NULL,NULL,2),(7,'107','蜘蛛侠',2,'root1','2019-05-29 16:38:13',1,'李林江','2019-05-29 16:38:19',NULL,NULL,NULL),(8,'108','灭霸',2,'root1','2019-05-29 16:39:47',1,'李林江','2019-05-29 16:39:54',NULL,NULL,4),(9,'109','胖虎',2,'root1','2019-05-29 16:43:51',1,'李林江','2019-05-29 16:43:57',NULL,NULL,5),(10,'110','静香',2,'root1','2019-05-29 16:44:17',1,'李林江','2019-05-29 16:44:23',NULL,NULL,8),(11,'111','小布',3,'root2','2019-05-29 16:46:38',1,'李林江','2019-05-29 16:46:45',NULL,NULL,2),(12,'112','大熊',3,'root2','2019-05-29 16:47:07',1,'李林江','2019-05-29 16:47:13',NULL,NULL,3),(13,'113','沙力万',3,'d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e','2022-09-28 08:42:01',1,'李林江','2019-05-29 16:47:41',NULL,NULL,1),(14,'114','米迪尔',3,'root2','2019-05-29 16:47:56',1,'李林江','2019-05-29 16:48:02',NULL,NULL,5),(15,'115','哆啦A梦',2,'root3','2019-07-03 16:39:10',1,'李林江','2019-05-29 20:35:37','刘相永','2019-07-03 16:38:50',7),(16,'116','乔老师',1,'root','2019-12-12 16:58:16',1,'李林江','2019-12-12 09:39:40',NULL,NULL,NULL),(17,'117','员工1',3,'root','2019-12-12 16:58:16',1,'李林江','2022-09-17 17:25:00',NULL,NULL,7),(18,'118','员工2',3,'root','2019-12-12 16:58:16',1,'李林江','2022-09-17 17:25:00',NULL,NULL,4),(24,'119','贺凯',NULL,NULL,NULL,1,NULL,NULL,'李林江','2022-09-22 09:22:46',NULL),(25,'120','贺凯',2,NULL,NULL,0,NULL,NULL,'李林江','2022-09-22 09:25:03',NULL);
/*!40000 ALTER TABLE `employee_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `course_type_id` int DEFAULT NULL COMMENT '0单节课 1套餐课',
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,1,0,388.00),(2,2,1,0,388.00),(55,55,5,0,188.00),(57,57,13,0,400.00),(58,58,11,0,300.00),(59,59,14,0,388.00),(60,60,10,0,480.00),(62,62,2,0,368.00),(63,63,13,0,400.00),(64,64,7,1,777.00),(65,65,13,0,400.00),(66,66,4,0,255.00),(96,96,5,0,188.00),(124,124,5,0,188.00),(125,125,2,0,368.00),(127,127,14,0,388.00),(130,130,14,0,388.00),(132,132,1,0,1000.00),(133,133,1,0,1000.00),(136,136,2,0,368.00),(137,137,1,0,1000.00),(138,138,1,0,1000.00),(139,139,15,0,100.00),(140,140,5,0,188.00),(141,141,4,0,255.00),(142,142,4,0,255.00),(143,143,5,0,188.00),(144,144,4,0,255.00),(145,145,1,0,1000.00),(146,146,1,0,1000.00),(147,147,4,0,255.00),(148,148,4,0,255.00),(150,150,13,0,400.00),(151,151,1,0,1000.00),(152,152,13,0,400.00),(154,154,13,0,400.00),(155,155,4,0,255.00),(156,156,5,0,188.00),(157,157,13,0,400.00),(158,158,13,0,400.00),(159,159,6,0,888.00),(166,166,14,0,388.00),(167,167,8,0,666.00),(168,168,8,0,666.00),(169,169,9,0,580.00),(170,170,15,0,100.00),(171,171,10,0,480.00),(172,172,17,0,299.00),(173,173,6,0,888.00),(174,174,8,0,666.00),(176,176,7,0,777.00),(177,177,8,0,666.00),(178,178,10,0,480.00),(179,179,6,0,888.00),(180,180,9,0,580.00),(181,181,7,0,777.00);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_goods`
--

DROP TABLE IF EXISTS `order_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_detail_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `write_off_code_number` varchar(50) DEFAULT NULL COMMENT '核销码',
  `reserve_id` int DEFAULT NULL,
  `course_table_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `reserve_id` (`reserve_id`),
  KEY `course_table_id` (`course_table_id`),
  KEY `order_goods_order_detail_id_fk` (`order_detail_id`),
  CONSTRAINT `order_goods_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `order_goods_ibfk_2` FOREIGN KEY (`reserve_id`) REFERENCES `course_reservation` (`id`),
  CONSTRAINT `order_goods_ibfk_3` FOREIGN KEY (`course_table_id`) REFERENCES `course_table` (`id`),
  CONSTRAINT `order_goods_order_detail_id_fk` FOREIGN KEY (`order_detail_id`) REFERENCES `order_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='下单后收到的货物，也就是核销码，用户用这个核销码去后续的操作，预约之类的';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_goods`
--

LOCK TABLES `order_goods` WRITE;
/*!40000 ALTER TABLE `order_goods` DISABLE KEYS */;
INSERT INTO `order_goods` VALUES (1,1,1,'1234567',1,1),(2,62,2,'1234568',2,2),(3,55,5,'254476',17,NULL),(4,57,13,'445575',19,NULL),(5,58,11,'506022',20,NULL),(6,59,14,'335762',21,NULL),(7,60,10,'986820',22,NULL),(8,62,2,'757143',34,22),(9,63,13,'800018',23,NULL),(10,64,7,'619759',24,NULL),(11,65,13,'841928',25,NULL),(12,66,4,'957444',26,NULL),(13,96,5,'828959',27,20),(14,124,5,'443574',29,NULL),(15,125,2,'529110',30,44),(16,127,14,'144965',31,21),(17,2,1,'324256',32,43),(18,132,1,'845580',NULL,NULL),(19,136,2,'695552',33,NULL),(20,137,1,'175933',35,23),(21,138,1,'463097',36,24),(22,139,15,'578696',37,25),(23,140,5,'566943',38,26),(24,141,4,'311032',39,27),(25,142,4,'642429',NULL,NULL),(26,143,5,'391419',40,28),(27,144,4,'759430',41,29),(28,145,1,'900024',NULL,NULL),(29,146,1,'305327',48,35),(30,147,4,'492865',47,34),(31,148,4,'494400',42,30),(32,150,13,'663918',43,31),(33,152,13,'902895',44,32),(34,154,13,'939584',45,33),(35,155,4,'830441',NULL,NULL),(36,156,5,'385734',NULL,NULL),(37,157,13,'846234',50,33),(38,158,13,'826188',49,NULL),(39,159,6,'827591',51,NULL),(40,166,14,'344573',52,NULL),(41,167,8,'468886',53,NULL),(42,168,8,'455280',62,NULL),(43,169,9,'723631',54,NULL),(44,170,15,'262394',55,NULL),(45,171,10,'785642',56,41),(46,172,17,'373445',57,42),(47,173,6,'802028',58,NULL),(48,174,8,'556227',59,NULL),(49,176,7,'132541',60,NULL),(50,177,8,'911279',NULL,NULL),(51,178,10,'464732',NULL,NULL),(52,179,6,'965999',NULL,NULL),(53,180,9,'172444',NULL,NULL),(54,181,7,'893960',61,45);
/*!40000 ALTER TABLE `order_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_number` varchar(50) CHARACTER SET ucs2 COLLATE ucs2_general_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '0未付款 1已付款  2售后中  3已退款  99交易关闭',
  `payment_way` varchar(10) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `user_level` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,'1000001','2019-04-08 15:00:53','2019-04-08 15:00:53',2,'微信',388.00,1,NULL),(2,'1000002','2019-04-08 15:02:31','2019-04-08 15:02:31',1,'微信',756.00,2,NULL),(55,'1000051','2019-05-29 16:50:41','2019-05-29 16:50:41',2,NULL,188.00,1,NULL),(57,'1000053','2019-05-29 17:09:08','2019-05-29 17:09:08',2,NULL,400.00,1,NULL),(58,'1000054','2019-05-29 18:45:51','2019-05-29 18:45:51',2,NULL,300.00,1,NULL),(59,'1000055','2019-05-29 21:55:18','2019-05-29 21:55:18',2,NULL,388.00,1,NULL),(60,'1000056','2019-05-29 22:11:48','2019-05-29 22:11:48',2,NULL,480.00,1,NULL),(62,'1000058','2019-05-30 10:21:07','2019-05-30 10:21:07',2,NULL,368.00,1,NULL),(63,'1000059','2019-05-30 10:35:23','2019-05-30 10:35:23',2,NULL,400.00,4,NULL),(64,'1000060','2019-05-30 10:52:22','2019-05-30 10:52:22',2,NULL,777.00,1,NULL),(65,'1000061','2019-05-30 13:30:18','2019-05-30 13:30:18',2,NULL,400.00,1,NULL),(66,'1000062','2019-05-30 15:05:16','2019-05-30 15:05:16',2,NULL,255.00,1,NULL),(96,'1000096','2019-06-11 16:47:10','2019-06-11 16:47:10',2,NULL,188.00,5,NULL),(124,'1000124','2019-06-21 15:07:48','2019-06-21 15:07:48',2,NULL,188.00,1,NULL),(125,'1000125','2019-06-21 15:09:11','2019-06-21 15:09:11',2,NULL,368.00,1,NULL),(127,'1000127','2019-06-21 20:27:28','2019-06-21 20:27:28',2,NULL,388.00,1,NULL),(130,'1000130','2019-06-21 23:44:11','2019-06-21 23:44:11',0,NULL,388.00,1,NULL),(132,'1000132','2019-06-21 23:45:58','2019-06-21 23:45:58',2,NULL,1000.00,1,NULL),(133,'1000133','2019-06-22 08:31:49','2019-06-22 08:31:49',1,NULL,1000.00,1,NULL),(136,'1000136','2019-06-22 08:35:17','2019-06-22 08:35:17',2,NULL,368.00,1,NULL),(137,'1000137','2019-06-22 09:45:51','2019-06-22 09:45:51',2,NULL,1000.00,1,NULL),(138,'1000138','2019-06-24 16:06:19','2019-06-24 16:06:19',2,NULL,1000.00,1,NULL),(139,'1000139','2019-06-25 14:59:43','2019-06-25 14:59:43',2,NULL,100.00,1,NULL),(140,'1000140','2019-06-25 16:14:25','2019-06-25 16:14:25',2,NULL,188.00,13,NULL),(141,'1000141','2019-06-27 15:29:02','2019-06-27 15:29:02',2,NULL,255.00,1,NULL),(142,'1000142','2019-07-01 15:43:01','2019-07-01 15:43:01',1,NULL,255.00,1,NULL),(143,'1000143','2019-07-01 16:41:44','2019-07-01 16:41:44',2,'',188.00,14,NULL),(144,'1000144','2019-07-02 14:58:20','2019-07-02 14:58:20',2,'',255.00,15,NULL),(145,'1000145','2019-07-04 17:21:33','2019-07-04 17:21:33',1,NULL,1000.00,1,NULL),(146,'1000146','2019-07-04 17:23:56','2019-07-04 17:23:56',2,NULL,1000.00,1,NULL),(147,'1000147','2019-07-04 20:40:58','2019-07-04 20:40:58',2,NULL,255.00,1,NULL),(148,'1000148','2019-07-04 21:58:16','2019-07-04 21:58:16',2,NULL,255.00,17,NULL),(150,'1000150','2019-07-05 08:16:26','2019-07-05 08:16:26',2,NULL,400.00,1,NULL),(151,'1000151','2019-07-05 10:53:56','2019-07-05 10:53:56',0,NULL,1000.00,1,NULL),(152,'1000152','2019-07-05 11:41:32','2019-07-05 11:41:32',2,NULL,400.00,18,NULL),(154,'1000154','2019-12-12 09:21:05','2019-12-12 09:21:05',2,NULL,400.00,1,NULL),(155,'1000155','2019-12-12 11:05:08','2019-12-12 11:05:08',1,NULL,255.00,1,NULL),(156,'1000156','2019-12-12 11:27:57','2019-12-12 11:27:57',1,NULL,188.00,1,NULL),(157,'1000157','2019-12-12 14:27:07','2019-12-12 14:27:07',2,NULL,400.00,1,NULL),(158,'1000158','2019-12-12 15:22:13','2019-12-12 15:22:13',2,NULL,400.00,1,NULL),(159,'20220920094618337952404668037930275928934114711252','2022-09-20 09:45:19','2022-09-20 17:52:04',1,NULL,888.00,27,NULL),(166,'20220921082146313085640967196999970820137759224532','2022-09-21 08:21:47','2022-09-21 08:25:32',1,NULL,388.00,27,NULL),(167,'20220921094337235629542293374746277646574930907909','2022-09-21 09:43:37','2022-09-21 09:44:34',1,NULL,666.00,27,NULL),(168,'20220922111825208900365173519817219585540453677180','2022-09-22 11:18:26','2022-09-22 11:19:18',1,NULL,666.00,28,NULL),(169,'20220923090106165072079909870835701492475461872252','2022-09-23 09:01:06','2022-09-23 09:03:13',1,NULL,580.00,27,NULL),(170,'20220923171246322568527728487097874314699581543609','2022-09-23 17:12:46','2022-09-23 17:13:38',1,NULL,100.00,27,NULL),(171,'20220923172337249504630231095542751205687879056372','2022-09-23 17:23:37','2022-09-23 17:24:20',1,NULL,480.00,27,NULL),(172,'20220923173506308991023450884139660816095275559596','2022-09-23 17:35:07','2022-09-23 17:35:30',1,NULL,299.00,27,NULL),(173,'20220923180138259706541283529707926752853775642632','2022-09-23 18:01:38','2022-09-23 18:02:59',1,NULL,888.00,27,NULL),(174,'20220923181009131326149652137028843007818767904776','2022-09-23 18:10:10','2022-09-23 18:10:34',1,NULL,666.00,27,NULL),(176,'20220926105202498197468587906819938012164229532721','2022-09-26 10:52:03','2022-09-26 11:13:32',1,NULL,777.00,27,NULL),(177,'20220926111434229101997404193202414522863089079540','2022-09-26 11:14:35','2022-09-26 11:15:12',1,NULL,666.00,27,NULL),(178,'20220927110035203222589198777745248578407142762834','2022-09-27 11:00:36','2022-09-27 11:02:22',1,NULL,480.00,27,NULL),(179,'20220927110842340990520889040719293273445335360385','2022-09-27 11:08:42','2022-09-27 11:09:19',1,NULL,888.00,27,NULL),(180,'20220927110937161337561266005770561330000102610603','2022-09-27 11:09:37','2022-09-27 11:10:16',1,NULL,580.00,27,NULL),(181,'20220928083802716185696053478594125483819601119309','2022-09-28 08:38:03','2022-09-28 08:38:52',1,NULL,777.00,28,NULL);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_list`
--

DROP TABLE IF EXISTS `permission_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permission_code` int NOT NULL COMMENT '权限码',
  `permission_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工和管理员在后台所能看到的菜单，该菜单会根据角色权限的不同而改变';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_list`
--

LOCK TABLES `permission_list` WRITE;
/*!40000 ALTER TABLE `permission_list` DISABLE KEYS */;
INSERT INTO `permission_list` VALUES (1,101,'统计分析'),(2,102,'深度分析'),(3,103,'课程管理'),(4,104,'讲师管理'),(5,105,'学员管理'),(6,106,'门店管理'),(7,107,'订单管理'),(8,108,'售后管理'),(9,109,'权限管理'),(10,110,'系统配置');
/*!40000 ALTER TABLE `permission_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation_role_permission`
--

DROP TABLE IF EXISTS `relation_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relation_role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `relation_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `relation_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission_list` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与权限相对应的表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation_role_permission`
--

LOCK TABLES `relation_role_permission` WRITE;
/*!40000 ALTER TABLE `relation_role_permission` DISABLE KEYS */;
INSERT INTO `relation_role_permission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,2,1),(12,2,2),(13,2,3),(14,2,4),(15,2,5),(16,2,6),(17,4,1),(18,4,2),(19,4,7),(21,3,1);
/*!40000 ALTER TABLE `relation_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation_store_course`
--

DROP TABLE IF EXISTS `relation_store_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relation_store_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  KEY `relation_store_course_ibfk_1` (`course_id`),
  CONSTRAINT `relation_store_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `relation_store_course_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这是课程和店铺的对应关系，就是哪门课在哪个店铺中';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation_store_course`
--

LOCK TABLES `relation_store_course` WRITE;
/*!40000 ALTER TABLE `relation_store_course` DISABLE KEYS */;
INSERT INTO `relation_store_course` VALUES (2,1,2),(4,3,1),(5,4,2),(6,5,2),(7,6,1),(8,7,3),(9,8,3),(10,9,3),(11,10,4),(12,11,3),(13,5,1),(16,13,1),(17,11,1),(18,14,1),(19,4,1),(20,2,1),(21,7,1),(22,8,1),(23,10,1),(24,9,1),(25,14,3),(26,1,1),(27,3,4),(28,15,1),(29,1,5),(30,3,5),(32,16,1);
/*!40000 ALTER TABLE `relation_store_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `creator` varchar(50) NOT NULL,
  `created_time` datetime NOT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `is_system_created_account` int DEFAULT NULL COMMENT '0代表不是由开发出来的软件创建的账户\r\n，而是在数据库这边直接创建的账户，反之1、2分别代表店长、店员，该属性相当于账户分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员','超级管理员','2019-04-07 22:40:10','系统','2019-04-07 22:41:04',0),(2,'店长','超级管理员','2019-04-07 22:51:44','超级管理员','2019-04-07 22:51:49',1),(3,'店员','超级管理员','2019-04-07 22:52:05','超级管理员','2019-04-07 22:52:07',2),(4,'财务总监','超级管理员','2019-05-29 20:34:51',NULL,NULL,1),(7,'总经理','李林江','2022-09-22 10:09:07',NULL,NULL,1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `store_number` varchar(50) DEFAULT NULL,
  `store_name` varchar(100) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL COMMENT 'H 欣和寒舍   S 水吧',
  `store_manager_id` int DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `picture_url` varchar(500) DEFAULT NULL,
  `summary` text,
  PRIMARY KEY (`id`),
  KEY `store_manager_id` (`store_manager_id`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`store_manager_id`) REFERENCES `employee_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商店表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'101','烟台永旺店','H',4,'山东 烟台 开发区 RouRou(开发永旺店)','images/stores/cakeShop1.jpg','烟台永旺店'),(2,'102','栖霞万达店','H',6,'山东 烟台 栖霞市 万达店','images/stores/cakeShop1.jpg','栖霞万达店'),(3,'103','莱山银座','H',7,'山东 烟台 莱山区 银座店','images/stores/cakeShop1.jpg','莱山银座店'),(4,'104','芝罘区万达店','H',8,'山东 烟台 芝罘区 万达广场(烟台芝罘店)','images/stores/cakeShop2.jpg','万达店'),(5,'105','莱山宝龙店','H',9,'山东 烟台 莱山区 迎春大街宝龙广场','images/stores/cakeShop2.jpg','莱山宝龙广场'),(7,'106','烟大店',NULL,15,'山东省烟台市莱山区烟台大学','images/stores/20220917145231145393719180374784909185655102502727769.png','烟大小吃'),(8,'107','莱山万象城店',NULL,10,'山东省烟台市莱山区万象城','/images/stores/20220918000824174406694598219826315593248009795931152.jpg','万象城店店');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestion`
--

DROP TABLE IF EXISTS `suggestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suggestion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(50) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='建议反馈';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestion`
--

LOCK TABLES `suggestion` WRITE;
/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
INSERT INTO `suggestion` VALUES (1,'15354565456','问题1','问题描述1','2022-09-21 17:17:30'),(2,'15858585858','我叫张乾','我叫张乾','2022-09-22 11:16:59');
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `store_id` int DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `picture_url` varchar(500) DEFAULT NULL,
  `employment_date` date DEFAULT NULL,
  `good_category` varchar(50) DEFAULT NULL COMMENT '这个属性是在后台创建的时候从category表中选择的',
  `entry_date` date DEFAULT NULL,
  `leave_date` date DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `feature` varchar(500) DEFAULT NULL,
  `status` int DEFAULT '1',
  `created_date` date DEFAULT NULL,
  `created_user_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='讲师信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,1,'101','鞠老师','山东 烟台 芝罘区 大润发(烟台店)','11011011011','110.qq.com','2019-04-07','男','','2019-04-07','蛋糕','2019-04-07',NULL,'很牛逼','牛逼',1,'2019-04-07','104'),(2,1,'102','李老师','山东 烟台 芝罘区 大润发(烟台店)','11911911911','119.qq.com','2019-04-07','男','images/teachers/defaultPerson.jpg','2019-04-07','面包','2019-04-07',NULL,'很厉害','厉害',1,'2019-04-07','105'),(3,2,'103','范老师','山东 烟台 芝罘区 大润发(烟台店)','17356568965','16576969@qq.com','2019-05-29','男','images/teachers/defaultPerson.jpg','2019-05-29','饮品','2019-05-29',NULL,'烦狗比',NULL,1,NULL,'101'),(4,2,'104','特斯拉','山东 青岛 市南区 青岛市南区第二实验小学','11311311311','113.qq.com','2019-04-17','男','images/teachers/defaultPerson.jpg','2019-04-17','饼干','2019-04-17',NULL,'发明饼干','饼干',1,NULL,'101'),(5,1,'105','孙老师','山东 烟台 芝罘区 大润发','17353527767','1657371717@qq.com','1991-11-28','女','images/teachers/defaultPerson.jpg','2019-05-29','蛋糕','2019-05-29',NULL,'暖暖老师',NULL,1,NULL,'0'),(6,1,'106','兜老师','山东 青岛 市南区 青岛市南区第二实验小学','17353527767','1657371717@qq.com','2019-05-29','男','images/teachers/defaultPerson.jpg','2019-05-29','饮品','2019-05-29','2022-09-23','鲁大第一兜老师',NULL,0,NULL,'0'),(8,1,'107','侯老师','山东 烟台 芝罘区 海韵广场','17353527767','1657371717@qq.com','2019-05-29','女','images/teachers/defaultPerson.jpg','2019-05-29','饼干','2019-05-29',NULL,'侯',NULL,1,NULL,'0'),(9,4,'108','晴老师','山东 烟台 芝罘区 凤凰台','17353527767','1657371717@qq.com','2019-05-29','男','images/teachers/defaultPerson.jpg','2019-05-29','饮品','2019-05-29',NULL,'凤凰',NULL,1,NULL,'0'),(10,1,'110','张乾','山东省烟台市莱山区烟台大学','15130380905','1974396570@qq.com','2001-01-20','男','/images/teachers/2022092110100453188612110027906267331126956233342865.png','2022-09-07','蛋糕','2022-09-20','2022-09-21','计193-1',NULL,1,'2022-09-20','101'),(11,1,'111','贺凯','甘肃省庆阳市宁县甘肃','11111111111',NULL,'2022-09-12','女','/images/teachers/20220920203305245165954006661064441334981552700089819.png','2022-09-14','面包','2022-09-20','2022-09-21','凯凯凯凯大佬大佬',NULL,0,'2022-09-20','101'),(12,2,'112','马老师','山东省烟台市莱山区烟台大学','12345678901',NULL,'2022-09-13','女','/images/teachers/20220920222310243978222027451924839476654049455745671.png','2022-09-19','面包','2022-09-20','2022-09-20','12',NULL,0,'2022-09-20','101'),(13,7,'113','王老师','山东省威海市环翠区市区','98765432111',NULL,'2022-09-28','女','/images/teachers/20220920230618257184744241326621845556653715264897648.png','2022-09-15','套餐','2022-09-20','2022-09-21','456',NULL,0,'2022-09-20','101');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `picture_url` varchar(500) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `register_way` varchar(50) DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT 'true可用  false不可用',
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user表代表使用客户端的用户，包括但不限于只是学生，也有可能就是单纯注册账号浏览的人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'兜兜','123456','兜兜','兜兜','13963853651','烟台市芝罘区鲁东大学','女','1996-11-28','1473668775@qq.com',NULL,'2016-06-16 15:26:48','手机APP',1,'2019-12-13 08:51:37'),(2,'哈士奇','123123','二哈','哈士奇','17854577101','烟台市芝罘区','男','1998-10-22','1477557448@qq.com',NULL,'2018-05-24 15:33:42','手机APP',0,'2018-12-05 15:34:40'),(4,'妞妞','520025','妞妞','妞妞','17353527767',NULL,NULL,NULL,'15254136792@qq.com',NULL,'2019-05-27 16:07:01',NULL,1,'2019-05-30 10:35:09'),(5,'A1','520025','A1','A1','15684138526',NULL,NULL,NULL,NULL,NULL,'2019-05-27 22:05:23',NULL,1,'2019-06-11 16:46:52'),(12,'王威霖','123456','王威霖','王威霖','13780973679',NULL,NULL,NULL,'147@qq.com',NULL,'2019-06-11 14:58:51',NULL,1,'2019-06-11 14:58:58'),(13,'王哥','123456','王哥','王哥','18354515186',NULL,NULL,NULL,'1123@qq.com',NULL,'2019-06-25 16:13:36',NULL,1,'2019-06-25 16:13:59'),(14,'牛哥','123456','牛哥','牛哥','15314473691',NULL,NULL,NULL,'1474@qq.com',NULL,'2019-07-01 16:41:06',NULL,1,'2019-07-01 16:41:30'),(15,'逗逗你','123456','逗逗你','逗逗你','17854579818',NULL,NULL,NULL,'13@qq.com',NULL,'2019-07-02 14:57:41',NULL,1,'2019-07-02 14:58:09'),(16,'li',NULL,'li','li','13205359129',NULL,'男',NULL,'123@qq.com',NULL,'2019-07-04 17:26:04',NULL,1,'2022-09-17 19:31:01'),(17,'li','123456','li','li','15615555391',NULL,NULL,NULL,'12@qq.com',NULL,'2019-07-04 21:57:27',NULL,1,'2019-07-04 22:31:00'),(18,'兜兜','d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e','兜兜','兜兜','15615555397',NULL,NULL,NULL,'1@qq.cpm',NULL,'2019-07-05 11:40:57',NULL,1,'2022-09-15 22:17:12'),(19,'1111','111',NULL,NULL,'1111',NULL,'男',NULL,'1111',NULL,NULL,NULL,NULL,NULL),(20,'11222','2222',NULL,NULL,'22222',NULL,'男',NULL,'2222',NULL,NULL,NULL,NULL,NULL),(21,'2222','3333',NULL,NULL,'222',NULL,'男',NULL,'222',NULL,NULL,NULL,NULL,NULL),(23,'12232','111',NULL,NULL,'13535353535',NULL,'男',NULL,'123456@qq.com',NULL,'2022-09-14 10:42:24',NULL,NULL,NULL),(24,'HKSB','22222',NULL,NULL,'17860397285',NULL,'女',NULL,'1@163.com',NULL,'2022-09-15 15:43:43',NULL,NULL,NULL),(25,'hekai','c888c9ce9e098d5864d3ded6ebcc140a12142263bace3a23a36f9905f12bd64a',NULL,NULL,'18881343398',NULL,'男',NULL,'123@gmail.com',NULL,'2022-09-15 15:47:15',NULL,NULL,NULL),(26,'HK','d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e',NULL,NULL,'15354545454',NULL,'男',NULL,'111!@qq.com',NULL,'2022-09-18 16:19:46',NULL,NULL,NULL),(27,'HK','d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e',NULL,'3333','15354565456','山东省烟台市莱山区','男','1999-07-07','111@qq.com',NULL,'2022-09-18 16:23:03',NULL,NULL,'2022-09-27 11:10:56'),(28,'ZQ ','d7190eb194ff9494625514b6d178c87f99c5973e28c398969d2233f2960a573e',NULL,NULL,'15858585858',NULL,'男','2022-09-01','1974396570@qq.com',NULL,'2022-09-22 11:12:35',NULL,NULL,'2022-09-28 08:39:10');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28  9:40:50
