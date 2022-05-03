-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Test
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.21.10.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '管理员唯一标识符',
  `admin_account` varchar(20) NOT NULL COMMENT '管理员账号',
  `admin_password` varchar(32) NOT NULL COMMENT '管理员密码',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '描述该条数据是否被弃用',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_admin_account_uindex` (`admin_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这个表描述后台管理员信息，虽然后台界面不打算更改了，但由于重构数据库和后端接口的改变，后台的后端模块还是要改一下';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_saa`
--

DROP TABLE IF EXISTS `map_saa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_saa` (
  `singer_id` int NOT NULL COMMENT '每个歌手的唯一标识符',
  `album` varchar(32) NOT NULL COMMENT '专辑名称',
  `album_picture` varchar(512) DEFAULT NULL COMMENT '专辑图片索引位置',
  `is_upload` int NOT NULL DEFAULT '0' COMMENT '是否为用户上传',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '数据是否被弃用',
  PRIMARY KEY (`singer_id`,`album`),
  CONSTRAINT `map_saa_singer_singer_id_fk` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`singer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='一张专辑应该有一张对应的专辑图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_saa`
--

LOCK TABLES `map_saa` WRITE;
/*!40000 ALTER TABLE `map_saa` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_saa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map_ss`
--

DROP TABLE IF EXISTS `map_ss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `map_ss` (
  `singer_id` int NOT NULL COMMENT '每个歌手的唯一标识符',
  `song_id` int NOT NULL COMMENT '每首歌的唯一标识符',
  `is_upload` int NOT NULL DEFAULT '0' COMMENT '是否为用户上传',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '数据是否被弃用',
  PRIMARY KEY (`singer_id`,`song_id`),
  CONSTRAINT `mapss_singer_singer_id_fk` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`singer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这个表描述歌手与歌曲的映射';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map_ss`
--

LOCK TABLES `map_ss` WRITE;
/*!40000 ALTER TABLE `map_ss` DISABLE KEYS */;
/*!40000 ALTER TABLE `map_ss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singer`
--

DROP TABLE IF EXISTS `singer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `singer` (
  `singer_id` int NOT NULL AUTO_INCREMENT COMMENT '每个歌手的唯一标识符',
  `singer_name` varchar(32) NOT NULL COMMENT '歌手名字',
  `singer_gender` int DEFAULT NULL COMMENT '歌手性别',
  `country` varchar(16) DEFAULT NULL COMMENT '歌手国籍',
  `singer_introduction` varchar(512) DEFAULT NULL COMMENT '歌手简介',
  `photo_url` varchar(64) DEFAULT NULL COMMENT '歌手图片',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '数据是否被弃用',
  `is_upload` int NOT NULL DEFAULT '0' COMMENT '是否为用户上传',
  PRIMARY KEY (`singer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这个表描述歌手信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
/*!40000 ALTER TABLE `singer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `song_id` int NOT NULL AUTO_INCREMENT COMMENT '每首歌的唯一标识符',
  `song_name` varchar(64) NOT NULL COMMENT '歌曲名字',
  `lrc_url` varchar(512) DEFAULT NULL COMMENT '歌曲的歌词文件索引位置',
  `album` varchar(32) DEFAULT NULL COMMENT '歌曲所属于的专辑',
  `release_time` datetime DEFAULT NULL COMMENT '歌曲发行时间',
  `song_tag` int DEFAULT NULL COMMENT '歌曲风格标签',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '数据是否被弃用',
  `is_upload` int NOT NULL DEFAULT '0' COMMENT '是否为用户上传',
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这个表描述歌曲信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '每个用户的唯一标识符',
  `user_account` varchar(20) NOT NULL COMMENT '用户账号',
  `user_name` varchar(32) NOT NULL COMMENT '用户名字',
  `user_password` varchar(128) NOT NULL COMMENT '用户密码',
  `user_gender` int DEFAULT NULL COMMENT '用户性别',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '用户电话号码',
  `email` varchar(30) DEFAULT NULL COMMENT '用户邮箱',
  `birthday` date DEFAULT NULL COMMENT '用户生日',
  `user_introduction` varchar(512) DEFAULT NULL COMMENT '用户简介',
  `location` varchar(128) DEFAULT NULL COMMENT '用户所在地区',
  `avatar` varchar(512) DEFAULT NULL COMMENT '用户头像索引位置',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间（精准到哪一秒）',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '描述该条数据是否被弃用',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `users_user_account_uindex` (`user_account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='这个表描述用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dcx772204','dcx','1232465',0,'','',NULL,'','','','2022-04-29 20:22:48',0),(2,'Apelious','dai','aec35f029fbd72817da4f06647386ab9',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-04-30 18:24:59',0),(3,'Apelious1','canxian','83cf1532ea3d2bc8a82b7b2c6852af60',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-05-02 12:55:00',0),(4,'Apelious2','daicanxian','83cf1532ea3d2bc8a82b7b2c6852af60',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-05-02 13:16:54',0);
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

-- Dump completed on 2022-05-03 16:16:24
