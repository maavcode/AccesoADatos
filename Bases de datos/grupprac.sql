DROP DATABASE IF EXISTS `grupprac`;
CREATE DATABASE  IF NOT EXISTS `grupprac` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `grupprac`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: grupprac
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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `CodA` int NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Domicilio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CodA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'David Martin','Calle1 n2'),(2,'Laura Roig','Calle1 n6'),(3,'Luis Garcia','Calle2 n3'),(4,'Maria Lopez','Calle3 n2'),(5,'Susana Garcia','Calle4 n4'),(6,'Emilio Mari','Calle5 n2'),(7,'Carolina Sanchez','Calle6 n4'),(8,'Clara Gómez','Calle3'),(9,'Javier Gómez','Calle4'),(10,'Mateo Sempere','Calle23'),(11,'Matias Casas','Calla12'),(12,'Sara Maesetro','Calle22');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignatura`
--

DROP TABLE IF EXISTS `asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignatura` (
  `CodAsig` varchar(10) NOT NULL,
  `descripción` varchar(30) DEFAULT NULL,
  `ciclo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CodAsig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignatura`
--

LOCK TABLES `asignatura` WRITE;
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
INSERT INTO `asignatura` VALUES ('BDA','BASES DE DATOS','DAM'),('PRG','PROGRAMACION','DAM');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos` (
  `CodG` varchar(10) NOT NULL,
  `CodAsig` varchar(10) DEFAULT NULL,
  `CodH` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CodG`),
  KEY `CodH` (`CodH`),
  KEY `CodAsig` (`CodAsig`),
  CONSTRAINT `GRUPOS_ibfk_1` FOREIGN KEY (`CodH`) REFERENCES `horarios` (`CodH`),
  CONSTRAINT `GRUPOS_ibfk_2` FOREIGN KEY (`CodAsig`) REFERENCES `asignatura` (`CodAsig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES ('G1','BDA','H1'),('G2','BDA','H2'),('G3','BDA','H3'),('G4','PRG','H4'),('G5','PRG','H2');
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruposmatri`
--

DROP TABLE IF EXISTS `gruposmatri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gruposmatri` (
  `CodG` varchar(10) NOT NULL,
  `CodAl` int NOT NULL,
  `CodH` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CodG`,`CodAl`),
  KEY `CodAl` (`CodAl`),
  CONSTRAINT `GRUPOSMATRI_ibfk_1` FOREIGN KEY (`CodAl`) REFERENCES `alumnos` (`CodA`),
  CONSTRAINT `GRUPOSMATRI_ibfk_2` FOREIGN KEY (`CodG`) REFERENCES `grupos` (`CodG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruposmatri`
--

LOCK TABLES `gruposmatri` WRITE;
/*!40000 ALTER TABLE `gruposmatri` DISABLE KEYS */;
INSERT INTO `gruposmatri` VALUES ('G1',1,'H4'),('G1',2,'H4'),('G1',3,'H1'),('G2',1,'H2'),('G2',2,'H2'),('G2',3,'H2'),('G2',4,'H2'),('G2',5,'H2'),('G2',6,'H2'),('G2',7,'H3'),('G2',8,'H3'),('G2',10,'H2'),('G3',6,'H3'),('G4',1,'H3'),('G4',2,'H3'),('G4',4,'H3'),('G4',7,'H4'),('G4',11,'H3'),('G5',1,'H3');
/*!40000 ALTER TABLE `gruposmatri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `CodH` varchar(10) NOT NULL,
  `horario` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`CodH`),
  UNIQUE KEY `horario` (`horario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES ('H4','Jueves'),('H1','Lunes'),('H2','Martes'),('H3','Miercoles'),('H5','Viernes');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practicas`
--

DROP TABLE IF EXISTS `practicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `practicas` (
  `CodP` varchar(10) NOT NULL,
  `Puntos` int NOT NULL,
  `Curso` int DEFAULT NULL,
  `Fecha_limite` date DEFAULT NULL,
  PRIMARY KEY (`CodP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practicas`
--

LOCK TABLES `practicas` WRITE;
/*!40000 ALTER TABLE `practicas` DISABLE KEYS */;
INSERT INTO `practicas` VALUES ('PR1',10,1,'2014-03-06'),('PR2',10,1,'2014-03-14'),('PR3',7,1,'2014-04-06'),('PR4',10,2,'2014-03-06'),('PR5',10,2,'2014-04-06'),('PR6',8,2,'2014-05-08');
/*!40000 ALTER TABLE `practicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presentan`
--

DROP TABLE IF EXISTS `presentan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presentan` (
  `CodAl` int NOT NULL,
  `CodP` varchar(10) NOT NULL,
  `Nota` int DEFAULT NULL,
  `Fecha_entrega` date DEFAULT NULL,
  PRIMARY KEY (`CodAl`,`CodP`),
  KEY `CodP` (`CodP`),
  CONSTRAINT `PRESENTAN_ibfk_1` FOREIGN KEY (`CodAl`) REFERENCES `alumnos` (`CodA`),
  CONSTRAINT `PRESENTAN_ibfk_2` FOREIGN KEY (`CodP`) REFERENCES `practicas` (`CodP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presentan`
--

LOCK TABLES `presentan` WRITE;
/*!40000 ALTER TABLE `presentan` DISABLE KEYS */;
INSERT INTO `presentan` VALUES (1,'PR1',6,'2014-03-06'),(1,'PR2',2,'2014-03-10'),(1,'PR3',4,'2014-05-06'),(2,'PR4',6,'2014-03-06'),(2,'PR5',6,'2014-03-06'),(3,'PR1',10,'2014-03-06'),(3,'PR2',10,'2014-03-14'),(3,'PR3',5,'2014-04-09'),(3,'PR4',5,'2014-04-03'),(3,'PR5',5,'2014-04-03'),(3,'PR6',5,'2014-04-03'),(4,'PR4',6,'2014-03-05'),(5,'PR1',2,'2014-03-06'),(5,'PR2',3,'2014-04-06'),(6,'PR1',8,'2014-04-02');
/*!40000 ALTER TABLE `presentan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'grupprac'
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