# Работает с таблицей категорий
# Вывести данные таблицы
SELECT * FROM db_shop_smoke.categories;

# Вставляем данные
insert into	categories(name) values ("Табак"), ("Кальян");

# Удаляем данные по идентификатору
delete from categories where id_category=2;

# Вывести данные без повторений по имени
select distinct categories.name from categories;

# Обновить данные изменяя идентификатор
update categories set categories.id_category = 4 where categories.id_category = 7;