INSERT INTO `shop_smoke`.`role` (`name_role`) VALUES ('ADMIN');
INSERT INTO `shop_smoke`.`role` (`name_role`) VALUES ('USER');

INSERT INTO `shop_smoke`.`user` (`last_name`, `first_name`, `login`, `password`) VALUES ('Ларионов', 'Анатолий', 'admin1', 'admin1');
INSERT INTO `shop_smoke`.`user` (`last_name`, `first_name`, `login`, `password`) VALUES ('Иванов', 'Иван', 'user1', 'user1');

INSERT INTO `shop_smoke`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `shop_smoke`.`user_role` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `shop_smoke`.`category` (`name`) VALUES ('Кальян');
INSERT INTO `shop_smoke`.`category` (`name`) VALUES ('Табак');

INSERT INTO `shop_smoke`.`manufacturer` (`name`) VALUES ('Германия');
INSERT INTO `shop_smoke`.`manufacturer` (`name`) VALUES ('Франция');
INSERT INTO `shop_smoke`.`manufacturer` (`name`) VALUES ('Россия');
INSERT INTO `shop_smoke`.`manufacturer` (`name`) VALUES ('Индия');

INSERT INTO `shop_smoke`.`product` (`name`, `description`, `price`, `manufacturer_id`, `category_id`) VALUES ('Блек', 'Ами', '4700', '1', '1');
INSERT INTO `shop_smoke`.`product` (`name`, `description`, `price`, `manufacturer_id`, `category_id`) VALUES ('Голд', 'Дарк', '6400', '2', '1');
INSERT INTO `shop_smoke`.`product` (`name`, `description`, `price`, `manufacturer_id`, `category_id`) VALUES ('Адалия', 'Груша', '150', '3', '2');
INSERT INTO `shop_smoke`.`product` (`name`, `description`, `price`, `manufacturer_id`, `category_id`) VALUES ('Щербетли', 'Дыня Лёд', '150', '4', '2');

