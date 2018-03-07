--
-- Create database
--

CREATE DATABASE IF NOT EXISTS telesoccorso;
USE telesoccorso;


--
-- Table Europe Assistance
--

DROP TABLE IF EXISTS `tsc_europe`;
CREATE TABLE `tsc_europe` (
	`ID_ALLARME` varchar(50) not null,
    `AB_CODI` varchar(10) not null,
    `DATA_RICHIESTA` timestamp not null,
    `DATA_ARRIVO` timestamp not null default current_timestamp,
    `NOMECLIENTE` varchar(255),
    `COGNOMECLIENTE` varchar(255) not null,
    `NUMEROTELEFONO1` varchar(15) not null,
    `NUMEROTELEFONO2` varchar(15),
    `EMAIL` varchar(255),
    `INDIRIZZO` varchar(255),
    `NUMEROORDINE` int not null,
    `NUMERODOSSIER` varchar(255),
    `CODICEBP` varchar(255) not null,
    `TIPOLOGIASERVIZIO` varchar(15) not null,
    `TIPOLOGIACONSULENZA` varchar(15) not null,
    `SPECIALIZZAZIONEMEDICO` varchar(255),
    `QUESITOMEDICO` varchar(255),
    `FASCIAORARIA` varchar(10),
    `LINKMYCLINIC` varchar(255),
    `TEST` tinyint(1),
    PRIMARY KEY (`ID_ALLARME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;