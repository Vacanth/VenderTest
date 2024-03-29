SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `accountdb` ;
CREATE SCHEMA IF NOT EXISTS `accountdb` DEFAULT CHARACTER SET utf8 ;
USE `accountdb` ;

-- -----------------------------------------------------
-- Table `accountdb`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accountdb`.`address` ;

CREATE  TABLE IF NOT EXISTS `accountdb`.`address` (
  `ADDRESS_ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `USE_CASE` TINYINT(4) NULL DEFAULT NULL ,
  `ADDR_TYPE` TINYINT(4) NULL DEFAULT NULL ,
  `CONTACT_FIRST_NAME` VARCHAR(64) NULL DEFAULT NULL ,
  `CONTACT_LAST_NAME` VARCHAR(64) NULL DEFAULT NULL ,
  `COMPANY_NAME` VARCHAR(64) NULL DEFAULT NULL ,
  `ADDR_LN1` VARCHAR(128) NULL DEFAULT NULL ,
  `ADDR_LN2` VARCHAR(128) NULL DEFAULT NULL ,
  `ADDR_LN3` VARCHAR(128) NULL DEFAULT NULL ,
  `CITY` VARCHAR(64) NULL DEFAULT NULL ,
  `STATE` VARCHAR(64) NULL DEFAULT NULL ,
  `COUNTRY_CODE_ISO3` TINYINT(4) NULL DEFAULT NULL ,
  `ZIP` VARCHAR(32) NULL DEFAULT NULL ,
  `STATUS` TINYINT(4) NULL DEFAULT NULL ,
  `CREATED_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`ADDRESS_ID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 44
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accountdb`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accountdb`.`account` ;

CREATE  TABLE IF NOT EXISTS `accountdb`.`account` (
  `ACCOUNT_ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `EMAIL_ADDR` VARCHAR(128) NULL DEFAULT NULL ,
  `PASSWORD` VARCHAR(128) NULL DEFAULT NULL ,
  `FIRST_NAME` VARCHAR(64) NULL DEFAULT NULL ,
  `LAST_NAME` VARCHAR(64) NULL DEFAULT NULL ,
  `MIDDLE_NAME` VARCHAR(64) NULL DEFAULT NULL ,
  `ACCOUNT_IMAGE` BLOB NULL DEFAULT NULL ,
  `REGISTRATION_ADDR_ID` BIGINT(20) NOT NULL ,
  `BILLING_ADDR_ID` BIGINT(20) NOT NULL ,
  `STATUS` TINYINT(4) NULL DEFAULT NULL ,
  `REGISTERED_COUNTRY` INT(11) NULL DEFAULT NULL ,
  `LOCALE_ISO3` TINYINT(4) NULL DEFAULT NULL ,
  `CURRENCY_CODE_ISO3` TINYINT(4) NULL DEFAULT NULL ,
  `CREATED_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_APP` TINYINT(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`ACCOUNT_ID`) ,
  UNIQUE INDEX `EMAIL_ADDR_UNIQUE` (`EMAIL_ADDR` ASC) ,
  INDEX `fk_ACCOUNT_ADDRESS1_idx` (`REGISTRATION_ADDR_ID` ASC) ,
  INDEX `fk_ACCOUNT_ADDRESS2_idx` (`BILLING_ADDR_ID` ASC) ,
  CONSTRAINT `fk_ACCOUNT_ADDRESS1`
    FOREIGN KEY (`REGISTRATION_ADDR_ID` )
    REFERENCES `accountdb`.`address` (`ADDRESS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACCOUNT_ADDRESS2`
    FOREIGN KEY (`BILLING_ADDR_ID` )
    REFERENCES `accountdb`.`address` (`ADDRESS_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accountdb`.`discount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accountdb`.`discount` ;

CREATE  TABLE IF NOT EXISTS `accountdb`.`discount` (
  `DISCOUNT_ID` INT(11) NOT NULL ,
  `DISCOUNT_NAME` VARCHAR(128) NULL DEFAULT NULL ,
  `STATUS` TINYINT(4) NULL DEFAULT NULL ,
  `DISCOUNT_PERCENT` DECIMAL(5,2) NULL DEFAULT NULL ,
  `DISCOUNT_AMOUNT` DECIMAL(18,4) NULL DEFAULT NULL ,
  `LAST_MODIFIED_APP` TINYINT(4) NULL DEFAULT NULL ,
  `CREATED_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`DISCOUNT_ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accountdb`.`account_discount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accountdb`.`account_discount` ;

CREATE  TABLE IF NOT EXISTS `accountdb`.`account_discount` (
  `ACCOUNT_DISCOUNT_ID` BIGINT(20) NOT NULL ,
  `ACCOUNT_ID` BIGINT(20) NULL DEFAULT NULL ,
  `DISCOUNT_ID` INT(11) NULL DEFAULT NULL ,
  `DISCOUNT_START_DATE` DATETIME NULL DEFAULT NULL ,
  `DISCOUNT_END_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL DEFAULT NULL ,
  `CREATED_DATE` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`ACCOUNT_DISCOUNT_ID`) ,
  INDEX `fk_ACCOUNT_DISCOUNT_ACCOUNT1_idx` (`ACCOUNT_ID` ASC) ,
  INDEX `fk_ACCOUNT_DISCOUNT_DISCOUNT1_idx` (`DISCOUNT_ID` ASC) ,
  CONSTRAINT `fk_ACCOUNT_DISCOUNT_ACCOUNT1`
    FOREIGN KEY (`ACCOUNT_ID` )
    REFERENCES `accountdb`.`account` (`ACCOUNT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACCOUNT_DISCOUNT_DISCOUNT1`
    FOREIGN KEY (`DISCOUNT_ID` )
    REFERENCES `accountdb`.`discount` (`DISCOUNT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accountdb`.`subscription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accountdb`.`subscription` ;

CREATE  TABLE IF NOT EXISTS `accountdb`.`subscription` (
  `SUBSCRIPTION_ID` INT(11) NOT NULL ,
  `NAME` VARCHAR(128) NULL DEFAULT NULL ,
  `STATUS` TINYINT(4) NULL DEFAULT NULL ,
  `FEE` DECIMAL(18,4) NULL DEFAULT NULL ,
  `SUBSCRIPTION_TYPE` TINYINT(4) NULL DEFAULT NULL COMMENT 'SUBSCRIPTION_TYPE is for MOnthy/Yearly subscription' ,
  `START_DATE` DATETIME NULL DEFAULT NULL ,
  `END_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_DATE` DATETIME NULL DEFAULT NULL ,
  `LAST_MODIFIED_APP` TINYINT(4) NULL DEFAULT NULL ,
  `CREATED_DATE` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`SUBSCRIPTION_ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accountdb`.`account_subscription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accountdb`.`account_subscription` ;

CREATE  TABLE IF NOT EXISTS `accountdb`.`account_subscription` (
  `ACCOUNT_SUBSCRIPTION_ID` BIGINT(20) NOT NULL ,
  `ACCOUNT_ID` BIGINT(20) NOT NULL ,
  `SUBSCRIPTION_ID` INT(11) NULL DEFAULT NULL ,
  `SUBSCRIPTION_TYPE` DECIMAL(4,0) NULL DEFAULT NULL COMMENT 'SUBSCRIPTION_TYPE is for MOnthy/Yearly subscription' ,
  `START_DATE` DATETIME NULL DEFAULT NULL ,
  `END_DATE` DATETIME NULL DEFAULT NULL ,
  `MODIFY_DATE` DATETIME NULL DEFAULT NULL ,
  `CHANGE_WHO` VARCHAR(45) NULL DEFAULT NULL ,
  `CREATE_DATE` DATETIME NULL DEFAULT NULL ,
  `DISCOUNT_ID` INT(11) NOT NULL ,
  PRIMARY KEY (`ACCOUNT_SUBSCRIPTION_ID`) ,
  INDEX `fk_ACCOUNT_SUBSCRIPTION_SUBSCRIPTION_DETAIL1_idx` (`SUBSCRIPTION_ID` ASC) ,
  INDEX `fk_ACCOUNT_SUBSCRIPTION_ACCOUNT1_idx` (`ACCOUNT_ID` ASC) ,
  CONSTRAINT `fk_ACCOUNT_SUBSCRIPTION_SUBSCRIPTION_DETAIL1`
    FOREIGN KEY (`SUBSCRIPTION_ID` )
    REFERENCES `accountdb`.`subscription` (`SUBSCRIPTION_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACCOUNT_SUBSCRIPTION_ACCOUNT1`
    FOREIGN KEY (`ACCOUNT_ID` )
    REFERENCES `accountdb`.`account` (`ACCOUNT_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `accountdb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
