CREATE DATABASE  IF NOT EXISTS `tienda` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tienda`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tienda
-- ------------------------------------------------------
-- Server version	5.6.28

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `nombreUsu` varchar(20) NOT NULL,
  `password` varchar(300) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `telefono` int(20) DEFAULT NULL,
  PRIMARY KEY (`nombreUsu`),
  UNIQUE KEY `nombreUsu_UNIQUE` (`nombreUsu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('aa','e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855','fgg@hhc','aa','bb','78925789r','',0),('ad','0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c','asd@df','aasd','asdas','asd','',0),('ana','2ac9a6746aca543af8dff39894cfe8173afba21eb01c6fae33d52947222855ef','gonzalezsaioa@gmil.com','Ana','Gonzalez Gonzalez','78925789r','',0),('anem','0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c','anem@mail.com','Ane','Urbina Mujika','72938749k','C/Licenciado 3 2 izq 48010 Bilbao Bizkaia',678912345),('inap','0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c','inapi@mail.com','Iñaki','Lopez Garay','73943029G','C/Areilza 2 9 izq 48010 Bilbao Bizkaia	',683948576),('pepe','5feceb66ffc86f38d952786c6d696c79c2dbc239dd4e91b46729d73a27fb57e9','pepeg@mail.com','Pepe','Gonzalez Perez','37849586j','C/Hort 45, 4º Izq 28099 Madrid Madrid',654345432),('saioa','13715f6c8b48ed1b00f509ca29bc826bd04fd6f1ce8d8ebe27fb286312ce3ba1','gonzalezsaioa@gmail.com','Saioa','Gonzalez Gonzalez','78925789r','',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `cliente` varchar(20) NOT NULL,
  `producto` varchar(10) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idpedido`,`producto`,`cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (11,3,'anem','cojinFrida',36),(12,3,'anem','butCoconut',6901.5),(13,4,'anem','relojVitra',1500),(14,1,'anem','loungEames',8653),(15,3,'anem','lampMaurer',960),(16,3,'anem','cojinFrida',36),(17,3,'anem','butCoconut',6901.5),(18,4,'anem','relojVitra',1500),(19,1,'anem','loungEames',8653),(20,3,'anem','lampMaurer',960),(21,3,'anem','cojinFrida',36),(22,3,'anem','butCoconut',6901.5),(23,4,'anem','relojVitra',1500),(24,1,'anem','loungEames',8653),(25,3,'anem','lampMaurer',960),(26,3,'anem','cojinFrida',36),(27,3,'anem','butCoconut',6901.5),(28,4,'anem','relojVitra',1500),(29,1,'anem','loungEames',8653),(30,3,'anem','lampMaurer',960),(31,4,'inap','relojVitra',1500),(32,1,'inap','mesaTulip',3350),(33,1,'ana','lampMaurer',320),(34,1,'ana','wiggleS',632.7);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` double NOT NULL,
  `imagen` varchar(30) NOT NULL,
  `precioAnterior` double NOT NULL,
  PRIMARY KEY (`idproducto`),
  UNIQUE KEY `idproducto_UNIQUE` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('butCoconut','Butaca Coconut Chair','Butaca diseñada por George Nelson,1955.',2300.5,'coconutChair.jpg',2554),('cojinEinst','Cojín Perro Einstein','Funda de cojín Perro Einstein 45x45.',12,'cojinEinstein.jpg',14.95),('cojinFrida','Cojín perro Frida Khalo','Funda de cojín Frida Khalo, 45x45.',12,'cojinFrida.jpg',14.95),('eamesBird','Figura Eames House Bird','Figura diseñada por Eames, 1960.',150,'eamesBird.jpg',172),('EamesPC','silla Eames Plastic Chair','Silla diseñada por Charles & Ray Eames, 1950.',320.5,'plasticChair.jpg',379),('lampMaurer','Lampara con alas Lucellino','Lampara diseñada por Ingo Maurer, 1992.',320,'lamparaMaurer.jpg',345.15),('loungEames','Lounge Chair y Ottoman','Butaca diseñada por Eames, 1956.',8653,'loungeEames.jpg',8900.95),('mesaTulip','Mesa Tulip Redonda','Mesa diseñada por Eero Saarinen, 1958.',3350,'mesaTulip.jpg',3533.2),('mesSeletti','Mesa o Estanteria A La Carte','Mesa diseñada por BBMDS-Seletti, 2011',190,'aLaCarte.jpg',198),('PantonC','silla Panton Chair','Silla diseñada por Verner Panton, 1960.',997.8,'pantonChair.jpg',1161),('relojVitra','Reloj Wall Clocks','Reloj diseñado por Gearge Nelson, 1948.',375,'BallClock.jpg',379.98),('wiggleS','Taburete o mesita Wiggle Stool','Taburete diseñado por Frank Ghery,1972.',632.7,'wiggleStool.jpg',729);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(10) DEFAULT NULL,
  `nombreUsu` varchar(20) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`idventa`,`nombreUsu`),
  UNIQUE KEY `idcarrito_UNIQUE` (`idventa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (10,'en proceso','anem','01-08-2016'),(11,'en proceso','inap','19-08-2016'),(12,'en proceso','ana','19-08-2016');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventaPedido`
--

DROP TABLE IF EXISTS `ventaPedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventaPedido` (
  `idventa` int(11) NOT NULL,
  `idpedido` int(11) NOT NULL,
  PRIMARY KEY (`idventa`,`idpedido`),
  KEY `fk5_idx` (`idpedido`),
  CONSTRAINT `fk5` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`),
  CONSTRAINT `fk6` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventaPedido`
--

LOCK TABLES `ventaPedido` WRITE;
/*!40000 ALTER TABLE `ventaPedido` DISABLE KEYS */;
INSERT INTO `ventaPedido` VALUES (10,11),(10,12),(10,13),(10,14),(10,15),(10,16),(10,17),(10,18),(10,19),(10,20),(11,21),(11,22),(11,23),(11,24),(11,25),(11,26),(11,27),(11,28),(11,29),(11,30),(11,31),(11,32),(12,33),(12,34);
/*!40000 ALTER TABLE `ventaPedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-20 14:56:42
