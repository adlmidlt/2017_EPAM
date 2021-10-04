-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_shop_smoke
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_shop_smoke
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_shop_smoke` DEFAULT CHARACTER SET utf8 ;
USE `db_shop_smoke` ;

-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `name_role` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(15) NOT NULL,
  `first_name` VARCHAR(15) NOT NULL,
  `login` VARCHAR(10) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`User_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`User_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `fk_Users_has_Roles_Roles1_idx` (`role_id` ASC) VISIBLE,
  INDEX `fk_Users_has_Roles_Users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_Roles_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_shop_smoke`.`Users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Roles_Roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `db_shop_smoke`.`Roles` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Basket` (
  `id_basket` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(150) NULL,
  `price` INT(10) NOT NULL,
  PRIMARY KEY (`id_basket`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`User_basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`User_basket` (
  `user_id` INT NOT NULL,
  `basket_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `basket_id`),
  INDEX `fk_Users_has_Basket_Basket1_idx` (`basket_id` ASC) VISIBLE,
  INDEX `fk_Users_has_Basket_Users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_Basket_Users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_shop_smoke`.`Users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Basket_Basket1`
    FOREIGN KEY (`basket_id`)
    REFERENCES `db_shop_smoke`.`Basket` (`id_basket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Manufacturers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Manufacturers` (
  `id_manufacturer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_manufacturer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Products` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `description` VARCHAR(150) NULL,
  `price` INT(10) NOT NULL,
  `manufacturer_id` INT NOT NULL,
  `date_devilry` DATE NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `fk_Products_Manufacturers1_idx` (`manufacturer_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Manufacturers1`
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `db_shop_smoke`.`Manufacturers` (`id_manufacturer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Product_basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Product_basket` (
  `product_id` INT NOT NULL,
  `basket_id` INT NOT NULL,
  PRIMARY KEY (`product_id`, `basket_id`),
  INDEX `fk_Products_has_Basket_Basket1_idx` (`basket_id` ASC) VISIBLE,
  INDEX `fk_Products_has_Basket_Products1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_has_Basket_Products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `db_shop_smoke`.`Products` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Products_has_Basket_Basket1`
    FOREIGN KEY (`basket_id`)
    REFERENCES `db_shop_smoke`.`Basket` (`id_basket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Categories` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_shop_smoke`.`Categorie_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_shop_smoke`.`Categorie_product` (
  `category_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `product_id`),
  INDEX `fk_Categories_has_Products_Products1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_Categories_has_Products_Categories1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_Categories_has_Products_Categories1`
    FOREIGN KEY (`category_id`)
    REFERENCES `db_shop_smoke`.`Categories` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Categories_has_Products_Products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `db_shop_smoke`.`Products` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
