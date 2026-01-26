DROP DATABASE IF EXISTS `musica`;
CREATE DATABASE  IF NOT EXISTS `musica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `musica`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: musica
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES ('1111111111','Adrian Lee'),('1111111112','Adam Clayton'),('1111111113','Bono'),('1111111114','C. Burchill'),('1111114444','Carlos Torero'),('2345678444','Edge'),('3232456547','Phil Collins'),('3333567898','Santiago Auseron'),('3454677777','Jim Kerr'),('4444444444','Larry Jr.Mullen'),('4454321111','Luis Auseron'),('5454532222','Paul Young'),('5555678976','Enrique Sierra'),('5556787777','J.L. Giménez'),('5656378999','Soledad Giménez'),('6666667885','Nacho Maño'),('7654323234','P. van Hooke'),('7876543428','Tony Banks'),('8884566666','M. Rutherford');
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancion`
--

DROP TABLE IF EXISTS `cancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancion` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) NOT NULL,
  `duracion` double(15,5) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancion`
--

LOCK TABLES `cancion` WRITE;
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
INSERT INTO `cancion` VALUES (1,'20th Century Promise',4.00000),(2,'37 grados',4.00000),(3,'4th of July',3.00000),(4,'7 Deadly Sins',6.00000),(5,'A cara o cruz',5.00000),(6,'A sort of homecoming',3.00000),(7,'Afterglow',4.00000),(8,'Al atardecer',4.00000),(9,'Al sur',3.00000),(10,'Alive And Kicking',4.00000),(11,'All The things She..',4.00000),(12,'Alma de blues',4.00000),(13,'And The Band ...',4.00000),(14,'Andas junto a mí',3.00000),(15,'Annabel Lee',3.00000),(16,'Anything she does',3.00000),(17,'Artitoestoy',4.00000),(18,'Asoma el llanto',3.00000),(19,'Babyface',4.00000),(20,'Bad',2.00000),(21,'Barbara del campo',4.00000),(22,'Beautiful day',5.00000),(23,'Before',4.00000),(24,'Black and blue',3.00000),(25,'Blame',4.00000),(26,'Book of Brilliant...',5.00000),(27,'Brazilian',4.00000),(28,'Cada historia',3.00000),(29,'Can\'t dance',4.00000),(30,'Careful In Career',4.00000),(31,'Carpet crawlers',4.00000),(32,'Cinema show',5.00000),(33,'Come A Long Way',2.00000),(34,'Como hemos cambiado',3.00000),(35,'Criminal World',5.00000),(36,'Cuando quiero sol',5.00000),(37,'Daddys Goma pay for',5.00000),(38,'Dance on a volcano',4.00000),(39,'De puntillas',3.00000),(40,'De sol a sol',4.00000),(41,'Dirty day',5.00000),(42,'Domino',5.00000),(43,'Don\'t',4.00000),(44,'Dreaming while ...',4.00000),(45,'Driving the last...',4.00000),(46,'E.de C. instrumental',3.00000),(47,'East At Easter',4.00000),(48,'El canto del gallo',5.00000),(49,'El hombre de papel',2.00000),(50,'El nadador',3.00000),(51,'Elvis Presley & USA',3.00000),(52,'En Portugal',3.00000),(53,'En la oscuridad',5.00000),(54,'En un baile de perro',2.00000),(55,'Encadenada',4.00000),(56,'Escuela de calor',3.00000),(57,'Even Better Than...',3.00000),(58,'Every body gets...',5.00000),(59,'Fading lights',5.00000),(60,'Fire',7.00000),(61,'Firth of fith',4.00000),(62,'Fly',4.00000),(63,'Get up',4.00000),(64,'Ghostdancing',3.00000),(65,'Gloria',6.00000),(67,'Great Leap Forward',4.00000),(68,'Guitarra y voz',1.00000),(69,'Hadaly',3.00000),(70,'Hay algo raro...',3.00000),(71,'Historia de playback',3.00000),(72,'Hypnotised',5.00000),(73,'I Fall Down',7.00000),(74,'I Threw a Brick',6.00000),(75,'I Wish You Were Here',4.00000),(76,'I know what I like',3.00000),(77,'Icaro',3.00000),(78,'In the glow of night',4.00000),(79,'In too deep',4.00000),(80,'Indian summer sky',4.00000),(81,'Invisible touch',3.00000),(82,'Is That All',6.00000),(83,'Jesus he knows me',5.00000),(84,'La futura promesa',3.00000),(85,'La ley',4.00000),(86,'La mala hora',3.00000),(87,'La negra flor',5.00000),(88,'La noche',2.00000),(89,'La secta del mar',3.00000),(90,'Lamb lies down...',5.00000),(91,'Land of confusion',4.00000),(92,'League Of nations',4.00000),(93,'Lemon',6.00000),(94,'Let\'s pretend...',5.00000),(95,'Living forever',4.00000),(96,'Living years',4.00000),(97,'Llovió',2.00000),(98,'Lluvia del porvenir',3.00000),(99,'Los endos',4.00000),(100,'Love is Blindness',4.00000),(101,'Luna de agosto',3.00000),(102,'MLK',2.00000),(103,'Me das el mar',3.00000),(104,'Mil mariposas',3.00000),(105,'Moon Cry Like A Baby',4.00000),(106,'Musical box',4.00000),(107,'My Life',4.00000),(108,'My crime of passion',3.00000),(109,'Mysterious Ways',4.00000),(110,'Nada tiene sentido',3.00000),(111,'Never a time',5.00000),(112,'Ni tu ni yo',3.00000),(113,'Night Music',4.00000),(114,'No hay humor',3.00000),(115,'No hay palabras',3.00000),(116,'No son of mine',4.00000),(117,'Nobody knows',3.00000),(118,'Nobody\'s perfect',3.00000),(119,'Numb',4.00000),(120,'October',6.00000),(121,'Oh Jungleland',3.00000),(122,'Once Upon A Time',4.00000),(123,'One',4.00000),(124,'Oscuro affaire',3.00000),(125,'Poor boy down',2.00000),(126,'Price',1.00000),(127,'Promenade',3.00000),(128,'Recibes cartas',3.00000),(130,'Rejoice',7.00000),(131,'Rio Po',4.00000),(132,'Robbery, assault...',3.00000),(133,'Sanctify yourself',4.00000),(134,'Scarlet',7.00000),(135,'Sed de amor',4.00000),(136,'Seeing is believing',5.00000),(137,'Semilla negra',4.00000),(138,'Sentir tu calor',4.00000),(139,'Ser de agua',3.00000),(140,'Shake Of The Ghosts',3.00000),(141,'She\'s A river',3.00000),(142,'Since I lost you',4.00000),(143,'So Cruel',6.00000),(144,'Some days are better',4.00000),(145,'Sound In 70 Cities',4.00000),(146,'Speed Your Love...',4.00000),(147,'Squok',4.00000),(148,'Stay',4.00000),(149,'Stop baby',4.00000),(150,'Stranger in a Land',7.00000),(151,'Street Hassle',4.00000),(152,'Supper\'s ready',5.00000),(153,'Tell me why',5.00000),(154,'The Kick Inside ofme',4.00000),(155,'The american',4.00000),(156,'The first time',3.00000),(157,'The last domino',5.00000),(158,'The unforgettable fi',5.00000),(159,'The wanderer',4.00000),(160,'Theme For Great city',3.00000),(161,'This Time',3.00000),(162,'Throwing it all away',4.00000),(163,'Time and place',4.00000),(164,'Tomorrow',6.00000),(165,'Tonight, tonight...',4.00000),(166,'Tormenta de arena',4.00000),(167,'Tryin to Throw...',4.00000),(168,'Ultra Violet',5.00000),(169,'Un africano...',3.00000),(170,'Until The end...',5.00000),(171,'Up On The Catwalk',4.00000),(172,'Volviendo a casa',3.00000),(173,'Waterfront',3.00000),(174,'Way of the world',5.00000),(175,'Way you look at me',3.00000),(176,'White Hot Day',5.00000),(177,'Whos Gonna ride...',5.00000),(178,'Why me?',3.00000),(179,'Wire',2.00000),(180,'With a Shout',7.00000),(181,'Wonderful In Young',5.00000),(182,'Word of mouth',3.00000),(183,'Yesterday, today,..',2.00000),(184,'Zoo Station',4.00000),(185,'Zooropa',6.00000),(186,'Hold on my heart',4.00000),(187,'Hibernando a las 3 pm',4.50000),(188,'Hibernando a las 3 pm',4.50000),(189,'Hibernando a las 3 pm bis',4.50000),(190,'Hibernando a las 3 pm bis',4.50000),(191,'titulo1_ex',3.00000),(192,'titulo11_ex',3.00000),(193,'titulo11_ex',5.00000),(194,'titulo11_ex',3.00000),(195,'titulo11_ex',3.00000),(196,'titulo12_ex',2.00000),(197,'Hibernando a las 3 pm bis',4.50000);
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `sede` varchar(30) DEFAULT NULL,
  `num` smallint DEFAULT NULL,
  `cod_gru` int NOT NULL,
  PRIMARY KEY (`cod`),
  KEY `grupoclub` (`cod_gru`),
  KEY `fk_grupo_club_idx` (`cod_gru`),
  CONSTRAINT `fk_grupo_club` FOREIGN KEY (`cod_gru`) REFERENCES `grupo` (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (1,'Zoomania','33, Abbey Road',2508,1),(3,'Che U2','C/Almussafes 59',239,1),(4,'Troglominds','C/Lepe 22',999,2),(5,'Mentes Fuertes','Ramon y Cajal 14',1984,2),(6,'The best mind','24, Homeround',1413,2),(7,'Genefans','C/Visitacion 34',23412,4),(8,'Fanaticgens','Av. H. Dominicos 155',12002,4),(9,'Futuristas','C/Alboraya 10',9850,6),(10,'Machines','Calle 3, Lab 3',7789,3),(11,'Jardin Botanico','203,Valencia 46004',357,6),(12,'Bonoculture','12, East Av.',129,1),(13,'Waterfront','C/Martin Blas 22',234,2),(14,'FanMike','Beverly Hills 90210',11,3),(15,'Presuntos','C/Albacete 12, bajo',237,5),(16,'Implicado','Torrejon de Ardoz 12',25,5),(17,'Los Culpables','C/Maria Cristina 67',355,5),(18,'PocaJuntasa','Castilla La Mancha',67,1111111114);
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companyia`
--

DROP TABLE IF EXISTS `companyia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companyia` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `dir` varchar(30) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL,
  `tfno` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companyia`
--

LOCK TABLES `companyia` WRITE;
/*!40000 ALTER TABLE `companyia` DISABLE KEYS */;
INSERT INTO `companyia` VALUES (1,'Island','67, JB St.','     78782222','     72724444'),(2,'ARIOLA','Aragon 204','    913667889','    913667890'),(3,'WEA','L Hoyos 42','    932401212','    932401213'),(4,'Virgin','2,23th St.','     20812445','     20812446'),(5,'ATLANTIC','12, E St.','      5481223','      5482312'),(6,'PoliDiscos','Cami de Vera','      3870001','      3870000'),(7,'PoliDiscos','Polynesia St.','    942380540','    942380522'),(8,'dasda','asdaasd','dasdasd','asdada');
/*!40000 ALTER TABLE `companyia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disco`
--

DROP TABLE IF EXISTS `disco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disco` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `cod_comp` int NOT NULL,
  `cod_gru` int NOT NULL,
  PRIMARY KEY (`cod`),
  KEY `companyiadisco` (`cod_comp`),
  KEY `grupodisco` (`cod_gru`),
  KEY `fk__idx` (`cod_comp`),
  KEY `fk_grupo_disco_idx` (`cod_gru`),
  CONSTRAINT `fk_companyia_disco` FOREIGN KEY (`cod_comp`) REFERENCES `companyia` (`cod`),
  CONSTRAINT `fk_grupo_disco` FOREIGN KEY (`cod_gru`) REFERENCES `grupo` (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disco`
--

LOCK TABLES `disco` WRITE;
/*!40000 ALTER TABLE `disco` DISABLE KEYS */;
INSERT INTO `disco` VALUES (1,'October','1981-10-12 00:00:00',1,1),(2,'Zooropa','1994-08-10 00:00:00',1,1),(3,'The unforgettable fi','1983-03-07 00:00:00',1,1),(4,'Achtung baby','1991-12-09 00:00:00',1,1),(5,'Once upon a time','1985-10-10 00:00:00',4,2),(6,'Good news F.N. world','1995-11-12 00:00:00',4,2),(7,'Sparkle in the rain','1984-03-03 00:00:00',4,2),(8,'Sister feelings call','1981-03-04 00:00:00',4,2),(9,'Living years','1988-04-02 00:00:00',5,3),(10,'Word of mouth','1991-05-07 00:00:00',5,3),(11,'We can\'t dance','1991-02-02 00:00:00',5,4),(12,'Invisible touch','1986-03-03 00:00:00',5,4),(13,'Seconds out','1986-08-08 00:00:00',5,4),(14,'De sol a sol','1987-01-08 00:00:00',3,5),(15,'Ser de agua','1991-02-05 00:00:00',3,5),(16,'Alma de blues','1989-02-03 00:00:00',3,5),(17,'La ley del desierto','1984-03-02 00:00:00',1,6),(18,'La canción de Jperro','1987-04-03 00:00:00',1,6),(20,'Hibernando','2015-02-10 00:00:00',1,1),(21,'Hibernando','2015-02-10 00:00:00',1,1),(22,'Hibernando bis','2015-02-10 00:00:00',1,1),(23,'Hibernando bis','2015-02-10 00:00:00',1,1),(27,'Hibernando bis','2015-02-10 00:00:00',1,1),(28,'recopilatorio','2017-01-30 14:25:16',1,1),(29,'recopilatorio','2017-01-30 14:27:03',1,1),(30,'recopilatorio','2017-01-30 14:29:04',1,1),(31,'recopilatorio','2017-01-30 14:29:41',1,1);
/*!40000 ALTER TABLE `disco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `esta`
--

DROP TABLE IF EXISTS `esta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `esta` (
  `can` int NOT NULL,
  `cod` int NOT NULL,
  PRIMARY KEY (`can`,`cod`),
  KEY `cancionesta` (`can`),
  KEY `discoesta` (`cod`),
  KEY `estacod` (`cod`),
  KEY `fk_cancion_esta_idx` (`can`),
  KEY `fk_disco_esta_idx` (`cod`),
  CONSTRAINT `fk_cancion_esta` FOREIGN KEY (`can`) REFERENCES `cancion` (`cod`),
  CONSTRAINT `fk_disco_esta` FOREIGN KEY (`cod`) REFERENCES `disco` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `esta`
--

LOCK TABLES `esta` WRITE;
/*!40000 ALTER TABLE `esta` DISABLE KEYS */;
INSERT INTO `esta` VALUES (1,8),(2,18),(3,3),(4,6),(5,18),(6,3),(7,13),(8,15),(9,14),(10,5),(11,5),(12,16),(13,6),(14,15),(15,18),(16,12),(17,4),(18,16),(19,2),(20,3),(21,15),(22,9),(23,10),(24,9),(25,9),(26,7),(27,12),(28,16),(29,11),(30,8),(31,13),(32,13),(33,5),(34,15),(35,6),(36,15),(37,2),(38,13),(39,15),(40,14),(41,2),(42,12),(43,9),(44,11),(45,11),(46,17),(47,7),(48,18),(49,18),(50,17),(51,3),(52,17),(53,14),(54,18),(55,16),(56,17),(57,4),(57,28),(57,29),(57,30),(57,31),(58,10),(59,11),(60,1),(61,13),(62,4),(63,10),(64,5),(65,1),(67,6),(68,16),(69,17),(70,14),(71,17),(72,6),(73,1),(74,1),(75,5),(76,13),(77,15),(78,12),(79,12),(80,3),(81,12),(82,1),(83,11),(84,16),(85,17),(86,18),(87,18),(88,16),(89,17),(90,13),(91,12),(92,8),(93,2),(94,10),(95,11),(96,9),(97,15),(98,18),(99,13),(100,4),(101,18),(102,3),(103,16),(104,15),(105,7),(106,13),(107,6),(108,10),(109,4),(110,14),(111,11),(112,14),(113,6),(114,16),(115,16),(116,11),(117,9),(118,9),(119,2),(120,1),(121,5),(122,5),(123,4),(124,17),(125,9),(126,3),(126,28),(126,29),(126,30),(126,31),(127,3),(128,15),(130,1),(131,16),(132,13),(133,5),(134,1),(135,14),(136,9),(137,17),(138,15),(139,15),(140,7),(141,6),(142,11),(143,4),(144,2),(145,8),(146,7),(147,13),(148,2),(149,10),(150,1),(151,7),(152,13),(153,11),(154,7),(155,8),(156,2),(156,28),(156,29),(156,30),(156,31),(157,12),(158,3),(159,2),(160,8),(161,6),(162,12),(163,10),(164,1),(165,12),(166,17),(167,4),(168,4),(169,17),(170,4),(171,7),(172,14),(173,7),(174,11),(175,10),(176,7),(177,4),(178,9),(179,3),(180,1),(181,8),(182,10),(183,10),(184,4),(185,2),(186,11),(187,20),(187,28),(187,29),(187,30),(187,31),(188,21),(188,28),(188,29),(188,30),(188,31),(189,22),(189,28),(189,29),(189,30),(189,31),(190,23),(190,28),(190,29),(190,30),(190,31),(193,1),(193,28),(193,29),(193,30),(193,31),(197,27),(197,28),(197,29),(197,30),(197,31);
/*!40000 ALTER TABLE `esta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `pais` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=1111111115 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,'U2','1977-01-01 00:00:00','Inglaterra'),(2,'Simple Minds','1979-02-09 00:00:00','Inglaterra'),(3,'Mike + The Mechanics','1988-04-06 00:00:00','Inglaterra'),(4,'Genesis','1975-10-10 00:00:00','Inglaterra'),(5,'Presuntos Implicados','1985-11-01 00:00:00','España'),(6,'Radio Futura','1980-01-07 00:00:00','España'),(1111111111,'prueba1',NULL,'saxo'),(1111111112,'prueba22',NULL,NULL),(1111111114,'MalaGestion',NULL,NULL);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pertenece`
--

DROP TABLE IF EXISTS `pertenece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pertenece` (
  `dni` varchar(10) NOT NULL,
  `cod` int NOT NULL,
  `funcion` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`dni`,`cod`),
  KEY `artistapertenece` (`dni`),
  KEY `grupopertenece` (`cod`),
  KEY `fk_artista_pertenece_idx` (`dni`),
  KEY `fk_grupo_pertenece_idx` (`cod`),
  CONSTRAINT `fk_artista_pertenece` FOREIGN KEY (`dni`) REFERENCES `artista` (`dni`),
  CONSTRAINT `fk_grupo_pertenece` FOREIGN KEY (`cod`) REFERENCES `grupo` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pertenece`
--

LOCK TABLES `pertenece` WRITE;
/*!40000 ALTER TABLE `pertenece` DISABLE KEYS */;
INSERT INTO `pertenece` VALUES ('1111111111',3,'teclado'),('1111111112',1,'teclado'),('1111111113',1,'voz'),('1111111114',2,'guitarra'),('1111114444',6,'batería'),('2345678444',1,'guitarra'),('3232456547',4,'voz'),('3333567898',6,'voz'),('3454677777',2,'voz'),('4444444444',1,'batería'),('4454321111',6,'bajo'),('5454532222',3,'voz'),('5555678976',6,'guitarra'),('5556787777',5,'guitarra'),('5656378999',5,'voz'),('6666667885',5,'bajo'),('7654323234',3,'batería'),('7876543428',4,'teclado'),('8884566666',3,'bajo'),('8884566666',4,'bajo');
/*!40000 ALTER TABLE `pertenece` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'musica'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-26 11:31:33