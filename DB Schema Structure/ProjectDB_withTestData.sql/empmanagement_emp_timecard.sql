CREATE DATABASE  IF NOT EXISTS `empmanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `empmanagement`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: empmanagement
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `emp_timecard`
--

DROP TABLE IF EXISTS `emp_timecard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_timecard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` varchar(45) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `month` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `day_mon` int(11) DEFAULT '0',
  `day_tue` int(11) DEFAULT NULL,
  `day_wed` int(11) DEFAULT '0',
  `day_thu` int(11) DEFAULT '0',
  `day_fri` int(11) DEFAULT '0',
  `week_val` varchar(45) DEFAULT NULL,
  `submittion_date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `emp_authentication` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_timecard`
--

LOCK TABLES `emp_timecard` WRITE;
/*!40000 ALTER TABLE `emp_timecard` DISABLE KEYS */;
INSERT INTO `emp_timecard` VALUES (1,'33,',50,'Jun','2018',0,0,0,0,8,'Week1','10-Jun-2018','approved','approved'),(2,'33,',50,'Jun','2018',8,8,8,8,8,'Week2','10-Jun-2018','approved','approved'),(3,'33,',50,'Jun','2018',8,8,8,8,8,'Week3','10-Jun-2018','approved','approved'),(4,'33,',50,'Jun','2018',8,8,8,8,8,'Week4','10-Jun-2018','approved','approved'),(5,'33,',50,'Jun','2018',8,8,8,8,8,'Week5','10-Jun-2018','approved','approved'),(6,'33,',48,'Jun','2018',0,0,0,0,8,'Week1','11-Jun-2018','approved','approved'),(7,'33,',48,'Jun','2018',8,8,8,8,8,'Week2','11-Jun-2018','approved','approved'),(8,'33,',48,'Jun','2018',8,8,8,8,8,'Week3','11-Jun-2018','approved','approved'),(9,'33,',48,'Jun','2018',8,8,8,8,8,'Week4','11-Jun-2018','approved','approved'),(10,'33,',48,'Jun','2018',8,8,8,8,8,'Week5','11-Jun-2018','approved','approved');
/*!40000 ALTER TABLE `emp_timecard` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-11  1:15:06
