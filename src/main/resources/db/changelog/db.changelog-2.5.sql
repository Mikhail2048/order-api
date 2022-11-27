--liquibase formatted sql

--changeset zig199:1
INSERT INTO orders_product (orders_id, product_id)
VALUES (4, 2);

INSERT INTO orders_product (orders_id, product_id)
VALUES (4, 3);

INSERT INTO orders_product (orders_id, product_id)
VALUES (4, 5);

INSERT INTO orders_product (orders_id, product_id)
VALUES (1, 1);
