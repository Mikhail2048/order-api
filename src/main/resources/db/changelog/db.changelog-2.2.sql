--liquibase formatted sql

--changeset zig199:1
INSERT INTO product (name_product, price, is_available, description, images)
VALUES ('Mercedes-Benz', 230000, false, 'Автомобиль премиум', 'url файла');

INSERT INTO product (name_product, price, is_available, description, images)
VALUES ('Туфли', 3000, true, 'Обувь для женщин', 'url файла');

INSERT INTO product (name_product, price, is_available, description, images)
VALUES ('Салфетки', 30, true, 'Для кухни', 'url файла');

INSERT INTO product (name_product, price, is_available, description, images)
VALUES ('Ferrari', 3000000, false, 'Спорткар премиум', 'url файла');

INSERT INTO product (name_product, price, is_available, description, images)
VALUES ('Носки', 10, false, 'Раздел к обуви', 'url файла');