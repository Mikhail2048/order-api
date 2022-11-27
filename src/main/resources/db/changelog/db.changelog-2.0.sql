--liquibase formatted sql


--changeset dmatveyenka:1
CREATE TABLE IF NOT EXISTS orders_product
(
    orders_id BIGINT NOT NULL REFERENCES orders (id),
    product_id BIGINT NOT NULL REFERENCES product (id),
    PRIMARY KEY(orders_id, product_id)

);