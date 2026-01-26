DROP DATABASE IF EXISTS `ciclismo`;
CREATE DATABASE  IF NOT EXISTS `ciclismo` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ciclismo`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: ciclismo
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
-- Table structure for table `ciclista`
--

DROP TABLE IF EXISTS `ciclista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclista` (
  `dorsal` smallint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `nomeq` varchar(25) NOT NULL,
  `nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`dorsal`),
  KEY `equipociclista` (`nomeq`),
  KEY `FK_ciclistaequipo_idx` (`nomeq`),
  CONSTRAINT `FK_ciclistaequipo` FOREIGN KEY (`nomeq`) REFERENCES `equipo` (`nomeq`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclista`
--

LOCK TABLES `ciclista` WRITE;
/*!40000 ALTER TABLE `ciclista` DISABLE KEYS */;
INSERT INTO `ciclista` VALUES (1,'Miguel Induráin','Banesto','1982-11-13'),(2,'Pedro Delgado','Banesto','1979-11-13'),(3,'Alex Zulle','ONCE','1987-11-13'),(4,'Tony Rominger','Mapei-Clas','1984-11-13'),(5,'Gert-Jan Theunisse','PDM','1982-11-13'),(6,'Adriano Baffi','Mercatone Uno','1981-11-13'),(7,'Massimiliano Lelli','Mercatone Uno','1984-11-13'),(8,'Jean Van Poppel','Lotus Festina','1981-11-13'),(9,'Massimo Podenzana','Navigare','1980-11-13'),(10,'Mario Cipollini','Mercatone Uno','1986-11-13'),(11,'Flavio Giupponi','Bresciali-Refin','1983-11-13'),(12,'Alessio Di Basco','Amore Vita','1983-11-13'),(13,'Lale Cubino','Seguros Amaya','1986-11-13'),(14,'Roberto Pagnin','Navigare','1981-11-13'),(15,'Jesper Skibby','TVM','1983-11-13'),(16,'Dimitri Konishev','Jolly Club','1985-11-13'),(17,'Bruno Leali','Bresciali-Refin','1977-11-13'),(18,'Robert Millar','TVM','1977-11-13'),(19,'Julian Gorospe','Banesto','1980-11-13'),(20,'Alfonso Gutiérrez','Artiach','1985-11-13'),(21,'Erwin Nijboer','Artiach','1983-11-13'),(22,'Giorgio Furlan','Gewiss','1982-11-13'),(23,'Lance Armstrong','Motorola','1987-11-13'),(24,'Claudio Chiappucci','Carrera','1985-11-13'),(25,'Gianni Bugno','Gatorade','1982-11-13'),(26,'Mikel Zarrabeitia','Banesto','1987-11-13'),(27,'Laurent Jalabert','ONCE','1986-11-13'),(28,'Jesus Montoya','Banesto','1981-11-13'),(29,'Angel Edo','Kelme','1986-11-13'),(30,'Melchor Mauri','Banesto','1986-11-13'),(31,'Vicente Aparicio','Banesto','1984-11-13'),(32,'Laurent Dufaux','ONCE','1986-11-13'),(33,'Stefano della Santa','Mapei-Clas','1985-11-13'),(34,'Angel Yesid Camargo','Kelme','1984-11-13'),(35,'Erik Dekker','Wordperfect','1986-11-13'),(36,'Gian Matteo Fagnini','Mercatone Uno','1982-11-13'),(37,'Scott Sunderland','TVM','1985-11-13'),(38,'Javier Palacin','Euskadi','1989-11-13'),(39,'Rudy Verdonck','Lotus Festina','1984-11-13'),(40,'Viatceslav Ekimov','Wordperfect','1982-11-13'),(41,'Rolf Aldag','Telecom','1989-11-13'),(42,'Davide Cassani','TVM','1985-11-13'),(43,'Francesco Casagrande','Mercatone Uno','1986-11-13'),(44,'Luca Gelfi','Gatorade','1987-11-13'),(45,'Alberto Elli','Artiach','1988-11-13'),(46,'Agustin Sagasti','Euskadi','1990-11-13'),(47,'Laurent Pillon','Gewiss','1982-11-13'),(48,'Marco Saligari','Gewiss','1985-11-13'),(49,'Eugeni Berzin','Gewiss','1991-11-13'),(50,'Fernando Escartin','Mapei-Clas','1987-11-13'),(51,'Udo Bolts','Telecom','1984-11-13'),(52,'Vladislav Bobrik','Gewiss','1988-11-13'),(53,'Michele Bartoli','Mercatone Uno','1986-11-13'),(54,'Steffen Wesemann','Telecom','1984-11-13'),(55,'Nicola Minali','Gewiss','1986-11-13'),(56,'Andrew Hampsten','Banesto','1985-11-13'),(57,'Stefano Zanini','Navigare','1986-11-13'),(58,'Gerd Audehm','Telecom','1980-11-13'),(59,'Mariano Picolli','Mercatone Uno','1986-11-13'),(60,'Giovanni Lombardi','Bresciali-Refin','1986-11-13'),(61,'Walte Castignola','Navigare','1988-11-13'),(62,'Raul Alcala','Motorola','1984-11-13'),(63,'Alvaro Mejia','Motorola','1982-11-13'),(64,'Giuseppe Petito','Mercatone Uno','1986-11-13'),(65,'Pascal Lino','Amore Vita','1985-11-13'),(66,'Enrico Zaina','Gewiss','1990-11-13'),(67,'Armand de las Cuevas','Castorama','1986-11-13'),(68,'Angel Citracca','Navigare','1986-11-13'),(69,'Eddy Seigneur','Castorama','1987-11-13'),(70,'Sandro Heulot','Banesto','1985-11-13'),(71,'Prudencio Induráin','Banesto','1987-11-13'),(72,'Stefano Colage','Bresciali-Refin','1986-11-13'),(73,'Laurent Fignon','Gatorade','1979-11-13'),(74,'Claudio Chioccioli','Amore Vita','1978-11-13'),(75,'Juan Romero','Seguros Amaya','1982-11-13'),(76,'Marco Giovannetti','Gatorade','1980-11-13'),(77,'Javier Mauleon','Mapei-Clas','1981-11-13'),(78,'Antonio Esparza','Kelme','1979-11-13'),(79,'Johan Bruyneel','ONCE','1981-11-13'),(80,'Federico Echave','Mapei-Clas','1977-11-13'),(81,'Piotr Ugrumov','Gewiss','1981-11-13'),(82,'Edgar Corredor','Kelme','1984-11-13'),(83,'Hernan Buenahora','Kelme','1982-11-13'),(84,'Jon Unzaga','Mapei-Clas','1983-11-13'),(85,'Dimitri Abdoujaparov','Carrera','1984-11-13'),(86,'Juan Martinez Oliver','Kelme','1982-11-13'),(87,'Fernando Mota','Artiach','1982-11-13'),(88,'Angel Camarillo','Mapei-Clas','1986-11-13'),(89,'Stefan Roche','Carrera','1978-11-13'),(90,'Ivan Ivanov','Artiach','1987-11-13'),(91,'Nestor Mora','Kelme','1986-11-13'),(92,'Federico Garcia','Artiach','1987-11-13'),(93,'Bo Hamburger','TVM','1985-11-13'),(94,'Marino Alonso','Banesto','1984-11-13'),(95,'Manuel Guijarro','Lotus Festina','1983-11-13'),(96,'Tom Cordes','Wordperfect','1985-11-13'),(97,'Casimiro Moreda','ONCE','1986-11-13'),(98,'Eleuterio Anguita','Artiach','1989-11-13'),(99,'Per Pedersen','Seguros Amaya','1985-11-13'),(100,'William Palacios','Jolly Club','1984-11-13');
/*!40000 ALTER TABLE `ciclista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coche`
--

DROP TABLE IF EXISTS `coche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coche` (
  `cod` int NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) DEFAULT NULL,
  `nomequipo` varchar(25) DEFAULT NULL,
  `km` int DEFAULT NULL,
  `patrocinador` varchar(10) NOT NULL,
  `marca` varchar(10) DEFAULT NULL,
  `funcion` varchar(10) DEFAULT NULL,
  `tipo` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`cod`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `nomequipo` (`nomequipo`),
  CONSTRAINT `coche_ibfk_1` FOREIGN KEY (`nomequipo`) REFERENCES `equipo` (`nomeq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coche`
--

LOCK TABLES `coche` WRITE;
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` VALUES (1,'2233AAA','Telecom',10000,'Matutano','Skoda','Apoyo',NULL),(2,'1122BBB','Once',NULL,'Maphre','Renault','Apoyo',NULL);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `nomeq` varchar(25) NOT NULL,
  `director` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`nomeq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('Amore Vita','Ricardo Padacci'),('Artiach','José Peréz'),('Banesto','Miguel Echevarria'),('Bresciali-Refin','Pietro Armani'),('Carrera','Luigi Petroni'),('Castorama','Jean Philip'),('Euskadi','Pedro Txucaru'),('Gatorade','Gian Luca Pacceli'),('Gewiss','Moreno Argentin'),('Jolly Club','Johan Richard'),('Kelme','Álvaro Pino'),('Lotus Festina','Suarez Cuevas'),('Mapei-Clas','Juan Fernandez'),('Mercatone Uno','Ettore Romano'),('Motorola','John Fidwell'),('Navigare','Lonrenzo Sciacci'),('ONCE','Manuel Sainz'),('PDM','Piet Van Der Kruis'),('Seguros Amaya','Minguez'),('Telecom','Morgan Reikcard'),('TVM','Steveens Henk'),('Wordperfect','Bill Gates');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etapa`
--

DROP TABLE IF EXISTS `etapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etapa` (
  `netapa` smallint NOT NULL,
  `km` smallint NOT NULL,
  `salida` varchar(35) NOT NULL,
  `llegada` varchar(35) NOT NULL,
  `dorsal` smallint DEFAULT NULL,
  PRIMARY KEY (`netapa`),
  KEY `ciclistaetapa` (`dorsal`),
  KEY `fk_etapaciclista_idx` (`dorsal`),
  CONSTRAINT `fk_etapaciclista` FOREIGN KEY (`dorsal`) REFERENCES `ciclista` (`dorsal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa`
--

LOCK TABLES `etapa` WRITE;
/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
INSERT INTO `etapa` VALUES (1,9,'Valladolid','Valladolid',1),(2,180,'Valladolid','Salamanca',36),(3,240,'Salamanca','Caceres',12),(4,230,'Almendralejo','Córdoba',83),(5,170,'Córdoba','Granada',27),(6,150,'Granada','Sierra Nevada',52),(7,250,'Baza','Alicante',22),(8,40,'Benidorm','Benidorm',1),(9,150,'Benidorm','Valencia',35),(10,200,'Igualada','Andorra',2),(11,195,'Andorra','Estación de Cerler',65),(12,220,'Benasque','Zaragoza',12),(13,200,'Zaragoza','Pamplona',93),(14,172,'Pamplona','Alto de la Cruz de la Demanda',86),(15,207,'Santo Domingo de la Calzada','Santander',10),(16,160,'Santander','Lagos de Covadonga',5),(17,140,'Cangas de Onis','Alto del Naranco',4),(18,195,'Ávila','Ávila',8),(19,190,'Ávila','Destilerias Dyc',2),(20,52,'Segovia','Destilerias Dyc',2),(21,170,'Destilerias Dyc','Madrid',27);
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gana`
--

DROP TABLE IF EXISTS `gana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gana` (
  `dorsal` smallint NOT NULL,
  `premio` int NOT NULL,
  PRIMARY KEY (`dorsal`,`premio`),
  KEY `fk_dorsal_idx` (`premio`),
  CONSTRAINT `fk_ciclismo` FOREIGN KEY (`dorsal`) REFERENCES `ciclista` (`dorsal`),
  CONSTRAINT `fk_premio` FOREIGN KEY (`premio`) REFERENCES `premios` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gana`
--

LOCK TABLES `gana` WRITE;
/*!40000 ALTER TABLE `gana` DISABLE KEYS */;
INSERT INTO `gana` VALUES (1,1),(1,2),(1,3),(2,3);
/*!40000 ALTER TABLE `gana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llevar`
--

DROP TABLE IF EXISTS `llevar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `llevar` (
  `dorsal` smallint NOT NULL,
  `netapa` smallint NOT NULL,
  `codigo` varchar(3) NOT NULL,
  PRIMARY KEY (`netapa`,`codigo`),
  KEY `ciclistallevar` (`dorsal`),
  KEY `etapallevar` (`netapa`),
  KEY `maillotllevar` (`codigo`),
  KEY `fk_llevar_ciclista_idx` (`dorsal`),
  KEY `fk_llevar_maillot_idx` (`codigo`),
  KEY `fk_llevar_etapa_idx` (`netapa`),
  CONSTRAINT `fk_llevar_ciclista` FOREIGN KEY (`dorsal`) REFERENCES `ciclista` (`dorsal`),
  CONSTRAINT `fk_llevar_etapa` FOREIGN KEY (`netapa`) REFERENCES `etapa` (`netapa`),
  CONSTRAINT `fk_llevar_maillot` FOREIGN KEY (`codigo`) REFERENCES `maillot` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llevar`
--

LOCK TABLES `llevar` WRITE;
/*!40000 ALTER TABLE `llevar` DISABLE KEYS */;
INSERT INTO `llevar` VALUES (1,1,'MGE'),(1,1,'MMO'),(1,1,'MMV'),(1,1,'MRE'),(1,1,'MSE'),(1,2,'MGE'),(1,3,'MGE'),(1,4,'MGE'),(1,16,'MGE'),(1,17,'MGE'),(1,18,'MGE'),(1,19,'MGE'),(1,20,'MGE'),(1,21,'MGE'),(2,5,'MGE'),(2,6,'MGE'),(2,7,'MGE'),(2,21,'MMO'),(3,11,'MGE'),(3,12,'MGE'),(4,8,'MGE'),(8,2,'MSE'),(8,4,'MSE'),(10,18,'MSE'),(12,3,'MSE'),(12,5,'MSE'),(12,6,'MSE'),(16,2,'MMV'),(16,3,'MMV'),(16,5,'MMV'),(16,6,'MMV'),(17,4,'MMV'),(20,6,'MRE'),(20,7,'MRE'),(20,8,'MRE'),(20,9,'MRE'),(20,10,'MRE'),(20,11,'MRE'),(20,12,'MRE'),(20,13,'MRE'),(20,14,'MRE'),(20,15,'MRE'),(20,16,'MRE'),(20,17,'MRE'),(20,18,'MMV'),(20,19,'MRE'),(20,20,'MRE'),(20,21,'MRE'),(22,14,'MSE'),(22,15,'MSE'),(22,16,'MSE'),(22,17,'MSE'),(22,19,'MSE'),(22,20,'MSE'),(22,21,'MSE'),(24,4,'MMO'),(25,2,'MMO'),(25,3,'MMO'),(25,5,'MMO'),(26,6,'MMO'),(26,7,'MMO'),(26,8,'MMO'),(26,9,'MGE'),(26,9,'MMO'),(26,10,'MGE'),(26,18,'MMO'),(27,2,'MRE'),(27,3,'MRE'),(27,4,'MRE'),(27,5,'MRE'),(27,18,'MRE'),(28,14,'MMO'),(28,15,'MMO'),(28,16,'MMO'),(28,17,'MMO'),(28,19,'MMO'),(28,20,'MMO'),(30,10,'MMO'),(30,11,'MMO'),(30,12,'MMO'),(30,13,'MGE'),(30,13,'MMO'),(30,14,'MGE'),(30,15,'MGE'),(33,7,'MMV'),(33,8,'MMV'),(42,14,'MMV'),(42,15,'MMV'),(42,16,'MMV'),(42,17,'MMV'),(42,19,'MMV'),(42,20,'MMV'),(42,21,'MMV'),(48,9,'MMV'),(48,10,'MMV'),(48,11,'MMV'),(48,12,'MMV'),(48,13,'MMV'),(67,1,'MMS'),(67,3,'MMS'),(69,2,'MMS'),(69,4,'MMS'),(99,7,'MSE'),(99,8,'MSE'),(99,9,'MSE'),(99,10,'MSE'),(99,11,'MSE'),(99,12,'MSE'),(99,13,'MSE');
/*!40000 ALTER TABLE `llevar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maillot`
--

DROP TABLE IF EXISTS `maillot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maillot` (
  `codigo` varchar(3) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `color` varchar(20) NOT NULL,
  `premio` int NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maillot`
--

LOCK TABLES `maillot` WRITE;
/*!40000 ALTER TABLE `maillot` DISABLE KEYS */;
INSERT INTO `maillot` VALUES ('MGE','General','Amarillo',8000000),('MMO','Montaña','Blanco y Rojo',2000000),('MMS','Mas Sufrido','Estrellitas moradas',2000000),('MMV','Metas volantes','Rojo',2000000),('MRE','Regularidad','Verde',2000000),('MSE','Sprints especiales','Rosa',2000000);
/*!40000 ALTER TABLE `maillot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `premios`
--

DROP TABLE IF EXISTS `premios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `premios` (
  `codigo` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `premios`
--

LOCK TABLES `premios` WRITE;
/*!40000 ALTER TABLE `premios` DISABLE KEYS */;
INSERT INTO `premios` VALUES (1,'meta_volante_primero',1000),(2,'meta_volante_segundo',1500),(3,'gana_etapa_primero',3000);
/*!40000 ALTER TABLE `premios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puerto`
--

DROP TABLE IF EXISTS `puerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puerto` (
  `nompuerto` varchar(35) NOT NULL,
  `altura` smallint NOT NULL,
  `categoria` varchar(1) NOT NULL,
  `pendiente` double(15,5) DEFAULT NULL,
  `netapa` smallint NOT NULL,
  `dorsal` smallint DEFAULT NULL,
  PRIMARY KEY (`nompuerto`),
  KEY `ciclistapuerto` (`dorsal`),
  KEY `etapapuerto` (`netapa`),
  KEY `fk_puertociclista_idx` (`dorsal`),
  KEY `fk_puertoetapa_idx` (`netapa`),
  CONSTRAINT `fk_puertociclista` FOREIGN KEY (`dorsal`) REFERENCES `ciclista` (`dorsal`),
  CONSTRAINT `fk_puertoetapa` FOREIGN KEY (`netapa`) REFERENCES `etapa` (`netapa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puerto`
--

LOCK TABLES `puerto` WRITE;
/*!40000 ALTER TABLE `puerto` DISABLE KEYS */;
INSERT INTO `puerto` VALUES ('Alto del Naranco',565,'1',6.90000,10,30),('Angliru',1500,'E',15.00000,7,2),('Arcalis',2230,'E',6.50000,10,4),('Cerler-Circo de Ampriu',2500,'E',5.87000,11,9),('Coll de la Comella',1362,'1',8.07000,10,2),('Coll de Ordino',1980,'E',5.30000,10,7),('Cruz de la Demanda',1850,'E',7.00000,11,20),('La Pandereta',1456,'E',12.00000,8,4),('Lagos de Covadonga',1134,'E',6.86000,16,42),('Navacerrada',1860,'1',7.50000,19,2),('Penyagolosa',1823,'E',10.00000,9,NULL),('Puerto de Alisas',672,'1',5.80000,15,1),('Puerto de la Morcuera',1760,'2',6.50000,19,2),('Puerto de Mijares',1525,'1',4.90000,18,24),('Puerto de Navalmoral',1521,'2',4.30000,18,2),('Puerto de Pedro Bernardo',1250,'1',4.20000,18,25),('Sierra Nevada',2500,'E',6.00000,2,26),('Tourmalet',2100,'E',10.00000,3,4);
/*!40000 ALTER TABLE `puerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representante`
--

DROP TABLE IF EXISTS `representante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `representante` (
  `id` int NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `nom_eq` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom_eq_UNIQUE` (`nom_eq`),
  CONSTRAINT `fk_equipo` FOREIGN KEY (`nom_eq`) REFERENCES `equipo` (`nomeq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representante`
--

LOCK TABLES `representante` WRITE;
/*!40000 ALTER TABLE `representante` DISABLE KEYS */;
INSERT INTO `representante` VALUES (1,'Pepepe','ONCE');
/*!40000 ALTER TABLE `representante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ciclismo'
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