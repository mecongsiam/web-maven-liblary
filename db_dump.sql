-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: liblary
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `abonement`
--

DROP TABLE IF EXISTS `abonement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abonement` (
  `id_abonement` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `surname` varchar(45) CHARACTER SET utf8 NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 NOT NULL,
  `adress` varchar(45) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id_abonement`),
  KEY `id_us_ab_idx` (`id_abonement`),
  CONSTRAINT `id_us_ab` FOREIGN KEY (`id_abonement`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonement`
--

LOCK TABLES `abonement` WRITE;
/*!40000 ALTER TABLE `abonement` DISABLE KEYS */;
INSERT INTO `abonement` VALUES (36,'bingo','man','mec@gmail.com','minsk','2222227'),(37,'jimmy','hand','hand@dot.com','msk','3333333'),(40,'cotos','cotos','minsk@gmail.com','minsk','2222222'),(41,'Fill','Fill','fill@g.com','sss','2222222'),(43,'asd','fdsf','vince@g.com','sad','2222222'),(44,'qwe','qwe','user@gmail.com','minsk','2222222'),(45,'qwer','qwer','user2@g.com','qwe','2222222'),(46,'qwe','qweasd','g@co.com','vv','2222222'),(48,'vseok','asdsad','vseok@g.com','dfdf','2222222'),(49,'dfsdfdsf','sdfsdfdsf','grib@gmail.com','sdfdsf','2222222'),(51,'sdfsdf','sdfsdf','ff@gamil.com','fdgfd','2222222'),(52,'sdfsdf','sdfsdfsdf','user5@g.com','ewr','2222222'),(53,'sdfsdf','sdfsdfsd','tut@g.com','dffdf','2222222'),(68,'asdasd','asdas','bulkin@gmail.com','minsk','2222222'),(69,'ivan','ibaaa','iv@gm.com','minsk','2222222'),(70,'gili','ggg','gorlum@g.com','minsk','2222222'),(71,'kivich','kivich','kivich@g.com','min','2222222'),(72,'qweasd','rojer','rurik@k.com','minsk','2222222'),(73,'chapeiro','chapeiro','chapeiro@g.com','minsk','2222222');
/*!40000 ALTER TABLE `abonement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auther`
--

DROP TABLE IF EXISTS `auther`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auther` (
  `id_auther` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`id_auther`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auther`
--

LOCK TABLES `auther` WRITE;
/*!40000 ALTER TABLE `auther` DISABLE KEYS */;
INSERT INTO `auther` VALUES (3,'Jimmy','Watzong','2012-11-20'),(4,'Hedrix','Milton','2011-10-20'),(5,'Steeve','Jonhson','1988-11-22');
/*!40000 ALTER TABLE `auther` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auther_pool`
--

DROP TABLE IF EXISTS `auther_pool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auther_pool` (
  `id_auther_pool` int(11) NOT NULL AUTO_INCREMENT,
  `id_book` int(11) NOT NULL,
  `id_auther` int(11) NOT NULL,
  PRIMARY KEY (`id_auther_pool`),
  KEY `id_book_idx` (`id_book`),
  KEY `id_auther_idx` (`id_auther`),
  KEY `id_book_p_idx` (`id_book`),
  CONSTRAINT `id_auther_p` FOREIGN KEY (`id_auther`) REFERENCES `auther` (`id_auther`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_book_p` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auther_pool`
--

LOCK TABLES `auther_pool` WRITE;
/*!40000 ALTER TABLE `auther_pool` DISABLE KEYS */;
INSERT INTO `auther_pool` VALUES (1,4,3),(2,4,4),(3,5,5);
/*!40000 ALTER TABLE `auther_pool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id_book` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id_book`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,'Java',2000),(5,'Spring',2015);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `book_auther`
--

DROP TABLE IF EXISTS `book_auther`;
/*!50001 DROP VIEW IF EXISTS `book_auther`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `book_auther` AS SELECT 
 1 AS `name`,
 1 AS `surname`,
 1 AS `id_book`,
 1 AS `year`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `books_on_hand`
--

DROP TABLE IF EXISTS `books_on_hand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_on_hand` (
  `id_books_on_hand` int(11) NOT NULL AUTO_INCREMENT,
  `id_abonement` int(11) NOT NULL,
  `id_book` int(11) NOT NULL,
  PRIMARY KEY (`id_books_on_hand`),
  KEY `id_book_idx` (`id_book`),
  KEY `for_abonement_idx` (`id_abonement`),
  CONSTRAINT `for_abonement` FOREIGN KEY (`id_abonement`) REFERENCES `abonement` (`id_abonement`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `for_book` FOREIGN KEY (`id_book`) REFERENCES `book` (`id_book`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_on_hand`
--

LOCK TABLES `books_on_hand` WRITE;
/*!40000 ALTER TABLE `books_on_hand` DISABLE KEYS */;
/*!40000 ALTER TABLE `books_on_hand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `name_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (36,'admin','admin','admin'),(37,'buz','buz','user'),(40,'cat','qweasd','admin'),(41,'Colson','qwe','admin'),(43,'vincent','qwe','admin'),(44,'user1','qwe','user'),(45,'user2','qwe','admin'),(46,'user3','qwe','admin'),(48,'vseok','qweasd','admin'),(49,'grib','fdsfdsf','admin'),(51,'galkin','sdfsdf','admin'),(52,'user5','sdfsdf','admin'),(53,'user6','sdfdsf','admin'),(68,'Bulkin','sadas','admin'),(69,'grizli','qweasd','admin'),(70,'Gorlum','qweasd','admin'),(71,'kivich','hhhhh','admin'),(72,'Alik','Alikov','admin'),(73,'chapaeiro','qweasd','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `book_auther`
--

/*!50001 DROP VIEW IF EXISTS `book_auther`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_auther` AS select `book`.`name` AS `name`,`auther`.`surname` AS `surname`,`book`.`id_book` AS `id_book`,`book`.`year` AS `year` from ((`auther_pool` join `book` on((`auther_pool`.`id_book` = `book`.`id_book`))) join `auther` on((`auther_pool`.`id_auther` = `auther`.`id_auther`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-11 15:23:12
