# Работает с таблицей производителей
# Вывести данные таблицы
SELECT * FROM db_shop_smoke.manufacturers;

# Вставляем данные
insert into	manufacturers(name) values ("Дарк Сайд"), ("Ами Делюкс");

# Удаляем данные по идентификатору
delete from manufacturers where manufacturers.id_manufacturer=2;

# Вывести данные без повторений по имени
select distinct manufacturers.name from manufacturers;

# Обновить данные изменяя идентификатор
update manufacturers set manufacturers.id_manufacturer = 4 where manufacturers.id_manufacturer = 7;
