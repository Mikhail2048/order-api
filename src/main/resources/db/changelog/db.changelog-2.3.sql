--liquibase formatted sql

--changeset zig199:1
INSERT INTO orders (users_id, order_status, arriving_location, is_payed)
VALUES (1, 'REGISTERED', 'Moscow', false);

INSERT INTO orders (users_id, order_status, arriving_location, is_payed)
VALUES (2, 'ASSIGNED', 'Piter', true);

INSERT INTO orders (users_id, order_status, arriving_location, is_payed)
VALUES (3, 'ON_THE_WAY', 'Glazov', true);

INSERT INTO orders (users_id, order_status, arriving_location, is_payed)
VALUES (4, 'DELIVERED', 'Izhevsk', true);
