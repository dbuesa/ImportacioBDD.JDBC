-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema practicaEleccions
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema practicaEleccions
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `practicaEleccions` DEFAULT CHARACTER SET utf8 ;
USE `practicaEleccions` ;

-- -----------------------------------------------------
-- Table `practicaEleccions`.`comunitats_autonomes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practicaEleccions`.`comunitats_autonomes` (
  `comunitat_aut_id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `codi_ine` CHAR(2) NOT NULL,
  PRIMARY KEY (`comunitat_aut_id`),
  UNIQUE INDEX `uk_com_aut_codi_ine` (`codi_ine` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practicaEleccions`.`provincies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practicaEleccions`.`provincies` (
  `provincia_id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comunitat_aut_id` TINYINT UNSIGNED NOT NULL,
  `nom` VARCHAR(45) NULL,
  `codi_ine` CHAR(2) NOT NULL,
  `num_escons` TINYINT UNSIGNED NULL COMMENT 'Numero d\'escons que li pertoquen a aquella provincia',
  PRIMARY KEY (`provincia_id`),
  UNIQUE INDEX `uk_provincies_codi_ine` (`codi_ine` ASC) VISIBLE,
  INDEX `idx_fk_provincies_comunitats_autonomes` (`comunitat_aut_id` ASC) VISIBLE,
  CONSTRAINT `fk_provincies_comunitats_autonomes`
    FOREIGN KEY (`comunitat_aut_id`)
    REFERENCES `mydb`.`comunitats_autonomes` (`comunitat_aut_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practicaEleccions`.`municipis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practicaEleccions`.`municipis` (
  `municipi_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NULL,
  `codi_ine` CHAR(3) NOT NULL,
  `provincia_id` TINYINT UNSIGNED NOT NULL,
  `districte` CHAR(2) NULL COMMENT 'Número de districte municipal , sinó el seu valor serà 99. Per exemple aquí municiís com Blanes el seu valor serà 99, però en ciutats com Barcelona hi haurà el número de districte',
  PRIMARY KEY (`municipi_id`),
  UNIQUE INDEX `uk_municipis_codi` (`codi_ine` ASC, `provincia_id` ASC, `districte` ASC) VISIBLE,
  INDEX `idx_fk_municipis_provincies1` (`provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_municipis_provincies`
    FOREIGN KEY (`provincia_id`)
    REFERENCES `mydb`.`provincies` (`provincia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practicaEleccions`.`candidatures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practicaEleccions`.`candidatures` (
  `candidatura_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `eleccio_id` TINYINT UNSIGNED NOT NULL,
  `codi_candidatura` CHAR(6) NULL,
  `nom_curt` VARCHAR(50) NULL COMMENT 'Sigles de la candidatura',
  `nom_llarg` VARCHAR(150) NULL COMMENT 'Nom llarg de la candidatura (denominació)',
  `codi_acumulacio_provincia` CHAR(6) NULL COMMENT 'Codi de la candidatura d\'acumulació a nivell provincial.',
  `codi_acumulacio_ca` CHAR(6) NULL COMMENT 'Codi de la candidatura d\'acumulació a nivell de comunitat autònoma',
  `codi_acumulario_nacional` CHAR(6) NULL,
  PRIMARY KEY (`candidatura_id`),
  UNIQUE INDEX `uk_eleccions_partits` (`eleccio_id` ASC, `codi_candidatura` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practicaEleccions`.`persones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practicaEleccions`.`persones` (
  `persona_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(30) NULL,
  `cog1` VARCHAR(30) NULL,
  `cog2` VARCHAR(30) NULL,
  `sexe` ENUM('M', 'F') NULL COMMENT 'M=Masculí, F=Femení',
  `data_naixement` DATE NULL,
  `dni` CHAR(10) NOT NULL,
  PRIMARY KEY (`persona_id`),
  UNIQUE INDEX `uk_candidats_dni` (`dni` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practicaEleccions`.`candidats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practicaEleccions`.`candidats` (
  `candidat_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `candidatura_id` INT UNSIGNED NOT NULL,
  `persona_id` INT UNSIGNED NOT NULL,
  `provincia_id` TINYINT UNSIGNED NOT NULL,
  `num_ordre` TINYINT NULL COMMENT 'Num ordre del candidatdins la llista del partit dins de la circumpscripció que es presenta.',
  `tipus` ENUM('T', 'S') NULL COMMENT 'T=Titular, S=Suplent',
  PRIMARY KEY (`candidat_id`),
  INDEX `fk_candidats_provincies1_idx` (`provincia_id` ASC) VISIBLE,
  INDEX `fk_candidats_persones1_idx` (`persona_id` ASC) VISIBLE,
  INDEX `fk_candidats_candidatures1_idx` (`candidatura_id` ASC) VISIBLE,
  UNIQUE INDEX `uk_candidats_persona_cand` (`candidatura_id` ASC, `persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_candidats_provincies1`
    FOREIGN KEY (`provincia_id`)
    REFERENCES `mydb`.`provincies` (`provincia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidats_persones1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `mydb`.`persones` (`persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidats_candidatures1`
    FOREIGN KEY (`candidatura_id`)
    REFERENCES `mydb`.`candidatures` (`candidatura_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
