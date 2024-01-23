CREATE DATABASE  IF NOT EXISTS `vleague` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vleague`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: vleague
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `footballclub`
--

DROP TABLE IF EXISTS `footballclub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footballclub` (
  `club_ID` varchar(45) NOT NULL,
  `club_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`club_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footballclub`
--

LOCK TABLES `footballclub` WRITE;
/*!40000 ALTER TABLE `footballclub` DISABLE KEYS */;
INSERT INTO `footballclub` VALUES ('BBD','Becamex Bình Dương'),('CAH','Công An Hà Nội'),('DATH','Đông Á Thanh Hóa'),('FA','Free Agents'),('HAGL','LPBank Hoàng Anh Gia Lai'),('HLHT','Hồng Lĩnh Hà Tĩnh'),('HNFC','Hà Nội FC'),('HP','Hải Phòng'),('KH','Khánh Hòa'),('QN','Quảng Nam'),('QNBD','MerryLand Quy Nhơn Bình Định'),('SLNA','Sông Lam Nghệ An'),('TCVT','Thể Công – Viettel'),('TPHCM','TP Hồ Chí Minh'),('TXND','Thép Xanh Nam Định');
/*!40000 ALTER TABLE `footballclub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `footballplayer`
--

DROP TABLE IF EXISTS `footballplayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footballplayer` (
  `ID` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `ShirtNumber` int DEFAULT NULL,
  `Position` varchar(45) DEFAULT NULL,
  `Height` int DEFAULT NULL,
  `Weight` int DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Nationality` varchar(45) DEFAULT NULL,
  `club_ID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footballplayer`
--

LOCK TABLES `footballplayer` WRITE;
/*!40000 ALTER TABLE `footballplayer` DISABLE KEYS */;
INSERT INTO `footballplayer` VALUES ('ABC123','Nguyen Van A',10,'Midfielder',87,180,23,'Vietnamese','FA'),('BBD-10','Hồ Sỹ Giáp',10,'Forward',176,67,29,'Vietnamese','BBD'),('BBD-11','Bùi Vĩ Hào',11,'Forward',175,68,20,'Vietnamese','BBD'),('BBD-12','Trần Duy Khánh',12,'Midfielder',172,77,26,'Vietnamese','BBD'),('BBD-14','Nguyễn Hải Huy',14,'Midfielder',175,70,32,'Vietnamese','BBD'),('BBD-16','Nguyễn Trần Việt Cường',16,'Midfielder',180,68,23,'Vietnamese','BBD'),('BBD-17','Võ Minh Trọng',17,'Defender',170,59,22,'Vietnamese','BBD'),('BBD-18','Hà Trung Hậu',18,'Defender',178,77,21,'Vietnamese','BBD'),('BBD-19','Nguyễn Thành Lộc',19,'Defender',172,67,26,'Vietnamese','BBD'),('BBD-20','Đoàn Tuấn Cảnh',20,'Defender',176,69,25,'Vietnamese','BBD'),('BBD-21','Trần Đình Khương',21,'Midfielder',179,75,27,'Vietnamese','BBD'),('BBD-22','Nguyễn Tiến Linh',22,'Forward',181,75,26,'Vietnamese','BBD'),('BBD-23','Vũ Tuyên Quang',23,'Goalkeeper',185,72,28,'Vietnamese','BBD'),('BBD-24','Trần Hoàng Bảo',24,'Midfielder',177,65,22,'Vietnamese','BBD'),('BBD-25','Trần Minh Toàn',25,'Goalkeeper',186,85,27,'Vietnamese','BBD'),('BBD-27','Đoàn Hải Quân',27,'Midfielder',178,67,26,'Vietnamese','BBD'),('BBD-28','Nguyễn Văn Đô',28,'Midfielder',172,65,25,'Vietnamese','BBD'),('BBD-29','Võ Hoàng Minh Khoa',29,'Midfielder',175,70,22,'Vietnamese','BBD'),('BBD-3','Quế Ngọc Hải',3,'Defender',180,77,30,'Vietnamese','BBD'),('BBD-32','Trương Dủ Đạt',32,'Defender',181,82,26,'Vietnamese','BBD'),('BBD-34','Lê Quang Hùng',34,'Defender',165,65,31,'Vietnamese','BBD'),('BBD-39','Trần Trung Hiếu',39,'Midfielder',180,75,30,'Vietnamese','BBD'),('BBD-4','Janclesio Almeida Santos',4,'Defender',190,80,30,'Brazilian','BBD'),('BBD-46','Phan Minh Thành',46,'Goalkeeper',192,80,25,'Vietnamese','BBD'),('BBD-7','Ryan Ha',7,'Forward',184,84,26,'Vietnamese','BBD'),('BBD-77','Elogo Guintangui Arsene',77,'Forward',179,83,28,'French','BBD'),('BBD-8','Tống Anh Tỷ',8,'Midfielder',173,73,26,'Vietnamese','BBD'),('BBD-88','Bùi Duy Thường',88,'Midfielder',176,74,27,'Vietnamese','BBD'),('BBD-9','Ibara Doniama Prince Vinny',9,'Forward',190,92,27,'Congolese','BBD'),('CAH-1','Filip Nguyen',1,'Goalkeeper',192,88,31,'Czech','CAH'),('CAH-11','Lê Phạm Thành Long',11,'Midfielder',165,64,27,'Vietnamese','CAH'),('CAH-12','Hoàng Văn Toản',12,'Midfielder',175,70,22,'Vietnamese','CAH'),('CAH-15','Bùi Xuân Thịnh',15,'Defender',169,64,22,'Vietnamese','CAH'),('CAH-16','Bùi Tiến Dụng',16,'Defender',176,74,25,'Vietnamese','CAH'),('CAH-17','Vũ Văn Thanh',17,'Defender',172,73,27,'Vietnamese','CAH'),('CAH-18','Hồ Ngọc Thắng',18,'Forward',178,73,29,'Vietnamese','CAH'),('CAH-19','Nguyễn Quang Hải',19,'Midfielder',166,65,26,'Vietnamese','CAH'),('CAH-21','Phạm Văn Luân',21,'Midfielder',169,63,24,'Vietnamese','CAH'),('CAH-22','Trần Văn Trung',22,'Midfielder',168,63,25,'Vietnamese','CAH'),('CAH-24','Bùi Tiến Dũng',24,'Goalkeeper',180,78,26,'Vietnamese','CAH'),('CAH-26','Hà Văn Phương',26,'Midfielder',170,69,22,'Vietnamese','CAH'),('CAH-27','La Nguyễn Bảo Trung',27,'Midfielder',172,67,21,'Vietnamese','CAH'),('CAH-3','Huỳnh Tấn Sinh',3,'Defender',182,80,25,'Vietnamese','CAH'),('CAH-30','Hồ Văn Cường',30,'Defender',167,63,20,'Vietnamese','CAH'),('CAH-33','Đỗ Sỹ Huy',33,'Goalkeeper',181,80,25,'Vietnamese','CAH'),('CAH-39','Huỳnh Tấn Tài',39,'Midfielder',168,66,29,'Vietnamese','CAH'),('CAH-4','Hồ Tấn Tài',4,'Defender',180,77,26,'Vietnamese','CAH'),('CAH-47','Phạm Gia Hưng',47,'Forward',181,74,23,'Vietnamese','CAH'),('CAH-5','Đoàn Văn Hậu',5,'Defender',185,82,24,'Vietnamese','CAH'),('CAH-6','Trương Văn Thiết',6,'Defender',177,68,28,'Vietnamese','CAH'),('CAH-68','Bùi Hoàng Việt Anh',68,'Defender',184,82,24,'Vietnamese','CAH'),('CAH-7','Nguyễn Xuân Nam',7,'Forward',181,72,29,'Vietnamese','CAH'),('CAH-71','Trần Quang Thịnh',71,'Defender',179,73,22,'Vietnamese','CAH'),('CAH-8','Fialho De Aquino Junior Janio',8,'Forward',180,80,20,'Brazilian','CAH'),('CAH-9','Jeferson Elias',9,'Forward',186,78,25,'Brazilian','CAH'),('CAH-94','Geovane Magno',94,'Forward',188,78,29,'Brazilian','CAH'),('CAH-98','Giáp Tuấn Dương',98,'Defender',176,73,21,'Vietnamese','CAH'),('DATH-10','Lê Văn Thắng',10,'Midfielder',176,68,33,'Vietnamese','DATH'),('DATH-11','Rimario Allando Gordon',11,'Forward',180,75,29,'Brazilian','DATH'),('DATH-12','Nguyễn Thái Sơn',12,'Midfielder',171,61,20,'Vietnamese','DATH'),('DATH-14','Trương Thanh Nam',14,'Defender',172,65,19,'Vietnamese','DATH'),('DATH-15','Trịnh Văn Lợi',15,'Defender',180,71,28,'Vietnamese','DATH'),('DATH-16','Đinh Tiến Thành',16,'Midfielder',183,71,32,'Vietnamese','DATH'),('DATH-17','Lâm Ti Phông',17,'Midfielder',168,65,27,'Vietnamese','DATH'),('DATH-18','Đinh Viết Tú',18,'Defender',180,78,31,'Vietnamese','DATH'),('DATH-19','Lê Quốc Phương',19,'Midfielder',165,61,32,'Vietnamese','DATH'),('DATH-2','Hoàng Đình Tùng',2,'Midfielder',168,62,35,'Vietnamese','DATH'),('DATH-20','Nguyễn Trọng Hùng',20,'Midfielder',172,68,26,'Vietnamese','DATH'),('DATH-21','Thái Khắc Huy Hoàng',21,'Midfielder',170,65,24,'Vietnamese','DATH'),('DATH-22','Vũ Hồng Quân',22,'Midfielder',171,66,24,'Vietnamese','DATH'),('DATH-23','Phạm Trùm Tỉnh',23,'Midfielder',168,62,28,'Vietnamese','DATH'),('DATH-25','Nguyễn Thanh Diệp',25,'Goalkeeper',180,75,32,'Vietnamese','DATH'),('DATH-27','A Mít',27,'Midfielder',168,67,26,'Vietnamese','DATH'),('DATH-28','Hoàng Thái Bình',28,'Midfielder',173,65,25,'Vietnamese','DATH'),('DATH-29','Đoàn Ngọc Hà',29,'Defender',182,72,19,'Vietnamese','DATH'),('DATH-30','Y Êli Niê',30,'Goalkeeper',183,79,22,'Vietnamese','DATH'),('DATH-34','Doãn Ngọc Tân',34,'Defender',169,57,29,'Vietnamese','DATH'),('DATH-52','Nguyễn Trọng Phú',52,'Midfielder',173,68,24,'Vietnamese','DATH'),('DATH-6','Nguyễn Sỹ Nam',6,'Defender',170,66,30,'Vietnamese','DATH'),('DATH-66','Trần Đình Bảo',66,'Midfielder',176,74,26,'Vietnamese','DATH'),('DATH-67','Trịnh Xuân Hoàng',67,'Goalkeeper',184,78,23,'Vietnamese','DATH'),('DATH-7','Nguyễn Thanh Long',7,'Defender',180,79,30,'Vietnamese','DATH'),('DATH-8','Võ Nguyên Hoàng',8,'Forward',180,78,21,'Vietnamese','DATH'),('DATH-88','Luiz Antonio De Souza Soares',88,'Midfielder',181,80,32,'Brazilian','DATH'),('DATH-9','Nguyễn Văn Tùng',9,'Forward',168,63,21,'Vietnamese','DATH'),('DATH-91','Lê Thanh Bình',91,'Forward',176,71,28,'Vietnamese','DATH'),('DATH-95','Gustavo Sant Ana Santos',95,'Midfielder',195,91,28,'Brazilian','DATH'),('FA-01','Nguyen Tung Lam',0,'Defender',50,170,18,'Vietnamese','FA'),('HAGL-1','Dương Văn Lợi',1,'Goalkeeper',177,73,24,'Vietnamese','HAGL'),('HAGL-10','Trần Minh Vương',10,'Midfielder',167,67,29,'Vietnamese','HAGL'),('HAGL-11','Nguyễn Tuấn Anh',11,'Midfielder',175,66,29,'Vietnamese','HAGL'),('HAGL-15','Nguyễn Thanh Nhân',15,'Defender',168,65,24,'Vietnamese','HAGL'),('HAGL-18','Lê Hữu Phước',18,'Midfielder',174,62,23,'Vietnamese','HAGL'),('HAGL-19','Nguyễn Quốc Việt',19,'Forward',173,68,21,'Vietnamese','HAGL'),('HAGL-2','Lê Văn Sơn',2,'Defender',169,64,28,'Vietnamese','HAGL'),('HAGL-20','Trần Bảo Toàn',20,'Forward',169,63,24,'Vietnamese','HAGL'),('HAGL-21','Nguyễn Văn Triệu',21,'Midfielder',188,73,21,'Vietnamese','HAGL'),('HAGL-24','Nguyễn Đức Việt',24,'Midfielder',174,70,20,'Vietnamese','HAGL'),('HAGL-25','Trần Trung Kiên',25,'Goalkeeper',191,82,21,'Vietnamese','HAGL'),('HAGL-27','Phan Đình Vũ Hải',27,'Goalkeeper',183,81,30,'Vietnamese','HAGL'),('HAGL-28','Nguyễn Kiên Quyết',28,'Midfielder',166,63,28,'Vietnamese','HAGL'),('HAGL-29','Âu Dương Quân',29,'Midfielder',181,75,24,'Vietnamese','HAGL'),('HAGL-30','Martin Dzilah',30,'Forward',194,84,27,'Cameroonese','HAGL'),('HAGL-33','Jairo Rodrigues Peixoto Filho',33,'Defender',190,89,27,'Brazilian','HAGL'),('HAGL-35','Jesus Silva Jhon Cley',35,'Forward',180,79,30,'Brazilian','HAGL'),('HAGL-5','Nguyễn Hữu Anh Tài',5,'Defender',172,69,28,'Vietnamese','HAGL'),('HAGL-6','Trần Thanh Sơn',6,'Midfielder',175,71,27,'Vietnamese','HAGL'),('HAGL-60','Võ Đình Lâm',60,'Midfielder',169,68,24,'Vietnamese','HAGL'),('HAGL-62','Phan Du Học',62,'Defender',175,68,23,'Vietnamese','HAGL'),('HAGL-71','A Hoàng',71,'Midfielder',174,67,29,'Vietnamese','HAGL'),('HAGL-8','Châu Ngọc Quang',8,'Midfielder',170,63,28,'Vietnamese','HAGL'),('HAGL-86','Dụng Quang Nho',86,'Defender',171,65,24,'Vietnamese','HAGL'),('HAGL-9','Đinh Thanh Bình',9,'Forward',177,72,26,'Vietnamese','HAGL'),('HLHT-1','Nguyễn Thanh Tùng',1,'Goalkeeper',179,75,35,'Vietnamese','HLHT'),('HLHT-10','Trần Phi Sơn',10,'Midfielder',168,70,31,'Vietnamese','HLHT'),('HLHT-11','Trần Đình Tiến',11,'Midfielder',170,65,25,'Vietnamese','HLHT'),('HLHT-12','Nguyễn Vũ Linh',12,'Midfielder',170,70,26,'Vietnamese','HLHT'),('HLHT-16','Phạm Văn Long',16,'Midfielder',170,65,26,'Vietnamese','HLHT'),('HLHT-17','Trần Văn Bửu',17,'Midfielder',168,63,25,'Vietnamese','HLHT'),('HLHT-18','Vũ Quang Nam',18,'Forward',180,80,31,'Vietnamese','HLHT'),('HLHT-2','Nguyễn Văn Nhuần',2,'Defender',171,65,26,'Vietnamese','HLHT'),('HLHT-20','Nguyễn Xuân Hùng',20,'Defender',172,73,32,'Vietnamese','HLHT'),('HLHT-21','Nguyễn Văn Huy',21,'Defender',165,65,25,'Vietnamese','HLHT'),('HLHT-23','Hồ Sỹ Sâm',23,'Midfielder',170,67,30,'Vietnamese','HLHT'),('HLHT-25','Dương Quang Tuấn',25,'Goalkeeper',175,73,27,'Vietnamese','HLHT'),('HLHT-26','Bùi Văn Đức',26,'Midfielder',174,67,26,'Vietnamese','HLHT'),('HLHT-28','Nguyễn Trung Học',28,'Midfielder',172,67,25,'Vietnamese','HLHT'),('HLHT-29','Dương Tùng Lâm',29,'Goalkeeper',179,76,24,'Vietnamese','HLHT'),('HLHT-3','Nguyễn Văn Hạnh',3,'Defender',179,74,25,'Vietnamese','HLHT'),('HLHT-30','Vũ Viết Triều',30,'Defender',180,75,26,'Vietnamese','HLHT'),('HLHT-33','Tạ Việt Sơn',33,'Midfielder',176,66,20,'Vietnamese','HLHT'),('HLHT-38','Nguyễn Ngọc Thắng',38,'Defender',175,70,21,'Vietnamese','HLHT'),('HLHT-4','Lâm Anh Quang',4,'Defender',180,72,32,'Vietnamese','HLHT'),('HLHT-45','Dương Văn Kiên',45,'Defender',172,72,20,'Vietnamese','HLHT'),('HLHT-5','Đặng Văn Trâm',5,'Midfielder',168,70,28,'Vietnamese','HLHT'),('HLHT-6','Ngô Xuân Toàn',6,'Midfielder',168,65,30,'Vietnamese','HLHT'),('HLHT-68','Nguyễn Văn Trường',68,'Defender',174,64,20,'Vietnamese','HLHT'),('HLHT-7','Đinh Thanh Trung',7,'Midfielder',168,65,35,'Vietnamese','HLHT'),('HLHT-8','Bruno Edgar Silva Almeida',8,'Defender',190,84,23,'Brazilian','HLHT'),('HLHT-86','Đào Tấn Lộc',86,'Defender',181,69,25,'Vietnamese','HLHT'),('HLHT-9','Stephen Micheal Gopey',9,'Forward',184,82,23,'Nigerian','HLHT'),('HLHT-91','Diallo Abdoulaye',91,'Forward',186,80,27,'Guinean','HLHT'),('HNFC-1','Bùi Tấn Trường',1,'Goalkeeper',188,88,37,'Vietnamese','HNFC'),('HNFC-10','Nguyễn Văn Quyết',10,'Forward',172,65,32,'Vietnamese','HNFC'),('HNFC-14','Nguyễn Hai Long',14,'Midfielder',168,63,23,'Vietnamese','HNFC'),('HNFC-15','Nguyễn Đức Anh',15,'Defender',175,68,20,'Vietnamese','HNFC'),('HNFC-16','Nguyễn Thành Chung',16,'Defender',180,70,26,'Vietnamese','HNFC'),('HNFC-19','Nguyễn Văn Trường',19,'Midfielder',182,75,20,'Vietnamese','HNFC'),('HNFC-2','Đỗ Duy Mạnh',2,'Defender',180,70,27,'Vietnamese','HNFC'),('HNFC-21','Vũ Đình Hai',21,'Midfielder',172,68,23,'Vietnamese','HNFC'),('HNFC-26','Đào Văn Nam',26,'Defender',180,70,27,'Vietnamese','HNFC'),('HNFC-27','Vũ Tiến Long',27,'Defender',168,63,21,'Vietnamese','HNFC'),('HNFC-37','Quan Văn Chuẩn',37,'Goalkeeper',181,71,22,'Vietnamese','HNFC'),('HNFC-4','Wilson Brandon James',4,'Midfielder',185,80,26,'Canadian','HNFC'),('HNFC-45','Lê Văn Xuân',45,'Defender',168,69,24,'Vietnamese','HNFC'),('HNFC-5','Nguyễn Văn Hoàng',5,'Goalkeeper',182,72,28,'Vietnamese','HNFC'),('HNFC-66','Nguyễn Văn Dũng',66,'Defender',180,75,29,'Vietnamese','HNFC'),('HNFC-67','Trần Văn Thắng',67,'Defender',170,62,22,'Vietnamese','HNFC'),('HNFC-7','Phạm Xuân Mạnh',7,'Defender',175,68,27,'Vietnamese','HNFC'),('HNFC-70','Pereira Junior Delnison',70,'Forward',170,66,28,'Brazilian','HNFC'),('HNFC-74','Trương Văn Thái Quý',74,'Midfielder',168,64,26,'Vietnamese','HNFC'),('HNFC-77','Almeida Silva Marcos Antonio',77,'Midfielder',183,73,32,'Vietnamese','HNFC'),('HNFC-8','Đậu Văn Toàn',8,'Midfielder',170,69,26,'Vietnamese','HNFC'),('HNFC-88','Đỗ Hùng Dũng',88,'Midfielder',170,66,30,'Vietnamese','HNFC'),('HNFC-89','Nguyễn Văn Tùng',89,'Forward',179,70,22,'Vietnamese','HNFC'),('HNFC-9','Phạm Tuấn Hải',9,'Forward',172,68,25,'Vietnamese','HNFC'),('HNFC-95','Tagueu Tadjo Diederrick Joel',95,'Forward',178,70,30,'Cameroonian','HNFC'),('HP-1','Nguyễn Đình Triệu',1,'Goalkeeper',180,73,32,'Vietnamese','HP'),('HP-11','Hồ Minh Dĩ',11,'Midfielder',160,58,25,'Vietnamese','HP'),('HP-14','Nguyễn Văn Đạt',14,'Defender',180,72,25,'Vietnamese','HP'),('HP-19','Lê Mạnh Dũng',19,'Midfielder',172,70,29,'Vietnamese','HP'),('HP-2','Nguyễn Anh Hùng',2,'Defender',169,68,31,'Vietnamese','HP'),('HP-20','Dương Văn Khoa',20,'Defender',172,64,29,'Vietnamese','HP'),('HP-21','Lê Tiến Anh',21,'Midfielder',165,65,25,'Vietnamese','HP'),('HP-23','Đàm Tiến Dũng',23,'Defender',180,79,27,'Vietnamese','HP'),('HP-25','Bicou Bissainthe',25,'Defender',188,75,24,'Haitian','HP'),('HP-26','Nguyễn Văn Toản',26,'Goalkeeper',186,80,24,'Vietnamese','HP'),('HP-27','Nguyễn Nhật Minh',27,'Defender',175,65,20,'Vietnamese','HP'),('HP-3','Phạm Mạnh Hùng',3,'Defender',178,73,30,'Vietnamese','HP'),('HP-30','Lương Hoàng Nam',30,'Midfielder',160,57,26,'Vietnamese','HP'),('HP-31','Nguyễn Đình Tùng',31,'Goalkeeper',182,76,20,'Vietnamese','HP'),('HP-36','Phạm Văn Luân',36,'Goalkeeper',177,73,29,'Vietnamese','HP'),('HP-4','Benjamin Patrick Van Meurs',4,'Defender',187,80,26,'Dutch','HP'),('HP-42','A Sân',42,'Midfielder',172,65,27,'Vietnamese','HP'),('HP-45','Nguyễn Thành Đồng',45,'Midfielder',170,65,28,'Vietnamese','HP'),('HP-5','Đặng Văn Tới',5,'Defender',178,74,24,'Vietnamese','HP'),('HP-6','Lương Xuân Trường',6,'Midfielder',178,72,28,'Vietnamese','HP'),('HP-68','Nguyễn Trọng Đại',68,'Midfielder',184,72,26,'Vietnamese','HP'),('HP-7','Mpande Joseph Mbolimbo',7,'Forward',183,80,29,'Nigerian','HP'),('HP-77','Nguyễn Hữu Sơn',77,'Midfielder',172,65,27,'Vietnamese','HP'),('HP-79','Nguyễn Tuấn Anh',79,'Midfielder',171,61,24,'Vietnamese','HP'),('HP-8','Martin Lo',8,'Midfielder',165,66,26,'Taiwanese','HP'),('HP-9','Goncalves Silva Lucas Vinicius',9,'Midfielder',184,80,32,'Brazilian','HP'),('HP-91','Phạm Hoài Dương',91,'Defender',180,70,29,'Vietnamese','HP'),('HP-97','Triệu Việt Hưng',97,'Midfielder',171,70,26,'Vietnamese','HP'),('HP-99','Nguyễn Văn Minh',99,'Midfielder',169,58,24,'Vietnamese','HP'),('KH-11','Truong Quoc Minh',11,'Midfielder',174,75,23,'Vietnamese','KH'),('KH-12','Nguyễn Văn Sang',12,'Midfielder',168,64,26,'Vietnamese','KH'),('KH-13','Nguyễn Hoài Anh',13,'Goalkeeper',181,75,30,'Vietnamese','KH'),('KH-14','Lê Nguyễn Thanh Vị',14,'Midfielder',170,64,24,'Vietnamese','KH'),('KH-18','Nguyễn Đình Mạnh',18,'Midfielder',174,58,25,'Vietnamese','KH'),('KH-19','Dương Đoàn Công Hậu',19,'Forward',175,63,23,'Vietnamese','KH'),('KH-20','Trần Văn Tùng',20,'Forward',170,65,27,'Vietnamese','KH'),('KH-21','Trần Mạnh Hùng',21,'Midfielder',165,60,26,'Vietnamese','KH'),('KH-22','Leazard Watz Landy',22,'Forward',188,81,20,'Haitian','KH'),('KH-23','Trần Trọng Hiếu',23,'Defender',175,75,27,'Vietnamese','KH'),('KH-26','Nguyễn Tuấn Mạnh',26,'Goalkeeper',181,78,33,'Vietnamese','KH'),('KH-28','Nguyễn Văn Hiệp',28,'Midfielder',171,64,29,'Vietnamese','KH'),('KH-29','Bùi Nguyễn Tuấn Kiệt',29,'Defender',183,82,21,'Vietnamese','KH'),('KH-3','Đoàn Công Thành',3,'Defender',180,71,26,'Vietnamese','KH'),('KH-30','Nguyễn Đức Cường',30,'Midfielder',174,74,27,'Vietnamese','KH'),('KH-35','Nguyễn Duy Dương',35,'Defender',170,64,28,'Vietnamese','KH'),('KH-37','Nguyễn Minh Lợi',37,'Defender',174,72,21,'Vietnamese','KH'),('KH-4','Sesay Alie',4,'Defender',185,86,29,'Sierra Leonean','KH'),('KH-47','Hổ',47,'Midfielder',163,60,25,'Vietnamese','KH'),('KH-52','Huỳnh Nhật Tân',52,'Midfielder',172,66,26,'Vietnamese','KH'),('KH-55','Hứa Quốc Thắng',55,'Defender',185,79,22,'Vietnamese','KH'),('KH-66','Đinh Văn Trường',66,'Defender',165,55,27,'Vietnamese','KH'),('KH-7','Nguyễn Thành Nhân',7,'Midfielder',172,66,23,'Vietnamese','KH'),('KH-77','Đỗ Trường Trân',77,'Midfielder',165,65,21,'Vietnamese','KH'),('KH-8','Lê Duy Thanh',8,'Midfielder',167,67,33,'Vietnamese','KH'),('KH-88','Trần Đình Kha',88,'Forward',175,75,29,'Vietnamese','KH'),('KH-89','Nguyễn Hữu Khôi',89,'Forward',173,70,31,'Vietnamese','KH'),('KH-9','Guirassy Mamadou',9,'Forward',184,83,28,'Senegalese','KH'),('KH-93','Võ Ngọc Cường',93,'Goalkeeper',172,67,29,'Vietnamese','KH'),('QN-1','Nguyễn Văn Công',1,'Goalkeeper',182,82,31,'Vietnamese','QN'),('QN-10','Mạch Ngọc Hà',10,'Midfielder',170,62,23,'Vietnamese','QN'),('QN-11','Nguyễn Văn Trạng',11,'Midfielder',167,61,25,'Vietnamese','QN'),('QN-12','Trần Hoàng Hưng',12,'Defender',175,70,27,'Vietnamese','QN'),('QN-14','Yago Goncalves Nogueira Ramos',14,'Forward',190,83,27,'Brazilian','QN'),('QN-16','Mạc Đức Việt Anh',16,'Defender',176,70,26,'Vietnamese','QN'),('QN-17','Cao Xuân Thắng',17,'Midfielder',166,65,30,'Vietnamese','QN'),('QN-18','Võ Văn Toàn',18,'Midfielder',174,69,24,'Vietnamese','QN'),('QN-20','Nguyễn Tiến Duy',20,'Defender',180,72,32,'Vietnamese','QN'),('QN-23','Nguyễn Văn Ngọc',23,'Defender',176,71,24,'Vietnamese','QN'),('QN-24','Nguyễn Văn Ka',24,'Midfielder',170,72,24,'Vietnamese','QN'),('QN-25','Lê Xuân Tú',25,'Forward',180,72,24,'Vietnamese','QN'),('QN-26','Tống Đức An',26,'Goalkeeper',178,75,32,'Vietnamese','QN'),('QN-28','Phù Trung Phong',28,'Midfielder',171,66,25,'Vietnamese','QN'),('QN-29','Ngân Văn Đại',29,'Midfielder',174,72,31,'Vietnamese','QN'),('QN-3','Trần Ngọc Hiệp',3,'Defender',177,67,24,'Vietnamese','QN'),('QN-30','Paulo Conrado Do Carmo Sardin',30,'Forward',190,83,32,'Brazilian','QN'),('QN-34','Nguyễn Tiến Mạnh',34,'Goalkeeper',178,75,20,'Vietnamese','QN'),('QN-36','Nguyễn Vũ Hoàng Dương',36,'Defender',175,68,31,'Vietnamese','QN'),('QN-37','Võ Ngọc Đức',37,'Defender',170,71,29,'Vietnamese','QN'),('QN-39','Hoàng Vũ Olaleye Samson',39,'Forward',180,75,35,'Nigerian','QN'),('QN-4','Nguyễn Tăng Tiến',4,'Defender',181,78,29,'Vietnamese','QN'),('QN-5','Lamothe Pierre',5,'Defender',173,65,26,'Haitian','QN'),('QN-56','Vũ Văn Sơn',56,'Defender',181,77,20,'Vietnamese','QN'),('QN-6','Lê Hải Đức',6,'Defender',178,76,23,'Vietnamese','QN'),('QN-66','Eze Stephen',66,'Defender',198,102,29,'Nigerian','QN'),('QN-7','Nguyễn Đình Bắc',7,'Midfielder',179,72,19,'Vietnamese','QN'),('QN-8','Phan Thanh Hậu',8,'Midfielder',171,60,26,'Vietnamese','QN'),('QN-9','Lê Văn Nam',9,'Forward',171,71,24,'Vietnamese','QN'),('QN-98','Hoàng Thế Tài',98,'Midfielder',170,61,25,'Vietnamese','QN'),('QNBD-1','Đặng Văn Lâm',1,'Goalkeeper',188,87,30,'Vietnamese','QNBD'),('QNBD-10','Leonardo Artur De Melo',10,'Midfielder',177,68,28,'Brazilian','QNBD'),('QNBD-12','Trần Đình Trọng',12,'Defender',175,70,26,'Vietnamese','QNBD'),('QNBD-14','Đỗ Văn Thuận',14,'Midfielder',170,71,31,'Vietnamese','QNBD'),('QNBD-15','Vũ Xuân Cường',15,'Defender',170,65,31,'Vietnamese','QNBD'),('QNBD-16','Đinh Thành Luân',16,'Midfielder',173,65,19,'Vietnamese','QNBD'),('QNBD-17','Lê Ngọc Bảo',17,'Defender',178,82,25,'Vietnamese','QNBD'),('QNBD-18','Nguyễn Văn Đức',18,'Defender',168,63,27,'Vietnamese','QNBD'),('QNBD-19','Adriano Schmidt',19,'Defender',185,78,29,'Brazilian','QNBD'),('QNBD-23','Cao Văn Triền',23,'Midfielder',168,68,30,'Vietnamese','QNBD'),('QNBD-24','Nguyễn Mạnh Cường',24,'Goalkeeper',184,82,26,'Vietnamese','QNBD'),('QNBD-26','Trần Đình Minh Hoàng',26,'Goalkeeper',175,73,30,'Vietnamese','QNBD'),('QNBD-28','Nguyễn Đức Hữu',28,'Midfielder',172,69,22,'Vietnamese','QNBD'),('QNBD-29','Nguyễn Võ Minh Hiếu',29,'Midfielder',166,64,20,'Vietnamese','QNBD'),('QNBD-3','Marlon Rangel De Almeida',3,'Defender',189,80,27,'Brazilian','QNBD'),('QNBD-4','Phan Ngọc Tín',4,'Defender',176,75,19,'Vietnamese','QNBD'),('QNBD-43','Huỳnh Tiến Đạt',43,'Forward',169,68,23,'Vietnamese','QNBD'),('QNBD-6','Đỗ Thanh Thịnh',6,'Defender',169,75,25,'Vietnamese','QNBD'),('QNBD-66','Vũ Minh Tuấn',66,'Midfielder',174,66,33,'Vietnamese','QNBD'),('QNBD-67','Ngô Hồng Phước',67,'Forward',173,64,25,'Vietnamese','QNBD'),('QNBD-7','Le Viktor',7,'Midfielder',180,70,20,'Brazilian','QNBD'),('QNBD-72','Alan Sebastiao Alexandre',72,'Forward',189,82,25,'Brazilian','QNBD'),('QNBD-77','Nghiêm Xuân Tú',77,'Midfielder',174,67,35,'Vietnamese','QNBD'),('QNBD-8','Mạc Hồng Quân',8,'Midfielder',180,81,31,'Vietnamese','QNBD'),('QNBD-88','Phạm Văn Thành',88,'Midfielder',174,71,29,'Vietnamese','QNBD'),('QNBD-9','Hà Đức Chinh',9,'Forward',174,74,26,'Vietnamese','QNBD'),('QNBD-94','Trịnh Đức Lợi',94,'Defender',179,74,29,'Vietnamese','QNBD'),('QNBD-98','Phạm Minh Nghĩa',98,'Defender',178,71,25,'Vietnamese','QNBD'),('SLNA-1','Nguyễn Văn Việt',1,'Goalkeeper',180,70,21,'Vietnamese','SLNA'),('SLNA-10','Đinh Xuân Tiến',10,'Midfielder',171,65,20,'Vietnamese','SLNA'),('SLNA-11','Trần Mạnh Quỳnh',11,'Midfielder',170,65,22,'Vietnamese','SLNA'),('SLNA-14','Nguyễn Văn Việt',14,'Midfielder',173,60,24,'Vietnamese','SLNA'),('SLNA-15','Hồ Khắc Lương',15,'Defender',172,68,22,'Vietnamese','SLNA'),('SLNA-16','Nguyễn Quang Vinh',16,'Midfielder',174,68,18,'Vietnamese','SLNA'),('SLNA-17','Trần Nam Hải',17,'Midfielder',182,75,19,'Vietnamese','SLNA'),('SLNA-18','Hồ Phúc Tịnh',18,'Forward',175,68,29,'Vietnamese','SLNA'),('SLNA-19','Phan Bá Quyền',19,'Defender',175,68,21,'Vietnamese','SLNA'),('SLNA-2','Vương Văn Huy',2,'Defender',163,63,22,'Vietnamese','SLNA'),('SLNA-20','Ngô Văn Lương',20,'Forward',172,65,22,'Vietnamese','SLNA'),('SLNA-21','Phan Xuân Đại',21,'Forward',173,65,20,'Vietnamese','SLNA'),('SLNA-22','Nguyễn Xuân Bình',22,'Midfielder',171,65,22,'Vietnamese','SLNA'),('SLNA-23','Mai Sỹ Hoàng',23,'Defender',171,60,24,'Vietnamese','SLNA'),('SLNA-24','Lê Văn Quý',24,'Midfielder',168,60,19,'Vietnamese','SLNA'),('SLNA-25','Trần Văn Tiến',25,'Goalkeeper',184,70,29,'Vietnamese','SLNA'),('SLNA-26','Cao Văn Bình',26,'Goalkeeper',183,80,18,'Vietnamese','SLNA'),('SLNA-27','Ngô Văn Bắc',27,'Midfielder',169,63,19,'Vietnamese','SLNA'),('SLNA-28','Nguyễn Văn Bách',28,'Midfielder',172,66,20,'Vietnamese','SLNA'),('SLNA-29','Đặng Quang Tú',29,'Midfielder',173,69,22,'Vietnamese','SLNA'),('SLNA-3','Lê Nguyên Hoàng',3,'Defender',177,68,18,'Vietnamese','SLNA'),('SLNA-37','Đặng Văn Lắm',37,'Midfielder',170,63,24,'Vietnamese','SLNA'),('SLNA-5','Lê Văn Thành',5,'Defender',177,68,22,'Vietnamese','SLNA'),('SLNA-6','Trần Đình Hoàng',6,'Defender',174,68,32,'Vietnamese','SLNA'),('SLNA-65','Bùi Đình Châu',65,'Midfielder',168,65,27,'Vietnamese','SLNA'),('SLNA-7','Olaha Michael Onyedikachi',7,'Forward',180,78,26,'Nigerian','SLNA'),('SLNA-70','Akwa Raphael Success',70,'Midfielder',173,68,25,'Nigerian','SLNA'),('SLNA-8','Nguyễn Trọng Hoàng',8,'Midfielder',172,65,34,'Vietnamese','SLNA'),('SLNA-95','Zebic Mario',95,'Defender',187,82,28,'Croatian','SLNA'),('TCVT-1','Ngô Xuân Sơn',1,'Goalkeeper',177,75,26,'Vietnamese','TCVT'),('TCVT-11','Khuất Văn Khang',11,'Midfielder',168,63,20,'Vietnamese','TCVT'),('TCVT-12','Phan Tuấn Tài',12,'Defender',177,75,22,'Vietnamese','TCVT'),('TCVT-14','Mohamed Essameldin Abouelella Sabe',14,'Forward',176,74,29,'Egyptian','TCVT'),('TCVT-15','Đặng Tuấn Phong',15,'Defender',175,72,20,'Vietnamese','TCVT'),('TCVT-16','Nguyễn Huy Hùng',16,'Midfielder',170,68,31,'Vietnamese','TCVT'),('TCVT-17','Nguyễn Đức Hoàng Minh',17,'Midfielder',166,62,25,'Vietnamese','TCVT'),('TCVT-2','Vũ Văn Quyết',2,'Defender',175,68,24,'Vietnamese','TCVT'),('TCVT-20','Cao Trần Hoàng Hùng',20,'Defender',178,76,24,'Vietnamese','TCVT'),('TCVT-21','Nguyễn Đức Chiến',21,'Midfielder',180,77,25,'Vietnamese','TCVT'),('TCVT-22','Trần Danh Trung',22,'Forward',176,76,23,'Vietnamese','TCVT'),('TCVT-23','Nhâm Mạnh Dũng',23,'Forward',178,77,23,'Vietnamese','TCVT'),('TCVT-25','Quàng Thế Tài',25,'Goalkeeper',178,76,27,'Vietnamese','TCVT'),('TCVT-28','Nguyễn Hoàng Đức',28,'Midfielder',183,74,25,'Vietnamese','TCVT'),('TCVT-3','Nguyễn Thanh Bình',3,'Defender',183,78,23,'Vietnamese','TCVT'),('TCVT-36','Phạm Văn Phong',36,'Goalkeeper',179,75,30,'Vietnamese','TCVT'),('TCVT-37','Bruno Cunha Cantanhede',37,'Forward',184,83,30,'Brazilian','TCVT'),('TCVT-39','Dương Văn Hào',39,'Forward',177,76,26,'Vietnamese','TCVT'),('TCVT-4','Bùi Tiến Dũng',4,'Defender',172,70,28,'Vietnamese','TCVT'),('TCVT-5','Nguyễn Xuân Kiên',5,'Defender',170,66,23,'Vietnamese','TCVT'),('TCVT-6','Nguyễn Công Phương',6,'Forward',170,70,17,'Vietnamese','TCVT'),('TCVT-66','Bùi Quang Khải',66,'Midfielder',168,63,30,'Vietnamese','TCVT'),('TCVT-7','Abdumuminov Jakhongir',7,'Midfielder',186,86,30,'Uzbek','TCVT'),('TCVT-8','Nguyễn Hữu Thắng',8,'Midfielder',168,63,23,'Vietnamese','TCVT'),('TCVT-86','Trương Tiến Anh',86,'Midfielder',168,68,24,'Vietnamese','TCVT'),('TCVT-9','Trần Ngọc Sơn',9,'Midfielder',168,66,27,'Vietnamese','TCVT'),('TCVT-90','Trần Mạnh Cường',90,'Defender',166,66,30,'Vietnamese','TCVT'),('TPHCM-10','Timite Cheick Aymar',10,'Forward',178,75,25,'Ivorian','TPHCM'),('TPHCM-11','Lâm Thuận',11,'Midfielder',170,70,25,'Vietnamese','TPHCM'),('TPHCM-14','Lê Trung Vinh',14,'Midfielder',178,74,20,'Vietnamese','TPHCM'),('TPHCM-15','Uông Ngọc Tiến',15,'Midfielder',166,63,23,'Vietnamese','TPHCM'),('TPHCM-16','Nguyễn Thanh Khôi',16,'Midfielder',165,60,22,'Vietnamese','TPHCM'),('TPHCM-17','Nguyễn Minh Trung',17,'Midfielder',173,68,31,'Vietnamese','TPHCM'),('TPHCM-18','Bùi Ngọc Long',18,'Midfielder',165,57,22,'Vietnamese','TPHCM'),('TPHCM-2','Ngô Tùng Quốc',2,'Defender',172,63,25,'Vietnamese','TPHCM'),('TPHCM-20','Chu Văn Kiên',20,'Midfielder',165,62,25,'Vietnamese','TPHCM'),('TPHCM-21','Đào Quốc Gia',21,'Midfielder',177,70,27,'Vietnamese','TPHCM'),('TPHCM-22','Võ Hữu Việt Hoàng',22,'Defender',175,71,21,'Vietnamese','TPHCM'),('TPHCM-23','Hoàng Vĩnh Nguyên',23,'Midfielder',170,60,21,'Vietnamese','TPHCM'),('TPHCM-25','Phạm Hữu Nghĩa',25,'Goalkeeper',181,79,31,'Vietnamese','TPHCM'),('TPHCM-28','Trần Hoàng Phúc',28,'Defender',181,77,22,'Vietnamese','TPHCM'),('TPHCM-29','Nguyễn Hạ Long',29,'Defender',170,68,29,'Vietnamese','TPHCM'),('TPHCM-3','Nguyễn Thanh Thảo',3,'Defender',178,73,28,'Vietnamese','TPHCM'),('TPHCM-38','Đặng Ngọc Tuấn',38,'Goalkeeper',182,76,28,'Vietnamese','TPHCM'),('TPHCM-4','Lê Cao Hoài An',4,'Defender',178,74,30,'Vietnamese','TPHCM'),('TPHCM-43','Da Silva Estevam Brendon Lucas',43,'Defender',188,80,28,'Brazilian','TPHCM'),('TPHCM-5','Nguyễn Minh Tùng',5,'Midfielder',185,75,31,'Vietnamese','TPHCM'),('TPHCM-6','Võ Huy Toàn',6,'Midfielder',168,65,30,'Vietnamese','TPHCM'),('TPHCM-7','Ntep De Madiba Paul Georges',7,'Forward',180,80,31,'Cameroonian','TPHCM'),('TPHCM-77','Sầm Ngọc Đức',77,'Defender',170,70,31,'Vietnamese','TPHCM'),('TPHCM-8','Nguyễn Vũ Tín',8,'Defender',172,66,25,'Vietnamese','TPHCM'),('TPHCM-89','Patrik Le Giang',89,'Goalkeeper',188,85,31,'Vietnamese','TPHCM'),('TPHCM-9','Hồ Tuấn Tài',9,'Forward',172,68,28,'Vietnamese','TPHCM'),('TXND-10','Hendrio Araujo Dasilva',10,'Midfielder',181,74,29,'Brazilian','TXND'),('TXND-11','Douglas Coutinho Gomes de Souza',11,'Forward',183,71,29,'Brazilian','TXND'),('TXND-12','Hồ Khắc Ngọc',12,'Midfielder',170,60,31,'Vietnamese','TXND'),('TXND-13','Trần Văn Kiên',13,'Defender',170,62,27,'Vietnamese','TXND'),('TXND-14','Rafaelson Bezerra Fernandes',14,'Forward',185,90,26,'Brazilian','TXND'),('TXND-15','Nguyễn Hữu Tuấn',15,'Defender',178,70,31,'Vietnamese','TXND'),('TXND-17','Nguyễn Văn Vĩ',17,'Defender',169,60,25,'Vietnamese','TXND'),('TXND-18','Đoàn Thanh Trường',18,'Midfielder',170,61,23,'Vietnamese','TXND'),('TXND-19','Trần Văn Đạt',19,'Midfielder',175,65,23,'Vietnamese','TXND'),('TXND-2','Đinh Xuân Khải',2,'Defender',176,67,16,'Vietnamese','TXND'),('TXND-22','Hoàng Minh Tuấn',22,'Forward',177,67,28,'Vietnamese','TXND'),('TXND-23','Lê Vũ Phong',23,'Goalkeeper',181,58,22,'Vietnamese','TXND'),('TXND-26','Trần Nguyên Mạnh',26,'Goalkeeper',178,70,32,'Vietnamese','TXND'),('TXND-27','Trần Ngọc Sơn',27,'Forward',175,60,20,'Vietnamese','TXND'),('TXND-28','Tô Văn Vũ',28,'Midfielder',175,60,30,'Vietnamese','TXND'),('TXND-29','Trần Đức Dũng',29,'Goalkeeper',180,76,26,'Vietnamese','TXND'),('TXND-3','Dương Thanh Hào',3,'Defender',175,67,32,'Vietnamese','TXND'),('TXND-32','Ngô Đức Huy',32,'Defender',178,63,23,'Vietnamese','TXND'),('TXND-37','Trần Văn Công',37,'Midfielder',176,70,24,'Vietnamese','TXND'),('TXND-5','Hoàng Văn Khánh',5,'Defender',181,71,28,'Vietnamese','TXND'),('TXND-6','Phạm Đức Huy',6,'Midfielder',172,67,28,'Vietnamese','TXND'),('TXND-7','Nguyễn Phong Hồng Duy',7,'Defender',169,66,27,'Vietnamese','TXND'),('TXND-77','Mai Xuân Quyết',77,'Midfielder',171,68,24,'Vietnamese','TXND'),('TXND-8','Nguyễn Đình Sơn',8,'Midfielder',173,66,22,'Vietnamese','TXND'),('TXND-82','Trần Liêm Điều',82,'Goalkeeper',185,74,22,'Vietnamese','TXND'),('TXND-88','Lý Công Hoàng Anh',88,'Midfielder',166,70,24,'Vietnamese','TXND'),('TXND-9','Nguyễn Văn Toàn',9,'Forward',170,58,27,'Vietnamese','TXND'),('TXND-91','Nguyễn Văn Anh',91,'Forward',175,75,27,'Vietnamese','TXND');
/*!40000 ALTER TABLE `footballplayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guess_acc`
--

DROP TABLE IF EXISTS `guess_acc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guess_acc` (
  `username_guess` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username_guess`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guess_acc`
--

LOCK TABLES `guess_acc` WRITE;
/*!40000 ALTER TABLE `guess_acc` DISABLE KEYS */;
INSERT INTO `guess_acc` VALUES ('hoangphat','hoangphat123'),('nguyenvana','123456'),('tunglam','tunglam123');
/*!40000 ALTER TABLE `guess_acc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager_acc`
--

DROP TABLE IF EXISTS `manager_acc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager_acc` (
  `username_manager` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username_manager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_acc`
--

LOCK TABLES `manager_acc` WRITE;
/*!40000 ALTER TABLE `manager_acc` DISABLE KEYS */;
INSERT INTO `manager_acc` VALUES ('admin','admin');
/*!40000 ALTER TABLE `manager_acc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rank`
--

DROP TABLE IF EXISTS `rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rank` (
  `club_name` varchar(45) NOT NULL,
  `Win` int DEFAULT '0',
  `Draw` int DEFAULT '0',
  `Lose` int DEFAULT '0',
  `Points` int GENERATED ALWAYS AS (((`Win` * 3) + `Draw`)) STORED,
  `Matches_played` int GENERATED ALWAYS AS (((`Win` + `Lose`) + `Draw`)) STORED,
  PRIMARY KEY (`club_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` (`club_name`, `Win`, `Draw`, `Lose`) VALUES ('Becamex Bình Dương',0,0,0),('Công An Hà Nội',1,0,1),('Đông Á Thanh Hóa',1,0,0),('Hà Nội FC',0,0,1),('Hải Phòng',0,1,0),('Hồng Lĩnh Hà Tĩnh',0,1,0),('Khánh Hòa',0,1,0),('LPBank Hoàng Anh Gia Lai',1,0,1),('MerryLand Quy Nhơn Bình Định',2,0,0),('Quảng Nam',1,0,0),('Sông Lam Nghệ An',0,0,0),('Thể Công – Viettel',1,0,0),('Thép Xanh Nam Định',0,1,2),('TP Hồ Chí Minh',0,0,2);
/*!40000 ALTER TABLE `rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `match_id` varchar(45) NOT NULL,
  `team1_name` varchar(45) DEFAULT NULL,
  `score_1` varchar(45) DEFAULT NULL,
  `score_2` varchar(45) DEFAULT NULL,
  `team2_name` varchar(45) DEFAULT NULL,
  `match_date` date DEFAULT NULL,
  `match_time` time DEFAULT NULL,
  `stadium_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES ('1','Hồng Lĩnh Hà Tĩnh','2','2','Khánh Hòa','2024-01-11','16:00:00','Cẩm Phả'),('2','MerryLand Quy Nhơn Bình Định','3','1','Thép Xanh Nam Định','2024-01-11','10:00:00','Cẩm Phả'),('3','Thể Công – Viettel','4','2','Công An Hà Nội','2024-01-11','08:00:00','Đồng Nai'),('34','Đông Á Thanh Hóa','2','1','Thép Xanh Nam Định','2024-01-09','04:00:00','Việt Trì'),('4','Quảng Nam','2','1','TP Hồ Chí Minh','2024-01-19','14:00:00','Vĩnh Long'),('abc','Công An Hà Nội','3','2','LPBank Hoàng Anh Gia Lai','2024-01-09','09:00:00','Buôn Ma Thuột'),('ahaha','MerryLand Quy Nhơn Bình Định','1','0','Hà Nội FC','2024-01-12','07:00:00','Cao Lãnh'),('asb','Hải Phòng','1','1','Thép Xanh Nam Định','2024-01-18','06:00:00','Cẩm Phả'),('mnn123','LPBank Hoàng Anh Gia Lai','4','2','TP Hồ Chí Minh','2024-01-11','14:59:50','Cẩm Phả');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stadium`
--

DROP TABLE IF EXISTS `stadium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stadium` (
  `stadium_id` int NOT NULL,
  `stadium_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`stadium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stadium`
--

LOCK TABLES `stadium` WRITE;
/*!40000 ALTER TABLE `stadium` DISABLE KEYS */;
INSERT INTO `stadium` VALUES (1,'Bà Rịa'),(2,'Bến Tre'),(3,'Bình Phước'),(4,'Buôn Ma Thuột'),(5,'Cà Mau'),(6,'Cẩm Phả'),(7,'Cần Thơ'),(8,'Cao Lãnh'),(9,'Chi Lăng'),(10,'Gò Đậu'),(11,'Hà Nam'),(12,'Hà Tĩnh'),(13,'Hàng Đẫy'),(14,'Hoà Xuân'),(15,'Kon Tum'),(16,'Lạch Tray'),(17,'Lâm Viên'),(18,'Long An'),(19,'Mỹ Đình'),(20,'Ninh Bình'),(21,'Phan Thiết'),(22,'Phú Yên'),(23,'Pleiku'),(24,'Quân khu 7'),(25,'Quy Nhơn'),(26,'Rạch Giá'),(27,'Tam Kỳ'),(28,'Tây Ninh'),(29,'Thanh Hóa'),(30,'Thiên Trường'),(31,'Thống Nhất'),(32,'Tự Do'),(33,'Việt Trì'),(34,'Vinh'),(35,'Vĩnh Long'),(36,'Đồng Nai');
/*!40000 ALTER TABLE `stadium` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-23  7:25:38
