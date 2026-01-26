DROP DATABASE IF EXISTS `nba`;
CREATE DATABASE  IF NOT EXISTS `nba` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nba`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: nba
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
-- Table structure for table `entrenadores`
--

DROP TABLE IF EXISTS `entrenadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenadores` (
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nume_carnet` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `equipos_Nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `nume_carnet_UNIQUE` (`nume_carnet`),
  KEY `fk_entrenadores_equipos1_idx` (`equipos_Nombre`),
  CONSTRAINT `fk_equipos` FOREIGN KEY (`equipos_Nombre`) REFERENCES `equipos` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenadores`
--

LOCK TABLES `entrenadores` WRITE;
/*!40000 ALTER TABLE `entrenadores` DISABLE KEYS */;
INSERT INTO `entrenadores` VALUES ('1111','entrenador1',21212,'2016-08-09','Golden State Warrior'),('1122','entrenador2',21323232,'2016-08-09','Brooklyn Nets'),('1133','entrenador3',214242422,'2016-08-09','Dallas Mavericks');
/*!40000 ALTER TABLE `entrenadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `Nombre` varchar(40) NOT NULL,
  `Ciudad` varchar(20) DEFAULT NULL,
  `Conferencia` varchar(4) DEFAULT NULL,
  `Division` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES ('Boston Celtics','Boston','E','Atlantic'),('Brooklyn Nets','Brooklyn','E','Atlantic'),('Chicago Bulls','Chicago','E','Central'),('Dallas Mavericks','Dallas','O','Southwest'),('Golden State Warrior','San Francisco','O','Pacific'),('Houston Rockets','Houston','O','Southwest'),('Los Angeles Lakers','Los Angeles','O','Pacific'),('Miami Heat','Miami','E','Southeast'),('Milwaukee Bucks','Milwaukee','E','Central'),('Phoenix Suns','Phoenix','O','Pacific');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) DEFAULT NULL,
  `Altura` varchar(4) DEFAULT NULL,
  `Posicion` varchar(5) DEFAULT NULL,
  `Nombre_equipo` varchar(20) DEFAULT NULL,
  `nacimiento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `Nombre_equipo` (`Nombre_equipo`),
  CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`Nombre_equipo`) REFERENCES `equipos` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (11,'LeBron James','2.06','Alero','Miami Heat','1984-12-30'),(12,'Stephen Curry','1.88','Base','Golden State Warrior','1988-03-14'),(13,'Zach LaVine','1.98','Escol','Chicago Bulls','1995-03-10'),(14,'Jimmy Butler','2.01','Alero','Miami Heat','1989-09-14'),(15,'Jayson Tatum','2.03','Alero','Boston Celtics','1998-03-03'),(16,'Kevin Durant','2.08','Alero','Brooklyn Nets','1988-09-29'),(17,'Luka Dončić','2.01','Base','Dallas Mavericks','1999-02-28'),(18,'Jalen Green','1.93','Escol','Houston Rockets','2002-02-09'),(19,'Devin Booker','1.96','Escol','Phoenix Suns','1996-10-30'),(20,'Giannis Antetokounmpo','2.11','Alero','Milwaukee Bucks','1994-12-06'),(31,'Anthony Davis','2.08','Pivot','Los Angeles Lakers','1993-03-11'),(32,'Russell Westbrook','1.91','Base','Los Angeles Lakers','1988-11-12'),(33,'Klay Thompson','1.98','Escol','Golden State Warrior','1990-02-08'),(34,'Draymond Green','1.98','Ala-P','Golden State Warrior','1990-03-04'),(35,'Nikola Vučević','2.13','Pivot','Chicago Bulls','1990-10-24'),(36,'DeMar DeRozan','2.01','Alero','Chicago Bulls','1989-08-07'),(37,'Bam Adebayo','2.06','Pivot','Miami Heat','1997-07-18'),(38,'Tyler Herro','1.96','Escol','Miami Heat','2000-01-20'),(39,'Jaylen Brown','1.98','Alero','Boston Celtics','1996-10-24'),(40,'Marcus Smart','1.93','Escol','Boston Celtics','1994-03-06'),(41,'James Harden','1.96','Escol','Brooklyn Nets','1989-08-26'),(42,'Kyrie Irving','1.88','Base','Brooklyn Nets','1992-03-23'),(43,'Kristaps Porziņģis','2.21','Ala-P','Dallas Mavericks','1995-08-02'),(44,'Tim Hardaway Jr.','1.96','Escol','Dallas Mavericks','1992-03-16'),(45,'Christian Wood','2.08','Pivot','Houston Rockets','1995-09-27'),(46,'Kevin Porter Jr.','1.93','Escol','Houston Rockets','2000-05-04'),(47,'Chris Paul','1.83','Base','Phoenix Suns','1985-05-06'),(48,'Deandre Ayton','2.11','Pivot','Phoenix Suns','1998-07-23'),(49,'Khris Middleton','2.01','Alero','Milwaukee Bucks','1991-08-12'),(50,'Brook Lopez','2.13','Pivot','Milwaukee Bucks','1988-04-01');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_deportivo`
--

DROP TABLE IF EXISTS `material_deportivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_deportivo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_deportivo`
--

LOCK TABLES `material_deportivo` WRITE;
/*!40000 ALTER TABLE `material_deportivo` DISABLE KEYS */;
INSERT INTO `material_deportivo` VALUES (1,'Balón de baloncesto','Balón oficial de la NBA'),(2,'Aro de baloncesto','Aro estándar con red'),(3,'Tablero de baloncesto','Tablero de vidrio templado'),(4,'Zapatillas de baloncesto','Zapatillas de alta calidad para jugadores'),(5,'Conos de entrenamiento','Conos para ejercicios de agilidad'),(6,'Silbato','Silbato de árbitro'),(7,'Cronómetro','Cronómetro digital para medir el tiempo'),(8,'Botellas de agua','Botellas reutilizables para hidratación'),(9,'Cinta adhesiva','Cinta para protección y soporte'),(10,'Pizarra táctica','Pizarra para estrategias de juego');
/*!40000 ALTER TABLE `material_deportivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidos` (
  `codigo` int NOT NULL,
  `equipo_local` varchar(20) DEFAULT NULL,
  `equipo_visitante` varchar(20) DEFAULT NULL,
  `puntos_local` int DEFAULT NULL,
  `puntos_visitante` int DEFAULT NULL,
  `temporada` varchar(5) DEFAULT NULL,
  `fechahora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `equipo_local` (`equipo_local`),
  KEY `equipo_visitante` (`equipo_visitante`),
  CONSTRAINT `fk_local` FOREIGN KEY (`equipo_local`) REFERENCES `equipos` (`Nombre`),
  CONSTRAINT `partidos_ibfk_1` FOREIGN KEY (`equipo_visitante`) REFERENCES `equipos` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` VALUES (1,'Golden State Warrior','Miami Heat',80,75,'2017','2021-10-22 18:00:00'),(2,'Los Angeles Lakers','Houston Rockets',90,92,'2017','2021-10-22 18:00:00'),(3,'Los Angeles Lakers','Dallas Mavericks',30,60,'2019','2021-10-22 18:00:00'),(4,'Houston Rockets','Dallas Mavericks',10,10,'2019','2021-10-29 18:30:00'),(5,'Dallas Mavericks','Miami Heat',1,2,'2019','2021-10-22 18:00:00'),(7,'Miami Heat','Los Angeles Lakers',NULL,NULL,'2017',NULL),(10,'Miami Heat','Los Angeles Lakers',NULL,NULL,'2017',NULL),(16,'Miami Heat','Los Angeles Lakers',NULL,NULL,'2017','2021-10-23 18:00:00'),(33,'Golden State Warrior','Chicago Bulls',87,90,'2017',NULL),(34,'Miami Heat','Los Angeles Lakers',NULL,NULL,'2020',NULL),(35,'Miami Heat','Los Angeles Lakers',NULL,NULL,'2020',NULL),(999,'Miami Heat','Los Angeles Lakers',NULL,NULL,'2017','');
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos_material_deportivo`
--

DROP TABLE IF EXISTS `partidos_material_deportivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidos_material_deportivo` (
  `partido_id` int NOT NULL,
  `material_id` int NOT NULL,
  PRIMARY KEY (`partido_id`,`material_id`),
  KEY `fk_partido` (`partido_id`),
  KEY `fk_material` (`material_id`),
  CONSTRAINT `fk_material` FOREIGN KEY (`material_id`) REFERENCES `material_deportivo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_partido` FOREIGN KEY (`partido_id`) REFERENCES `partidos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos_material_deportivo`
--

LOCK TABLES `partidos_material_deportivo` WRITE;
/*!40000 ALTER TABLE `partidos_material_deportivo` DISABLE KEYS */;
INSERT INTO `partidos_material_deportivo` VALUES (1,1),(1,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,9),(5,10);
/*!40000 ALTER TABLE `partidos_material_deportivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'nba'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-26 11:31:32