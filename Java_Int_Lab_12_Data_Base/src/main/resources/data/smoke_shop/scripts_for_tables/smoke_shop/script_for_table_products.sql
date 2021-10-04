# Работает с таблицей продукты
# Вывести данные таблицы
SELECT * FROM db_shop_smoke.products;

# Вставляем данные в таблицу продукты связываю с производителей
insert into products(name, description, price, manufacturer_id, date_devilry) values ("Блэк Дарт", "Сделан в Германии", 1500, 2, "2019.01.10");

# Удаляем данные по идентификатору
delete from products where products.id_product=1;

# Обновить данные изменяя идентификатор
update products set name="Еврошиша С6", price=2500, manufacturer_id=1, date_devilry="2019-01-01" where products.id_product=1;