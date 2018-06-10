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
-- Table structure for table `emp_authentication`
--

DROP TABLE IF EXISTS `emp_authentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_authentication` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `emp_name` varchar(100) NOT NULL,
  `emp_desg` varchar(100) NOT NULL,
  `emp_access` int(11) DEFAULT '1',
  `emp_remainHours` int(11) DEFAULT '8',
  `leave_balance` int(11) DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  KEY `emp_access_1_idx` (`emp_access`),
  CONSTRAINT `emp_access_1` FOREIGN KEY (`emp_access`) REFERENCES `emp_access` (`accessId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_authentication`
--

LOCK TABLES `emp_authentication` WRITE;
/*!40000 ALTER TABLE `emp_authentication` DISABLE KEYS */;
INSERT INTO `emp_authentication` VALUES (31,'masterAdmin','masterAdmin!123','Master Admin','Master Admin',2,8,14),(32,'masterHR','masterHR!123','Master HR','Master HR',6,8,14),(33,'admin1','admin@123','admin1','Admin Team',2,8,14),(34,'hr1','hr@123','hr1','Resource Team',6,8,14),(35,'developer1','developer@123','developer1','Software Developer',3,0,14),(36,'developer2','developer@123','developer2','Software Developer',3,8,14),(37,'developer3','developer@123','developer3','Software Developer',3,8,14),(38,'perfTester1','perf@123','perfTester1','Performane Tester',8,4,14),(39,'perfTester2','perf@123','perfTester2','Performane Tester',8,8,14),(40,'AutoTester2','auto@123','AutoTester2','Automation Tester',9,0,14),(41,'AutoTester1','auto@123','AutoTester1','Automation Tester',9,8,14),(42,'ManTester1','man@123','ManTester1','Manual Tester',9,8,14),(43,'ManTester2','man@123','ManTester2','Manual Tester',9,8,14),(44,'ManTester3','man@123','ManTester3','Manual Tester',9,8,14),(45,'client1','client@123','client1','Client',7,8,14),(46,'client2','client@123','client2','Client',7,8,14),(47,'lead1','lead@1234','lead1','Project Lead',4,0,13),(48,'lead2','leas@123','lead2','Project Lead',4,8,6),(49,'manager1','manager@123','manager1','Manager',5,4,14),(50,'lead3','lead@123','lead3','Project Lead',4,8,14),(51,'consultant1','cons@123','consultant1','Associate Consultant',3,0,14),(52,'consultant2','cons@123','consultant2','Associate Consultant',8,6,14),(53,'seniorDev1','dev@123','seniorDev1','Senior Developer',3,0,14),(54,'seniorDev2','seniorDev1','seniorDev2','Senior Developer',3,8,14),(55,'seniorPerf1','perf@123','seniorPerf1','Senior Performane Tester',8,4,14),(56,'seniorPerf2','perf@123','seniorPerf2','Senior Performane Tester',8,8,14),(57,'SeniorAuto1','auto@123','SeniorAuto1','Senior Automation Tester',9,0,14),(58,'SeniorAuto2','auto@123','SeniorAuto2','Senior Automation Tester',9,8,14),(59,'SeniorMan1','man@123','SeniorMan1','Senior Manual Tester',9,4,14),(60,'SeniorMan2','man@123','SeniorMan2','Senior Manual Tester',9,0,14),(61,'SeniorManager1','manag@123','SeniorManager1','Senior Manager',5,8,14),(62,'OnsiterManager1','man@123','OnsiterManager1','Onsite Manager',10,4,14),(63,'OnsiterManager2','man@123','OnsiterManager2','Onsite Manager',10,8,14);
/*!40000 ALTER TABLE `emp_authentication` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-11  1:15:10
