-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: spartandb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `House_No` varchar(100) DEFAULT NULL,
  `City` varchar(100) DEFAULT NULL,
  `State` varchar(100) DEFAULT NULL,
  `Zip` int(11) DEFAULT NULL,
  `Apt_No` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'9539 University Terrace Drive','Charlotte','North Carolina',28262,'Apt. #L'),(10,'430 barton creek drive','charlotte','NC',28262,''),(11,'204 BartonCreek Dr,Apt H','Charlotte','NC',28262,''),(12,'9401 E','Charlotte','NC',28262,''),(13,'9401E','Charlotte','NC',28262,''),(17,'9401E','Charlotte','NC',28262,''),(18,'204 Bcreek Dr,','Charlotte','NC',28262,''),(19,'204','Charlotte','NC',23432,''),(20,'9401','charlorte','nc',28262,'');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `Major` varchar(100) NOT NULL,
  `PBL_Connection` varchar(100) NOT NULL,
  PRIMARY KEY (`admin_id`),
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'cs','SYR'),(2,'cs','SYR'),(3,'cs','SYR'),(4,'cs','SYR'),(5,'cs','SYR');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bundleorders`
--

DROP TABLE IF EXISTS `bundleorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bundleorders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bundle_id` varchar(200) DEFAULT NULL,
  `total_order` int(11) DEFAULT NULL,
  `shipping` int(11) DEFAULT NULL,
  `tax` int(11) DEFAULT NULL,
  `grand_total` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bundleorders`
--

LOCK TABLES `bundleorders` WRITE;
/*!40000 ALTER TABLE `bundleorders` DISABLE KEYS */;
INSERT INTO `bundleorders` VALUES (52,'qevbaugygm',200,0,10,210),(53,'swlefbiatq',20,10,1,31),(54,'ztrnt',20,10,1,31),(55,'uijysx',7,10,0,17),(56,'hmxfenmz',7,10,0,17),(57,'upoufhad',7,10,0,17),(58,'tmeviefn',7,10,0,17),(59,'ffzigftwfp',7,10,0,17),(60,'imwnkfw',9,10,0,19),(61,'ckmrn',10,10,1,21),(62,'tcrumfvhae',2,10,0,12),(63,'zgskjztim',19,10,1,30),(64,'rstg',19,10,1,30),(65,'bqbfd',19,10,1,30),(66,'ctz',19,10,1,30),(67,'dtuj',19,10,1,30),(68,'dzcdzxdqf',19,10,1,30),(69,'zza',19,10,1,30),(70,'sddxbx',5,10,0,15),(71,'gqls',7,10,0,17),(72,'rwvphazsue',209,0,10,219),(73,'abzjnljhk',9,10,0,19),(74,'weapdh',9,10,0,19);
/*!40000 ALTER TABLE `bundleorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) DEFAULT NULL,
  `itemname` varchar(200) DEFAULT NULL,
  `imageurl` varchar(200) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `itemprice` double DEFAULT NULL,
  PRIMARY KEY (`cartid`),
  KEY `itemid` (`itemid`),
  KEY `customerid` (`customerid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`itemid`) REFERENCES `items` (`itemid`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `Connection` varchar(100) NOT NULL,
  `NewsletterSubscription` tinyint(1) NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'SYR student',1),(7,'SYR student',1),(8,'SYR student',0),(9,'SYR student',1),(10,'Student',0),(11,'Student',0),(12,'Student',0),(13,'Student',0),(17,'Student',0),(18,'Student',1),(19,'Alumni',1),(20,'Student',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `itemprice` double DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `itembrand` varchar(100) DEFAULT NULL,
  `size` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `itemAge` varchar(200) DEFAULT NULL,
  `imageurl` varchar(200) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `quantity` varchar(100) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `requested_price` double DEFAULT NULL,
  `donorstatus` varchar(10) DEFAULT NULL,
  `isapproved` tinyint(1) DEFAULT NULL,
  `approved_by` varchar(100) DEFAULT NULL,
  `date_posted` varchar(100) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `issold` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (4,9,'Shirts','Men\'s Shirts','Great Quality','Arrow','Medium','Grey','2yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FArrow1.jpg?alt=media&token=94fda296-cc52-44cf-9c91-fd86bfb41b67','male','1',10,9,NULL,1,'','Fri, 9 Dec 2016 01:05:29',0,1),(5,20,'T Shirts','Men\'s Shirts','Good condition','Peter England','X-Small','Blue','2yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FPeter%20England2.jpg?alt=media&token=735a119b-d71d-401b-9107-64f100e15b8a','male','1',10,20,NULL,1,'','Fri, 9 Dec 2016 01:06:51',0,0),(6,7,'T Shirts','Men\'s Shirts','Old is Gold','Peter England','X-Small','Black','5yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FPeter%20England3.jpg?alt=media&token=96a159dd-d6fa-40f6-8c2e-4608645222a3','male','1',10,7,NULL,1,'','Fri, 9 Dec 2016 01:07:39',0,1),(7,5,'T Shirts','Men\'s Shirts','Hii','Wrangler','Medium','Light Purple','4yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FWrangler4.jpg?alt=media&token=eaee9ee9-0755-4e50-8c44-9e7d974153dc','male','2',10,5,NULL,1,'','Fri, 9 Dec 2016 01:08:35',0,1),(9,7,'T Shirts','Men\'s TShirt','hell','Arrow','XXX-Large','Purple','1','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FArrow5.jpg?alt=media&token=d8a651bb-5400-496d-bfd8-d8bc0746cc53','male','1',10,7,NULL,1,'','Fri, 9 Dec 2016 01:11:09',0,0),(14,9,'Tops','Women\'s Tops','Good','Bossini','X-Small','Maroon','3yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FBossini57.jpg?alt=media&token=beee89c6-daef-4080-af19-e9f990553e10','female','1',10,9,NULL,1,'','Fri, 9 Dec 2016 01:32:40',0,1),(15,9,'Tops','Women\'s Tops','Good','Nike','X-Small','Red','4yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FNike58.jpg?alt=media&token=bd2bcec6-b164-4a84-9f57-4604023fe73c','female','1',10,9,NULL,1,'','Fri, 9 Dec 2016 01:33:29',0,1),(16,2,'Tops','Women\'s Tops','Great','Superdry','Medium','Yellow','3yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FSuperdry59.jpg?alt=media&token=3034e118-bf9e-4e1f-9d55-c1cff4d7d01a','female','1',10,2,NULL,1,'','Fri, 9 Dec 2016 01:34:16',0,1),(17,10,'Tops','Women\'s Tops','Good','Vero Moda','Medium','Blue','3yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FVero-Moda60.jpg?alt=media&token=5dfca882-d681-46e0-af2d-8b033a8695e1','female','1',10,10,NULL,1,'','Fri, 9 Dec 2016 01:35:29',0,1),(18,19,'Trousers','Women\'s Trousers','Great','Lee','Large','Blue','19yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FLee61.jpg?alt=media&token=60a64b2e-d67f-4012-8e5e-7045598afc5f','female','1',10,19,NULL,1,'','Fri, 9 Dec 2016 01:36:43',0,1),(19,20,'Trousers','Women\'s Trousers','Great','Levi\'s','Medium','Blue','20','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FLevi-s62.jpg?alt=media&token=91ffa33e-207b-44e8-be88-aa5e34d53d61','female','1',10,20,NULL,1,'','Fri, 9 Dec 2016 01:37:37',0,0),(20,20,'Trousers','Women\'s Trousers','Not Bad','Pepe jeans','Large','Black','20','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FPepe-Jeans63.jpg?alt=media&token=161a4f2b-34c1-4fa5-9f3c-e118078db15a','female','2',10,20,NULL,1,'','Fri, 9 Dec 2016 01:38:24',0,0),(21,200,'Tops','Women\'s Thermals','Damn ','Park Avenue','Medium','Black','2yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FPark%20Avenue85.jpg?alt=media&token=992769b7-10e4-4616-81f8-1c8fbef3265b','female','1',10,200,NULL,1,'','Fri, 9 Dec 2016 02:19:13',0,1),(22,9,'Tops','Women\'s Thermals','Good condition','Park Avenue','Small','White','3yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FPark%20Avenue87.jpg?alt=media&token=a3555661-e943-44ae-82ec-2abe945a1f8c','female','1',10,9,NULL,1,'','Fri, 9 Dec 2016 03:30:37',0,0),(23,6,'Tops','Women\'s Thermals','Great condition','Park Avenue','Medium','White','3months','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FPark%20Avenue88.jpg?alt=media&token=10f713be-08d1-4ae2-a240-a844ed6fd030','female','1',10,6,NULL,1,'','Fri, 9 Dec 2016 03:31:32',0,0),(24,7,'Shirts','Women\'s Shirts','good','Old Navy','Medium','Black','4yrs','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FOld%20Navy77.jpg?alt=media&token=6703b313-0b0b-4606-82d4-ee26ee0a829c','female','1',10,7,NULL,1,'','Fri, 9 Dec 2016 03:32:17',0,0),(25,8,'T Shirts','SweatShirts','Sweat shirt in Good Condition ','Quiksilver','Medium','White','2 Months','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FQuiksilver10.jpg?alt=media&token=bb484dae-d875-4675-9ffa-c6bf52f16b44','male','1',11,8,'hide',0,'','Fri, 9 Dec 2016 08:47:00',0,0),(26,15,'Jackets','Jackets','Well maintained Jacket','Adidas','X-Large','Blue','1 Month','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FAdidas13.jpg?alt=media&token=1bf02c1a-68e8-463f-bd05-5300b4286c6c','male','1',11,15,NULL,0,'','Fri, 9 Dec 2016 08:48:46',0,0),(27,5,'T Shirts','Tshirt','good condition','wrangler','X-Small','blue','2 months','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2FNext14.jpg?alt=media&token=c8a12b95-bab0-41d4-8c07-afca01eb265a','male','1',11,5,'hide',1,'','Fri, 9 Dec 2016 10:42:58',0,0),(28,20,'T Shirts','Aeropostale','Well maintained','Aeropostale','Small','Blue','2 months','https://firebasestorage.googleapis.com/v0/b/dbcloset-53a0d.appspot.com/o/images%2Faeropostale.jpg?alt=media&token=18c577ac-8677-4e0a-a8fe-7bf2adc96898','male','2',11,20,'hide',0,'','Sun, 11 Dec 2016 13:43:19',0,0);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `Order_id` int(11) NOT NULL AUTO_INCREMENT,
  `bundle_id` varchar(200) DEFAULT NULL,
  `Customer_id` int(11) DEFAULT NULL,
  `Date_Ordered` varchar(200) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `Order_Status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (26,'qevbaugygm',11,'Fri, 9 Dec 2016 03:58:39',21,'Created'),(27,'swlefbiatq',11,'Fri, 9 Dec 2016 04:03:27',19,'Created'),(28,'uijysx',11,'Fri, 9 Dec 2016 04:21:07',6,'Created'),(29,'imwnkfw',8,'Fri, 9 Dec 2016 04:49:16',14,'Created'),(30,'ckmrn',8,'Fri, 9 Dec 2016 04:59:38',17,'Created'),(31,'tcrumfvhae',8,'Fri, 9 Dec 2016 05:03:06',16,'Created'),(32,'zgskjztim',11,'Fri, 9 Dec 2016 06:05:14',18,'Created'),(33,'sddxbx',11,'Fri, 9 Dec 2016 06:22:54',7,'Created'),(34,'gqls',11,'Fri, 9 Dec 2016 08:50:17',6,'Created'),(35,'rwvphazsue',11,'Fri, 9 Dec 2016 10:45:55',14,'Created'),(36,'rwvphazsue',11,'Fri, 9 Dec 2016 10:45:55',21,'Created'),(37,'abzjnljhk',11,'Sat, 10 Dec 2016 23:40:46',15,'Created'),(38,'weapdh',11,'Sun, 11 Dec 2016 13:42:10',4,'Created');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Phone_no` bigint(20) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Vyom Sharma',7042419179,'vyom','Sharma','Admin','vsharm11@gmail.com'),(2,'Avinash',7044990255,'avinash','avinash','Admin','schinta7@gmail.com'),(3,'Sharath',7406021187,'sharath','sharath','Admin','spareme2@gmail.com'),(4,'Soni',9805856510,'Soni','Soni','Admin','mamidisoni@gmail.com'),(5,'Sagar',9803183550,'sagar','sagar','Admin','kbukkapu@gmail.com'),(6,'Amruth',9803651518,'amruth','amruth','Admin','agandava@gmail.com'),(7,'Vasmsi',9807294929,'vamsi','vamsi','Customer','vkovuru@gmail.com'),(8,'Atul',7049549144,'atul','atul','Customer','abanwar@gmail.com'),(9,'Sanket',7049549420,'sanket','sanket','Customer','spatil@gmail.com'),(10,'vamsi krishna',9876543210,'vamsikvk','cc007','customer','vamsi2294@gmail.com'),(11,'Soni',9805856510,'mamidisoni','qwerty123','customer','mamidisoni@gmail.com'),(12,'Sai Avinash',7044990255,'saiavinash','krishnateja','customer','saiavinash.ch@gmail.com'),(13,'Manikanta',7047059844,'mani','123456','customer','mbhagava@gmail.com'),(14,'Manikanta',7047059844,'mani','123456','customer','mbhagava@gmail.com'),(15,'Manikanta',7047059844,'mani','123456','customer','mbhagava@gmail.com'),(16,'Manikanta',7047059844,'mani','123456','customer','mbhagava@gmail.com'),(17,'Shiv',7047057047,'shiva','123456','customer','vavula1@gmail.com'),(18,'sachin',9805856510,'sachin','qwerty123','customer','wshane796@gmail.com'),(19,'Dhoni',9985840601,'Dhoni','qwerty123','customer','dhoni@gmail.com'),(20,'saiavinash.ch',1234567890,'saiavinash.ch','1234567','customer','saiavinash2431@gmail.com');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxdocument`
--

DROP TABLE IF EXISTS `taxdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxdocument` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `message` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxdocument`
--

LOCK TABLES `taxdocument` WRITE;
/*!40000 ALTER TABLE `taxdocument` DISABLE KEYS */;
INSERT INTO `taxdocument` VALUES (1,6,10,'Approved'),(2,6,10,'Approved'),(3,4,10,'Approved'),(4,5,10,'Approved'),(5,6,10,'Approved'),(6,24,10,'<div><h1 style=\'color:blue;\'>Your Tax Document ForWomen\'s Shirts.</h1><div style=\'margin-top:20px;color:#e60000\'>This is to confirm that your item has been taken into our closet.Thanks for donating and here is the tax document worth7.0</div></div>'),(7,24,10,'<div><h1 style=\'color:blue;\'>Your Tax Document ForWomen\'s Shirts.</h1><div style=\'margin-top:20px;color:#e60000\'>This is to confirm that your item has been taken into our closet.Thanks for donating and here is the tax document worth7.0</div></div>'),(8,22,10,'<html><div><h1 style=\'color:blue;\'>Your Tax Document ForWomen\'s Thermals.</h1><div style=\'margin-top:20px;color:#e60000\'>This is to confirm that your item has been taken into our closet.Thanks for donating and here is the tax document worth9.0</div></div></html>'),(9,23,10,'<html><div><h1 style=\'color:blue;\'>Your Tax Document ForWomen\'s Thermals.</h1><div style=\'margin-top:20px;color:#e60000\'>This is to confirm that your item has been taken into our closet.Thanks for donating and here is the tax document worth6.0</div></div></html>'),(10,24,10,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:200px\'><h3 style=\'color:#333;\'>Your Tax Document ForWomen\'s Shirts.</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#e9f4f2\'>This is to confirm that your item has been taken into our closet.Thanks for donating and here is the tax document worth7.0</div></div></html>'),(11,23,10,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:100%\'><h3 style=\'color:#333;\'>Your Tax Document For Women\'s Thermals</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#e9f4f2\'>This is to confirm that your item has been taken into our closet.Thanks for donating and here is the tax document worth6.0</div></div></html>'),(12,23,10,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:100%\'><h3 style=\'color:#333;\'>Your Tax Document For Women\'s Thermals</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#e9f4f2\'>This is to confirm that your item has been taken into our closet. Thanks for donating and here is the tax document worth6.0</div></div></html>'),(13,23,10,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:100%\'><h3 style=\'color:#333;\'>Your Tax Document For Women\'s Thermals</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#666\'>This is to confirm that your item has been taken into our closet. Thanks for donating and here is the tax document worth6.0</div></div></html>'),(14,27,11,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:100%\'><h3 style=\'color:#333;\'>Your Tax Document For Tshirt</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#666\'>This is to confirm that your item has been taken into our closet. Thanks for donating and here is the tax document worth5.0$</div></div></html>'),(15,4,10,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:100%\'><h3 style=\'color:#333;\'>Your Tax Document For Men\'s Shirts</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#666\'>This is to confirm that your item has been taken into our closet. Thanks for donating and here is the tax document worth9.0$</div></div></html>'),(16,5,10,'<html><div style=\'background: #eee;padding: 10px;border-radius:5px;width:100%\'><h3 style=\'color:#333;\'>Your Tax Document For Men\'s Shirts</h3><div style=\'margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#666\'>This is to confirm that your item has been taken into our closet. Thanks for donating and here is the tax document worth20.0$</div></div></html>');
/*!40000 ALTER TABLE `taxdocument` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-09 13:22:56
