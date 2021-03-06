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
-- Create database
--

CREATE DATABASE IF NOT EXISTS telesoccorso;
USE telesoccorso;
--
-- Table structure for table `allarme_tecnico`
--

DROP TABLE IF EXISTS `allarme_tecnico`;
CREATE TABLE `allarme_tecnico` (
  `ID_ALLARME` varchar(50) default NULL,
  `AB_CODI` varchar(10) default NULL,
  `DATA` varchar(10) default NULL,
  `ORA` varchar(10) default NULL,
  `GIORNO_INTERVENTO` varchar(50) default NULL,
  `DATA_INTINTERVENTO` varchar(10) default NULL,
  `ORA_INTERVENTO` varchar(10) default NULL,
  `NOTE` longtext,
  `ANOMALIA_RISCONTRATA` varchar(50) default NULL,
  `USER` varchar(50) default NULL,
  KEY `IDX_ID` (`ID_ALLARME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `allarmi`
--

DROP TABLE IF EXISTS `allarmi`;
CREATE TABLE `allarmi` (
  `ID_ALLARME` varchar(50) NOT NULL,
  `ID_PROVA` varchar(50) default NULL COMMENT 'ID della prova correlata ad allarme',
  `AB_CODI` varchar(10) NOT NULL COMMENT 'Codice Utente',
  `EVENTO` varchar(50) default NULL,
  `DATA` varchar(10) default NULL,
  `ORA` varchar(10) default NULL,
  `USER` varchar(50) default NULL,
  `ESITO` varchar(255) default NULL,
  `DATA_ESITO` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT 'Data (timestamp) chiusura dell'' esito allarme',
  `CONCLUSIONI` longtext,
  `DATA_CHIUSO` varchar(10) default NULL,
  `ORA_CHIUSO` varchar(10) default NULL,
  `VISUALIZZAZIONE` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ID_ALLARME`),
  UNIQUE KEY `VISUALIZZAZIONE` (`VISUALIZZAZIONE`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  KEY `IDX_ID_PROVA` (`ID_PROVA`),
  CONSTRAINT `FK_ALLARMI.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=249672 DEFAULT CHARSET=latin1;

--
-- Table structure for table `ambulanze`
--

DROP TABLE IF EXISTS `ambulanze`;
CREATE TABLE `ambulanze` (
  `ID` int(11) NOT NULL auto_increment,
  `NUMERO` varchar(50) default NULL,
  `AB_CODI` varchar(10) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `TEL_3` varchar(50) default NULL,
  `FAX` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `TIPO` varchar(50) default NULL,
  `NOTE` longtext,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  CONSTRAINT `FK_AMBULANZE.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15027 DEFAULT CHARSET=latin1;

--
-- Table structure for table `anagrafica`
--

DROP TABLE IF EXISTS `anagrafica`;
CREATE TABLE `anagrafica` (
  `AB_CODI` varchar(10) NOT NULL default '',
  `MATRICOLA` varchar(10) default NULL,
  `NOMINATIVO` varchar(255) default NULL,
  `INDIRIZZO` varchar(255) default NULL,
  `COMUNE` varchar(255) default NULL,
  `PROVINCIA` varchar(2) default NULL,
  `CAP` varchar(50) default NULL,
  `TAVOLA` varchar(15) default NULL,
  `ZONA` varchar(5) default NULL,
  `TELEFONO` varchar(20) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `SESSO` varchar(1) default NULL,
  `DATA_NASCITA` varchar(50) default NULL,
  `LUOGO_NASCITA` varchar(50) default NULL,
  `ALTEZZA` smallint(6) default NULL,
  `PESO` smallint(6) default NULL,
  `PATOLOGIA` longtext,
  `TERAPIA` longtext,
  `EVIDENZIA` longtext,
  `NOTE` longtext,
  `ALTRO` longtext,
  `DATI_ABITA` longtext,
  `SOPRAVVIVENZA` varchar(5) default NULL,
  `DATI_TECNICI` longtext,
  `DATA_INSERIMENTO` varchar(10) default NULL,
  `DATA_INSTALLAZIONE` varchar(10) default NULL,
  `DATA_MODIFICA` varchar(10) default NULL,
  `DATA_AGGIORNAMENTO` varchar(10) default NULL,
  `DATA_DISINSTALLAZIONE` varchar(10) default NULL,
  `MOTIVO_DISINSTALLAZIONE` varchar(50) default NULL,
  `CENTRALE` varchar(50) default NULL,
  `ENTE` varchar(10) default NULL,
  PRIMARY KEY  (`AB_CODI`),
  UNIQUE KEY `IDX_AB_CODI` (`AB_CODI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `analisi`
--

DROP TABLE IF EXISTS `analisi`;
CREATE TABLE `analisi` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `NUMERO` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `FAX` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `ORARIO` varchar(50) default NULL,
  `NOTE` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `CAP` varchar(50) default NULL,
  `PROV` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  CONSTRAINT `FK_ALLARMI.ANALISI` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9027 DEFAULT CHARSET=latin1;

--
-- Table structure for table `asi_convenzioni`
--

DROP TABLE IF EXISTS `asi_convenzioni`;
CREATE TABLE `asi_convenzioni` (
  `ID` int(11) NOT NULL auto_increment,
  `NOMINATIVO` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `FAX` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `CAP` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `PROVINCIA` varchar(50) default NULL,
  `COSTO_1` varchar(50) default NULL,
  `DESCRIZIONE_1` varchar(50) default NULL,
  `COSTO_2` varchar(50) default NULL,
  `DESCRIZIONE_2` varchar(50) default NULL,
  `COSTO_3` varchar(50) default NULL,
  `DESCRIZIONE_3` varchar(50) default NULL,
  `COSTO_4` varchar(50) default NULL,
  `DESCRIZIONE_4` varchar(50) default NULL,
  `NOTE` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `asi_gmed`
--

DROP TABLE IF EXISTS `asi_gmed`;
CREATE TABLE `asi_gmed` (
  `ID` int(11) NOT NULL auto_increment,
  `DATA` date default NULL,
  `CONVENZIONE` varchar(50) default NULL,
  `DOSSIER` varchar(50) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `MEDICO` varchar(50) default NULL,
  `TEMPO` varchar(50) default NULL,
  `USCITA` varchar(50) default NULL,
  `NOTE` longtext,
  `USER` varchar(50) default NULL,
  `DATA_CHIUSO` date default NULL,
  `DIAGNOSI` longtext,
  `ORA` time default NULL,
  `ORA_CHIUSO` time default NULL,
  `TERAPIA` longtext,
  `PROGNOSI` longtext,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Table structure for table `asi_medici`
--

DROP TABLE IF EXISTS `asi_medici`;
CREATE TABLE `asi_medici` (
  `ID` int(11) NOT NULL auto_increment,
  `NOMINATIVO` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `TEL_STUDIO` varchar(255) default NULL,
  `TEL_CASA` varchar(255) default NULL,
  `CELLULARE` varchar(255) default NULL,
  `FAX` varchar(255) default NULL,
  `REPERIBILITA` varchar(255) default NULL,
  `SPECIALITA` varchar(255) default NULL,
  `INDIRIZZO` varchar(255) default NULL,
  `COMUNE` varchar(255) default NULL,
  `CAP` varchar(255) default NULL,
  `PROV` varchar(255) default NULL,
  `BANCA` varchar(255) default NULL,
  `AGENZIA` varchar(255) default NULL,
  `CONTO_CORRENTE` varchar(255) default NULL,
  `ABI` varchar(255) default NULL,
  `CAB` varchar(255) default NULL,
  `CIN` varchar(255) default NULL,
  `NOTE` longtext,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Table structure for table `asi_turni`
--

DROP TABLE IF EXISTS `asi_turni`;
CREATE TABLE `asi_turni` (
  `ID` int(11) NOT NULL auto_increment,
  `GIORNO` varchar(50) default NULL,
  `DATA` varchar(50) default NULL,
  `MATTINO` varchar(50) default NULL,
  `POMERIGGIO` varchar(50) default NULL,
  `NOTTE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `assenza`
--

DROP TABLE IF EXISTS `assenza`;
CREATE TABLE `assenza` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) default NULL,
  `TIPO` varchar(50) default NULL,
  `DATA_ASSENZA` varchar(10) default NULL,
  `DATA_RIENTRO` varchar(10) default NULL,
  `NOTE` longtext,
  `MOTIVO` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  CONSTRAINT `FK_ALLARMI.ASSENZA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18496 DEFAULT CHARSET=latin1;

--
-- Table structure for table `cdr`
--

DROP TABLE IF EXISTS `cdr`;
CREATE TABLE `cdr` (
  `calldate` datetime NOT NULL default '0000-00-00 00:00:00',
  `clid` varchar(80) NOT NULL default '',
  `src` varchar(80) NOT NULL default '',
  `dst` varchar(80) NOT NULL default '',
  `dcontext` varchar(80) NOT NULL default '',
  `channel` varchar(80) NOT NULL default '',
  `dstchannel` varchar(80) NOT NULL default '',
  `lastapp` varchar(80) NOT NULL default '',
  `lastdata` varchar(80) NOT NULL default '',
  `duration` int(11) NOT NULL default '0',
  `billsec` int(11) NOT NULL default '0',
  `disposition` varchar(45) NOT NULL default '',
  `amaflags` int(11) NOT NULL default '0',
  `accountcode` varchar(20) NOT NULL default '',
  `uniqueid` varchar(32) NOT NULL default '',
  `userfield` varchar(255) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `coda_eve`
--

DROP TABLE IF EXISTS `coda_eve`;
CREATE TABLE `coda_eve` (
  `ID_ALLARME` varchar(50) default NULL,
  `AB_CODI` varchar(10) default NULL,
  `MATRICOLA` varchar(10) default NULL,
  `EVENTO` varchar(50) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `DATA` varchar(50) default NULL,
  `ORA` varchar(50) default NULL,
  `USER` varchar(50) default NULL,
  `TELEFONO` varchar(20) default NULL,
  `FILENAME` varchar(512) default NULL,
  KEY `IDX_ID` (`ID_ALLARME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `coda_prove`
--

DROP TABLE IF EXISTS `coda_prove`;
CREATE TABLE `coda_prove` (
  `ID` varchar(50) NOT NULL COMMENT 'ID univoco della prova',
  `AB_CODI` varchar(10) NOT NULL COMMENT 'AB_CODI della prova, unico in chiave primaria',
  `ORA` varchar(10) default NULL,
  `USER` varchar(50) default NULL,
  `RICHIAMARE` varchar(5) default NULL,
  PRIMARY KEY  (`AB_CODI`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `convivente`
--

DROP TABLE IF EXISTS `convivente`;
CREATE TABLE `convivente` (
  `AB_CODI` varchar(10) default NULL,
  `NOMINATIVO` varchar(255) default NULL,
  `COINTESTATARIO` varchar(75) default NULL,
  `SESSO` varchar(1) default NULL,
  `LUOGO_NASCITA` varchar(50) default NULL,
  `DATA_NASCITA` varchar(50) default NULL,
  `ALTEZZA` smallint(6) default NULL,
  `PESO` smallint(6) default NULL,
  `PATOLOGIA` text,
  `EVIDENZIA` varchar(75) default NULL,
  `NOTE` text,
  `TERAPIA` text,
  `CELLULARE` varchar(20) default NULL,
  `ID` int(11) NOT NULL auto_increment COMMENT 'ID campo convivente',
  `PARENTELA` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  KEY `IDX_NOMINATIVO` (`NOMINATIVO`),
  KEY `IDX_SESSO` (`SESSO`),
  CONSTRAINT `FK_ALLARMI.CONVIVENTE` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2278 DEFAULT CHARSET=latin1;

--
-- Table structure for table `croci`
--

DROP TABLE IF EXISTS `croci`;
CREATE TABLE `croci` (
  `ID` int(11) NOT NULL auto_increment,
  `NOMINATIVO` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `CAP` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `ORARIO` varchar(50) default NULL,
  `NOTE` varchar(50) default NULL,
  `TRASPORTO` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `enti`
--

DROP TABLE IF EXISTS `enti`;
CREATE TABLE `enti` (
  `ENTE` varchar(50) default NULL,
  `DESCRIZIONE` varchar(50) default NULL,
  `REFERENTE` varchar(20) default NULL,
  `TEL_1` varchar(20) default NULL,
  `TEL_2` varchar(20) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `CAP` varchar(5) default NULL,
  `ID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Table structure for table `eventi_allarme`
--

DROP TABLE IF EXISTS `eventi_allarme`;
CREATE TABLE `eventi_allarme` (
  `LIVELLO_ALLARME` varchar(4) NOT NULL COMMENT 'Livello attenzione allarme, 1 Allarme reale, 2 Allarme non reale, etc.. etc..',
  `EVENTO` varchar(50) NOT NULL COMMENT 'Tipo evento, trasmesso dall scheduler',
  PRIMARY KEY  (`EVENTO`),
  UNIQUE KEY `IDX_EVENTO` (`EVENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `eventip0`
--

DROP TABLE IF EXISTS `eventip0`;
CREATE TABLE `eventip0` (
  `STORICO_EVENTI_AB_CODI` varchar(10) default NULL,
  `DATA` varchar(10) default NULL,
  `EVENTO` varchar(15) default NULL,
  `TABELLAP0_AB_CODI` varchar(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `gmed`
--

DROP TABLE IF EXISTS `gmed`;
CREATE TABLE `gmed` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `NUMERO` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `TIPO` varchar(50) default NULL,
  `NOTE` longtext,
  `ORARIO` longtext,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`)
) ENGINE=InnoDB AUTO_INCREMENT=15804 DEFAULT CHARSET=latin1;

--
-- Table structure for table `indirizzisociali`
--

DROP TABLE IF EXISTS `indirizzisociali`;
CREATE TABLE `indirizzisociali` (
  `NOMINATIVO` varchar(255) default NULL,
  `INDIRIZZO` varchar(255) default NULL,
  `CAP` varchar(50) default NULL,
  `COMUNE` varchar(255) default NULL,
  `ZONA` varchar(50) default NULL,
  `TAVOLA` varchar(50) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `FAX` varchar(50) default NULL,
  `REFERENTE` varchar(255) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `ORARIO` varchar(50) default NULL,
  `TIPO` varchar(255) default NULL,
  `NOTE` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `infermieri`
--

DROP TABLE IF EXISTS `infermieri`;
CREATE TABLE `infermieri` (
  `ID` int(11) NOT NULL auto_increment,
  `DATA` date default NULL,
  `CONVENZIONE` varchar(50) default NULL,
  `DOSSIER` varchar(50) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `INFERMIERE` varchar(50) default NULL,
  `TEMPO` varchar(50) default NULL,
  `USCITA` varchar(50) default NULL,
  `NOTE` longtext,
  `USER` varchar(50) default NULL,
  `DATA_CHIUSO` date default NULL,
  `REFERTO` longtext,
  `ORA` time default NULL,
  `ORA_CHIUSO` time default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Table structure for table `info_allarme`
--

DROP TABLE IF EXISTS `info_allarme`;
CREATE TABLE `info_allarme` (
  `ID` varchar(32) NOT NULL,
  `ID_ALLARME` varchar(50) NOT NULL COMMENT 'ID allarme generato',
  `AB_CODI` varchar(10) default NULL,
  `DATA` varchar(10) default NULL,
  `ORA` varchar(10) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `INFO` longtext,
  `DURATA` varchar(50) default NULL,
  `USER` varchar(50) default NULL,
  `USCITA` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDX_DATA` (`DATA`),
  KEY `IDX_OPE` (`USER`),
  KEY `IDX_ORA` (`ORA`),
  KEY `IDX_TELEFONO` (`TELEFONO`),
  KEY `IDX_ID_ALLARME` (`ID_ALLARME`),
  CONSTRAINT `FK_ALLARMI.INFO_ALLARME` FOREIGN KEY (`ID_ALLARME`) REFERENCES `allarmi` (`ID_ALLARME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `info_prova`
--

DROP TABLE IF EXISTS `info_prova`;
CREATE TABLE `info_prova` (
  `ID_PROVA` varchar(50) NOT NULL COMMENT 'ID prova effettuata',
  `AB_CODI` varchar(10) default NULL COMMENT 'Codice utente',
  `DATA` varchar(10) default NULL,
  `ORA` varchar(10) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `INFO` longtext,
  `DURATA` varchar(50) default NULL,
  `USER` varchar(50) default NULL,
  KEY `IDX_DATA` (`DATA`),
  KEY `IDX_OPE` (`USER`),
  KEY `IDX_ORA` (`ORA`),
  KEY `IDX_TELEFONO` (`TELEFONO`),
  KEY `IDX_ID_PROVA` (`ID_PROVA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `USER` varchar(50) NOT NULL COMMENT 'Campo user della login Info',
  `IP` varchar(15) default NULL COMMENT 'Indirizzo IP di login',
  `FOGLIO_PROVE` varchar(50) NOT NULL COMMENT 'Foglio prove utente',
  `CENTRALE` varchar(50) default NULL COMMENT 'Centrale a cui appartiene Utente',
  `ID_LOGIN` int(20) NOT NULL auto_increment,
  PRIMARY KEY  (`ID_LOGIN`),
  UNIQUE KEY `IDX_ID_LOGIN` (`ID_LOGIN`)
) ENGINE=InnoDB AUTO_INCREMENT=3376 DEFAULT CHARSET=latin1;

--
-- Table structure for table `medici`
--

DROP TABLE IF EXISTS `medici`;
CREATE TABLE `medici` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) default NULL,
  `MEDICO` varchar(50) default NULL,
  `TEL_AMB` varchar(50) default NULL,
  `TEL_CASA` varchar(50) default NULL,
  `TEL_CELL` varchar(50) default NULL,
  `INDIRIZZO` varchar(255) default NULL,
  `COMUNE` varchar(255) default NULL,
  `SPECIALISTA` varchar(50) default NULL,
  `NUMERO` varchar(50) default NULL,
  `ORARIO` longtext,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  CONSTRAINT `FK_MEDICI.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24986 DEFAULT CHARSET=latin1;

--
-- Table structure for table `medicinali`
--

DROP TABLE IF EXISTS `medicinali`;
CREATE TABLE `medicinali` (
  `ID` int(10) NOT NULL,
  `NOME` varchar(255) default NULL,
  `PRINCIPIO_ATTIVO` varchar(255) default NULL,
  `DESCRIZIONE` varchar(255) default NULL,
  `DITTA` varchar(255) default NULL,
  `POSOLOGIA` double(15,5) default NULL,
  `PREZZO` double(15,5) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `ospedali`
--

DROP TABLE IF EXISTS `ospedali`;
CREATE TABLE `ospedali` (
  `NOMINATIVO` tinyint(4) NOT NULL auto_increment,
  `NOTE` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `CAP` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `ZONA` varchar(50) default NULL,
  `TAVOLA` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `TEL_3` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `ORARI` varchar(50) default NULL,
  PRIMARY KEY  (`NOMINATIVO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `pagamenti`
--

DROP TABLE IF EXISTS `pagamenti`;
CREATE TABLE `pagamenti` (
  `AB_CODI` varchar(10) NOT NULL default '',
  `MODO_PAGAMENTO` varchar(50) default NULL,
  `IMPONIBILE` varchar(50) default NULL,
  `IMPORTO_IVA` varchar(50) default NULL,
  `TOTALE` varchar(50) default NULL,
  `TOTALE_LETTERE` varchar(50) default NULL COMMENT 'Importo in lettere',
  `ANNO` varchar(50) default NULL,
  `DAL_AL` varchar(50) default NULL,
  `ID` int(11) NOT NULL auto_increment,
  `DATA_PAGAMENTO` varchar(50) default NULL,
  PRIMARY KEY  (`AB_CODI`),
  UNIQUE KEY `IDX_AB_CODI` (`AB_CODI`),
  UNIQUE KEY `IDX_ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `patologie`
--

DROP TABLE IF EXISTS `patologie`;
CREATE TABLE `patologie` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(50) default NULL,
  `IPERTENSIONE` tinyint(1) NOT NULL,
  `IPOTENSIONE` tinyint(1) NOT NULL,
  `PRESSIONE_NOTE` varchar(50) default NULL,
  `IMA` tinyint(1) NOT NULL,
  `DATA_IMA1` varchar(10) default NULL,
  `DATA_IMA2` varchar(10) default NULL,
  `DATA_IMA3` varchar(10) default NULL,
  `ANGINA` tinyint(1) NOT NULL,
  `CARDIOPATIA_ISCHEMICA` tinyint(1) NOT NULL,
  `MIOCARDIOPATIA` tinyint(1) NOT NULL,
  `VALVULOPATIA` tinyint(1) NOT NULL,
  `ARITMIA` tinyint(1) NOT NULL,
  `TACHICARDIA` tinyint(1) NOT NULL,
  `FIBRILAZIONE` tinyint(1) NOT NULL,
  `INSUFFICIENZA_CARDIACA` tinyint(1) NOT NULL,
  `PACEMAKER` tinyint(1) NOT NULL,
  `STENOSI_AORTICA` tinyint(1) NOT NULL,
  `TIA` tinyint(1) NOT NULL,
  `ICTUS` tinyint(1) NOT NULL,
  `ANEURISMA` tinyint(1) NOT NULL,
  `ARTERIOPATIA` tinyint(1) NOT NULL,
  `FLEBITE` tinyint(1) NOT NULL,
  `TROMBOSI` tinyint(1) NOT NULL,
  `VARICI` tinyint(1) NOT NULL,
  `EDEMA_POLMONARE` tinyint(1) NOT NULL,
  `PLEURITE` tinyint(1) NOT NULL,
  `PNX` tinyint(1) NOT NULL,
  `TBC` tinyint(1) NOT NULL,
  `BPCO` tinyint(1) NOT NULL,
  `INSUFFICIENZA_RESPIRATORIA` tinyint(1) NOT NULL,
  `K_POLMONARE` tinyint(1) NOT NULL,
  `GASTRITE` tinyint(1) NOT NULL,
  `ULCERA` tinyint(1) NOT NULL,
  `COLITE` tinyint(1) NOT NULL,
  `ERNIA_DX` tinyint(1) NOT NULL,
  `ERNIA_SX` tinyint(1) NOT NULL,
  `ERNIA_IATALE` tinyint(1) NOT NULL,
  `DIVERTICOLI` tinyint(1) NOT NULL,
  `EPATITE_A` tinyint(1) NOT NULL,
  `EPETITE_B` tinyint(1) NOT NULL,
  `EPATITE_C` tinyint(1) NOT NULL,
  `CIRROSI` tinyint(1) NOT NULL,
  `CALCOLI` tinyint(1) NOT NULL,
  `K_DIGERENTE` tinyint(1) NOT NULL,
  `K_DIGERENTE_SEDE` varchar(50) default NULL,
  `INSUFFICIENZA-RENALE` tinyint(1) NOT NULL,
  `CALCOLOSI_RENALE` tinyint(1) NOT NULL,
  `CISTE_RENALE` tinyint(1) NOT NULL,
  `CISTITE` tinyint(1) NOT NULL,
  `CISTI_OVAIO` tinyint(1) NOT NULL,
  `PROSTATA` tinyint(1) NOT NULL,
  `DIALISI` tinyint(1) NOT NULL,
  `K_GENITO_URINARIO` tinyint(1) NOT NULL,
  `K_GENITO_URINARIO_SEDE` varchar(50) default NULL,
  `ARTROSI_1` tinyint(1) NOT NULL,
  `ARTROSI_2` tinyint(1) NOT NULL,
  `ARTROSI_3` tinyint(1) NOT NULL,
  `ARTROSI_4` tinyint(1) NOT NULL,
  `OSTEOPOROSI_1` tinyint(1) NOT NULL,
  `OSTEOPOROSI_2` tinyint(1) NOT NULL,
  `OSTEOPOROSI_3` tinyint(1) NOT NULL,
  `OSTEOPOROSI_4` tinyint(1) NOT NULL,
  `FRATTURE` tinyint(1) NOT NULL,
  `FRATTURE_SEDE` varchar(50) default NULL,
  `AMPUTAZIONI` tinyint(1) NOT NULL,
  `AMPUTAZIONI_SEDE` varchar(50) default NULL,
  `PROTESI` tinyint(1) NOT NULL,
  `PROTESI_SEDE` varchar(50) default NULL,
  `DIABETE` tinyint(1) NOT NULL,
  `IPERTIROIDISMO` tinyint(1) NOT NULL,
  `IPOTIROIDISMO` tinyint(1) NOT NULL,
  `ANEMIA` tinyint(1) NOT NULL,
  `COAGULOPATIA` tinyint(1) NOT NULL,
  `LEUCEMIA` tinyint(1) NOT NULL,
  `LINFOMA` tinyint(1) NOT NULL,
  `DEPRESSIONE` tinyint(1) NOT NULL,
  `ANSIA` tinyint(1) NOT NULL,
  `AMNESIE` tinyint(1) NOT NULL,
  `DEMENZA` tinyint(1) NOT NULL,
  `SCLEROSI` tinyint(1) NOT NULL,
  `EPILESSIA` tinyint(1) NOT NULL,
  `NEUROPATIA` tinyint(1) NOT NULL,
  `PARKINSON` tinyint(1) NOT NULL,
  `ERNIA-DISCO` tinyint(1) NOT NULL,
  `DISTROFIA` tinyint(1) NOT NULL,
  `CEFALEA` tinyint(1) NOT NULL,
  `DISTURBI_EQUILIBRIO` tinyint(1) NOT NULL,
  `CATARATTA_DX` tinyint(1) NOT NULL,
  `CATARATTA_SX` tinyint(1) NOT NULL,
  `GLAUCOMA_DX` tinyint(1) NOT NULL,
  `GLAUCOMA_SX` tinyint(1) NOT NULL,
  `IPOACUSIA_1` tinyint(1) NOT NULL,
  `IPOACUSIA_2` tinyint(1) NOT NULL,
  `IPOACUSIA_3` tinyint(1) NOT NULL,
  `RIDUZIONE_VISTA_1` tinyint(1) NOT NULL,
  `RIDUZIONE_VISTA_2` tinyint(1) NOT NULL,
  `RIDUZIONE_VISTA_3` tinyint(1) NOT NULL,
  `ALLERGIE` varchar(50) default NULL,
  `ALTRO` longtext,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_CODICE` (`AB_CODI`),
  CONSTRAINT `FK_PATOLOGIE.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `pediatrica`
--

DROP TABLE IF EXISTS `pediatrica`;
CREATE TABLE `pediatrica` (
  `ID` int(11) NOT NULL auto_increment,
  `DATA` date default NULL,
  `CONVENZIONE` varchar(50) default NULL,
  `DOSSIER` varchar(50) default NULL,
  `NOMINATIVO` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `MEDICO` varchar(50) default NULL,
  `TEMPO` varchar(50) default NULL,
  `USCITA` varchar(50) default NULL,
  `NOTE` longtext,
  `USER` varchar(50) default NULL,
  `DATA_CHIUSO` date default NULL,
  `REFERTO` longtext,
  `ORA` time default NULL,
  `ORA_CHIUSO` time default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `phone_info`
--

DROP TABLE IF EXISTS `phone_info`;
CREATE TABLE `phone_info` (
  `IP` varchar(15) NOT NULL COMMENT 'Indirizzo IP della postazione usata',
  `Server_IP` varchar(15) NOT NULL COMMENT 'IP del server telefonico',
  `Channel` varchar(36) default NULL COMMENT 'Numero di telefono configurato',
  `Callback_Page` varchar(256) default NULL COMMENT 'Pagina php callback telefonica',
  PRIMARY KEY  (`IP`),
  UNIQUE KEY `IDX_IP` (`IP`),
  UNIQUE KEY `IDX_Phone_Number` (`Channel`),
  UNIQUE KEY `IDX_Channel` (`Channel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 8192 kB ; Tabella di configurazione dei telefon';

--
-- Table structure for table `prove`
--

DROP TABLE IF EXISTS `prove`;
CREATE TABLE `prove` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(50) default NULL,
  `FOGLIO` varchar(50) default NULL,
  `GIORNO` varchar(50) default NULL,
  `FASCIA` varchar(50) default NULL,
  `RICHIAMARE` varchar(50) default NULL,
  `NOTE` varchar(50) default NULL,
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  CONSTRAINT `FK_PROVE.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7150 DEFAULT CHARSET=latin1;

--
-- Table structure for table `prove_day`
--

DROP TABLE IF EXISTS `prove_day`;
CREATE TABLE `prove_day` (
  `ID` varchar(50) NOT NULL COMMENT 'ID univoco della prova',
  `AB_CODI` varchar(10) NOT NULL,
  `FOGLIO` varchar(50) default NULL,
  `GIORNO` varchar(50) default NULL,
  `FASCIA` varchar(50) default NULL,
  `USER` varchar(50) default NULL,
  `GESTIONE` varchar(50) default NULL,
  `RICHIAMARE` varchar(50) default NULL,
  `CENTRALE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `prove_fascia`
--

DROP TABLE IF EXISTS `prove_fascia`;
CREATE TABLE `prove_fascia` (
  `ID` int(11) NOT NULL auto_increment,
  `FASCIA` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;

--
-- Table structure for table `prove_fogli`
--

DROP TABLE IF EXISTS `prove_fogli`;
CREATE TABLE `prove_fogli` (
  `ID` int(11) NOT NULL auto_increment,
  `TIPO` varchar(50) default NULL,
  `DESCRIZIONE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Table structure for table `prove_nr`
--

DROP TABLE IF EXISTS `prove_nr`;
CREATE TABLE `prove_nr` (
  `ID` varchar(50) NOT NULL COMMENT 'ID univoco della prova',
  `AB_CODI` varchar(50) default NULL,
  `FOGLIO` varchar(50) default NULL,
  `GIORNO` varchar(50) default NULL,
  `FASCIA` varchar(50) default NULL,
  `USER` varchar(50) default NULL,
  `GESTIONE` varchar(50) default NULL,
  `RICHIAMARE` varchar(50) default NULL,
  `CENTRALE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `socc_amici`
--

DROP TABLE IF EXISTS `socc_amici`;
CREATE TABLE `socc_amici` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) NOT NULL default '',
  `NOMINATIVO` varchar(255) default NULL,
  `TEL_CASA` varchar(50) default NULL,
  `TEL_UFF` varchar(50) default NULL,
  `TEL_CELL` varchar(50) default NULL,
  `TEMPO_CASA` varchar(50) default NULL,
  `TEMPO_UFF` varchar(50) default NULL,
  `CHIAVI` varchar(50) default NULL,
  `COINQUILINO` varchar(50) default NULL,
  `PARENTE` varchar(50) default NULL,
  `NUMERO` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  CONSTRAINT `FK_SOCC_AMICI.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54016 DEFAULT CHARSET=latin1;

--
-- Table structure for table `socc_pub`
--

DROP TABLE IF EXISTS `socc_pub`;
CREATE TABLE `socc_pub` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) default NULL,
  `TIPO` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `TEL_2` varchar(50) default NULL,
  `NUMERO` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `IDX_ID` (`ID`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  KEY `IDX_NUMERO` (`NUMERO`),
  CONSTRAINT `FK_SOCC_PUBB.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50340 DEFAULT CHARSET=latin1;

--
-- Table structure for table `stipulante`
--

DROP TABLE IF EXISTS `stipulante`;
CREATE TABLE `stipulante` (
  `ID` int(11) NOT NULL auto_increment,
  `AB_CODI` varchar(10) NOT NULL default '',
  `NOMINATIVO` varchar(50) default NULL,
  `INDIRIZZO` varchar(50) default NULL,
  `COMUNE` varchar(50) default NULL,
  `PROV` varchar(50) default NULL,
  `CAP` varchar(50) default NULL,
  `CF` varchar(16) default NULL,
  `TELEFONO` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `TEL_UFFICIO` varchar(50) default NULL,
  `REFERENTE` varchar(50) default NULL,
  `IMPONIBILE` varchar(10) default NULL,
  `IVA` varchar(10) default NULL,
  `IMPORTO_IVA` varchar(10) default NULL,
  `CONTRATTO` varchar(50) default NULL,
  `PAGAMENTO` varchar(50) default NULL,
  `MODO_PAGAMENTO` varchar(50) default NULL,
  `EMAIL` varchar(50) default NULL,
  `PARENTELA` varchar(50) default NULL,
  `PIVA` varchar(11) default NULL,
  `NOTE` longtext,
  `TOTALE` varchar(20) default NULL,
  PRIMARY KEY  (`AB_CODI`),
  UNIQUE KEY `IDX_AB_CODI` (`AB_CODI`),
  UNIQUE KEY `IDX_ID` (`ID`),
  CONSTRAINT `FK_STIPULANTE.ANAGRAFICA` FOREIGN KEY (`AB_CODI`) REFERENCES `anagrafica` (`AB_CODI`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6819 DEFAULT CHARSET=latin1;

--
-- Table structure for table `storico_eventi`
--

DROP TABLE IF EXISTS `storico_eventi`;
CREATE TABLE `storico_eventi` (
  `ID_ALLARME` varchar(50) default NULL,
  `DATA` varchar(10) default NULL,
  `ORA` varchar(10) default NULL,
  `MUX` varchar(5) default NULL,
  `EVENTO` varchar(15) default NULL,
  `AB_CODI` varchar(10) default NULL,
  `MATRICOLA` varchar(10) default NULL,
  `RITARDO` varchar(2) default NULL,
  `VISUALIZZAZIONE` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`VISUALIZZAZIONE`),
  UNIQUE KEY `IDX_ID` (`ID_ALLARME`),
  KEY `IDX_AB_CODI` (`AB_CODI`),
  KEY `IDX_DATA` (`DATA`),
  KEY `EVENTO` (`EVENTO`),
  KEY `IDX_MATRICOLA` (`MATRICOLA`),
  KEY `IDX_MUX` (`MUX`),
  KEY `IDX_ORA` (`ORA`),
  KEY `IDX_RITARDO` (`RITARDO`)
) ENGINE=InnoDB AUTO_INCREMENT=1025154 DEFAULT CHARSET=latin1;

--
-- Table structure for table `tabellap0`
--

DROP TABLE IF EXISTS `tabellap0`;
CREATE TABLE `tabellap0` (
  `AB_CODI` varchar(10) default NULL,
  `NOMINATIVO` varchar(255) default NULL,
  `SOPRAVVIVENZA` varchar(5) default NULL,
  `TAVOLA` varchar(15) default NULL,
  `COMUNE` varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
CREATE TABLE `tecnico` (
  `NOMINATIVO` varchar(50) default NULL,
  `ENTE` varchar(50) default NULL,
  `TEL_1` varchar(50) default NULL,
  `CELLULARE` varchar(50) default NULL,
  `ORARIO` varchar(50) default NULL,
  `NOTE` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `tipo_allarme`
--

DROP TABLE IF EXISTS `tipo_allarme`;
CREATE TABLE `tipo_allarme` (
  `ALLARME` varchar(5) NOT NULL COMMENT 'Campo tipo allarme (reali, sociali, errori,gestione)',
  `PREVIEW` varchar(5) default 'NULL' COMMENT 'Campo preview , for future use',
  PRIMARY KEY  (`ALLARME`),
  UNIQUE KEY `IDX_ALLARME` (`ALLARME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabella Tipo allarme , for future use';

--
-- Table structure for table `tsc_group`
--

DROP TABLE IF EXISTS `tsc_group`;
CREATE TABLE `tsc_group` (
  `groupid` smallint(5) NOT NULL,
  `groupname` varchar(50) NOT NULL,
  PRIMARY KEY  (`groupid`),
  UNIQUE KEY `uk_group` (`groupname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `tsc_group_user_link`
--

DROP TABLE IF EXISTS `tsc_group_user_link`;
CREATE TABLE `tsc_group_user_link` (
  `groupid` smallint(5) NOT NULL,
  `username` varchar(60) NOT NULL COMMENT 'User name',
  `role`varchar(255),
  PRIMARY KEY  (`groupid`,`username`,`role`),
  CONSTRAINT `FK_ALLARMI.TSC_USER` FOREIGN KEY (`username`,`role`) REFERENCES `tsc_user` (`username`,`role`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ALLARMI.TSC_GROUP` FOREIGN KEY (`groupid`) REFERENCES `tsc_group` (`groupid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `tsc_user`
--

DROP TABLE IF EXISTS `tsc_user`;
CREATE TABLE `tsc_user` (
  `username` varchar(60) NOT NULL COMMENT 'User name',
  `password` varchar(255),
  `email`varchar(255),
  `role`varchar(255),
  `keyId`varchar(255),
  `base32Secret` varchar(255),
  mfaEnabled TINYINT(1),
  PRIMARY KEY  (`username`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Temporary table structure for view `vw_provecompleanno`
--

DROP TABLE IF EXISTS `vw_provecompleanno`;
/*!50001 DROP VIEW IF EXISTS `vw_provecompleanno`*/;
/*!50001 CREATE TABLE `vw_provecompleanno` (
  `AB_CODI` varchar(10),
  `FOGLIO` varchar(10),
  `GIORNO` char(0),
  `FASCIA` varchar(10),
  `RICHIAMARE` char(0)
) */;

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
    `name` varchar(100) NOT NULL,
    `increment` int(11) NOT NULL DEFAULT 1,
    `min_value` int(11) NOT NULL DEFAULT 1,
    `max_value` bigint(20) NOT NULL DEFAULT 9223372036854775807,
    `cur_value` bigint(20) DEFAULT 1,
    `cycle` boolean NOT NULL DEFAULT FALSE,
    PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Final view structure for view `vw_CentraleUtente`
--

/*!50001 DROP TABLE IF EXISTS `vw_CentraleUtente`*/;
/*!50001 DROP VIEW IF EXISTS `vw_CentraleUtente`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_CentraleUtente` AS select `tsc_user`.`username` AS `tsc_username`,`tsc_group`.`groupname` AS `centrale` from ((`tsc_group` join `tsc_group_user_link` on((`tsc_group`.`groupid` = `tsc_group_user_link`.`groupid`))) join `tsc_user` on((`tsc_group_user_link`.`username` = `tsc_user`.`username`))) */;

--
-- Final view structure for view `vw_provecompleanno`
--

/*!50001 DROP TABLE IF EXISTS `vw_provecompleanno`*/;
/*!50001 DROP VIEW IF EXISTS `vw_provecompleanno`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_provecompleanno` AS select sql_no_cache `anagrafica`.`AB_CODI` AS `AB_CODI`,_latin1'COMPLEANNO' AS `FOGLIO`,_latin1'' AS `GIORNO`,_latin1'COMPLEANNO' AS `FASCIA`,_latin1'' AS `RICHIAMARE` from `anagrafica` where ((substr(`anagrafica`.`DATA_NASCITA`,6,10) = substr(cast(now() as date),6,10)) and (isnull(`anagrafica`.`DATA_DISINSTALLAZIONE`) or (`anagrafica`.`DATA_DISINSTALLAZIONE` = _latin1''))) */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
