-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shop_smoke
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shop_smoke
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shop_smoke` DEFAULT CHARACTER SET utf8 ;
USE `shop_smoke` ;

-- -----------------------------------------------------
-- Table `shop_smoke`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`role` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(20) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`role_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`role_user` (
  `role_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`),
  INDEX `fk_role_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_role_has_user_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_has_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `shop_smoke`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `shop_smoke`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`manufacturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`manufacturer` (
  `id_manufacturer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_manufacturer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `price` INT(6) NOT NULL,
  `date_devilery` DATE NOT NULL,
  `manufacturer_id` INT NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `fk_product_manufacturer1_idx` (`manufacturer_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_manufacturer1`
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `shop_smoke`.`manufacturer` (`id_manufacturer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`category_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`category_product` (
  `category_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `product_id`),
  INDEX `fk_category_has_product_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_category_has_product_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_category_has_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `shop_smoke`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shop_smoke`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`basket` (
  `id_basket` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id_basket`),
  INDEX `fk_basket_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_basket_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `shop_smoke`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shop_smoke`.`basket_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_smoke`.`basket_product` (
  `basket_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`basket_id`, `product_id`),
  INDEX `fk_basket_has_product_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_basket_has_product_basket1_idx` (`basket_id` ASC) VISIBLE,
  CONSTRAINT `fk_basket_has_product_basket1`
    FOREIGN KEY (`basket_id`)
    REFERENCES `shop_smoke`.`basket` (`id_basket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_basket_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shop_smoke`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
