DROP DATABASE IF EXISTS `cocina`;
CREATE DATABASE  IF NOT EXISTS `cocina` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cocina`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: cocina
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
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente` (
  `id_ingrediente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `calorias` int DEFAULT NULL,
  PRIMARY KEY (`id_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'Pollo',200),(2,'Merluza',120),(3,'Huevos',150),(4,'Leche',60),(5,'Queso',400),(6,'Tomate',20),(7,'Cebolla',40),(8,'Ajo',10),(9,'Aceite de oliva',900),(10,'Harina',350),(11,'Azúcar',400),(12,'Chocolate',500),(13,'Mantequilla',720),(14,'Perejil',5);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id_menu` int NOT NULL AUTO_INCREMENT,
  `precio` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,15.50),(2,18.00),(3,12.75),(4,20.00),(5,25.00),(6,17.25),(7,14.50),(8,19.00),(9,16.00),(10,22.50),(11,21.75),(12,18.50),(13,23.00),(14,12.00);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_plato`
--

DROP TABLE IF EXISTS `menu_plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_plato` (
  `id_menu` int NOT NULL DEFAULT '0',
  `id_plato` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_menu`,`id_plato`),
  KEY `id_plato` (`id_plato`),
  CONSTRAINT `menu_plato_ibfk_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`),
  CONSTRAINT `menu_plato_ibfk_2` FOREIGN KEY (`id_plato`) REFERENCES `plato` (`id_plato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_plato`
--

LOCK TABLES `menu_plato` WRITE;
/*!40000 ALTER TABLE `menu_plato` DISABLE KEYS */;
INSERT INTO `menu_plato` VALUES (1,1),(5,1),(9,1),(13,1),(2,2),(6,2),(10,2),(14,2),(1,3),(3,3),(6,3),(11,3),(3,4),(7,4),(12,4),(4,5),(7,5),(12,5),(2,6),(5,6),(8,6),(13,6),(4,7),(8,7),(14,7),(9,8),(3,9),(8,9),(10,9),(4,10),(9,10),(11,10),(1,11),(7,11),(10,11),(12,11),(2,12),(6,12),(11,12),(13,12),(5,13),(14,13);
/*!40000 ALTER TABLE `menu_plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `id_plato` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `id_ingrediente_principal` int DEFAULT NULL,
  PRIMARY KEY (`id_plato`),
  KEY `id_ingrediente_principal` (`id_ingrediente_principal`),
  CONSTRAINT `plato_ibfk_1` FOREIGN KEY (`id_ingrediente_principal`) REFERENCES `ingrediente` (`id_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (1,'Pollo al horno','Carne',1),(2,'Merluza a la plancha','Pescado',2),(3,'Tortilla de patatas','Huevos',3),(4,'Crema de leche','Postre',4),(5,'Pizza de queso','Carne',5),(6,'Ensalada de tomate','Verdura',6),(7,'Sopa de cebolla','Verdura',7),(8,'Ajoarriero','Pescado',8),(9,'Patatas fritas','Guarnición',9),(10,'Pan casero','Pan',10),(11,'Bizcocho','Postre',11),(12,'Brownie','Postre',12),(13,'Mantequilla casera','Guarnición',13),(14,'Perejil fresco','Guarnición',14),(15,'Huevos Rellenos','Huevos',3),(16,'Huevos Rellenos','Huevos',3),(17,'Huevos Rellenos','Huevos',3);
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta` (
  `id_receta` int NOT NULL AUTO_INCREMENT,
  `id_plato` int NOT NULL,
  `tiempo_total` int DEFAULT NULL,
  PRIMARY KEY (`id_receta`),
  UNIQUE KEY `id_plato` (`id_plato`),
  CONSTRAINT `receta_ibfk_1` FOREIGN KEY (`id_plato`) REFERENCES `plato` (`id_plato`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,1,90),(2,2,30),(3,3,25),(4,4,15),(5,5,40),(6,6,10),(7,7,35),(8,8,50),(9,9,20),(10,10,120),(11,11,45),(12,12,35),(13,13,15),(14,14,5);
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_utensilio`
--

DROP TABLE IF EXISTS `receta_utensilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta_utensilio` (
  `id_receta` int NOT NULL DEFAULT '0',
  `id_utensilio` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_receta`,`id_utensilio`),
  KEY `id_utensilio` (`id_utensilio`),
  CONSTRAINT `receta_utensilio_ibfk_1` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id_receta`),
  CONSTRAINT `receta_utensilio_ibfk_2` FOREIGN KEY (`id_utensilio`) REFERENCES `utensilio` (`id_utensilio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_utensilio`
--

LOCK TABLES `receta_utensilio` WRITE;
/*!40000 ALTER TABLE `receta_utensilio` DISABLE KEYS */;
INSERT INTO `receta_utensilio` VALUES (1,1),(5,1),(10,1),(2,2),(3,2),(9,2),(7,3),(8,3),(13,3),(4,4),(11,4),(12,4),(1,5),(2,5),(3,5),(6,5),(7,5),(8,5),(14,5),(6,6),(14,6),(9,8),(5,10),(4,11),(10,11),(11,11),(12,11),(13,12);
/*!40000 ALTER TABLE `receta_utensilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utensilio`
--

DROP TABLE IF EXISTS `utensilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utensilio` (
  `id_utensilio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_utensilio`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utensilio`
--

LOCK TABLES `utensilio` WRITE;
/*!40000 ALTER TABLE `utensilio` DISABLE KEYS */;
INSERT INTO `utensilio` VALUES (1,'Horno'),(2,'Sartén'),(3,'Cazuela'),(4,'Batidora'),(5,'Cuchillo'),(6,'Tabla de cortar'),(7,'Cucharón'),(8,'Espátula'),(9,'Tenedor'),(10,'Batidor de mano'),(11,'Molde de horno'),(12,'Colador'),(13,'Rallador'),(14,'Cacerola');
/*!40000 ALTER TABLE `utensilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cocina'
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