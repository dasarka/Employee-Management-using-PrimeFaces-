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
-- Temporary view structure for view `emp_avail_resource`
--

DROP TABLE IF EXISTS `emp_avail_resource`;
/*!50001 DROP VIEW IF EXISTS `emp_avail_resource`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `emp_avail_resource` AS SELECT 
 1 AS `user_id`,
 1 AS `user_name`,
 1 AS `password`,
 1 AS `emp_name`,
 1 AS `emp_desg`,
 1 AS `emp_access`,
 1 AS `emp_remainHours`,
 1 AS `accessVal`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `emp_proj_map`
--

DROP TABLE IF EXISTS `emp_proj_map`;
/*!50001 DROP VIEW IF EXISTS `emp_proj_map`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `emp_proj_map` AS SELECT 
 1 AS `project_id`,
 1 AS `project_name`,
 1 AS `start_date`,
 1 AS `end_date`,
 1 AS `client_name`,
 1 AS `user_id`,
 1 AS `emp_name`,
 1 AS `flag`,
 1 AS `working_hours`,
 1 AS `lms_start_date`,
 1 AS `lms_end_date`,
 1 AS `onsite_manager`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `emp_avail_resource`
--

/*!50001 DROP VIEW IF EXISTS `emp_avail_resource`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`localUser`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `emp_avail_resource` AS select `auth`.`user_id` AS `user_id`,`auth`.`user_name` AS `user_name`,`auth`.`password` AS `password`,`auth`.`emp_name` AS `emp_name`,`auth`.`emp_desg` AS `emp_desg`,`auth`.`emp_access` AS `emp_access`,`auth`.`emp_remainHours` AS `emp_remainHours`,`acc`.`accessVal` AS `accessVal` from (`emp_authentication` `auth` join `emp_access` `acc`) where ((`auth`.`emp_access` = `acc`.`accessId`) and (`auth`.`emp_remainHours` > 0)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `emp_proj_map`
--

/*!50001 DROP VIEW IF EXISTS `emp_proj_map`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`localUser`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `emp_proj_map` AS select `proj`.`project_id` AS `project_id`,`proj`.`project_name` AS `project_name`,`proj`.`start_date` AS `start_date`,`proj`.`end_date` AS `end_date`,`proj`.`client_name` AS `client_name`,`auth`.`user_id` AS `user_id`,`auth`.`emp_name` AS `emp_name`,`proj`.`flag` AS `flag`,`alloc`.`working_hours` AS `working_hours`,`alloc`.`lms_start_date` AS `lms_start_date`,`alloc`.`lms_end_date` AS `lms_end_date`,(select `auth`.`emp_name` from (`emp_project_allocation` `alloc` join `emp_authentication` `auth`) where ((`auth`.`user_id` = `alloc`.`user_id`) and (`auth`.`emp_access` = 10) and (`alloc`.`project_id` = `proj`.`project_id`))) AS `onsite_manager` from ((`emp_project` `proj` join `emp_authentication` `auth`) join `emp_project_allocation` `alloc`) where ((`proj`.`project_id` = `alloc`.`project_id`) and (`alloc`.`user_id` = `auth`.`user_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping events for database 'empmanagement'
--

--
-- Dumping routines for database 'empmanagement'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-11  1:15:10
