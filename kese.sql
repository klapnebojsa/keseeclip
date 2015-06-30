-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: kese
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `kesa`
--

DROP TABLE IF EXISTS `kesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kesa` (
  `IdKese` bigint(10) NOT NULL AUTO_INCREMENT,
  `OpisKese` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `SKese` bigint(12) DEFAULT NULL,
  `FKese` bigint(12) DEFAULT NULL,
  `VKese` bigint(12) DEFAULT NULL,
  `SKutije` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `SOdsecka` bigint(10) DEFAULT NULL,
  `DOdsecka` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`IdKese`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kesa`
--

LOCK TABLES `kesa` WRITE;
/*!40000 ALTER TABLE `kesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `kesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keseproba`
--

DROP TABLE IF EXISTS `keseproba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keseproba` (
  `IdKese` bigint(10) NOT NULL AUTO_INCREMENT,
  `OpisKese` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `SKese` bigint(12) DEFAULT NULL,
  `FKese` bigint(12) DEFAULT NULL,
  `VKese` bigint(12) DEFAULT NULL,
  `prom` decimal(16,4) DEFAULT NULL,
  `prom2` decimal(14,2) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Racun1` decimal(26,2) DEFAULT NULL,
  `Racun2` decimal(26,2) DEFAULT NULL,
  `Racun3` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Racun4` decimal(26,2) DEFAULT NULL,
  PRIMARY KEY (`IdKese`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keseproba`
--

LOCK TABLES `keseproba` WRITE;
/*!40000 ALTER TABLE `keseproba` DISABLE KEYS */;
INSERT INTO `keseproba` VALUES (142,'5454g',54,54,54,54.0000,44545.00,'2015-05-05',18085.94,2405430.00,'Ovo je upis bez tabele',24054.30),(143,'Opis 143 sa mnogo unetih znako',143,144,145,1456.0000,170.00,'2015-05-05',1861.05,247520.00,'Ovo je upis bez tabele',2475.20);
/*!40000 ALTER TABLE `keseproba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kutijaproba`
--

DROP TABLE IF EXISTS `kutijaproba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kutijaproba` (
  `IdKutije` bigint(10) NOT NULL AUTO_INCREMENT,
  `OpisKutije` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `DuzPrazno` bigint(12) DEFAULT NULL,
  `SirPrazno` bigint(12) DEFAULT NULL,
  `VisKutije` bigint(12) DEFAULT NULL,
  `Preklop` bigint(12) DEFAULT NULL,
  `BrojKesa` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`IdKutije`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kutijaproba`
--

LOCK TABLES `kutijaproba` WRITE;
/*!40000 ALTER TABLE `kutijaproba` DISABLE KEYS */;
INSERT INTO `kutijaproba` VALUES (102,'оиузузујхгјхгхгдгфдвцфдсњђшћч',30,30,333,15,333555),(112,'5445',5,5,4,40,4),(114,'jkhkhk',10,10,545,10,65655),(123,'kkkkkkkkkkk',5,5,3232,30,544554),(128,'re',20,5,21,10,21),(129,'1212112',5,5,211111,10,11111),(130,'545454',5,5,54545454,50,545454),(131,'44',5,5,4,10,4),(132,'12121221',5,5,212121,10,21212),(133,'545454',5,5,5454455,10,54544),(134,'hhh',5,5,333333,15,3333),(135,'545',5,5,5454545,50,454545),(136,'444',5,5,44444,10,444444),(137,'54545',5,5,444444,50,555555555),(138,'5454',5,5,5454,10,54545),(139,'5454',5,5,54545,50,54554),(140,'lkjlkjkl',5,5,545445,10,54545),(141,'yttyut',5,5,4343,10,43434),(142,'Opis kutije 123',10,10,300,30,250),(143,'opis',5,5,54545,45,5454),(144,'fgjhgjg',5,5,324324,10,234234),(145,'3333333',5,5,33,10,33),(146,'343',5,5,343,10,23432),(147,'55555555555555',5,5,545,10,5454),(148,'1',10,10,1,15,1);
/*!40000 ALTER TABLE `kutijaproba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `margine`
--

DROP TABLE IF EXISTS `margine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `margine` (
  `IdMargine` varchar(10) COLLATE utf8_bin NOT NULL,
  `Levo` decimal(5,2) DEFAULT NULL,
  `Desno` decimal(5,2) DEFAULT NULL,
  `Gore` decimal(5,2) DEFAULT NULL,
  `Dole` decimal(5,2) DEFAULT NULL,
  `MedjX` decimal(3,2) DEFAULT NULL,
  `MedjY` decimal(3,2) DEFAULT NULL,
  `VelFonta` int(6) DEFAULT NULL,
  `Font` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `Stampac` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `FormatPapira` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Orjentacija` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IdMargine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `margine`
--

LOCK TABLES `margine` WRITE;
/*!40000 ALTER TABLE `margine` DISABLE KEYS */;
INSERT INTO `margine` VALUES ('12345677',10.00,20.00,30.00,40.00,0.50,1.05,12,'Arial Bold Italic','Foxit PhantomPDF Printer','A4(210x297)','Uspravno'),('12345678',10.00,20.00,30.00,40.00,0.50,1.05,12,'Arial Bold Italic','Foxit PhantomPDF Printer','A4(210x297)','Uspravno'),('12345679',10.00,20.00,30.00,40.00,0.50,1.05,12,'Arial Bold Italic','Foxit PhantomPDF Printer','A4(210x297)','Uspravno');
/*!40000 ALTER TABLE `margine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partneri`
--

DROP TABLE IF EXISTS `partneri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partneri` (
  `IdPartner` bigint(10) NOT NULL AUTO_INCREMENT,
  `NazivPartnera` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `Adresa` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `Mesto` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Tel` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `MB` varchar(13) COLLATE utf8_bin DEFAULT NULL,
  `PIB` varchar(9) COLLATE utf8_bin DEFAULT NULL,
  `PDV` varchar(9) COLLATE utf8_bin DEFAULT NULL,
  `Delatnost` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IdPartner`)
) ENGINE=InnoDB AUTO_INCREMENT=4004 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partneri`
--

LOCK TABLES `partneri` WRITE;
/*!40000 ALTER TABLE `partneri` DISABLE KEYS */;
INSERT INTO `partneri` VALUES (700,'VSD TRADE DOO','Bulevar Despota Stefana br. 67','Beograd','','17404121','100159461','130839928','051450'),(701,'Jugoslovensko re?no brodarstvo','Kneza Miloša br. 82','Beograd','','','','',''),(702,'Zavod za zaštitu zdravlja radnika đšđššđ','Savska 23','Beograd','','146','','',''),(703,'HERBA LOGISTIC d.o.o.','Dalmatinska br. 55','Beograd','011/325-6525','','104569257','111111111',''),(704,'GAK \'NARODNI FRONT\'','Kraljice Natalije br. 62','BEOGRAD','','','100219891','',''),(705,'Lotex System d.o.o.','Kneza Miloša br. 15','Loznica','','','103197145','',''),(706,'Beošped d.o.o.','Dalmatinske zagore 113','Zemun','','','','',''),(707,'Bit Impeks d.o.o','LJERMONTOVA BR . 13','BEOGRAD','','','101198459','',''),(708,'Transprom d.o.o','Jurija Gagarina br. 229/258','Novi Beograd','','','100829633','',''),(709,'BOSS TRADE D.O.O','Slobodana Peneziša br. 2','Loznica','','','101190524','',''),(710,'WOODCRAFT D.O.O.','Valjevski put b.b. Mala Vranjska','Cerovac','','','104687890','',''),(711,'Visoka zdravstvena škola strukovnih stud','Cara Dušana 254','ZEMUN','2100-535','','100010255','173150682',''),(712,'Cannaco D.O.O.','Aleksandra Popovica 1','Zemun','','','100145954','',''),(713,'Minel Eksport-Import A.D.','Uzun Mirkova 3a','Beograd','','','100060942','',''),(714,'HK Boro Skoriš','Zajaćki put bb','Loznica','','','101198188','',''),(715,'PC Servis','Pašiševa br. 17','Loznica','','56409211','103429634','1',''),(716,'Drina Auto d.o.o','Miloša Obiliša br. 2','Miliši','','','','',''),(717,'Merkur Trade d.o.o.','Omladinskih brigada br. 31','Novi Beograd','','','104777072','',''),(718,'Žitopromet A.D.','Karakaj bb','Zvornik','','','','',''),(719,'Žak plus d.o.o','Drinske divizije br. 34','Loznica','','','103929864','',''),(720,'Aktiv 5','Dragoslava Srejoviša br.48','Beograd','','','103529707','',''),(721,'Elnos BL d.o.o','Blagoja Marjanoviša Moše br. 6','Beograd','','017330861','100143203','',''),(722,'ESTHETIC FORM D.O.O','Miloša Pocerca br. 15','Beograd','','20152133','104358472','240937630',''),(723,'Elnos BL d.o.o','Blagoja Paroviša 100E','Banja Luka','','','','','51540'),(724,'Vimkop d.o.o','Ivana Gorana Kovaćiša br. 9','Banja Luka','','','','',''),(725,'Specijalna bolnica za psihijatrijske bol','Višegradska br. 26','Beograd','','','','',''),(726,'SZGR Medakoviš','','Beograd','','','104140049','',''),(731,'VIBEX M d.o.o','Albanske spomenice br. 19','Beograd','011/2608-582','','104485414','',''),(732,'Capricorn d.o.o','Bogdana Žerajiša br. 20','Beograd','','','100168261','',''),(733,'GET computers d.o.o','Proleterske solidarnosti 30','Beograd','','','103139046','',''),(734,'Inpos d.o.o','Radnićka bb','Bor','','','104658845','',''),(735,'Sopikom d.o.o','Sarajevska 28','Beograd','','','100351751','',''),(736,'IZOLIR A.D.','Novosadski put bb','Zrenjanin','','','100654969','',''),(737,'EWE Comp','Cara Dušana 212','Beograd','','17333127','100042618','130712630','30020'),(738,'CET Computer Equipment and Trade d.o.o','Skadarska 45','Beograd','','','100063131','1',''),(739,'SUR kod Ane','Sarajevska 26','Beograd','','','103832071','',''),(740,'Auto Centar Sloba','','','','','','',''),(741,'SZR Adam','Prilaz 42','Zemun','','','100015363','',''),(742,'BBS GUMA d.o.o','Grćiša Milenka 37','Beograd','','','103772638','',''),(743,'Auspuh servis MILAN','Smederevski put 8i','Beograd M.M. Lug','','','100029688','',''),(744,'Dialog d.o.o','Tadeuša Košuška 82','Beograd','','','100244506','135137169',''),(745,'SZRR Rolo M.B.','M.P. Nenadoviša br 33','Beograd','','','104462674','',''),(746,'NETIKS D.O.O','Bulevar Kralja Aleksandra br. 193','Beograd','','','101720229','1',''),(747,'E-port Solutions Sistem d.o.o','Francuska br. 37a','Beograd','','','101601978','130970366',''),(748,'Beo-export sport d.o.o','Nemanjina 40','Beograd','','20536012','106104812','',''),(749,'Grappolo international','Kumodraska 247','Beograd','','17170643','102010664','1',''),(750,'O.š. XIV Oktobar','Goćka 40','Beograd','','','100173206','',''),(751,'KBC ZEMUN','Vukova 9','Zemun','','','100105205','1',''),(752,'Tehnomanija d.o.o','Porućnika Spasiša i Mašare br. 102','Beograd','','17233041','100416234','',''),(753,'Društvo za Konstalting',' Trgovinu i Usluge JAALP do','Milutina Milankoviša','Novi Beograd','','20478284','105878476','449934'),(754,'PERDINO d.o.o','','','','','104175434','',''),(755,'Alfa Digital d.o.o','Baja Pivljanina 53a','Beograd','','17339532','101540529','1',''),(756,'Triglav','Kralja Petra 28','Beograd','','07082428','100000555','1',''),(757,'Telcom','Nebojšina 32-a','Beograd','011/244-00-36','07562551','100010505','134239252',''),(758,'O.š. Vojvoda Putnik','Put za koloniju 12','Beograd-Ripanj','8650-139','','101746056','',''),(759,'CT Retail d.o.o.','Golsvortijeva 38',' Beograd','','','109740267','',''),(760,'UNION šPED d.o.o','Prve pruge 31a','Zemun','','20621052','106516919','1',''),(761,'Telekom Srbija','Takovska 2','Beograd','','17162543','100002887','1',''),(762,'ALTI d.o.o','Balkanska 7','Beograd','3626036','07980485','100893688','1',''),(783,'sztr SPEKTAR','Višegradska16','Beograd','','','103454312','1',''),(785,'Medicinski fakultet univerziteta Beograd','DR. Subotiša br. 8','Beograd','','','100221404','',''),(787,'K&K ELECTRONICS','Nehruova 68B','Beograd','2091900','','100268256','1',''),(791,'Centar za vazduhoplovno modelarstvo d.o.','Timoćka 18','Beograd','011/2835217','07019220','100279660','130977781',''),(792,'ONICOM','Sazonova 2','Beograd','011/2830000','07527233','100021331','1',''),(793,'Fabrika Mernih Transformatora Zajećar A.','Stra§ilovska 57','Zajećar','','','101327055','1',''),(796,'Banjola komunikacije','Omladinskih brigada 71','Beograd','011/3177-313 064/612','60596344','104926730','',''),(797,'EXTOL D.O.O','Nikole Tesle 44','Loznica','015/878625','','101195180','',''),(800,'Oris d.o.o','Banjalu?ka br. 50','Br?ko','','','','',''),(801,'OMEGA PROFEKS D.O.O.','šabaćki put bb','Loznica','','07672748','101193203','131249210',''),(802,'Mile prom d.o.o.','PC- Zelena pijaca lokal 8','loznica','','06833136','101562332','',''),(805,'METRO Cash & Carry','','Beograd','2073120','17482700','102864104','',''),(807,'AS-ART','Makarijeva 7','Beograd','0113980393','06437818','101743961','',''),(808,'KUD Branko Cvetkoviš','','','','','','',''),(809,'SPEED','Vladimira Tomanovica BB','Beograd','','','100430113','',''),(810,'str SINTELON','D. Obradoviša 12','Loznica','','','101199732','1',''),(811,'DIKTIO','Mirka Banjeviša 3','Beograd','','','106444148','1',''),(813,'RMT DOT','Braše Jerkoviš 112k','Beograd','0113949212','61753249','106034017','',''),(816,'Medical wave','Losinjska4','Beograd','011/3085354','20677660','106771234','1',''),(817,'Mali Servis d.o.o','Pohorska br. 24','Beograd','','17138405','100835453','',''),(818,'Union sped transport d.o.o','Prve pruge 31a','Beograd-Zemun','','17591622','103641285','',''),(819,'Office 1 Superstore d.o.o','Milošev Kladenac br. 14','Beograd','','','102748300','',''),(824,'UNL GROUP D.O.O. Društvo za trgovinu i u','Velemajstora Bore Kostiša 49','Beograd','','20719117','106986080','1',''),(826,'BMG Projekt','Krećanska br 1','Kovin','','','107474128','',''),(827,'AS COMMERCE- STAN D.O.O.','Obalskih radnika 17','Beograd','3558249','06976999','100116628','1',''),(828,'Opšta bolnica Loznica','Bolnićka 65','Loznica','015873311','17824465','107330306','1',''),(838,'STR SNEŽANA','Maršala Tita 60','Leštane','','','101183233','1',''),(839,'Mitros Music','Milutina Milankoviša 23','Novi Beograd','','08330158','100725925','1',''),(840,'Light designe centar d.o.o.','Zmaj Jovina 15','Beograd','','','105810715','',''),(841,'VINTEC','Koste Glaviniša 10','Beograd','011/2651226','20128224','104276295','1',''),(1001,'DABEL DOO','INDUSTRIJSKA ZONA BLOK 25','NOVA PAZOVA','3160-409','17141724','100267585','135307658','51540'),(1002,'RZZO FILIJALA NOVI SAD','ŽITNI TRG 1','NOVI SAD','021-21-276','06042945','101288707','149923146',''),(1003,'RZZO FILIJALA KRAGUJEVAC','KRALJA  PETRA PRVOG 1','KRAGUJEVAC','034-335-491','06042945','101288707','149923146',''),(1004,'RZZO FILIJALA SMEDEREVO','TRG REPUBLIKE 4','SMEDEREVO','026-227-912','06042945','101288707','149923146',''),(1005,'Zavod za javno zdravlje šabac','JOVANA CVIJIćA 1','','015/300-550','07289502','100082545','131357106',''),(1006,'SPECIJALNA BOLNICA NOVI PAZAR','BANJSKI PUT BB','NOVI PAZAR','020-313-648','313-655','848','07191987','101797'),(1007,'INSTITUT ZA JAVNO ZDRAVLJE-BATUT','Dr. SUBOTIćA  5','BEOGRAD','361-1605','07036027','102000930','135321443',''),(1008,'RZZO FILIJALA ¬A¬AK','ŽELEZNI¬KA  7','¬A¬AK','032-227-615','06042945','101288707','149923146','65232'),(1009,'VN EKONOMIST','DRAGOLJUBA POPOVIćA 14','','015/897-925','','103186075','',''),(1010,'RZZO FILIJALA BOR','NIKOLE KOPERNIKA 2-4','BOR','030-434-864','06042945','101288707','149923146',''),(1011,'PRIVREDNA KOMORA SRBIJE','RESAVSKA 13-15','BEOGRAD','32-48-123','07000529','100296837','130967554','91110'),(1012,'ZORA SUPER SPORT','VOJVODE VLAHOVIćA 29S','BEOGRAD','471-995','','100143140','126375670',''),(1013,'RZZO POKRAJINSKI ZAVOD NOVI SAD','ŽITNI TRG 3','NOVI SAD','021-623-014','06042945','101288707','149923146',''),(1014,'RZZO FILIJALA KIKINDA','DOSITEJEVA 33','KIKINDA','0230-34-203','06042945','101288707','149923146',''),(1015,'RZZO DIREKCIJA BEOGRAD','Dr.ALEKSANDRA KOSTIćA 9','BEOGRAD','2645-022','06042945','101288707','149923146',''),(1017,'KLINI¬KI CENTAR PRIšTINA','','GRA¬ANICA','','','102493090','111111111',''),(1018,'MODEL 5','Baćvanska 21','BEOGRAD','','','','',''),(1019,'CENTAR ZA SOCIJALNI RAD','DOSITEJA OBRADOVIćA BB','LOZNICA','015/889-412','07122632','102275644','160927719','85322'),(1020,'RZZO FILIJALA PIROT','SRPSKIH VLADARA BB','PIROT','010-311-992','06042945','101288707','149923146',''),(1021,'ZDRAVSTVENI CENTAR KLADOVO','DUNAVSKA 1-3','KLADOVO','019-81-396','17228480','100697491','122318779','85120'),(1022,'RZZO FILIJALA KRALJEVO','VOJVODE PUTNIKA 5','KRALJEVO','036-311-791','06042945','101288707','149923146',''),(1023,'FOREX D.O.O.','KNEZA VIšESLAVA 2d','','','','101012505','',''),(1024,'RZZO FILIJALA UŽICE','KURSULINA 1','UŽICE','031-513-237','06042945','101288707','149923146',''),(1025,'RZZO FILIJALA šABAC','VOJVODE MIšIćA 9','šABAC','015-343-470','06042945','101288707','149923146',''),(1026,'AS SOFTVER','STEVANA MOKRANJCA 6','POŽAREVAC','012/551-498','17212508','101522023','121965787','110905'),(1027,'RZZO FILIJALA S.MITROVICA','TRG SVETOG DIMITRIJA 4','SREMSKA MITROVICA','022-610-597','06042945','101288707','149923146',''),(1028,'SUP SMEDEREVO','DESPOTA GRGURA BR.2','SMEDEREVO','026/224-112  LOK.137','','100184116','',''),(1029,'VSD TRADE','Bul. Despota Stefana 67','Beograd','334-15-06','17404121','100159461','130839928',''),(1030,'ZAVOD ZA JAVNO ZDRAVLJE POŽAREVAC','JOVANA šERBANOVIćA 14','POŽAREVAC','012/227-572','','101524176','111111111',''),(1031,'RZZO FILIJALA KRUšEVAC','TRG OKTOBARSKE REVOLUCIJE 2','KRUšEVAC','037-30-891','06042945','101288707','149923146',''),(1032,'VIšA šKOLA UNUTRAšNJIH POSLOVA','CARA DUšANA 196','ZEMUN','3107-105','','100105184','111111111',''),(1033,'UNIVERZITETSKA DE¬JA KLINIKA','TIRšOVA 5','BEOGRAD','2060-656','07031246','102004424','135324265','85110'),(1035,'STUDIO B JRDP','MASARIKOVA 5','BEOGRAD','3613-872','07010109','100158887','128923211','92200'),(1036,'RZZO FILIJALA JAGODINA','KARAŃORŃEVA BB','JAGODINA','035-221-059','06042945','101288707','149923146',''),(1037,'POLICIJSKA AKADEMIJA BEOGRAD','HUMSKA 22','BEOGRAD','3692-912','','100352455','135288217',''),(1038,'KBC KRAGUJEVAC','ZMAJ JOVINA 30','KRAGUJEVAC','034/370-204','07253958','101042141','131902259',''),(1039,'LOTEKS SISTEM','Kneza Miloša 15','LOZNICA','015/874-570','','103197145','123390903',''),(1040,'KLINIKA ZA NEUROLOGIJU I PSIHIJATRIJU','DR.SUBOTIćA 6A','BEOGRAD','645-064','07035802','100269185','111111111','85110'),(1041,'INFOGRAF-Loznica','SLOBODANA PENEZIćA bb','LOZNICA','','','102997080','',''),(1042,'ACNIELSEN','španskih boraca 3','Novi Beograd','011/4141755','17512072','103071091','123098680','74130'),(1043,'CENTAR ZA STRU¬NO OBRAZOVANJE I OBRAZOVA','FABRISOVA 10','BEOGRAD','','','103476203','',''),(1045,'PETšPED','LEONARDA DA VIN¬IJA','BEOGRAD','','17517767','103137917','130664609',''),(1046,'JSP LOZNICA','VLADE ZE¬EVIćA 16','LOZNICA','','07345771','101193391','123389124','045220'),(1047,'DION','DESPOTA STEFANA LAZAREVIćA 82','NOVA PAZOVA','022-333-301','08336154','102110580','111111111','51380'),(1048,'DOM ZDRAVLJA TOPOLA','BUL. VOŽDA KARAŃORŃA 62','TOPOLA','034/811-880','17210548','101221549','131899567','85120'),(1058,'RZZO PROKUPLJE','21.SRPSKE DIVIZIJE 49','PROKUPLJE','027-321-717','06042945','101288707','149923146',''),(1059,'NEZOCO','KALEMARSKA 19E','BEOGRAD','','17573934','103547809','','51450'),(1060,'RZZO PAN¬EVO','JNA 6','PAN¬EVO','013-301-005','06042945','101288707','149923146',''),(1061,'AKTIV 5','Dragoslava Srejoviša 48','BEOGRAD','','','103529707','111111111',''),(1062,'TRANSPROM','JURIJA GAGARINA 229 lok.258','Novi Beograd','318-73-22','','100829633','111111111',''),(1063,'SUP KRAGUJEVAC','TRG SLOBODE 3','KRAGUJEVAC','034/335-013','','100184116','135324562',''),(1064,'SUP SUBOTICA','SEGEDINSKI PUT 45','SUBOTICA','024/552-933','','100184116','135324562',''),(1065,'DOM ZDRAVLJA RUMA','Orloviševa bb','RUMA','022/429-365','','101338609','111111111',''),(1066,'SUP POŽAREVAC','DRINSKA 2','POŽAREVAC','012/530-545','','100184116','135324562',''),(1067,'ZAVOD ZA BOLESTI ZAVISNOSTI','','','','','101369148','',''),(1068,'SUP Panćevo','MILOšA OBRENOVIćA 1','PAN¬EVO','013/311-780  LOK.230','','100184116','135324562',''),(1069,'SUP PEć','BRANKA RADI¬EVIćA 3','KRAGUJEVAC','','','100184116','135324562',''),(1070,'SUP SREMSKA MITROVICA','ćIRE MILETIćA 1','SREMSKA MITROVICA','022/610-270  LOK.133','','100184116','135324562',''),(1071,'Opšta bolnica Majdanpek','Kapetanska 30','MAJDANPEK','','','104891974','',''),(1072,'VRS-Kancelarija za saradnju sa medijima','','','','','102211930','',''),(1073,'ZAVOD ZA VREDNOVANJE KVALITETA OBRAZOVAN','Fabrisova br.10','BEOGRAD','','17568981','103476203','',''),(1074,'NATURA TRADE','BANJSKA bb','LOZNICA','','17550089','103325628','123421593',''),(1075,'SUP BEOGRAD','SAVSKA 35','BEOGRAD','685-144','','100184116','135324562',''),(1076,'ALFA TRADE-S DOO','BULEVAR AVNOJA 10','NOVI BEOGRAD','','','101712459','111111111',''),(4000,'BIT IMPEKS','','','','06330835','101198459','','22110'),(4001,'Aksiom Softver Development d.o.o','Kneza Miloša 82/5','Beograd','','20437375','105680465','',''),(4002,'1','1','1','1','1','1','1','1'),(4003,'NNNNNNNNNNNNNNNNN','','','','','','','');
/*!40000 ALTER TABLE `partneri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rucka`
--

DROP TABLE IF EXISTS `rucka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rucka` (
  `IdRucke` bigint(10) NOT NULL AUTO_INCREMENT,
  `KomRucki` bigint(2) DEFAULT NULL,
  `OpisRucke` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `DuzRucke` bigint(10) DEFAULT NULL,
  `SirRucke` bigint(10) DEFAULT NULL,
  `VisinaRucke` bigint(10) DEFAULT NULL COMMENT 'Koliki je deo rucke van kese. Duzina kutije = visina kese + VisinaRucke + prazan prostor (u kutiji)',
  `GramaturaRucke` bigint(4) DEFAULT NULL COMMENT 'GRamatura u combo box sa definisanim vrednostima',
  `DuzPeca` bigint(10) DEFAULT NULL,
  `SirPeca` bigint(10) DEFAULT NULL,
  `GramaturaPeca` bigint(4) DEFAULT NULL COMMENT 'GRamatura u combo box sa definisanim vrednostima',
  PRIMARY KEY (`IdRucke`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rucka`
--

LOCK TABLES `rucka` WRITE;
/*!40000 ALTER TABLE `rucka` DISABLE KEYS */;
/*!40000 ALTER TABLE `rucka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-30 21:38:46
