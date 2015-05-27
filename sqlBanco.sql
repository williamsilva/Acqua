-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `acqua_dados` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `acqua_dados` ;

-- -----------------------------------------------------
-- Table `mydb`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acqua_dados`.`Login` (
  `idLogin` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `ativo` CHAR(3) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `data_cadastro` VARCHAR(50) NOT NULL,
  `ultma_alteracao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idLogin`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Computador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acqua_dados`.`Computador` (
  `idComputador` INT NOT NULL AUTO_INCREMENT,
  `mac_computador` VARCHAR(12) NOT NULL,
  `nome_computador` VARCHAR(50) NOT NULL,
  `data_cadastro` VARCHAR(50) NOT NULL,
  `ultima_alteracao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idComputador`),
  UNIQUE INDEX `mac_computador_UNIQUE` (`mac_computador` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
