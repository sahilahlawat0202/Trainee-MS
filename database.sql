-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema trainee
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trainee
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trainee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema air
-- -----------------------------------------------------
USE `trainee` ;

-- -----------------------------------------------------
-- Table `trainee`.`personalinformation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainee`.`personalinformation` (
  `uniqueID` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(50) NULL DEFAULT NULL,
  `lastname` VARCHAR(50) NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `gender` VARCHAR(50) NULL DEFAULT NULL,
  `nationality` VARCHAR(50) NULL DEFAULT NULL,
  `contactnumber` BIGINT NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `permanantaddress` VARCHAR(255) NULL DEFAULT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `state` VARCHAR(50) NULL DEFAULT NULL,
  `zip` INT NULL DEFAULT NULL,
  `country` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`uniqueID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `trainee`.`educationbackground`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainee`.`educationbackground` (
  `uniqueID` VARCHAR(45) NOT NULL,
  `university` VARCHAR(255) NULL DEFAULT NULL,
  `major` VARCHAR(100) NULL DEFAULT NULL,
  `currentyearofstudy` INT NULL DEFAULT NULL,
  `cgpa` FLOAT NULL DEFAULT NULL,
  `yearofgraduation` INT NULL DEFAULT NULL,
  PRIMARY KEY (`uniqueID`),
  CONSTRAINT `uniqueIDedu`
    FOREIGN KEY (`uniqueID`)
    REFERENCES `trainee`.`personalinformation` (`uniqueID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `trainee`.`internshipdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trainee`.`internshipdetails` (
  `uniqueID` VARCHAR(45) NOT NULL,
  `startdate` DATE NULL DEFAULT NULL,
  `enddate` DATE NULL DEFAULT NULL,
  `fulltime` VARCHAR(50) NULL DEFAULT NULL,
  `interest` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`uniqueID`),
  CONSTRAINT `uniqueID`
    FOREIGN KEY (`uniqueID`)
    REFERENCES `trainee`.`personalinformation` (`uniqueID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
