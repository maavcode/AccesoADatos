CREATE DATABASE  IF NOT EXISTS `demospringboot` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demospringboot`;
-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: demospringboot
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nif` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `claveseguridad` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'11111111A','Filemón','Pí','1234','filemon.pi@tia.es'),(2,'22222222B','Mortadelo','Ibáñez','1234','mortadelo.ibanez@tia.es'),(3,'33333333C','Vicente','Mondragón','1234','vicente.mondragon@tia.es'),(4,'44444444D','Ayrton','Senna','1234','ayrton.senna@f1.es'),(5,'B1111111A','Ibertrola','-','1234','-'),(6,'B2222222B','Gas Natural','-','1234','-'),(7,'B3333333C','Telefónica','-','1234','-'),(8,'B4444444D','Aguas de Valencia','-','1234','-'),(9,'B5555555E','Audi','-','1234','-'),(10,'B6666666F','BMW','-','1234','-'),(11,'B7777777G','PayPal','-','1234','-'),(12,'B8888888H','Ayuntamiento de Valencia','-','1234','-');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientesdirecciones`
--

DROP TABLE IF EXISTS `clientesdirecciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientesdirecciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `iddireccion` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fg-cliente_idx` (`idcliente`),
  KEY `fg-direccion_idx` (`iddireccion`),
  CONSTRAINT `fg-cliente` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fg-direccion` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientesdirecciones`
--

LOCK TABLES `clientesdirecciones` WRITE;
/*!40000 ALTER TABLE `clientesdirecciones` DISABLE KEYS */;
INSERT INTO `clientesdirecciones` VALUES (7,4,6),(8,5,7),(9,6,8),(10,6,3),(11,7,8),(12,8,9),(13,9,10),(14,10,11),(15,6,6),(36,1,2),(37,1,3),(42,2,2),(43,2,4),(45,3,5);
/*!40000 ALTER TABLE `clientesdirecciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `banco` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `sucursal` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `dc` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  `numerocuenta` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `saldoactual` float NOT NULL,
  `idcliente` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fg_cuentas_clientes_idx` (`idcliente`),
  CONSTRAINT `fg_cuentas_clientes` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'1001','1001','11','1000000001',1500,1),(2,'1001','1001','11','1000000003',-1200,1),(3,'1001','1001','11','1000000002',3500,1),(4,'1001','1001','11','1000000004',15340,2),(5,'1001','1001','11','1000000005',23729.2,1),(6,'1001','1001','11','1000000006',6500,1),(7,'1001','1001','11','1000000007',9500,2),(8,'1001','1001','11','1000000008',7500,3),(9,'1001','1001','11','1000000009',24650,1),(10,'1001','1001','11','1000000010',-3500,3),(11,'1001','2001','22','2000000001',7530540,5),(12,'1001','2001','22','2000000002',15890300,6),(13,'1001','2001','22','2000000003',19396400,7),(14,'1001','2001','22','2000000004',1250350,8),(15,'1001','2001','22','2000000005',24387300,9),(16,'1001','2001','22','2000000006',15904400,10),(19,'1001','2001','22','2000000007',156398000,10),(20,'1001','2001','22','2000000008',2389460,11);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `pais` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `cp` varchar(5) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (2,'calle buñol, 3','España','46183'),(3,'calle diputat isidre escandell, 2','España','46026'),(4,'calle bairen, 1','España','46702'),(5,'calle de la creu, 2','España','46701'),(6,'calle concepcion arenal, 35','España','46210'),(7,'25 Rue des Pyramides','Francia','75001'),(8,'22 Avenue Marceau','Francia','75008'),(9,'4 rue de la Montagne Sainte-Geneviève','Francia','75005'),(10,'78 rue Bonaparte','Francia','75006'),(11,'Via Santo Spirito 11','Italia','50122');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomendaciones`
--

DROP TABLE IF EXISTS `recomendaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recomendaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `observaciones` varchar(500) COLLATE latin1_spanish_ci NOT NULL,
  `idcliente` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_recomendaciones1` (`idcliente`),
  UNIQUE KEY `UK_sblcnbtsi1fgj6ksbok1nt6lv` (`idcliente`),
  KEY `fk_cliente_recomendacion_idx` (`idcliente`),
  CONSTRAINT `fk_cliente_recomendacion` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendaciones`
--

LOCK TABLES `recomendaciones` WRITE;
/*!40000 ALTER TABLE `recomendaciones` DISABLE KEYS */;
INSERT INTO `recomendaciones` VALUES (1,'Nada que observar',1),(2,'Sin comentarios',2),(3,'Realiza muchos pedidos',3),(4,'No realiza pedidos.',4),(5,'Solo dado de alta.',5),(6,'Empresa',6),(7,'Empresa',7),(8,'Empresa de Valencia',8),(9,'Empresa de automoción',9),(10,'Empresa de automoción',10),(11,'Medio de pago',11),(12,'Ayuntamiento',12);
/*!40000 ALTER TABLE `recomendaciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-27 15:23:38
