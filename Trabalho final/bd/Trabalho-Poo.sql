-- MySQL Script generated by MySQL Workbench
-- Wed Dec  4 18:17:07 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema douglas-meier
-- -----------------------------------------------------
-- Trabalho final de poo 4bimestre.

-- -----------------------------------------------------
-- Schema douglas-meier
--
-- Trabalho final de poo 4bimestre.
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `douglas-meier` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `douglas-meier` ;

-- -----------------------------------------------------
-- Table `douglas-meier`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `douglas-meier`.`cliente` (
  `idCliente` INT UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(80) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `cpfCliente` VARCHAR(15) NOT NULL,
  `emailCliente` VARCHAR(149) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
