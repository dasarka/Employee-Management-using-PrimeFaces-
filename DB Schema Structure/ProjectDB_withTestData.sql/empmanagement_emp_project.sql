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
-- Table structure for table `emp_project`
--

DROP TABLE IF EXISTS `emp_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL,
  `start_date` varchar(100) NOT NULL,
  `end_date` varchar(100) NOT NULL,
  `resources` int(11) NOT NULL,
  `budget` double NOT NULL,
  `client_name` varchar(100) NOT NULL,
  `flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_project`
--

LOCK TABLES `emp_project` WRITE;
/*!40000 ALTER TABLE `emp_project` DISABLE KEYS */;
INSERT INTO `emp_project` VALUES (32,'Internal Project','Mon Jun 10 00:00:00 IST 2018','Tue Jun 11 00:00:00 IST 2019',0,0,'Master HR','C'),(33,'Bench Project','Mon Jun 10 00:00:00 IST 2018','Tue Jun 11 00:00:00 IST 2019',0,0,'Master HR','C'),(34,'LMS Project','Mon Jun 10 00:00:00 IST 2018','Tue Jun 11 00:00:00 IST 2019',0,0,'Master HR','C'),(35,'project1','Mon Jun 11 00:00:00 IST 2018','Thu Jun 11 00:00:00 IST 2020',8,80000,'client1','C'),(36,'project2','Mon Jun 11 00:00:00 IST 2018','Tue Jun 11 00:00:00 IST 2019',6,5994,'client1','C'),(37,'project3','Thu Jun 21 00:00:00 IST 2018','Sun Jun 21 00:00:00 IST 2020',4,4000,'client2','U'),(38,'project4','Wed Aug 08 00:00:00 IST 2018','Thu Aug 08 00:00:00 IST 2019',4,4000,'client2','U');
/*!40000 ALTER TABLE `emp_project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-11  1:15:07
