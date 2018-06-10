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
-- Table structure for table `emp_task`
--

DROP TABLE IF EXISTS `emp_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(100) NOT NULL,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `end_date` varchar(100) NOT NULL,
  `task_desc` varchar(2000) NOT NULL,
  `task_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`task_id`),
  KEY `project_id_1_idx` (`project_id`),
  KEY `task_user_id_idx` (`user_id`),
  CONSTRAINT `task+project_id` FOREIGN KEY (`project_id`) REFERENCES `emp_project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `task_user_id` FOREIGN KEY (`user_id`) REFERENCES `emp_authentication` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_task`
--

LOCK TABLES `emp_task` WRITE;
/*!40000 ALTER TABLE `emp_task` DISABLE KEYS */;
INSERT INTO `emp_task` VALUES (1,'POC',35,35,'Tue Jul 31 00:00:00 IST 2018','need POC',2),(2,'Development1',35,35,'Tue Nov 27 00:00:00 IST 2018','Development1',0),(3,'Dev2',35,51,'Tue Nov 27 00:00:00 IST 2018','Dev2',0),(4,'Dev3',35,53,'Tue Nov 27 00:00:00 IST 2018','Dev3',0),(5,'Dev4',35,35,'Fri Nov 30 00:00:00 IST 2018','d4',0),(6,'D5',35,51,'Fri Nov 30 00:00:00 IST 2018','D5',0);
/*!40000 ALTER TABLE `emp_task` ENABLE KEYS */;
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
