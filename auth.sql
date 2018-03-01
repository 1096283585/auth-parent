-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 0.0.0.0    Database: s4t-2.0_auth
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `api`
--

DROP TABLE IF EXISTS `api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `api` (
  `API_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'API ID，自增',
  `API_name` varchar(255) DEFAULT NULL COMMENT 'API 名称',
  `API_http_method` varchar(255) DEFAULT NULL COMMENT 'API HTTP方法',
  `API_URL` varchar(255) DEFAULT NULL COMMENT 'API URL',
  `API_version` varchar(255) DEFAULT NULL COMMENT 'API 版本号',
  `API_category` varchar(255) DEFAULT NULL COMMENT 'API 类别（分组）',
  `API_programmer` varchar(255) DEFAULT NULL COMMENT 'API 开发者',
  `API_desc` varchar(255) DEFAULT NULL COMMENT 'API 描述信息',
  PRIMARY KEY (`API_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permission_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限 ID，自增',
  `permission_catagory_ID` int(10) DEFAULT NULL,
  `permission_identity` varchar(64) DEFAULT 'uuid()',
  `permission_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `permission_desc` varchar(255) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`permission_ID`),
  KEY `fk_permission_permission_catagory1_idx` (`permission_catagory_ID`),
  CONSTRAINT `fk_permission_permission_catagory1` FOREIGN KEY (`permission_catagory_ID`) REFERENCES `permission_category` (`permission_category_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission_associate_api`
--

DROP TABLE IF EXISTS `permission_associate_api`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission_associate_api` (
  `pa_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'API-权限 ID，自增',
  `permission_ID` int(10) DEFAULT NULL COMMENT '权限 ID，外键，权限表',
  `api_ID` int(10) DEFAULT NULL COMMENT 'API ID，外键，API表',
  `pa_desc` varchar(255) DEFAULT NULL COMMENT 'API-权限描述',
  PRIMARY KEY (`pa_ID`),
  KEY `pa_permission` (`permission_ID`),
  KEY `pa_api` (`api_ID`),
  CONSTRAINT `pa_api` FOREIGN KEY (`api_ID`) REFERENCES `api` (`API_ID`),
  CONSTRAINT `pa_permission` FOREIGN KEY (`permission_ID`) REFERENCES `permission` (`permission_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission_category`
--

DROP TABLE IF EXISTS `permission_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission_category` (
  `permission_category_ID` int(10) NOT NULL AUTO_INCREMENT,
  `permission_category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色 ID，自增',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_associate_permission`
--

DROP TABLE IF EXISTS `role_associate_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_associate_permission` (
  `rp_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色-权限 ID，自增',
  `role_ID` int(10) DEFAULT NULL COMMENT '角色 ID，外键，角色表',
  `permission_ID` int(10) DEFAULT NULL COMMENT '权限 ID，外键，权限表',
  `rp_desc` varchar(255) DEFAULT NULL COMMENT '角色-权限描述',
  PRIMARY KEY (`rp_ID`),
  KEY `rp_role` (`role_ID`),
  KEY `rp_permission` (`permission_ID`),
  CONSTRAINT `rp_permission` FOREIGN KEY (`permission_ID`) REFERENCES `permission` (`permission_ID`),
  CONSTRAINT `rp_role` FOREIGN KEY (`role_ID`) REFERENCES `role` (`role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `token_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'TOKEN ID，自增',
  `token_name` varchar(255) DEFAULT NULL COMMENT 'TOKEN 内容',
  `create_time` datetime DEFAULT NULL COMMENT 'token 创建时间',
  `effective_minutes` int(10) DEFAULT NULL COMMENT 'token 有效时间（分钟）',
  `user_ID` int(10) DEFAULT NULL COMMENT '用户 ID，外键，用户表',
  PRIMARY KEY (`token_ID`),
  KEY `token_user` (`user_ID`),
  CONSTRAINT `token_user` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户 ID，自增',
  `user_category_ID` int(10) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(255) DEFAULT NULL COMMENT '用户登录密码',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `user_code` varchar(255) DEFAULT NULL COMMENT '用户唯一编码',
  `user_active` bit(1) DEFAULT NULL COMMENT '用户状态',
  `user_position` enum('总经理','分公司经理','部长','普通员工','组长') DEFAULT '普通员工' COMMENT '职位',
  PRIMARY KEY (`user_ID`),
  UNIQUE KEY `login_name_UNIQUE` (`login_name`),
  KEY `fk_user_auth_type1_idx` (`user_category_ID`),
  CONSTRAINT `fk_user_auth_type1` FOREIGN KEY (`user_category_ID`) REFERENCES `user_category` (`user_category_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_associate_role`
--

DROP TABLE IF EXISTS `user_associate_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_associate_role` (
  `ru_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色-用户 ID',
  `user_ID` int(10) DEFAULT NULL COMMENT '用户 ID，外键，用户表',
  `role_ID` int(10) DEFAULT NULL COMMENT '角色 ID，外键，角色表',
  `ru_desc` varchar(255) DEFAULT NULL COMMENT '角色-用户描述',
  PRIMARY KEY (`ru_ID`),
  KEY `ru_user` (`user_ID`),
  KEY `ru_role` (`role_ID`),
  CONSTRAINT `ru_role` FOREIGN KEY (`role_ID`) REFERENCES `role` (`role_ID`),
  CONSTRAINT `ru_user` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_category`
--

DROP TABLE IF EXISTS `user_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_category` (
  `user_category_ID` int(10) NOT NULL AUTO_INCREMENT,
  `user_category` enum('客户','管理员','员工') DEFAULT NULL,
  PRIMARY KEY (`user_category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-19 10:01:15
