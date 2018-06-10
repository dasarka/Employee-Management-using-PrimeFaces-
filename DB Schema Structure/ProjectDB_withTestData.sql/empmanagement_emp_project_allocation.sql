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
-- Table structure for table `emp_project_allocation`
--

DROP TABLE IF EXISTS `emp_project_allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_project_allocation` (
  `allocation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `working_hours` int(11) NOT NULL DEFAULT '0',
  `lms_start_date` varchar(100) DEFAULT 'NA',
  `lms_end_date` varchar(100) DEFAULT 'NA',
  PRIMARY KEY (`allocation_id`),
  KEY `project_id_1_idx` (`project_id`),
  KEY `user_id_1_idx` (`user_id`),
  CONSTRAINT `project_id_1` FOREIGN KEY (`project_id`) REFERENCES `emp_project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_1` FOREIGN KEY (`user_id`) REFERENCES `emp_authentication` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_project_allocation`
--

LOCK TABLES `emp_project_allocation` WRITE;
/*!40000 ALTER TABLE `emp_project_allocation` DISABLE KEYS */;
INSERT INTO `emp_project_allocation` VALUES (1,31,32,0,'NA','NA'),(2,33,32,0,'NA','NA'),(3,32,32,0,'NA','NA'),(4,34,32,0,'NA','NA'),(5,31,33,0,'NA','NA'),(6,33,33,0,'NA','NA'),(7,32,33,0,'NA','NA'),(8,34,33,0,'NA','NA'),(9,31,34,0,'NA','NA'),(10,33,34,0,'NA','NA'),(11,32,34,0,'NA','NA'),(12,34,34,0,'NA','NA'),(13,45,35,0,'NA','NA'),(14,45,36,0,'NA','NA'),(15,46,37,0,'NA','NA'),(16,46,38,0,'NA','NA'),(17,62,35,4,'NA','NA'),(18,49,35,4,'NA','NA'),(19,47,35,8,'NA','NA'),(20,35,35,8,'NA','NA'),(21,51,35,8,'NA','NA'),(22,53,35,8,'NA','NA'),(23,38,35,4,'NA','NA'),(24,55,35,4,'NA','NA'),(25,40,35,8,'NA','NA'),(26,57,35,8,'NA','NA'),(28,60,35,8,'NA','NA'),(29,50,33,0,'NA','NA'),(30,47,34,0,'10/06/2018','10/06/2018'),(31,48,33,0,'NA','NA'),(32,59,35,4,'NA','NA'),(33,48,34,0,'11/06/2018','18/06/2018'),(34,52,35,2,'NA','NA'),(35,36,33,0,'NA','NA');
/*!40000 ALTER TABLE `emp_project_allocation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-11  1:15:09
