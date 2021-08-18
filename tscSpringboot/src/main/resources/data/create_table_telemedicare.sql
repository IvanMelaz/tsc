USE `telesoccorso`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

/*Table structure for table `tsc_telemedicare` */

CREATE TABLE IF NOT EXISTS `tsc_telemedicare` (

  `id_allarme` VARCHAR(50)  NOT NULL default '',
  `ab_codi` VARCHAR(50)  NOT NULL default '',
  `data_arrivo` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `tsc_user` (
    `role` VARCHAR(255)  NOT NULL default '',
    `username` VARCHAR(255)  NOT NULL default '',
    `base32Secret` VARCHAR(255) NOT NULL default '',
    `email` VARCHAR(255) NOT NULL default '',
    `mfaEnabled` TINYINT,
    `keyId` VARCHAR(255) NOT NULL default '',
    `password` VARCHAR(255) NOT NULL default ''
    );
