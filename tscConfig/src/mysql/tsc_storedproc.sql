-- MySQL dump 10.11
--
-- Host: localhost    Database: telesoccorso
-- ------------------------------------------------------
-- Server version	5.0.45-log

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
-- Dumping routines for database 'telesoccorso'
--
DELIMITER ;;
/*!50003 DROP FUNCTION IF EXISTS `fn_GetDayOfWeek_IT` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `fn_GetDayOfWeek_IT`() RETURNS varchar(10) CHARSET latin1
    DETERMINISTIC
    COMMENT 'restituisce il giorno in italiano, della settimana'
BEGIN
     DECLARE v_Day INT;
     DECLARE v_return VARCHAR(10);
     SELECT DATE_FORMAT(DATE(NOW()),'%w') INTO v_Day;
     CASE
            WHEN v_Day = 0 THEN
                 SET  v_return = 'DOMENICA';
            WHEN v_Day = 1 THEN
                 SET v_return = 'LUNEDI'  ;
            WHEN v_Day = 2 THEN
                 SET v_return = 'MARTEDI';
            WHEN v_Day = 3 THEN
                 SET v_return = 'MERCOLEDI';
            WHEN v_Day = 4 THEN
                 SET v_return = 'GIOVEDI';
            WHEN v_Day = 5 THEN
                 SET v_return = 'VENERDI';
            WHEN v_Day = 6 THEN
                 SET v_return = 'SABATO';
     END CASE;

RETURN v_return;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `fn_RetIDCode` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `fn_RetIDCode`(p_centrale VARCHAR(50)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE v_RetCode CHAR(50);
  DECLARE v_date CHAR(8);
  DECLARE v_time CHAR(8);
  DECLARE v_int1 CHAR(10);
  DECLARE v_int2 CHAR(10);

  SELECT CONCAT(MID(NOW(),1,4),MID(NOW(),6,2),MID(NOW(),9,2)) FROM DUAL INTO v_date;
  SELECT CONCAT(MID(NOW(),12,2),MID(NOW(),15,2),MID(NOW(),18,2)) FROM DUAL INTO v_time;
  SELECT HEX(4294967295 * RAND()) FROM DUAL INTO v_int1;
  SELECT HEX(4294967295 * RAND()) FROM DUAL INTO v_int2;

###############
## Return ID ##
###############

  SET v_RetCode = CONCAT(v_date,v_time,v_int1,v_int2,"_",p_centrale);

  RETURN v_RetCode;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `fn_RetIDProva` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `fn_RetIDProva`(p_AB_CODI VARCHAR(10)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN
  DECLARE v_RetCode CHAR(50);
  DECLARE v_date CHAR(8);
  DECLARE v_time CHAR(8);
  DECLARE v_int1 CHAR(10);
  DECLARE v_int2 CHAR(10);

  SELECT CONCAT(MID(NOW(),1,4),MID(NOW(),6,2),MID(NOW(),9,2)) FROM DUAL INTO v_date;
  SELECT CONCAT(MID(NOW(),12,2),MID(NOW(),15,2),MID(NOW(),18,2)) FROM DUAL INTO v_time;
  SELECT HEX(4294967295 * RAND()) FROM DUAL INTO v_int1;
  SELECT HEX(4294967295 * RAND()) FROM DUAL INTO v_int2;

###############
## Return ID ##
###############

  SET v_RetCode = CONCAT(v_date,v_time,v_int1,v_int2,"_",p_AB_CODI);

  RETURN v_RetCode;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `fn_RetIDProva_from_CodaProve` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `fn_RetIDProva_from_CodaProve`(p_AB_CODI VARCHAR(10)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN

     DECLARE v_ID VARCHAR(50);

###############################################
## seleziona ID della prova dalla coda prove ##
###############################################

     SELECT `coda_prove`.`ID`
     FROM `coda_prove`
     WHERE `coda_prove`.`AB_CODI` = p_AB_CODI
     INTO v_ID;

     RETURN v_ID;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `fn_RetIDProva_from_ProveDay` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `fn_RetIDProva_from_ProveDay`(p_ab_codi VARCHAR(10)) RETURNS varchar(50) CHARSET latin1
    DETERMINISTIC
BEGIN

     DECLARE v_ID VARCHAR(50);

###############################################
## seleziona ID della prova da proveday  ##
###############################################

     SELECT `prove_day`.`ID`
     FROM `prove_day`
     WHERE `prove_day`.`AB_CODI` = p_ab_codi
     INTO v_ID;

     RETURN v_ID;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `new_proc` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `new_proc`(IN p_ente VARCHAR(50), IN p_descrizione VARCHAR(50), IN p_referente VARCHAR(50), IN p_tel_1 VARCHAR(20), IN p_tel_2 VARCHAR(20), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_cap VARCHAR(5))
BEGIN

INSERT INTO `enti` (
ENTE,
DESCRIZIONE,
REFERENTE,
TEL_1,
TEL_2,
INDIRIZZO,
COMUNE,
CAP
)
VALUES
(
p_ente,
p_descrizione,
p_referente,
p_tel_1,
p_tel_2,
p_indirizzo,
p_comune,
p_cap
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_c_CreaFogliProvaDay` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_c_CreaFogliProvaDay`()
BEGIN

## field per il fetch dei dati ##
  DECLARE  c_ID, c_AB_CODI, c_FOGLIO, c_GIORNO, c_FASCIA, c_USER VARCHAR(50);
  DECLARE  c_RICHIAMARE VARCHAR(50);
  DECLARE recordcount INT DEFAULT 0;
  DECLARE done INT DEFAULT 0;

## cursore e handler ##
  DECLARE cur1
          CURSOR FOR
                 SELECT DISTINCT
                        prove.AB_CODI,
                        prove.FOGLIO,
                        prove.GIORNO,
                        prove.FASCIA,
                        prove.RICHIAMARE
          FROM anagrafica
          INNER JOIN prove ON (anagrafica.AB_CODI = prove.AB_CODI)

          WHERE
                (`prove`.`GIORNO`  = (SELECT `fn_GetDayOfWeek_IT`() FROM DUAL))
                AND
                ((anagrafica.DATA_DISINSTALLAZIONE IS NULL)
                OR (anagrafica.DATA_DISINSTALLAZIONE = ''))

          UNION

              SELECT * FROM `vw_provecompleanno`;


  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

        OPEN cur1;

###################################
## TRUNCATE TABLE BEFORE INSERT ###
###################################

        TRUNCATE TABLE prove_day;

        REPEAT

## START TRANSACTION
        START TRANSACTION;

        FETCH cur1 INTO c_AB_CODI, c_FOGLIO, c_GIORNO, c_FASCIA,
        c_RICHIAMARE;

################################
## Genera l' ID Prova univoco ##
################################
          SELECT fn_RetIDCode(c_AB_CODI) INTO c_ID FROM DUAL;


          IF NOT done THEN
             INSERT INTO
               `prove_day`(
               ID,
               AB_CODI,
               FOGLIO,
               GIORNO,
               FASCIA,
               RICHIAMARE)
             VALUES(
               c_ID,
               c_AB_CODI,
               c_FOGLIO,
               c_GIORNO,
               c_FASCIA,
               c_RICHIAMARE
               );
          END IF;
        UNTIL done END REPEAT;

## COMMIT TRANSACTION
        COMMIT;

        CLOSE cur1;

## controlla se esiste Prove day ##
## se esiste sposta in Prove NR  ##
## Drop Prove Day ##
## genere le prove del giorno da tabella solo per gli utenti attivi ##

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_c_SpostaProveDay_in_NR` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_c_SpostaProveDay_in_NR`(IN p_user VARCHAR(50))
BEGIN
## field per il fetch dei dati ##
  DECLARE  c_ID,c_AB_CODI, c_FOGLIO, c_GIORNO, c_FASCIA, c_USER VARCHAR(50);
  DECLARE  c_GESTIONE, c_RICHIAMARE VARCHAR(50);
  DECLARE recordcount INT DEFAULT 0;
  DECLARE done INT DEFAULT 0;
  DECLARE cur1 CURSOR FOR SELECT ID,
                                 AB_CODI,
                                 FOGLIO,
                                 GIORNO,
                                 FASCIA,
                                 USER,
                                 GESTIONE,
                                 RICHIAMARE
                          FROM `prove_day`
                          WHERE prove_day.GESTIONE IN ('NR','OCC','MSG','OK');

  DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;

## controllo se prove e' vuota ##
## controlla se esiste Prove day ##
## se esiste sposta in Prove NR  ##
## 19-05-07 sposta solo le prove del foglio gestito ##

   SELECT COUNT(ID) FROM `prove_day`
   WHERE prove_day.GESTIONE IN ('NR','OCC','MSG','OK')
   AND prove_day.FOGLIO IN
   (SELECT DISTINCT (login_info.`FOGLIO_PROVE`) FROM `login_info`
     WHERE `login_info`.`USER` = p_user)
   INTO recordcount;

   IF (recordcount > 0) THEN

        OPEN cur1;

## START TRANSACTION
       START TRANSACTION;

        REPEAT
        FETCH cur1 INTO c_ID,c_AB_CODI, c_FOGLIO, c_GIORNO, c_FASCIA,
        c_USER, c_GESTIONE, c_RICHIAMARE;
          IF NOT done THEN

             INSERT INTO
               `prove_nr`(
               ID,
               AB_CODI,
               FOGLIO,
               GIORNO,
               FASCIA,
               USER,
               GESTIONE,
               RICHIAMARE)
             VALUES(
               c_ID,
               c_AB_CODI,
               c_FOGLIO,
               c_GIORNO,
               c_FASCIA,
               c_USER,
               c_GESTIONE,
               c_RICHIAMARE
               );

          END IF;
        UNTIL done END REPEAT;

## COMMIT TRANSACTION
        COMMIT;

        CLOSE cur1;

## START TRANSACTION
       START TRANSACTION;
## Drop Prove Day ##
       DELETE
       FROM prove_day
       WHERE prove_day.GESTIONE IN ('NR','OCC','MSG','0K');
## COMMIT TRANSACTION
        COMMIT;

   END IF;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Analisi` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Analisi`(IN p_id INTEGER(11))
BEGIN

DELETE
FROM
  analisi
WHERE
  (analisi.ID = p_ID);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_CodaEve` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_CodaEve`(IN p_ID_Allarme VARCHAR(50))
BEGIN

DELETE
FROM
  `coda_eve`
WHERE
  (`coda_eve`.ID_ALLARME = p_ID_Allarme);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_CodaProve` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_CodaProve`(IN p_ID VARCHAR(50))
BEGIN
## cancella coda prove usando id della prova ##

DELETE
FROM
  coda_prove
WHERE
  (coda_prove.ID = p_ID);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Convivente` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Convivente`(IN p_id INTEGER(11))
BEGIN

DELETE
FROM
  convivente
WHERE
  (convivente.ID = p_ID);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Ente` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Ente`(IN p_id INTEGER(11))
BEGIN

## cancella prova per ID dall' ente ##

DELETE
FROM
  `enti`
WHERE
  (`enti`.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Gmed` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Gmed`(IN p_id INTEGER(11))
BEGIN

DELETE
FROM
  gmed
WHERE
  (gmed.ID = p_ID);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Login` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Login`(IN p_id INTEGER(20))
BEGIN

START TRANSACTION;

DELETE

FROM

`login_info`

WHERE

`login_info`.`ID_LOGIN`= p_id;


COMMIT;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Mdb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Mdb`(IN p_id INTEGER(11))
BEGIN

DELETE
FROM
  medici
WHERE
  (medici.ID = p_id);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_ProvaUtente` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_ProvaUtente`(IN p_IDProva INTEGER)
BEGIN

## cancella prova per ID dalle prove del giorno ##

DELETE
FROM
  `prove`
WHERE
  (`prove`.`ID` = p_IDProva);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_ProveDay` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_ProveDay`(IN p_IDProva VARCHAR(50))
BEGIN

## cancella prova per ID dalle prove del giorno ##

DELETE
FROM
  `prove_day`
WHERE
  (`prove_day`.`ID` = p_IDProva);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_ProveNR` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_ProveNR`(IN p_IDProva VARCHAR(50))
BEGIN

## cancella prova per ID dalle prove del giorno ##

DELETE
FROM
  `prove_nr`
WHERE
  (`prove_nr`.`ID` = p_IDProva);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Soccamici` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Soccamici`(IN p_id INTEGER(11))
BEGIN

DELETE
FROM
  socc_amici
WHERE
  (socc_amici.ID = p_id);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_d_Soccpubb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_d_Soccpubb`(IN p_id INTEGER(11))
BEGIN

DELETE
FROM
  socc_pub
WHERE
  (socc_pub.ID = p_id);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Anagrafica` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Anagrafica`(IN p_ab_codi VARCHAR(10), IN p_matricola VARCHAR(50), IN p_nominativo VARCHAR(50), IN p_sesso VARCHAR(50), IN p_centrale VARCHAR(50), IN p_telefono VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_indirizzo VARCHAR(255), IN p_comune VARCHAR(255), IN p_provincia VARCHAR(2), IN p_cap VARCHAR(50), IN p_tavola VARCHAR(15), IN p_zona VARCHAR(5), IN p_data_nascita DATE, IN p_luogo_nascita VARCHAR(50), IN p_altezza SMALLINT, IN p_peso SMALLINT, IN p_patologia LONGTEXT, IN p_terapia LONGTEXT, IN p_evidenzia LONGTEXT, IN p_note LONGTEXT, IN p_altro LONGTEXT, IN p_dati_abita LONGTEXT, IN p_sopravvivenza VARCHAR(5), IN p_dati_tecnici LONGTEXT, IN p_ente VARCHAR(5))
BEGIN
INSERT INTO
  anagrafica(
AB_CODI,
MATRICOLA,
NOMINATIVO,
SESSO,
CENTRALE,
TELEFONO,
CELLULARE,
INDIRIZZO,
COMUNE,
PROVINCIA,
CAP,
TAVOLA,
ZONA,
DATA_NASCITA,
LUOGO_NASCITA,
ALTEZZA,
PESO,
PATOLOGIA,
TERAPIA,
EVIDENZIA,
NOTE,
ALTRO,
DATI_ABITA,
SOPRAVVIVENZA,
DATI_TECNICI,
DATA_INSERIMENTO,
DATA_INSTALLAZIONE,
ENTE
)
VALUES
(
p_ab_codi,
p_matricola,
p_nominativo,
p_sesso,
p_centrale,
p_telefono,
p_cellulare,
p_indirizzo,
p_comune,
p_provincia,
p_cap,
p_tavola,
p_zona,
p_data_nascita,
p_luogo_nascita,
p_altezza,
p_peso,
p_patologia,
p_terapia,
p_evidenzia,
p_note,
p_altro,
p_dati_abita,
p_sopravvivenza,
p_dati_tecnici,
DATE(NOW()),
DATE(NOW()),
p_ente
);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Analisi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Analisi`(p_ab_codi VARCHAR(10), p_nominativo VARCHAR(50), p_numero VARCHAR(50), p_tel_1 VARCHAR(50), p_tel_2 VARCHAR(50), p_tel_fax VARCHAR(50), p_referente VARCHAR(50), p_cellulare VARCHAR(50), p_orario VARCHAR(50), p_note VARCHAR(50), p_indirizzo VARCHAR(50), p_comune VARCHAR(50), p_prov VARCHAR(50), p_cap VARCHAR(50))
BEGIN
INSERT INTO `analisi`(
AB_CODI,
NOMINATIVO,
NUMERO,
TEL_1,
TEL_2,
FAX,
REFERENTE,
CELLULARE,
ORARIO,
NOTE,
INDIRIZZO,
COMUNE,
PROV,
CAP
)
VALUES
(
p_ab_codi,
p_nominativo,
p_numero,
p_tel_1,
p_tel_2,
p_tel_fax,
p_referente,
p_cellulare,
p_orario,
p_note,
p_indirizzo,
p_comune,
p_prov,
p_cap
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Asi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Asi`(IN p_convenzione VARCHAR(50), IN p_dossier VARCHAR(50), IN p_nominativo VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_telefono VARCHAR(50), IN p_medico VARCHAR(50), IN p_tempo VARCHAR(50), IN p_uscita VARCHAR(50), IN p_note VARCHAR(50), IN p_user VARCHAR(50))
BEGIN
INSERT INTO `asi_gmed`(
DATA,
ORA,
CONVENZIONE,
DOSSIER,
NOMINATIVO,
INDIRIZZO,
COMUNE,
TELEFONO,
MEDICO,
TEMPO,
USCITA,
NOTE,
USER
)
VALUES
(
DATE(NOW()),
TIME(NOW()),
p_convenzione,
p_dossier,
p_nominativo,
p_indirizzo,
p_comune,
p_telefono,
p_medico,
p_tempo,
p_uscita,
p_note,
p_user
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Assenza` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Assenza`(IN p_ab_codi VARCHAR(10), IN p_tipo VARCHAR(50), IN p_note LONGTEXT)
BEGIN
INSERT INTO `assenza`(
AB_CODI,
TIPO,
DATA_ASSENZA,
NOTE
)
VALUES
(
p_ab_codi,
p_tipo,
DATE(NOW()),
p_note
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Coda_prove` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Coda_prove`(IN p_id VARCHAR(50), IN p_ab_codi VARCHAR(10), IN p_user VARCHAR(10))
BEGIN
## insert in CODA_PROVE
   INSERT INTO coda_prove
       (coda_prove.ID,
        coda_prove.AB_CODI,
        coda_prove.ORA,
        coda_prove.USER)
   VALUES (
       p_id,
       p_ab_codi,
       TIME(NOW()),
       p_user);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Convivente` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Convivente`(IN p_ab_codi VARCHAR(10), IN p_nominativo VARCHAR(255), IN p_cointestatario VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_sesso VARCHAR(1), IN p_data_nascita VARCHAR(50), IN p_luogo_nascita VARCHAR(50), IN p_altezza SMALLINT, IN p_peso SMALLINT, IN p_patologia LONGTEXT, IN p_terapia VARCHAR(255), IN p_evidenzia VARCHAR(20), IN p_note LONGTEXT, IN p_parentela VARCHAR(50))
BEGIN
INSERT INTO convivente
(
AB_CODI,
NOMINATIVO,
COINTESTATARIO,
CELLULARE,
SESSO,
DATA_NASCITA,
LUOGO_NASCITA,
ALTEZZA,
PESO,
PATOLOGIA,
TERAPIA,
EVIDENZIA,
NOTE,
PARENTELA
)
VALUES
(
p_ab_codi,
p_nominativo,
p_cointestatario,
p_cellulare,
p_sesso,
p_data_nascita,
p_luogo_nascita,
p_altezza,
p_peso,
p_patologia,
p_terapia,
p_evidenzia,
p_note,
p_parentela
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Ente` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Ente`(IN p_ente VARCHAR(50), IN p_descrizione VARCHAR(50), IN p_tel_1 VARCHAR(50), IN p_tel_2 VARCHAR(50), IN p_referente VARCHAR(50), IN p_comune VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_cap VARCHAR(5))
BEGIN
INSERT INTO `enti` (
ENTE,
DESCRIZIONE,
TEL_1,
TEL_2,
REFERENTE,
COMUNE,
INDIRIZZO,
CAP
)
VALUES
(
p_ente,
p_descrizione,
p_tel_1,
p_tel_2,
p_referente,
p_comune,
p_indirizzo,
p_cap
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_GeneraAllarme` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_GeneraAllarme`(p_ab_codi VARCHAR(10), p_matricola VARCHAR(50), p_mux VARCHAR(50), p_evento VARCHAR(10), p_centrale VARCHAR(50))
BEGIN

  DECLARE v_id VARCHAR(50) DEFAULT "";

##################################
## Genera l' ID Allarme univoco ##
##################################
SELECT fn_RetIDCode(p_centrale) INTO v_id FROM DUAL;

####################################################
## insert in `STORICO_EVENTI` (tutti gli allarmi) ##
####################################################

## START TRANSACTION
   START TRANSACTION;

   INSERT INTO storico_eventi
          (storico_eventi.ID_ALLARME,
          storico_eventi.AB_CODI,
          storico_eventi.MATRICOLA,
          storico_eventi.MUX,
          storico_eventi.EVENTO,
          storico_eventi.DATA,
          storico_eventi.ORA)
   VALUES(v_id,
          p_ab_codi,
          p_matricola,
          p_mux,
          p_evento,
          DATE(NOW()),
          TIME(NOW()));

## insert in CODA_EVE
   INSERT INTO coda_eve
        (coda_eve.ID_ALLARME,
        coda_eve.AB_CODI,
        coda_eve.MATRICOLA,
        coda_eve.EVENTO,
        coda_eve.DATA,
        coda_eve.ORA,
        coda_eve.USER)
   VALUES (v_id,
       p_ab_codi,
       p_matricola,
       p_evento,
       DATE(NOW()),
       TIME(NOW()),
       "");

## COMMIT TRANSACTION
         COMMIT;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_GestioneProva` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_GestioneProva`(IN p_ID VARCHAR(50), IN p_Tipo_Allarme VARCHAR(10), IN p_User VARCHAR(50))
    COMMENT 'Gestione della prova elencata in Prove Day'
BEGIN

  DECLARE v_user VARCHAR(50);
  DECLARE v_ab_codi VARCHAR(10);
  DECLARE v_id VARCHAR(50);
  DECLARE v_idprova VARCHAR(50);

###################
## Prenota prova ##
###################

SELECT
      prove_day.`USER`
  FROM
         `prove_day`
WHERE
     (prove_day.`ID` = p_id)
INTO
v_user;

## se non prenotata , update ##
IF (v_user = "") OR (v_user = NULL) THEN
       UPDATE prove_day
       SET
             prove_day.USER = p_user

       WHERE
            (prove_day.`ID` = p_id);
END IF;

################################################
## cerca user ed ID allarme nella coda eventi ##
################################################

  SELECT `prove_day`.USER,
         `prove_day`.AB_CODI,
         `prove_day`.ID
  FROM
         `prove_day`
  WHERE
         `prove_day`.ID = p_ID
  AND
        `prove_day`.`USER` = p_User
  INTO
         v_user,v_ab_codi,v_id;

#############################################
####### CERCA PRENOTAZIONE PROVE_DAY ######
#############################################
## allarme non prenotato, user = ""

  IF (v_user = p_User) THEN

###################################################
####### INSERIMENTO IN ALLARMI CON CASE  ##########
###################################################

  CASE

####################################
## trovato ##
####################################

      WHEN (p_Tipo_Allarme = "OK") THEN
## START TRANSACTION
        START TRANSACTION;

           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_Prove_day(v_id,v_ab_codi,p_Tipo_Allarme,p_user);

## COMMIT
        COMMIT;

####################################
## messaggio segreteria ##
####################################

      WHEN (p_Tipo_Allarme = "MSG") THEN
## START TRANSACTION
        START TRANSACTION;

           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_Prove_day(v_id,v_ab_codi,p_Tipo_Allarme,p_user);

## COMMIT
        COMMIT;

####################################
## non risponde ##
####################################

      WHEN (p_Tipo_Allarme = "NR") THEN
## START TRANSACTION
        START TRANSACTION;

           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_Prove_day(v_id,v_ab_codi,p_Tipo_Allarme,p_user);

## COMMIT
        COMMIT;

####################################
## occupato ##
####################################

      WHEN (p_Tipo_Allarme = "OCC") THEN
## START TRANSACTION
        START TRANSACTION;

           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_Prove_day(v_id,v_ab_codi,p_Tipo_Allarme,p_user);

## COMMIT
        COMMIT;

####################################
## contatto telefonico ##
####################################

      WHEN (p_Tipo_Allarme = "CT") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_GestioneAllarme(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_idprova);
## COMMIT
        COMMIT;

####################################
## Da Non Fare ##
####################################

      WHEN (p_Tipo_Allarme = "DNF") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_GestioneAllarme(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_idprova);
## COMMIT
        COMMIT;

####################################
## ASSENZA ##
####################################

      WHEN (p_Tipo_Allarme = "ASS") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_GestioneAllarme(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_idprova);
## COMMIT
        COMMIT;

####################################
## RICOVERO ##
####################################

      WHEN (p_Tipo_Allarme = "RIC") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_d_ProveDay(v_idprova);
## COMMIT
        COMMIT;


######################################
## avaria, da prove ##
######################################

      WHEN (p_Tipo_Allarme = "A") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_GestioneAllarme(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_idprova);
## COMMIT
        COMMIT;

  END CASE;
  END IF;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Gmed` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Gmed`(p_ab_codi VARCHAR(10), p_nominativo VARCHAR(50), p_tel_1 VARCHAR(50), p_tel_2 VARCHAR(50), p_numero VARCHAR(50), p_referente VARCHAR(50), p_cellulare VARCHAR(50), p_tipo VARCHAR(50), p_note VARCHAR(50), p_orario VARCHAR(50))
BEGIN
INSERT INTO gmed (
AB_CODI,
NOMINATIVO,
TEL_1,
TEL_2,
NUMERO,
REFERENTE,
CELLULARE,
TIPO,
NOTE,
ORARIO
)
VALUES
(
p_ab_codi,
p_nominativo,
p_tel_1,
p_tel_2,
p_numero,
p_referente,
p_cellulare,
p_tipo,
p_note,
p_orario
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Infermieri` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Infermieri`(IN p_convenzione VARCHAR(50), IN p_dossier VARCHAR(50), IN p_nominativo VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_telefono VARCHAR(50), IN p_infermiere VARCHAR(50), IN p_tempo VARCHAR(50), IN p_uscita VARCHAR(50), IN p_note VARCHAR(50), IN p_user VARCHAR(50))
BEGIN
INSERT INTO `infermieri`(
DATA,
ORA,
CONVENZIONE,
DOSSIER,
NOMINATIVO,
INDIRIZZO,
COMUNE,
TELEFONO,
INFERMIERE,
TEMPO,
USCITA,
NOTE,
USER
)
VALUES
(
DATE(NOW()),
TIME(NOW()),
p_convenzione,
p_dossier,
p_nominativo,
p_indirizzo,
p_comune,
p_telefono,
p_infermiere,
p_tempo,
p_uscita,
p_note,
p_user
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_InsertAllarmi_in_Allarmi` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_InsertAllarmi_in_Allarmi`(IN p_id VARCHAR(50), IN p_idprova INTEGER(11), IN p_ab_codi VARCHAR(10), IN p_evento VARCHAR(50), IN p_user VARCHAR(50))
BEGIN
INSERT INTO `allarmi`(
ID_ALLARME,
ID_PROVA,
AB_CODI,
EVENTO,
USER,
DATA,
ORA
)
VALUES
(
p_id,
p_idprova,
p_ab_codi,
p_evento,
p_user,
DATE(NOW()),
TIME(NOW())
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_InsertAllarmi_in_CodaEve` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_InsertAllarmi_in_CodaEve`(p_matricola VARCHAR(10), p_evento VARCHAR(50), p_centrale VARCHAR(50), p_mux VARCHAR(10), p_ritardo VARCHAR(2))
    COMMENT 'SP inserimento allarme in coda_eventi dallo schedulatore, inseri'
BEGIN

  DECLARE v_id VARCHAR(50) DEFAULT "";
  DECLARE v_ab_codi VARCHAR(10) DEFAULT "";
  DECLARE v_nominativo VARCHAR(50) DEFAULT "";
  DECLARE v_evento VARCHAR(50); ## tipo allarme, se "1" allora allarme reale

################################################
## Select nominativo ed ab_codi dall anagraf. ##
################################################

  SELECT SQL_CACHE anagrafica.AB_CODI,
         anagrafica.NOMINATIVO
  FROM anagrafica
  WHERE anagrafica.MATRICOLA = p_matricola
  INTO v_ab_codi,v_nominativo;

## check se non risulta associata
  IF (v_ab_codi = "" OR v_ab_codi = NULL) THEN
     SET v_ab_codi = '??????';
     SET v_nominativo = 'NON ASSOCIATO';
  END IF;

##################################
## Genera l' ID Allarme univoco ##
##################################
SELECT fn_RetIDCode(p_centrale) INTO v_id FROM DUAL;

####################################################
## insert in `STORICO_EVENTI` (tutti gli allarmi) ##
####################################################

## START TRANSACTION
   START TRANSACTION;

   INSERT INTO storico_eventi
          (storico_eventi.ID_ALLARME,
          storico_eventi.AB_CODI,
          storico_eventi.MATRICOLA,
          storico_eventi.MUX,
          storico_eventi.EVENTO,
          storico_eventi.DATA,
          storico_eventi.ORA,
          storico_eventi.RITARDO)
   VALUES(v_id,
          v_ab_codi,
          p_matricola,
          p_mux,
          p_evento,
          DATE(NOW()),
          TIME(NOW()),
          p_ritardo);

## COMMIT TRANSACTION
   COMMIT;

############################################
####### INSERIMENTO ALLARME REALE ##########
############################################
## controlla se l' allarme Ã¨ un allarme reale ( LIVELLO_ALLARME = "ON")
## se vero lo inserisce nella coda eventi



   SELECT SQL_CACHE eventi_allarme.LIVELLO_ALLARME
   FROM eventi_allarme
   WHERE eventi_allarme.EVENTO = p_evento
   INTO v_evento;

IF (v_evento = "ON") THEN

## START TRANSACTION
   START TRANSACTION;

## insert in CODA_EVE
   INSERT INTO coda_eve
        (coda_eve.ID_ALLARME,
        coda_eve.AB_CODI,
        coda_eve.MATRICOLA,
        coda_eve.EVENTO,
        coda_eve.NOMINATIVO,
        coda_eve.DATA,
        coda_eve.ORA,
        coda_eve.USER)
   VALUES (v_id,
       v_ab_codi,
       p_matricola,
       p_evento,
       v_nominativo,
       DATE(NOW()),
       TIME(NOW()),
       "");

## COMMIT TRANSACTION
   COMMIT;

END IF;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_InsertAllarmi_in_CodaEve_Brondi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_InsertAllarmi_in_CodaEve_Brondi`(IN p_telefono VARCHAR(20), IN p_filename VARCHAR(100), IN p_centrale VARCHAR(50))
    COMMENT 'SP inserimento allarme in coda_eventi dallo schedulatore, per la'
BEGIN

  DECLARE v_id VARCHAR(50) DEFAULT ""; ## id univoco generato dal sistema
  DECLARE v_ab_codi VARCHAR(10) DEFAULT "";
  DECLARE v_nominativo VARCHAR(50) DEFAULT "";
  DECLARE v_telefono VARCHAR(20) DEFAULT "";
  DECLARE v_matricola VARCHAR(20) DEFAULT "";
  DECLARE v_mux VARCHAR(20) DEFAULT "INFAMIGLIA-0";
  DECLARE v_count INT DEFAULT 0 ;

################################################
## Select di verifica esistenza numero tel    ##
################################################

   SELECT COUNT(anagrafica.AB_CODI)
   FROM anagrafica
   WHERE anagrafica.TELEFONO = p_telefono
   INTO v_count;

## check se non e' associata
  IF (v_count = 0) THEN
     SET v_ab_codi = '??????';
     SET v_nominativo = 'NON ASSOCIATO';
  ELSE

      ################################################
      ## Select nominativo ed ab_codi dall anagraf. ##
      ################################################

      SELECT anagrafica.AB_CODI,
         anagrafica.NOMINATIVO,
         anagrafica.`TELEFONO`,
         anagrafica.`CENTRALE`,
         anagrafica.`MATRICOLA`
      FROM anagrafica
      WHERE anagrafica.`TELEFONO` = p_telefono
      INTO   v_ab_codi,
         v_nominativo,
         v_telefono,
         p_centrale,
         v_matricola;

  END IF;


##################################
## Genera l' ID Allarme univoco ##
##################################
SELECT fn_RetIDCode(p_centrale) INTO v_id FROM DUAL;

####################################################
## insert in `STORICO_EVENTI` (tutti gli allarmi) ##
####################################################

## START TRANSACTION
   START TRANSACTION;

   INSERT INTO storico_eventi
          (storico_eventi.ID_ALLARME,
          storico_eventi.AB_CODI,
          storico_eventi.MATRICOLA,
          storico_eventi.MUX,
          storico_eventi.EVENTO,
          storico_eventi.DATA,
          storico_eventi.ORA,
          storico_eventi.RITARDO)
   VALUES(v_id,
          v_ab_codi,
          v_matricola,
          v_mux,
          'Tel',
          DATE(NOW()),
          TIME(NOW()),
          0);

## COMMIT TRANSACTION
   COMMIT;

############################################
####### INSERIMENTO ALLARME IN CODA_EVE ##########
############################################
## l' allarme e' sempre un allarme reale ( LIVELLO_ALLARME = "ON")

## START TRANSACTION
   START TRANSACTION;
## insert in CODA_EVE
   INSERT INTO coda_eve
        (coda_eve.ID_ALLARME,
        coda_eve.AB_CODI,
        coda_eve.MATRICOLA,
        coda_eve.EVENTO,
        coda_eve.NOMINATIVO,
        coda_eve.DATA,
        coda_eve.ORA,
        coda_eve.USER,
        coda_eve.TELEFONO,
        coda_eve.FILENAME)
   VALUES (v_id,
       v_ab_codi,
       v_matricola,
       'Tel',
       v_nominativo,
       DATE(NOW()),
       TIME(NOW()),
       "",
       p_telefono,
       CONCAT( p_filename, ' .wav'));

## COMMIT TRANSACTION
   COMMIT;

-- SELECT v_count,v_id,v_ab_codi,v_nominativo,v_telefono,v_centrale,v_matricola FROM DUAL;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_InsertAllarmi_in_CodaEve_Italtel` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_InsertAllarmi_in_CodaEve_Italtel`(IN p_matricola VARCHAR(10), IN p_evento VARCHAR(15), IN p_centrale VARCHAR(50), IN p_mux VARCHAR(5), IN p_ritardo VARCHAR(2))
BEGIN

  DECLARE v_id VARCHAR(50) DEFAULT "";
  DECLARE v_ab_codi VARCHAR(10) DEFAULT "";
  DECLARE v_nominativo VARCHAR(50) DEFAULT "";
  DECLARE v_evento VARCHAR(50); ## tipo allarme, se "1" allora allarme reale

################################################
## Select nominativo ed ab_codi dall anagraf. ##
################################################

  SELECT SQL_CACHE anagrafica.AB_CODI,
         anagrafica.NOMINATIVO
  FROM anagrafica
  WHERE anagrafica.MATRICOLA = p_matricola
  INTO v_ab_codi,v_nominativo;

## check se non risulta associata
  IF (v_ab_codi = "" OR v_ab_codi = NULL) THEN
     SET v_ab_codi = '??????';
     SET v_nominativo = 'NON ASSOCIATO';
  END IF;

##################################
## Genera l' ID Allarme univoco ##
##################################
SELECT fn_RetIDCode(p_centrale) INTO v_id FROM DUAL;

####################################################
## insert in `STORICO_EVENTI` (tutti gli allarmi) ##
####################################################

## START TRANSACTION
   START TRANSACTION;

   INSERT INTO storico_eventi
          (storico_eventi.ID_ALLARME,
          storico_eventi.AB_CODI,
          storico_eventi.MATRICOLA,
          storico_eventi.MUX,
          storico_eventi.EVENTO,
          storico_eventi.DATA,
          storico_eventi.ORA,
          storico_eventi.RITARDO)
   VALUES(v_id,
          v_ab_codi,
          p_matricola,
          p_mux,
          p_evento,
          DATE(NOW()),
          TIME(NOW()),
          p_ritardo);

## COMMIT TRANSACTION
   COMMIT;

############################################
####### INSERIMENTO ALLARME REALE ##########
############################################
## controlla se l' allarme e' un allarme reale ( LIVELLO_ALLARME = "ON")
## se vero lo inserisce nella coda eventi



   SELECT SQL_CACHE eventi_allarme.LIVELLO_ALLARME
   FROM eventi_allarme
   WHERE eventi_allarme.EVENTO = p_evento
   INTO v_evento;

IF (v_evento = "ON") THEN

## START TRANSACTION
   START TRANSACTION;

## insert in CODA_EVE
   INSERT INTO coda_eve
        (coda_eve.ID_ALLARME,
        coda_eve.AB_CODI,
        coda_eve.MATRICOLA,
        coda_eve.EVENTO,
        coda_eve.NOMINATIVO,
        coda_eve.DATA,
        coda_eve.ORA,
        coda_eve.USER)
   VALUES (v_id,
       v_ab_codi,
       p_matricola,
       p_evento,
       v_nominativo,
       DATE(NOW()),
       TIME(NOW()),
       "");

## COMMIT TRANSACTION
   COMMIT;

END IF;

   ###########################################
   ## restituisce ab_codi per lo scheduler ###
   ###########################################
   SELECT v_ab_codi AS AB_CODI FROM DUAL;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_InsertProve` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_InsertProve`(IN p_ab_codi VARCHAR(50), IN p_giorno VARCHAR(50), IN p_foglio VARCHAR(50), IN p_fascia VARCHAR(50), IN p_note VARCHAR(50), IN p_richiamare VARCHAR(50))
BEGIN
INSERT INTO prove
(
AB_CODI,
GIORNO,
FOGLIO,
FASCIA,
NOTE,
RICHIAMARE
)
VALUES
(
p_ab_codi,
p_giorno,
p_foglio,
p_fascia,
p_note,
p_richiamare
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Login` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Login`(IN p_user VARCHAR(50), IN p_foglio VARCHAR(50))
BEGIN
INSERT INTO `login_info`
(
`login_info`.`USER`,
`login_info`.`FOGLIO_PROVE`
)
VALUES
(
p_user,
p_foglio
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Mdb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Mdb`(p_ab_codi VARCHAR(10), p_medico VARCHAR(50), p_indirizzo VARCHAR(50), p_comune VARCHAR(50), p_tel_amb VARCHAR(50), p_tel_casa VARCHAR(50), p_tel_cell VARCHAR(50), p_numero VARCHAR(50), p_specialista VARCHAR(50), p_orario VARCHAR(50))
BEGIN
INSERT INTO medici (
AB_CODI,
MEDICO,
INDIRIZZO,
COMUNE,
TEL_AMB,
TEL_CASA,
TEL_CELL,
NUMERO,
SPECIALISTA,
ORARIO
)
VALUES
(
p_ab_codi,
p_medico,
p_indirizzo,
p_comune,
p_tel_amb,
p_tel_casa,
p_tel_cell,
p_numero,
p_specialista,
p_orario
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Pediatrica` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Pediatrica`(IN p_convenzione VARCHAR(50), IN p_dossier VARCHAR(50), IN p_nominativo VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_telefono VARCHAR(50), IN p_medico VARCHAR(50), IN p_tempo VARCHAR(50), IN p_uscita VARCHAR(50), IN p_note VARCHAR(50), IN p_user VARCHAR(50))
BEGIN
INSERT INTO `pediatrica`(
DATA,
ORA,
CONVENZIONE,
DOSSIER,
NOMINATIVO,
INDIRIZZO,
COMUNE,
TELEFONO,
MEDICO,
TEMPO,
USCITA,
NOTE,
USER
)
VALUES
(
DATE(NOW()),
TIME(NOW()),
p_convenzione,
p_dossier,
p_nominativo,
p_indirizzo,
p_comune,
p_telefono,
p_medico,
p_tempo,
p_uscita,
p_note,
p_user
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Soccamici` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Soccamici`(p_ab_codi VARCHAR(10), p_nominativo VARCHAR(255), p_tel_casa VARCHAR(50), p_tel_uff VARCHAR(50), p_tel_cell VARCHAR(50), p_tempo_casa VARCHAR(50), p_tempo_uff VARCHAR(50), p_chiavi VARCHAR(50), p_coinquilino VARCHAR(50), p_parente VARCHAR(50), p_numero VARCHAR(50))
BEGIN
INSERT INTO socc_amici
(
AB_CODI,
NOMINATIVO,
TEL_CASA,
TEL_UFF,
TEL_CELL,
TEMPO_CASA,
TEMPO_UFF,
CHIAVI,
COINQUILINO,
PARENTE,
NUMERO
)
VALUES
(
p_ab_codi,
p_nominativo,
p_tel_casa,
p_tel_uff,
p_tel_cell,
p_tempo_casa,
p_tempo_uff,
p_chiavi,
p_coinquilino,
p_parente,
p_numero
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Soccpubb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Soccpubb`(IN p_ab_codi VARCHAR(10), IN p_tipo VARCHAR(50), IN p_tel_1 VARCHAR(50), IN p_tel_2 VARCHAR(50), IN p_numero VARCHAR(50), IN p_cellulare VARCHAR(50))
BEGIN
INSERT INTO socc_pub
(
AB_CODI,
TIPO,
TEL_1,
TEL_2,
NUMERO,
CELLULARE
)
VALUES
(
p_ab_codi,
p_tipo,
p_tel_1,
p_tel_2,
p_numero,
p_cellulare
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_i_Stipulante` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_i_Stipulante`(IN p_ab_codi VARCHAR(10), IN p_nominativo VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_prov VARCHAR(50), IN p_cap VARCHAR(50), IN p_telefono VARCHAR(50), IN p_cellulare VARCHAR(50))
BEGIN
INSERT INTO stipulante(
AB_CODI,
NOMINATIVO,
INDIRIZZO,
COMUNE,
PROV,
CAP,
TELEFONO,
CELLULARE
)
VALUES
(
p_ab_codi,
p_nominativo,
p_indirizzo,
p_comune,
p_prov,
p_cap,
p_telefono,
p_cellulare
);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_AllarmeChiuso` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_AllarmeChiuso`(IN p_id_allarme VARCHAR(50))
BEGIN
UPDATE `allarmi`
SET
  `allarmi`.DATA_CHIUSO = DATE(NOW()),
  `allarmi`.ORA_CHIUSO = TIME(NOW())
WHERE
  (`allarmi`.ID_ALLARME = p_id_allarme);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Anagrafica` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Anagrafica`(IN p_ab_codi VARCHAR(10), IN p_matricola VARCHAR(50), IN p_nominativo VARCHAR(50), IN p_sesso VARCHAR(50), IN p_centrale VARCHAR(50), IN p_telefono VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_ente VARCHAR(5))
BEGIN
UPDATE anagrafica
SET
  anagrafica.MATRICOLA = p_matricola,
  anagrafica.NOMINATIVO = p_nominativo,
  anagrafica.SESSO = p_sesso,
  anagrafica.CENTRALE = p_centrale,
  anagrafica.TELEFONO = p_telefono,
  anagrafica.CELLULARE = p_cellulare,
  anagrafica.DATA_MODIFICA = DATE(NOW()),
  anagrafica.ENTE = p_ente

WHERE
  (anagrafica.AB_CODI = p_ab_codi);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Analisi` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Analisi`(IN p_id INTEGER(11), IN p_nominativo VARCHAR(50), IN p_numero VARCHAR(50), IN p_tel_1 VARCHAR(50), IN p_tel_2 VARCHAR(50), IN p_tel_fax VARCHAR(50), IN p_referente VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_orario VARCHAR(50), IN p_note VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_prov VARCHAR(50), IN p_cap VARCHAR(50))
BEGIN
UPDATE `analisi`
SET
`analisi`.NOMINATIVO = p_nominativo,
`analisi`.NUMERO = p_numero,
`analisi`.TEL_1 = p_tel_1,
`analisi`.TEL_2 = p_tel_2,
`analisi`.FAX = p_tel_fax,
`analisi`.REFERENTE = p_referente,
`analisi`.CELLULARE = p_cellulare,
`analisi`.ORARIO = p_orario,
`analisi`.NOTE = p_note,
`analisi`.INDIRIZZO = p_indirizzo,
`analisi`.COMUNE = p_comune,
`analisi`.PROV = p_prov,
`analisi`.CAP = p_cap

WHERE
(`analisi`.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Asi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Asi`(IN p_id INTEGER(11), IN p_diagnosi LONGTEXT, IN p_terapia LONGTEXT, IN p_prognosi LONGTEXT)
BEGIN
UPDATE `asi_gmed`
SET
`asi_gmed`.`DIAGNOSI` = p_diagnosi,
`asi_gmed`.`TERAPIA` = p_terapia,
`asi_gmed`.`PROGNOSI` = p_prognosi,
`asi_gmed`.`DATA_CHIUSO` = DATE(NOW()),
`asi_gmed`.`ORA_CHIUSO`= TIME(NOW())

WHERE
(`asi_gmed`.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Codaprove` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Codaprove`(p_ab_codi VARCHAR(10), p_user VARCHAR(50))
    COMMENT 'Usata per il cambio utente, da non confondere con la insert'
BEGIN
UPDATE `coda_prove`
SET
`coda_prove`.`USER` = p_user
WHERE
(`coda_prove`.`AB_CODI` = p_ab_codi);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Coda_Eve` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Coda_Eve`(p_user VARCHAR(50), p_id VARCHAR(50))
BEGIN
UPDATE `coda_eve`
SET
coda_eve.`USER`= p_user
WHERE
coda_eve.`ID` = p_id;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Convivente` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Convivente`(IN p_id VARCHAR(50), IN p_ab_codi VARCHAR(10), IN p_nominativo VARCHAR(255), IN p_cointestatario VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_sesso VARCHAR(1), IN p_data_nascita VARCHAR(50), IN p_luogo_nascita VARCHAR(50), IN p_altezza SMALLINT, IN p_peso SMALLINT, IN p_patologia LONGTEXT, IN p_terapia VARCHAR(255), IN p_evidenzia VARCHAR(20), IN p_note LONGTEXT, IN p_parentela VARCHAR(50))
BEGIN
UPDATE convivente
SET
  convivente.NOMINATIVO = p_nominativo,
  convivente.COINTESTATARIO = p_cointestatario,
  convivente.CELLULARE = p_cellulare,
  convivente.SESSO = p_sesso,
  convivente.DATA_NASCITA = p_data_nascita,
  convivente.LUOGO_NASCITA = p_luogo_nascita,
  convivente.ALTEZZA = p_altezza,
  convivente.PESO = p_peso,
  convivente.PATOLOGIA = p_patologia,
  convivente.TERAPIA = p_terapia,
  convivente.EVIDENZIA = p_evidenzia,
  convivente.NOTE = p_note,
  convivente.PARENTELA = p_parentela
WHERE
  (convivente.AB_CODI = p_ab_codi) AND (convivente.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Disinstallazione` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Disinstallazione`(IN p_ab_codi VARCHAR(10), IN p_motivo VARCHAR(50))
BEGIN
UPDATE anagrafica
SET
  anagrafica.`MATRICOLA` = '######',
  anagrafica.DATA_DISINSTALLAZIONE = DATE(NOW()),
  anagrafica.MOTIVO_DISINSTALLAZIONE = p_motivo
WHERE
  (anagrafica.AB_CODI = p_ab_codi);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Ente` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Ente`(IN p_id INTEGER(11), IN p_ente VARCHAR(5), IN p_descrizione VARCHAR(50), IN p_referente VARCHAR(50), IN p_tel_1 VARCHAR(20), IN p_tel_2 VARCHAR(20), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_cap VARCHAR(5))
BEGIN
UPDATE enti
SET
enti.`ENTE` = p_ente,
enti.`DESCRIZIONE` = p_descrizione,
enti.`REFERENTE` = p_referente,
enti.`TEL_1` = p_tel_1,
enti.`TEL_2` = p_tel_2,
enti.`INDIRIZZO` = p_indirizzo,
enti.`COMUNE` = p_comune,
enti.`CAP` = p_cap

WHERE
(enti.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Enti` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Enti`(IN p_id INTEGER(11), IN p_ente VARCHAR(5), IN p_descrizione VARCHAR(50), IN p_referente VARCHAR(50), IN p_tel_1 VARCHAR(20), IN p_tel_2 VARCHAR(20), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_cap VARCHAR(5))
BEGIN
UPDATE enti
SET
enti.`ENTE` = p_ente,
enti.`DESCRIZIONE` = p_descrizione,
enti.`REFERENTE` = p_referente,
enti.`TEL_1` = p_tel_1,
enti.`TEL_2` = p_tel_2,
enti.`INDIRIZZO` = p_indirizzo,
enti.`COMUNE` = p_comune,
enti.`CAP` = p_cap

WHERE
(enti.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_EsitoAllarme` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_EsitoAllarme`(IN p_ID VARCHAR(50), IN p_ID_Prova VARCHAR(50), IN p_AB_CODI VARCHAR(10), IN p_Esito VARCHAR(5))
BEGIN


IF (p_Esito = "C") OR (p_Esito = "P") OR (p_Esito = "CT") OR (p_Esito = "E") THEN

######################################################
## chiude allarme e inserisce le conclusioni uguali alle note di anagrafica
######################################################

   UPDATE
       `allarmi`
   SET
      `allarmi`.`ESITO` = p_Esito,
      `allarmi`.`DATA_ESITO` = CURRENT_TIMESTAMP,
      `allarmi`.`ID_PROVA` = p_ID_Prova,
      `allarmi`.`CONCLUSIONI` = p_ID_Prova,
      `allarmi`.`DATA_CHIUSO` = DATE(NOW()),
      `allarmi`.`ORA_CHIUSO` = TIME(NOW())
   WHERE
      `allarmi`.`ID_ALLARME` = p_ID;

END IF;


IF (p_Esito = "DNF") OR (p_Esito = "ASS") OR (p_Esito = "RIC") THEN

######################################################
## chiude allarme e mette conlusioni uguali al campo note di anagrafica
######################################################

   UPDATE
       `allarmi`
   SET
      `allarmi`.`ESITO` = p_Esito,
      `allarmi`.`DATA_ESITO` = CURRENT_TIMESTAMP,
      `allarmi`.`ID_PROVA` = p_ID_Prova,
      `allarmi`.`CONCLUSIONI` = p_ID_Prova,
      `allarmi`.`DATA_CHIUSO` = DATE(NOW()),
      `allarmi`.`ORA_CHIUSO` = TIME(NOW())
   WHERE
      `allarmi`.`ID_ALLARME` = p_ID;

END IF;


IF (p_Esito = "T") OR (p_Esito = "A") OR (p_Esito = "R") OR (p_Esito = "RT") OR (p_Esito = "S")
OR (p_Esito = "ST") THEN

######################################################
## se caso  sopra chiude allarme (data, ora)
######################################################

   UPDATE
       `allarmi`
   SET
      `allarmi`.`ESITO` = p_Esito,
      `allarmi`.`DATA_ESITO` = CURRENT_TIMESTAMP,
      `allarmi`.`ID_PROVA` = p_ID_Prova
   WHERE
       `allarmi`.`ID_ALLARME` = p_ID;

END IF;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_GestioneAllarme` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_GestioneAllarme`(IN p_ID_Allarme VARCHAR(50), IN p_Tipo_Allarme VARCHAR(10), IN p_User VARCHAR(50))
    COMMENT 'Stored Procedure di gestione allarme gestisce gli Esiti P,C,E,R,'
BEGIN

  DECLARE v_user VARCHAR(50);
  DECLARE v_ab_codi VARCHAR(10);
  DECLARE v_id VARCHAR(50);
  DECLARE v_idprova VARCHAR(50);
  DECLARE v_error_message INTEGER;

###############################################
## cerca user ed ID allarme nella coda eventi ##
################################################

  SELECT coda_eve.USER,
         coda_eve.AB_CODI,
         coda_eve.ID_ALLARME
  FROM
         coda_eve
  WHERE
         coda_eve.ID_ALLARME = p_ID_Allarme
  AND
        `coda_eve`.`USER` = p_User
  INTO
         v_user,v_ab_codi,v_id;

#############################################
####### CERCA PRENOTAZIONE CODA EVENTI ######
#############################################
## allarme non prenotato, user = ""

  IF (v_user = p_User) THEN

###################################################
####### INSERIMENTO IN ALLARMI CON CASE  ##########
###################################################

  CASE
#######################
## prova da centrale ##
## ricava ID prova da coda prove
## aggiorna allarme con ID prova ed esito e chiude allarme
## cancella la prova da prove del giorno
## cancella la prova da coda prove
## cancella allarme da coda eventi
#######################

      WHEN (p_Tipo_Allarme = "C") THEN
## START TRANSACTION
        START TRANSACTION;
           SELECT fn_RetIDProva_from_CodaProve(v_ab_codi) INTO v_idprova FROM DUAL;
           CALL sp_u_EsitoAllarme(v_id,v_idprova,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_idprova);
           CALL sp_d_ProveNR(v_idprova);
           CALL sp_d_CodaProve(v_idprova);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

#######################
## anticipo prova  ##
## ricava ID prova da prove_day
## aggiorna allarme con ID prova ed esito e chiude allarme
## cancella la prova da prove del giorno
## cancella allarme da coda eventi
#######################

      WHEN (p_Tipo_Allarme = "Cc") THEN
## START TRANSACTION
        START TRANSACTION;
           SELECT `fn_RetIDProva_from_ProveDay`(v_ab_codi) INTO v_idprova FROM DUAL;
           CALL sp_u_EsitoAllarme(v_id,v_idprova,v_ab_codi,"C");
           CALL sp_d_ProveDay(v_idprova);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;



################################
## prova da centrale , errore ##
################################

      WHEN (p_Tipo_Allarme = "E") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

######################################
## prova da centrale , Prova utente ##
######################################

      WHEN (p_Tipo_Allarme = "P") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

######################################
## allarme reale   ##
######################################

      WHEN (p_Tipo_Allarme = "R") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

######################################
## allarme reale  , telefonico ##
######################################

      WHEN (p_Tipo_Allarme = "RT") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

######################################
## allarme sociale
######################################

      WHEN (p_Tipo_Allarme = "S") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

######################################
## allarme sociale, telefonico
######################################

      WHEN (p_Tipo_Allarme = "ST") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

######################################
##  da allarme, intervento tecn.
######################################

      WHEN (p_Tipo_Allarme = "T") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_EsitoAllarme(v_id,"",v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_CodaEve(v_id);
## COMMIT
        COMMIT;

  END CASE;

  ## azzera errore ##
      SET v_error_message = 0;
      SELECT v_error_message FROM DUAL;

  ELSE
## ritorna errore ##
      SET v_error_message = 90000;
      SELECT v_error_message FROM DUAL;
  END IF;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_GestioneCodaProve` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_GestioneCodaProve`(IN p_ID VARCHAR(50), IN p_Tipo_Allarme VARCHAR(10), IN p_User VARCHAR(50))
    COMMENT 'Gestione della prova elencata in Prove Day'
BEGIN

  DECLARE v_user VARCHAR(50);
  DECLARE v_ab_codi VARCHAR(10);
  DECLARE v_id VARCHAR(50);

#########################################
## controlla se la prova Ã¨ prenotata   ##
#########################################

  SELECT `coda_prove`.USER,
         `coda_prove`.AB_CODI,
         `coda_prove`.ID
  FROM
         `coda_prove`
  WHERE
         `coda_prove`.ID = p_ID
  INTO
         v_user,v_ab_codi,v_id;


#################################################
####### INSERIMENTO IN ALLARMI CON CASE  ########
#################################################

  CASE

####################################
## Da Non Fare ##
####################################

      WHEN (p_Tipo_Allarme = "DNF") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL `sp_d_CodaProve`(v_id);
## COMMIT
        COMMIT;


######################################
## avaria, da prove ##
######################################

      WHEN (p_Tipo_Allarme = "A") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_id,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_EsitoAllarme(v_id,v_id,v_ab_codi,p_Tipo_Allarme);
           CALL `sp_d_CodaProve`(v_id);

## COMMIT
        COMMIT;

  END CASE;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_GestioneProvaDay` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_GestioneProvaDay`(IN p_ID VARCHAR(50), IN p_Tipo_Allarme VARCHAR(10), IN p_User VARCHAR(50))
    COMMENT 'Gestione della prova elencata in Prove Day'
BEGIN

  DECLARE v_user VARCHAR(50);
  DECLARE v_ab_codi VARCHAR(10);
  DECLARE v_id VARCHAR(50);

#########################################
## controlla se la prova e' prenotata   ##
#########################################

  SELECT `prove_day`.USER,
         `prove_day`.AB_CODI,
         `prove_day`.ID
  FROM
         `prove_day`
  WHERE
         `prove_day`.ID = p_ID
  AND
        `prove_day`.`USER` = p_User
  UNION

  SELECT `prove_nr`.USER,
         `prove_nr`.AB_CODI,
         `prove_nr`.ID
  FROM
         `prove_nr`
  WHERE
         `prove_nr`.ID = p_ID
  AND
        `prove_nr`.`USER` = p_User

  INTO
         v_user,v_ab_codi,v_id;

#############################################
####### CERCA PRENOTAZIONE PROVE_DAY ######
#############################################
## allarme non prenotato, user = ""

  IF (v_user = p_User) THEN

###################################################
####### INSERIMENTO IN ALLARMI CON CASE  ##########
###################################################

  CASE

#############
## trovato ##
#############

      WHEN (p_Tipo_Allarme = "OK") THEN
## START TRANSACTION
        START TRANSACTION;

           CALL sp_i_Coda_prove(v_id,v_ab_codi,p_user);
           CALL sp_u_ProvaDay_u_Campo_Gestione(v_id,p_Tipo_Allarme);

## COMMIT
        COMMIT;

####################################
## messaggio segreteria ##
####################################

      WHEN (p_Tipo_Allarme = "MSG") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_ProvaDay_u_Campo_Gestione(v_id,p_Tipo_Allarme);
## COMMIT
        COMMIT;

####################################
## non risponde ##
####################################

      WHEN (p_Tipo_Allarme = "NR") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_ProvaDay_u_Campo_Gestione(v_id,p_Tipo_Allarme);
## COMMIT
        COMMIT;

####################################
## occupato ##
####################################

      WHEN (p_Tipo_Allarme = "OCC") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_u_ProvaDay_u_Campo_Gestione(v_id,p_Tipo_Allarme);
## COMMIT
        COMMIT;

####################################
## contatto telefonico ##
####################################

      WHEN (p_Tipo_Allarme = "CT") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_id,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_EsitoAllarme(v_id,v_id,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_id);
           CALL sp_d_ProveNR(v_id);
## COMMIT
        COMMIT;

####################################
## Da Non Fare ##
####################################

      WHEN (p_Tipo_Allarme = "DNF") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_id,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_EsitoAllarme(v_id,v_id,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_id);
           CALL sp_d_ProveNR(v_id);
## COMMIT
        COMMIT;

####################################
## ASSENZA ##
####################################

      WHEN (p_Tipo_Allarme = "ASS") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_id,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_EsitoAllarme(v_id,v_id,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_id);
           CALL sp_d_ProveNR(v_id);
## COMMIT
        COMMIT;

####################################
## RICOVERO ##
####################################

      WHEN (p_Tipo_Allarme = "RIC") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_id,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_EsitoAllarme(v_id,v_id,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_id);
           CALL sp_d_ProveNR(v_id);
## COMMIT
        COMMIT;


######################################
## avaria, da prove ##
######################################

      WHEN (p_Tipo_Allarme = "A") THEN
## START TRANSACTION
        START TRANSACTION;
           CALL sp_i_InsertAllarmi_in_Allarmi(v_id,v_id,v_ab_codi,p_Tipo_Allarme,p_user);
           CALL sp_u_EsitoAllarme(v_id,v_id,v_ab_codi,p_Tipo_Allarme);
           CALL sp_d_ProveDay(v_id);
           CALL sp_d_ProveNR(v_id);
## COMMIT
        COMMIT;

  END CASE;
  END IF;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Gmed` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Gmed`(IN p_id INTEGER(11), IN p_nominativo VARCHAR(50), IN p_tel_1 VARCHAR(50), IN p_tel_2 VARCHAR(50), IN p_numero VARCHAR(50), IN p_referente VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_tipo VARCHAR(50), IN p_note LONGTEXT, IN p_orario LONGTEXT)
BEGIN
UPDATE gmed
SET
gmed.`NOMINATIVO` = p_nominativo,
gmed.`TEL_1` = p_tel_1,
gmed.`TEL_2` = p_tel_2,
gmed.`NUMERO` = p_numero,
gmed.`REFERENTE` = p_referente,
gmed.`CELLULARE` = p_cellulare,
gmed.`TIPO` = p_tipo,
gmed.`NOTE` = p_note,
gmed.`ORARIO` = p_orario

WHERE
(gmed.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Infermieri` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Infermieri`(IN p_id INTEGER(11), IN p_referto LONGTEXT)
BEGIN
UPDATE `infermieri`
SET
`infermieri`.`REFERTO` = p_referto,
`infermieri`.`DATA_CHIUSO` = DATE(NOW()),
`infermieri`.`ORA_CHIUSO`= TIME(NOW())

WHERE
(`infermieri`.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_InfoAllarme` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_InfoAllarme`(IN p_uid VARCHAR(32), IN p_id_allarme VARCHAR(50), IN p_ab_codi VARCHAR(10), IN p_nominativo VARCHAR(255), IN p_user VARCHAR(50))
BEGIN

##############################
### inserisce info allarme ###
##############################

## START TRANSACTION
    START TRANSACTION;

    INSERT INTO
	  `info_allarme`(
	  ID,
	  ID_ALLARME,
	  AB_CODI,
	  NOMINATIVO,
	  USER)
	VALUES(
	  p_uid,
	  p_id_allarme,
	  p_ab_codi,
	  p_nominativo,
	  p_user);

## COMMIT TRANSACTION
      COMMIT;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_InfoAllarmeNote` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_InfoAllarmeNote`(IN p_id VARCHAR(32), IN p_info LONGTEXT)
BEGIN
     UPDATE `info_allarme`
     SET `info_allarme`.`INFO` = p_info
     WHERE `info_allarme`.`ID` = p_id;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Mdb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Mdb`(IN p_id INTEGER(11), IN p_medico VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_tel_amb VARCHAR(50), IN p_tel_casa VARCHAR(50), IN p_tel_cell VARCHAR(50), IN p_numero VARCHAR(50), IN p_specialista VARCHAR(50), IN p_orario LONGTEXT)
BEGIN
UPDATE medici
SET
medici.`MEDICO` = p_medico,
medici.`INDIRIZZO` = p_indirizzo,
medici.`COMUNE` = p_comune,
medici.`TEL_AMB` = p_tel_amb,
medici.`TEL_CASA` = p_tel_casa,
medici.`TEL_CELL` = p_tel_cell,
medici.`NUMERO` = p_numero,
medici.`SPECIALISTA` = p_specialista,
medici.`ORARIO` = p_orario

WHERE
(medici.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_NoteScheda` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_NoteScheda`(IN p_ab_codi VARCHAR(10), IN p_note LONGTEXT)
BEGIN
     UPDATE anagrafica
     SET anagrafica.NOTE = p_note
     WHERE anagrafica.AB_CODI = p_ab_codi;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Pediatrica` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Pediatrica`(IN p_id INTEGER(11), IN p_referto LONGTEXT)
BEGIN
UPDATE `pediatrica`
SET
`pediatrica`.`REFERTO` = p_referto,
`pediatrica`.`DATA_CHIUSO` = DATE(NOW()),
`pediatrica`.`ORA_CHIUSO`= TIME(NOW())

WHERE
(`pediatrica`.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_ProvaDay_u_Campo_Gestione` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_ProvaDay_u_Campo_Gestione`(IN p_ID VARCHAR(50), IN p_Tipo_Allarme VARCHAR(10))
    COMMENT 'Gestione della prova elencata in Prove Day'
BEGIN

     UPDATE `prove_day`
     SET
           `prove_day`.`GESTIONE` = p_Tipo_Allarme
     WHERE `prove_day`.`ID` = p_ID;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Prove` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Prove`(IN p_id INTEGER(11), IN p_giorno VARCHAR(50), IN p_foglio VARCHAR(50), IN p_fascia VARCHAR(50), IN p_note VARCHAR(50), IN p_richiamare VARCHAR(50))
    SQL SECURITY INVOKER
BEGIN
UPDATE prove
SET
prove.GIORNO = p_giorno,
prove.FOGLIO = p_foglio,
prove.FASCIA = p_fascia,
prove.NOTE = p_note,
prove.RICHIAMARE = p_richiamare

WHERE
(prove.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Reinstallazione` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Reinstallazione`(IN p_ab_codi VARCHAR(10))
BEGIN
UPDATE anagrafica
SET
  anagrafica.DATA_DISINSTALLAZIONE = '',
  anagrafica.MOTIVO_DISINSTALLAZIONE = ''
WHERE
  (anagrafica.AB_CODI = p_ab_codi);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Rientro` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Rientro`(IN p_id INTEGER(11))
BEGIN
UPDATE `assenza`
SET
`assenza`.DATA_RIENTRO = DATE(NOW())

WHERE
(`assenza`.`ID` = p_id);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Scheda` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Scheda`(IN p_ab_codi VARCHAR(10), IN p_indirizzo VARCHAR(255), IN p_comune VARCHAR(255), IN p_provincia VARCHAR(2), IN p_cap VARCHAR(50), IN p_tavola VARCHAR(15), IN p_zona VARCHAR(5), IN p_data_nascita DATE, IN p_luogo_nascita VARCHAR(50), IN p_altezza SMALLINT, IN p_peso SMALLINT, IN p_patologia LONGTEXT, IN p_terapia LONGTEXT, IN p_evidenzia LONGTEXT, IN p_note LONGTEXT, IN p_altro LONGTEXT, IN p_dati_abita LONGTEXT, IN p_sopravvivenza VARCHAR(5), IN p_dati_tecnici LONGTEXT, IN p_data_ins VARCHAR(10), IN p_data_inst VARCHAR(10), IN p_data_disinst VARCHAR(10), IN p_motivo_disinst VARCHAR(50))
BEGIN
UPDATE anagrafica
SET
  anagrafica.INDIRIZZO = p_indirizzo,
  anagrafica.COMUNE = p_comune,
  anagrafica.PROVINCIA = p_provincia,
  anagrafica.CAP = p_cap,
  anagrafica.TAVOLA = p_tavola,
  anagrafica.ZONA = p_zona,
  anagrafica.DATA_NASCITA = p_data_nascita,
  anagrafica.LUOGO_NASCITA = p_luogo_nascita,
  anagrafica.ALTEZZA = p_altezza,
  anagrafica.PESO = p_peso,
  anagrafica.PATOLOGIA = p_patologia,
  anagrafica.TERAPIA = p_terapia,
  anagrafica.EVIDENZIA = p_evidenzia,
  anagrafica.NOTE = p_note,
  anagrafica.ALTRO = p_altro,
  anagrafica.DATI_ABITA = p_dati_abita,
  anagrafica.SOPRAVVIVENZA = p_sopravvivenza,
  anagrafica.DATI_TECNICI = p_dati_tecnici,
  anagrafica.DATA_INSERIMENTO = p_data_ins,
  anagrafica.DATA_INSTALLAZIONE = p_data_inst,
  anagrafica.DATA_MODIFICA = DATE(NOW()),
  anagrafica.DATA_DISINSTALLAZIONE = p_data_disinst,
  anagrafica.MOTIVO_DISINSTALLAZIONE = p_motivo_disinst
WHERE
  (anagrafica.AB_CODI = p_ab_codi);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_SetUser_in_CodaEve` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_SetUser_in_CodaEve`(IN p_id_allarme VARCHAR(50), IN p_user VARCHAR(50))
    COMMENT 'Aggiunge la prenotazione dell Utente in un allarme arrivato'
BEGIN
  DECLARE v_user VARCHAR(50);
  DECLARE v_ab_codi VARCHAR(10);
  DECLARE v_evento VARCHAR(50);

## cerca user ed ID allarme nella coda
  SELECT coda_eve.USER,
             coda_eve.AB_CODI,
             coda_eve.EVENTO
  FROM coda_eve
  WHERE coda_eve.ID_ALLARME = p_id_allarme
  INTO v_user,v_ab_codi,v_evento;

############################################
#######     PRENOTA CODA EVENTI       ######
############################################
## allarme non prenotato, user = "" , prenota
  IF (v_user = "") OR ISNULL(v_user) THEN
## START TRANSACTION
         START TRANSACTION;
               UPDATE `coda_eve`
               SET `coda_eve`.`USER` = p_user
               WHERE `coda_eve`.`ID_ALLARME` = p_id_allarme;
## COMMIT TRANSACTION
         COMMIT;
############################################
####### INSERIMENTO ALLARME REALE ##########
############################################
## controlla se l' allarme Ã¨ un allarme reale ( LIVELLO_ALLARME = "ON")
         SELECT eventi_allarme.LIVELLO_ALLARME
         FROM eventi_allarme
         WHERE eventi_allarme.EVENTO = v_evento
         INTO v_evento;

## START TRANSACTION
        START TRANSACTION;

        IF v_evento = "ON" THEN
		     INSERT INTO
		            allarmi(
		            ID_ALLARME,
		            AB_CODI,
		            EVENTO,
                    USER,
                    DATA,
                    ORA)
             VALUES(
		            p_id_allarme,
		            v_ab_codi,
		            v_evento,
                    p_user,
                    date(now()),
                    time(now()));
## COMMIT TRANSACTION
          COMMIT;
        END IF;
    END IF;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_SetUser_in_ProveDay` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_SetUser_in_ProveDay`(IN p_ID VARCHAR(50), IN p_User VARCHAR(50))
    COMMENT 'Prenota la prova da prove day  aggiornando il campo user con\r\n'
BEGIN

               UPDATE `prove_day`
               SET `prove_day`.`USER` = p_User
               WHERE `prove_day`.`ID` = p_ID;

               UPDATE `prove_nr`
               SET `prove_nr`.`USER` = p_User
               WHERE `prove_nr`.`ID` = p_ID;


END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Soccamici` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Soccamici`(IN p_id INTEGER(11), IN p_nominativo VARCHAR(255), IN p_tel_casa VARCHAR(50), IN p_tel_uff VARCHAR(50), IN p_tel_cell VARCHAR(50), IN p_tempo_casa VARCHAR(50), IN p_tempo_uff VARCHAR(50), IN p_chiavi VARCHAR(50), IN p_coinquilino VARCHAR(50), IN p_parente VARCHAR(50), IN p_numero VARCHAR(50))
BEGIN
UPDATE socc_amici
SET
  socc_amici.NOMINATIVO = p_nominativo,
  socc_amici.TEL_CASA = p_tel_casa,
  socc_amici.TEL_UFF = p_tel_uff,
  socc_amici.TEL_CELL = p_tel_cell,
  socc_amici.TEMPO_CASA = p_tempo_casa,
  socc_amici.TEMPO_UFF = p_tempo_uff,
  socc_amici.CHIAVI = p_chiavi,
  socc_amici.COINQUILINO = p_coinquilino,
  socc_amici.PARENTE = p_parente,
  socc_amici.NUMERO = p_numero
WHERE
  (socc_amici.`ID` = p_id) ;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Soccpubb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Soccpubb`(IN p_id INTEGER(11), IN p_tipo VARCHAR(50), IN p_tel_1 VARCHAR(50), IN p_tel_2 VARCHAR(50), IN p_numero VARCHAR(50), IN p_cellulare VARCHAR(50))
BEGIN
UPDATE socc_pub
SET
socc_pub.TIPO = p_tipo,
socc_pub.TEL_1 = p_tel_1,
socc_pub.TEL_2 = p_tel_2,
socc_pub.NUMERO = p_numero,
socc_pub.CELLULARE = p_cellulare
WHERE
(socc_pub.`ID` = p_id);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_u_Stipulante` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_u_Stipulante`(IN p_ab_codi VARCHAR(10), IN p_nominativo VARCHAR(50), IN p_indirizzo VARCHAR(50), IN p_comune VARCHAR(50), IN p_prov VARCHAR(50), IN p_cap VARCHAR(50), IN p_cf VARCHAR(16), IN p_piva VARCHAR(11), IN p_telefono VARCHAR(50), IN p_cellulare VARCHAR(50), IN p_tel_ufficio VARCHAR(50), IN p_referente VARCHAR(50), IN p_imponibile VARCHAR(10), IN p_iva VARCHAR(10), IN p_importo_iva VARCHAR(10), IN p_totale VARCHAR(20), IN p_contratto VARCHAR(50), IN p_pagamento VARCHAR(50), IN p_modo_pagamento VARCHAR(50), IN p_note LONGTEXT, IN p_parentela VARCHAR(50), IN p_email VARCHAR(50))
BEGIN
UPDATE stipulante
SET
stipulante.NOMINATIVO = p_nominativo,
stipulante.INDIRIZZO = p_indirizzo,
stipulante.COMUNE = p_comune,
stipulante.PROV = p_prov,
stipulante.CAP = p_cap,
stipulante.CF = p_cf,
stipulante.PIVA = p_piva,
stipulante.TELEFONO = p_telefono,
stipulante.CELLULARE = p_cellulare,
stipulante.TEL_UFFICIO = p_tel_ufficio,
stipulante.REFERENTE = p_referente,
stipulante.IMPONIBILE = p_imponibile,
stipulante.IVA = p_iva,
stipulante.IMPORTO_IVA = p_importo_iva,
stipulante.TOTALE = p_totale,
stipulante.CONTRATTO = p_contratto,
stipulante.PAGAMENTO = p_pagamento,
stipulante.MODO_PAGAMENTO = p_modo_pagamento,
stipulante.NOTE = p_note,
stipulante.PARENTELA = p_parentela,
stipulante.EMAIL = p_email

WHERE
(stipulante.`AB_CODI` = p_ab_codi);
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_AllarmiAperti` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_AllarmiAperti`(IN p_user VARCHAR(50))
BEGIN
     SELECT allarmi.`AB_CODI`,
            allarmi.`ID_ALLARME`,
            allarmi.`DATA`,
            allarmi.`ORA`,
            allarmi.`USER`,
            allarmi.`ESITO`,
            allarmi.`DATA_CHIUSO`
      FROM
            allarmi


     LEFT OUTER JOIN `anagrafica` ON (`allarmi`.AB_CODI = `anagrafica`.AB_CODI)

WHERE

  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user )

AND

            ((allarmi.`ESITO` = "R") OR
            (allarmi.`ESITO` = "RT") OR
            (allarmi.`ESITO` = "S") OR
            (allarmi.`ESITO` = "ST")) AND
            ((`allarmi`.`DATA_CHIUSO` IS NULL) OR
            (`allarmi`.`DATA_CHIUSO` = ""));
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Anagrafica` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Anagrafica`(
IN p_ab_codi VARCHAR(10)
)
BEGIN
      SELECT * FROM anagrafica WHERE anagrafica.AB_CODI = p_ab_codi;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Analisi` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Analisi`(p_ab_codi VARCHAR(10))
BEGIN
SELECT * FROM `analisi` WHERE `analisi`.`AB_CODI` = p_ab_codi ORDER by analisi.NUMERO ASC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Asi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Asi`()
BEGIN
SELECT * FROM `asi_gmed` WHERE `asi_gmed`.`DATA_CHIUSO` IS NULL ORDER BY asi_gmed.`ID` DESC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Asi_Scheda` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Asi_Scheda`(IN p_id INTEGER(11))
BEGIN

SELECT * FROM `asi_gmed`

WHERE `asi_gmed`.`ID`= p_id;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Assenza` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Assenza`(IN p_ab_codi VARCHAR(10))
BEGIN
      SELECT * FROM `assenza`

     WHERE assenza.AB_CODI = p_ab_codi
     AND assenza.DATA_RIENTRO IS NULL;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_CodaEveSound` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_CodaEveSound`(IN p_user VARCHAR(50))
BEGIN

SELECT
  COUNT(*) AS ALLARM_COUNT
FROM
  coda_eve

  LEFT OUTER JOIN `anagrafica` ON (`coda_eve`.AB_CODI = `anagrafica`.AB_CODI)

WHERE `coda_eve`.`USER` IS NULL OR `coda_eve`.`USER` = ''

AND  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user );

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Codaprove` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Codaprove`(IN p_user VARCHAR(50))
BEGIN
SELECT * FROM
    `coda_prove`
LEFT OUTER JOIN `anagrafica` ON (`coda_prove`.AB_CODI = `anagrafica`.AB_CODI)

WHERE

  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user )

     ;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Coda_Eve` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Coda_Eve`(IN p_user VARCHAR(50))
BEGIN

SELECT
  `coda_eve`.AB_CODI,
  `coda_eve`.MATRICOLA,
  `coda_eve`.EVENTO,
  `coda_eve`.NOMINATIVO,
  `coda_eve`.ID_ALLARME,
  `coda_eve`.`DATA`,
  `coda_eve`.ORA,
  `coda_eve`.USER,
  `coda_eve`.TELEFONO,
  `coda_eve`.FILENAME,
  `anagrafica`.CENTRALE
FROM
  `coda_eve`
  LEFT OUTER JOIN `anagrafica` ON (`coda_eve`.AB_CODI = `anagrafica`.AB_CODI)

WHERE

  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user )

ORDER BY
  `coda_eve`.`DATA`,`coda_eve`.ORA ;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Context` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Context`()
BEGIN
SELECT * FROM `cdr`
ORDER BY `cdr`.`calldate` DESC LIMIT 150;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Context_Brondi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Context_Brondi`()
BEGIN
SELECT * FROM `cdr`
WHERE (dcontext = 'mycustom-brondi')
ORDER BY `cdr`.`calldate` DESC LIMIT 150;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Convivente` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Convivente`(
IN p_ab_codi VARCHAR(10)
)
BEGIN
      SELECT
            convivente.ID,
            convivente.AB_CODI,
            convivente.NOMINATIVO,
            convivente.COINTESTATARIO,
            convivente.CELLULARE,
            convivente.SESSO,
            convivente.LUOGO_NASCITA,
            convivente.DATA_NASCITA,
            convivente.ALTEZZA,
            convivente.PESO,
            convivente.TERAPIA,
            convivente.PATOLOGIA,
            convivente.EVIDENZIA,
            convivente.NOTE,
            convivente.PARENTELA

     FROM convivente

     WHERE convivente.AB_CODI = p_ab_codi;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_CountPerEnte` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_CountPerEnte`(IN p_User VARCHAR(50))
BEGIN
 -- Select prove per foglio con ab_codi in
 -- centrale dell' utente selezionato
 SELECT ENTE ,COUNT(*) AS TOTALE FROM `anagrafica`
 WHERE (`anagrafica`.`DATA_DISINSTALLAZIONE` ='') OR (`anagrafica`.`DATA_DISINSTALLAZIONE` IS NULL)
 AND AB_CODI IN
     (SELECT ab_codi FROM anagrafica a
      WHERE a. centrale IN
        (SELECT centrale FROM
         `vw_CentraleUtente`
         WHERE tsc_username = p_User))
 GROUP BY ENTE;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_CountProvePerFoglio` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_CountProvePerFoglio`(IN p_Day VARCHAR(10), IN p_User VARCHAR(50))
BEGIN
 -- Select prove per foglio con ab_codi in
 -- centrale dell' utente selezionato
 SELECT p_Day AS FOGLIO ,'' TOTALE  FROM DUAL
 UNION
 SELECT FOGLIO ,COUNT(*) AS TOTALE FROM prove
 WHERE GIORNO = p_Day
 AND AB_CODI IN
     (SELECT ab_codi FROM anagrafica a
      WHERE a. centrale IN
        (SELECT centrale FROM
         `vw_CentraleUtente`
         WHERE tsc_username = p_User))
 GROUP BY FOGLIO;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Disinstallato` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Disinstallato`(IN p_ab_codi VARCHAR(10))
BEGIN
      SELECT * FROM `anagrafica`

     WHERE anagrafica.AB_CODI = p_ab_codi
     AND anagrafica.`DATA_DISINSTALLAZIONE` <> '';
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Enti` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Enti`()
BEGIN

SELECT * FROM `enti`ORDER BY `enti`.`ENTE` ASC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Fascia` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Fascia`()
BEGIN
      SELECT
            `prove_fascia`.FASCIA

     FROM prove_fascia;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_GetPhone` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_GetPhone`(IN ip_address VARCHAR(15))
BEGIN
SELECT
  `phone_info`.`Channel`
FROM
  `phone_info`
WHERE
  phone_info.`IP`= ip_address;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Gmed` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Gmed`(p_ab_codi VARCHAR(10))
BEGIN

SELECT * FROM `gmed` WHERE (`gmed`.AB_CODI = p_ab_codi) ORDER by gmed.NUMERO ASC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_His_allarmi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_His_allarmi`(IN p_ab_codi VARCHAR(10))
BEGIN
      SELECT * FROM `allarmi`

       WHERE allarmi.AB_CODI = p_ab_codi

       ORDER BY `allarmi`.`VISUALIZZAZIONE` DESC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_His_Assenza` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_His_Assenza`(IN p_ab_codi VARCHAR(50))
BEGIN
SELECT * FROM `assenza`
WHERE `assenza`.`AB_CODI`=p_ab_codi
ORDER BY `assenza`.`ID` DESC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_His_eve` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_His_eve`(IN p_ab_codi VARCHAR(10))
BEGIN
      SELECT * FROM `storico_eventi`

       WHERE `storico_eventi`.AB_CODI = p_ab_codi

       ORDER BY `storico_eventi`.`VISUALIZZAZIONE` DESC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Infermieri` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Infermieri`()
BEGIN
SELECT * FROM `infermieri` WHERE `infermieri`.`DATA_CHIUSO` IS NULL ORDER BY infermieri.`ID` DESC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Infermieri_Scheda` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Infermieri_Scheda`(IN p_id INTEGER(11))
BEGIN

SELECT * FROM `infermieri`

WHERE `infermieri`.`ID`= p_id;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_InfoAllarme` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_InfoAllarme`(IN p_id_allarme VARCHAR(50))
    COMMENT 'Stored Procedure di gestione allarme gestisce gli Esiti P,C,E,R,'
BEGIN

SELECT
   info_allarme.`ID` AS ID,
   info_allarme.NOMINATIVO AS NOMINATIVO,
   info_allarme.USER,
   info_allarme.INFO,
  `cdr`.billsec AS DURATA,
  `cdr`.disposition AS RISPOSTA,
  `cdr`.dst AS TELEFONO,
   DATE(cdr.`calldate`) AS DATA,
   TIME(cdr.`calldate`) AS ORA
FROM
  `cdr`
  INNER JOIN info_allarme ON (`cdr`.uniqueid = info_allarme.ID)

WHERE info_allarme.`ID_ALLARME` = p_id_allarme
ORDER BY   info_allarme.`ID` DESC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Login` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Login`(IN p_user VARCHAR(50))
BEGIN
      SELECT
            `login_info`.`USER`,
            `login_info`.`ID_LOGIN`,
            `login_info`.`FOGLIO_PROVE`
      FROM `login_info`

     WHERE `login_info`.`USER` = p_user;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Mdb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Mdb`(p_ab_codi VARCHAR(10))
BEGIN

SELECT * FROM medici WHERE (medici.AB_CODI = p_ab_codi) ORDER by medici.NUMERO ASC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Moduloallarmi` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Moduloallarmi`(IN p_id_allarme VARCHAR(50))
BEGIN

SELECT allarmi.`AB_CODI`,
       allarmi.`USER`,
       allarmi.`EVENTO`,
       allarmi.`DATA`,
       allarmi.`ORA`,
       allarmi.`ESITO`
FROM allarmi
WHERE allarmi.`ID_ALLARME` = p_id_allarme;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Pediatrica` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Pediatrica`()
BEGIN
SELECT * FROM `pediatrica` WHERE `pediatrica`.`DATA_CHIUSO` IS NULL ORDER BY pediatrica.`ID` DESC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Pediatrica_Scheda_new` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Pediatrica_Scheda_new`(IN p_id INTEGER(11))
BEGIN

SELECT * FROM `pediatrica`

WHERE `pediatrica`.`ID`= p_id;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_PhoneInfo` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_PhoneInfo`(IN p_User VARCHAR(50), IN p_IP_Address VARCHAR(15))
    COMMENT 'La sp restituisce le info sulla mappatura user-IP-telefono'
BEGIN

  DECLARE  v_User VARCHAR(50);

#####################################
## Seleiona la config per il phone ##
#####################################

          SELECT
            `login_info`.User,
            `login_info`.IP,
            `phone_info`.IP,
            `phone_info`.Server_IP,
            /* `phone_info`.Phone_Number, */
            `phone_info`.Callback_Page
          FROM
            `phone_info`,
            `login_info`
          WHERE
            (`login_info`.IP = `phone_info`.IP);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Prove` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Prove`(p_ab_codi VARCHAR(10))
BEGIN
      SELECT
            prove.ID,
            prove.AB_CODI,
            prove.FOGLIO,
            prove.GIORNO,
            prove.FASCIA,
            prove.NOTE,
            prove.RICHIAMARE

     FROM prove

     WHERE prove.AB_CODI = p_ab_codi;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Prove_day` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Prove_day`(IN p_user VARCHAR(50))
BEGIN
SELECT  prove_day.* FROM

anagrafica

INNER JOIN `prove_day` ON (`prove_day`.AB_CODI = `anagrafica`.AB_CODI)

WHERE

  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user )

AND

  `prove_day`.`FOGLIO` IN (SELECT (login_info.`FOGLIO_PROVE`) FROM `login_info`
     WHERE `login_info`.`USER` = p_user)


ORDER BY
     `prove_day`.`FASCIA` ASC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Prove_nr` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Prove_nr`(IN p_user VARCHAR(50))
BEGIN
SELECT  prove_nr.*

FROM

`prove_nr`

INNER JOIN `anagrafica` ON (`prove_nr`.AB_CODI = `anagrafica`.AB_CODI)

WHERE

  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user )

ORDER BY
     `prove_nr`.`FASCIA` ASC;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Richiamare` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Richiamare`(IN p_ab_codi VARCHAR(10))
BEGIN

SELECT `prove`.`RICHIAMARE` FROM `prove`

WHERE `prove`.`AB_CODI` = p_ab_codi AND (`prove`.`GIORNO`  = (SELECT `fn_GetDayOfWeek_IT`() FROM DUAL));

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Schedulatore` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Schedulatore`()
BEGIN
SELECT * FROM `storico_eventi` ORDER by `storico_eventi`.`VISUALIZZAZIONE` DESC LIMIT 0, 100;
END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Soccamici` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Soccamici`(p_ab_codi VARCHAR(10))
BEGIN
      SELECT
             socc_amici.ID,
             socc_amici.AB_CODI,
             socc_amici.NOMINATIVO,
             socc_amici.TEL_CASA,
             socc_amici.TEL_UFF,
             socc_amici.TEL_CELL,
             socc_amici.TEMPO_CASA,
             socc_amici.TEMPO_UFF,
             socc_amici.CHIAVI,
             socc_amici.COINQUILINO,
             socc_amici.PARENTE,
             socc_amici.NUMERO

     FROM socc_amici
     WHERE socc_amici.AB_CODI = p_ab_codi
     ORDER by socc_amici.NUMERO ASC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Soccpubb` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Soccpubb`(
IN p_ab_codi VARCHAR(10)
)
BEGIN
      SELECT
             socc_pub.ID,
             socc_pub.AB_CODI,
             socc_pub.TIPO,
             socc_pub.TEL_1,
             socc_pub.TEL_2,
             socc_pub.NUMERO,
             socc_pub.CELLULARE

     FROM socc_pub

     WHERE socc_pub.AB_CODI = p_ab_codi

     ORDER by socc_pub.NUMERO ASC;

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_Stipulante` */;;
/*!50003 SET SESSION SQL_MODE="NO_AUTO_VALUE_ON_ZERO"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_Stipulante`(p_ab_codi VARCHAR(10))
BEGIN

SELECT
  stipulante.AB_CODI,
  anagrafica.AB_CODI,
  stipulante.NOMINATIVO,
  stipulante.INDIRIZZO,
  stipulante.COMUNE,
  stipulante.PROV,
  stipulante.CAP,
  stipulante.CF,
  stipulante.TELEFONO,
  stipulante.CELLULARE,
  stipulante.TEL_UFFICIO,
  stipulante.REFERENTE,
  stipulante.IMPONIBILE,
  stipulante.IVA,
  stipulante.IMPORTO_IVA,
  stipulante.CONTRATTO,
  stipulante.PAGAMENTO,
  stipulante.MODO_PAGAMENTO,
  stipulante.EMAIL,
  stipulante.PARENTELA,
  stipulante.NOTE,
  stipulante.PIVA,
  stipulante.TOTALE,
  anagrafica.DATA_INSERIMENTO,
  anagrafica.DATA_INSTALLAZIONE,
  anagrafica.DATA_DISINSTALLAZIONE,
  anagrafica.MOTIVO_DISINSTALLAZIONE,
  anagrafica.CENTRALE,
  anagrafica.ENTE
FROM
  stipulante
  INNER JOIN anagrafica ON (`stipulante`.`AB_CODI`=`anagrafica`.`AB_CODI`)
  WHERE (`stipulante`.AB_CODI = p_ab_codi);

END */;;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP PROCEDURE IF EXISTS `sp_v_TecniciAperti` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 PROCEDURE `sp_v_TecniciAperti`(IN p_user VARCHAR(50))
BEGIN
     SELECT allarmi.`AB_CODI`,
            allarmi.`ID_ALLARME`,
            allarmi.`DATA`,
            allarmi.`ORA`,
            allarmi.`USER`,
            allarmi.`ESITO`,
            allarmi.`DATA_CHIUSO`
      FROM
            allarmi


     LEFT OUTER JOIN `anagrafica` ON (`allarmi`.AB_CODI = `anagrafica`.AB_CODI)

WHERE

  `anagrafica`.CENTRALE IN
  ( SELECT CENTRALE FROM `vw_CentraleUtente`
     WHERE `vw_CentraleUtente`.`tsc_username` = p_user )

AND

            (allarmi.`ESITO` = "A");

END */;;

/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `nextval` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `nextval`(`seq_name` varchar(100))
RETURNS bigint NOT DETERMINISTIC
BEGIN
    DECLARE cur_val bigint;

    SELECT
        cur_value INTO cur_val
    FROM
        sequence
    WHERE
        name = seq_name;

    IF cur_val IS NOT NULL THEN
        UPDATE
            sequence
        SET
            cur_value = IF (
                (cur_value + increment) > max_value OR (cur_value + increment) < min_value,
                IF (
                    cycle = TRUE,
                    IF (
                        (cur_value + increment) > max_value,
                        min_value,
                        max_value
                    ),
                    NULL
                ),
                cur_value + increment
            )
        WHERE
            name = seq_name;
    END IF;
    RETURN cur_val;
END */;;

/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `currval` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `currval`(`seq_name` varchar(100))
RETURNS bigint(20) NOT DETERMINISTIC
BEGIN
    DECLARE cur_val bigint(20);

    SELECT
        cur_value INTO cur_val
    FROM
        sequence
    WHERE
        `name` = seq_name
    ;

    RETURN cur_val;
END */;;

/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
/*!50003 DROP FUNCTION IF EXISTS `setval` */;;
/*!50003 SET SESSION SQL_MODE=""*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`%`*/ /*!50003 FUNCTION `setval` (`seq_name` varchar(100), `new_val` bigint(20))
RETURNS bigint(20) NOT DETERMINISTIC
BEGIN
	DECLARE cur_val bigint(20);

    SELECT
        cur_value INTO cur_val
    FROM
        sequence
    WHERE
        `name` = seq_name;

	IF cur_val IS NOT NULL THEN
	    UPDATE
			sequence
		SET
			cur_value = new_val
	    WHERE
	        `name` = seq_name;

	ELSE
		INSERT INTO
			sequence
		    	(`name`,cur_value)
			VALUES
		    	(seq_name,new_val);
	END IF;
	RETURN new_val;
END */;;

/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE*/;;
DELIMITER ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-18 20:30:05
